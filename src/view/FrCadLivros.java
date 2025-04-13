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
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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
    double preco = getPreco();
    if (preco == -1) {
        return; // Se o preço for inválido, não continua a gravação
    }
    l1.setPreco(preco);

    // Ano de publicação
    l1.setAnoPublicacao(Integer.parseInt(edtAnoPublicacao.getText().trim()));

    // ID do autor
    l1.setIdAutor(Integer.parseInt(edtAutor.getText().trim()));

    // Validação e atribuição das categorias
    if (!validarCategorias()) {
        return; // Se alguma categoria for inválida, não continua a gravação
    }
    l1.setIdsCategorias(getCategoriasList()); // Armazenando os IDs de categorias como uma lista

    controller.salvar(l1);
    JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!");
    limparCampos();
}

private List<Integer> getCategoriasList() {
    String[] categorias = edtCategoria.getText().trim().split(",");
    List<Integer> idsCategorias = new ArrayList<>();
    for (String categoria : categorias) {
        try {
            idsCategorias.add(Integer.parseInt(categoria.trim()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Categoria com ID inválido: " + categoria.trim());
            return Collections.emptyList(); // Retorna uma lista vazia se houver erro
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
        Integer.parseInt(autor);  // Validar se o autor é um número (ID do autor)
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ID do autor inválido. Use um número.");
        return false;
    }

    if (categoria.isEmpty()) {
        JOptionPane.showMessageDialog(null, "O campo 'Categoria' está vazio.");
        return false;
    }

    // Validar a categoria como lista de IDs separados por vírgula
    String[] categorias = categoria.split(",");
    for (String idCategoria : categorias) {
        idCategoria = idCategoria.trim(); // Remove espaços extras
        try {
            int idCategoriaInt = Integer.parseInt(idCategoria); // Converter para inteiro

            // Verificar se a categoria com o ID informado existe
            if (!controller.verificarCategoria(idCategoriaInt)) {
                JOptionPane.showMessageDialog(null, "ID de categoria " + idCategoriaInt + " inválido!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID de categoria inválido: " + idCategoria);
            return false;
        }
    }

    // Preço
    if (precoStr.isEmpty() || !precoStr.matches("\\d+(\\.\\d{1,2})?")) {
        JOptionPane.showMessageDialog(null, "O campo 'Preço' está vazio ou inválido.");
        return false;
    }

    // Ano de publicação
    if (anoPublicacaoStr.isEmpty() || !anoPublicacaoStr.matches("\\d{4}")) {
        JOptionPane.showMessageDialog(null, "O campo 'Ano de Publicação' está vazio ou inválido.");
        return false;
    }

    return true;
}

private boolean validarCategorias() {
    List<Integer> categorias = getCategoriasList();
    return !categorias.isEmpty(); // Verifica se a lista de categorias não está vazia
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
