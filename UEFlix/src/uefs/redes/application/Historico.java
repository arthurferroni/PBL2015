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

/**
 *
 * @author Arthur
 */
public class Historico extends javax.swing.JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * Creates new form Catalógo
     */
    private ArrayList<MovieInformation> movies;

    public Historico() {
        initComponents();
        movies = clientController.getClient().getHistory();
        wellcome.setText("Wellcome to UEFLIX " + clientController.getClient().getName());

        addButtonsInter();

    }

    public Historico(ControllerClient x) {

        clientController = x;
        initComponents();

        wellcome.setText("Wellcome to UEFLIX " + clientController.getClient().getName());
        movies = clientController.getClient().getHistory();
        addButtonsInter();
    }

    public Historico(ControllerClient x, ArrayList<MovieInformation> m) {

        clientController = x;
        initComponents();

        wellcome.setText("Wellcome to UEFLIX " + clientController.getClient().getName());
        movies = m;
        addButtonsInter();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        barraRolagem = new javax.swing.JPanel();

        wellcome = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mainButton = new javax.swing.JMenu();
        logoutButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setTitle("Histórico de Filmes");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        searchField.setText("Search");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(204, 204, 204));
        searchButton.setText("search my movies");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        barraRolagem.setBackground(new java.awt.Color(204, 204, 204));
        barraRolagem.setPreferredSize(new java.awt.Dimension(640, 400));
        jScrollPane1.setViewportView(barraRolagem);

        wellcome.setText("Name");

        mainButton.setText("Principal");
        mainButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(mainButton);

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
                        .addGap(1, 1, 1)
                        .addComponent(searchButton))

                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addComponent(searchButton)
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

            a1.addActionListener(new EventsR(new MovieInformation(xFilme.getName_file(), xFilme.getTags_file(), xFilme.getDescription(), xFilme.getQuantity(), xFilme.getCategory())));
            d.add(a1);

            jScrollPane1.setViewportView(d);
        }

    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

        String search = searchField.getText().trim();
        search = search.toUpperCase();
        ArrayList<MovieInformation> l = searchMovies(search);
        if (l.size() > 0) {
            new Historico(clientController, l).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "There aren't moveis.");
        }
    }//GEN-LAST:event_searchButtonActionPerformed
    private ArrayList<MovieInformation> searchMovies(String tag_movie) {

        ArrayList<MovieInformation> list = new ArrayList<MovieInformation>();
        for (MovieInformation movies : this.movies) {
            ArrayList<String> x = movies.getTags_file();
            for (String y : x) {
                if (y.equals(tag_movie)) {
                    list.add(movies);
                }
            }

        }
        return list;
    }


    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked

        try {
            clientController.logout(clientController.getClient().getLogin());
        } catch (IOException ex) {
            Logger.getLogger(Historico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Historico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LogoutSucessException ex) {
            JOptionPane.showMessageDialog(null, "Você foi desconectado");
            new Login(clientController).setVisible(true);
            this.dispose();
        } catch (LogoutFailException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao deslogar");
        }
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void mainButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainButtonMouseClicked
        // TODO add your handling code here:
        new Catalogo(clientController).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mainButtonMouseClicked


    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Historico().setVisible(true);
            }
        });
    }
    private ControllerClient clientController;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraRolagem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu logoutButton;
    private javax.swing.JMenu mainButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel wellcome;

    // End of variables declaration//GEN-END:variables
}

class EventsR implements ActionListener {

    private MovieInformation mov;

    public EventsR(MovieInformation xs) {
        mov = xs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new MovieDesc(mov).setVisible(true);

    }
}
