package uefs.redes.model;
import java.io.IOException;
import java.io.ObjectInputStream;
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
	public void run()											//	(IMPLEMENTED FROM THE RUNNABLE INTERFACE)
	{
		try	
		{
			Pack x ;
			ObjectInputStream in;
			do
			{
				in =  new  ObjectInputStream(socket.getInputStream());
				 x = (Pack) in.readObject();

				switch(x.getCODE()) {
				case Constants.LOGIN_REQ:
					System.out.println("login");
					break;
				case Constants.LOGOUT_REQ:
					System.out.println("logout");
					break;
				case Constants.REGISTER_REQ:
					System.out.println("register");
					break;
				case Constants.SEARCH_REQ:
					System.out.println("search");
					break;
				case Constants.DOWNLOAD_REQ:
					System.out.println("register");
					break;
				default:
					
					break;
					
				
				}
				
			}
			while(!x.equals("0"));
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();								
		}	
	}

}
