package vue;

import java.io.IOException;
import java.util.*;
import model.*;
import controller.*;

public class JeuVueConsole extends JeuVue implements Observer {
	//implementer la vue console
	private int cpt;
	public JeuVueConsole(Jeu model, JeuController controller) throws ArithmeticException, IOException {
		super(model, controller);
		initMotus();
	}
	/*private class ReadInput implements Runnable{
		public void run() {
			while(true){
				try{
					String c = sc.next();
					if(c.length()!=1){
						affiche("Format d'input incorrect");
						printHelp();
					}
						
					int i = sc.nextInt();
					if(i<0 || i> 9){
						affiche("Numéro du livre incorrect");
						printHelp(); 
					}
					switch(c){
						case "R" :
							controller.rendreLivre(i);
							break;
						case "E" : 
							controller.emprunteLivre(i);
							break;
						default : 
							affiche("Opération incorrecte");
							printHelp();
					}
				}
				catch(InputMismatchException e){
					affiche("Format d'input incorrect");
					printHelp();
				}
				System.out.println("\tVeuillez entrer votre pseudo");
		Scanner sc = new Scanner(System.in);
		joueur1.setPseudo(sc.nextLine());
		System.out.println("C'est Parti "+joueur1.getPseudo()+"!");
			}
		}
	}*/
	public void initMotus() throws IOException {
		affiche("*********************BIENVENUE DANS LE JEU MOTUS***********************\n");
		affiche("\tVeuillez entrer votre pseudo");
		Scanner sc = new Scanner(System.in);
		ctrl.setPseudo(sc.nextLine());
		affiche("C'est Parti "+ctrl.getPseudo()+"!");
		ctrl.genererMotCorrect();
		ctrl.setMotActuel();
		this.deroulement();
	}
	/**
	 * Cette methode generalise le deroulement de la partie pour un joueur pour l'instant.
	 * @throws IOException 
	 */
	public void deroulement() throws IOException {
		Scanner sc = new Scanner(System.in);
		cpt=ctrl.getEssaisRestants();
		do {
			affiche("Mot à deviner : "+ ctrl.getMotActuel()+" ("+ctrl.getMotCorrect().getLongueur()+" lettres )");
			affiche("Il vous reste "+ctrl.getEssaisRestants()+" essais");
			affiche("Votre proposition : ");
			ctrl.setProposition(sc.nextLine());
			ctrl.TraitementPropo(ctrl.getProposition());
			ctrl.setEssaisRestants(cpt);
		}while(ctrl.getEssaisRestants()>0 && ctrl.isTrouve()!=true);		
		if(ctrl.isTrouve()==false)
			affiche("Dommage,le mot a trouvé était "+ctrl.getMotCorrect().getValeur());
	}
	public void update(Observable o, Object arg) {
		Jeu p = (Jeu) o;
		affiche(p.toString());
	}
	public void affiche(String s) {
		System.out.println(s);
	}
}
