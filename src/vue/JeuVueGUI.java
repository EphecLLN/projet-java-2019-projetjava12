package vue;

import model.*;
import controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class JeuVueGUI extends JeuVue implements Observer,ActionListener{

	public JeuVueGUI(Jeu model, JeuController ctrl) {
		super(model, ctrl);
		this.fenetre();
		//this.refresh();
	}
	//la vueGui utilise notre paneau et une JFrame
	private Panneau pane = new Panneau();
	private JFrame frame = new JFrame();
	
	//methode  qui initialise la fenetre en y ajoutant notre paneau
	public void fenetre() {
		frame.setTitle("MOTUS");
		frame.setSize(750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		model.genererMotCorrect();
		pane.setMot(model.getMotCorrect().getValeur());
		frame.setContentPane(pane);
		frame.setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
	}

	@Override
	public void affiche(String s) {
		pane.setlblMessage(s);
	}
	//c'est à ce niveau que j'ai des soucis pour l'instant
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean length = false;
		if(e.getActionCommand().equals("OK")) {
		do{
			String n = pane.getTxt();
			length = ctrl.setProposition(n);
		}while(length==false);
		}
	}
	//suivant un exemple de la prof mais pas encore implementé
	@Override
	public void enableWarning() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void disableWarning() {
		// TODO Auto-generated method stub
		
	}
	
}
