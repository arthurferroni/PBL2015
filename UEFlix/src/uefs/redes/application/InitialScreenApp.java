package uefs.redes.application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private TextField txPesquisa;
	private TableView<MovieProperty> tbInitial;
	private TableColumn<MovieProperty, String> columnVideo;
	private TableColumn<MovieProperty, String> columnName;
	private static ObservableList<MovieProperty> listMovies = FXCollections.observableArrayList();
	private static Favorites watched;
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		initComponents();
		initMovies();
		
	}
	
	private void initComponents(){
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		txPesquisa = new TextField();
		txPesquisa.setPromptText("Digite o item para pesquisa");
		tbInitial = new TableView<MovieProperty>();
		tbInitial.setPrefSize(780, 550);
		columnVideo = new TableColumn<MovieProperty, String>();
		columnName = new TableColumn<MovieProperty, String>();
		tbInitial.getColumns().addAll(columnVideo, columnName);
		pane.getChildren().addAll(txPesquisa, tbInitial);
		watched = new Favorites();
		
		columnVideo.setCellValueFactory(
				new PropertyValueFactory<MovieProperty, String>("Movie"));
		columnName.setCellValueFactory(
				new PropertyValueFactory<MovieProperty, String>("Name"));
	}
	
	private void initMovies(){
		InitialScreen is = new InitialScreen();
		is.addMovies(/*new Movie("Bola Topper", 15.00), new Produto(
		"Luvas Umbro", 9.00), new Produto("Camisa Esportiva", 40.00),
		new Produto("Chuteira Nike Mercurial", 199.00), new Produto(
		"Caneleira Topper", 10.00)*/);
		for (MovieInformation m : is.getMovies())
			listMovies.add(new MovieProperty(m.getName_file(), m.getCategory()));
	}

}
