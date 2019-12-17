package vue;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import test.JeuMVC;

public class MenuPrincipal {
	private JFrame ecran;
	private JButton bouton;
	private JButton bouton2;
	private JButton boutonExit;
	private JPanel panneau;
	private ImageIcon icone;
	private JLabel image;
	private JLabel label;
	private JLabel label2;
	
	public String nom;

	
	public MenuPrincipal (){
		gui();
	}
	
	public void gui() {
		/*Création de l'écran principal*/
		ecran = new JFrame("Menu Principal");
        ecran.setSize(1280,720);
        ecran.setResizable(false);
        ecran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Création du pannel de bouttons*/
        panneau = new JPanel();
        
        /*Création des boutons de naviguation*/
        bouton = new JButton("1 Joueur !");
        label = new JLabel("Voulez-vous jouer en Solitaire ?");
        bouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] difficulte = {"Facile", "Moyen", "Difficile"};
        	    JOptionPane jop12 = new JOptionPane(), jop22 = new JOptionPane();
        	    int rang = jop12.showOptionDialog(null, 
        	      "Choisissez votre Niveau de difficulté !",
        	      "Choix du Niveau !",
        	      JOptionPane.YES_NO_CANCEL_OPTION,
        	      JOptionPane.QUESTION_MESSAGE,
        	      null,
        	      difficulte,
        	      difficulte[2]);
        	    jop22.showMessageDialog(null, "Votre niveau de difficulté est " + difficulte[rang], "Choix Niveau", JOptionPane.INFORMATION_MESSAGE);
				try {
					new  JeuMVC();
				} catch (ArithmeticException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ecran.setVisible(false);
				/*Boite de Dialogue demandant le pseudo du joueur*/
				JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
				nom = jop.showInputDialog(null, "Choisissez un pseudo !", "Choix Pseudo", JOptionPane.QUESTION_MESSAGE);
				jop2.showMessageDialog(null, "Votre pseudo est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);
			}
		});
        
        bouton2 = new JButton("2 Joueurs !");
        label2 = new JLabel("Voulez-vous jouer en Multijoueur ?");
        bouton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] difficulte = {"Facile", "Moyen", "Difficile"};
        	    JOptionPane jop12 = new JOptionPane(), jop22 = new JOptionPane();
        	    int rang = jop12.showOptionDialog(null, 
        	      "Choisissez votre Niveau de difficulté !",
        	      "Choix du Niveau !",
        	      JOptionPane.YES_NO_CANCEL_OPTION,
        	      JOptionPane.QUESTION_MESSAGE,
        	      null,
        	      difficulte,
        	      difficulte[2]);
        	    jop22.showMessageDialog(null, "Votre niveau de difficulté est " + difficulte[rang], "Choix Niveau", JOptionPane.INFORMATION_MESSAGE);
				
				try {
					new  JeuMVC();
				} catch (ArithmeticException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ecran.setVisible(false);
				JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
				nom = jop.showInputDialog(null, "Choisissez un pseudo !", "Choix Pseudo", JOptionPane.QUESTION_MESSAGE);
				jop2.showMessageDialog(null, "Votre pseudo est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);
			}
		});
        
        boutonExit = new JButton("Quitter le jeu !");
        boutonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
  
        /*Ajout des boutons au pannel ainsi que leur étiquette*/
        panneau.add(bouton);
        panneau.add(label);
        panneau.add(bouton2);
        panneau.add(label2);
        panneau.add(boutonExit);

        /*Mise en place du pannel sur le bas de l'écran*/ 
        ecran.add(panneau, BorderLayout.SOUTH); 
        
        /*Mise à l'échelle de l'image*/
        icone = new ImageIcon("Image/motus.jpg");
        Image backgroundMotus = icone.getImage();
        Image backgroundMotusModif = backgroundMotus.getScaledInstance(1280, 700, java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(backgroundMotusModif);
        
        /*Ajout de l'image sur la frame*/
        image = new JLabel(icone);
        ecran.add(image);
        ecran.setVisible(true);
        ecran.setLocationRelativeTo( null );
	}
	
    public static void main(String[] args) {

    	new MenuPrincipal();
    	
    }
}