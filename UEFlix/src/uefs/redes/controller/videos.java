package uefs.redes.controller;

import java.io.IOException;

public class videos {

	public static void main(String[] args) {
		ControllerServers x = new ControllerServers();
		
		
			try {
				try {
					x.load_movies();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

}
