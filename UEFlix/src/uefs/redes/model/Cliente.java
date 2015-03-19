package uefs.redes.model;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import uefs.redes.define.Constants;
import uefs.redes.define.Pack;

public class Cliente implements Runnable {

	
	private Socket socket;
	private ArrayList<Object>filmes = new  ArrayList<>();
	private ArrayList<Object>historico = new  ArrayList<>();
	
	public Cliente(Socket s) throws IOException
	{
		socket = s;	
	
	}
	
	@Override
	public void run() 											//	INHERIT THE RUN METHOD FROM THE Runnable INTERFACE
	{
		try
		{
			Pack x ;
			ObjectInputStream in;
			ObjectOutputStream out;
			do
			{
				in =  new  ObjectInputStream(socket.getInputStream());
				 x = (Pack) in.readObject();

				switch(x.getCODE()) {
				case Constants.LOGIN_REP:
					System.out.println("login-REP");
					break;
				case Constants.LOGOUT_REP:
					System.out.println("logout");
					break;
				case Constants.REGISTER_REP:
					System.out.println("register");
					break;
				case Constants.SEARCH_REP:
					System.out.println("search");
					break;
				case Constants.DOWNLOAD_REP:
					System.out.println("register");
					break;
				default:
					
					break;
					
				
				}
				
			}
			while(socket!=null);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();								//	MOST LIKELY WONT BE AN ERROR, GOOD PRACTICE TO CATCH THOUGH
		} 
	}
	

}
