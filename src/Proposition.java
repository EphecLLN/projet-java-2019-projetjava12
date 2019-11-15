package model;

/** 
 *Proposition est la classe permettant de choisir ou vérifier notre mot.
 *@author Projet Java Groupe 12 (Souhaïb Azzouz)
 */
public class Proposition {
	
	protected Mot motCorrect;
	private String [] lettresActuelles;
	
	public Proposition(String valeur,String motCorrect){
		super(valeur);
		this.motCorrect.setValeur(motCorrect);
	}
	
	/**
	 * Cette methode compte le nombre d'occurences d'une lettre dans un tableau de chaines de caracteres.
	 * @param l la lettre
	 * @param tab le tableau de chaines caracteres.
	 * @return le nombre d'occurences du string s dans le tableau a.
	 **/
	public int compterOccurences(String l, String[] tab) {
		int count = 0;
		for(int i =0; i < tab.length; i ++) {
			if(l.equals(tab[i])) {
				count++;
			}
		}
		return count;
	}
	
	public Proposition() {
		super();
	}
		
	/**
	 * Cette methode determine si le mot propose est equivalent au mot a  trouver
	 * @param m le mot que le joueur propose
	 * @return true s'il a trouve la bonne reponse et false sinon
	 */
	public boolean traiterReponse(Mot m){
		if(m.getValeur().equals("")) {
			pseudo.setErreur(true);
			return false;
		}
		else if(m.getValeur().equals(motCorrect.getValeur())) {
			pseudo.pointsPlus();
			return true;
		}
		else {
			pseudo.setErreur(true);
		}
		return false;
		
	}
	
	
	/**
	 * Cette methode traite la proposition du joueur et met a jour le string,
	 * important pour que le joueur voit l'evolution du mot en fonction de ces proposition.
	 * @param mot le mot du joueur 
	 */
	public void checkLettres(Mot mot) {
		String s = mot.getValeur(); 
		String m = motCorrect.getValeur();
		String lettres[] = s.split("");
		String lettresATrouver [] = m.split("");
		for(int i = 0; i < lettres.length ; i++) {
			if(m.contains(lettres[i])) {
				int occ1 = compterOccurences(lettres[i], lettresActuelles);
				int occ2 = compterOccurences(lettres[i], lettresATrouver);
				if(lettres[i].equals(lettresATrouver[i])){
					lettresActuelles[i] = lettres[i];
					lettres[i] = "";
				}
				else if(occ2 != occ1) {
					if(lettresActuelles[i].equals("*")) {
						lettresActuelles[i]= "+";
					}
					lettres[i] = "";
				}
			}
			else {
				if((lettresActuelles[i].equals("+"))) {
					lettresActuelles[i] = "*";
					lettres[i] = "";
				}
			}
		}
	}
}
