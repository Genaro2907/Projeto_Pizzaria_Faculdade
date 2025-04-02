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
    

    /**
     * Creates new form PedidoDetalhesScreen
     */
    public PedidoDetalhesScreen(Pedido pedido) {
        this.pedidoAtual = pedido;
        initComponents();
         // Preenche o combobox com as descrições dos status
    for (StatusPedido status : StatusPedido.values()) {
        cmbStatus.addItem(status.toString());
    }
    
    // Seleciona o status atual do pedido
    cmbStatus.setSelectedItem(pedidoAtual.getStatus().toString());
        exibirdadosPedido();
        
    }
    private void exibirdadosPedido() {
    if (pedidoAtual.getCliente() == null) { // 👈 Verificação de segurança
    JOptionPane.showMessageDialog(this, "Cliente não vinculado ao pedido!");
        return;
    }
           // Dados do Cliente
    txtNome.setText(pedidoAtual.getCliente().getNomeCliente());
    txtEndereco.setText(pedidoAtual.getCliente().getEnderecoCliente());
    
    // Data/Hora formatada
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    txtDataHora.setText(pedidoAtual.getDataHora().format(formatter));
    
    
    // Tabela de Itens
    DefaultTableModel model = (DefaultTableModel) tblItens.getModel();
    model.setRowCount(0); // Limpa a tabela
    
    for (ItemPedido item : pedidoAtual.getItens()) {
        if (item instanceof Pizza pizza) {
            model.addRow(new Object[]{
                "Pizza",
                pizza.getNome() + " (" + pizza.getTamanho() + ") - " + 
                String.join(", ", pizza.getIngredientesExtras()),
                "R$ " + pizza.getPreco()
            });
        } else if (item instanceof Bebida bebida) {
            model.addRow(new Object[]{
                "Bebida",
                bebida.getMarca() + " - " + bebida.getTamanho().getMl() + "ml" +
                (bebida.isComGelo() ? " (Com Gelo)" : " (Sem Gelo)"),
                "R$ " + bebida.getPreco()
            });
        }
    } 
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataHora))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAtualizarStatus)
                                .addGap(14, 14, 14))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE)))
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
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
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
    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> {
        // Cria um pedido de teste
        Cliente clienteTeste = new Cliente("Cliente Exemplo", "Rua Teste, 123");
        Pedido pedidoTeste = new Pedido(clienteTeste);
        
        // Adiciona itens fictícios (opcional)
        pedidoTeste.adicionarItem(Pizza.criarMargherita("M", List.of("Queijo Extra")));
        
        // Abre a tela
        new PedidoDetalhesScreen(pedidoTeste).setVisible(true);
    });
}
    /**
     * @param args the command line arguments
     */
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarStatus;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblItens;
    private javax.swing.JFormattedTextField txtDataHora;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
