package Projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



public class Fenetre extends JFrame {
	
	private JPanel pan= new JPanel();
	private JPanel pan2= new JPanel();
	
	private JLabel lab= new JLabel("WELCOME",JLabel.CENTER);
	private JLabel lab2= new JLabel("Projet JMQ DL 2016 : Laure, Amel et Christopher.",JLabel.CENTER);
	
	private Font police = new Font("Arial", Font.BOLD, 20);
	
	private String bouton[] = {"Consulter la liste des salles","Consulter le planning","Consulter le planning","Comptes"};
	private MonBouton b = new MonBouton("");
	/*
	private MonBouton bouton1 = new MonBouton("Consulter la liste des salles");
	private MonBouton bouton2 = new MonBouton("Consulter le planning");
	private MonBouton bouton3 = new MonBouton("Consulter le planning");
	private MonBouton bouton4 = new MonBouton("Comptes");
	*/
	public Fenetre(){
		setSize(700, 500);
		setTitle("LOGICIEL DE GESTION");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(false);
		
		this.setContentPane(pan);
		pan.setBackground(Color.lightGray);
		pan2.setBackground(Color.WHITE);
		pan2.setPreferredSize(new Dimension(this.getWidth(),30));
		lab2.setBackground(Color.WHITE);
		
		pan.setLayout(new BorderLayout());
		pan.add(lab, BorderLayout.NORTH);
		pan.add(pan2, BorderLayout.CENTER);
		pan.add(lab2, BorderLayout.SOUTH);
		
		
		GridLayout gr=new GridLayout(4, 3);
		pan2.setLayout(gr);
		gr.setHgap(15);
        gr.setVgap(15);
        
        /*
        pan2.add(bouton1);
        pan2.add(bouton2);
        pan2.add(bouton3);
        pan2.add(bouton4);
        */
        
        for(int i=0;i<bouton.length;i++){
        
        b=new MonBouton(bouton[i]);
        b.setFont(police);
        pan2.add(b);
        b.setPreferredSize(new Dimension(30,45));
      
        }
        
		
		
		JMenuBar barMenu= new JMenuBar();
		setJMenuBar(barMenu);
		JMenu menu1 = new JMenu("Fichier");
		JMenu menu2 = new JMenu("Affichage");
	    barMenu.add(menu1);
	    barMenu.add(menu2);
	    
	    JMenuItem quitter=new JMenuItem("Quitter");
	    menu1.add(quitter);
	    
	    JMenu couleur = new  JMenu("changer couleur");
	    menu2.add(couleur);
	    JMenuItem noir = new  JMenuItem("noir");
	    JMenuItem gris = new  JMenuItem("gris");
	    couleur.add(noir);
	    couleur.add(gris);
	    
	   
		setVisible(true);
		
	}	

}


