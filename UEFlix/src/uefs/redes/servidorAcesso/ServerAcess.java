<<<<<<< HEAD
<<<<<<< OURS
package uefs.redes.servidorAcesso;
<<<<<<< HEAD
import java.io.File;
import java.io.FileOutputStream;
=======
>>>>>>> origin/master
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
<<<<<<< HEAD
import java.time.Clock;
=======
>>>>>>> origin/master
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import uefs.redes.define.Constants;
import uefs.redes.define.Pack;
import uefs.redes.model.ClientInformation;
import uefs.redes.model.MovieInformation;

public class ServerAcess implements Runnable{

	private ClientInformation client_information = null;
	private Socket socket;
	@SuppressWarnings("unused")
	private ArrayList<MovieInformation> moviesInformation = new ArrayList<MovieInformation>();
	private ArrayList<ClientInformation> clients = new  ArrayList<ClientInformation>();

	public ServerAcess(Socket sock) throws IOException
	{
		this.socket = sock;
	}
	@Override
	public void run()
	{
			
		try	
		{
			Pack pack_reqs ;
			ObjectInputStream in;
<<<<<<< HEAD
			int countSave = 0;
=======
			
>>>>>>> origin/master
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
<<<<<<< HEAD
						//System.out.println("login-REQ");
=======
						System.out.println("login-REQ");
>>>>>>> origin/master
						//
						 name = (String)pack_reqs.getInformation(0);
						 pass = (String)pack_reqs.getInformation(1);
						
						 
						
						for(ClientInformation xClient:this.clients)
						{
							if(xClient.getLogin().equals(name))
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
							pack_reqs.addInformation(moviesInformation);
							pack_reqs.addInformation(Constants.MESSAGE_INFORMATION+"Login.");
						}
						else{
							pack_reqs = new Pack(Constants.LOGIN_RER);
							pack_reqs.addInformation(Constants.MESSAGE_ERROR+"Login verifique as informa��es.");
						}
						// CODIGO 
						this.send_pack(pack_reqs);
						break;
					case Constants.LOGOUT_REQ:
						
						pack_reqs.setCode(Constants.LOGOUT_REP);
<<<<<<< HEAD
						pack_reqs.addInformation(Constants.MESSAGE_INFORMATION+" Logout.");
						this.send_pack(pack_reqs);
                                                socket.close();
=======
						pack_reqs.addInformation(Constants.MESSAGE_INFORMATION+"Logout.");
						this.send_pack(pack_reqs);
>>>>>>> origin/master
						break;
					case Constants.REGISTER_REQ:
						 
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
<<<<<<< HEAD
                                                                countSave++;
=======
								
>>>>>>> origin/master
							}
							else{
								
								pack_reqs = new Pack(Constants.REGISTER_RER);
<<<<<<< HEAD
								pack_reqs.addInformation(Constants.MESSAGE_ERROR+" Cadastrado Usuário já existe.");
								
								
							}
                                                        
                                                        if(countSave == 10)
                                                        {
                                                            save_movies();
                                                            countSave = 0;
                                                        }
                                                        
=======
								pack_reqs.addInformation(Constants.MESSAGE_ERROR+"Cadastrado Usu�rio j� existe.");
								
								
							}
>>>>>>> origin/master
						  // CODIGO
						 this.send_pack(pack_reqs);
						 hasClient = false;
						break;
					case Constants.SEARCH_REQ:
						String tag_movie;
						tag_movie = (String)pack_reqs.getInformation(0);
<<<<<<< HEAD
						//System.out.println(tag_movie);
						
						ArrayList<MovieInformation> movieslist = searchMovies(tag_movie);
                                                
=======
						System.out.println(tag_movie);
						
						ArrayList<MovieInformation> movieslist = searchMovies(tag_movie);
							
						
>>>>>>> origin/master
							if(movieslist.isEmpty())
							{
								pack_reqs = new Pack(Constants.SEARCH_RER);
								pack_reqs.addInformation(Constants.MESSAGE_ERROR+"Search n�o h� videos com essa tag");
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
						String tag_movie1;
						
						tag_movie1 = (String) pack_reqs.getInformation(0);
						MovieInformation movieslists = getMovies(tag_movie1);
<<<<<<< HEAD
                                                
                                               
                                                System.out.print( movieslists.getName_file());
                                                
						client_information.addMoiveHistory(movieslists);
                                                pack_reqs.setCode(Constants.DOWNLOAD_REP);
                                                //pack_reqs.addInformation(client_information.getMyMovies());
                                                this.send_pack(pack_reqs);
=======
						client_information.addMoiveHistory(movieslists);
					//	pack_reqs.setCode(Constants.DOWNLOAD_REP);
					//	this.send_pack(pack_reqs);
>>>>>>> origin/master
						break;
					default:
						
						break;
						
					
					}
							
			}
			while(true);
			
		} 
		catch (Exception e)
		{
<<<<<<< HEAD
                    System.out.println(client_information.getName()+" foi desconectado.");								
=======
		System.out.println("cliente desco");								
>>>>>>> origin/master
		}	
	}
	private void send_pack(Pack pack) throws IOException
	{
		ObjectOutputStream out;
		out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(pack);
	}
	
	private ArrayList<MovieInformation> searchMovies(String tag_movie)
	{
		
		ArrayList<MovieInformation> list = new ArrayList<MovieInformation>();
		for(MovieInformation movies:this.moviesInformation)
		{
			ArrayList<String> x = movies.getTags_file();
			for(String y:x)
			{
				if(y.equals(tag_movie))
<<<<<<< HEAD
                                   list.add(movies);
			}
                      
		}
                
=======
					if(!list.contains(movies))
						list.add(movies);
			}
		}
