package model;

import java.io.*;
import java.util.*;

public class Jeu extends Observable{
	
	private Joueur joueur1 = new Joueur();
	private Mot motCorrect ;
	private String motActuel ; 
	private Mot proposition;
	private char [] lettresActuelles;
	private boolean motTrouve=false;
	//Liste de mots deja joues pour ne plus proposer les memes aux joueurs
	private ArrayList<String> motDejaChoisis = new ArrayList<String>();
	/**
	 * Methode qui initialise le mot a trouver et la proposition qui sera faite a l'utilisateur
	 */
	public void genererMotCorrect() {
		Random r = new Random();
		int n = r.nextInt(448);
		while((motCorrect = new Mot(choisirMot(n))) == null && 
				motDejaChoisis.contains(motCorrect.getValeur()))
		{
			n=r.nextInt(448);
			motCorrect = new Mot(choisirMot(n));
		}
		motDejaChoisis.add(motCorrect.getValeur());
		String actuel = motCorrect.getValeur().substring(0,1);
		for(int i=1;i<motCorrect.getLongueur();i++)
			actuel += "*";
		lettresActuelles= actuel.toCharArray();
		notifyObservers();
	}
	/**
	 * Methode qui recupere un mot dans notre fichier de mots predefini
	 * @param n la ligne (aléatoire) du mot
	 * @return le mot qui devra etre deviné
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
		notifyObservers();
	}
	/**
	 * Methode qui s'occupe du traitement de la proposition faite par le joueur(pas complete pour l'instant)
	 * @param mot proposition du joueur
	 */
	public void TraitementProposition(Mot mot) throws IOException{
		if(motCorrect.getValeur().length()==mot.getLongueur()) {
			joueur1.setEssaisRestants(joueur1.getEssaisRestants()-1);
		  if(motCorrect.getValeur().equals(mot.getValeur()))
		  	{
			  setMotTrouve(true);
			  System.out.println("Bravo vous avez trouvé le mot !");
			  joueur1.addScore();
		  	}
		  else
			  traiterLettres(mot);
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
	@Override
	public String toString() {
		String s="";
		s +="Les informations de la partie sont\n";
		s += getJoueur().toString();
		return s;
	}
	public Joueur getJoueur() {
		return joueur1;
	}
	public void setJoueur(Joueur j1) {
		this.joueur1 = j1;
	}
	public Mot getProposition() {
		return proposition;
	}
	public void setProposition(Mot proposition) {
		this.proposition = proposition;
	}
	public Mot getMotCorrect() {
		return motCorrect;
	}
	public void setMotCorrect(Mot motCorrect) {
		this.motCorrect = motCorrect;
	}
	public String getMotActuel() {
		return motActuel;
	}
	public void setMotActuel(String motActuel) {
		this.motActuel = motActuel;
	}
	public boolean isMotTrouve() {
		return motTrouve;
	}
	public void setMotTrouve(boolean motTrouve) {
		this.motTrouve = motTrouve;
	}
	
}
