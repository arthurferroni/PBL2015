package s;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import uefs.redes.define.Constants;
import uefs.redes.define.Pack;

public class ServerArq implements Runnable {
	private Socket sock;
	

	public ServerArq(Socket s){
		sock = s;
	}
	
	public void run()
	{
		try	
		{
			Pack x ;
			ObjectInputStream in;
			ObjectOutputStream out;
			do
			{
				
					in =  new  ObjectInputStream(sock.getInputStream());
					 x = (Pack) in.readObject();
	
					FileInputStream fileIn;
					OutputStream socketOut;
					switch(x.getCODE()) {
					case Constants.DOWNLOAD_REQ:
						
			            // Criando tamanho de leitura
			            byte[] cbuffer = new byte[1024];
			            int bytesRead;
			            
			            String name_file = "they";
			            // Criando arquivo que sera transferido pelo servidor
			            File file = new File("c:\\Teste\\"+name_file+".avi");
			            fileIn = new FileInputStream(file);
			            System.out.println("Lendo arquivo...");
			             
			            // Criando canal de transferencia
			            socketOut = sock.getOutputStream();
			 
			            // Lendo arquivo criado e enviado para o canal de transferencia
			            System.out.println("Enviando Arquivo...");
			            while ((bytesRead = fileIn.read(cbuffer)) != -1) {
			                socketOut.write(cbuffer, 0, bytesRead);
			                socketOut.flush();
			            }
			            
			            System.out.println("Arquivo Enviado!");
						
						// CODIGO 
						x.setCODE(Constants.DOWNLOAD_REP);
						out = new ObjectOutputStream(sock.getOutputStream());
						out.writeObject(x);
						break;
					default:
						
						break;
						
					
					}
							
			}
			while(sock.getOOBInline());
			
			
		} 
		catch (Exception e)
		{
		System.out.println("cliente desco");								
		}	
	}

}
