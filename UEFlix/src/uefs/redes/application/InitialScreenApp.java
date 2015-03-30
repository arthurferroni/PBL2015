package uefs.redes.application;

import javax.swing.event.ChangeListener;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uefs.redes.model.MovieInformation;
import uefs.redes.property.*;

public class InitialScreenApp extends Application{
	
	private AnchorPane pane;
	private TextField txSearch;
	private Button btSearch;
	private static Watched watched;
	private static Stage stage;
	
	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		initComponents();
		pane.getChildren().addAll(txSearch, btSearch);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Login - UEFSFlix");
		stage.show();
		
	}
	
	private void initComponents(){
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		txSearch = new TextField();
		txSearch.setPromptText("Digite o item para pesquisa");
		btSearch = new Button("Pesquisar");	
		watched = new Watched();
	}

	public static Watched getWatched(){
		return watched;
	}
}
