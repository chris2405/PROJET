package Projet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public abstract class  Personne {
	
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

	public static int getCompteur() {
		return compteur;
	}

	public static void setCompteur(int compteur) {
		Personne.compteur = compteur;
	}
	
	public void saisirIdentifiants()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("login : ");
		login = sc.nextLine();
		System.out.print("pwd : ");
		mdp = sc.nextLine();
	}
	
	public boolean verifierIdentifiants()
	{
		String query = "SELECT * FROM user WHERE login=?";
		String query2 = "SELECT * FROM user WHERE login=? AND pwd=?";
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
					
					
					return true;
				}
				//Mot de passe non valide !
				else
				{
					System.out.println("\nAttention le mot de passe est invalide !\n");
					return false;
				}
			}
			else
			{
				System.out.println("\nAttention le login saisi n'existe pas !\n");
				return false;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public static void afficherPlanningGeneral(Date d1, Date d2){
		
		
		String query = "SELECT * From planning where date >= ? and date <= ?";

		try {   

			PreparedStatement prepare = ConnexionBDD.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			prepare.setDate(1, d1);
			
			prepare.setDate(2, d2);
		
		 ResultSet result = prepare.executeQuery();
         

		 }
			catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
	
}
