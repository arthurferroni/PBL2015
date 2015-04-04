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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import uefs.redes.define.Constants;
import uefs.redes.exceptions.RegisterFailException;
import uefs.redes.exceptions.RegisterSucessException;
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
	public void load_movies() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File arq = new File ("dataServer.dat");
		ObjectInputStream getIn;
		getIn = new ObjectInputStream (new FileInputStream (arq));
		this.clients = (ArrayList<ClientInformation>)getIn.readObject();
		this.moviesInformation = (ArrayList<MovieInformation>)getIn.readObject();
		getIn.close();
		System.out.println(moviesInformation.size() +"-"+ clients.size());
		
		
	}
	public void save_movies() throws SecurityException, IOException
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
		
		MovieInformation movie = new MovieInformation(name,tags ,description, quantity, category);
		this.moviesInformation.add(movie);
	}
        
        
        public String Encrypt(String data) 
        {
            String password = data;
 
        MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(ControllerClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        md.update(password.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
 
      //  System.out.println("Digest(in hex format):: " + sb.toString());
 
        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
             return hexString.toString();
            
        }
        
        
        public void registerTEMP(String name, String login, String password) {
		
		String loginE = Encrypt(login);
                String passE = Encrypt(password);
                
                ClientInformation x = new ClientInformation(name,loginE,passE);
                clients.add(x);
                    
		
	}
        
        
        
	
}

