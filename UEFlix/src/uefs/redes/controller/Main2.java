package uefs.redes.controller;

import java.io.IOException;
import java.util.Scanner;

import uefs.redes.exceptions.LoginFailException;
import uefs.redes.exceptions.LoginSucessException;

public class Main2 {

	@SuppressWarnings("unused")
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		ControllerClient x = new ControllerClient();
		x.connect();
		
		System.out.println("ok");
		Scanner c = new Scanner(System.in);
		
		
		//x.register("Arthur", "Arthur-LOGIN", "Arthur-PASS");
     
                //x.register("Arthur", "Arthur-LOGIN", "Arthur-PASS");
                try {
					x.login("Arthur-LOGIN","Arthur-PASS");
				} catch (IOException | InterruptedException
						| LoginSucessException | LoginFailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                //x.logout();
                //x.register("Arthur", "Arthur-LOGIN", "Arthur-PASS");
                // x.search("tag1");
                //  System.out.println("s");
                //  x.search("tags1");
                //	x.donwload_movie("ss", "s");
                
                //
           
		
	}

}
