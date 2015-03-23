package uefs.redes.transporte;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientTransfer {
	private Socket sockServer;
	
	public ClientTransfer (Socket s)
	{
		sockServer = s;
	}

	public  void getFileFromServeR() {
		
		FileOutputStream fos = null;
		InputStream is = null;

		try {
			// Criando conex�o com o servidor
			System.out.println("Conectando com Servidor porta 13267");
			
			is = sockServer.getInputStream();

			// Cria arquivo local no cliente
			fos = new FileOutputStream(new File("c:\\Teste1\\they.avi"));
			System.out.println("Arquivo Local Criado c:\\temp\\source-copy.zip");
			
			// Prepara variaveis para transferencia
			byte[] cbuffer = new byte[1024];
			int bytesRead;

			// Copia conteudo do canal
			System.out.println("Recebendo arquivo...");
			while ((bytesRead = is.read(cbuffer)) != -1) {
				fos.write(cbuffer, 0, bytesRead);
				fos.flush();
			}
			
			System.out.println("Arquivo recebido!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sockServer != null) {
				try {
					sockServer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			if (is != null) {
				try {
					is.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}