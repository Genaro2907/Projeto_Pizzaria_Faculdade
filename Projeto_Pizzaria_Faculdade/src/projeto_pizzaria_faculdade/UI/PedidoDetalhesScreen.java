/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projeto_pizzaria_faculdade.UI;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projeto_pizzaria_faculdade.Util.Cliente;
import projeto_pizzaria_faculdade.Util.ItemPedido;
import projeto_pizzaria_faculdade.Util.Pedido;
import projeto_pizzaria_faculdade.Util.items.Bebida;
import projeto_pizzaria_faculdade.Util.items.Pizza;
import projeto_pizzaria_faculdade.Util.items.StatusPedido;

/**
 *
 * @author Gabriel
 */
public class PedidoDetalhesScreen extends javax.swing.JFrame {
    
    private Pedido pedidoAtual;
    
    public PedidoDetalhesScreen(Pedido pedido) {
        this.pedidoAtual = pedido;
        initComponents();
        this.setLocationRelativeTo(null);
    for (StatusPedido status : StatusPedido.values()) {
        cmbStatus.addItem(status.toString());
    }
    

    cmbStatus.setSelectedItem(pedidoAtual.getStatus().toString());
        exibirdadosPedido();
     
     if (pedidoAtual.getStatus() == null) {
        pedidoAtual.setStatus(StatusPedido.EM_ABERTO); 
    }
        
    }
    private void exibirdadosPedido() {
    if (pedidoAtual.getCliente() == null) {
    JOptionPane.showMessageDialog(this, "Cliente não vinculado ao pedido!");
        return;
    }
    txtNome.setText(pedidoAtual.getCliente().getNomeCliente());
    txtEndereco.setText(pedidoAtual.getCliente().getEnderecoCliente());
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    txtDataHora.setText(pedidoAtual.getDataHora().format(formatter));
    
    
    DefaultTableModel model = (DefaultTableModel) tblItens.getModel();
    model.setRowCount(0);
    
    for (ItemPedido item : pedidoAtual.getItens()) {
        if (item instanceof Pizza pizza) {
            model.addRow(new Object[]{
                "Pizza",
                pizza.getNome() + " (" + pizza.getTamanho() + ") - " + 
                String.join(", ", pizza.getIngredientesExtras()),
                String.format("R$ %.2f", pizza.getPreco())
            });
        } else if (item instanceof Bebida bebida) {
            model.addRow(new Object[]{
                "Bebida",
                bebida.getMarca() + " - " + bebida.getTamanho().getMl() + "ml" +
                (bebida.isComGelo() ? " (Com Gelo)" : " (Sem Gelo)"),
               String.format("R$ %.2f", bebida.getPreco())
            });
        }
    } 
    lblTotal.setText(String.format("Total: R$ %.2f", pedidoAtual.getTotal()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtDataHora = new javax.swing.JFormattedTextField();
        cmbStatus = new javax.swing.JComboBox<>();
        btnAtualizarStatus = new javax.swing.JButton();
        btnNovoPedido = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome: ");

        jLabel2.setText("Endereço:");

        jLabel3.setText("Data/Hora:");

        jLabel4.setText("Status: ");

        jLabel5.setText("Itens: ");

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo", "Produto", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tblItens);
        if (tblItens.getColumnModel().getColumnCount() > 0) {
            tblItens.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblItens.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblItens.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        txtNome.setEnabled(false);

        txtEndereco.setEnabled(false);

        txtDataHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm"))));
        txtDataHora.setEnabled(false);

        btnAtualizarStatus.setText("Atualizar Status");
        btnAtualizarStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarStatusActionPerformed(evt);
            }
        });

        btnNovoPedido.setText("Novo Pedido");
        btnNovoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPedidoActionPerformed(evt);
            }
        });

        lblTotal.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(25, 25, 25)
                            .addComponent(txtNome))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                                    .addComponent(btnAtualizarStatus))
                                .addComponent(txtDataHora)
                                .addComponent(txtEndereco))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNovoPedido)
                                .addGap(41, 41, 41))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizarStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 125, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoPedido)
                    .addComponent(lblTotal))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarStatusActionPerformed
        try {
            String statusSelecionado = (String) cmbStatus.getSelectedItem();
            StatusPedido novoStatus = StatusPedido.fromString(statusSelecionado);
            
            if (novoStatus != null) {
                pedidoAtual.setStatus(novoStatus);
                JOptionPane.showMessageDialog(this, 
                    "Status atualizado para: " + novoStatus.toString(),
                    "Sucesso", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Status inválido selecionado!", 
                    "Erro", 
                    JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao atualizar status: " + e.getMessage(), 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAtualizarStatusActionPerformed

    private void btnNovoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPedidoActionPerformed
    int resposta = JOptionPane.showConfirmDialog(
        this, 
        "Deseja iniciar um novo pedido?",
        "Confirmação",
        JOptionPane.YES_NO_OPTION
    );
    
    if (resposta == JOptionPane.YES_OPTION) {
        this.dispose();
        new PedidoScreen().setVisible(true);
    }
    }//GEN-LAST:event_btnNovoPedidoActionPerformed
    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> {
        Cliente clienteTeste = new Cliente("Cliente Exemplo", "Rua Teste, 123");
        Pedido pedidoTeste = new Pedido(clienteTeste);
        
        pedidoTeste.adicionarItem(Pizza.criarMargherita("M", List.of("Queijo Extra"), true));
        new PedidoDetalhesScreen(pedidoTeste).setVisible(true);
    });
}
    /**
     * @param args the command line arguments
     */
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarStatus;
    private javax.swing.JButton btnNovoPedido;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblItens;
    private javax.swing.JFormattedTextField txtDataHora;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
