package uefs.redes.application;

import java.util.Scanner;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MovieScreen extends Scene {
	
	 public MovieScreen(Parent arg0) {
		super(arg0);
		VBox box = new VBox();

	    Scanner scan = new Scanner(System.in);
	    String path = scan.nextLine();
	    scan.close();
	    Media media = new Media("file:///"+path);
	    MediaPlayer mediaPlayer = new MediaPlayer(media);
	    mediaPlayer.setAutoPlay(true);
	    
	    System.out.println(media.getHeight());
	    System.out.println(media.getWidth());
	    System.out.println(media.getDuration());
	    
	    Scene scene = new Scene(box, media.getHeight(), media.getWidth());
	   
	    MediaView mediaView = new MediaView(mediaPlayer);
	    mediaView.setFitHeight(1900);
	    mediaView.setFitWidth(1400);
	    ((VBox) scene.getRoot()).getChildren().add(mediaView);

	}

}
