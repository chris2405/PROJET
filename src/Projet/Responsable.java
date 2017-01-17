package Projet;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Responsable extends Personne{
	
	public Responsable(){}
	
	
	
	public void afficherListeSalle(){
			 
		 //Création d'un objet Statement
		Statement state;
		
		try{
			//verifier la connexion
			state = ConnexionBDD.getInstance().createStatement();
		
	      
	      //L'objet ResultSet contient le résultat de la requête SQL
	      ResultSet result = state.executeQuery("SELECT * FROM salle");
	      
	      while(result.next()){ 
	    	System.out.println("idsalle : "+result.getInt("idsalle"));	
	        System.out.println("nom de la salle : "+result.getString("nom"));
	        System.out.println("capacite de la salle : "+result.getInt("capacite"));
	        System.out.println("idcampus : "+result.getInt("idcampus"));
	        System.out.println("idequipement : "+result.getInt("idequipement"));
	        System.out.println();
	       
	      }
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	public void afficherListePromos(){
		System.out.println("une liste des promos");
		
	
		Statement state;
				
		try{
			//verifier la connexion
			state = ConnexionBDD.getInstance().createStatement();
				
			      
			 //L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = state.executeQuery("SELECT * FROM promotion");
			      
			while(result.next()){ 
			   System.out.println("idpromo : "+result.getInt("idpromo"));	
			   System.out.println("nom de la promotion : "+result.getString("nom"));
			   System.out.println();
			       
			      }
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}

