package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import communication.MyConstants;
import communication.MyPackage;
import exception.ClientNotFoundException;
import exception.MovieNotFoundException;
import model.*;

public class OperationsServer {
	private List<Client> users;
	private List<Video> videos;
	private List<VideoCover> videoCovers;
	
	public OperationsServer() {
		this.users = new ArrayList<Client>();
		this.videoCovers = new ArrayList<VideoCover>();
		this.videos = new ArrayList<Video>();
	}

	public void startOperation(MyPackage pack, Socket socket) throws IOException{
		int type = pack.getType();
		//realizar login
		if(type == MyConstants.LOGIN){
			this.login(pack, socket);
		}
		//TODO outras operações
	}
	
	
	private void login(MyPackage pack, Socket socket) throws IOException {
		String login = (String) pack.getItems().get(0);
		String password = (String) pack.getItems().get(1);
		
		try {
			Client cl = this.findByLogin(login);
			//Caso o login e senha estejam corretos
			if(cl.getPassword().equals(password)){
				MyPackage myPackage = new MyPackage(MyConstants.LOGIN_SUCCESS);
				myPackage.add(this.videoCovers);
				this.send(myPackage, socket);
			}
			//Caso o login exista e a senha esteja incorreta
			else{
				this.send(new MyPackage(MyConstants.LOGIN_FAIL), socket);
			}
		//caso não ache o usuário com o login oferecido
		} catch (ClientNotFoundException e) {
			this.send(new MyPackage(MyConstants.CLIENT_NOT_FOUND), socket); 
		}
	}
	
	private void send(Object obj, Socket socket) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(obj);
		oos.flush();
	}

	private Client findByLogin(String login) throws ClientNotFoundException{
		for(Client client : this.users){
			if(client.getLogin().equals(login))
				return client;
		}
		throw new ClientNotFoundException();
		
	}
}
