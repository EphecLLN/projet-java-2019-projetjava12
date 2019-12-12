package controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.*;
import vue.*;

public class JeuController {
	Jeu model;
	JeuVue view;
	
	public JeuController(Jeu model) {
		this.model=model;
	}
	
	
	
	public void TraitementPropo(Mot mot) {
		try {
			model.TraitementProposition(mot);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void setProposition(String s) {
		this.model.getJoueur().setProposition(new Mot(s));
	}
	public Mot getProposition() {
		return this.model.getJoueur().proposerMot();
	}
	public int getLongueurMot() {
		return model.getMotCorrect().getLongueur();
	}
	public void setPseudo(String s) {
		this.model.getJoueur().setPseudo(s);
	}
	public String getMotActuel() {
		return this.model.getMotActuel();
	}
	public String getPseudo() {
		return model.getJoueur().getPseudo();
	}
	public void setMotActuel() {
		this.model.setMotActuel();
	}
	public void genererMotCorrect() {
		model.genererMotCorrect();
	}
	public Mot getMotCorrect() {
		return model.getMotCorrect();
	}
	public int getEssaisRestants() {
		return model.getJoueur().getEssaisRestants();
	}
	public void setEssaisRestants(int i) {
		model.getJoueur().setEssaisRestants(i);
	}
	public boolean isTrouve() {
		return model.isMotTrouve();
	}
	public void addView(JeuVue view) {
		this.view=view;
	}

	@Override
	public String toString() {
		return model.toString();
	}
	
}
