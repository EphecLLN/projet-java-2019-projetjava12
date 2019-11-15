package project;

import java.text.Normalizer;

/**
 * 
 * @author ProjetJava12 (L�on Servais)
 * @return
 */
public class mot {
	
	
	private String valeur;
	private int longueur;
	

	/**
	 * Param�tre d�faut du mot
	 * @param valeur 
	 */
	public mot(String valeur) {
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
