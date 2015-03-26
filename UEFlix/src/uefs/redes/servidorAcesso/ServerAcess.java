package uefs.redes.servidorAcesso;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import uefs.redes.define.Constants;
import uefs.redes.define.Pack;
import uefs.redes.model.ClientInformation;
import uefs.redes.model.MovieInformation;

public class ServerAcess implements Runnable{

	
	private Socket socket;
	@SuppressWarnings("unused")
	private ArrayList<MovieInformation> moviesInformation = new ArrayList<MovieInformation>();
	private ArrayList<ClientInformation> clients = new  ArrayList<ClientInformation>();
	public ServerAcess(Socket sock) throws IOException
	{
		this.socket = sock;
		//iniciar array de videos do pc (arquivo)
	}
	@Override
	public void run()
	{
		MovieInformation o = new MovieInformation("FILME NOME","DESCRI",1,"TERRO");
		o.addOneByOne("tag1");
		o.addOneByOne("tag2");
		o.addOneByOne("tag3");
		
		moviesInformation.add(o);
		try	
		{
			Pack pack_reqs ;
			ObjectInputStream in;
			
			do
			{
				String name;
				String pass;
				String login_name;
				boolean hasClient = false;
					in =  new  ObjectInputStream(socket.getInputStream());
					 pack_reqs = (Pack) in.readObject();
	
					switch(pack_reqs.getCode()) {
					case Constants.LOGIN_REQ:
						System.out.println("login-REQ");
						//
				
						
						 name = (String)pack_reqs.getInformation(0);
						 pass = (String)pack_reqs.getInformation(1);
						
						 ClientInformation client_information = new ClientInformation(name,pass);
						
						
						for(ClientInformation xClient:this.clients)
						{
							if(xClient.equals(client_information))
							{
								client_information = xClient;
								hasClient = true;
								break;
							}
						}
						if(hasClient)
						{
							pack_reqs = new Pack(Constants.LOGIN_REP);
							pack_reqs.addInformation(client_information);
							pack_reqs.addInformation(Constants.MESSAGE_INFORMATION+"Login.");
						}
						else{
							pack_reqs = new Pack(Constants.LOGIN_RER);
							pack_reqs.addInformation(Constants.MESSAGE_ERROR+"Login verifique as informações.");
						}
						// CODIGO 
						this.send_pack(pack_reqs);
						break;
					case Constants.LOGOUT_REQ:
						System.out.println("logout-REQ");
						// CODIGO 
						pack_reqs.setCode(Constants.LOGOUT_REP);
						pack_reqs.addInformation(Constants.MESSAGE_INFORMATION+"Logout.");
						this.send_pack(pack_reqs);
						socket.close();
						break;
					case Constants.REGISTER_REQ:
						 System.out.println("register-REQ");
						//
						 name = (String) pack_reqs.getInformation(0);
						 login_name = (String) pack_reqs.getInformation(1);
						 pass = (String) pack_reqs.getInformation(2);
						 
						  hasClient = false;
						  ClientInformation clientInfor = null;
						  
						  for(ClientInformation xClient:this.clients)
							{
								if(xClient.getLogin().equals(login_name))
								{
									hasClient = true;
									break;
								}
							}
							if(!hasClient)
							{
								clientInfor = new ClientInformation(name,login_name,pass);
								clients.add(clientInfor);
								pack_reqs = new Pack(Constants.REGISTER_REP);
								pack_reqs.addInformation(Constants.MESSAGE_INFORMATION+"Cadastro.");
								System.out.println("SC");
								
							}
							else{
								
								pack_reqs = new Pack(Constants.REGISTER_RER);
								pack_reqs.addInformation(Constants.MESSAGE_ERROR+"Cadastrado Usuário já existe.");
								System.out.println("ERRO");
								
							}
						
						  // CODIGO
						 this.send_pack(pack_reqs);
						
						break;
					case Constants.SEARCH_REQ:
						System.out.println("search-REQ");
						//
					String tag_movie = (String)pack_reqs.getInformation(0);
					System.out.println(tag_movie);
					ArrayList<MovieInformation> movieslist = searchMovies(tag_movie);
						System.out.println(movieslist.size());
						
						if(movieslist.isEmpty())
						{
							pack_reqs = new Pack(Constants.SEARCH_RER);
							pack_reqs.addInformation(Constants.MESSAGE_ERROR+"Search");
							System.out.println("AQUI");
						}
						else
						{
							pack_reqs = new Pack(Constants.SEARCH_REP);
							pack_reqs.addInformation(Constants.MESSAGE_INFORMATION + "Search");
							
							pack_reqs.addInformation(movieslist);
						
						}
						
						// CODIGO 
						this.send_pack(pack_reqs);
						
						break;
					case Constants.DOWNLOAD_REQ:
						System.out.println("DONW-REQ");
						//
					
						
						
						// CODIGO 
						pack_reqs.setCode(Constants.DOWNLOAD_REP);
						this.send_pack(pack_reqs);
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
	private void send_pack(Pack pack) throws IOException
	{
		ObjectOutputStream out;
		out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(pack);
	}
	private void load_movies()
	{
		
	}
	private ArrayList<MovieInformation> searchMovies(String tag_movie)
	{
		boolean hasMovie = false;
		ArrayList<MovieInformation> list = new ArrayList<MovieInformation>();
		for(MovieInformation movies:this.moviesInformation)
		{
			ArrayList<String> x = movies.getTags_file();
			for(String y:x)
			{
				if(y.equals(tag_movie))
					if(!list.contains(movies))
					{	list.add(movies);
						hasMovie = true;
					}
			}
		}
		return list;
	}
}
