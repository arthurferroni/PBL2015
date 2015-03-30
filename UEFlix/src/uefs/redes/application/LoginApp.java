package uefs.redes.application;

import javax.swing.JOptionPane;

import uefs.redes.controller.ControllerClient;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application{
	

	private AnchorPane pane;
	private TextField txLogin;
	private PasswordField txSenha;
	private Button btEntrar, btSair;
	private static Stage stage;
	private ControllerClient controlClient;
	
	public void start(Stage stage) throws Exception{
		LoginApp.stage = stage;
		initComponents();
		pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);
		Scene scene = new Scene(pane); // pass the pane to start a screen
		stage.setScene(scene);
		stage.setResizable(false);
		//Title for the screen
		stage.setTitle("Login - UEFSFlix");
		stage.show();
		initLayout();
		initListeners();
		controlClient = new ControllerClient();
	}
	
	private void initComponents(){
		pane = new AnchorPane();
		pane.setPrefSize(400, 300);
		txLogin = new TextField();
		txLogin.setPromptText("Digite aqui seu login");
		txSenha = new PasswordField();
		txSenha.setPromptText("Digite aqui sua senha");
		btEntrar = new Button("Entrar");
		btSair = new Button("Sair");
		
	}
	
	private void initLayout() {
		txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
		txLogin.setLayoutY(50);
		txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
		txSenha.setLayoutY(100);
		btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
		btEntrar.setLayoutY(150);
		btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
		btSair.setLayoutY(200);
		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, black 0%, silver 100%);");
	}
	
	public static Stage getStage() {
		return stage;
	}
	
	public static void main(String[] args) {
			launch(args);
	}
	
	private void initListeners() {
		btSair.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent event) {
								closeApp();
							}
		});
		btEntrar.setOnAction(new EventHandler<ActionEvent>(){
							@Override
							public void handle(ActionEvent event) {
								try {
									toLogIn();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
				});
	}
	
	private void toLogIn() throws Exception{
		//controlClient.login(txLogin.getText(), txSenha.getText());
		InitialScreenApp initial = new InitialScreenApp();
		if (txLogin.getText().equals("admin") &&
				txSenha.getText().equals("casadocodigo")) {
			
			initial.start(new Stage());
			LoginApp.getStage().close();
		} else {
			JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void closeApp(){
		System.exit(0);
	}
}
