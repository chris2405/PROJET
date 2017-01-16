package Projet;

import java.util.ArrayList;


public class Salle {
	protected int capacite;
	ArrayList<Equipement> array = new ArrayList<Equipement>();

	public Salle(){
		
	}
	
	public boolean salleDispo(){
		
		return true;// true si dispo, false si occupe : connection avec bdd
	}
}
