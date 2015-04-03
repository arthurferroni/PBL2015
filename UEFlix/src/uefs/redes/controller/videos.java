package uefs.redes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class videos {

	public static void main(String[] args) {
		ControllerServers x = new ControllerServers();
		
               // String name, ArrayList< String > tags, String description,int quantity,String category
                String xs;
                ArrayList<String> x1 = new ArrayList<String>();
                
                x1.add("BATMAN");
                x1.add("SUPERMAN");
                
                x1.add("BATMAN CONTRA SUPERMAN");
                x1.add("CONTRA");
                x1.add("ACAO");
                 x1.add("AÇÃO");
                xs = "Batman v Superman: Dawn of Justice é um vindouro filme americano baseado nos personagens Superman, Batman e Mulher-Maravilha da DC Comics. É a sequência do filme Man of Steel e o segundo filme do Universo Cinematográfico DC.";
                x.addMovies("Batman_Contra_Superman", x1, xs, 1, "Ação");
                
                x1 = new ArrayList<String>();
                x1.add("CAPITÃO");
                x1.add("CAPITAO");
                x1.add("PLANETA");
                
                x1.add("CAPITAO PLANETA");
                
                x1.add("ACAO");
                    x1.add("AÇÃO");
                
                xs = "Capitão Planeta é um super-herói criado no começo dos anos 1990 pelo empresário americano Ted Turner como uma forma de alerta e interação para com seus telespectadores, que em sua maioria são crianças e adolescentes.";
                x.addMovies("Captain_Planet", x1, xs, 1, "Ação");
               
                x1 = new ArrayList<String>();
                x1.add("DRAGON");
                x1.add("BALL");
                x1.add("Z");
                
                x1.add("DRAGON BALL");
                x1.add("BALL Z");
                
                x1.add("DRAGON BALL Z");
                               
                x1.add("ACAO");
                    x1.add("AÇÃO");
                xs = "Dragon Ball Z é uma série de anime produzida pela Toei Animation Baseada na série de mangá Dragon Ball escrita por Akira Toriyama.";
                x.addMovies("DragonBallZ",  x1, xs, 1, "Ação");
               
                x1 = new ArrayList<String>();
                x1.add("FAST");
                x1.add("FURIOUS");
                x1.add("7");
                x1.add("FAST AND FURIOUS");
                x1.add("FAST AND FURIOUS 7");
                
                x1.add("VELOZES");
                x1.add("FURIOSOS");
                x1.add("VELOZES E FURIOSOS");
                x1.add("VELOZES E FURIOSOS 7");
             
                               
                x1.add("ACAO");
                    x1.add("AÇÃO");
                
                
                xs = "Após os acontecimentos em Londres, Dom (Vin Diesel), Brian (Paul Walker), Letty (Michelle Rodriguez) e o resto da equipe tiveram a chance de voltar para os Estados Unidos e recomeçarem suas vidas. Mas a tranquilidade do grupo é destruída quando Ian Shaw (Jason Statham), um assassino profissional, quer vingança pela morte de seu irmão. Agora, a equipe tem que se reunir para impedir este novo vilão. Mas dessa vez, não é só sobre ser veloz. A luta é pela sobrevivência.";
                x.addMovies("Fast_E_Furious_7", x1, xs, 1, "Ação");   
               x1 = new ArrayList<String>();
                x1.add("VINGADORES");
                x1.add("ERA");
                x1.add("ULTRON");
                x1.add("VINGADORES ERA DE ULTRON");
                
                x1.add("AVENGERS");
                x1.add("AGE");
                x1.add("AVENGERES AGE OF ULTRON");
                
                
                x1.add("ACAO");
                    x1.add("AÇÃO");
                xs = "Sequência do sucesso \"Os Vingadores\", que reúne mais uma vez a equipe de super-heróis formada por Capitão América (Chris Evans), Homem de Ferro (Robert Downey Jr.), Thor (Chris Hemsworth), Hulk (Mark Ruffalo), Viúva Negra (Scarlett Johansson) e Gavião Arqueiro (Jeremy Renner).";
		x.addMovies("Vingadores_Era_de_Ultron", x1, xs, 1, "Ação");   
		
                
            try {
                x.save_movies();
            } catch (SecurityException ex) {
                Logger.getLogger(videos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(videos.class.getName()).log(Level.SEVERE, null, ex);
            }
		

	}

}
