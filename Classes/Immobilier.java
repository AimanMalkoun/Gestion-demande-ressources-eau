package Classes;

import java.io.File;

public class Immobilier {

	private String localisation;
	private String douar;
	private String commune;
	private String province;
	private File attestationDePocession;
	
	public Immobilier() {
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "Localisation = " + localisation
				+"\ndouar = " + douar
				+"\ncommune = " + commune
				+"\nprovince = " + province
				+"\nattestation de pocession d'immobilier = " + (attestationDePocession != null ? attestationDePocession.getPath() : "null");
	}
	
	//getters and setters
	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
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

}
