package motus;

import java.io.*;
import java.util.*;

public class Jeu {
	
	private Joueur j1 = new Joueur();
	private Mot motCorrect ;
	private String motActuel ; 
	private String proposition;
	private Mot motComparaison;
	private char [] lettresActuelles;
	private int cpt;
	private boolean motTrouve=false;
	
	/**
	 * Lancement de la partie de jeu
	 */
	public void start() {
		System.out.println("*********************BIENVENUE DANS LE JEU MOTUS***********************\n");
		System.out.println("\t\tVeuillez entrer votre pseudo");
		Scanner sc = new Scanner(System.in);
		j1.setPseudo(sc.nextLine());
		System.out.println("C'est Parti "+j1.getPseudo()+"!");
		this.genererMotCorrect();
		this.setMotActuel();
		this.deroulement();
	}
	/**
	 * Cette methode generalise le deroulement de la partie pour un joueur pour l'instant.
	 */
	public void deroulement() {
		Scanner sc = new Scanner(System.in);
		cpt=j1.getEssaisRestants();
		do {
			System.out.println("Mot à deviner : "+ this.motActuel);
			System.out.println("Il vous reste "+j1.getEssaisRestants()+" essais");
			cpt--;
			j1.setEssaisRestants(cpt);
			System.out.print("Votre proposition : ");
			proposition=sc.nextLine();
			this.TraitementProposition(proposition);
		}while(j1.getEssaisRestants()>0 && motTrouve!=true);
		if(motTrouve==false)
			System.out.println("Dommage,le mot a trouvé était "+motCorrect.getValeur());
	}
	/**
	 * Methode qui initialise le mot a trouver et la proposition qui sera faite a l'utilisateur
	 */
	public void genererMotCorrect() {
		Random r = new Random();
		int n = r.nextInt(100);
		motCorrect = new Mot(choisirMot(n));
		int longueur = motCorrect.getValeur().length();
		String actuel = motCorrect.getValeur().substring(0,1);
		for(int i=1;i<longueur;i++)
			actuel += "*";
		lettresActuelles= actuel.toCharArray();
	}
	/**
	 * Methode qui recupere un mot dans notre fichier de mots predefinis
	 * @param n la ligne (aléatoire) du mot
	 * @return le mot qui devra etre devine
	 */
	public String choisirMot(int n) {
		FileReader f = null;
		BufferedReader b =null;
		String essai=" ";
		try {
			int i = 0;
			f = new FileReader("liste-mot.txt");
			b = new BufferedReader(f);
			String mot;
			while((mot=b.readLine()) != null) {
				if(i==n) {
					essai=mot;
					mot = null;
				}
				i++;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
		try {
			if(b!=null)
			  b.close();
			if(f!=null)
				f.close();
			}
		catch (IOException e) {
			e.printStackTrace();
			}
		}
		return essai;
	}
	/**
	 * Met a jour le mot actuel en fonction des bonnes propositions faites par le joueur
	 */
	public void setMotActuel() {
		String actuel = "";
		for(int i = 0; i < lettresActuelles.length; i++) {
			actuel += lettresActuelles[i];
		}
		motActuel = actuel;
	}
	/**
	 * Methode qui s'occupe du traitement de la proposition faite par le joueur(pas complete pour l'instant)
	 * @param mot proposition du joueur
	 */
	public void TraitementProposition(String mot) {
		motComparaison = new Mot(mot);
		if(motCorrect.getValeur().length()==mot.length()) {
		  if(motCorrect.getValeur().equals(motComparaison.getValeur()))
		  	{
			  motTrouve = true;
			  System.out.println("Bravo vous avez trouvé le mot !");
			  j1.addScore();
		  	}
		  else
			  traiterLettres(motComparaison);
		  	  setMotActuel();
		}
		else 
			System.out.println("Entrez un mot de meme longueur que le mot à trouver");
			
	}
	/**
	 * Methode de traitement des lettres du mot proposées par le joueur
	 * @param mot proposition qui sera traitee
	 */
	public void traiterLettres(Mot mot) {
		String s = mot.getValeur(); 
		String m = motCorrect.getValeur();
		char lettres[] = s.toCharArray();
		char lettresATrouver [] = m.toCharArray();
		for(int i = 0; i < lettres.length ; i++) {
			if(m.indexOf(lettres[i])!=-1) {
				int occ1 = occurence(lettres[i], lettresActuelles);
				int occ2 = occurence(lettres[i], lettresATrouver);
				if(lettres[i]==(lettresATrouver[i])){
					lettresActuelles[i] = lettres[i];
					lettres[i] = ' ';
				}
				else if(occ2 != occ1) {
					if(lettresActuelles[i]=='*') {
						lettresActuelles[i]= '*';
					}
					lettres[i] = ' ';
				}
			}
		}
	}
	/**
	 * Methode qui nous donne le nombre d'occurences d'une lettre dans les chaines
	 * @param c le caractere dont on veut le nombre d'occurences
	 * @param ch la chaine de caracteres (tableau)
	 * @return le nombre d'occurences
	 */
	private  int occurence(char c,char[] ch)
	{
		int res=0;
		int i=0;
	while(i<ch.length){
		if(ch[i]==c) res++;
		i++;
	}
		return res;
	}
}
