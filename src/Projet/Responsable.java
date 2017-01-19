package Projet;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

public class Responsable {
	
	//DatePlanning date=new DatePlanning(j, m, a);
	public Responsable(){
		super();
	}
	
	
	public static void modifierPlanning (Date a, int b, String c, String d, String e){
		//new DatePlanning(int j, int m, int a);
		
		
		String query = "UPDATE planning SET (id_salle = ? AND nom_promo = ? AND nom_formateur = ? AND intitule_cours = ?) WHERE date = ?";


		try {   


			PreparedStatement prepare = ConnexionBDD.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			prepare.setInt(1,b);
			prepare.setString(2, c);
			prepare.setString(3, d);
			prepare.setString(4, e);
			prepare.setDate(5,a);
			prepare.executeUpdate();
			prepare.close();

		}
		catch (SQLException exc) {
			exc.printStackTrace();
		}

	}
	
	public static void supprimerReservation(Date a, int b){
		
		String query = "DELETE * FROM planning WHERE date=? and id_salle=?";
		
		try {   


			PreparedStatement prepare = ConnexionBDD.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			prepare.setDate(1,a);
			prepare.setInt(2,b);
			ResultSet result = prepare.executeQuery();


		}
		catch (SQLException exc) {
			exc.printStackTrace();
		}

		
	}
		
	public static void ajouterPlanning (Date a, int b, String c, String d, String e){
		
		if(!existPlanning( a, b , c, d)){
			
		String query = "INSERT INTO planning (date, id_salle, nom_promo, nom_formateur, intitule_cours) VALUES (?, ?, ?, ?, ?)";
			 
		
		try {   


			PreparedStatement prepare = ConnexionBDD.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			prepare.setDate(1,a);
			prepare.setInt(2, b);
			prepare.setString(3, c);
			prepare.setString(4, d);
			prepare.setString(5,e);
		
			prepare.executeQuery();
			prepare.close();
			


		}
		catch (SQLException exc) {
			exc.printStackTrace();
		}

		}
		
		else{
			System.out.println("ce Planning existe déjà !");
		}
		

	}

	
	public static boolean existPlanning(Date a,int b, String c, String d){

		boolean exist = false;
		
		String query = "SELECT * FROM planning WHERE date = ? AND id_salle = ?";
		
		try {
			PreparedStatement prepare = ConnexionBDD.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			prepare.setDate(1,a);
			prepare.setInt(2, b);


			ResultSet res = prepare.executeQuery();

			if(res.first()){
				System.out.println("la salle est deja reserve pour cette date!");
				exist = true;
			}

		}
		catch (SQLException exc) {
			exc.printStackTrace();
		}
		
		String query1 = "SELECT * FROM planning WHERE date = ? AND nom_promo = ?";

		try {
			PreparedStatement prepare1 = ConnexionBDD.getInstance().prepareStatement(query1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			prepare1.setDate(1,a);
			prepare1.setString(2, c);


			ResultSet res1 = prepare1.executeQuery();

			if(res1.first()){
				System.out.println("cette promo a un cours dans une autre salle!");
				exist = true;
			}

		}
		catch (SQLException exc) {
			exc.printStackTrace();
		}
		
		String query2 = "SELECT * FROM planning WHERE date = ? AND nom_formateur = ?";
		
		try {
			PreparedStatement prepare2 = ConnexionBDD.getInstance().prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			prepare2.setDate(1,a);
			prepare2.setString(2, d);


			ResultSet res2 = prepare2.executeQuery();

			if(res2.first()){
				System.out.println("le formateur enseigne une autre promo!");
				exist = true;
			}

		}
		catch (SQLException exc) {
			exc.printStackTrace();
		}
		
		return exist;

	}
	
	
	
	
}
