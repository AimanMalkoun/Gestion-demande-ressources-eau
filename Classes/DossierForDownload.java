package Classes;

import java.sql.Blob;

public class DossierForDownload {
	
	/*
	 * declaration des attributs (private) .
	 */
	private int IdDossier;
	
	//Demandeur attributs
	private String nom;
	private String prenom;
	private String cin;
	private String dateDepotDossier;
	private String typeDemande;
	private Blob cinFile;
	private Blob demandeFile;
	
	//immobilier attributs
	private String nomImmobilier;
	private String daaira;
	private String quiada;
	private String douar;
	private String commune;
	private String province;
	private Blob attestationDePocession;
	private Blob planImmobilier;
	
	//point d'eau attributs
	private String localisationPoint;
	private float debit;
	private float profondeur;
	private float planEau;
	
	//suivi du dossier attributs
	private String dateDepot;
	private String dateEnvoiA_LABHOER;
	private String dateDebutde_EP;
	private String dateFin_EP;
	private String dateSignateureDuPv;
	private String dateEnvoiDuPVa_LABHOER;
	
	private String avisDe_CEP;
	private String avisABHOER;
	private String autorisation;
	

	/*
	 * le constricteur de la classe initialisé par les attributs .
	 */
	
	public DossierForDownload() {
		
	}


	//Getters
	public int getIdDossier() {
		return IdDossier;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public String getCin() {
		return cin;
	}


	public String getDateDepotDossier() {
		return dateDepotDossier;
	}


	public String getTypeDemande() {
		return typeDemande;
	}


	public Blob getCinFile() {
		return cinFile;
	}


	public Blob getDemandeFile() {
		return demandeFile;
	}

	public String getDouar() {
		return douar;
	}


	public String getCommune() {
		return commune;
	}


	public String getProvince() {
		return province;
	}


	public Blob getAttestationDePocession() {
		return attestationDePocession;
	}


	public String getLocalisationPoint() {
		return localisationPoint;
	}


	public float getDebit() {
		return debit;
	}


	public float getProfondeur() {
		return profondeur;
	}


	public float getPlanEau() {
		return planEau;
	}


	public String getDateDepot() {
		return dateDepot;
	}


	public String getDateEnvoiA_LABHOER() {
		return dateEnvoiA_LABHOER;
	}


	public String getDateDebutde_EP() {
		return dateDebutde_EP;
	}


	public String getDateFin_EP() {
		return dateFin_EP;
	}


	public String getDateSignateureDuPv() {
		return dateSignateureDuPv;
	}


	public String getDateEnvoiDuPVa_LABHOER() {
		return dateEnvoiDuPVa_LABHOER;
	}


	public String getAvisDe_CEP() {
		return avisDe_CEP;
	}


	public String getAvisABHOER() {
		return avisABHOER;
	}


	public String getAutorisation() {
		return autorisation;
	}


	public String getNomImmobilier() {
		return nomImmobilier;
	}


	public String getDaaira() {
		return daaira;
	}


	public String getQuiada() {
		return quiada;
	}


	public Blob getPlanImmobilier() {
		return planImmobilier;
	}


	//Setters
	public void setNomImmobilier(String nomImmobilier) {
		this.nomImmobilier = nomImmobilier;
	}


	public void setDaaira(String daaira) {
		this.daaira = daaira;
	}


	public void setQuiada(String quiada) {
		this.quiada = quiada;
	}


	public void setPlanImmobilier(Blob planImmobilier) {
		this.planImmobilier = planImmobilier;
	}


	public void setIdDossier(int idDossier) {
		IdDossier = idDossier;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public void setDateDepotDossier(String dateDepotDossier) {
		this.dateDepotDossier = dateDepotDossier;
	}


	public void setTypeDemande(String typeDemande) {
		this.typeDemande = typeDemande;
	}


	public void setCinFile(Blob cinFile) {
		this.cinFile = cinFile;
	}


	public void setDemandeFile(Blob demandeFile) {
		this.demandeFile = demandeFile;
	}

	
	public void setDouar(String douar) {
		this.douar = douar;
	}


	public void setCommune(String commune) {
		this.commune = commune;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	public void setAttestationDePocession(Blob attestationDePocession) {
		this.attestationDePocession = attestationDePocession;
	}


	public void setLocalisationPoint(String localisationPoint) {
		this.localisationPoint = localisationPoint;
	}


	public void setDebit(float debit) {
		this.debit = debit;
	}


	public void setProfondeur(float profondeur) {
		this.profondeur = profondeur;
	}


	public void setPlanEau(float planEau) {
		this.planEau = planEau;
	}


	public void setDateDepot(String dateDepot) {
		this.dateDepot = dateDepot;
	}


	public void setDateEnvoiA_LABHOER(String dateEnvoiA_LABHOER) {
		this.dateEnvoiA_LABHOER = dateEnvoiA_LABHOER;
	}


	public void setDateDebutde_EP(String dateDebutde_EP) {
		this.dateDebutde_EP = dateDebutde_EP;
	}


	public void setDateFin_EP(String dateFin_EP) {
		this.dateFin_EP = dateFin_EP;
	}


	public void setDateSignateureDuPv(String dateSignateureDuPv) {
		this.dateSignateureDuPv = dateSignateureDuPv;
	}


	public void setDateEnvoiDuPVa_LABHOER(String dateEnvoiDuPVa_LABHOER) {
		this.dateEnvoiDuPVa_LABHOER = dateEnvoiDuPVa_LABHOER;
	}


	public void setAvisDe_CEP(String avisDe_CEP) {
		this.avisDe_CEP = avisDe_CEP;
	}


	public void setAvisABHOER(String avisABHOER) {
		this.avisABHOER = avisABHOER;
	}


	public void setAutorisation(String autorisation) {
		this.autorisation = autorisation;
	}


	@Override
	public String toString() {
		return    "DossierForDownload [\nIdDossier=" + IdDossier + "\n nom=" + nom + "\n prenom=" + prenom + "\n cin=" + cin
				+ "\n dateDepotDossier=" + dateDepotDossier + "\n typeDemande=" + typeDemande + "\n cinFile=" + cinFile
				+ "\n demandeFile=" + demandeFile + "\n nomImmobilier=" + nomImmobilier + "\n daaira=" + daaira
				+ "\n quiada=" + quiada + "\n douar=" + douar + "\n commune=" + commune + "\n province=" + province
				+ "\n attestationDePocession=" + attestationDePocession + "\n planImmobilier=" + planImmobilier
				+ "\n localisationPoint=" + localisationPoint + "\n debit=" + debit + "\n profondeur=" + profondeur
				+ "\n planEau=" + planEau  + "\n dateDepot=" + dateDepot
				+ "\n dateEnvoiA_LABHOER=" + dateEnvoiA_LABHOER + "\n dateDebutde_EP=" + dateDebutde_EP + "\n dateFin_EP="
				+ dateFin_EP + "\n dateSignateureDuPv=" + dateSignateureDuPv + "\n dateEnvoiDuPVa_LABHOER="
				+ dateEnvoiDuPVa_LABHOER + "\n avisDe_CEP=" + avisDe_CEP + "\n avisABHOER=" + avisABHOER
				+ "\n autorisation=" + autorisation + "]\n";
	}

	
}
