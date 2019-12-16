package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.*;
import vue.*;

//notre controleur ici se charge de verifier que le mot proposer est bien conforme à nos spécifications
public class JeuController {
	Jeu model;
	JeuVue view;
	
	public JeuController(Jeu model) {
		this.model=model;
	}
	
	public boolean traitementPropo(Mot mot) throws IOException {
			return model.TraitementProposition(mot);
	}
	public void updateMotActuel() {
		model.updateActuel();
	}
	private boolean testerSaisie(String s){
		boolean bonneLongueur=false;
		
		if(s.length()!=5)
			bonneLongueur=false;
		else
		{
			boolean isChar=true;
			int pos=0;
		while(pos < 5 && isChar)
		{
			isChar=Character.isLetter(s.charAt(pos)); 
			pos++;
		}
			bonneLongueur=isChar;
		}	
		return bonneLongueur ;
	}
	
	public boolean setProposition(String s) {
		boolean prop=false;
		
			if(this.testerSaisie(s)==false) {
				view.affiche("Entrez un mot de 5 lettres");
				}
			else {
				model.setProposition(s);
				prop=true;
			}
			
			return prop;
	}
	public void addView(JeuVue view) {
		this.view=view;
	}
	@Override
	public String toString() {
		return model.toString();
	}
	
}
