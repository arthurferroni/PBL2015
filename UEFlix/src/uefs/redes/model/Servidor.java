package uefs.redes.model;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import uefs.redes.define.Constants;
import uefs.redes.define.Pack;

public class Servidor implements Runnable{

	
	private Socket socket;
	private ArrayList<VideoInfo> videos;
	
	public Servidor(Socket s) throws IOException
	{
		this.socket = s;
		//iniciar array de videos do pc (arquivo)
	}
	@Override
	public void run()
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
					case Constants.LOGIN_REQ:
						System.out.println("login-REQ");
						//
						
						
						// CODIGO 
						x.setCODE(Constants.LOGIN_REP);
						out = new ObjectOutputStream(socket.getOutputStream());
						out.writeObject(x);
						break;
					case Constants.LOGOUT_REQ:
						System.out.println("logout-REQ");
						//
						
						
						// CODIGO 
						x.setCODE(Constants.LOGOUT_REP);
						out = new ObjectOutputStream(socket.getOutputStream());
						out.writeObject(x);
						break;
					case Constants.REGISTER_REQ:
						System.out.println("register-REQ");
						//
						
						
						// CODIGO 
						x.setCODE(Constants.REGISTER_REP);
						out = new ObjectOutputStream(socket.getOutputStream());
						out.writeObject(x);
						break;
					case Constants.SEARCH_REQ:
						System.out.println("search-REQ");
						//
						
						
						// CODIGO 
						x.setCODE(Constants.SEARCH_REP);
						out = new ObjectOutputStream(socket.getOutputStream());
						out.writeObject(x);
						break;
					case Constants.DOWNLOAD_REQ:
						System.out.println("DONW-REQ");
						//
					
						
						
						// CODIGO 
						x.setCODE(Constants.DOWNLOAD_REP);
						out = new ObjectOutputStream(socket.getOutputStream());
						out.writeObject(x);
						break;
					default:
						
						break;
						
					
					}
							
			}
			while(true);
			
			
		} 
		catch (Exception e)
		{
		System.out.println("cliente desco");								
		}	
	}

}
