package uefs.redes.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import uefs.redes.controller.ControllerCliente;
import uefs.redes.define.Constants;
import uefs.redes.define.Pack;

public class Cliente implements Runnable {

	
	private Socket socket;
	private ArrayList<Object>filmes = new  ArrayList<>();
	private ArrayList<Object>historico = new  ArrayList<>();
	private ControllerCliente controll_cliente = null;
	
	public Cliente(Socket s, ControllerCliente x) throws IOException
	{
		socket = s;	
		controll_cliente = x;
	}
	public Cliente(Socket s) throws IOException
	{
		socket = s;	
	
	}
	
	@Override
	public void run() 											//	INHERIT THE RUN METHOD FROM THE Runnable INTERFACE
	{
		try
		{
			Pack x  = null;
			ObjectInputStream in = null;
			ObjectOutputStream out = null;
			do
			{
				in =  new  ObjectInputStream(socket.getInputStream());
				 x = (Pack) in.readObject();

				switch(x.getCODE()) {
				case Constants.LOGIN_REP:
					System.out.println("login-REP");
	
					break;
				case Constants.LOGOUT_REP:
					System.out.println("logout-REP");
					break;
				case Constants.REGISTER_REP:
					System.out.println("register-REP");
					break;
				case Constants.SEARCH_REP:
					System.out.println("search-REP");
					break;
				case Constants.DOWNLOAD_REP:
					System.out.println("donw-REP");
					
					break;
				default:
					break;
					
				
				}
				
			}
			while(true);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();								//	MOST LIKELY WONT BE AN ERROR, GOOD PRACTICE TO CATCH THOUGH
		} 
	}
	

}
