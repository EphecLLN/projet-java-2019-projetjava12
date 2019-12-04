package vue;

import java.util.*;
import model.*;
import controller.*;

public abstract class JeuVue implements Observer {
	
	//comportement commun a toutes les vues
	protected Jeu model;
	protected JeuController ctrl;
	
	public JeuVue(Jeu model, JeuController ctrl) {
		this.model =model;
		this.ctrl=ctrl;
		model.addObserver(this);
	}
	
	public abstract void affiche(String s);
}
