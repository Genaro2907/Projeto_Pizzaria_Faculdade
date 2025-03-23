/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projeto_pizzaria_faculdade.UI;

import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import projeto_pizzaria_faculdade.Util.Cliente;
import projeto_pizzaria_faculdade.Util.ItemPedido;
import projeto_pizzaria_faculdade.Util.Pedido;
import projeto_pizzaria_faculdade.Util.items.Bebida;
import projeto_pizzaria_faculdade.Util.items.Pizza;

/**
 *
 * @author Gabriel
 */
public class PedidoScreen extends javax.swing.JFrame {
    private Cliente clienteAtual;
    private Pedido pedidoAtual;
    /**
     * Creates new form PedidoScreen
     */
    public PedidoScreen() {
        initComponents();
        pedidoAtual = new Pedido();
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnAddBebida = new javax.swing.JButton();
        btnAddPizza = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pizzaria ");
        setSize(new java.awt.Dimension(800, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));
        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        jLabel1.setText("Nome");
        jPanel1.add(jLabel1);
        jPanel1.add(txtNome);

        jLabel2.setText("Endereço");
        jPanel1.add(jLabel2);
        jPanel1.add(txtEndereco);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens do Pedido"));

        btnAddBebida.setText("Adicionar Bebida");
        btnAddBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBebidaActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddBebida);

