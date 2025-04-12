package view;

import controller.ClienteController;
import controller.LivroController;
import javax.swing.JOptionPane;
import model.Livro;

public class FrCadLivros extends javax.swing.JDialog {

    public FrCadLivros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
    }

    LivroController controller = new LivroController();
    Livro l1 = new Livro();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitutolabel.setText("Cadastro de Livro");

        lblTitulo.setText("Titulo");

        lbltAutor.setText("Autor");

        lblCategoria.setText("Categoria");

        lblIsbn.setText("ISBN");

        lblAnoPublicacao.setText("Ano de publicação");

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

        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });

        edtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtTituloActionPerformed(evt);
            }
        });

        edtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtCategoriaActionPerformed(evt);
            }
        });

        lblPreco.setText("Preço");

        edtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPrecoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnVoltar)
                        .addGap(47, 47, 47)
                        .addComponent(btnSalvar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbltAutor)
                            .addComponent(lblTitulo)
                            .addComponent(lblCategoria)
                            .addComponent(lblIsbn)
                            .addComponent(lblPreco)
                            .addComponent(edtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(edtIsbn)
                            .addComponent(edtAnoPublicacao)
                            .addComponent(lblAnoPublicacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(lblTitutolabel)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblTitutolabel)
                .addGap(18, 18, 18)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbltAutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lblCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblIsbn)
                .addGap(8, 8, 8)
                .addComponent(edtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAnoPublicacao)
                .addGap(1, 1, 1)
                .addComponent(edtAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPreco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnSalvar))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMouseClicked

        verificarCampos();
        gravar();
    }//GEN-LAST:event_btnSalvarMouseClicked

    public void gravar() {
        // Pegando os valores dos campos de entrada
        l1.setTitulo(edtTitulo.getText());
        l1.setIsbn(edtIsbn.getText());

        // Corrigindo o acesso ao campo de Preço
        try {
            String precoStr = edtPreco.getText().trim();
            double preco = Double.parseDouble(precoStr);  // Converte para double
            l1.setPreco(preco);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Preço inválido.");
            return;
        }

        // Corrigindo o acesso ao campo de Ano de Publicação
        try {
            int anoPublicacao = Integer.parseInt(edtAnoPublicacao.getText().trim());  // Convertendo para int
            l1.setAnoPublicacao(anoPublicacao);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano de publicação inválido.");
            return;
        }

        // Setando o idAutor
        try {
            String autorStr = edtAutor.getText().trim();
            if (autorStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo 'Autor' está vazio.");
                return;
            }
            int idAutor = Integer.parseInt(autorStr);  // Convertendo para int
            l1.setIdAutor(idAutor);  // Agora é int
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID do autor inválido. Use um número.");
            return;
        }

        l1.setCategoria(edtCategoria.getText());

        // Verificando se a inserção foi bem-sucedida
        if (controller.inserir(l1)) {
            JOptionPane.showMessageDialog(null, "Livro gravado com sucesso");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "O cadastro do livro não foi gravado");
        }

        l1.setCategoria(edtCategoria.getText());

        // Verificando se a inserção foi bem-sucedida
        if (controller.inserir(l1)) {
            JOptionPane.showMessageDialog(null, "Livro gravado com sucesso");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "O cadastro do livro não foi gravado");
        }
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
        // Verificando se o ID do autor é numérico
        int idAutor = Integer.parseInt(autor);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID do autor inválido. Use um número.");
        return false;
    }

    if (categoria.isEmpty()) {
        JOptionPane.showMessageDialog(null, "O campo 'Categoria' está vazio.");
        return false;
    }

    if (!categoria.matches("^[A-Za-zÀ-ÖØ-öø-ÿ ]+$")) {
        JOptionPane.showMessageDialog(null, "Categoria inválida! Use o formato somente com letras.");
        return false;
    }

    if (precoStr.isEmpty()) {
        JOptionPane.showMessageDialog(null, "O campo 'Preço' está vazio.");
        return false;
    }
    try {
        double preco = Double.parseDouble(precoStr);
        if (preco <= 0) {
            JOptionPane.showMessageDialog(null, "Preço inválido! Deve ser maior que zero.");
            return false;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Preço inválido! Use um número válido.");
        return false;
    }

    if (anoPublicacaoStr.isEmpty()) {
        JOptionPane.showMessageDialog(null, "O campo 'Ano de Publicação' está vazio.");
        return false;
    }
    try {
        int anoPublicacao = Integer.parseInt(anoPublicacaoStr);
        if (anoPublicacao < 1000 || anoPublicacao > 2900) {
            JOptionPane.showMessageDialog(null, "Ano de Publicação inválido! Deve ser um ano válido.");
            return false;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ano de Publicação inválido! Use um número válido.");
        return false;
    }

    return true;
}

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrCadLivros dialog = new FrCadLivros(new javax.swing.JFrame(), true);
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
    private javax.swing.JFormattedTextField edtAnoPublicacao;
    private javax.swing.JTextField edtAutor;
    private javax.swing.JTextField edtCategoria;
    private javax.swing.JTextField edtIsbn;
    private javax.swing.JFormattedTextField edtPreco;
    private javax.swing.JTextField edtTitulo;
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
