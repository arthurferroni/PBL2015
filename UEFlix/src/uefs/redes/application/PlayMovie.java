package uefs.redes.application;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class PlayMovie extends javax.swing.JFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JFXPanel jfxPanel = new JFXPanel();
	private final JPanel panel = new JPanel(new BorderLayout());
	private final JButton btnPlay = new JButton("Play");
	private final JButton btnPause = new JButton("Pause");
	private MediaPlayer mediaPlayer;
	private String movie;
	private int width;
	private int height;
	
	public PlayMovie(String m, int w, int h) {
       super();
       movie = m;
       width = w;
       height = h;
       initComponents();
	}

  /* public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {

           @Override
           public void run() {
               PlayMovie browser = new PlayMovie("D:/AA.mp4", 1280, 720);
               browser.setVisible(true);
               browser.setResizable(false);
               //browser.loadURL("http://oracle.com");
           }
       });
   }*/
   
   private void initComponents() {
       createScene();

       getContentPane().add(panel);
       setPreferredSize(new Dimension(width, height));
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       ActionListener pause = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   mediaPlayer.pause();
           }
       };
       ActionListener play = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
        	   mediaPlayer.play();
           }
       };
       
       btnPause.addActionListener(pause);
       btnPlay.addActionListener(play);
       
       JPanel topBar = new JPanel(new BorderLayout(5, 0));
       topBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
       topBar.add(btnPause, BorderLayout.WEST);
       topBar.add(btnPlay, BorderLayout.CENTER);
       panel.add(jfxPanel, BorderLayout.CENTER);
       panel.add(topBar, BorderLayout.SOUTH);
       pack();
   }

   private void createScene() {

   	VBox box = new VBox();
   	//Scanner scan = new Scanner(System.in);
      // String path = scan.nextLine();
      // scan.close();
       Media media = new Media("file:///"+movie);
       setTitle(movie); 
       mediaPlayer = new MediaPlayer(media);
       
       System.out.println(width);
       System.out.println(height);
       System.out.println(media.getDuration());
       
      

       MediaView mediaView = new MediaView(mediaPlayer);
       mediaView.autosize();
       Scene scene = new Scene(box, width, height);
       ((VBox) scene.getRoot()).getChildren().add(mediaView);
       jfxPanel.setScene(scene);
      // jfxPanel.setMinimumSize(new Dimension(320, 280));
      // jfxPanel.setSize(new Dimension(width, height));
       //mediaPlayer.setAutoPlay(true);
       mediaPlayer.play();
   }
   }