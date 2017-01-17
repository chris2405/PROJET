package Projet;

import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;


public class DatePlannnig {
	//variable
	private int mois;
	private int jour;
	private int annee;
	
//Constructor
public DatePlannnig(int jour,int mois,int annee) {
		
		this.mois = mois;
		this.jour = jour;
		this.annee = annee;
	}

public DatePlannnig() {
	 
Calendar cal=Calendar.getInstance();
this.annee=cal.get(Calendar.YEAR);
this.jour=cal.get(Calendar.DAY_OF_MONTH);
this.mois=cal.get(Calendar.MONTH)+1;


}

//get && set

public int getMois() {
		return mois;
	}

	public void setMois(int mois) {
		this.mois = mois;
	}

	public int getJour() {
		return jour;
	}

	public void setJour(int jour) {
		this.jour = jour;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	
	//public type method(){}
public void afficherDate(){
	System.out.println(jour+"/"+mois+"/"+annee);
	
}
	
public boolean egale(DatePlannnig autre) {
	
	boolean res=false;
	
	if(this.annee==autre.getAnnee()){
		res=true;System.out.println("Les dates sont identiques");
		
	}
	else {res=false;
	System.out.println("les dates sont différentes");}
	return res;	
}

public int compare(DatePlannnig date2){
	
	int res;
	
	if (this.annee==date2.getAnnee() && this.mois==date2.getMois() && this.jour==date2.getJour()){
		res = 0;
		System.out.println("Les deux années sont identiques !");
		
	}
	else if ((this.annee>date2.getAnnee()) || ((this.annee==date2.getAnnee()) && (this.mois>date2.getMois())) || ((this.mois==date2.getMois()) && (this.jour>date2.getJour()))){
		res= -1;
	System.out.println("L'année la plus petite est : " + date2.getJour() + "/" + date2.getMois() + "/" + date2.getAnnee());
	}
	
	else{
		res = 1;
	System.out.println("L'année la plus petite est : " + this.jour + "/" + this.mois + "/" + this.annee);
	}
	return res;
}

public String toString(){
	String a = "";
	
	if (jour < 10) a = a + "0" + jour +"/";
	
	else a = a + jour + "/";
	
	if (mois < 10 ) a = a + "0" + mois + "/";
	
	else a = a + mois + "/";
	
	a = a + annee;
	
	return a;
}
public String dateEnLettre()
{
	String[] nomMois = {"Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Décembre"};
	
	String mOis = nomMois[mois-1];
	//System.out.println("indice mois " + mois);
	return jour +" "+ mOis + " " +annee;
	
}
	public  String moisLettre() {
		
		String result = "";
		switch (this.mois) {
		case 1:
		result = "Janvier";
		break;
		case 2:
		result = "Fevrier";
		break;
		case 3:
		result = "Mars";
		break;
		case 4:
		result = "Avril";
		break;
		case 5:
		result="Mai";
		break;
		case 6:
		result = "juin";
		break;
		case 7:
		result = "juillet";
		break;
		case 8:
		result = "Août";
		break;
		case 9:
		result = "Septembre";
		break;
		case 10:
		result = "Octobre";
		break;
		case 11:
		result= "Novembre";
		break;
		case 12:
		result= "Decembre";
		break;
		// default:
		// break;
		}
		 
		System.out.println(this.jour+" "+result+" "+this.annee);
		return result;
		
		}

	


	
	
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	










	


		
		
		
		
		
		
		
	




