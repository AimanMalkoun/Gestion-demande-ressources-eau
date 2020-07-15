package Classes;

public class Demandeur {
	/*
	 * declaration des attributs (private) .
	 */
	
	private String cin;
	private String nom;
	private String prenom;
	
	/*
	 * le constricteur de la classe initialisé par les attributs .
	 */
	
	public Demandeur(String cin, String nom, String prenom) {
		setCin(cin);
		setNom(nom);
		setPrenom(prenom);
	}
	
	/*
	 * le constricteur de la classe initialisé par l'objet Limmobilier.
	 */

	public Demandeur(Demandeur demandeur) {
		setCin(demandeur.cin);
		setNom(demandeur.nom);
		setPrenom(demandeur.prenom);

	}
	
	/*
	 * les getters et les setters des attributs de la classe.
	 */

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
