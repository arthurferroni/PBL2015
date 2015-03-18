package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port;
	private ServerSocket server;
	protected OperationsServer operations;
	
	public Server() {
		operations = new OperationsServer();
	}
	
	public void startServer(int port) throws IOException {
		server = new ServerSocket(port);
		
		while(true) {
			Socket socket = server.accept();
			new UserThread(socket, this).start();
		}
	}
	
	public int getPort() {
		return port;
	}

}
