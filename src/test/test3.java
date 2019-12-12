package test;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class test3 {
	
	private JFrame appli;
	private JPanel pannel;
	private JPanel panneltitre;
	private Button cmdOK;
	private TextField txtMot;
	private Label label1;
	private Label labelMessage;
	private Label titre;
	private Label titre2;

	
	
	private String solution;
	
	public test3() {
		
		gui();
		/*choisirMot();*/
	}
	
	public void gui() {
		
		appli = new JFrame("Motus : Le Jeu");
		appli.setSize(1280,720);
        appli.setResizable(false);
        appli.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appli.setVisible(true);
		
		pannel = new JPanel();
        pannel.setBackground(Color.orange);
        pannel.setLayout(null);
        
        label1=new Label("Your word : ");
		label1.setFont(new Font("Time New Roman",Font.ITALIC+Font.BOLD,20));	 
		label1.setForeground(Color.red);
		label1.setBounds(400,550,120,50);
		
		txtMot=new TextField("",10);	
		txtMot.setBounds(520,550,150,50);
		
		cmdOK=new Button("   Ok   ");
		cmdOK.setBackground(Color.pink);
		cmdOK.setBounds(680,550,90,50);

		labelMessage=new Label();	 
		labelMessage.setBackground(pannel.getBackground());
		labelMessage.setBounds(580,605,200,20);
		
		titre=new Label("Projet Java MOTUS", Label.CENTER);
		titre.setFont(new Font("Arial",Font.BOLD,30));
		titre.setForeground(Color.black);
		
		titre2=new Label("Groupe 12");
		titre2.setFont(new Font("Arial",Font.BOLD,30));
		titre2.setForeground(Color.black);


		pannel.add(label1);
		pannel.add(txtMot);
		pannel.add(cmdOK);
		pannel.add(labelMessage);
		pannel.add(titre);
		pannel.add(titre2);


		
		
		/*pannel.drawString("Projet Java MOTUS",500,50);
		pannel.drawString("Groupe 12",570,90);*/		
		
		
		appli.add(pannel);

		
        appli.setVisible(true);
        appli.setLocationRelativeTo( null );
	}
	
	/*private void choisirMot() {
		
	}*/
	
	public static void main(String[] args) {
		new test3();
	}
}