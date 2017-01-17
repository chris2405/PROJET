package Projet;
import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JDialog;



public class MainProjet {

	public static void main(String[] args) {
	Connect();
	
	 
	Fenetre fen=new Fenetre();
	
	//DatePlannnig date=new DatePlannnig(20,04,2017);
	//System.out.println(date);
	
	
	//System.out.println();
	
	

	}

	
	public static void Connect(){
		try {

		   


		      String url = "jdbc:postgresql://localhost:5432/campus";

		      String user = "postgres";

		      String passwd = "24261305";


		      Connection conn = DriverManager.getConnection(url, user, passwd);

		      System.out.println("Connexion effective !");    
		      
		      
		      Statement state = conn.createStatement();

		      //L'objet ResultSet contient le résultat de la requête SQL

		      ResultSet result = state.executeQuery("SELECT * FROM DATE ");

		      //On récupère les MetaData

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
		      state.close();

		    } catch (Exception e) {

		      e.printStackTrace();

		    }      
		
	}

	public static void affiche(){
		
		
		
	}
	
}
		
