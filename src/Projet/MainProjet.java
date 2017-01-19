package Projet;
import java.awt.BorderLayout;
import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.plaf.TableUI;



public class MainProjet {

	public static void main(String[] args) {
	
	
    //Connect();
		
	Connect2();	
	Responsable res = null;
	Fenetre fen=new Fenetre(res);
	query();
	
    


	
	
	
	
	

	}

	
	public static void Connect(){
		try {

		   


		      String url = "jdbc:postgresql://localhost:5432/campus";

		      String user = "postgres";

		      String passwd = "24261305";


		      Connection conn = DriverManager.getConnection(url, user, passwd);

		      System.out.println("Connexion effective !");    
		      
		      
		      Statement state = conn.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
					   ResultSet.CONCUR_READ_ONLY);

		      //L'objet ResultSet contient le résultat de la requête SQL

		      ResultSet result = state.executeQuery("SELECT * FROM DATE ");

		      //On récupère les MetaData

		      ResultSetMetaData resultMeta = result.getMetaData();

		         

		      System.out.println("\n**************************************************************************");

		      //On affiche le nom des colonnes

		      for(int i = 1; i <= resultMeta.getColumnCount(); i++)

		       // System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
		    	
		    	  
		      

		      System.out.println("\n**************************************************************************");

		         

		      while(result.next()){         

		        for(int i = 1; i <= resultMeta.getColumnCount(); i++)

		          System.out.print("\t" + result.getObject(i).toString() + "\t |");

		            

		        System.out.println("\n--------------------------------------------------------------------------");
		        
		        
		        

		      }

		      result.close();
		      state.close();

		    } catch (Exception e) {

		      e.printStackTrace();

		    }      
		
	}

	public static void Connect2(){
		try {

		   Class.forName("org.postgresql.Driver");

		      System.out.println("Driver O.K.");


		      String url = "jdbc:postgresql://localhost:5432/campus";

		      String user = "postgres";

		      String passwd = "24261305";


		      Connection conn = DriverManager.getConnection(url, user, passwd);

		      System.out.println("Connexion effective !");    
		     /* 
		      Personne.afficherPlanningGeneral();
		      
		      Statement state = conn.createStatement();

		      //L'objet ResultSet contient le rï¿½sultat de la requï¿½te SQL

		      ResultSet result = state.executeQuery("SELECT * FROM SALLE ");

		      //On rï¿½cupï¿½re les MetaData

		      ResultSetMetaData resultMeta = result.getMetaData();

		         

		      System.out.println("\n**************************************************************************");

		      //On affiche le nom des colonnes

		      for(int i = 1; i <= resultMeta.getColumnCount(); i++)

		        System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");

		         

		      System.out.println("\n**************************************************************************");

		         

		      while(result.next()){         

		        for(int i = 1; i <= resultMeta.getColumnCount(); i++)

		          System.out.print("\t" + result.getObject(i).toString() + "\t |");

		            

		        System.out.println("\n--------------------------------------------------------------------------");

		      }

		      result.close();
		      state.close();*/

		    } catch (Exception e) {

		      e.printStackTrace();

		    }      
		
		  }

	public static void query(){
		try
	    {
	        Statement st = ConnexionBDD.getInstance().createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
	                								   ResultSet.CONCUR_READ_ONLY );
	        
	        ResultSet rs = st.executeQuery( "SELECT * FROM planning" );
	        ResultSetTableModel rtm = new ResultSetTableModel( rs );
	        
	        TablePanel tablePanel = new TablePanel( rtm );
	        
	        JFrame mainFrame = new JFrame( "Affiche table " );
	        mainFrame.add( tablePanel, BorderLayout.CENTER );
	        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	        mainFrame.setSize( 640, 480 );
	        mainFrame.setVisible( true );
	    } 
	    catch ( SQLException e )
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace();}
		
	}
}
		
