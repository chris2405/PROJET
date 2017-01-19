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



public class Fenetre extends JFrame implements MouseListener,ActionListener{

	//VARIABLE AMEL %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	
	//PAN 7   CHOIX DU PLANNING  CREER & MODIF
	
	JComboBox<Integer> comb1 = new JComboBox();
	JComboBox<Integer> comb2= new JComboBox();
	JComboBox<Integer> comb3 = new JComboBox();
	JComboBox<Integer> comb4 = new JComboBox();
	JComboBox<String> comb5 =new JComboBox();
	JComboBox<String> comb6 =new JComboBox();
	JComboBox<String> comb7 =new JComboBox();
	
	MonBouton creer= new MonBouton("creer");
	MonBouton modif= new MonBouton("modifier");
	
	JLabel l1 = new JLabel("jour");
	JLabel l2 = new JLabel("mois");
	JLabel l3 = new JLabel("annee");
	JLabel l4 = new JLabel("id_salle");
	JLabel l5 = new JLabel("nom_promo");
	JLabel l6 = new JLabel("nom_formateur");
	JLabel l7 = new JLabel("intitule_cours");
		
	//µµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµµ
	
	
	
	private JPanel pan0= new JPanel();
	private JPanel pan1= new JPanel();
	private JPanel pan2= new JPanel();
	private JPanel pan3= new JPanel();
	private JPanel pan4= new JPanel();
	private JPanel pan5= new JPanel();
	private JPanel pan6= new JPanel();
	private JPanel pan7= new JPanel();

	private JLabel lab2= new JLabel("Projet JMQ DL 2016 : Laure, Amel et Christopher.",JLabel.CENTER);
    private Font police = new Font("Arial", Font.BOLD, 40);

	JToolBar bar=new JToolBar();


	private int[] tmois = { 01, 02, 03, 04, 05, 06, 07,8,9,10, 11, 12 };
	private int anneeT[]=new int[10];
	private int jourT[]=new int[31];


	public Fenetre(Responsable res){//SUPPRIMER RES SI PB
		
		
		
		Responsable johan = new Responsable();
		
		
		
		

		setSize(700, 500);
		setTitle("LOGICIEL DE GESTION");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(false);
		
		
         //CHANGER DE JPANEL
		this.setContentPane(pan1);
		
		

		MonBouton b1=new MonBouton("Consulter planning General");
		MonBouton b2=new MonBouton("Consulter le planning Personnel");
		MonBouton b3=new MonBouton("Créer Planning");
		MonBouton b4=new MonBouton("Gestion des Comptes"); 
		
		
		b4.setVisible(false);
		
		MonBouton b5=new MonBouton("Consulter planning General");
		MonBouton b6=new MonBouton("Consulter le planning Personnel");
		MonBouton b7=new MonBouton("Créer Planning");
		
		MonBouton b8=new MonBouton("Consulter planning General");
		MonBouton b9=new MonBouton("Consulter le planning Personnel");
		


		/*
        String login=JOptionPane.showInputDialog (pan1, "Tapez votre login");
        String mdp=JOptionPane.showInputDialog (pan1, "Tapez votre mot de passe");
        
       System.out.println(login);
       System.out.println(mdp);
	    */
		
		//PAN 1 ADMIN  
		GridLayout gr= new GridLayout(4,1);
		pan1.setBackground(Color.WHITE);
		pan1.setLayout(gr);
		gr.setHgap(20);
		gr.setVgap(20);

		pan1.add(b1);
		pan1.add(b2);
		pan1.add(b3);
		pan1.add(b4);
		

		
		//PAN 2  RESPONSABLE
		GridLayout gr2= new GridLayout(3,1);
		pan2.setBackground(Color.WHITE);
		pan2.setLayout(gr2);
		
		pan2.add(b5);
		pan2.add(b6);
		pan2.add(b7);
		gr2.setHgap(20);
		gr2.setVgap(20);
		
		
		//PAN 3    ETUDIANT
		
		GridLayout gr3= new GridLayout(2,1);
		pan3.setBackground(Color.WHITE);
		pan3.setLayout(gr3);

		pan3.add(b8);
		pan3.add(b9);
		gr3.setHgap(20);
		gr3.setVgap(20);
		

		//PAN 4  GESTION DES COMPTES  ROUGE
		MonBouton ajout= new MonBouton("Ajouter un compte");
		JButton supp= new JButton("Supprimer un compte");
		JButton modif= new JButton("Modifier un compte");
		GridLayout gr4= new GridLayout(1,1);
		pan4.setBackground(Color.red);
		pan4.setLayout(gr4);
		pan4.add(ajout);
		pan4.add(supp);
		pan4.add(modif);
		gr4.setHgap(20);
		gr4.setVgap(20);

		//PAN 5   DATE

		JComboBox jour=new JComboBox();
		JComboBox mois=new JComboBox();
		JComboBox annee=new JComboBox();
		MonBouton valid=new MonBouton("Validez");
		pan5.setBackground(Color.LIGHT_GRAY);
		pan5.add(jour);
		pan5.add(mois);
		pan5.add(annee);
		pan5.add(valid);
		
		anneeT[0]=2006;
		for(int i=0;i<anneeT.length;i++){

			annee.addItem(2015+i);
		}


		for(int i=0;i<tmois.length;i++){
			mois.addItem(tmois[i]);


		}
		for(int i=0;i<jourT.length;i++)	
			jour.addItem(1+i);

         //*******************************Menu Bar		  
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
	    
	    MonBouton pre=new MonBouton("Precedent");
	    MonBouton sui=new MonBouton("Suivant");
	    barMenu.add(pre);
	    barMenu.add(sui);
	    /*
	    JTable table = new JTable(4,4 );
	    pan6.add(table);
	    pan6.setLayout( new BorderLayout() );
	    add( new JScrollPane( table ), BorderLayout.CENTER );
	    */

	   
		setVisible(true);
		
		//va a la page choix date
		b1.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {	
		setContentPane(pan5);
		setVisible(true);
				}
			});
		//va a la page choix date
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setContentPane(pan5);
				setVisible(true);
				}
			});
		// va a la page ajouter compte
