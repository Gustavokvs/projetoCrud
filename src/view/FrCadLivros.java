package view;

import controller.LivroController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Livro;
import model.Genero;
import model.Autor;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class FrCadLivros extends javax.swing.JDialog {

    public FrCadLivros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
    }

    LivroController controller = new LivroController();
    Livro l1 = new Livro();
    Genero genero = new Genero();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitutolabel = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lbltAutor = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblIsbn = new javax.swing.JLabel();
        lblAnoPublicacao = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        edtTitulo = new javax.swing.JTextField();
        edtIsbn = new javax.swing.JTextField();
        edtCategoria = new javax.swing.JTextField();
        edtAutor = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        edtAnoPublicacao = new javax.swing.JFormattedTextField();
        edtPreco = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitutolabel.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitutolabel.setForeground(new java.awt.Color(204, 204, 0));
        lblTitutolabel.setText("Cadastro de Livro");
        jPanel1.add(lblTitutolabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        lblTitulo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(204, 204, 0));
        lblTitulo.setText("Titulo");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        lbltAutor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbltAutor.setForeground(new java.awt.Color(204, 204, 0));
        lbltAutor.setText("Autor");
        jPanel1.add(lbltAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        lblCategoria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(204, 204, 0));
        lblCategoria.setText("Categoria ID");
        jPanel1.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        lblIsbn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblIsbn.setForeground(new java.awt.Color(204, 204, 0));
        lblIsbn.setText("ISBN");
        jPanel1.add(lblIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        lblAnoPublicacao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAnoPublicacao.setForeground(new java.awt.Color(204, 204, 0));
        lblAnoPublicacao.setText("Ano de publicação");
        jPanel1.add(lblAnoPublicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 140, -1));

        btnVoltar.setBackground(new java.awt.Color(255, 255, 153));
        btnVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVoltar.setBorderPainted(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar.setFocusPainted(false);
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
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 410, 120, 40));

        btnSalvar.setBackground(new java.awt.Color(255, 255, 153));
        btnSalvar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvar.setBorderPainted(false);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setFocusPainted(false);
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 120, 40));

        edtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtTituloActionPerformed(evt);
            }
        });
        jPanel1.add(edtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 180, -1));
        jPanel1.add(edtIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 130, -1));

        edtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(edtCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 130, -1));
        jPanel1.add(edtAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 130, -1));

        lblPreco.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPreco.setForeground(new java.awt.Color(204, 204, 0));
        lblPreco.setText("Preço");
        jPanel1.add(lblPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, 20));
        jPanel1.add(edtAnoPublicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 130, -1));

        edtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPrecoActionPerformed(evt);
            }
        });
        jPanel1.add(edtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 130, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundo_logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 80, 410, 360));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botao_salvar.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 120, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botao_voltar.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPrecoActionPerformed

    private void edtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtCategoriaActionPerformed

    private void edtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtTituloActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked

    }//GEN-LAST:event_btnSalvarMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (verificarCampos()) {
            gravar();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    public void gravar() {
        l1.setTitulo(edtTitulo.getText().trim());
        l1.setIsbn(edtIsbn.getText().trim());

        // Verificando e atribuindo o preço
        double preco = Double.parseDouble(edtPreco.getText().trim());
        if (preco <= 0) {
            JOptionPane.showMessageDialog(this, "Preço inválido!");
            return;
        }
        l1.setPreco(preco);

        // Ano de publicação
        l1.setAnoPublicacao(Integer.parseInt(edtAnoPublicacao.getText().trim()));

        // ID do autor
        try {
            l1.setIdAutor(Integer.parseInt(edtAutor.getText().trim()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID de autor inválido!");
            return;
        }

        // Validação e atribuição das categorias
        if (!validarCategorias()) {
            return;
        }
        l1.setIdsCategorias(getCategoriasList());

        controller.salvar(l1);
        JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");
        limparCampos();
    }

    public void limparCampos() {
        edtTitulo.setText("");
        edtIsbn.setText("");
        edtPreco.setText("");
        edtAnoPublicacao.setText("");
        edtAutor.setText("");
        edtCategoria.setText("");  // Limpa o campo de categorias
    }

    private List<Integer> getCategoriasList() {
        String[] categorias = edtCategoria.getText().trim().split(",");
        List<Integer> idsCategorias = new ArrayList<>();
        for (String categoria : categorias) {
            try {
                idsCategorias.add(Integer.parseInt(categoria.trim()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Categoria com ID inválido: " + categoria.trim());
                return Collections.emptyList();
            }
        }
        return idsCategorias;
    }

    public boolean verificarCampos() {
        String titulo = edtTitulo.getText().trim();
        String isbn = edtIsbn.getText().trim();
        String autor = edtAutor.getText().trim();
        String categoria = edtCategoria.getText().trim();
        String precoStr = edtPreco.getText().trim();
        String anoPublicacaoStr = edtAnoPublicacao.getText().trim();

        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'Título' está vazio.");
            return false;
        }

        if (isbn.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'ISBN' está vazio.");
            return false;
        }

        if (!isbn.matches("^\\d{10}|\\d{13}$")) {
            JOptionPane.showMessageDialog(null, "ISBN inválido! Use o formato de 10 ou 13 dígitos.");
            return false;
        }

        if (autor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'Autor' está vazio.");
            return false;
        }

        try {
            Integer.parseInt(autor);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID do autor inválido. Use um número.");
            return false;
        }

        if (categoria.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'Categoria' está vazio.");
            return false;
        }

        String[] categorias = categoria.split(",");
        for (String idCategoria : categorias) {
            idCategoria = idCategoria.trim();
            try {
                int idCategoriaInt = Integer.parseInt(idCategoria);

                List<Integer> categoriaList = new ArrayList<>();
                categoriaList.add(idCategoriaInt);
                if (!controller.verificarCategoria(categoriaList)) {
                    JOptionPane.showMessageDialog(null, "ID de categoria " + idCategoriaInt + " inválido!");
                    return false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID de categoria inválido: " + idCategoria);
                return false;
            }
        }

        if (precoStr.isEmpty() || !precoStr.matches("\\d+(\\.\\d{1,2})?")) {
            JOptionPane.showMessageDialog(null, "O campo 'Preço' está vazio ou inválido.");
            return false;
        }

        if (anoPublicacaoStr.isEmpty() || !anoPublicacaoStr.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(null, "O campo 'Ano de Publicação' está vazio ou inválido.");
            return false;
        }

        return true;
    }

    private boolean validarCategorias() {
        List<Integer> categorias = getCategoriasList();
        if (categorias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Categoria(s) inválida(s)!");
            return false;
        }

        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JFormattedTextField edtAnoPublicacao;
    private javax.swing.JTextField edtAutor;
    private javax.swing.JTextField edtCategoria;
    private javax.swing.JTextField edtIsbn;
    private javax.swing.JFormattedTextField edtPreco;
    private javax.swing.JTextField edtTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAnoPublicacao;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblIsbn;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitutolabel;
    private javax.swing.JLabel lbltAutor;
    // End of variables declaration//GEN-END:variables
}
