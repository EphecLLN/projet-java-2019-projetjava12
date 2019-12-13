package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class viewTest {
	
	/*Ecran menu principal*/
	private JFrame ecranMenuPrincipal;
	private JButton bouton;
	private JButton bouton2;
	private JPanel panneau;
	private ImageIcon icone;
	private JLabel image;
	private JLabel label;
	private JLabel label2;
	
	
	/*Ecran Jeu*/
	private JFrame appli;
	private JPanel pannel;
	private JButton cmdOK;
	private JTextField txtMot;
	private JLabel label1;
	private JLabel labelMessage;
	private JLabel titre;
	private JLabel titre2;
	
	/*Pannel de boutons */
	private JPanel pannelBouton;
	private JButton boutonExit;
	private JButton boutonMenu;
	
	private String nom;
	
	public viewTest() {
		
		menuPrincipal();
	}
	
	/*Lancement du menu principal*/
	public void menuPrincipal() {
		ecranMenuPrincipal = new JFrame("Menu Principal");
		ecranMenuPrincipal.setSize(1280,720);
		ecranMenuPrincipal.setResizable(false);
		ecranMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Création du pannel de bouttons*/
        panneau = new JPanel();
        
        /*Création des boutons de naviguation*/
        bouton = new JButton("1 Joueur !");
        label = new JLabel("Voulez-vous jouer en Solitaire ?");
        bouton.addActionListener(new ActionListener() {
        	
			/*Lancement du Jeu*/
			@Override
			public void actionPerformed(ActionEvent e) {
				gui();
				ecranMenuPrincipal.setVisible(false);
				/*Boite de Dialogue demandant le pseudo du joueur*/
				JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
				nom = jop.showInputDialog(null, "Choisissez un pseudo !", "Choix Pseudo", JOptionPane.QUESTION_MESSAGE);
				jop2.showMessageDialog(null, "Votre pseudo est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);
			}
		});
        
        bouton2 = new JButton("2 Joueurs !");
        label2 = new JLabel("Voulez-vous jouer en Multijoueur ?");
        bouton2.addActionListener(new ActionListener() {
        	
			/*Lancement du jeu*/
			@Override
			public void actionPerformed(ActionEvent e) {
				gui();
				ecranMenuPrincipal.setVisible(false);
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
        ecranMenuPrincipal.add(panneau, BorderLayout.SOUTH); 
        
        /*Mise à l'échelle de l'image*/
        icone = new ImageIcon("Image/motus.jpg");
        Image backgroundMotus = icone.getImage();
        Image backgroundMotusModif = backgroundMotus.getScaledInstance(1280, 700, java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(backgroundMotusModif);
        
        /*Ajout de l'image sur la frame*/
        image = new JLabel(icone);
        ecranMenuPrincipal.add(image);
        ecranMenuPrincipal.setVisible(true);
        ecranMenuPrincipal.setLocationRelativeTo( null );
	
	}
	
	/*Vue de l'ecran de jeu*/
	public void gui() {
		
		/*Ecran de Jeu*/
		appli = new JFrame("Motus : Le Jeu");
		appli.setSize(1280,720);
        appli.setResizable(false);
        appli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appli.setVisible(true);
		
		/*Panneau de jeu*/
		pannel = new JPanel();
        pannel.setBackground(Color.orange);
        pannel.setLayout(null);
        
        /*Etiquette demandant au joueur de choisir son mot*/
        label1=new JLabel("Your word : ");
		label1.setFont(new Font("Time New Roman",Font.ITALIC+Font.BOLD,20));	 
		label1.setForeground(Color.red);
		label1.setBounds(400,550,120,50);
		
		/*Endroit où le joueur peut chosir son mot*/
		txtMot=new JTextField("",10);	
		txtMot.setBounds(520,550,150,50);
		
		/*Valider le mot du joueur*/
		cmdOK=new JButton("   Ok   ");
		cmdOK.setBackground(Color.pink);
		cmdOK.setBounds(680,550,90,50);

		/*Etiquette permettant de dire au joueur qu'il a fait une erreur sur le nombre de lettres*/
		labelMessage=new JLabel();	 
		labelMessage.setBackground(pannel.getBackground());
		labelMessage.setBounds(580,605,200,20);
		
		/*Titre de l'ecran de Jeu*/
		titre=new JLabel("Projet Java MOTUS", JLabel.CENTER);
		titre.setFont(new Font("Arial",Font.BOLD,30));
		titre.setForeground(Color.black);
		titre.setBounds(500,50,300,50);
		titre2=new JLabel("Groupe 12");
		titre2.setFont(new Font("Arial",Font.BOLD,30));
		titre2.setForeground(Color.black);
		titre2.setBounds(570,90,500,50);
		
		/*Ajout des éléments sur le panneau de jeu*/
		pannel.add(label1);
		pannel.add(txtMot);
		pannel.add(cmdOK);
		pannel.add(labelMessage);
		pannel.add(titre);
		pannel.add(titre2);	
		
		/*Boutton permettant de naviguer dans le jeu*/
		boutonMenu = new JButton("Menu Principal");
        boutonMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new  test2();
				appli.setVisible(false);
			}
		});
        
        boutonExit = new JButton("Quitter le jeu !");
        boutonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
        /*Ajout des boutons sur l'écran de jeu*/
        pannelBouton = new JPanel();
        pannelBouton.add(boutonMenu);
        pannelBouton.add(boutonExit);
		
		appli.add(pannel);
		appli.add(pannelBouton, BorderLayout.SOUTH);
        appli.setVisible(true);
        appli.setLocationRelativeTo( null );    
	}

	
	public static void main(String[] args) {
		new viewTest();
	}
}