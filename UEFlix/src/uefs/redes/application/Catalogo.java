<<<<<<< HEAD
package uefs.redes.application;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uefs.redes.controller.ControllerClient;
import uefs.redes.exceptions.*;
import uefs.redes.model.MovieInformation;

public class Catalogo extends javax.swing.JFrame {

    private ArrayList<MovieInformation> movies;

    public Catalogo() {
        initComponents();
        movies = clientController.getMovies();

        wellcome.setText("Wellcome to UEFLIX " + clientController.getClient().getName());

        addButtonsInter();

    }

    public Catalogo(ControllerClient x) {

        clientController = x;
        initComponents();

        movies = clientController.getMovies();

        wellcome.setText("Wellcome to UEFLIX  " + clientController.getClient().getName());
        addButtonsInter();
    }

    public Catalogo(ControllerClient x, ArrayList<MovieInformation> f) {

        clientController = x;
        initComponents();

        movies = f;
        wellcome.setText("Wellcome to UEFLIX " + clientController.getClient().getName());
        addButtonsInter();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        barraRolagem = new javax.swing.JPanel();

        wellcome = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        buttonMain = new javax.swing.JMenu();

        historyButton = new javax.swing.JMenu();
        logoutButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catalógo de Filmes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        searchField.setText("Search");

        searchButton.setBackground(new java.awt.Color(204, 204, 204));

        searchButton.setText("search");

        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        barraRolagem.setBackground(new java.awt.Color(204, 204, 204));
        barraRolagem.setPreferredSize(new java.awt.Dimension(640, 400));
        jScrollPane1.setViewportView(barraRolagem);


        wellcome.setText("Name");

        buttonMain.setText("Inicio");
        buttonMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMainMouseClicked(evt);
            }
        });
        buttonMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMainActionPerformed(evt);
            }
        });
        jMenuBar1.add(buttonMain);


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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wellcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))

                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton))
                    .addComponent(wellcome))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonsInter() {

        barraRolagem.setLayout(new FlowLayout());
        jScrollPane1.setPreferredSize(new Dimension(640, 409));
        String x = new File("").getAbsolutePath();
        JPanel d = new JPanel();
        d.setPreferredSize(new java.awt.Dimension(158, 230));

        for (MovieInformation xFilme : movies) {

            JButton a1 = new JButton("");

            a1.setForeground(new java.awt.Color(204, 204, 204));
            a1.setPreferredSize(new java.awt.Dimension(158, 230));
            a1.setIcon(new javax.swing.ImageIcon(x + "\\clientpicture\\" + xFilme.getName_file() + ".png"));

            a1.addActionListener(new EventsH(new MovieInformation(xFilme.getName_file(), xFilme.getTags_file(), xFilme.getDescription(), xFilme.getQuantity(), xFilme.getCategory())));
            d.add(a1);

            jScrollPane1.setViewportView(d);
        }

    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
           // TODO add your handling code here:

            String search = searchField.getText().trim();

            search = search.toUpperCase();

            clientController.search(search);
        } catch (IOException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SearchSucessException ex) {

            new Catalogo(clientController, clientController.getClient().getSearch()).setVisible(true);
            this.dispose();
        } catch (SearchFailException ex) {
            JOptionPane.showMessageDialog(null, "Não há filmes com essas caracteristicas.");

        }


    }//GEN-LAST:event_searchButtonActionPerformed

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked

        try {

            clientController.logout(clientController.getClient().getLogin());
        } catch (IOException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LogoutSucessException ex) {
            JOptionPane.showMessageDialog(null, "Você foi desconectado");
            new Login(clientController).setVisible(true);
            this.dispose();
        } catch (LogoutFailException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deslogar");
        }
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void historyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyButtonMouseClicked
        // TODO add your handling code here:
        new Historico(clientController).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_historyButtonMouseClicked


    private void buttonMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMainActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_buttonMainActionPerformed

    private void buttonMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMainMouseClicked
        // TODO add your handling code here:

        new Catalogo(clientController).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonMainMouseClicked

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


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Catalogo().setVisible(true);
            }
        });
    }
    private ControllerClient clientController;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraRolagem;

    private javax.swing.JMenu buttonMain;

    private javax.swing.JMenu historyButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu logoutButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;

    private javax.swing.JLabel wellcome;
    // End of variables declaration//GEN-END:variables
}

class EventsH implements ActionListener {

    private MovieInformation mov;

