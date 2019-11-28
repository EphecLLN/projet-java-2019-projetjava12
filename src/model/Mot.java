package model;

import java.text.Normalizer;

/**
 * 
 * @author ProjetJava12 (L�on Servais)
 * @return
 */
public class Mot {
	
	
	private String valeur;
	private int longueur;
	

	public int getLongueur() {
		return longueur;
	}
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}
	/**
	 * Param�tre d�faut du mot
	 * @param valeur 
	 */
	public Mot(String valeur) {
		this.valeur = valeur;
	}
	/**
	 * Attribue un mot � valeur
	 * @param valeur
	 */
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	/**
	 * 
	 * @return la valeur
	 */
	public String getValeur() {
		return valeur;
	}
		
	public static String formatMot(String valeur) {
		String  mot = Normalizer.normalize(valeur, Normalizer.Form.NFD);
		return mot.replaceAll("[^\\p{ASCII}]", "").toUpperCase();
	}
}
