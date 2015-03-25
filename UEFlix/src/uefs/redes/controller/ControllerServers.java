package uefs.redes.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import uefs.redes.define.Constants;
import uefs.redes.servidorAcesso.ServerAcess;
import uefs.redes.servidorArquivo.ServerFile;



public class ControllerServers {
	
	private ServerSocket server_socket ;
	@SuppressWarnings("unused")
	private Socket client;
	
	public void start_server_acess() throws IOException
	{
		server_socket = new ServerSocket(Constants.PORT_ACESS);	//	SET PORT NUMBER
		System.out.println("Waiting for clients...");	//	AT THE START PRINT THIS
	
		while (true) 									//	WHILE THE PROGRAM IS RUNNING
		{												
			Socket client_connected = server_socket.accept();					//	ACCEPT SOCKETS(CLIENTS) TRYING TO CONNECT
			System.out.println("Client connected from " + client_connected.getLocalAddress().getHostName());	//	TELL THEM THAT THE CLIENT CONNECTED
			
			ServerAcess server_acess = new ServerAcess(client_connected);				//	CREATE A NEW CLIENT OBJECT
			Thread thread_server = new Thread(server_acess);				//	MAKE A NEW THREAD
			thread_server.start();		
		}
	
	}
	public void start_server_file() throws IOException
	{
		server_socket = new ServerSocket(Constants.PORT_FILE);				//	SET PORT NUMBER
		System.out.println("Waiting for clients...");						//	AT THE START PRINT THIS
		while (true) 														//	WHILE THE PROGRAM IS RUNNING
		{												
			Socket client_connected = server_socket.accept();					//	ACCEPT SOCKETS(CLIENTS) TRYING TO CONNECT
			System.out.println("Client connected from " + client_connected.getLocalAddress().getHostName());	//	TELL THEM THAT THE CLIENT CONNECTED
			
			ServerFile server_file = new ServerFile(client_connected);				//	CREATE A NEW CLIENT OBJECT
			Thread thread_server_file = new Thread(server_file);					//	MAKE A NEW THREAD
			thread_server_file.start();		
		}
	
	}
}

