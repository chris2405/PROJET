package Projet;

public class Campus {
protected String nom;
protected String ville;
protected int nbPromo;
protected int nbEtudiant;

public Campus(){}

public int compterPromo(){
	//  dans bdd ? count nbr idpromo where idCampus is ?
	return nbPromo;
}

public int compterEtudiant(){
	//  dans bdd ? count nbr idetudiant where idCampus is ?
	return nbEtudiant;
}

}

