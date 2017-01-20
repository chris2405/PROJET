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
	
		
	Responsable res = null;
	Fenetre fen=new Fenetre(res);
	

	}

	
	

	public static void Connect(){
		try {

		   Class.forName("org.postgresql.Driver");

		      System.out.println("Driver O.K.");


		      String url = "jdbc:postgresql://localhost:5432/campus";

		      String user = "postgres";

		      String passwd = "24261305";


		      Connection conn = DriverManager.getConnection(url, user, passwd);

		      System.out.println("Connexion effective !");    
		    

		    } catch (Exception e) {

		      e.printStackTrace();

		    }      
		
		  }

	
}
		