>>>>>>> origin/master
		return list;
	}
	private MovieInformation getMovies(String tag_movie)
	{
		
		MovieInformation list = null;
		for(MovieInformation movies:this.moviesInformation)
		{
			String x = movies.getName_file();
			
				if(x.equals(tag_movie))
					list = movies;
		}
<<<<<<< HEAD
                
=======
>>>>>>> origin/master
		return list;
	}
	
	public void setDatas(ArrayList<ClientInformation> x, ArrayList<MovieInformation> y)
	{
		this.clients = x;
		this.moviesInformation = y;
	}
<<<<<<< HEAD
        public void save_movies() throws SecurityException, IOException
	{
		File arq = new File ("dataServer.dat");
		ObjectOutputStream out; 
		out = new ObjectOutputStream(new FileOutputStream(arq));
		out.writeObject(this.clients);
		out.writeObject(this.moviesInformation);
		out.close();	
		
	}
=======
>>>>>>> origin/master
}
=======
package uefs.redes.servidorAcesso;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.Clock;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import uefs.redes.define.Constants;
import uefs.redes.define.Pack;
import uefs.redes.model.ClientInformation;
import uefs.redes.model.MovieInformation;

public class ServerAcess implements Runnable{

	private ClientInformation client_information = null;
	private Socket socket;
	@SuppressWarnings("unused")
	private ArrayList<MovieInformation> moviesInformation = new ArrayList<MovieInformation>();
	private ArrayList<ClientInformation> clients = new  ArrayList<ClientInformation>();

	public ServerAcess(Socket sock) throws IOException
	{
		this.socket = sock;
	}
	@Override
	public void run()
	{
			
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
						//System.out.println("login-REQ");
						//
						 name = (String)pack_reqs.getInformation(0);
						 pass = (String)pack_reqs.getInformation(1);
						
						 
						
						for(ClientInformation xClient:this.clients)
						{
							if(xClient.getLogin().equals(name))
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
							pack_reqs.addInformation(moviesInformation);
							pack_reqs.addInformation(Constants.MESSAGE_INFORMATION+"Login.");
						}
						else{
							pack_reqs = new Pack(Constants.LOGIN_RER);
							pack_reqs.addInformation(Constants.MESSAGE_ERROR+"Login verifique as informa��es.");
						}
						// CODIGO 
						this.send_pack(pack_reqs);
						break;
					case Constants.LOGOUT_REQ:
						
						pack_reqs.setCode(Constants.LOGOUT_REP);
						pack_reqs.addInformation(Constants.MESSAGE_INFORMATION+" Logout.");
						this.send_pack(pack_reqs);
                                                socket.close();
						break;
					case Constants.REGISTER_REQ:
						 
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
								
							}
							else{
								
								pack_reqs = new Pack(Constants.REGISTER_RER);
								pack_reqs.addInformation(Constants.MESSAGE_ERROR+" Cadastrado Usuário já existe.");
								
								
							}
						  // CODIGO
						 this.send_pack(pack_reqs);
						 hasClient = false;
						break;
					case Constants.SEARCH_REQ:
						String tag_movie;
						tag_movie = (String)pack_reqs.getInformation(0);
						//System.out.println(tag_movie);
						
						ArrayList<MovieInformation> movieslist = searchMovies(tag_movie);
                                                
