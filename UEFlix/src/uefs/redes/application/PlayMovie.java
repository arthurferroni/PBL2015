package uefs.redes.application;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;


public class PlayMovie extends javax.swing.JFrame {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JFXPanel jfxPanel = new JFXPanel();
    //private WebEngine engine;
 
    private final JPanel panel = new JPanel(new BorderLayout());
   // private final JLabel lblStatus = new JLabel();
 
   // private final JButton btnGo = new JButton("Go");
   // private final JTextField txtURL = new JTextField();
   // private final JProgressBar progressBar = new JProgressBar();
 
    public PlayMovie() {
        super();
        initComponents();
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
 
            @Override
            public void run() {
                PlayMovie browser = new PlayMovie();
                browser.setVisible(true);
                browser.setResizable(false);
                //browser.loadURL("http://oracle.com");
            }
        });
    }
    
    private void initComponents() {
        createScene();
 
    /*    ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadURL(txtURL.getText());
            }
        };*/
 
       // btnGo.addActionListener(al);
     //   txtURL.addActionListener(al);
 
     //   progressBar.setPreferredSize(new Dimension(150, 18));
       // progressBar.setStringPainted(true);
 
   //     JPanel topBar = new JPanel(new BorderLayout(5, 0));
     //   topBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
       // topBar.add(txtURL, BorderLayout.CENTER);
       // topBar.add(btnGo, BorderLayout.EAST);
 
       // JPanel statusBar = new JPanel(new BorderLayout(5, 0));
       // statusBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
       // statusBar.add(lblStatus, BorderLayout.CENTER);
        //statusBar.add(progressBar, BorderLayout.EAST);
 
       // panel.add(topBar, BorderLayout.NORTH);
        panel.add(jfxPanel, BorderLayout.CENTER);
       // panel.add(statusBar, BorderLayout.SOUTH);
 
        getContentPane().add(panel);
 
        setPreferredSize(new Dimension(1280, 720));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
 
    private void createScene() {
 
    	VBox box = new VBox();
    	Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        scan.close();
        Media media = new Media("file:///"+path);
        setTitle(path); 
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        
        System.out.println(media.getHeight());
        System.out.println(media.getWidth());
        System.out.println(media.getDuration());
        
       

        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.autosize();
        Scene scene = new Scene(box, media.getHeight(), media.getWidth());
        ((VBox) scene.getRoot()).getChildren().add(mediaView);
        jfxPanel.setScene(scene);
        jfxPanel.setMaximumSize(new Dimension(1280, 720));
        jfxPanel.setMinimumSize(new Dimension(320, 280));
        
        mediaPlayer.setAutoPlay(true);
    }
        

}
