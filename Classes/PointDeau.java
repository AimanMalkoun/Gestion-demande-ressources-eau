package Classes;

public class PointDeau {
	/*
	 * declaration des attributs (private) .
	 */

	private String localisationPoint;
	private float debit;
	private float profondeur;
	private float planEau;

	// Constructeur par defaut il metre tout les atribut null
	public PointDeau() {

	}

	/*
	 * le constricteur de la classe initialisť par les attributs .
	 */

	public PointDeau(String localisationPoint, float debit, float profondeur, float poinEau) {

		setLocalisationPoint(localisationPoint);
		setDebit(debit);
		setProfondeur(profondeur);
		setPlanEau(poinEau);

	}

	/*
	 * le constricteur de la classe initialisť par l'objet PointDeau.
	 */

	public PointDeau(PointDeau pointDeau) {
		setLocalisationPoint(pointDeau.localisationPoint);
		setDebit(pointDeau.debit);
		setProfondeur(pointDeau.profondeur);
		setPlanEau(pointDeau.planEau);

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

	public float getPlanEau() {
		return planEau;
	}

	public void setPlanEau(float planEau) {
		this.planEau = planEau;
	}

}
