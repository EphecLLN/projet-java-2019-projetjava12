package vue;

import java.io.IOException;
import java.util.*;
import model.*;
import controller.*;

public class JeuVueConsole extends JeuVue implements Observer {
	//implementer la vue console 
	private Scanner sc;
	
	public JeuVueConsole(Jeu model, JeuController controller) throws ArithmeticException, IOException {
		super(model, controller);
		affiche("*********************BIENVENUE DANS LE JEU MOTUS***********************\n");
		affiche("\tVeuillez entrer votre pseudo");
		update(null, null);
		sc = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}
	private class ReadInput implements Runnable{
		public void run() {
			while(true){
				try{
					String c = sc.nextLine();
					model.getJoueur().setPseudo(c);
					affiche("\nC'est Parti "+model.getJoueur().getPseudo()+"!");
					String rep=" ";
					do {
						deroulement();
						affiche("Voulez-vous reessayer ? O/N ");
						rep=sc.nextLine();
						model.getJoueur().setEssaisRestants(5);
					}while(rep.equals("O") || rep.equals("o"));
				}
				catch(InputMismatchException e){
					affiche("Format d'input incorrect");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Cette methode generalise le deroulement de la partie pour un joueur pour l'instant.
	 * @throws IOException 
	 */
	public void deroulement() throws IOException {
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
			else 
				affiche("Bravo vous avez trouvé le mot.");
	}
	public void update(Observable o, Object arg) {
	
	}
	public void affiche(String s) {
		System.out.println(s);
	}

}
