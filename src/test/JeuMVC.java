package test;
import model.*;
import java.io.*;
import controller.*;
import vue.*;

public class JeuMVC {
	public JeuMVC() throws ArithmeticException, IOException {
		//creation du modele
		Jeu model = new Jeu();
		
		//les controleurs des differentes vues
		JeuController ctrlConsole =new JeuController(model);
		JeuController ctrlGUI = new JeuController(model);
		
		//les differentes vues
		JeuVueConsole console = new JeuVueConsole(model,ctrlConsole);
		JeuVueGUI gui = new JeuVueGUI(model,ctrlGUI);
		
		ctrlConsole.addView(console);
		ctrlGUI.addView(gui);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new JeuMVC();
				} catch (ArithmeticException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

}
