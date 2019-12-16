package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Panneau extends JPanel {
private static final long serialVersionUID = 1L;
	
	// liste des mots
	// s'il y a des mots � ajouter 
	String mot = new String();
	
	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
	}

	private int MotNum=0;
	
	private boolean MotTrouve=false; 
	private boolean MotValide=true;
	private boolean jeuFini=false;
	
	private boolean PosExactes[][]=new boolean[5][5];
	private boolean PosFausses[][]=new boolean[5][5];
	
	private boolean HistoExacte[]=new boolean[5];
	
	private String MotSaisies[]=new String[5];
	
	// Les composants de la fen�tre
	
	private JButton cmdok,changerColor;
	private JTextField txtmot;
	
	private JLabel lbl1,lblmessage;
	
	public Panneau()
	{
		initComposants();	
	}
	
	private void initComposants()
	{
		setBackground(Color.pink);
		setLayout(null);
		
		lbl1=new JLabel("Proposition: ");
		lbl1.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,15));	 
		lbl1.setBackground(Color.blue);
		lbl1.setBounds(10,400,100,20);
		
		
		txtmot=new JTextField("",10);	
		txtmot.setBounds(120,400,70,20);
		
		cmdok=new JButton("Ok");
		cmdok.setBackground(Color.yellow);
		cmdok.setBounds(200,400,90,20);
		
		lblmessage=new JLabel("");	 
		lblmessage.setBackground(getBackground());
		lblmessage.setBounds(10,430,280,20);
		
		add(lbl1);
		add(txtmot);
		add(cmdok);
		add(lblmessage);
		
	}
	public String getTxt() {
		return txtmot.getText();
	}
	public void setlblMessage(String s) {
		lblmessage.setText(s);
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
		G.setColor(Color.blue);
		G.drawString("PROJET JAVA GROUPE 12",40,50);
		
		G.setFont(new Font("Helvetika",Font.BOLD,20));
		G.setColor(Color.black);
		G.drawRoundRect(5,390,300,80,4,4);
		
		int x=40,y=100,nb=0;
		
		while(nb < 30)
		{
			G.drawRect(x,y,40,40);
			x+=40;
			nb++;
			if(nb % 5 == 0) {x=40; y+=40;}
		}
		
		G.setFont(new Font("Helvetika",Font.BOLD,20)); 
		G.setColor(Color.black);
	}
	
	private void initPerdu()
	{
		lblmessage.setText("You lose the solution was "+mot+" .");
		txtmot.setText("");
		MotNum=0;
		//choisirMot();
		for(int i=1;i<5;i++) 
			for(int j=0;j<5;j++) {
				PosExactes[i][j]=false;this.HistoExacte[i]=false;
			}
		cmdok.setLabel("Restart");
		jeuFini=true;	
			
	}
	
	
	private  void initMotTrouve()
	{
		lblmessage.setText("Well done you found the word!") ;
		txtmot.setText("");
	}
	
	
	private  void ecrireMotSuivant(Graphics g)
	{
		g.drawString(String.valueOf(mot.charAt(0)),55,130+ 40*MotNum);
		
		int pos=1;
		int x=95;
		int y=130 + 40 * MotNum;
		
		while(pos < 5)
		{	
			if(HistoExacte[pos]) g.drawString(String.valueOf(mot.charAt(pos)) , x , y );
			else g.drawString("." , x , y );
			x+=40;pos++;
			}
		
		txtmot.setText("");
	}
	
	
	
	private  void ecrirePremiereLetrre(Graphics g)
	{
		g.drawString(String.valueOf(mot.charAt(0)),55,130);
		
		int pos=1;
		int  x=95;
		int y=130 + 40 * MotNum;
		
		while(pos < 5)
		{
			g.drawString("." , x , y );
		x+=40;pos++;
		}	
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
			{
				if(PosFausses[i][j]) 
					g.fillOval( x + 3 , y+ 3 , 35 , 35);
				x+=40;
			}		
		}
		g.setColor(Color.red );
		for(i=1;i < MotNum;i++)
		{
			x=40;
			y=100 + 40 * (i-1);
			for(j=0 ;j < 5 ;j++)
			{
				if(PosExactes[i][j]) { 
					g.fillRect( x + 3 , y + 3 , 35 , 35);
				}
				x+=40;
			}
		}
	}
	
	
	private  void ecrireMots(Graphics g)
	{
		int pos,x,y;
		
		for(int cpt=1;cpt<=MotNum;cpt++)
		{
			pos=0;
			x=55;
			y=130 + 40 * (cpt-1);
		
		while(pos < 5)
		{
			g.drawString(String.valueOf(MotSaisies[cpt].charAt(pos)) , x , y );
			x+=40;pos++;
		}
	  }
	
	}
	
	private  void dessinerPositionsJustes(Graphics g)
	{
		int x,y,pos;
		g.setColor(Color.red);
		pos=0;
		x=40;
		y=100 + 40 * (MotNum-1);
	
	while(pos < 5)
	{
		if( MotSaisies[MotNum].charAt(pos) == mot.charAt(pos) )   {
			g.fillRect( x + 3 , y + 3 , 35 , 35);
			PosExactes[MotNum][pos]=true;
			HistoExacte[pos]=true;
		
		}
		else
			PosExactes[MotNum][pos]=false;
			x+=40;pos++;
		}
	
		if( MotSaisies[MotNum].equals(mot) )
			MotTrouve=true;
	}
	
	private  void dessinerPositionsFausses(Graphics g)
	{
		String tmp=mot;
		char[] tmpc=tmp.toCharArray();
		for(int i=0;i<5;i++)
		{  
			if(tmp.charAt(i)==MotSaisies[MotNum].charAt(i)) tmpc[i]=' ';   
		}
		tmp=String.valueOf(tmpc);
		
		g.setColor(Color.yellow);
		int i=0;
		int x=40;
		int y=100 + 40 * (MotNum-1);
		
		while(i < 5)
		{
			char c= MotSaisies[MotNum].charAt(i);
			if(occurence( c, tmp ) > 0)
			{
				g.fillOval(x+3 ,y + 3 , 35, 35);	
				PosFausses[MotNum][i]=true;
				tmp=eliminer(c,tmp);
			}
			else 
				PosFausses[MotNum][i]=false;
				x+=40;
				i++;
			}	
	}
	private  String eliminer(char c,String ch)
	{
		int i=0;
		String resultat="";
		
		while(i<ch.length())
		{
			if(ch.charAt(i)==c)
					c='1';
			else 
				resultat+=ch.charAt(i);
			i++;
		}		
		return resultat; 	  		
	}
	private  int occurence(char c,String ch){
		int res=0;
		int i=0;
		
		while(i<ch.length())
		{
			if(ch.charAt(i)==c) res++;
			i++;
		}
			return res;
	}
	public void initBoutons()
	{
		cmdok.setLabel("Recommencer");
		cmdok.setEnabled(true);
	}
	
}
