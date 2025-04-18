/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import controller.LivroController;
import controller.VendaController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Livro;
import model.Venda;

/**
 *
 * @author gusta
 */
public class FrAltVenda extends javax.swing.JDialog {

    private int idVenda; // variável para armazenar o ID da venda

    /**
     * Creates new form FrAltVenda
     */
    public FrAltVenda(java.awt.Frame parent, boolean modal, int idVenda) {
        super(parent, modal);
        this.idVenda = idVenda;
        initComponents();
        carregarVenda();  // Carregar os dados da venda ao abrir a tela
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
        lbQuantidade = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        edtQuantidade = new javax.swing.JTextField();
        edtIdCliente = new javax.swing.JTextField();
        lbIdCliente1 = new javax.swing.JLabel();
        edtData = new javax.swing.JTextField();
        edtIdLivro = new javax.swing.JTextField();
        lbLivro = new javax.swing.JLabel();
        btmSalvar = new javax.swing.JButton();
        btmCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbQuantidade.setText("Quantidade");
        jPanel1.add(lbQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        lbData.setText("Data");
        jPanel1.add(lbData, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));
        jPanel1.add(edtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 92, -1));
        jPanel1.add(edtIdCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 92, -1));

        lbIdCliente1.setText("ID Cliente");
        jPanel1.add(lbIdCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));
        jPanel1.add(edtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 92, -1));
        jPanel1.add(edtIdLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 92, -1));

        lbLivro.setText("Livro");
        jPanel1.add(lbLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, -1));

        btmSalvar.setText("Salvar");
        btmSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btmSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        btmCancelar.setText("Cancelar");
        btmCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btmCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btmSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmSalvarActionPerformed
        salvarVenda();

    }//GEN-LAST:event_btmSalvarActionPerformed

    private void btmCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmCancelarActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btmCancelarActionPerformed

    private void carregarVenda() {
        VendaController controller = new VendaController();
        ArrayList<Venda> vendas = controller.listarTodos();

        for (Venda v : vendas) {
            // Verifica se a venda encontrada corresponde ao ID da venda fornecido
            if (v.getId() == idVenda) {
                // Debug para verificar se estamos obtendo os dados corretamente

                // Verifica se o cliente da venda tem o ID correto
                // Aqui deve ser preenchido apenas o ID do cliente
                edtIdCliente.setText(String.valueOf(v.getIdCliente()));  // Exibe o ID do cliente no campo

                // Continuando o preenchimento dos outros campos
// ...
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                edtData.setText(v.getDataVenda().format(formatter));

                StringBuilder idsLivros = new StringBuilder();
                StringBuilder quantidades = new StringBuilder();

                for (Map.Entry<Livro, Integer> entry : v.getLivrosVendidos().entrySet()) {
                    idsLivros.append(entry.getKey().getId()).append(",");
                    quantidades.append(entry.getValue()).append(",");
                }

                // Remover a última vírgula, se houver
                if (idsLivros.length() > 0) {
                    idsLivros.setLength(idsLivros.length() - 1);
                }
                if (quantidades.length() > 0) {
                    quantidades.setLength(quantidades.length() - 1);
                }

                edtIdLivro.setText(idsLivros.toString());
                edtQuantidade.setText(quantidades.toString());

                break;  // Encerra o loop após encontrar a venda correspondente
            }
        }
    }

    // Método para salvar ou atualizar os dados da venda
    private void salvarVenda() {
        try {
            // Obter o ID do Cliente e validar
            int idCliente = Integer.parseInt(edtIdCliente.getText().trim());
            ClienteController clienteController = new ClienteController();
            Cliente cliente = clienteController.buscarPorId(idCliente);
            if (cliente == null) {
                JOptionPane.showMessageDialog(this, "Cliente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obter e validar a data da venda
            String dataStr = edtData.getText().trim();
            LocalDate dataVenda;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataVenda = LocalDate.parse(dataStr, formatter);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Formato de data inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obter os livros vendidos e suas quantidades
            String[] idsLivros = edtIdLivro.getText().split(",");
            String[] quantidades = edtQuantidade.getText().split(",");

            // Verificar se o número de IDs de livros e quantidades é o mesmo
            if (idsLivros.length != quantidades.length) {
                JOptionPane.showMessageDialog(this, "O número de livros e quantidades não coincide.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Map<Livro, Integer> livrosVendidos = new HashMap<>();
            LivroController livroController = new LivroController();

            for (int i = 0; i < idsLivros.length; i++) {
                try {
                    int idLivro = Integer.parseInt(idsLivros[i].trim());
                    int quantidade = Integer.parseInt(quantidades[i].trim());

                    Livro livro = livroController.buscarPorId(idLivro);
                    if (livro != null) {
                        livrosVendidos.put(livro, quantidade);
                    } else {
                        JOptionPane.showMessageDialog(this, "Livro com ID " + idLivro + " não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Formato inválido para ID de livro ou quantidade.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            // Verificar se a venda tem pelo menos um livro
            if (livrosVendidos.isEmpty()) {
                JOptionPane.showMessageDialog(this, "A venda deve ter ao menos um livro.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Criar e salvar a venda
            Venda venda = new Venda(idVenda, cliente, livrosVendidos, dataVenda);
            VendaController vendaController = new VendaController();
            vendaController.alterarVenda(venda);

            JOptionPane.showMessageDialog(this, "Venda atualizada com sucesso.");
            dispose();  // Fechar a tela de alteração
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar a venda: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

// Método fictício para buscar cliente pelo ID
    private Cliente buscarClientePorId(int id) {
        // Lógica para buscar o cliente pelo ID, pode ser feito via controlador ou banco de dados
        // Exemplo de implementação fictícia:
        ClienteController clienteController = new ClienteController();
        return clienteController.buscarPorId(id);
    }

    // Método fictício para buscar livro por título
    private Livro buscarLivroPorTitulo(String titulo) {
        // Lógica de busca pelo título (pode ser feito via controlador ou diretamente no banco)
        // Este é apenas um exemplo
        return new Livro();  // Retorna um novo livro, a lógica de busca precisa ser implementada
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrAltVenda dialog = new FrAltVenda(new javax.swing.JFrame(), true, 1); // Exemplo com ID de venda 1
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmCancelar;
    private javax.swing.JButton btmSalvar;
    private javax.swing.JTextField edtData;
    private javax.swing.JTextField edtIdCliente;
    private javax.swing.JTextField edtIdLivro;
    private javax.swing.JTextField edtQuantidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbIdCliente1;
    private javax.swing.JLabel lbLivro;
    private javax.swing.JLabel lbQuantidade;
    // End of variables declaration//GEN-END:variables
}
