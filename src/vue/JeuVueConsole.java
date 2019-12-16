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
		//initMotus(); 
	}
	
	public void initMotus() throws IOException {
		affiche("*********************BIENVENUE DANS LE JEU MOTUS***********************\n");
		affiche("\tVeuillez entrer votre pseudo");
		Scanner sc = new Scanner(System.in);
		model.getJoueur().setPseudo(sc.nextLine());
		affiche("\nC'est Parti "+model.getJoueur().getPseudo()+"!");
		do {
		this.deroulement();
		affiche("Voulez-vous reessayer ? O/N ");
		rep=sc.nextLine();
		model.getJoueur().setEssaisRestants(5);
		}while(rep.equals("O") || rep.equals("o"));
	}
	
	/**
	 * Cette methode generalise le deroulement de la partie pour un joueur pour l'instant.
	 * @throws IOException 
	 */
	public void deroulement() throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean length = false;
		model.genererMotCorrect();
		model.updateActuel();
		do {
			affiche("Mot à deviner : "+ model.getMotActuel()+" ("+model.getMotCorrect().getLongueur()+" lettres )");
			affiche("Il vous reste "+model.getJoueur().getEssaisRestants()+" essais");
			
			do{
				String n = new String();
				affiche("Votre proposition : ");
				n=sc.nextLine();
				length = ctrl.setProposition(n);
			}while(length==false);
			
			ctrl.traitementPropo(new Mot(model.getProposition()));
			
		}while(model.getJoueur().getEssaisRestants()>0 && model.isMotTrouve()!=true);
			if(model.isMotTrouve()==false)
			affiche("Dommage,le mot à trouver était "+model.getMotCorrect().getValeur());
	}
	public void update(Observable o, Object arg) {
	
	}
	public void affiche(String s) {
		System.out.println(s);
	}

	@Override
	public void enableWarning() {
		affiche("Entrez un mot de 5 lettres");
	}

	@Override
	public void disableWarning() {
		// TODO Auto-generated method stub
		
	}
}
