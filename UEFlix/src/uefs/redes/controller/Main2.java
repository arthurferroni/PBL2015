package uefs.redes.controller;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import uefs.redes.exceptions.LoginFailException;
import uefs.redes.exceptions.LoginSucessException;
import uefs.redes.exceptions.RegisterFailException;
import uefs.redes.exceptions.RegisterSucessException;
import uefs.redes.exceptions.SearchFailException;
import uefs.redes.exceptions.SearchSucessException;

public class Main2 {

	@SuppressWarnings("unused")
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		ControllerClient x = new ControllerClient();
            try {
                x.connect();
            } catch (IOException ex) {
                Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            }
		
		System.out.println("ok");
		Scanner c = new Scanner(System.in);
		
		
            try {
                x.register("Arthur", "Arthur-LOGIN", "Arthur-PASS");
            } catch (IOException ex) {
                Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RegisterSucessException ex) {
               
            } catch (RegisterFailException ex) {
               
            }
     
                //x.register("Arthur", "Arthur-LOGIN", "Arthur-PASS");
                try {
					x.login("Arthur-LOGIN","Arthur-PASS");
				} catch (IOException | InterruptedException
						| LoginSucessException | LoginFailException e) {
					// TODO Auto-generated catch block
					
				}
            try {
                //x.logout();
                //x.register("Arthur", "Arthur-LOGIN", "Arthur-PASS");
                x.search("DRAGON");
                //  System.out.println("s");
                //  x.search("tags1");
                //	x.donwload_movie("ss", "s");
                
                //
            } catch (IOException ex) {
                Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SearchSucessException ex) {
              System.out.printf("sim");
            } catch (SearchFailException ex) {
                
            }
           
		
	}

}
