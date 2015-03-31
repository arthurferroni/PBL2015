package uefs.redes.application;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfxtras.scene.SceneToJComponent;

public class PlayMovie extends JFrame {
	
	public static JTextField tf = new JTextField("JavaFX for SWING");
	
	public PlayMovie() {
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);  
	    setTitle("JavaFX in SWING Test");  
	  
	    Container container = getContentPane();  
	    container.setLayout(new BorderLayout());  
	  
	    String sceneClass = "uefs.redes.application.MovieScreen";  
	    JComponent myScene = SceneToJComponent.loadScene(sceneClass);  
	  
	    JLabel label = new JLabel(" Below is a JavaFX Animation: ");  
	    container.add(label, BorderLayout.NORTH);  
	    container.add(myScene, BorderLayout.CENTER);  
	  
	    JPanel p = new JPanel();  
	    p.setLayout(new FlowLayout());  
	  
	    tf.setColumns(28);  
	    p.add(tf);  
	    p.add(new JButton("SWING Button"));  
	  
	    container.add(p, BorderLayout.SOUTH);  
	    pack();  
	}
	
	public static void main(String args[]) {  
	    java.awt.EventQueue.invokeLater(  
	      new Runnable() {  
	        public void run() {  
	          new PlayMovie().setVisible(true);  
	        }  
	      });  
	  }  

}
