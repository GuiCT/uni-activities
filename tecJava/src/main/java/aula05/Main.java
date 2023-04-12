/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aula05;

import aula05.controller.ControllerBiblioteca;
import java.io.IOException;

import javax.swing.JOptionPane;

import aula05.controller.ControllerLivro;
import aula05.view.CadastrarBiblioteca;
import aula05.view.CadastrarLivro;

/**
 *
 * @author guilherme
 */
public class Main extends javax.swing.JFrame {

  /**
   * Creates new form Main
   */
  public Main() {
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
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jMenuBar = new javax.swing.JMenuBar();
    jMenuLivros = new javax.swing.JMenu();
    jMenuItemListarLivros = new javax.swing.JMenuItem();
    jMenuItemCadastrarLivros = new javax.swing.JMenuItem();
    jMenuBibliotecas = new javax.swing.JMenu();
    jMenuItemListarBibliotecas = new javax.swing.JMenuItem();
    jMenuItemCadastrarBibliotecas = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Listagem e Cadastro");

    jMenuLivros.setText("Livros");

    jMenuItemListarLivros.setText("Listar");
    jMenuItemListarLivros.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemListarLivrosActionPerformed(evt);
      }
    });
    jMenuLivros.add(jMenuItemListarLivros);

    jMenuItemCadastrarLivros.setText("Cadastrar");
    jMenuItemCadastrarLivros.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemCadastrarLivrosActionPerformed(evt);
      }
    });
    jMenuLivros.add(jMenuItemCadastrarLivros);

    jMenuBar.add(jMenuLivros);

    jMenuBibliotecas.setText("Bibliotecas");

    jMenuItemListarBibliotecas.setText("Listar");
    jMenuItemListarBibliotecas.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemListarBibliotecasActionPerformed(evt);
      }
    });
    jMenuBibliotecas.add(jMenuItemListarBibliotecas);

    jMenuItemCadastrarBibliotecas.setText("Cadastrar");
    jMenuItemCadastrarBibliotecas.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemCadastrarBibliotecasActionPerformed(evt);
      }
    });
    jMenuBibliotecas.add(jMenuItemCadastrarBibliotecas);

    jMenuBar.add(jMenuBibliotecas);

    setJMenuBar(jMenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jMenuItemCadastrarBibliotecasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItemCadastrarBibliotecasActionPerformed
    CadastrarBiblioteca cadastrarBiblioteca = new CadastrarBiblioteca();
    cadastrarBiblioteca.setVisible(true);
  }// GEN-LAST:event_jMenuItemCadastrarBibliotecasActionPerformed

  private void jMenuItemListarBibliotecasActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItemListarBibliotecasActionPerformed
    // Cria um Dialog mostrando a listagem de todos as bibliotecas
    ControllerBiblioteca controllerBiblioteca = new ControllerBiblioteca();
    String listagem;
    try {
      listagem = controllerBiblioteca.listarBibliotecas();
      JOptionPane.showMessageDialog(this, listagem);
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }// GEN-LAST:event_jMenuItemListarBibliotecasActionPerformed

  private void jMenuItemCadastrarLivrosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItemCadastrarLivrosActionPerformed
    CadastrarLivro cadastrarLivro = new CadastrarLivro();
    cadastrarLivro.setVisible(true);
  }// GEN-LAST:event_jMenuItemCadastrarLivrosActionPerformed

  private void jMenuItemListarLivrosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItemListarLivrosActionPerformed
    // Cria um Dialog mostrando a listagem de todos os livros
    ControllerLivro controllerLivro = new ControllerLivro();
    String listagem;
    try {
      listagem = controllerLivro.listarLivros();
      JOptionPane.showMessageDialog(this, listagem);
    } catch (ClassNotFoundException | IOException e) {
      e.printStackTrace();
    }
  }// GEN-LAST:event_jMenuItemListarLivrosActionPerformed

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
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Main().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenuBar jMenuBar;
  private javax.swing.JMenu jMenuBibliotecas;
  private javax.swing.JMenuItem jMenuItemCadastrarBibliotecas;
  private javax.swing.JMenuItem jMenuItemCadastrarLivros;
  private javax.swing.JMenuItem jMenuItemListarBibliotecas;
  private javax.swing.JMenuItem jMenuItemListarLivros;
  private javax.swing.JMenu jMenuLivros;
  // End of variables declaration//GEN-END:variables
}