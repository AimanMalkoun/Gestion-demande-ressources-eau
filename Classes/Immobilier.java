package Classes;

import java.io.File;

public class Immobilier {

	private String daiira;
	private String quiada;
	private String douar;
	private String commune;
	private String province;
	private File attestationDePocession;
	private File planImmobilier;
	
	public Immobilier() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Localisation = " + daiira
				+"\ndouar = " + douar
				+"\ncommune = " + commune
				+"\nprovince = " + province
				+"\nattestation de pocession d'immobilier = " + (attestationDePocession != null ? attestationDePocession.getPath() : "null");
	}
	
	//getters and setters
	public String getDaaira() {
		return daiira;
	}

	public void setDaaira(String localisation) {
		this.daiira = localisation;
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

	public File getAttestationDePocession() {
		return attestationDePocession;
	}

	public void setAttestationDePocession(File attestationDePocession) {
		this.attestationDePocession = attestationDePocession;
	}

	public File getPlanImmobilier() {
		return planImmobilier;
	}

	public void setPlanImmobilier(File planImmobilier) {
		this.planImmobilier = planImmobilier;
	}

	public String getQuiada() {
		return quiada;
	}

	public void setQuiada(String quiada) {
		this.quiada = quiada;
	}

}
