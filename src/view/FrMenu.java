/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
<<<<<<< HEAD

import view.FrAltCadUsuario;

=======
import view.FrAltCadCliente;
>>>>>>> pt3arrumando
/**
 *
 * @author thain
 */
public class FrMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrMenu
     */
    public FrMenu() {
        initComponents();
<<<<<<< HEAD
        
=======

>>>>>>> pt3arrumando
        this.setLocationRelativeTo(null);
        
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
        barMenu = new javax.swing.JMenuBar();
        meCadastro = new javax.swing.JMenu();
        miAltCadCliente = new javax.swing.JMenuItem();
        miLivros = new javax.swing.JMenuItem();
        miFuncionarios = new javax.swing.JMenuItem();
        miCategorias = new javax.swing.JMenuItem();
        meVendas = new javax.swing.JMenu();
        miRegistarVenda = new javax.swing.JMenuItem();
        miConsultarVenda = new javax.swing.JMenuItem();
        meEstoque = new javax.swing.JMenu();
        miAltCliente = new javax.swing.JMenuItem();
        miAltLivro = new javax.swing.JMenuItem();
        miAltCategoria = new javax.swing.JMenuItem();
        miAltVenda = new javax.swing.JMenuItem();
        meSobre = new javax.swing.JMenu();
        miInformações = new javax.swing.JMenuItem();
        meSobre1 = new javax.swing.JMenu();
        miConCliente = new javax.swing.JMenuItem();
        miConLivro = new javax.swing.JMenuItem();
        miConCategoria = new javax.swing.JMenuItem();
        miConVendas = new javax.swing.JMenuItem();
        miConFuncionarios = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
        );

        meCadastro.setText("Cadastro");

        miAltCadCliente.setText("Cliente");
        miAltCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltCadClienteActionPerformed(evt);
            }
        });
        meCadastro.add(miAltCadCliente);

        miLivros.setText("Livros");
        miLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLivrosActionPerformed(evt);
            }
        });
        meCadastro.add(miLivros);

        miFuncionarios.setText("Funcionários");
        miFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFuncionariosActionPerformed(evt);
            }
        });
        meCadastro.add(miFuncionarios);

        miCategorias.setText("Categorias");
        miCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCategoriasActionPerformed(evt);
            }
        });
        meCadastro.add(miCategorias);

        barMenu.add(meCadastro);

        meVendas.setText("Vendas");

        miRegistarVenda.setText("Cadastrar Vendas");
        miRegistarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegistarVendaActionPerformed(evt);
            }
        });
        meVendas.add(miRegistarVenda);

        miConsultarVenda.setText("Consultar Vendas");
        miConsultarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsultarVendaActionPerformed(evt);
            }
        });
        meVendas.add(miConsultarVenda);

        barMenu.add(meVendas);

        meEstoque.setText("Ñ tem cm saber o ID para Alterar direto");

        miAltCliente.setText("Dados de Clientes");
        miAltCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltClienteActionPerformed(evt);
            }
        });
        meEstoque.add(miAltCliente);

        miAltLivro.setText("Dados de Livros");
        miAltLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltLivroActionPerformed(evt);
            }
        });
        meEstoque.add(miAltLivro);

        miAltCategoria.setText("Dados de Categoria");
        miAltCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltCategoriaActionPerformed(evt);
            }
        });
        meEstoque.add(miAltCategoria);

        miAltVenda.setText("Dados de Venda");
        miAltVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAltVendaActionPerformed(evt);
            }
        });
        meEstoque.add(miAltVenda);

        barMenu.add(meEstoque);

        meSobre.setText("Sobre");

        miInformações.setText("Informações");
        miInformações.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInformaçõesActionPerformed(evt);
            }
        });
        meSobre.add(miInformações);

        barMenu.add(meSobre);

        meSobre1.setText("Consultar");

        miConCliente.setText("Clientes");
        miConCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConClienteActionPerformed(evt);
            }
        });
        meSobre1.add(miConCliente);

        miConLivro.setText("Livros");
        miConLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConLivroActionPerformed(evt);
            }
        });
        meSobre1.add(miConLivro);

        miConCategoria.setText("Categorias");
        miConCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConCategoriaActionPerformed(evt);
            }
        });
        meSobre1.add(miConCategoria);

        miConVendas.setText("Vendas");
        miConVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConVendasActionPerformed(evt);
            }
        });
        meSobre1.add(miConVendas);

        miConFuncionarios.setText("Funcionarios");
        miConFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConFuncionariosActionPerformed(evt);
            }
        });
        meSobre1.add(miConFuncionarios);

        barMenu.add(meSobre1);

        setJMenuBar(barMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void miAltCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltCadClienteActionPerformed
        //criou uma tela de cadastro de usuario, o this referencia a tela anterior de onde ele veio
<<<<<<< HEAD
        FrCadUsuario telaAlt = new FrCadUsuario(this, rootPaneCheckingEnabled);
=======
        FrCadCliente telaAlt = new FrCadCliente (this, rootPaneCheckingEnabled);
>>>>>>> pt3arrumando

        //tornou a tela visivel
        telaAlt.setVisible(true);
    }//GEN-LAST:event_miAltCadClienteActionPerformed

    private void miLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLivrosActionPerformed
        //criou uma tela de cadastro de usuario, o this referencia a tela anterior de onde ele veio
        FrCadLivros telaCadastro = new FrCadLivros(this, rootPaneCheckingEnabled);

        //tornou a tela visivel
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_miLivrosActionPerformed

    private void miFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFuncionariosActionPerformed
        //criou uma tela de cadastro de usuario, o this referencia a tela anterior de onde ele veio
