package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import communication.MyConstants;
import communication.MyPackage;
import model.Client;

public class UserThread extends Thread{
	protected Socket socket;
	protected Server server;
	protected Client client;	
	private MyPackage pack;

	public UserThread(Socket socket, Server server) {
		this.socket = socket;
		this.server = server;
	}

	public void run() {
		this.pack = null;
		try {
			do {
				ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());
				Object aux = in.readObject();
				if(aux instanceof MyPackage){
					this.pack = (MyPackage) aux;
					this.server.operations.startOperation(this.pack, this.socket);
				}
				else{
					System.out.println("O cliente enviou algo estranho.");
				}				
			} while (pack != null);
		} catch (IOException e) {
			//Cliente se autosuicidou-se
			System.out.println("O cliente se desconectou.");
		} catch (ClassNotFoundException e) {
			// não achou a classe
			System.out.println("O cliente enviou algo estranho.");
		}

	}


}