							if(movieslist.isEmpty())
							{
								pack_reqs = new Pack(Constants.SEARCH_RER);
								pack_reqs.addInformation(Constants.MESSAGE_ERROR+"Search n�o h� videos com essa tag");
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
						String tag_movie1;
						
						tag_movie1 = (String) pack_reqs.getInformation(0);
						MovieInformation movieslists = getMovies(tag_movie1);
						client_information.addMoiveHistory(movieslists);
                                                pack_reqs.setCode(Constants.DOWNLOAD_REP);
                                                pack_reqs.addInformation(client_information.getMyMovies());
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
		System.out.println(client_information.getName()+" foi desconectado.");								
		}	
	}
	private void send_pack(Pack pack) throws IOException
	{
		ObjectOutputStream out;
		out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(pack);
	}
	
	private ArrayList<MovieInformation> searchMovies(String tag_movie)
	{
		
		ArrayList<MovieInformation> list = new ArrayList<MovieInformation>();
		for(MovieInformation movies:this.moviesInformation)
		{
			ArrayList<String> x = movies.getTags_file();
			for(String y:x)
			{
				if(y.equals(tag_movie))
                                   list.add(movies);
			}
                      
		}
                
		return list;
	}
	private MovieInformation getMovies(String tag_movie)
	{
		
		MovieInformation list = null;
		for(MovieInformation movies:this.moviesInformation)
		{
			String x = movies.getName_file();
			
				if(x.equals(tag_movie))
					list = movies;
		}
                
		return list;
	}
	
	public void setDatas(ArrayList<ClientInformation> x, ArrayList<MovieInformation> y)
	{
		this.clients = x;
		this.moviesInformation = y;
	}
}
>>>>>>> THEIRS
=======
package uefs.redes.servidorAcesso;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.Clock;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import uefs.redes.define.Constants;
import uefs.redes.define.Pack;
import uefs.redes.model.ClientInformation;
import uefs.redes.model.MovieInformation;

public class ServerAcess implements Runnable{

	private ClientInformation client_information = null;
	private Socket socket;
	@SuppressWarnings("unused")
	private ArrayList<MovieInformation> moviesInformation = new ArrayList<MovieInformation>();
	private ArrayList<ClientInformation> clients = new  ArrayList<ClientInformation>();

	public ServerAcess(Socket sock) throws IOException
	{
		this.socket = sock;
	}
	@Override
	public void run()
	{
			
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
						//System.out.println("login-REQ");
						//
						 name = (String)pack_reqs.getInformation(0);
						 pass = (String)pack_reqs.getInformation(1);
						
						 
						
						for(ClientInformation xClient:this.clients)
						{
							if(xClient.getLogin().equals(name))
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
							pack_reqs.addInformation(moviesInformation);
							pack_reqs.addInformation(Constants.MESSAGE_INFORMATION+"Login.");
						}
						else{
							pack_reqs = new Pack(Constants.LOGIN_RER);
							pack_reqs.addInformation(Constants.MESSAGE_ERROR+"Login verifique as informa��es.");
						}
						// CODIGO 
						this.send_pack(pack_reqs);
						break;
					case Constants.LOGOUT_REQ:
						
						pack_reqs.setCode(Constants.LOGOUT_REP);
						pack_reqs.addInformation(Constants.MESSAGE_INFORMATION+" Logout.");
						this.send_pack(pack_reqs);
                                                socket.close();
						break;
					case Constants.REGISTER_REQ:
						 
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
								
							}
							else{
								
								pack_reqs = new Pack(Constants.REGISTER_RER);
								pack_reqs.addInformation(Constants.MESSAGE_ERROR+" Cadastrado Usuário já existe.");
								
								
							}
						  // CODIGO
						 this.send_pack(pack_reqs);
						 hasClient = false;
						break;
					case Constants.SEARCH_REQ:
						String tag_movie;
						tag_movie = (String)pack_reqs.getInformation(0);
						//System.out.println(tag_movie);
						
						ArrayList<MovieInformation> movieslist = searchMovies(tag_movie);
                                                
							if(movieslist.isEmpty())
							{
								pack_reqs = new Pack(Constants.SEARCH_RER);
								pack_reqs.addInformation(Constants.MESSAGE_ERROR+"Search n�o h� videos com essa tag");
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
						String tag_movie1;
						
						tag_movie1 = (String) pack_reqs.getInformation(0);
						MovieInformation movieslists = getMovies(tag_movie1);
						client_information.addMoiveHistory(movieslists);
                                                pack_reqs.setCode(Constants.DOWNLOAD_REP);
                                                pack_reqs.addInformation(client_information.getMyMovies());
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
		System.out.println(client_information.getName()+" foi desconectado.");								
		}	
	}
	private void send_pack(Pack pack) throws IOException
	{
		ObjectOutputStream out;
		out = new ObjectOutputStream(socket.getOutputStream());
		out.writeObject(pack);
	}
	
	private ArrayList<MovieInformation> searchMovies(String tag_movie)
	{
		
		ArrayList<MovieInformation> list = new ArrayList<MovieInformation>();
		for(MovieInformation movies:this.moviesInformation)
		{
			ArrayList<String> x = movies.getTags_file();
			for(String y:x)
			{
				if(y.equals(tag_movie))
                                   list.add(movies);
			}
                      
		}
                
		return list;
	}
	private MovieInformation getMovies(String tag_movie)
	{
		
		MovieInformation list = null;
		for(MovieInformation movies:this.moviesInformation)
		{
			String x = movies.getName_file();
			
				if(x.equals(tag_movie))
					list = movies;
		}
                
		return list;
	}
	
	public void setDatas(ArrayList<ClientInformation> x, ArrayList<MovieInformation> y)
	{
		this.clients = x;
		this.moviesInformation = y;
	}
}
>>>>>>> parent of 997e155... A porra toda FUNCIONANDO só falta o teu bagui mulek