<<<<<<< HEAD
        FrCadFuncionario telaCadastro = new FrCadFuncionario(this, rootPaneCheckingEnabled);
=======
        FrCadFuncionario telaCadastro = new FrCadFuncionario (this, rootPaneCheckingEnabled, 0);
>>>>>>> pt3arrumando

        //tornou a tela visivel
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_miFuncionariosActionPerformed

    private void miRegistarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegistarVendaActionPerformed

        FrCadVenda telaVenda = new FrCadVenda(this, rootPaneCheckingEnabled);
        
        telaVenda.setVisible(true);
        
        
    }//GEN-LAST:event_miRegistarVendaActionPerformed

    private void miConsultarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsultarVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miConsultarVendaActionPerformed

    private void miAltClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltClienteActionPerformed
<<<<<<< HEAD
        //criou uma tela de cadastro de usuario, o this referencia a tela anterior de onde ele veio
        FrAltCadUsuario telaAlterar = new FrAltCadUsuario(this, rootPaneCheckingEnabled, WIDTH);
        //tornou a tela visivel
        telaAlterar.setVisible(true);
=======

>>>>>>> pt3arrumando
    }//GEN-LAST:event_miAltClienteActionPerformed

    private void miAltLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltLivroActionPerformed

    }//GEN-LAST:event_miAltLivroActionPerformed

    private void miInformaçõesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInformaçõesActionPerformed
        //criou uma tela de cadastro de usuario, o this referencia a tela anterior de onde ele veio
        FrInformacoes telaInformacoes = new FrInformacoes(this, rootPaneCheckingEnabled);

        //tornou a tela visivel
        telaInformacoes.setVisible(true);
    }//GEN-LAST:event_miInformaçõesActionPerformed

    private void miCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCategoriasActionPerformed
        FrCadGenero telaCategoria = new FrCadGenero (this, rootPaneCheckingEnabled);

        //tornou a tela visivel
        telaCategoria.setVisible(true); 
    }//GEN-LAST:event_miCategoriasActionPerformed

    private void miAltCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miAltCategoriaActionPerformed

    private void miAltVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAltVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miAltVendaActionPerformed

    private void miConClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConClienteActionPerformed
        //criou uma tela de cadastro de usuario, o this referencia a tela anterior de onde ele veio
<<<<<<< HEAD
        FrConCliente telaCategoria = new FrConCliente(this, rootPaneCheckingEnabled);

        //tornou a tela visivel
        telaCategoria.setVisible(true);
=======
        FrConCliente telaCliente = new FrConCliente (this, rootPaneCheckingEnabled);

        //tornou a tela visivel
        telaCliente.setVisible(true); 
>>>>>>> pt3arrumando
    }//GEN-LAST:event_miConClienteActionPerformed

    private void miConLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miConLivroActionPerformed

    private void miConCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miConCategoriaActionPerformed

    private void miConVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConVendasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miConVendasActionPerformed

    private void miConFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConFuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miConFuncionariosActionPerformed

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
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu meCadastro;
    private javax.swing.JMenu meEstoque;
    private javax.swing.JMenu meSobre;
    private javax.swing.JMenu meSobre1;
    private javax.swing.JMenu meVendas;
    private javax.swing.JMenuItem miAltCadCliente;
    private javax.swing.JMenuItem miAltCategoria;
    private javax.swing.JMenuItem miAltCliente;
    private javax.swing.JMenuItem miAltLivro;
    private javax.swing.JMenuItem miAltVenda;
    private javax.swing.JMenuItem miCategorias;
    private javax.swing.JMenuItem miConCategoria;
    private javax.swing.JMenuItem miConCliente;
    private javax.swing.JMenuItem miConFuncionarios;
    private javax.swing.JMenuItem miConLivro;
    private javax.swing.JMenuItem miConVendas;
    private javax.swing.JMenuItem miConsultarVenda;
    private javax.swing.JMenuItem miFuncionarios;
    private javax.swing.JMenuItem miInformações;
    private javax.swing.JMenuItem miLivros;
    private javax.swing.JMenuItem miRegistarVenda;
    // End of variables declaration//GEN-END:variables
}
