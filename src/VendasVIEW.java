import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class VendasVIEW extends javax.swing.JFrame {
    // Variáveis de componentes
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaProdutosVendidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton btnVoltar;

    public VendasVIEW() {
        listaProdutosVendidos = new JTable();
        setTitle("Vendas");
        setSize(800, 600);
        carregarProdutosVendidos();
    }

    private void carregarProdutosVendidos() {
        if (listaProdutosVendidos == null) {
        listaProdutosVendidos = new JTable(); // Inicializa se estiver nulo
    }
    
    try {
        DefaultTableModel model = (DefaultTableModel) listaProdutosVendidos.getModel();
        model.setRowCount(0); // Limpa a tabela
        
        // Adicione seus dados aqui (exemplo)
        Object[] row = {"1", "Produto A", "2", "R$ 50,00"};
        model.addRow(row);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
    }
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendasVIEW().setVisible(true);
            }
        });
    }
}