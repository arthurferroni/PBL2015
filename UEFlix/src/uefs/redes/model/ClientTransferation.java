package uefs.redes.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import uefs.redes.exceptions.DownloadSucessException;

public class ClientTransferation {

    private Socket sockServer;

    public ClientTransferation(Socket s) {
        sockServer = s;
    }

    public void getFileFromServeR(String name) throws DownloadSucessException  {

        FileOutputStream fos = null;
        InputStream is = null;

        try {
            // Criando conex�o com o servidor
            System.out.println("Conectando com Servidor porta 13267");

            is = sockServer.getInputStream();

            // Cria arquivo local no cliente
            String x = new File("").getAbsolutePath();
            fos = new FileOutputStream(new File(x + "\\clientmovie\\" + name + ".mp4"));

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
                throw new DownloadSucessException();
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

    public void getFileFromeServerImage(String name) {

        FileOutputStream fos = null;
        InputStream is = null;

        try {
            // Criando conex�o com o servidor
            System.out.println("Conectando com Servidor porta 13267");

            is = sockServer.getInputStream();

            // Cria arquivo local no cliente
            String x = new File("").getAbsolutePath();
            fos = new FileOutputStream(new File(x + "\\clientpicture\\" + name + ".png"));

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
