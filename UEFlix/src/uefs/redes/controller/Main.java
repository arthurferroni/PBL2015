package uefs.redes.controller;

import java.io.File;
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ControllerServers y = new ControllerServers();
		y.load_movies();
		y.start_server_acess();
		
		
		
	}

}
