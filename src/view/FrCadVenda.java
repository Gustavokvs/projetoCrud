/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.VendaController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import model.Venda;
import model.Cliente;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.Livro;
import controller.ClienteController;
import controller.GerenciadorConexao;
import controller.LivroController;

/**
 *
 * @author thain
 */
public class FrCadVenda extends javax.swing.JDialog {

    private List<Livro> livrosComQuantidade = new ArrayList<>();

    /**
     * Creates new form FrCadVenda
     */
    public FrCadVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    VendaController controller = new VendaController();
    ClienteController cliente = new ClienteController();
    Venda venda = new Venda();
    Cliente cl = new Cliente();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblLivro = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        lblDataVenda = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        edtLivro = new javax.swing.JTextField();
        edtCliente = new javax.swing.JTextField();
        edtQuantidade = new javax.swing.JTextField();
        edtDataVenda = new javax.swing.JFormattedTextField();
        btnVoltar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setText("Dados de venda");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 27, -1, -1));

        lblLivro.setText("Livro");
        jPanel1.add(lblLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 71, -1, -1));

        lblCliente.setText("Cliente");
        jPanel1.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 134, -1, -1));

        lblDataVenda.setText("Data");
        jPanel1.add(lblDataVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        lblQuantidade.setText("Quantidade");
        jPanel1.add(lblQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 197, -1, -1));
        jPanel1.add(edtLivro, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 94, 116, -1));
        jPanel1.add(edtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 157, 63, -1));
        jPanel1.add(edtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 103, -1));

        edtDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jPanel1.add(edtDataVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 90, -1));

        btnVoltar.setText("Voltar");
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVoltarMouseClicked(evt);
            }
        });
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, -1, -1));

        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked
        if (verificarCampos()) {
            gravar();
        }
    }//GEN-LAST:event_btnSalvarMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed

    }//GEN-LAST:event_btnVoltarActionPerformed

    public void gravar() {

        // Criação de uma nova venda
        Venda venda = new Venda();

        // Buscar o cliente
        int idCliente = Integer.parseInt(edtCliente.getText());
        Cliente clienteBuscado = cliente.buscarPorId(idCliente);
        if (clienteBuscado == null) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            return;
        }
        venda.setCliente(clienteBuscado);

        // Pegando a data da venda
        String dataVendaStr = edtDataVenda.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dataVenda = sdf.parse(dataVendaStr);
            venda.setDataVenda(dataVenda);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro: A data fornecida é inválida. Use o formato dd/MM/yyyy.");
            return;
        }

        // Pegando os IDs dos livros e as quantidades
        String idsLivrosStr = edtLivro.getText();
        String quantidadesStr = edtQuantidade.getText();

        // Separando os IDs dos livros e as quantidades
        String[] idsLivros = idsLivrosStr.split(",");
        String[] quantidades = quantidadesStr.split(",");

        if (idsLivros.length != quantidades.length) {
            JOptionPane.showMessageDialog(null, "Erro: O número de IDs e quantidades não corresponde.");
            return;
        }

        // Lista de livros a serem associados à venda
        List<Livro> livrosDaVenda = new ArrayList<>();
        double valorTotal = 0;  // Inicializa o valor total

        for (int i = 0; i < idsLivros.length; i++) {
            try {
                int idLivro = Integer.parseInt(idsLivros[i].trim());
                int quantidade = Integer.parseInt(quantidades[i].trim());

                // Buscar o livro
                LivroController livroCtrl = new LivroController();
                Livro livroBuscado = livroCtrl.buscarPorId(idLivro);
                if (livroBuscado == null) {
                    JOptionPane.showMessageDialog(null, "Erro: Livro não encontrado.");
                    return;
                }

                // Calcular o valor total (quantidade * preço do livro)
                double valorLivro = livroBuscado.getPreco() * quantidade;
                valorTotal += valorLivro;

                // Adicionar o livro à venda
                livrosDaVenda.add(livroBuscado);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Erro: ID do livro ou quantidade inválidos.");
                return;
            }
        }

        // Definindo os livros na venda
        venda.setLivros(livrosDaVenda);

        // Definindo a quantidade total de livros vendidos (opcional)
        int quantidadeTotal = 0;
        for (int i = 0; i < quantidades.length; i++) {
            quantidadeTotal += Integer.parseInt(quantidades[i].trim());
        }
        venda.setQuantidade(quantidadeTotal);

        // Definindo o valor total da venda
        venda.setValorTotal(valorTotal);

        // Inserir a venda no banco de dados
        GerenciadorConexao conexao = new GerenciadorConexao();
        boolean sucesso = controller.inserir(venda, conexao);

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao registrar a venda.");
        }
    }

    public void limparCampos() {
        edtCliente.setText("");
        edtDataVenda.setText("");
        edtLivro.setText("");
        edtQuantidade.setText("");
        edtCliente.requestFocus(); // volta o cursor pro primeiro campo
    }

    public boolean verificarCampos() {

        if (edtLivro.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o campo Livro com o ID.");
            edtLivro.requestFocus();
            return false;
        }

        if (edtCliente.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o campo Cliente com o ID.");
            edtCliente.requestFocus();
            return false;
        }

        if (edtQuantidade.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o campo Quantidade.");
            edtQuantidade.requestFocus();
            return false;
        }

        if (edtDataVenda.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o campo Data da Venda.");
            edtDataVenda.requestFocus();
            return false;
        }

        return true;
    }

    //e no campo quantidade posso colocar a quantidade de cada um dos livros? Como
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
            java.util.logging.Logger.getLogger(FrCadVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrCadVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrCadVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrCadVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrCadVenda dialog = new FrCadVenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextField edtCliente;
    private javax.swing.JFormattedTextField edtDataVenda;
    private javax.swing.JTextField edtLivro;
    private javax.swing.JTextField edtQuantidade;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblDataVenda;
    private javax.swing.JLabel lblLivro;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
