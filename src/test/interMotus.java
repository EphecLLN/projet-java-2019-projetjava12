package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class interMotus extends JFrame{
	private JButton boutonExit;
	private JButton boutonMenu;
	private JPanel panneau;

	private static final long serialVersionUID = 1L;
	interMotus(){
		super("Motus: Le Jeu");
        boutonExit = new JButton("Quitter le jeu !");
        boutonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        
        boutonMenu = new JButton("Menu Principal");
        boutonMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new  test2();
				setVisible(false);
			}
		});
        
        panneau = new JPanel();
		panneau.add(boutonMenu);
		panneau.add(boutonExit);
		add(panneau,BorderLayout.SOUTH);
		setSize(1280,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo( null );
		setVisible(true);
		setResizable(false);
		
		test1 motus=null;
		try
		{
		motus = new test1();
		motus.init();
		getContentPane().add(motus);
		}
		catch(Exception p)
		{JOptionPane.showMessageDialog(this,p.toString());}

		setVisible(true);
	}
	
	public static void main(String x[])
	{   
		new interMotus();
	}
}
