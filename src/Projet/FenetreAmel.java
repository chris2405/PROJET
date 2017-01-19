
	
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.MenuDragMouseListener;
import javax.swing.event.TableModelListener;



public class FenetreAmel extends JFrame{
	
	

	private JPanel pan0= new JPanel();
	private JPanel pan1= new JPanel();
	private JPanel pan2= new JPanel();
	private JPanel pan3= new JPanel();
	private JPanel pan4= new JPanel();
	private JPanel pan5= new JPanel();
	private JPanel pan6= new JPanel();
	private JPanel pan7= new JPanel();
	
	private JLabel lab2= new JLabel("Projet JMQ DL 2016 : Laure, Amel et Christopher.",JLabel.CENTER);
    

	JToolBar bar=new JToolBar();


	private int[] tmois = { 01, 02, 03, 04, 05, 06, 07,8,9,10, 11, 12 };
	private int anneeT[]=new int[10];
	private int jourT[]=new int[31];
	
	private JPanel centre= new JPanel();
	
	
	
	private JLabel lab= new JLabel("WELCOME",JLabel.CENTER);
	
	private MonBouton pre=	new MonBouton("Précèdent");
	private MonBouton sui=	new MonBouton("Suivant");
	
	private Font police = new Font("Arial", Font.BOLD, 15);	
	private Font police2 = new Font("Arial", Font.BOLD, 12);
	
	MonBouton b1=new MonBouton("Consulter planning General");
	MonBouton b2=new MonBouton("Consulter le planning Personnel");
	MonBouton b3=new MonBouton("Créer Planning");
	MonBouton b4=new MonBouton("Gestion des Comptes"); 
	
	public FenetreAmel(){
		
		setSize(700, 500);
		setTitle("LOGICIEL DE GESTION");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(false);
		
		this.setContentPane(pan1);
		
		MonBouton b1=new MonBouton("Consulter planning General");
		MonBouton b2=new MonBouton("Consulter le planning Personnel");
		MonBouton b3=new MonBouton("Créer Planning");
		MonBouton b4=new MonBouton("Gestion des Comptes"); 
		
		
		
		
		MonBouton b5=new MonBouton("Consulter planning General");
		MonBouton b6=new MonBouton("Consulter le planning Personnel");
		MonBouton b7=new MonBouton("Créer Planning");
		
		MonBouton b8=new MonBouton("Consulter planning General");
		MonBouton b9=new MonBouton("Consulter le planning Personnel");
		MonBouton b10=new MonBouton("SUIVANT");
		
		lab2.setBackground(Color.WHITE);
		
		pan0.setBackground(Color.lightGray);
		
		pan0.setLayout(new BorderLayout());
		pan0.add(lab, BorderLayout.NORTH);
		pan0.add(lab2, BorderLayout.SOUTH);
		
		pan0.add(centre, BorderLayout.CENTER);
		centre.setBackground(Color.black);
		pan0.add(pre,BorderLayout.WEST);
		pan0.add(sui,BorderLayout.EAST);
		
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		GridLayout gr= new GridLayout(4,1);
		pan1.setBackground(Color.WHITE);
		pan1.setLayout(gr);
		gr.setHgap(20);
		gr.setVgap(20);

		pan1.add(b1);
		pan1.add(b2);
		pan1.add(b3);
		pan1.add(b4);
		
		centre.add(pan1);
		
        
       setVisible(true);
        
        
       pre.setFont(police);
       sui.setFont(police);
       lab.setFont(police2);
       lab2.setFont(police2);
       
     
     		
     		
        
        //pre.setPreferredSize(new Dimension(30,45));
      // pan2.setPreferredSize(new Dimension(this.getWidth(),30));
     
   	sui.addActionListener(new ActionListener(){

		
		public void actionPerformed(ActionEvent e) {
			
			
			centre.setVisible(false);
			}
		});
pre.addActionListener(new ActionListener(){

		
		public void actionPerformed(ActionEvent e) {
			
			
			centre.setVisible(true);
			}
		});
	
		
	}	

}


