package uefs.redes.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import uefs.redes.define.Constants;
import uefs.redes.define.Pack;
import uefs.redes.model.Cliente;

public class ControllerCliente {
	
	private Cliente cliente;
	private Socket socket_cliente ;
	private ArrayList<Object>filmes = new  ArrayList();
	private ArrayList<Object>historico = new  ArrayList();
	
	
	
	public void conectar() throws UnknownHostException, IOException
	{
		this.socket_cliente = new Socket (Constants.HOST,Constants.PORT);
		cliente = new Cliente(this.socket_cliente);
		Thread y = new Thread(cliente);
		y.start();
	}
	
	public void enviar(Pack pacote) throws IOException, InterruptedException
	{
		ObjectOutputStream out = new ObjectOutputStream(socket_cliente.getOutputStream());
		out.writeObject(pacote);
		out.flush();
		//Thread.sleep(1000);
	}
	public void login(String nome, String senha) throws IOException, InterruptedException
	{
		Pack login_reqs = new Pack(Constants.LOGIN_REQ);
		login_reqs.addOneByOne(nome);
		login_reqs.addOneByOne(senha);
		this.enviar(login_reqs);
	}
	public void buscar()
	{
		
	}
	public void logout()
	{
		
	}
	
}
