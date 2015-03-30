package uefs.redes.application;

import uefs.redes.model.MovieInformation;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MovieApp extends Application{
	
	private AnchorPane pane;
	private ImageView imgItem;
	private Label lbName, lbDescricao;
	private Button btWatchLow;
	private Button btWatchHigh;	
	private static Stage stage;
	private static MovieInformation movie;
	
	@Override
	public void start(Stage stage) throws Exception {
		pane = new AnchorPane();
		pane.setPrefSize(600, 400);
	/* Demais códigos de inicialização da tela e componentes */
	}

}
