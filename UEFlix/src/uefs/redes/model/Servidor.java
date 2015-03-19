package uefs.redes.model;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Servidor implements Runnable{

	
	private Socket socket;
	
	public Servidor(Socket s) throws IOException
	{
		this.socket = s;

	}
	
	@Override
	public void run()											//	(IMPLEMENTED FROM THE RUNNABLE INTERFACE)
	{
		try	
		{
			ObjectInputStream in;
			in =  new  ObjectInputStream(socket.getInputStream());
			do
			{
				String x = (String) in.readObject();
				System.out.println(x+" OK");
			}
			while(socket !=null);
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();								
		}	
	}

}
