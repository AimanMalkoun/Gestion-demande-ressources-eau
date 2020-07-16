package Classes;

import java.io.File;

public class PointEau {

	private String localisation;
	private float debit;
	private float profondeur;
	private float rabattement;
	private File planFile;
	public PointEau() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String toString() {
		return "Localisation = " + localisation
				+"\ndouar = " + debit
				+"\ncommune = " + profondeur
				+"\nprovince = " + rabattement
				+"\nattestation de pocession d'immobilier = " + (planFile != null ? planFile.getPath() : "null");
	}
	
	//getters and setters
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public float getDebit() {
		return debit;
	}
	public void setDebit(float debit) {
		this.debit = debit;
	}
	public float getProfondeur() {
		return profondeur;
	}
	public void setProfondeur(float profondeur) {
		this.profondeur = profondeur;
	}
	public float getRabattement() {
		return rabattement;
	}
	public void setRabattement(float rabattement) {
		this.rabattement = rabattement;
	}


	public File getPlanFile() {
		return planFile;
	}


	public void setPlanFile(File planFile) {
		this.planFile = planFile;
	}

}