b4.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {		
		setContentPane(pan4);
		setVisible(true);
				}
			});

b3.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e) {
		setContentPane(pan7);
		setVisible(true);
		}
	});

pre.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e) {
		setContentPane(pan7);
		setVisible(true);
		}
	});

sui.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e) {
		setContentPane(pan7);
		setVisible(true);
		}
	});

//   PAN 7    AMEL CODE++++++++++++++++++++++++++++++++++++++++++++++
pan7.setLayout(new GridLayout(8,2));
pan7.add(l1);

for(int i = 0; i<31;i++){
comb1.addItem(i+1);}

pan7.add(comb1);

for(int i = 0; i<12;i++){
	comb2.addItem(i+1);}

pan7.add(l2);
pan7.add(comb2);

for(int i = 0; i<11;i++){
	comb3.addItem(2015+i);}

pan7.add(l3);
pan7.add(comb3);

pan7.add(l4);
pan7.add(comb4);

String query = "SELECT id_salle FROM salle";

try {   
	PreparedStatement prepare = ConnexionBDD.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	
	ResultSet result = prepare.executeQuery();
	
	while (result.next()){
		comb4.addItem(result.getInt("id_salle"));
	}
}
catch (SQLException exc) {
	exc.printStackTrace();
}


String query1 = "SELECT DISTINCT nom_promo FROM promotion";

try {   


	PreparedStatement prepare1 = ConnexionBDD.getInstance().prepareStatement(query1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	
	ResultSet result1 = prepare1.executeQuery();
	
	while (result1.next()){
		comb5.addItem(result1.getString("nom_promo"));
	}


}
catch (SQLException exc) {
	exc.printStackTrace();
}

pan7.add(l5);
pan7.add(comb5);

String query2 = "SELECT DISTINCT nom_formateur FROM formateur";

try {   


	PreparedStatement prepare2= ConnexionBDD.getInstance().prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	
	ResultSet result2 = prepare2.executeQuery();
	
	while (result2.next()){
		comb6.addItem(result2.getString("nom_formateur"));
	}


}
catch (SQLException exc) {
	exc.printStackTrace();
}

pan7.add(l6);
pan7.add(comb6);

String query3 = "SELECT DISTINCT intitule_cours FROM matiere";

try {   


	PreparedStatement prepare3= ConnexionBDD.getInstance().prepareStatement(query3, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	
	ResultSet result3 = prepare3.executeQuery();
	
	while (result3.next()){
		comb7.addItem(result3.getString("intitule_cours"));
	}


}
catch (SQLException exc) {
	exc.printStackTrace();
}

pan7.add(l7);
pan7.add(comb7);

pan7.add(creer);
pan7.add(modif);



creer.addActionListener((new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent event) {
		

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		//System.out.println("utilDate:" + utilDate);
		//System.out.println("sqlDate:" + sqlDate);

		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, (int) comb3.getSelectedItem());
		myCal.set(Calendar.MONTH, (int) comb2.getSelectedItem());
		myCal.set(Calendar.DAY_OF_MONTH, (int) comb1.getSelectedItem());
		java.util.Date a = myCal.getTime();
		java.sql.Date aa = new java.sql.Date(a.getTime());

		
		
		int b=(int) comb4.getSelectedItem();
		String c=(String) comb5.getSelectedItem();
		String d=(String) comb6.getSelectedItem();
		String e=(String) comb7.getSelectedItem();
		
		Responsable.ajouterPlanning(aa, b, c, d, e);
		
	}}));

modif.addActionListener((new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent event) {
		

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("utilDate:" + utilDate);
		System.out.println("sqlDate:" + sqlDate);

		Calendar myCal = Calendar.getInstance();
		myCal.set(Calendar.YEAR, (int) comb3.getSelectedItem());
		myCal.set(Calendar.MONTH, (int) comb2.getSelectedItem());
		myCal.set(Calendar.DAY_OF_MONTH, (int) comb1.getSelectedItem());
		java.util.Date a = myCal.getTime();
		java.sql.Date aa = new java.sql.Date(a.getTime());

		
		
		int b=(int) comb4.getSelectedItem();
		String c=(String) comb5.getSelectedItem();
		String d=(String) comb6.getSelectedItem();
		String e=(String) comb7.getSelectedItem();
		
		Responsable.modifierPlanning(aa, b, c, d, e);
		
	}}));
//FIN CODE AMEL ***********************************************









setVisible(true);
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	}
		

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		

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


