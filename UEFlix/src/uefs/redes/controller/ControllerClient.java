package uefs.redes.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import uefs.redes.define.Constants;
import uefs.redes.define.Pack;
import uefs.redes.model.ClientAcess;
import uefs.redes.model.ClientTransferation;

public class ControllerClient {
	
	private ClientAcess client_acess;
	private Socket client_socket ;
	
	public void connect() throws UnknownHostException, IOException
	{
		this.client_socket = new Socket (Constants.HOST,Constants.PORT_ACESS);
		client_acess = new ClientAcess(this.client_socket,this);
		
		Thread threadClient = new Thread(client_acess);
		threadClient.start();
	}
	public void send_pack(Object pack) throws IOException, InterruptedException
	{
		ObjectOutputStream out = new ObjectOutputStream(client_socket.getOutputStream());
		out.writeObject(pack);
		out.flush();
		
	}
	public void login(String name, String password) throws IOException, InterruptedException
	{
		Pack login_pack = new Pack(Constants.LOGIN_REQ);
		
		login_pack.addInformation(name);
		login_pack.addInformation(password);
		this.send_pack(login_pack);
	}
	public void search(String datagrams) throws IOException, InterruptedException
	{
		Pack search_pack = new Pack(Constants.SEARCH_REQ);
		
		search_pack.addInformation(datagrams);
		
		this.send_pack(search_pack);
	}
	public void logout(String login) throws IOException, InterruptedException
	{
		Pack logout_pack = new Pack(Constants.LOGOUT_REQ);
		logout_pack.addInformation(login);
		this.send_pack(logout_pack);
	}
	public void watch_movie() throws UnknownHostException, IOException, InterruptedException
	{
		Pack download_pack = new Pack(Constants.DOWNLOAD_REQ);
		
		ClientTransferation client_channel = send_pack_file(download_pack);
		
		client_channel.getFileFromServeR();
	}
	public ClientTransferation send_pack_file(Object pack) throws IOException, InterruptedException
	{
		Socket client_socket_file = new Socket(Constants.HOST,Constants.PORT_FILE);
		
		ClientTransferation client_channel= new ClientTransferation(client_socket_file);		
		ObjectOutputStream out = new ObjectOutputStream(client_socket_file.getOutputStream());
		
		out.writeObject(pack);
		out.flush();
		
		return client_channel;
	}
	public void register(String name, String login, String password) throws IOException, InterruptedException
	{
		Pack register_pack = new Pack(Constants.REGISTER_REQ);
		register_pack.addInformation(name);
		register_pack.addInformation(login);
		// codigo para encryp
		register_pack.addInformation(password);
		this.send_pack(register_pack);
	}


}
