package Classes;

import java.io.File;
import java.sql.Blob;
import java.time.LocalDate;

public class Demandeur {

	private String nom;
	private String prenom;
	private String cin;
	private LocalDate dateDepotDossier;
	private String typeDemande;
	private File cinFile;
	private File demandeFile;
	
	
	public Demandeur() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "nom = " + nom
				+"\nprenom = " + prenom
				+"\ncin = " + cin
				+"\ndate = " + dateDepotDossier
				+"\ntype de demande = " + typeDemande
				+"\ncinImage = " + (cinFile != null ? cinFile.getPath() : "null")
				+"\ndemande file = " + (demandeFile != null ? demandeFile.getPath() : "null");
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


	public String getCin() {
		return cin;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public LocalDate getDateDepotDossier() {
		return dateDepotDossier;
	}


	public void setDateDepotDossier(LocalDate dateDepotDossier) {
		this.dateDepotDossier = dateDepotDossier;
	}


	public String getTypeDemande() {
		return typeDemande;
	}


	public void setTypeDemande(String typeDemande) {
		this.typeDemande = typeDemande;
	}


	public File getCinFile() {
		return cinFile;
	}


	public void setCinFile(File cinImg) {
		this.cinFile = cinImg;
	}


	public File getDemandeFile() {
		return demandeFile;
	}


	public void setDemandeFile(File demandeFile) {
		this.demandeFile = demandeFile;
	}

}
