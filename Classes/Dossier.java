package Classes;

import java.time.LocalDate;

import javafx.scene.control.Label;

public class Dossier {
	/* 
	 * declaration des attributs (private) 
	 */

	private int idDossier;
	
	private Demandeur demandeur;
	private Immobilier immobilier;
	private PointDeau pointDeau;
	
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
	 *le constricteur de la classe initialis� par les attributs 
	 */

	public Dossier(int idDossier, Demandeur demandeur, Immobilier immobilier, PointDeau pointDeau, LocalDate dateDepot,
				   LocalDate dateEnvoiA_LABHOER, LocalDate dateDebutde_EP, LocalDate dateFin_EP, LocalDate dateSignateureDuPv, String avisDe_CEP,
			       LocalDate dateEnvoiDuPVa_LABHOER, String avisABHOER) {
		setIdDossier(idDossier);
		setDemandeur(demandeur);
		setImmobilier(immobilier);
		setPointDeau(pointDeau);
		setDateDepot(dateDepot);
		setDateEnvoiA_LABHOER(dateEnvoiA_LABHOER);
		setDateDebutde_EP(dateDebutde_EP);
		setDateFin_EP(dateFin_EP);
		setDateSignateureDuPv(dateSignateureDuPv);
		setAvisDe_CEP(avisDe_CEP);
		setDateEnvoiDuPVa_LABHOER(dateEnvoiDuPVa_LABHOER);
		setAvisABHOER(avisABHOER);

	}

	/* 
	 * le constricteur de la classe initialis� par l'objet Dossier 
	 */
	
	public Dossier(Dossier dossier) {
		setIdDossier(dossier.idDossier);
		setDemandeur(dossier.demandeur);
		setImmobilier(dossier.immobilier);
		setPointDeau(dossier.pointDeau);
		setDateDepot(dossier.dateDepot);
		setDateEnvoiA_LABHOER(dossier.dateEnvoiA_LABHOER);
		setDateDebutde_EP(dossier.dateDebutde_EP);
		setDateFin_EP(dossier.dateFin_EP);
		setDateSignateureDuPv(dossier.dateSignateureDuPv);
		setAvisDe_CEP(dossier.avisDe_CEP);
		setDateEnvoiDuPVa_LABHOER(dossier.dateEnvoiDuPVa_LABHOER);
		setAvisABHOER(dossier.avisABHOER);
		setAutorisation(dossier.autorisation);
	}
	
	//constructeur par defaut pour instancier les classe et metre tout les atributs null
	public Dossier() {
		
		demandeur = new Demandeur();
		immobilier = new Immobilier();
		pointDeau = new PointDeau();
		
	}

	/* 
	 * les getters et les setters des attributs de la classe.
	 */
	
	public Dossier(int idDossier2, Demandeur demandeur2, Immobilier infosurimmobilier, PointDeau poinDeau,
			Label dateDepot2) {
		setIdDossier(idDossier);
		setDemandeur(demandeur);
		setImmobilier(immobilier);
		setPointDeau(pointDeau);
		setDateDepot(dateDepot);
		setDateEnvoiA_LABHOER(null);
		setDateDebutde_EP(null);
		setDateFin_EP(null);
		setDateSignateureDuPv(null);
		setAvisDe_CEP(null);
		setDateEnvoiDuPVa_LABHOER(null);
		setAvisABHOER(null);
		
	}

	public int getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(int idDossier) {
		this.idDossier = idDossier;
	}

	public Demandeur getDemandeur() {
		return this.demandeur;
	}

	public void setDemandeur(Demandeur demandeur) {
		this.demandeur = demandeur;
	}

	public Immobilier getImmobilier() {
		return immobilier;
	}

	public void setImmobilier(Immobilier immobilier) {
		this.immobilier = immobilier;
	}

	public PointDeau getPointDeau() {
		return pointDeau;
	}

	public void setPointDeau(PointDeau pointDeau) {
		this.pointDeau = pointDeau;
	}

	public LocalDate getDateDepot() {
		return dateDepot;
	}

	public void setDateDepot(LocalDate dateDepot) {
		this.dateDepot = dateDepot;
	}

	public LocalDate getDateEnvoiA_LABHOER() {
		return dateEnvoiA_LABHOER;
	}

	public void setDateEnvoiA_LABHOER(LocalDate dateEnvoiA_LABHOER) {
		this.dateEnvoiA_LABHOER = dateEnvoiA_LABHOER;
	}

	public LocalDate getDateDebutde_EP() {
		return dateDebutde_EP;
	}

	public void setDateDebutde_EP(LocalDate dateDebutde_EP) {
		this.dateDebutde_EP = dateDebutde_EP;
	}

	public LocalDate getDateFin_EP() {
		return dateFin_EP;
	}

	public void setDateFin_EP(LocalDate dateFin_EP) {
		this.dateFin_EP = dateFin_EP;
	}

	public LocalDate getDateSignateureDuPv() {
		return dateSignateureDuPv;
	}

	public void setDateSignateureDuPv(LocalDate dateSignateureDuPv) {
		this.dateSignateureDuPv = dateSignateureDuPv;
	}

	public String getAvisDe_CEP() {
		return avisDe_CEP;
	}

	public void setAvisDe_CEP(String avisDe_CEP) {
		this.avisDe_CEP = avisDe_CEP;
	}

	public LocalDate getDateEnvoiDuPVa_LABHOER() {
		return dateEnvoiDuPVa_LABHOER;
	}

	public void setDateEnvoiDuPVa_LABHOER(LocalDate dateEnvoiDuPVa_LABHOER) {
		this.dateEnvoiDuPVa_LABHOER = dateEnvoiDuPVa_LABHOER;
	}

	public String getAvisABHOER() {
		return avisABHOER;
	}

	public void setAvisABHOER(String avisABHOER) {
		this.avisABHOER = avisABHOER;
	}

	public String getAutorisation() {
		return autorisation;
	}

	public void setAutorisation(String autorisation) {
		this.autorisation = autorisation;
	}
	
	public String toString() {
		return demandeur.toString() + immobilier.toString() + pointDeau.toString();
	}
}
