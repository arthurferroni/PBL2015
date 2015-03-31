/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uefs.redes.application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import uefs.redes.controller.ControllerClient;
import uefs.redes.exceptions.LogoutFailException;
import uefs.redes.exceptions.LogoutSucessException;
import uefs.redes.exceptions.SearchFailException;
import uefs.redes.exceptions.SearchSucessException;
import uefs.redes.model.MovieInformation;

/**
 *
 * @author Arthur
 */
public class Catalogo extends javax.swing.JFrame {

    /**
     * Creates new form Catalógo
     */
   private ArrayList<MovieInformation> movies;
    public Catalogo() {
        initComponents();
        movies = clientController.getMovies();
        backButton.setVisible(false);
    }

   
    public Catalogo(ControllerClient x)
    {
       
        clientController = x;
          initComponents();
          backButton.setVisible(false);
           movies = clientController.getMovies();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        geralPanel = new javax.swing.JPanel();
        moviePanel1 = new javax.swing.JPanel();
        movie1 = new javax.swing.JButton();
        moviePanel2 = new javax.swing.JPanel();
        movie2 = new javax.swing.JButton();
        moviePanel3 = new javax.swing.JPanel();
        movie3 = new javax.swing.JButton();
        moreButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        historyButton = new javax.swing.JMenu();
        logoutButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        searchField.setText("Search");

        searchButton.setText("s");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        geralPanel.setBackground(new java.awt.Color(0, 0, 0));

        moviePanel1.setBackground(new java.awt.Color(0, 0, 0));
        moviePanel1.setPreferredSize(new java.awt.Dimension(178, 252));

        String x = (String) new File("").getAbsolutePath();
        movie1.setForeground(new java.awt.Color(204, 204, 204));
        movie1.setIcon(new javax.swing.ImageIcon( x+"\\clientpicture\\DragonBallZ.png"));
        movie1.setPreferredSize(new java.awt.Dimension(158, 230));
        movie1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout moviePanel1Layout = new javax.swing.GroupLayout(moviePanel1);
        moviePanel1.setLayout(moviePanel1Layout);
        moviePanel1Layout.setHorizontalGroup(
            moviePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        moviePanel1Layout.setVerticalGroup(
            moviePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        moviePanel2.setBackground(new java.awt.Color(0, 0, 0));
        moviePanel2.setPreferredSize(new java.awt.Dimension(178, 252));

        x = (String) new File("").getAbsolutePath();
        movie2.setForeground(new java.awt.Color(204, 204, 204));
        movie2.setIcon(new javax.swing.ImageIcon(x+"\\clientpicture\\Captain_Planet.png"));
        movie2.setPreferredSize(new java.awt.Dimension(158, 230));
        movie2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout moviePanel2Layout = new javax.swing.GroupLayout(moviePanel2);
        moviePanel2.setLayout(moviePanel2Layout);
        moviePanel2Layout.setHorizontalGroup(
            moviePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        moviePanel2Layout.setVerticalGroup(
            moviePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        moviePanel3.setBackground(new java.awt.Color(0, 0, 0));
        moviePanel3.setPreferredSize(new java.awt.Dimension(178, 252));

        x = (String) new File("").getAbsolutePath();
        movie3.setForeground(new java.awt.Color(204, 204, 204));
        movie3.setIcon(new javax.swing.ImageIcon(x+"\\clientpicture\\Batman_Contra_Superman.png"));
        movie3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movie3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout moviePanel3Layout = new javax.swing.GroupLayout(moviePanel3);
        moviePanel3.setLayout(moviePanel3Layout);
        moviePanel3Layout.setHorizontalGroup(
            moviePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        moviePanel3Layout.setVerticalGroup(
            moviePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moviePanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        moreButton.setText("Mais");
        moreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreButtonActionPerformed(evt);
            }
        });

        backButton.setText("Voltar");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout geralPanelLayout = new javax.swing.GroupLayout(geralPanel);
        geralPanel.setLayout(geralPanelLayout);
        geralPanelLayout.setHorizontalGroup(
            geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geralPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(moviePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(moviePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(moviePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, geralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moreButton)
                .addContainerGap())
        );
        geralPanelLayout.setVerticalGroup(
            geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moviePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moviePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moviePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(moreButton)
                    .addComponent(backButton))
                .addContainerGap())
        );

        historyButton.setText("Historico");
        historyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(historyButton);

        logoutButton.setText("Sair");
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(logoutButton);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(geralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(geralPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
       try {
           // TODO add your handling code here:
           
           String search =  searchField.getText().trim();
           
           
           clientController.search(search);
       } catch (IOException ex) {
           Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InterruptedException ex) {
           Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SearchSucessException ex) {
           Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SearchFailException ex) {
           Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
       }
           
    
    }//GEN-LAST:event_searchButtonActionPerformed

    private void movie1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie1ActionPerformed
        MovieInformation movieInfo1 = movies.get(0);
        System.out.print(movieInfo1);
        new MovieDesc(clientController, movieInfo1).setVisible(true);
    }//GEN-LAST:event_movie1ActionPerformed

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        
        try {
            
                    JOptionPane.showMessageDialog(null, clientController.getClient().getLogin());
            clientController.logout(clientController.getClient().getLogin());
        } catch (IOException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LogoutSucessException ex) {
                JOptionPane.showMessageDialog(null, "Você foi desconectado" );
                this.dispose();
        } catch (LogoutFailException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deslogar" );
        }
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void historyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyButtonMouseClicked
        // TODO add your handling code here:
        new CatalogoHistory(clientController).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_historyButtonMouseClicked

    private void moreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreButtonActionPerformed
        // TODO add your handling code here:
        
               
                movie1.setVisible(false);
                movie2.setVisible(false);
                movie3.setVisible(false);
               
               // String  x = (String) new File("").getAbsolutePath();
                //movie3.setIcon(new javax.swing.ImageIcon(x+"\\clientpicture\\Captain_Planet.png"));
                
                backButton.setVisible(true);
                moreButton.setVisible(false);
        
    }//GEN-LAST:event_moreButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        
                 movie1.setVisible(true);
                movie2.setVisible(true);
                movie3.setVisible(true);
               
               // String  x = (String) new File("").getAbsolutePath();
                //movie3.setIcon(new javax.swing.ImageIcon(x+"\\clientpicture\\Captain_Planet.png"));
                
                backButton.setVisible(false);
                moreButton.setVisible(true);
        
        
        
    }//GEN-LAST:event_backButtonActionPerformed

    private void movie2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie2ActionPerformed
        // TODO add your handling code here:
        MovieInformation movieInfo1 = movies.get(1);
        System.out.print(movieInfo1);
        new MovieDesc(clientController, movieInfo1).setVisible(true);
    }//GEN-LAST:event_movie2ActionPerformed

    private void movie3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movie3ActionPerformed
        // TODO add your handling code here:
        MovieInformation movieInfo1 = movies.get(2);
        System.out.print(movieInfo1);
        new MovieDesc(clientController, movieInfo1).setVisible(true);
    }//GEN-LAST:event_movie3ActionPerformed

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
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Catalogo().setVisible(true);
            }
        });
    }
    private ControllerClient clientController ;
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel geralPanel;
    private javax.swing.JMenu historyButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logoutButton;
    private javax.swing.JButton moreButton;
    private javax.swing.JButton movie1;
    private javax.swing.JButton movie2;
    private javax.swing.JButton movie3;
    private javax.swing.JPanel moviePanel1;
    private javax.swing.JPanel moviePanel2;
    private javax.swing.JPanel moviePanel3;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
