package uefs.redes.servidorArquivo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import uefs.redes.define.Constants;
import uefs.redes.define.Pack;

public class ServerFile implements Runnable{

	
	private Socket socket;

	public ServerFile(Socket sock) throws IOException
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
					
						case Constants.DOWNLOAD_REQ:
							//System.out.println("DONW-REQ");
							//
							String x = (String) pack_reqs.getInformation(0);
							sendMovie(x);
							// CODIGO 
							pack_reqs.setCode(Constants.DOWNLOAD_REP);
							out = new ObjectOutputStream(socket.getOutputStream());
							out.writeObject(pack_reqs);
							break;
						case Constants.DOWNLOAD_IMAGE_REQ:
							String x1 = (String) pack_reqs.getInformation(0);
							sendPictures(x1);
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
		System.out.println("Cliente desconectou.");								
		}	
	}
	
	@SuppressWarnings("unused")
	public void sendMovie(String name_file) {
		// Checa se a transferencia foi completada com sucesso
		 OutputStream socketOut = null;
		 ServerSocket servsock = null;
		 FileInputStream fileIn = null;
		

		try {
			

			// Criando tamanho de leitura
			byte[] cbuffer = new byte[1024];
			int bytesRead;

			// Criando arquivo que sera transferido pelo servidor
			String x = new File("").getAbsolutePath();
			File file = new File( x + "\\movie\\" + name_file + ".mp4");
			fileIn = new FileInputStream(file);
			//System.out.println("Lendo arquivo...");
			
			
			// Criando canal de transferencia
			socketOut = socket.getOutputStream();

			// Lendo arquivo criado e enviado para o canal de transferencia
			//System.out.println("Enviando Arquivo...");
			while ((bytesRead = fileIn.read(cbuffer)) != -1) {
				socketOut.write(cbuffer, 0, bytesRead);
				socketOut.flush();
			}

			//System.out.println("Arquivo Enviado!");
		} catch (Exception e) {
			// Mostra erro no console
			e.printStackTrace();
		} finally {
			if (socketOut != null) {
				try {
					socketOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (servsock != null) {
				try {
					servsock.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fileIn != null) {
				try {
					fileIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}



	public void sendPictures(String name_file) {
		// Checa se a transferencia foi completada com sucesso
		 OutputStream socketOut = null;
		 ServerSocket servsock = null;
		 FileInputStream fileIn = null;
		

		try {
			

			// Criando tamanho de leitura
			byte[] cbuffer = new byte[1024];
			int bytesRead;

			// Criando arquivo que sera transferido pelo servidor
			String x = new File("").getAbsolutePath();
                        
			File file = new File(x+"\\picture\\"+name_file+".png");
			fileIn = new FileInputStream(file);
			//System.out.println("Lendo arquivo...");
			
			
			// Criando canal de transferencia
			socketOut = socket.getOutputStream();

			// Lendo arquivo criado e enviado para o canal de transferencia
			//System.out.println("Enviando Arquivo...");
			while ((bytesRead = fileIn.read(cbuffer)) != -1) {
				socketOut.write(cbuffer, 0, bytesRead);
				socketOut.flush();
			}

			//System.out.println("Arquivo Enviado!");
		} catch (Exception e) {
			// Mostra erro no console
			e.printStackTrace();
		} finally {
			if (socketOut != null) {
				try {
					socketOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (servsock != null) {
				try {
					servsock.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fileIn != null) {
				try {
					fileIn.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}



}
