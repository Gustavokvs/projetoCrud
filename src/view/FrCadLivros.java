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
import java.util.ArrayList;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboAutor = new javax.swing.JComboBox<>();
        comboGenero = new javax.swing.JComboBox<>();
        btnAdicionarGenero = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        lblCategoria.setText("Genero");
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

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botao_salvar.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 120, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/botao_voltar.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 130, 40));

        comboAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAutorActionPerformed(evt);
            }
        });
        jPanel1.add(comboAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 40, -1));

        jPanel1.add(comboGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 40, -1));

        btnAdicionarGenero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAdicionarGenero.setText("Adicionais + genero");
        btnAdicionarGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarGeneroActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdicionarGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fundo_logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 80, 410, 360));

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
        try {
        StringBuilder erros = new StringBuilder();

        String titulo = edtTitulo.getText().trim();
        String isbn = edtIsbn.getText().trim();
        String precoStr = edtPreco.getText().trim();
        String anoStr = edtAnoPublicacao.getText().trim();
        Autor autorSelecionado = (Autor) comboAutor.getSelectedItem();
        Genero generoSelecionado = (Genero) comboGenero.getSelectedItem();

        // Verifica todos os campos e adiciona mensagens específicas
        if (titulo.isEmpty()) erros.append("- O campo Título é obrigatório.\n");
        if (isbn.isEmpty()) erros.append("- O campo ISBN é obrigatório.\n");
        if (precoStr.isEmpty()) erros.append("- O campo Preço é obrigatório.\n");
        if (anoStr.isEmpty()) erros.append("- O campo Ano de Publicação é obrigatório.\n");
        if (autorSelecionado == null) erros.append("- Selecione um Autor.\n");
        if (generoSelecionado == null) erros.append("- Selecione um Gênero.\n");

        // Se tiver erros, mostra tudo junto e para o processo
        if (erros.length() > 0) {
            JOptionPane.showMessageDialog(this, "Por favor, corrija os seguintes erros:\n" + erros.toString());
            return;
        }

        // Agora pode criar o livro com segurança
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setIsbn(isbn);
        livro.setPreco(Double.parseDouble(precoStr));
        livro.setAnoPublicacao(Integer.parseInt(anoStr));
        livro.setIdAutor(autorSelecionado.getId());

        List<Integer> idsCategorias = new ArrayList<>();
        idsCategorias.add(generoSelecionado.getId());

        for (javax.swing.JComboBox<Genero> combo : generosAdicionais) {
            Genero generoAdicional = (Genero) combo.getSelectedItem();
            if (generoAdicional != null) {
                idsCategorias.add(generoAdicional.getId());
            }
        }

        livro.setIdsCategorias(idsCategorias);

        boolean sucesso = salvar(livro);
        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Livro salvo com sucesso no banco de dados!");
        } else {
            JOptionPane.showMessageDialog(this, "Falha ao salvar o livro no banco.");
        }

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Erro de formatação: o campo Preço ou Ano não está com valor numérico válido.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erro ao criar o livro: " + e.getMessage());
        e.printStackTrace();
    
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void comboAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAutorActionPerformed

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