        btnAddPizza.setText("Adicionar Pizza");
        btnAddPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPizzaActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddPizza);

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item", "Descrição", "Preço"
            }
        ));
        jScrollPane2.setViewportView(tblItens);

        jScrollPane1.setViewportView(jScrollPane2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.BorderLayout());

        lblTotal.setText("Total: R$ 0,00");
        jPanel4.add(lblTotal, java.awt.BorderLayout.CENTER);

        btnFinalizar.setText("Finalizar Pedido");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        jPanel4.add(btnFinalizar, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel4, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void atualizarTabelaItens() {
    DefaultTableModel model = (DefaultTableModel) tblItens.getModel();
    model.setRowCount(0); // Limpa a tabela

    for (ItemPedido item : pedidoAtual.getItens()) {
        if (item instanceof Pizza) {
            Pizza pizza = (Pizza) item;
            model.addRow(new Object[]{
                "Pizza",
                pizza.getNome() + " (" + pizza.getTamanho() + ") - " + 
                String.join(", ", pizza.getIngredientesExtras()),
                "R$ " + pizza.getPreco()
            });
        }else if (item instanceof Bebida) {
            Bebida bebida = (Bebida) item;
            model.addRow(new Object[]{
                "Bebida",
                bebida.getMarca() + " - " + bebida.getTamanho().getMl() + "ml" +
                (bebida.isComGelo() ? " (Com Gelo)" : " (Sem Gelo)"),
                "R$ " + bebida.getPreco()
            });
        }
    }

    lblTotal.setText(String.format("Total: R$ %.2f", pedidoAtual.getTotal()));
} 
    private void btnAddPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPizzaActionPerformed
    JDialog dialog = new JDialog(this, "Selecionar Pizza", true);
    dialog.setLayout(new GridLayout(0, 2, 10, 10));

    // Componentes
    JComboBox<String> cmbSabor = new JComboBox<>(new String[]{
        Pizza.MARGHERITA, 
        Pizza.CALABRESA, 
        Pizza.PORTUGUESA
    });
    JComboBox<String> cmbTamanho = new JComboBox<>(new String[]{"P", "M", "G"});
    JList<String> lstExtras = new JList<>(new String[]{"Queijo Extra", "Bacon", "Cebola"});
    JButton btnConfirmar = new JButton("Adicionar");

    btnConfirmar.addActionListener(e -> {
        String sabor = (String) cmbSabor.getSelectedItem();
        String tamanho = (String) cmbTamanho.getSelectedItem();
        List<String> extras = lstExtras.getSelectedValuesList();

        Pizza pizza = switch(sabor) {
            case Pizza.MARGHERITA -> Pizza.criarMargherita(tamanho, extras);
            case Pizza.CALABRESA -> Pizza.criarCalabresa(tamanho, extras);
            case Pizza.PORTUGUESA -> Pizza.criarPortuguesa(tamanho, extras);
            default -> throw new IllegalArgumentException("Sabor inválido");
        };

        pedidoAtual.adicionarItem(pizza);
        atualizarTabelaItens();
        dialog.dispose();
    });

    // Layout do diálogo
    dialog.add(new JLabel("Sabor:"));
    dialog.add(cmbSabor);
    dialog.add(new JLabel("Tamanho:"));
    dialog.add(cmbTamanho);
    dialog.add(new JLabel("Extras:"));
    dialog.add(new JScrollPane(lstExtras));
    dialog.add(btnConfirmar);

    dialog.pack();
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
    }//GEN-LAST:event_btnAddPizzaActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        
        String nome = txtNome.getText().trim();
    String endereco = txtEndereco.getText().trim();
    
    if (nome.isEmpty() || endereco.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha nome e endereço!");
        return;
    }
    
    clienteAtual = new Cliente(nome, endereco);
    pedidoAtual.setCliente(clienteAtual); // Adicione este método na classe Pedido
    
    JOptionPane.showMessageDialog(this, 
        "Pedido finalizado!\n" + 
        "Cliente: " + clienteAtual.getNomeCliente() + "\n" +
        "Total: R$ " + pedidoAtual.calcularTotal()
    );
    
    // Reiniciar para novo pedido
    pedidoAtual = new Pedido();
    txtNome.setText("");
    txtEndereco.setText("");
    atualizarTabelaItens();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnAddBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBebidaActionPerformed
       JDialog dialog = new JDialog(this, "Adicionar Bebida", true);
    dialog.setLayout(new GridLayout(0, 2, 10, 10));

    // Componentes
    JComboBox<String> cmbTipo = new JComboBox<>(new String[]{
        Bebida.COCA_COLA, 
        Bebida.GUARANA, 
        Bebida.AGUA_MINERAL
    });
    JComboBox<Bebida.Tamanho> cmbTamanho = new JComboBox<>(Bebida.Tamanho.values());
    JCheckBox chkGelo = new JCheckBox("Com Gelo");
    JButton btnConfirmar = new JButton("Adicionar");

    btnConfirmar.addActionListener(e -> {
        String tipo = (String) cmbTipo.getSelectedItem();
        Bebida.Tamanho tamanho = (Bebida.Tamanho) cmbTamanho.getSelectedItem();
        boolean comGelo = chkGelo.isSelected();

        Bebida bebida = switch(tipo) {
            case Bebida.COCA_COLA -> Bebida.criarCocaCola(tamanho, comGelo);
            case Bebida.GUARANA -> Bebida.criarGuarana(tamanho, comGelo);
            case Bebida.AGUA_MINERAL -> Bebida.criarAguaMineral(tamanho, comGelo);
            default -> throw new IllegalArgumentException("Tipo inválido");
        };

        pedidoAtual.adicionarItem(bebida);
        atualizarTabelaItens();
        dialog.dispose();
    });

    // Layout do diálogo
    dialog.add(new JLabel("Tipo:"));
    dialog.add(cmbTipo);
    dialog.add(new JLabel("Tamanho:"));
    dialog.add(cmbTamanho);
    dialog.add(new JLabel("Gelo:"));
    dialog.add(chkGelo);
    dialog.add(btnConfirmar);

    dialog.pack();
    dialog.setLocationRelativeTo(this);
    dialog.setVisible(true);
    }//GEN-LAST:event_btnAddBebidaActionPerformed
   
    private void atualizarTotal() {
    double total = 0;
    for(int i = 0; i < tblItens.getRowCount(); i++) {
        String precoStr = tblItens.getValueAt(i, 2).toString().replace("R$ ", "");
        total += Double.parseDouble(precoStr);
    }
    lblTotal.setText(String.format("Total: R$ %.3f", pedidoAtual.getTotal()));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PedidoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedidoScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBebida;
    private javax.swing.JButton btnAddPizza;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblItens;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
