package view;

import controller.AutorController;
import controller.GeneroController;
import controller.LivroController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Livro;
import model.Genero;
import model.Autor;
import java.util.List;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;

public class FrCadLivros extends javax.swing.JDialog {

    private List<javax.swing.JComboBox<Genero>> generosAdicionais = new ArrayList<>();
    private List<Genero> listaGeneros = new ArrayList<>();
    private LivroController controller = new LivroController();

    public FrCadLivros(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherComboBoxAutores();
        preencherComboBoxGeneros();
        this.setLocationRelativeTo(null);
    }

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
        lblPreco = new javax.swing.JLabel();
        edtAnoPublicacao = new javax.swing.JFormattedTextField();
        edtPreco = new javax.swing.JFormattedTextField();
        comboGenero = new javax.swing.JComboBox<>();
        comboAutor = new javax.swing.JComboBox<>();
        btnAdicionarGenero = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitutolabel.setText("Cadastro de Livro");
        jPanel1.add(lblTitutolabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 27, -1, -1));

        lblTitulo.setText("Titulo");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 61, -1, -1));

        lbltAutor.setText("Autor");
        jPanel1.add(lbltAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 125, -1, -1));

        lblCategoria.setText("Genero");
        jPanel1.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 186, -1, -1));

        lblIsbn.setText("ISBN");
        jPanel1.add(lblIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 256, -1, -1));

        lblAnoPublicacao.setText("Ano de publicação");
        jPanel1.add(lblAnoPublicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 316, 122, -1));

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
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 464, -1, -1));

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
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 464, -1, -1));

        edtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtTituloActionPerformed(evt);
            }
        });
        jPanel1.add(edtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 83, 190, -1));
        jPanel1.add(edtIsbn, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 280, 122, -1));

        lblPreco.setText("Preço");
        jPanel1.add(lblPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 365, -1, -1));
        jPanel1.add(edtAnoPublicacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 333, 122, -1));

        edtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPrecoActionPerformed(evt);
            }
        });
        jPanel1.add(edtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 393, 108, -1));

        jPanel1.add(comboGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        jPanel1.add(comboAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

        btnAdicionarGenero.setText("Adicionais + genero");
        btnAdicionarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarGeneroActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionarGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPrecoActionPerformed

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
            gravar(); // Só grava se os campos estiverem ok
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAdicionarGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarGeneroActionPerformed
        javax.swing.JComboBox<Genero> novoCombo = new javax.swing.JComboBox<>();
        for (Genero g : listaGeneros) {
            novoCombo.addItem(g);
        }

        int yOffset = 210 + generosAdicionais.size() * 40;
        jPanel1.add(novoCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, yOffset, 140, -1));
        generosAdicionais.add(novoCombo);
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_btnAdicionarGeneroActionPerformed

    private void preencherComboBoxAutores() {
        AutorController autorController = new AutorController();
        ArrayList<Autor> autores = autorController.listarTodos();

        for (Autor autor : autores) {
            comboAutor.addItem(autor); // Adiciona o objeto Autor completo
        }
    }

    private void preencherComboBoxGeneros() {
        GeneroController generoController = new GeneroController();
        listaGeneros = generoController.listarTodos();

        DefaultComboBoxModel<Genero> modelo = new DefaultComboBoxModel<>();
        for (Genero g : listaGeneros) {
            modelo.addElement(g);
        }

        comboGenero.setModel(modelo);
    }

    public boolean salvar(Livro livro) {
        String categoriasString = livro.getCategorias();
        List<Integer> categorias = new ArrayList<>();

        for (String categoria : categoriasString.split(",")) {
            categorias.add(Integer.parseInt(categoria.trim()));
        }

        if (!verificarCategoria(categorias)) {
            System.out.println("Uma ou mais categorias são inválidas.");
            return false;
        }

        LivroController livroController = new LivroController();  // Instanciando o controlador
        return livroController.salvar(livro);  // Chamando o método salvar na instância do controlador
    }

    private boolean verificarCategoria(List<Integer> categorias) {
        return categorias != null && !categorias.isEmpty();
    }

    public boolean verificarCampos() {
        String titulo = edtTitulo.getText().trim();
        String isbn = edtIsbn.getText().trim();
        String precoStr = edtPreco.getText().trim();
        String anoStr = edtAnoPublicacao.getText().trim();
        Autor autorSelecionado = (Autor) comboAutor.getSelectedItem();
        Genero generoSelecionado = (Genero) comboGenero.getSelectedItem();

        // Validação do Título
        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'Título' está em branco.");
            return false;
        }

        // Validação do ISBN
        if (isbn.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'ISBN' está em branco.");
            return false;
        }
        if (!isbn.matches("^[0-9]{10,13}$")) {
            JOptionPane.showMessageDialog(null, "ISBN inválido! Use de 10 a 13 dígitos numéricos.");
            return false;
        }

        // Validação do Preço
        if (precoStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'Preço' está em branco.");
            return false;
        }
        try {
            double preco = Double.parseDouble(precoStr);
            if (preco < 0) {
                JOptionPane.showMessageDialog(null, "O preço não pode ser negativo.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Preço inválido! Use um número válido, como 19.90");
            return false;
        }

        // Validação do Ano de Publicação
        if (anoStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'Ano de Publicação' está em branco.");
            return false;
        }
        try {
            int ano = Integer.parseInt(anoStr);
            if (ano < 1400 || ano > 2100) {
                JOptionPane.showMessageDialog(null, "Ano inválido! Insira um ano entre 1400 e 2100.");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ano inválido! Use apenas números.");
            return false;
        }

        // Validação do Autor
        if (autorSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Selecione um autor.");
            return false;
        }

        // Validação do Gênero
        if (generoSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Selecione um gênero.");
            return false;
        }

        return true;
    }

public void gravar() {
    // Criando uma instância do livro
    Livro livro = new Livro();

    // Definindo o título, ISBN, preço e ano de publicação
    livro.setTitulo(edtTitulo.getText().trim());
    livro.setIsbn(edtIsbn.getText().trim());
    livro.setPreco(Double.parseDouble(edtPreco.getText().trim()));
    livro.setAnoPublicacao(Integer.parseInt(edtAnoPublicacao.getText().trim()));

    // Pegando o autor selecionado no JComboBox e atribuindo o idAutor
    Autor autorSelecionado = (Autor) comboAutor.getSelectedItem();
    livro.setIdAutor(autorSelecionado != null ? autorSelecionado.getId() : 0); // Usando o id do autor selecionado

    // Pegando os gêneros selecionados (Lista de ids de categorias)
    List<Integer> categoriasSelecionadas = new ArrayList<>();
    Genero generoSelecionado = (Genero) comboGenero.getSelectedItem();
    if (generoSelecionado != null) {
        categoriasSelecionadas.add(generoSelecionado.getId());
    }

    // Convertendo a lista de categorias para uma string com IDs separados por vírgula
    StringBuilder categoriasString = new StringBuilder();
    for (Integer categoriaId : categoriasSelecionadas) {
        if (categoriasString.length() > 0) {
            categoriasString.append(",");
        }
        categoriasString.append(categoriaId);
    }

    // Agora, tentamos salvar o livro, passando a string com os IDs das categorias
    if (controller.inserir(livro, categoriasString.toString())) {
        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar o livro.");
    }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarGenero;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<Autor> comboAutor;
    private javax.swing.JComboBox<Genero> comboGenero;
    private javax.swing.JFormattedTextField edtAnoPublicacao;
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
