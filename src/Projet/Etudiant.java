package Projet;

import java.awt.BorderLayout;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

public class Etudiant extends Personne {
	
	public Etudiant(){
		super();
	}
	
	
	
	public int verifierIdentifiants(String a, String b){
		 return super.verifierIdentifiants( login, mdp);
	}
	
	
	public void planningPersoEtudiant(String login, String mdp){
		
		String query = "SELECT id_user FROM public.user WHERE login=? AND mdp=? ";
		  
		try {
			PreparedStatement prepare = ConnexionBDD.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			prepare.setString(1, login);
			prepare.setString(2, mdp);
			
			ResultSet result = prepare.executeQuery();
			
			if (result.next()){
				String query1 = "SELECT id_promo FROM etudiant WHERE id_user= ? ";
      		  
	    		try {
	    			PreparedStatement prepare1 = ConnexionBDD.getInstance().prepareStatement(query1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	    			prepare1.setInt(1, result.getInt("id_user") );
	    			
	    			
	    			ResultSet result1 = prepare1.executeQuery();
	    			
	    			if (result1.next()){
	    			
	    				String query2 = "SELECT * FROM planning WHERE id_promo= ? ";
	          		  
	    				try {
	    					PreparedStatement prepare2 = ConnexionBDD.getInstance().prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	    					prepare2.setString(1, result1.getString("id_promo"));


	    					ResultSet result2= prepare2.executeQuery();
	    					
	    				
	    					ResultSetTableModel rtm = new ResultSetTableModel( result2 );

	    					TablePanel tablePanel = new TablePanel( rtm );

	    					JFrame mainFrame = new JFrame( "Planning Personnel Etudiant " );
							mainFrame.add( tablePanel, BorderLayout.CENTER );
							mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
							mainFrame.setSize( 640, 480 );
							mainFrame.setVisible( true );
	    				} catch (Exception e) {

	    	      		      e.printStackTrace();

	    	      		    }      
	    			}
	    		 } catch (Exception e) {

	      		      e.printStackTrace();

	      		    }      
			}
		 } catch (Exception e) {

		      e.printStackTrace();

		    }      
		}	
	}
	
	
	

