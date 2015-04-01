/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uefs.redes.application;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uefs.redes.controller.ControllerClient;
import uefs.redes.model.MovieInformation;

/**
 *
 * @author Arthur
 */
public class MovieDesc extends javax.swing.JFrame {

    /**
     * Creates new form MovieDesc
     */
    private MovieInformation infMov;
    public MovieDesc() {
        initComponents();
    }

     public MovieDesc(ControllerClient x, MovieInformation y)
    {
        clientController = x;
        
        infMov = y;
        System.out.print(infMov.getName_file()+" "+infMov.getDescription());
        initComponents();
        textAreaDesc.setText(infMov.getDescription());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        geralPanel = new javax.swing.JPanel();
        pictureMovie = new javax.swing.JPanel();
        fieldDescrition = new javax.swing.JScrollPane();
        textAreaDesc = new javax.swing.JTextArea();
        movieDescription = new javax.swing.JLabel();
        secondPanel = new javax.swing.JPanel();
        combQualMovie = new javax.swing.JComboBox();
        labelMovie = new javax.swing.JLabel();
        watchButton = new javax.swing.JButton();
        closerWindowsMovie = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        geralPanel.setEnabled(false);

        pictureMovie.setBackground(new java.awt.Color(220, 240, 240));
        pictureMovie.setPreferredSize(new java.awt.Dimension(150, 219));

        javax.swing.GroupLayout pictureMovieLayout = new javax.swing.GroupLayout(pictureMovie);
        pictureMovie.setLayout(pictureMovieLayout);
        pictureMovieLayout.setHorizontalGroup(
            pictureMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        pictureMovieLayout.setVerticalGroup(
            pictureMovieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        textAreaDesc.setColumns(20);
        textAreaDesc.setRows(5);
        textAreaDesc.setText("aaaaaaaaaaa");
        textAreaDesc.setEditable(false);
        fieldDescrition.setViewportView(textAreaDesc);

        movieDescription.setText("Descrição do filme");

        combQualMovie.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Baixa", "Alta"}));
        combQualMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combQualMovieActionPerformed(evt);
            }
        });

        labelMovie.setText("Qualidade do filme");

        watchButton.setText("Assistir");
        watchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                watchButtonActionPerformed(evt);
            }
        });

        closerWindowsMovie.setText("Fechar");
        closerWindowsMovie.setToolTipText("");
        closerWindowsMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closerWindowsMovieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout secondPanelLayout = new javax.swing.GroupLayout(secondPanel);
        secondPanel.setLayout(secondPanelLayout);
        secondPanelLayout.setHorizontalGroup(
            secondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(secondPanelLayout.createSequentialGroup()
                .addGroup(secondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(secondPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(secondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelMovie)
                            .addComponent(combQualMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(secondPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(watchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closerWindowsMovie)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        secondPanelLayout.setVerticalGroup(
            secondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(secondPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMovie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combQualMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(secondPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(watchButton)
                    .addComponent(closerWindowsMovie))
                .addContainerGap())
        );

        javax.swing.GroupLayout geralPanelLayout = new javax.swing.GroupLayout(geralPanel);
        geralPanel.setLayout(geralPanelLayout);
        geralPanelLayout.setHorizontalGroup(
            geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(secondPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(geralPanelLayout.createSequentialGroup()
                        .addGroup(geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldDescrition, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(movieDescription))
                        .addGap(0, 0, 0)))
                .addContainerGap())
        );
        geralPanelLayout.setVerticalGroup(
            geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(geralPanelLayout.createSequentialGroup()
                        .addComponent(pictureMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 59, Short.MAX_VALUE))
                    .addGroup(geralPanelLayout.createSequentialGroup()
                        .addComponent(movieDescription)
                        .addGap(12, 12, 12)
                        .addComponent(fieldDescrition, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(secondPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(geralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(geralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combQualMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combQualMovieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combQualMovieActionPerformed

    private void watchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_watchButtonActionPerformed
        // TODO add your handling code here:
        
        String x = (String) combQualMovie.getSelectedItem();
        System.out.print(x);
        if(x.equals("Alta"))
            x = "high";
        else
            x = "low";
        
        try {
            clientController.donwload_movie(infMov.getName_file(),x);
        } catch (IOException ex) {
            Logger.getLogger(MovieDesc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MovieDesc.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_watchButtonActionPerformed

    private void closerWindowsMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closerWindowsMovieActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_closerWindowsMovieActionPerformed

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
            java.util.logging.Logger.getLogger(MovieDesc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovieDesc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovieDesc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovieDesc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovieDesc().setVisible(true);
            }
        });
    }
    private ControllerClient clientController ;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closerWindowsMovie;
    private javax.swing.JComboBox combQualMovie;
    private javax.swing.JScrollPane fieldDescrition;
    private javax.swing.JPanel geralPanel;
    private javax.swing.JLabel labelMovie;
    private javax.swing.JLabel movieDescription;
    private javax.swing.JPanel pictureMovie;
    private javax.swing.JPanel secondPanel;
    private javax.swing.JTextArea textAreaDesc;
    private javax.swing.JButton watchButton;
    // End of variables declaration//GEN-END:variables
}
