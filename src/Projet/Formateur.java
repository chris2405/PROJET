package Projet;

public class Formateur extends Etudiant {
	protected Matiere[] tabMatiere;
public Formateur(Matiere[] matieres){
	super();
	this.tabMatiere=matieres;
}

public String enseigner(){
	return ("J'enseigne le "+this.tabMatiere);
}
}