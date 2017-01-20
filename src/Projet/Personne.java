package Projet;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class  Personne {
	
	protected String nom,prenom,adresse,age,sexe, login, mdp;
	public static int compteur;
	
	
	public Personne() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public String getlogin() {
		return login;
	}

	public void setlogin(String login) {
		this.login = login;
	}

	public String getmdp() {
		return mdp;
	}

	public void setmdp(String mdp) {
		this.mdp = mdp;
	}

	public static int getCompteur() {
		return compteur;
	}

	public static void setCompteur(int compteur) {
		Personne.compteur = compteur;
	}

	
	public int verifierIdentifiants(String login,String mdp)
	{
		int statut = 0;
		String query = "SELECT * FROM public.user WHERE login=?";
		String query2 = "SELECT * FROM public.user WHERE login=? AND mdp=?";
		try {
			PreparedStatement prepare = ConnexionBDD.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepare.setString(1, login);
			
			ResultSet result = prepare.executeQuery();
			
			//Si login existe
			if(result.first())
			{
				PreparedStatement prepare2 = ConnexionBDD.getInstance().prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				prepare2.setString(1, login);
				prepare2.setString(2, mdp);
				
				ResultSet result2 = prepare2.executeQuery();
				//user identifie
				if(result2.first())
				{
					System.out.println("\nIdentification OK...\n");
					System.out.println("id : "+result2.getInt("id_user"));
					String query3 = "SELECT * FROM admin WHERE (id_user =?)";
					try {   

						PreparedStatement prepare3 = ConnexionBDD.getInstance().prepareStatement(query3, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						prepare3.setInt(1, result2.getInt("id_user"));
					    ResultSet result3 = prepare3.executeQuery();
					    
					    if (result3.first()){
					    	statut=1;
					    }
					    else{
					    	String query4 = "SELECT * FROM responsable WHERE (id_user =?)";
							try {   

								PreparedStatement prepare4 = ConnexionBDD.getInstance().prepareStatement(query4, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
								prepare4.setInt(1, result2.getInt("id_user"));
							    ResultSet result4 = prepare4.executeQuery();
							    
							    if (result4.first()){
							    	statut=2;
							    }
							    else{
							    	String query5 = "SELECT * FROM formateur WHERE (id_user =?)";
									try {   

										PreparedStatement prepare5 = ConnexionBDD.getInstance().prepareStatement(query5, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
										prepare5.setInt(1, result2.getInt("id_user"));
									    ResultSet result5 = prepare5.executeQuery();
									    
									    if (result5.first()){
									    	statut=3;
									    }
									    else{
									    	
									    	String query6 = "SELECT * FROM etudiant WHERE (id_user =?)";
											try {   

												PreparedStatement prepare6 = ConnexionBDD.getInstance().prepareStatement(query6, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
												prepare6.setInt(1, result2.getInt("id_user"));
											    ResultSet result6 = prepare6.executeQuery();
											    
											    if (result6.first()){
											    statut=4;
											    
											    }
											    

											 }
												catch (SQLException e) {
													e.printStackTrace();
												}
												
									    }
							         

									 }
										catch (SQLException e) {
											e.printStackTrace();
										}
										
							    	
							    }
					         

							 }
								catch (SQLException e) {
									e.printStackTrace();
								}
								
					    }
			         

					 }
						catch (SQLException e) {
							e.printStackTrace();
						}
						
				}
				//Mot de passe non valide !
				else
				{
					
					statut=-1;
				}
			}
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("statut : "+statut);
		return statut;
	}
	
	
	public static void planningGeneralPersonnalise(Date d1, Date d2){
		
		
		String query = "SELECT * From planning where date >= ? and date <= ?";

		try {   

			PreparedStatement prepare = ConnexionBDD.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			prepare.setDate(1, d1);
			
			prepare.setDate(2, d2);
		
		 ResultSet result = prepare.executeQuery();
		 ResultSetTableModel rtm = new ResultSetTableModel( result );

			TablePanel tablePanel = new TablePanel( rtm );

			JFrame mainFrame = new JFrame( "Planning General Personnalise " );
			mainFrame.add( tablePanel, BorderLayout.CENTER );
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
			mainFrame.setSize( 640, 480 );
			mainFrame.setVisible( true );
         

		 }
			catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
	
}
