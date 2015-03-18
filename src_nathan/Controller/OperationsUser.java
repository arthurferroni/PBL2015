package Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import communication.MyConstants;
import communication.MyPackage;

public class OperationsUser {
	private Socket socket;
	
	public OperationsUser(Socket socket) {
		this.socket = socket;
	}

	public void login(String login, String password) throws IOException {
		MyPackage pack = new MyPackage(MyConstants.LOGIN);
		pack.add(login);
		pack.add(password);
		this.send(pack);
	}
	
	private void send(Object pack) throws IOException{
		ObjectOutputStream oos = new ObjectOutputStream(this.socket.getOutputStream());
		oos.writeObject(pack);
		oos.flush();
	}
}
