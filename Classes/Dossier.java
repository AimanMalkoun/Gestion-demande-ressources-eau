package Classes;

import java.sql.Date;

import javafx.scene.control.Label;

public class Dossier {
	/* 
	 * declaration des attributs (private) 
	 */

	private int idDossier;
	private Demandeur demandeur;
	private Immobilier immobilier;
	private PointDeau pointDeau;
	private Date dateDepot;
	private Date dateEnvoiA_LABHOER;
	private Date dateDebutde_EP;
	private Date dateFin_EP;
	private Date dateSignateureDuPv;
	private String avisDe_CEP;
	private Date dateEnvoiDuPVa_LABHOER;
	private String avisABHOER;

	/* 
	 *le constricteur de la classe initialisť par les attributs 
	 */

	public Dossier(int idDossier, Demandeur demandeur, Immobilier immobilier, PointDeau pointDeau, Date dateDepot,
			Date dateEnvoiA_LABHOER, Date dateDebutde_EP, Date dateFin_EP, Date dateSignateureDuPv, String avisDe_CEP,
			Date dateEnvoiDuPVa_LABHOER, String avisABHOER) {
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
	 * le constricteur de la classe initialisť par l'objet Dossier 
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
		return demandeur;
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

	public Date getDateDepot() {
		return dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public Date getDateEnvoiA_LABHOER() {
		return dateEnvoiA_LABHOER;
	}

	public void setDateEnvoiA_LABHOER(Date dateEnvoiA_LABHOER) {
		this.dateEnvoiA_LABHOER = dateEnvoiA_LABHOER;
	}

	public Date getDateDebutde_EP() {
		return dateDebutde_EP;
	}

	public void setDateDebutde_EP(Date dateDebutde_EP) {
		this.dateDebutde_EP = dateDebutde_EP;
	}

	public Date getDateFin_EP() {
		return dateFin_EP;
	}

	public void setDateFin_EP(Date dateFin_EP) {
		this.dateFin_EP = dateFin_EP;
	}

	public Date getDateSignateureDuPv() {
		return dateSignateureDuPv;
	}

	public void setDateSignateureDuPv(Date dateSignateureDuPv) {
		this.dateSignateureDuPv = dateSignateureDuPv;
	}

	public String isAvisDe_CEP() {
		return avisDe_CEP;
	}

	public void setAvisDe_CEP(String avisDe_CEP) {
		this.avisDe_CEP = avisDe_CEP;
	}

	public Date getDateEnvoiDuPVa_LABHOER() {
		return dateEnvoiDuPVa_LABHOER;
	}

	public void setDateEnvoiDuPVa_LABHOER(Date dateEnvoiDuPVa_LABHOER) {
		this.dateEnvoiDuPVa_LABHOER = dateEnvoiDuPVa_LABHOER;
	}

	public String isAvisABHOER() {
		return avisABHOER;
	}

	public void setAvisABHOER(String avisABHOER) {
		this.avisABHOER = avisABHOER;
	}

}
