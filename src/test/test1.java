package test;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

//	import javax.swing.JOptionPane;


public class test1 extends Applet implements ActionListener
{  
	
	// liste des mots
	// s'il y a des mots � ajouter 
	String mots[]={"decor","glace","visio","auteu","taill","ligne","nouee","lucid","peine","coute","accen","vache","trent","saint","poutr","polic","saumo","minoi","etroi","minee","joule","gaffe","equip","evite","priso","etoil","hocke","repri","migal","aiman","pierr","ardeu","alcoo","nombr","confu","auteu","poste","repri","eclai","organ","ouver","teste","pente","tente","trait","carte","doute","piste","pisto","carto","route","calcu","tarte","mordu","cousi","frere","plair","trace","court","ecole","dette","crime","vague","cycle","table","suite"};
	
	// variables du jeux
	private String solution,dernier_mot="";
    private  Random alea;
	// Les boules
	

	
	private int MotNum=0;
	
	private boolean MotTrouve=false; 
	private boolean MotValide=true;
	private boolean jeuFini=false;
	
	private boolean PosExactes[][]=new boolean[5][5];
	private boolean PosFausses[][]=new boolean[5][5];
	
	private boolean HistoExacte[]=new boolean[5];
	
	private String MotSaisies[]=new String[5];
	
	// Les composants de la fen�tre
	
	private Button cmdok;
	private TextField txtmot;
	
	private Label lbl1,lblmessage;
	
	public void init()
	{
		initComposants();
		choisirMot();
		
	}
	private void initComposants()
	{
		setBackground(Color.orange);
		setLayout(null);
		
		lbl1=new Label("Your word : ");
		lbl1.setFont(new Font("Time New Roman",Font.ITALIC+Font.BOLD,20));	 
		lbl1.setForeground(Color.red);
		lbl1.setBounds(400,550,120,50);
		
		
		txtmot=new TextField("",10);	
		txtmot.setBounds(520,550,150,50);
		txtmot.addActionListener(this);         
		
		cmdok=new Button("   Ok   ");
		cmdok.setBackground(Color.pink);
		cmdok.addActionListener(this);
		cmdok.setBounds(680,550,90,50);
		
		lblmessage=new Label();	 
		lblmessage.setBackground(getBackground());
		lblmessage.setBounds(580,605,200,20);		
		
		add(lbl1);
		add(txtmot);
		add(cmdok);
		add(lblmessage);
		
		
		alea = new Random();
			
	}
	
	
	private void choisirMot()
	{
		solution=mots[alea.nextInt(mots.length)].toUpperCase();
		if(solution.equals(dernier_mot))	choisirMot(); 
		dernier_mot = solution;
	}
	
	
	public void actionPerformed(ActionEvent AE)
	{   
		
		
		if(jeuFini) 
		{
		//	JOptionPane.showMessageDialog(null,"ici");
			
		initFinJeu();
	
		}
		
		else 
		{
			testerSaisie ();
			
			if(!MotValide) 
			{lblmessage.setText("Ecrire un mot correct de 5 lettres.") ;}
			else
			{
				MotNum++;
				lblmessage.setText("") ;
				MotSaisies[MotNum]=txtmot.getText().toUpperCase();
				repaint();}
		}
	}
	
	public void paint(Graphics G)
	{	
		//	G.drawString(solution,10,20);
		
		
		dessinerInterface(G);
		
		
		if( MotNum ==0) {ecrirePremiereLetrre(G);return;}
		
		dessinerHistorique(G);
		dessinerPositionsFausses(G);
		dessinerPositionsJustes(G);
		G.setColor(Color.black);
		
		ecrireMots(G);	 
		
		if(MotTrouve  && !jeuFini) initMotTrouve();
		else if(MotNum==5 && !MotTrouve) initPerdu();
		else if(!jeuFini)
		{
			ecrireMotSuivant(G);
		}
	}
	
	private void dessinerInterface(Graphics G)
	{
	G.setFont(new Font("Arial",Font.BOLD,30));
	G.setColor(Color.black);
	G.drawString("Projet Java MOTUS",500,50);
	G.drawString("Groupe 12",570,90);

	
	G.setFont(new Font("Helvetika",Font.BOLD,20));
	G.setColor(Color.black);
	G.drawRoundRect(395,545,400,85,4,4);
	
	int x=40,y=100,nb=0;
	
	while(nb < 25)
	{
		G.drawRect(x,y,40,40);
		x+=40;nb++;
		if(nb % 5 == 0) {x=40; y+=40;}
	}
	
	G.setFont(new Font("Helvetika",Font.BOLD,20)); 
	G.setColor(Color.black);
	}
	
