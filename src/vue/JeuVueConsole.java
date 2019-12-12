package vue;

import java.io.IOException;
import java.util.*;
import model.*;
import controller.*;

public class JeuVueConsole extends JeuVue implements Observer {
	//implementer la vue console 
	private String rep=" ";
	public JeuVueConsole(Jeu model, JeuController controller) throws ArithmeticException, IOException {
		super(model, controller);
		initMotus();
	}
	public void initMotus() throws IOException {
		affiche("*********************BIENVENUE DANS LE JEU MOTUS***********************\n");
		affiche("\tVeuillez entrer votre pseudo");
		Scanner sc = new Scanner(System.in);
		ctrl.setPseudo(sc.nextLine());
		affiche("\nC'est Parti "+ctrl.getPseudo()+"!");
		do {
		this.deroulement();
		affiche("Voulez-vous reessayer ? O/N ");
		rep=sc.nextLine();
		ctrl.setEssaisRestants(5);
		}while(rep.equals("O") || rep.equals("o"));
	}
	/**
	 * Cette methode generalise le deroulement de la partie pour un joueur pour l'instant.
	 * @throws IOException 
	 */
	public void deroulement() throws IOException {
		Scanner sc = new Scanner(System.in);
		ctrl.genererMotCorrect();
		ctrl.setMotActuel();
		do {
			affiche("Mot à deviner : "+ ctrl.getMotActuel()+" ("+ctrl.getMotCorrect().getLongueur()+" lettres )");
			affiche("Il vous reste "+ctrl.getEssaisRestants()+" essais");
			affiche("Votre proposition : ");
			ctrl.setProposition(sc.nextLine());
			ctrl.TraitementPropo(ctrl.getProposition());
		}while(ctrl.getEssaisRestants()>0 && ctrl.isTrouve()!=true);		
		if(ctrl.isTrouve()==false)
			affiche("Dommage,le mot a trouver était "+ctrl.getMotCorrect().getValeur());
	}
	public void update(Observable o, Object arg) {
		Jeu p = (Jeu) o;
		affiche(p.toString());
	}
	public void affiche(String s) {
		System.out.println(s);
	}
}
