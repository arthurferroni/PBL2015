package uefs.redes.servidorAcesso;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import uefs.redes.define.Constants;
import uefs.redes.define.Pack;
import uefs.redes.model.ClientInformation;

public class ServerAcess implements Runnable{

	
	private Socket socket;
	@SuppressWarnings("unused")
	private ArrayList<Object> moviesInformation;
	@SuppressWarnings("unused")
	private ArrayList<Object> clients = new  ArrayList<Object>();
	public ServerAcess(Socket sock) throws IOException
	{
		this.socket = sock;
		//iniciar array de videos do pc (arquivo)
	}
	@Override
	public void run()
	{
		try	
		{
			Pack pack_reqs ;
			ObjectInputStream in;
			ObjectOutputStream out;
			do
			{
				
					in =  new  ObjectInputStream(socket.getInputStream());
					 pack_reqs = (Pack) in.readObject();
	
					switch(pack_reqs.getCode()) {
					case Constants.LOGIN_REQ:
						System.out.println("login-REQ");
						//
						
						
						


						// CODIGO 
						pack_reqs.setCode(Constants.LOGIN_REP);
						out = new ObjectOutputStream(socket.getOutputStream());
						out.writeObject(pack_reqs);
						break;
					case Constants.LOGOUT_REQ:
						System.out.println("logout-REQ");
						//
						
						
						// CODIGO 
						pack_reqs.setCode(Constants.LOGOUT_REP);
						out = new ObjectOutputStream(socket.getOutputStream());
						out.writeObject(pack_reqs);
						break;
					case Constants.REGISTER_REQ:
						System.out.println("register-REQ");
						//
						String name = (String) pack_reqs.getInformation(0);
						String login_name = (String) pack_reqs.getInformation(1);
						String password = (String) pack_reqs.getInformation(2);
						System.out.println(name+" "+login_name+" "+password);
						
						ClientInformation clientInfor = new ClientInformation(name,login_name,password);
						clients.add(clientInfor);
						// CODIGO 
						pack_reqs.setCode(Constants.REGISTER_REP);
						out = new ObjectOutputStream(socket.getOutputStream());
						out.writeObject(pack_reqs);
						break;
					case Constants.SEARCH_REQ:
						System.out.println("search-REQ");
						//
						
						
						// CODIGO 
						pack_reqs.setCode(Constants.SEARCH_REP);
						out = new ObjectOutputStream(socket.getOutputStream());
						out.writeObject(pack_reqs);
						break;
					case Constants.DOWNLOAD_REQ:
						System.out.println("DONW-REQ");
						//
					
						
						
						// CODIGO 
						pack_reqs.setCode(Constants.DOWNLOAD_REP);
						out = new ObjectOutputStream(socket.getOutputStream());
						out.writeObject(pack_reqs);
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
