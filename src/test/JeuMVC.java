package test;
import model.*;
import java.io.*;
import controller.*;
import vue.*;

public class JeuMVC {
	public JeuMVC() throws ArithmeticException, IOException {
		Jeu model = new Jeu();
		JeuController ctrl =new JeuController(model);
		JeuVueConsole console = new JeuVueConsole(model,ctrl);
		ctrl.addView(console);
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
