package view;

import controller.AutorController;
import controller.GeneroController;
import controller.LivroController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import model.Autor;
import model.Genero;
import model.Livro;

/**
 *
 * @author gusta
 */
public class FrAltLivro extends javax.swing.JDialog {

    private Livro livro;
    private List<Autor> listaAutores;
    private List<Genero> listaGeneros;

    public FrAltLivro(FrConLivros parent, boolean modal, Livro livro) {
        super(parent, modal);
        initComponents();
        this.livro = livro;
        this.setLocationRelativeTo(null);

        listaGeneros = new ArrayList<>();  // Inicialização correta

        // Preenche o combo de gêneros
        preencherComboBoxGeneros();

        if (livro != null) {
            preencherCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Erro: livro inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            dispose();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edtIdLivro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        edtTitulo = new javax.swing.JTextField();
        edtIsbn = new javax.swing.JTextField();
        edtPreco = new javax.swing.JTextField();
        edtAnoPublicacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboAutor = new javax.swing.JComboBox<>();
        btnAdicionarCategoria = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("Código do livro:");

        edtIdLivro.setEditable(false);
        edtIdLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtIdLivroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("Autor");

        lbCategoria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbCategoria.setForeground(new java.awt.Color(204, 204, 0));
        lbCategoria.setText("Categoria ID");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("Título");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 0));
        jLabel6.setText("ISBN");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 0));
        jLabel7.setText("Preço");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 0));
        jLabel8.setText("Ano de publicação");

        btnSalvar.setBackground(new java.awt.Color(255, 255, 153));
        btnSalvar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvar.setBorderPainted(false);
        btnSalvar.setContentAreaFilled(false);
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.setFocusPainted(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 153));
        btnCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setText("Alterar Livro");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botao_salvar.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botao_voltar.png"))); // NOI18N

        comboAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdicionarCategoria.setBackground(new java.awt.Color(255, 255, 255));
        btnAdicionarCategoria.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAdicionarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnAdicionarCategoria.setText("Adicionar categoria");
        btnAdicionarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5)
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1)
                        .addGap(8, 8, 8)
                        .addComponent(edtIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(edtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(edtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(edtAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(comboAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lbCategoria)))
                .addContainerGap(284, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnAdicionarCategoria))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(132, 132, 132))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtIdLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(edtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addComponent(edtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel8)
                .addGap(3, 3, 3)
                .addComponent(edtAnoPublicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(comboAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(lbCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnAdicionarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
        );

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

    private List<JComboBox<Genero>> listaComboCategorias = new ArrayList<>();
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
// 1. Coleta os IDs das categorias selecionadas
        List<Integer> categoriasSelecionadas = new ArrayList<>();

        for (JComboBox<Genero> combo : listaComboCategorias) {
            Genero generoSelecionado = (Genero) combo.getSelectedItem();
            if (generoSelecionado != null) {
                categoriasSelecionadas.add(generoSelecionado.getId());
            }
        }

// 2. Atualiza o objeto livro
        livro.setIdsCategorias(categoriasSelecionadas);

// 3. Chama o controller para salvar
        LivroController livroController = new LivroController();

        boolean sucesso;
        if (livro.getId() > 0) {
            sucesso = livroController.atualizar(livro);
            // Método atualizar deve agora tratar categorias também

// 4. Feedback para o usuário
            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Livro salvo com sucesso!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao salvar o livro.");
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void edtIdLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtIdLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtIdLivroActionPerformed

    private void btnAdicionarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarCategoriaActionPerformed
         JComboBox<Genero> novoCombo = new JComboBox<>();

        for (Genero genero : listaGeneros) {
            novoCombo.addItem(genero);
        }

        listaComboCategorias.add(novoCombo);  // Armazena na lista para controle

        // Ajusta a posição dinamicamente para evitar sobreposição
        int yOffset = 390 + (listaComboCategorias.size() * 40);
        novoCombo.setBounds(70, yOffset, 140, 30);

        jPanel1.add(novoCombo);  // Adiciona manualmente ao painel
        jPanel1.revalidate();  // Atualiza o layout
        jPanel1.repaint();  // Redesenha a interface
    }//GEN-LAST:event_btnAdicionarCategoriaActionPerformed

    // Inicializa a listaCategorias com valores fixos
    private void preencherCampos() {
        edtIdLivro.setText(String.valueOf(livro.getId())); // Agora exibe o ID do livro corretamente
        edtTitulo.setText(livro.getTitulo());
        edtAnoPublicacao.setText(String.valueOf(livro.getAnoPublicacao()));
        edtPreco.setText(String.valueOf(livro.getPreco()));
        edtIsbn.setText(livro.getIsbn());

        preencherComboBoxAutores();
        preencherComboBoxGeneros();

        // Seleciona os valores no ComboBox
        comboAutor.setSelectedItem(listaAutores.stream()
                .filter(a -> a.getId() == livro.getIdAutor())
                .findFirst()
                .orElse(null));

    }

    private void preencherComboBoxAutores() {
        try {
            AutorController autorController = new AutorController();
            listaAutores = autorController.listarTodos();
            comboAutor.removeAllItems();
            listaAutores.forEach(autor -> comboAutor.addItem(autor.getNome()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar autores: " + e.getMessage());
        }
    }

    private void preencherComboBoxGeneros() {
        GeneroController generoController = new GeneroController(); // Acesso ao controlador
        listaGeneros = generoController.listarTodos(); // Supondo que esse método retorne uma lista de Genero

    }

    private boolean verificarCampos() {
        // Verifica se o título do livro foi preenchido
        if (edtTitulo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O título do livro é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verifica se o ano de publicação foi preenchido e é um número válido
        try {
            int ano = Integer.parseInt(edtAnoPublicacao.getText().trim());
            if (ano <= 0) {
                JOptionPane.showMessageDialog(this, "O ano de publicação deve ser um número positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O ano de publicação deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verifica se o preço foi preenchido e é um número válido
        try {
            double preco = Double.parseDouble(edtPreco.getText().trim());
            if (preco <= 0) {
                JOptionPane.showMessageDialog(this, "O preço deve ser um valor positivo.", "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O preço deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verifica se o ISBN foi preenchido
        if (edtIsbn.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O ISBN é obrigatório.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Verifica se um autor foi selecionado
        if (comboAutor.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "É necessário selecionar um autor.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;  // Todos os campos estão validados corretamente
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarCategoria;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboAutor;
    private javax.swing.JTextField edtAnoPublicacao;
    private javax.swing.JTextField edtIdLivro;
    private javax.swing.JTextField edtIsbn;
    private javax.swing.JTextField edtPreco;
    private javax.swing.JTextField edtTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCategoria;
    // End of variables declaration//GEN-END:variables
}
