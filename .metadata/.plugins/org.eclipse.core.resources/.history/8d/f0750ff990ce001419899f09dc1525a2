package uefs.redes.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import uefs.redes.define.Constants;
import uefs.redes.define.Pack;
import uefs.redes.model.Servidor;
import uefs.redes.model.VideoInfo;



public class ControllerServidor {
	
	private ServerSocket socket_servidor ;
	private Socket client;
	
	public void start() throws IOException
	{
		socket_servidor = new ServerSocket(Constants.PORT );	//	SET PORT NUMBER
		System.out.println("Waiting for clients...");	//	AT THE START PRINT THIS
	
		while (true) 									//	WHILE THE PROGRAM IS RUNNING
		{												
			Socket s = socket_servidor.accept();					//	ACCEPT SOCKETS(CLIENTS) TRYING TO CONNECT
			System.out.println("Client connected from " + s.getLocalAddress().getHostName());	//	TELL THEM THAT THE CLIENT CONNECTED
			
			Servidor chat = new Servidor(s);				//	CREATE A NEW CLIENT OBJECT
			Thread t = new Thread(chat);				//	MAKE A NEW THREAD
			t.start();		
		}
	
	}
	
	public void retornar(Pack pacote){
		if (pacote.getCODE() == Constants.LOGIN_REQ){
			pacote.setCODE(Constants.LOGIN_REP);
			this.conferirLogin(pacote.getINFO());
		}
		else if (pacote.getCODE() == Constants.SEARCH_REQ){
			pacote.setCODE(Constants.SEARCH_REP);
		}
		else if (pacote.getCODE() == Constants.DOWNLOAD_REQ){
			pacote.setCODE(Constants.DOWNLOAD_REP);
		}
		else if (pacote.getCODE() == Constants.LOGOUT_REQ){
			pacote.setCODE(Constants.LOGOUT_REP);
		}
		else {
			//excessão
		}
	}
	
	public void conferirLogin(ArrayList<Object> info){
		String nick = (String)info.get(0);
		String pass = (String)info.get(1);
		//conferir onde os usuarios são salvos
	}
	
	public ArrayList<VideoInfo> retornarBusca(ArrayList<Object> info){
		String metadado = (String) info.get(0);
		
		return null;
		
	}
	
	public String confirmarDownload (ArrayList<Object> info){
		String cod = (String) info.get(0);
		
		return null;
	}
	
}