    public EventsH(MovieInformation xs) {
        mov = xs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new MovieDesc(mov).setVisible(true);
    }
}
=======
package uefs.redes.application;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uefs.redes.controller.ControllerClient;
import uefs.redes.exceptions.*;
import uefs.redes.model.MovieInformation;

public class Catalogo extends javax.swing.JFrame {

    private ArrayList<MovieInformation> movies;

    public Catalogo() {
        initComponents();
        movies = clientController.getMovies();

        wellcome.setText("Wellcome to UEFLIX " + clientController.getClient().getName());

        addButtonsInter();

    }

    public Catalogo(ControllerClient x) {

        clientController = x;
        initComponents();

        movies = clientController.getMovies();

        wellcome.setText("Wellcome to UEFLIX  " + clientController.getClient().getName());
        addButtonsInter();
    }

    public Catalogo(ControllerClient x, ArrayList<MovieInformation> f) {

        clientController = x;
        initComponents();

        movies = f;
        wellcome.setText("Wellcome to UEFLIX " + clientController.getClient().getName());
        addButtonsInter();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        barraRolagem = new javax.swing.JPanel();

        wellcome = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        buttonMain = new javax.swing.JMenu();

        historyButton = new javax.swing.JMenu();
        logoutButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Catalógo de Filmes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        searchField.setText("Search");

        searchButton.setBackground(new java.awt.Color(204, 204, 204));

        searchButton.setText("search");

        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        barraRolagem.setBackground(new java.awt.Color(204, 204, 204));
        barraRolagem.setPreferredSize(new java.awt.Dimension(640, 400));
        jScrollPane1.setViewportView(barraRolagem);


        wellcome.setText("Name");

        buttonMain.setText("Inicio");
        buttonMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMainMouseClicked(evt);
            }
        });
        buttonMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMainActionPerformed(evt);
            }
        });
        jMenuBar1.add(buttonMain);


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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wellcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))

                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()

                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton))
                    .addComponent(wellcome))

                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonsInter() {

        barraRolagem.setLayout(new FlowLayout());
        jScrollPane1.setPreferredSize(new Dimension(640, 409));
        String x = new File("").getAbsolutePath();
        JPanel d = new JPanel();
        d.setPreferredSize(new java.awt.Dimension(158, 230));

        for (MovieInformation xFilme : movies) {

            JButton a1 = new JButton("");

            a1.setForeground(new java.awt.Color(204, 204, 204));
            a1.setPreferredSize(new java.awt.Dimension(158, 230));
            a1.setIcon(new javax.swing.ImageIcon(x + "\\clientpicture\\" + xFilme.getName_file() + ".png"));

            a1.addActionListener(new EventsH(new MovieInformation(xFilme.getName_file(), xFilme.getTags_file(), xFilme.getDescription(), xFilme.getQuantity(), xFilme.getCategory())));
            d.add(a1);

            jScrollPane1.setViewportView(d);
        }

    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
           // TODO add your handling code here:

            String search = searchField.getText().trim();

            search = search.toUpperCase();

            clientController.search(search);
        } catch (IOException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SearchSucessException ex) {
            ArrayList<MovieInformation> list = clientController.getClient().getSearch();
            new Catalogo(clientController,list).setVisible(true);
            this.dispose();
        } catch (SearchFailException ex) {
            JOptionPane.showMessageDialog(null, "Não há filmes com essas caracteristicas.");

        }


    }//GEN-LAST:event_searchButtonActionPerformed

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked

        try {

            clientController.logout(clientController.getClient().getLogin());
        } catch (IOException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LogoutSucessException ex) {
            JOptionPane.showMessageDialog(null, "Você foi desconectado");
            new Login(clientController).setVisible(true);
            this.dispose();
        } catch (LogoutFailException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deslogar");
        }
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void historyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyButtonMouseClicked
        // TODO add your handling code here:
        new Historico(clientController).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_historyButtonMouseClicked


    private void buttonMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMainActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_buttonMainActionPerformed

    private void buttonMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMainMouseClicked
        // TODO add your handling code here:

        new Catalogo(clientController).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonMainMouseClicked

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


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Catalogo().setVisible(true);
            }
        });
    }
    private ControllerClient clientController;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraRolagem;

    private javax.swing.JMenu buttonMain;

    private javax.swing.JMenu historyButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu logoutButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;

    private javax.swing.JLabel wellcome;
    // End of variables declaration//GEN-END:variables
}

class EventsH implements ActionListener {

    private MovieInformation mov;

    public EventsH(MovieInformation xs) {
        mov = xs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new MovieDesc(mov).setVisible(true);
    }
}
>>>>>>> origin/master
