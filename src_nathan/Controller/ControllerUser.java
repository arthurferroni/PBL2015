package Controller;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class ControllerUser {
	private Socket socket;
	private Client client;
	private List<VideoCover> videoCovers;
	private OperationsUser operations;
	
	public ControllerUser() {
		super();
		this.videoCovers = new ArrayList<VideoCover>();
	}
	
	public void start(String address, int port) throws UnknownHostException, IOException{
		this.socket = new Socket(address, port);
		this.operations = new OperationsUser(this.socket);
	}
	
	//TODO ver se o throws aqui está certo
	public void login(String login, String password) throws IOException{
		this.operations.login(login,password);
	}
}
