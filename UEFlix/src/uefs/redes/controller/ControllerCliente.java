package uefs.redes.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import uefs.redes.define.Constants;
import uefs.redes.model.Cliente;

public class ControllerCliente {
	
	private Cliente cliente;
	private Socket socket_cliente ;
	private ArrayList<Object>filmes = new  ArrayList();
	
	
	
	
	public void Conectar() throws UnknownHostException, IOException
	{
		this.socket_cliente = new Socket (Constants.HOST,Constants.PORT);
		cliente = new Cliente(this.socket_cliente);
		cliente.run();
		
	}
	public void Enviar() throws IOException, InterruptedException
	{
		ObjectOutputStream out = new ObjectOutputStream(socket_cliente.getOutputStream());
		out.writeObject("OLA MUNDO");
		Thread.sleep(1000);
	}
	public void Login()
	{
		
	}
	
}
