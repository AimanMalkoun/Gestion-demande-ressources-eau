package Classes;

import java.sql.Blob;
import java.time.LocalDate;

public class DossierForDownload {
	@Override
	public String toString() {
		return "DossierForDownload [IdDossier=" + IdDossier + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin
				+ ", dateDepotDossier=" + dateDepotDossier + ", typeDemande=" + typeDemande + ", cinFile=" + cinFile
				+ ", demandeFile=" + demandeFile + ", localisation=" + localisation + ", douar=" + douar + ", commune="
				+ commune + ", province=" + province + ", attestationDePocession=" + attestationDePocession
				+ ", localisationPoint=" + localisationPoint + ", debit=" + debit + ", profondeur=" + profondeur
				+ ", planEau=" + planEau + ", rabattement=" + rabattement + ", dateDepot=" + dateDepot
				+ ", dateEnvoiA_LABHOER=" + dateEnvoiA_LABHOER + ", dateDebutde_EP=" + dateDebutde_EP + ", dateFin_EP="
				+ dateFin_EP + ", dateSignateureDuPv=" + dateSignateureDuPv + ", dateEnvoiDuPVa_LABHOER="
				+ dateEnvoiDuPVa_LABHOER + ", avisDe_CEP=" + avisDe_CEP + ", avisABHOER=" + avisABHOER
				+ ", autorisation=" + autorisation + ", getIdDossier()=" + getIdDossier() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getCin()=" + getCin() + ", getDateDepotDossier()="
				+ getDateDepotDossier() + ", getTypeDemande()=" + getTypeDemande() + ", getCinFile()=" + getCinFile()
				+ ", getDemandeFile()=" + getDemandeFile() + ", getLocalisation()=" + getLocalisation()
				+ ", getDouar()=" + getDouar() + ", getCommune()=" + getCommune() + ", getProvince()=" + getProvince()
				+ ", getAttestationDePocession()=" + getAttestationDePocession() + ", getLocalisationPoint()="
				+ getLocalisationPoint() + ", getDebit()=" + getDebit() + ", getProfondeur()=" + getProfondeur()
				+ ", getPlanEau()=" + getPlanEau() + ", getRabattement()=" + getRabattement() + ", getDateDepot()="
				+ getDateDepot() + ", getDateEnvoiA_LABHOER()=" + getDateEnvoiA_LABHOER() + ", getDateDebutde_EP()="
				+ getDateDebutde_EP() + ", getDateFin_EP()=" + getDateFin_EP() + ", getDateSignateureDuPv()="
				+ getDateSignateureDuPv() + ", getDateEnvoiDuPVa_LABHOER()=" + getDateEnvoiDuPVa_LABHOER()
				+ ", getAvisDe_CEP()=" + getAvisDe_CEP() + ", getAvisABHOER()=" + getAvisABHOER()
				+ ", getAutorisation()=" + getAutorisation() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}


	/*
	 * declaration des attributs (private) .
	 */
	private int IdDossier;
	
	//Demandeur attributs
	private String nom;
	private String prenom;
	private String cin;
	private LocalDate dateDepotDossier;
	private String typeDemande;
	private Blob cinFile;
	private Blob demandeFile;
	
	//immobilier attributs
	private String localisation;
	private String douar;
	private String commune;
	private String province;
	private Blob attestationDePocession;
	
	//point d'eau attributs
	private String localisationPoint;
	private float debit;
	private float profondeur;
	private Blob planEau;
	private float rabattement;
	
	//suivi du dossier attributs
	private LocalDate dateDepot;
	private LocalDate dateEnvoiA_LABHOER;
	private LocalDate dateDebutde_EP;
	private LocalDate dateFin_EP;
	private LocalDate dateSignateureDuPv;
	private LocalDate dateEnvoiDuPVa_LABHOER;
	
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


	public LocalDate getDateDepotDossier() {
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


	public String getLocalisation() {
		return localisation;
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


	public Blob getPlanEau() {
		return planEau;
	}


	public float getRabattement() {
		return rabattement;
	}


	public LocalDate getDateDepot() {
		return dateDepot;
	}


	public LocalDate getDateEnvoiA_LABHOER() {
		return dateEnvoiA_LABHOER;
	}


	public LocalDate getDateDebutde_EP() {
		return dateDebutde_EP;
	}


	public LocalDate getDateFin_EP() {
		return dateFin_EP;
	}


	public LocalDate getDateSignateureDuPv() {
		return dateSignateureDuPv;
	}


	public LocalDate getDateEnvoiDuPVa_LABHOER() {
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


	public void setIdDossier(int idDossier) {
		IdDossier = idDossier;
	}


	//Setters
	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public void setCin(String cin) {
		this.cin = cin;
	}


	public void setDateDepotDossier(LocalDate dateDepotDossier) {
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


	public void setLocalisation(String localisation) {
		this.localisation = localisation;
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


	public void setPlanEau(Blob planEau) {
		this.planEau = planEau;
	}


	public void setRabattement(float rabattement) {
		this.rabattement = rabattement;
	}


	public void setDateDepot(LocalDate dateDepot) {
		this.dateDepot = dateDepot;
	}


	public void setDateEnvoiA_LABHOER(LocalDate dateEnvoiA_LABHOER) {
		this.dateEnvoiA_LABHOER = dateEnvoiA_LABHOER;
	}


	public void setDateDebutde_EP(LocalDate dateDebutde_EP) {
		this.dateDebutde_EP = dateDebutde_EP;
	}


	public void setDateFin_EP(LocalDate dateFin_EP) {
		this.dateFin_EP = dateFin_EP;
	}


	public void setDateSignateureDuPv(LocalDate dateSignateureDuPv) {
		this.dateSignateureDuPv = dateSignateureDuPv;
	}


	public void setDateEnvoiDuPVa_LABHOER(LocalDate dateEnvoiDuPVa_LABHOER) {
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

}
