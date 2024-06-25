/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package uas.View;

import javax.swing.JScrollPane;

public class View_Home extends javax.swing.JPanel {

    private JScrollPane contentScrollPane;

    public View_Home(JScrollPane contentScrollPane) {
        this.contentScrollPane = contentScrollPane;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        inputNilaiButton = new javax.swing.JButton();
        lembarNilaiButton = new javax.swing.JButton();
        dataMahasiwaButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(231, 206, 53));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe Script", 1, 64)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Selamat Datang");
        jLabel14.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("POLSTAT STIS");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("SISTEM OLAH NILAI MAHASISWA");

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Copyright ©Politeknik Statistika STIS");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Yulia Wida Kharisma (222212926@stis.ac.id)");

        inputNilaiButton.setBackground(new java.awt.Color(20, 42, 74));
        inputNilaiButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        inputNilaiButton.setForeground(new java.awt.Color(255, 255, 255));
        inputNilaiButton.setText("INPUT NILAI");
        inputNilaiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNilaiButtonActionPerformed(evt);
            }
        });

        lembarNilaiButton.setBackground(new java.awt.Color(20, 42, 74));
        lembarNilaiButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lembarNilaiButton.setForeground(new java.awt.Color(255, 255, 255));
        lembarNilaiButton.setText("TRANSKRIP NILAI");
        lembarNilaiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lembarNilaiButtonActionPerformed(evt);
            }
        });

        dataMahasiwaButton1.setBackground(new java.awt.Color(20, 42, 74));
        dataMahasiwaButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dataMahasiwaButton1.setForeground(new java.awt.Color(255, 255, 255));
        dataMahasiwaButton1.setText("DATA MAHASISWA");
        dataMahasiwaButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dataMahasiwaButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataMahasiwaButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1048, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataMahasiwaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lembarNilaiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNilaiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(28, 28, 28)
                .addComponent(jLabel14)
                .addGap(38, 38, 38)
                .addComponent(dataMahasiwaButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(inputNilaiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lembarNilaiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(33, 33, 33))
        );

        add(jPanel7, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void dataMahasiwaButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataMahasiwaButton1ActionPerformed
        // TODO add your handling code here:
        contentScrollPane.setViewportView(new View_Mahasiswa());
    }//GEN-LAST:event_dataMahasiwaButton1ActionPerformed

    private void lembarNilaiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lembarNilaiButtonActionPerformed
        // TODO add your handling code here:
        contentScrollPane.setViewportView(new View_Transkrip());
    }//GEN-LAST:event_lembarNilaiButtonActionPerformed

    private void inputNilaiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNilaiButtonActionPerformed
        // TODO add your handling code here:
        contentScrollPane.setViewportView(new View_Nilai());
    }//GEN-LAST:event_inputNilaiButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton dataMahasiwaButton1;
    private javax.swing.JButton inputNilaiButton;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton lembarNilaiButton;
    // End of variables declaration//GEN-END:variables
}
