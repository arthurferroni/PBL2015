package uefs.redes.controller;

import java.io.IOException;
import java.util.Scanner;

public class Main2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ControllerClient x = new ControllerClient();
		x.connect();
		
		System.out.println("ok");
		Scanner c = new Scanner(System.in);
		x.register("Arthur", "Arthur-LOGINs", "Arthur-PASS");
		
		//x.register("Arthur", "Arthur-LOGIN", "Arthur-PASS");
		//x.register("Arthur", "Arthur-LOGIN", "Arthur-PASS");
		x.login("Arthur-LOGINs","Arthur-PASS");
		//x.logout();
		//x.register("Arthur", "Arthur-LOGIN", "Arthur-PASS");
		 // x.search("tag1");
		//  System.out.println("s");
		//  x.search("tags1");
		//	x.donwload_movie("ss", "s");
		
		//
		
	}

}
