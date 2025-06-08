import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VendasVIEW extends JFrame {
    private JTable listaProdutosVendidos;
    private JScrollPane jScrollPane1;
    private JLabel jLabel1;
    private JButton btnVoltar;

    public VendasVIEW() {
        setTitle("Vendas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela
        setLayout(new BorderLayout());

        // Inicializa componentes
        jLabel1 = new JLabel("Produtos Vendidos");
        btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        // Define a tabela com colunas
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID", "Produto", "Quantidade", "Preço"}, 0
        );
        listaProdutosVendidos = new JTable(model);
        jScrollPane1 = new JScrollPane(listaProdutosVendidos);

        // Painel superior com título
        JPanel topo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topo.add(jLabel1);

        // Painel inferior com botão
        JPanel rodape = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rodape.add(btnVoltar);

        // Adiciona tudo ao frame
        add(topo, BorderLayout.NORTH);
        add(jScrollPane1, BorderLayout.CENTER);
        add(rodape, BorderLayout.SOUTH);

        // Carrega os dados
        carregarProdutosVendidos();
    }

    private void carregarProdutosVendidos() {
        System.out.println("Método carregarProdutosVendidos() chamado!");

        try {
            DefaultTableModel model = (DefaultTableModel) listaProdutosVendidos.getModel();
            System.out.println("Modelo da tabela obtido: " + model);

            // Adiciona uma linha de exemplo
            model.addRow(new Object[]{"1", "Produto Teste", "1", "R$ 10,00"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void btnVoltarActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VendasVIEW().setVisible(true);
        });
    }
}
