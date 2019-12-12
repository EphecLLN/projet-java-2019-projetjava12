package test;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test2 {
	private JFrame ecran;
	private JButton bouton;
	private JButton bouton2;
	private JButton boutonExit;
	private JPanel panneau;
	private ImageIcon icone;
	private JLabel image;
	private JLabel label;
	private JLabel label2;

	
	public test2 (){
		gui();
	}
	
	public void gui() {
		ecran = new JFrame("Menu Principal");
        ecran.setSize(1280,720);
        ecran.setResizable(false);
        ecran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panneau = new JPanel();
        
        bouton = new JButton("1 Joueur !");
        label = new JLabel("Voulez-vous jouer en Solitaire ?");
        bouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new  interMotus();
				ecran.setVisible(false);
			}
		});
        
        bouton2 = new JButton("2 Joueurs !");
        label2 = new JLabel("Voulez-vous jouer en Multijoueur ?");
        bouton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new  interMotus();
				ecran.setVisible(false);
			}
		});
        
        boutonExit = new JButton("Quitter le jeu !");
        boutonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

        panneau.add(bouton);
        panneau.add(label);
        panneau.add(bouton2);
        panneau.add(label2);
        panneau.add(boutonExit);

        ecran.add(panneau, BorderLayout.SOUTH); 
        
        icone = new ImageIcon("Image/motus.jpg");
        Image backgroundMotus = icone.getImage();
        Image backgroundMotusModif = backgroundMotus.getScaledInstance(1280, 700, java.awt.Image.SCALE_SMOOTH);
        icone = new ImageIcon(backgroundMotusModif);
        
        image = new JLabel(icone);
        ecran.add(image);
        ecran.setVisible(true);
        ecran.setLocationRelativeTo( null );
	}
	
    public static void main(String[] args) {

    	new test2();
    	
    }
}
class gestionFenetre extends WindowAdapter{
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}