package uefs.redes.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import uefs.redes.define.Constants;
import uefs.redes.model.ClientInformation;
import uefs.redes.model.MovieInformation;
import uefs.redes.servidorAcesso.ServerAcess;
import uefs.redes.servidorArquivo.ServerFile;



public class ControllerServers {
	
	private ServerSocket server_socket ;
	@SuppressWarnings("unused")
	private Socket client;
	private ArrayList<ClientInformation> clients = new  ArrayList<ClientInformation>();
	private ArrayList<MovieInformation> moviesInformation = new ArrayList<MovieInformation>();

	
	public void start_server_acess() throws IOException
	{
		server_socket = new ServerSocket(Constants.PORT_ACESS);	//	SET PORT NUMBER
		System.out.println("Waiting for clients...");	//	AT THE START PRINT THIS
	
		while (true) 									//	WHILE THE PROGRAM IS RUNNING
		{												
			Socket client_connected = server_socket.accept();					//	ACCEPT SOCKETS(CLIENTS) TRYING TO CONNECT
			System.out.println("Client connected from " + client_connected.getLocalAddress().getHostName());	//	TELL THEM THAT THE CLIENT CONNECTED
			
			ServerAcess server_acess = new ServerAcess(client_connected);				//	CREATE A NEW CLIENT OBJECT
			server_acess.setDatas(this.clients,this.moviesInformation);
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
	private void load_movies() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File arq = new File ("dataServer.dat");
		ObjectInputStream getIn;
		getIn = new ObjectInputStream (new FileInputStream (arq));
		this.clients = (ArrayList<ClientInformation>)getIn.readObject();
		this.moviesInformation = (ArrayList<MovieInformation>)getIn.readObject();
		getIn.close();
		
	}
	private void save_movies() throws SecurityException, IOException
	{
		File arq = new File ("dataServer.dat");
		ObjectOutputStream out; 
		out = new ObjectOutputStream(new FileOutputStream(arq));
		out.writeObject(this.clients);
		out.writeObject(this.moviesInformation);
		out.close();	
		
	}
	public void addMovies( String name, ArrayList< String > tags, String description,int quantity,String category )
	{
		// faz um spli do tags e do nome do filme
		// for colando com addonebyone
		name = name+"-"+category;
		MovieInformation movie = new MovieInformation(name, description, quantity, category);
		this.moviesInformation.add(movie);
	}
	
}

