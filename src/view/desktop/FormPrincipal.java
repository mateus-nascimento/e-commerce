/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.desktop;

import View.desktop.categoria.FormCategoria;
import View.desktop.produto.FormProduto;
import View.desktop.usuario.FormUsuario;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author bboyrap
 */
public class FormPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FormPrincipal
     */
    
    public FormPrincipal() {
        initComponents();
        
        Image image = new ImageIcon(this.getClass().getResource("/material/icone.png")).getImage();
        this.setIconImage(image);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        usuarioMenu = new javax.swing.JMenu();
        usuarioMenuItem = new javax.swing.JMenuItem();
        produtoMenuItem = new javax.swing.JMenuItem();
        categoriaAsMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usuarioMenu.setMnemonic('f');
        usuarioMenu.setText("Menu");

        usuarioMenuItem.setMnemonic('o');
        usuarioMenuItem.setText("Usuário");
        usuarioMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioMenuItemActionPerformed(evt);
            }
        });
        usuarioMenu.add(usuarioMenuItem);

        produtoMenuItem.setMnemonic('s');
        produtoMenuItem.setText("Produto");
        produtoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoMenuItemActionPerformed(evt);
            }
        });
        usuarioMenu.add(produtoMenuItem);

        categoriaAsMenuItem.setMnemonic('a');
        categoriaAsMenuItem.setText("Categorias");
        categoriaAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaAsMenuItemActionPerformed(evt);
            }
        });
        usuarioMenu.add(categoriaAsMenuItem);

        menuBar.add(usuarioMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioMenuItemActionPerformed
        // TODO add your handling code here:
        FormUsuario fu = new FormUsuario();
        fu.setVisible(true);
        desktopPane.add(fu);
    }//GEN-LAST:event_usuarioMenuItemActionPerformed

    private void produtoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoMenuItemActionPerformed
        // TODO add your handling code here:
        FormProduto fp = new FormProduto();
        fp.setVisible(true);
        desktopPane.add(fp);
    }//GEN-LAST:event_produtoMenuItemActionPerformed

    private void categoriaAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaAsMenuItemActionPerformed
        // TODO add your handling code here:
        FormCategoria fc = new FormCategoria();
        fc.setVisible(true);
        desktopPane.add(fc);
    }//GEN-LAST:event_categoriaAsMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem categoriaAsMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem produtoMenuItem;
    private javax.swing.JMenu usuarioMenu;
    private javax.swing.JMenuItem usuarioMenuItem;
    // End of variables declaration//GEN-END:variables

}
