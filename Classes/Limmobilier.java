package Classes;

public class Limmobilier {
	/*
	 * declaration des attributs (private) .
	 */
	
	private String localisationImm;
	private String douar;
	private String commune;
	private String province;

	/*
	 * le constricteur de la classe initialisé par les attributs .
	 */
	
	public Limmobilier(String localisationImm, String douar, String commune, String province) {

		setLocalisation(localisationImm);
		setDouar(douar);
		setCommune(commune);
		setProvince(province);

	}
	
	/*
	 * le constricteur de la classe initialisé par l'objet Limmobilier.
	 */

	public Limmobilier(Limmobilier immobilier) {
		setLocalisation(immobilier.localisationImm);
		setDouar(immobilier.douar);
		setCommune(immobilier.commune);
		setProvince(immobilier.province);
	}
	
	/*
	 * les getters et les setters des attributs de la classe.
	 */
	public String getLocalisation() {
		return localisationImm;
	}

	public void setLocalisation(String localisation) {
		this.localisationImm = localisation;
	}

	public String getDouar() {
		return douar;
	}

	public void setDouar(String douar) {
		this.douar = douar;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}
