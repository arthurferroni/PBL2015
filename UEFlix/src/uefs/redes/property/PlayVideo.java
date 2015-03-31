package uefs.redes.property;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


public class PlayVideo extends Application {

	 public static void main(String[] args) {
		 launch();
	 }

	 public void start(Stage palco) throws Exception {
		 String file = "file:///D://video.mp4";
		 //File file = new File(file);
		  Media media = new Media(file); // 1
		  MediaPlayer mediaPlayer = new MediaPlayer(media); // 2
		  MediaView mediaView = new Media(mediaPlayer); // 3
	
		  StackPane raiz = new StackPane();
		  raiz.getChildren().add(mediaView); // 4
		  Scene cena = new Scene(raiz, 600, 400);
		  palco.setTitle("Tocando Video em JavaFX");
		  palco.setScene(cena);
		  palco.show();
	
		  mediaPlayer.play(); // 4
	 }

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
	}
