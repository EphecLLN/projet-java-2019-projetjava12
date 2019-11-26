package motus;

import java.io.*;
import java.util.*;

public class Jeu {
	
	private Joueur j1 = new Joueur();
	private Mot motCorrect ;
	private String motActuel ; 
	private String proposition;
	private Mot motComparaison;
	private int cpt;
	private boolean motTrouve=false;
	
	private String mots[]={"decors","glaces","vision","auteur","taille","lignes","nouees","lucide","peines","couter","accent","vaches","trente","sainte","poutre","police","saumon","minois","etroit","minees","joules","gaffes","equipe","eviter","prison","etoile","hockey","repris","migale","aimant","pierre","ardeur","alcool","nombre","confus","auteur","postes","repris","eclair","organe","ouvert","tester","pentes","tentes","traite","cartes","doutes","pistes","piston","carton","routes","calcul","tartes","mordue","cousin","freres","plaire","traces","courte","ecoles","dettes","crimes","vagues","cycles","tables","suites"};
	
	public void start() {
		System.out.println("*********************BIENVENUE DANS LE JEU MOTUS***********************\n");
		System.out.println("\t\tVeuillez entrer votre pseudo");
		Scanner sc = new Scanner(System.in);
		j1.setPseudo(sc.nextLine());
		System.out.println("C'est Parti "+j1.getPseudo()+"!");
		this.genererMotCorrect();
		//this.setMotActuel();
		System.out.println("Mot à deviner : "+ this.motActuel);
		cpt=j1.getEssaisRestants();
		this.deroulement();
	}
	/**
	 * Cette methode generalise le deroulement de la partie pour un joueur pour l'instant.
	 */
	public void deroulement() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Il vous reste "+j1.getEssaisRestants()+" essais");
			cpt--;
			j1.setEssaisRestants(cpt);
			System.out.print("Votre proposition : ");
			proposition=sc.nextLine();
			this.TraitementProposition(proposition);
		}while(j1.getEssaisRestants()>0 && motTrouve!=true);
	}
	/**
	 * Methode qui initialise le mot à trouver et la proposition qui sera faite à l'utilisateur
	 */
	public void genererMotCorrect() {
		motCorrect = new Mot(mots[3]);
		int longueur = motCorrect.getValeur().length();
		String actuel = motCorrect.getValeur().substring(0,1);
		for(int i=1;i<longueur;i++)
			actuel += "*";
		motActuel = actuel;
	}
	/*public void setMotActuel() {
		int longueur = motCorrect.getValeur().length();
		String actuel = motCorrect.getValeur().substring(0,1);
		for(int i=1;i<longueur;i++)
			actuel += "*";
		motActuel = actuel;
	}*/
	/**
	 * Methode qui s'occupe du traitement de la proposition faite par le joueur(pas complete pour l'instant)
	 * @param mot
	 */
	public void TraitementProposition(String mot) {
		motComparaison = new Mot(mot);
		if(motCorrect.getValeur().length()==mot.length()) {
		  if(motCorrect.getValeur().equals(motComparaison.getValeur()))
			  motTrouve = true;
			  System.out.println("Bravo vous avez trouvé le mot !");
		}
		else 
			System.out.println("Entrez un mot de meme longueur que le mot à trouver");
			
	}
}
