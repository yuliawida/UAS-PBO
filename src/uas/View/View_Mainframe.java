/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uas.View;

import javax.swing.JOptionPane;
import uas.Controller.Controller_User;

public class View_Mainframe extends javax.swing.JFrame {

    private Controller_User controller_user_login;

    public View_Mainframe() {
        initComponents();
        setTitle("SISTEM OLAH NILAI POLSTAT STIS");
        contentScrollPane.setViewportView(new View_Home(contentScrollPane));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentScrollPane = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        homeMenu = new javax.swing.JMenu();
        homeMenuItem = new javax.swing.JMenuItem();
        mahasiswaMenu = new javax.swing.JMenu();
        dataMahasiswaMenuItem = new javax.swing.JMenuItem();
        inputNilaiMenuItem = new javax.swing.JMenuItem();
        lembarNilaiMenuItem = new javax.swing.JMenuItem();
        logoutMenu = new javax.swing.JMenu();
        LogoutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        homeMenu.setText("Home");

        homeMenuItem.setText("Home");
        homeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeMenuItemActionPerformed(evt);
            }
        });
        homeMenu.add(homeMenuItem);

        jMenuBar1.add(homeMenu);

        mahasiswaMenu.setText("Mahasiswa");

        dataMahasiswaMenuItem.setText("Data Mahasiswa");
        dataMahasiswaMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataMahasiswaMenuItemActionPerformed(evt);
            }
        });
        mahasiswaMenu.add(dataMahasiswaMenuItem);

        inputNilaiMenuItem.setText("Input Nilai");
        inputNilaiMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNilaiMenuItemActionPerformed(evt);
            }
        });
        mahasiswaMenu.add(inputNilaiMenuItem);

        lembarNilaiMenuItem.setText("Transkrip Nilai");
        lembarNilaiMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lembarNilaiMenuItemActionPerformed(evt);
            }
        });
        mahasiswaMenu.add(lembarNilaiMenuItem);

        jMenuBar1.add(mahasiswaMenu);

        logoutMenu.setText("Logout");

        LogoutMenuItem.setText("Logout");
        LogoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuItemActionPerformed(evt);
            }
        });
        logoutMenu.add(LogoutMenuItem);

        jMenuBar1.add(logoutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNilaiMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNilaiMenuItemActionPerformed
        // TODO add your handling code here:
        contentScrollPane.setViewportView(new View_Nilai());

    }//GEN-LAST:event_inputNilaiMenuItemActionPerformed

    private void homeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeMenuItemActionPerformed
        // TODO add your handling code here:
        contentScrollPane.setViewportView(new View_Home(contentScrollPane));
    }//GEN-LAST:event_homeMenuItemActionPerformed

    private void dataMahasiswaMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataMahasiswaMenuItemActionPerformed
        // TODO add your handling code here:
        contentScrollPane.setViewportView(new View_Mahasiswa());

    }//GEN-LAST:event_dataMahasiswaMenuItemActionPerformed

    private void lembarNilaiMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lembarNilaiMenuItemActionPerformed
        // TODO add your handling code here:
        contentScrollPane.setViewportView(new View_Transkrip());
    }//GEN-LAST:event_lembarNilaiMenuItemActionPerformed

    private void LogoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuItemActionPerformed
        // TODO add your handling code here:
        View_UserLogin viewUser = new View_UserLogin();

        this.dispose();

        viewUser.setVisible(true);
    }//GEN-LAST:event_LogoutMenuItemActionPerformed

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
            java.util.logging.Logger.getLogger(View_Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem LogoutMenuItem;
    private javax.swing.JScrollPane contentScrollPane;
    private javax.swing.JMenuItem dataMahasiswaMenuItem;
    private javax.swing.JMenu homeMenu;
    private javax.swing.JMenuItem homeMenuItem;
    private javax.swing.JMenuItem inputNilaiMenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem lembarNilaiMenuItem;
    private javax.swing.JMenu logoutMenu;
    private javax.swing.JMenu mahasiswaMenu;
    // End of variables declaration//GEN-END:variables
}
