package test;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class viewTest extends Canvas {

	/*Ecran menu principal*/
	private static JFrame ecranMenuPrincipal;
	private static JButton bouton;
	private static JButton bouton2;
	private static JPanel panneau;
	private static ImageIcon icone;
	private static JLabel image;
	private static JLabel label;
	private static JLabel label2;
	
	/*Pannel de boutons */
	private static JPanel pannelBouton;
	private static JButton boutonExit;
	private static JButton boutonMenu;
	
	/*Ecran Jeu*/
	private static JFrame appli;
	private static JPanel pannel;
	private static JButton cmdOK;
	private static JTextField txtMot;
	private static JLabel label1;
	private static JLabel labelMessage;
	private static JLabel titre;
	private static JLabel titre2;
	
	private static String nom;
	private static String nom2 = "Steven";

	
	
	public viewTest() {

    }

	

	/*Lancement du menu principal*/
	public static void menuPrincipal() {
		ecranMenuPrincipal = new JFrame("Menu Principal");
		ecranMenuPrincipal.setSize(1280,720);
		ecranMenuPrincipal.setResizable(false);
		ecranMenuPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Création du pannel de bouttons*/
        panneau = new JPanel();
        
        /*Création des boutons de naviguation*/
        bouton = new JButton("1 Joueur !");
        label = new JLabel("Voulez-vous jouer en Solitaire ?");
        
        bouton2 = new JButton("2 Joueurs !");
        label2 = new JLabel("Voulez-vous jouer en Multijoueur ?");

        
        boutonExit = new JButton("Quitter le jeu !");

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
	
	public static void jeu() {
		
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
        
        dessin();
}

	
	public static void dessin() {
        JFrame frame = new JFrame("Motus: Le Jeu");
        frame.setLocationRelativeTo( null );
        frame.setUndecorated(true);
        frame.setOpacity(0.5f);
        Canvas canvas = new viewTest();
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*Etiquette demandant au joueur de choisir son mot*/
        label1=new JLabel("Your word : ");
		label1.setFont(new Font("Time New Roman",Font.ITALIC+Font.BOLD,20));	 
		label1.setForeground(Color.red);
		label1.setBounds(400,550,120,50);
		
		
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo( null );
	}
	
    public static void main(String[] args) {
    	menuPrincipal();
    	bouton.addActionListener(new ActionListener() {
    	
			/*Lancement du jeu*/
			@Override
			public void actionPerformed(ActionEvent e) {
				jeu();
				ecranMenuPrincipal.setVisible(false);
				if(nom == null) {
					JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
					nom = JOptionPane.showInputDialog(null, "Choisissez un pseudo !", "Choix Pseudo", JOptionPane.QUESTION_MESSAGE);
					JOptionPane.showMessageDialog(null, "Votre pseudo est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Votre pseudo est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);
				}
			}
    	});
    	
        bouton2.addActionListener(new ActionListener() {
        	
			/*Lancement du jeu*/
			@Override
			public void actionPerformed(ActionEvent e) {
				jeu();
				ecranMenuPrincipal.setVisible(false);
				if(nom == null) {
					JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
					nom = JOptionPane.showInputDialog(null, "Choisissez un pseudo pour le joueur 1 !", "Choix Pseudo", JOptionPane.QUESTION_MESSAGE);
					JOptionPane.showMessageDialog(null, "Le pseudo du Joueur 1 est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Le pseudo du Joueur 1 est " + nom, "Identité", JOptionPane.INFORMATION_MESSAGE);
				}
				if(nom2 == null) {
					JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
					nom2 = JOptionPane.showInputDialog(null, "Choisissez un pseudo pour le joueur 2 !", "Choix Pseudo", JOptionPane.QUESTION_MESSAGE);
					JOptionPane.showMessageDialog(null, "Le pseudo du Joueur 2 est " + nom2, "Identité", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Le pseudo du Joueur 2 est " + nom2, "Identité", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
        
        boutonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

    }

    public void paint(Graphics G) {
		/*Initialisation de l'emplacement et du nombre de case*/
		int x=20,y=20,nb=0;
		/*Boucle cr�ant les case une par une jusque 25 cases (5x5)*/
		while(nb < 25){
			G.drawRect(x,y,70,70);
			x+=70;nb++;
			if(nb % 5 == 0) {x=20; y+=70;}
		}
	}
}
