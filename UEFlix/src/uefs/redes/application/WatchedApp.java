package uefs.redes.application;

import uefs.redes.model.MovieInformation;
import uefs.redes.property.MovieProperty;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class WatchedApp extends Application{
	
	private AnchorPane pane;
	private TableView<MovieProperty> tbCarrinho;
	private TableColumn<MovieProperty, String> columnProduto;
	private TableColumn<MovieProperty, Double> columnPreco;
	private Button btExcluirItem, btVoltarVitrine, btConfirmarCompra;
	private static ObservableList<MovieProperty> listItens;
	
	private void initItens() {
		for (MovieInformation mi : InitialScreenApp.getWatched().getMovies())
			listItens.add(new MovieProperty(mi.getDescription(), mi.getName_file()));
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
