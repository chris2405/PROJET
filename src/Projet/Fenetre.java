package Projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.MenuDragMouseListener;



public class Fenetre extends JFrame implements MouseListener,ActionListener{
	
	
	private JPanel pan1= new JPanel();
	private JPanel pan2= new JPanel();
	private JPanel pan3= new JPanel();
	private JPanel pan4= new JPanel();
	private JPanel pan5= new JPanel();
	
	private JLabel lab2= new JLabel("Projet JMQ DL 2016 : Laure, Amel et Christopher.",JLabel.CENTER);
	
	
	//private Font police = new Font("Arial", Font.BOLD, 15);
	//private Font police2 = new Font("Arial", Font.BOLD, 40);
	
	//private String bouton[] = {"Consulter planning General","Consulter le planning Personnel","Créer Planning ","Gestion des Comptes",};
	
	//private MonBouton b = new MonBouton("");
	
	JToolBar bar=new JToolBar();
	JToolBar bar2=new JToolBar();
	JToolBar bar3=new JToolBar();
	
	private int[] tmois = { 01, 02, 03, 04, 05, 06, 07,8,9,10, 11, 12 };
	
	private int anneeT[]=new int[10];
	private int jourT[]=new int[31];
	
	
	public Fenetre(){
		
		setSize(700, 500);
		setTitle("LOGICIEL DE GESTION");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(false);
		addMouseListener(this);
		
		
		this.setContentPane(pan4);
		
	pan1.setBackground(Color.WHITE);
	lab2.setBackground(Color.LIGHT_GRAY);
	lab2.setOpaque(true);
	   
	 pan1.setLayout(new BorderLayout());
     pan1.add(lab2, BorderLayout.SOUTH);
     
     MonBouton b1=new MonBouton("Consulter planning General");
    /* b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Etudiant et = new Etudiant();
		//	et.afficherPlanningGeneral();
		}});
   */
     MonBouton b2=new MonBouton("Consulter le planning Personnel");
     /*
     b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Etudiant et = new Etudiant();
			//et.afficherPlanningPerso();
		}});
     */
     MonBouton b3=new MonBouton("Créer Planning");
     /*
     b3.addActionListener(new ActionListener(){
   			public void actionPerformed(ActionEvent e) {
   				Responsable r = new Responsable();
 			//	r.ajouterPlanning();
 			}});
     */
     MonBouton b4=new MonBouton("Gestion des Comptes"); 
     /*
     b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Administrateur a = new Administrateur();
		//	a.afficherMenuCompte();
		}});
    */
     //MonBouton b5=new MonBouton("Voire les listes");
    
        
     
        bar.add(b1);
        bar.add(b2);
        bar.add(b3);
        bar.add(b4);
        
        bar2.add(b1);
        bar2.add(b2);
        bar2.add(b3);
        
        bar3.add(b1);
        bar3.add(b2);
        
        getContentPane().add(bar);
        getContentPane().add(bar2);
        
		pan1.add(bar, BorderLayout.NORTH);
		pan4.add(bar2,BorderLayout.NORTH);
		pan5.add(bar3,BorderLayout.NORTH);
		
		bar.setFloatable(false);
		
		
		//}
        
        MonBouton ajout= new MonBouton("Ajouter un compte");
        JButton supp= new JButton("Supprimer un compte");
        JButton modif= new JButton("Modifier un compte");
        pan2.add(ajout);
        pan2.add(supp);
        pan2.add(modif);
        
        
         
        
        JComboBox jour=new JComboBox();
        JComboBox mois=new JComboBox();
        JComboBox annee=new JComboBox();
        MonBouton valid=new MonBouton("Validez");
        pan3.add(jour);
        pan3.add(mois);
        pan3.add(annee);
        pan3.add(valid);
        
        anneeT[0]=2006;
        for(int i=0;i<anneeT.length;i++){
     		
     		annee.addItem(2015+i);
     	}
        
        
        for(int i=0;i<tmois.length;i++){
        	mois.addItem(tmois[i]);
        	 
        
        }
        for(int i=0;i<jourT.length;i++)	
        	jour.addItem(1+i);
        	
      
        
        
        
       
        
       /*
        String login=JOptionPane.showInputDialog (pan1, "Tapez votre login");
        String mdp=JOptionPane.showInputDialog (pan1, "Tapez votre mot de passe");
        
       System.out.println(login);
       System.out.println(mdp);
       */
        
	    pan2.setBackground(Color.red);
	    pan3.setBackground(Color.GREEN);
			  
			  
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
	

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}	

}