	private void initPerdu()
	{
		lblmessage.setText("You lose the solution was "+solution+" .");
		txtmot.setText("");
		MotNum=0;choisirMot();
		for(int i=1;i<5;i++) for(int j=0;j<5;j++) {PosExactes[i][j]=false;this.HistoExacte[i]=false;}
		cmdok.setLabel("Restart");
		jeuFini=true;	
			
	}
	
	
	private  void initMotTrouve()
	{
		lblmessage.setText("Well done you found the word!") ;
		txtmot.setText("");		
		jeuFini=true;
		try
		{
		}
		catch(Exception ex) { ex.printStackTrace();}
		cmdok.setEnabled(false);
		txtmot.setEnabled(false);
		
	}
	
	
	private  void ecrireMotSuivant(Graphics g)
	{
		g.drawString(String.valueOf(solution.charAt(0)),55,130+ 40*MotNum);
		
		int pos=1;
		int x=95;
		int y=130 + 40 * MotNum;
		
		while(pos < 5)
		{	
			if(HistoExacte[pos]) g.drawString(String.valueOf(solution.charAt(pos)) , x , y );
			else g.drawString("." , x , y );
			x+=40;pos++;}
		
		txtmot.setText("");
		
	}
	
	
	
	private  void ecrirePremiereLetrre(Graphics g)
	{
		g.drawString(String.valueOf(solution.charAt(0)),55,130);
		
		int pos=1;
		int  x=95;
		int y=130 + 40 * MotNum;
		
		while(pos < 5)
		{g.drawString("." , x , y );
		x+=40;pos++;}
		
		
	}								 
	
	
	
	
	private  void dessinerHistorique(Graphics g)
	{
		int x,y;
		int i,j;
		g.setColor(Color.yellow );
		for(i=1;i < MotNum;i++)
		{
			x=40;
			y=100 + 40 * (i-1);
			for(j=0;j < 5 ;j++)
			{if(PosFausses[i][j]) g.fillOval( x + 3 , y+ 3 , 35 , 35);
			
			x+=40;}
			
		}
		g.setColor(Color.red );
		for(i=1;i < MotNum;i++)
		{
			x=40;
			y=100 + 40 * (i-1);
			for(j=0 ;j < 5 ;j++)
			{if(PosExactes[i][j]) { g.fillRect( x + 3 , y + 3 , 35 , 35);}
			
			x+=40;}
			
		}
		
	}
	
	
	private  void ecrireMots(Graphics g)
	{int pos,x,y;
	
	for(int cpt=1;cpt<=MotNum;cpt++)
	{pos=0;
	x=55;
	y=130 + 40 * (cpt-1);
	
	while(pos < 5)
	{
		g.drawString(String.valueOf(MotSaisies[cpt].charAt(pos)) , x , y );
		x+=40;pos++;}
	}
	
	}
	
	
	
	
	private  void dessinerPositionsJustes(Graphics g)
	{int x,y,pos;
	g.setColor(Color.red);
	pos=0;
	x=40;
	y=100 + 40 * (MotNum-1);
	
	while(pos < 5)
	{
		if( MotSaisies[MotNum].charAt(pos) == solution.charAt(pos) )   
		{g.fillRect( x + 3 , y + 3 , 35 , 35);
		PosExactes[MotNum][pos]=true;
		HistoExacte[pos]=true;
		
		}
		else
			PosExactes[MotNum][pos]=false;
		x+=40;pos++;}
	if( MotSaisies[MotNum].equals(solution) ) MotTrouve=true;
	}
	
	private  void dessinerPositionsFausses(Graphics g)
	{
		String tmp=solution;
		char[] tmpc=tmp.toCharArray();
		for(int i=0;i<5;i++)
		{  if(tmp.charAt(i)==MotSaisies[MotNum].charAt(i)) tmpc[i]=' ';           }
		tmp=String.valueOf(tmpc);
		
		g.setColor(Color.yellow);
		int i=0;
		int x=40;
		int y=100 + 40 * (MotNum-1);
		
		while(i < 5)
		{char c= MotSaisies[MotNum].charAt(i);
		if(occurence( c, tmp ) > 0)
		{g.fillOval(x+3 ,y + 3 , 35, 35);	
		PosFausses[MotNum][i]=true;
		tmp=eliminer(c,tmp);}
		else PosFausses[MotNum][i]=false;
		
		x+=40;
		i++;}
		
		
		
	}
	private  String eliminer(char c,String ch)
	{int i=0;
	String resultat="";
	while(i<ch.length())
	{if(ch.charAt(i)==c) {c='1';}
	else resultat+=ch.charAt(i);
	i++;
	}
	
	return resultat; 	  
	
	
	}
	private  int occurence(char c,String ch)
	{int res=0;
	int i=0;
	while(i<ch.length())
	{if(ch.charAt(i)==c) res++;
	i++;
	}
	return res;
	}
	
	private void testerSaisie()
	{String saisie=txtmot.getText();
	if(saisie.length()!=5)
		MotValide=false;
	else
	{boolean isChar=true;
	int pos=0;
	while(pos < 5 && isChar)
	{isChar=Character.isLetter(saisie.charAt(pos)); pos++;}
	MotValide=isChar;}	
	}
	

	public void initBoutons()
	{
	cmdok.setLabel("Recommencer");
	cmdok.setEnabled(true);
	}
	
	public void initFinJeu()
	{
		txtmot.setText("");
		lblmessage.setText("");
		MotNum=0;choisirMot(); 
		MotTrouve=false;
		for(int i=1;i<5;i++) for(int j=0;j<5;j++) 
		{PosExactes[i][j]=false;this.HistoExacte[j]=false;}
		
		txtmot.setEnabled(true);
		cmdok.setLabel("Ok");
		jeuFini=false;	

		repaint();
	}
}