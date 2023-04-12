/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aula05.view;

import java.io.IOException;
import javax.swing.JOptionPane;
import aula05.controller.ControllerLivro;

/**
 *
 * @author guilherme
 */
public class CadastrarLivro extends javax.swing.JFrame {

  /**
   * Creates new form CadastrarLivro
   */
  public CadastrarLivro() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabelNome = new javax.swing.JLabel();
    jLabelDescricao = new javax.swing.JLabel();
    jTextFieldNome = new javax.swing.JTextField();
    jTextFieldDescricao = new javax.swing.JTextField();
    jLabelQuantidade = new javax.swing.JLabel();
    jSpinnerQuantidade = new javax.swing.JSpinner();
    jButtonCadastrar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Cadastrar livro");

    jLabelNome.setText("Nome");

    jLabelDescricao.setText("Descrição");

    jLabelQuantidade.setText("Quantidade");

    jButtonCadastrar.setText("Cadastrar livro");
    jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButtonCadastrarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSpinnerQuantidade)))
                .addContainerGap()));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(jLabelDescricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelQuantidade)
                    .addComponent(jSpinnerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCadastrar)
                .addContainerGap()));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonCadastrarActionPerformed
    ControllerLivro controllerLivro = new ControllerLivro();
    try {
      controllerLivro.cadastrarLivro(
          jTextFieldNome.getText(),
          jTextFieldDescricao.getText(),
          (int) jSpinnerQuantidade.getValue());
      JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!", "Sucesso",
          JOptionPane.OK_CANCEL_OPTION);
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, e.getMessage(),
          "Erro ao cadastrar livro", JOptionPane.ERROR_MESSAGE);
    }
    this.dispose();
  }// GEN-LAST:event_jButtonCadastrarActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
    // (optional) ">
    /*
     * If Nimbus (introduced in Java SE 6) is not available, stay with the default
     * look and feel.
     * For details see
     * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null,
          ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new CadastrarLivro().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButtonCadastrar;
  private javax.swing.JLabel jLabelDescricao;
  private javax.swing.JLabel jLabelNome;
  private javax.swing.JLabel jLabelQuantidade;
  private javax.swing.JSpinner jSpinnerQuantidade;
  private javax.swing.JTextField jTextFieldDescricao;
  private javax.swing.JTextField jTextFieldNome;
  // End of variables declaration//GEN-END:variables
}