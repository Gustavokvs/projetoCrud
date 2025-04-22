/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ClienteController;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 *
 * @author thain
 */
public class FrCadCliente extends javax.swing.JDialog {

    
    public FrCadCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
    }

    ClienteController controller = new ClienteController();
    Cliente cl = new Cliente();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblDataNasc = new javax.swing.JLabel();
        edtEmail = new javax.swing.JTextField();
        edtTelefone = new javax.swing.JTextField();
        edtNome = new javax.swing.JTextField();
        edtDataNasc = new javax.swing.JFormattedTextField();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        chkAtivo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("Cadastro do Cliente");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        lblNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(204, 204, 0));
        lblNome.setText("Nome");
        jPanel1.add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 80, -1, -1));

        lblEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(204, 204, 0));
        lblEmail.setText("E-mail");
        jPanel1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 136, -1, -1));

        lblTelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTelefone.setForeground(new java.awt.Color(204, 204, 0));
        lblTelefone.setText("Telefone");
        jPanel1.add(lblTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 183, -1, -1));

        lblDataNasc.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDataNasc.setForeground(new java.awt.Color(204, 204, 0));
        lblDataNasc.setText("Data de Nascimento");
        jPanel1.add(lblDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));
        jPanel1.add(edtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 154, 180, -1));
        jPanel1.add(edtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 206, 130, -1));
        jPanel1.add(edtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 103, 180, -1));

        edtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        edtDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtDataNascActionPerformed(evt);
            }
        });
        jPanel1.add(edtDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 130, -1));

        btnSalvar.setBackground(new java.awt.Color(255, 255, 153));
        btnSalvar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, -1, 30));

        btnVoltar.setBackground(new java.awt.Color(255, 255, 153));
        btnVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar.png"))); // NOI18N
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
        jPanel1.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, 30));

        chkAtivo.setBackground(new java.awt.Color(204, 204, 0));
        chkAtivo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkAtivo.setText("Ativo");
        jPanel1.add(chkAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 315, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtDataNascActionPerformed

    private void btnVoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnVoltarMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (verificarCampos()) {
            gravar();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    public void gravar() {

        cl.setNome(edtNome.getText());
        cl.setEmail(edtEmail.getText());
        cl.setTelefone(edtTelefone.getText());
        cl.setDataNascimento(utils.Utils.converterStringToDate(edtDataNasc.getText()));
        cl.setAtivo(chkAtivo.isSelected()); // Em vez de cl.setAtivo(true);

        if (controller.inserir(cl)) {
            JOptionPane.showMessageDialog(null, "Cliente Registrado com sucesso");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "O cadastro não foi gravado");

        }
    }

    public boolean verificarCampos() {

        String nome = edtNome.getText().trim();
        String email = edtEmail.getText().trim();
        String telefone = edtTelefone.getText().trim();
        String dataNascimento = edtDataNasc.getText().trim();
        boolean ativo = chkAtivo.isSelected();

        if (edtNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo 'Nome' está em branco");
            return false;
        }
        if (!nome.matches("^[A-Za-zÀ-ÖØ-öø-ÿ ]+$")) {
            JOptionPane.showMessageDialog(null, "Nome inválido! Use apenas letras e espaços.");
            return false;
        }

        if (edtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo 'Email' está em branco");
            return false;
        }
        if (!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            JOptionPane.showMessageDialog(null, "E-mail inválido! Use o formato a@a.com.");
            return false;
        }

        if (edtTelefone.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo 'Telefone' está vazio.");
            return false;
        }
        if (!telefone.matches("^^[0-9]{11}$$")) {
            JOptionPane.showMessageDialog(null, "Telefone inválido! Use apenas números (com ou sem o código do país) e de 10 a 15 dígitos.");
            return false;
        }

        // Validação da Data de Nascimento
        if (dataNascimento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'Data de Nascimento' está em branco.");
            return false;
        }
        if (!dataNascimento.matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            JOptionPane.showMessageDialog(null, "Data de nascimento inválida! Use o formato dd/mm/aaaa.");
            return false;
        }

        return true;
    }

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
            java.util.logging.Logger.getLogger(FrCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrCadCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrCadCliente dialog = new FrCadCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JRadioButton chkAtivo;
    private javax.swing.JFormattedTextField edtDataNasc;
    private javax.swing.JTextField edtEmail;
    private javax.swing.JTextField edtNome;
    private javax.swing.JTextField edtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    // End of variables declaration//GEN-END:variables
}
