package Classes;

import java.io.File;

public class PointDeau {
	/*
	 * declaration des attributs (private) .
	 */

	private String localisationPoint;
	private float debit;
	private float profondeur;
	private File planEau;
	private float rabattement;

	

	//Constructeur par defaut il metre tout les atribut null
	public PointDeau() {
		
	}

	/*
	 * le constricteur de la classe initialisé par les attributs .
	 */

	public PointDeau(String localisationPoint, float debit, float profondeur, File planEau, float rabattement) {

		setLocalisationPoint(localisationPoint);
		setDebit(debit);
		setProfondeur(profondeur);
		setPlanEau(planEau);
		setRabattement(rabattement);
	}

	/*
	 * le constricteur de la classe initialisé par l'objet PointDeau.
	 */

	public PointDeau(PointDeau pointDeau) {
		setLocalisationPoint(pointDeau.localisationPoint);
		setDebit(pointDeau.debit);
		setProfondeur(pointDeau.profondeur);
		setPlanEau(pointDeau.planEau);
		setRabattement(pointDeau.rabattement);
	}
	
	/*
	 * les getters et les setters des attributs de la classe.
	 */

	public String getLocalisationPoint() {
		return localisationPoint;
	}

	public void setLocalisationPoint(String localisationPoint) {
		this.localisationPoint = localisationPoint;
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

	public File getPlanEau() {
		return planEau;
	}

	public void setPlanEau(File planEau) {
		this.planEau = planEau;
	}

	public float getRabattement() {
		return rabattement;
	}

	public void setRabattement(float rabattement) {
		this.rabattement = rabattement;
	}


}
