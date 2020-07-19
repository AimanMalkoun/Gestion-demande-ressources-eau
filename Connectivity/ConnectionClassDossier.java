package Connectivity;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.Demandeur;
import Classes.Dossier;
import Classes.Immobilier;
import Classes.PointDeau;

public class ConnectionClassDossier {

	private ConnectionClassMaria conection;
	public ConnectionClassDossier() {
		conection =  new ConnectionClassMaria();// TODO Auto-generated constructor stub
	}
	
	
	public Dossier getDossierFromDatabase(int ID) {
		
		Dossier dossier = new Dossier();
		String sqlRequette = "SELECT * "
						   + "FROM `dossier` "
						   + "WHERE `IdDossier` = "+ ID ;
		System.out.println(sqlRequette);
		try {
			
			Statement stm = conection.connection.createStatement();
			ResultSet result = stm.executeQuery(sqlRequette);
			if(result.next()) {
				System.out.println("i am in");
				dossier.setIdDossier(ID);
				
				dossier.setDemandeur(getDemandeurInfo(result));
				dossier.setImmobilier(getImmobilierInfo(result));
				dossier.setPointDeau(getPointDeauInfo(result));
				
				dossier.setAvisABHOER((result.getString("Avis ABHOER")));
				dossier.setAvisDe_CEP((result.getString("Avis de la CEP")));
				dossier.setAutorisation(result.getString("Autorisation"));
				
				//we need first to convert java.sql.Date to java.time.LocalDate to match the argument of the setter  
				dossier.setDateDepot(result.getDate("Date de dépôt du dossier").toLocalDate());											
				dossier.setDateEnvoiA_LABHOER(result.getDate("Date d'envoi à la délégation de l'ABHOER à El Jadida").toLocalDate());
				dossier.setDateDebutde_EP(result.getDate("Date début de l'enquête publique").toLocalDate());
				dossier.setDateFin_EP(result.getDate("Date fin de l'enquête publique (EP)").toLocalDate());
				dossier.setDateSignateureDuPv(result.getDate("Date signature du PV par la commission de l'EP").toLocalDate());
				dossier.setDateEnvoiDuPVa_LABHOER(result.getDate("Date d'envoi du PV à la D.ABHOER à EL Jadida").toLocalDate());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return dossier;
	}
	
	
	
	private Demandeur getDemandeurInfo(ResultSet result) throws SQLException{
		Demandeur demandeur = new Demandeur();
		
		demandeur.setNom(result.getString("Nom"));
		demandeur.setPrenom(result.getString("Prenom"));
		demandeur.setCin(result.getString("Carte d'identite National"));
		demandeur.setTypeDemande(result.getString("Type de demande"));
		demandeur.setDateDepotDossier(result.getDate("Date de dépôt du dossier").toLocalDate());
		//demandeur.setCinFile(result.getBlob(""));
		//demandeur.setDemandeFile(result.getBlob(""));
		
		return demandeur;
	}
	
	private Immobilier getImmobilierInfo(ResultSet result) throws SQLException{
		Immobilier immobilier = new Immobilier();
		
		immobilier.setLocalisation(result.getString("Localisation de l'immobilier"));
		immobilier.setDouar(result.getString("Douar"));
		immobilier.setCommune(result.getString("Commune"));
		immobilier.setProvince(result.getString("Province"));
		//immobilier.setAttestationDePocession(result.getBlob(""));
		
		return immobilier;
	}
	
	private PointDeau getPointDeauInfo(ResultSet result) throws SQLException{
		PointDeau pointDeau = new PointDeau();
		
		pointDeau.setLocalisationPoint(result.getString("Localisation du point d'eau"));
		pointDeau.setProfondeur(result.getFloat("Profendeur"));
		pointDeau.setDebit(result.getFloat("Debit"));
		pointDeau.setRabattement(result.getFloat("Rabatement"));
		//pointDeau.setPlanEau(result.getBlob(""));
		
		return pointDeau;
	}
	
	
	//getters and setters
	public ConnectionClassMaria getConnection() {
		return conection;
	}
	public void setConnectTo(ConnectionClassMaria connection) {
		this.conection = connection;
	}
	
	
	public int updateDossierToDatabase(Dossier dossier) {
		
		String sqlRequete = "UPDATE `dossier` " + 
							"SET `Nom`= ?," + 
							"    `Prenom`= ?," + 
							"    `Carte d'identite National`= ?," + 
							"    `CIN (PDF/Img)`= ?," + 
							"    `Type de demande`= ?," + 
							"    `Demande de creusement (PDF)`= ?," + 
							"    `Localisation de l'immobilier`= ?," + 
							"    `Attistation de pocession de l'immobilier`= ?," + 
							"    `Douar`= ?," + 
							"    `Commune`= ?," + 
							"    `Province`= ?," + 
							"    `Localisation du point d'eau`= ?," + 
							"    `Debit`= ?," + 
							"    `Profendeur`= ?," + 
							"    `Plan d'eau`= ?," + 
							"    `Rabatement`= ?," + 
							"    `Date de dépôt du dossier`= ?," + 
							"    `Date d'envoi à la délégation de l'ABHOER à El Jadida`= ?," + 
							"    `Date début de l'enquête publique`= ?," + 
							"    `Date fin de l'enquête publique (EP)`= ?," + 
							"    `Date signature du PV par la commission de l'EP`= ?," + 
							"    `Avis de la CEP`= ?," + 
							"    `Date d'envoi du PV à la D.ABHOER à EL Jadida`= ?," + 
							"    `Avis ABHOER`= ?," + 
							"    `Autorisation`= ? " + 
							"WHERE `IdDossier`= ?";
		try {
			
			PreparedStatement stm = conection.connection.prepareStatement(sqlRequete);
			
			stm.setString(1, dossier.getDemandeur().getNom());
			stm.setString(2, dossier.getDemandeur().getPrenom());
			stm.setString(3, dossier.getDemandeur().getCin());
			stm.setBlob(4, FiletoBlob(dossier.getDemandeur().getCinFile()));
			stm.setString(5, dossier.getDemandeur().getTypeDemande());
			stm.setBlob(6, FiletoBlob(dossier.getDemandeur().getDemandeFile()));
			
			stm.setString(7, dossier.getImmobilier().getLocalisation());
			stm.setBlob(8, FiletoBlob(dossier.getImmobilier().getAttestationDePocession()));
			stm.setString(9, dossier.getImmobilier().getDouar());
			stm.setString(10, dossier.getImmobilier().getCommune());
			stm.setString(11, dossier.getImmobilier().getProvince());
			
			stm.setString(12, dossier.getPointDeau().getLocalisationPoint());
			stm.setFloat(13, dossier.getPointDeau().getDebit());
			stm.setFloat(14, dossier.getPointDeau().getProfondeur());
			stm.setBlob(15, FiletoBlob(dossier.getPointDeau().getPlanEau()));
			stm.setFloat(16, dossier.getPointDeau().getRabattement());
			
			stm.setDate(17, Date.valueOf(dossier.getDemandeur().getDateDepotDossier()));
			stm.setDate(18, Date.valueOf(dossier.getDateEnvoiA_LABHOER()));
			stm.setDate(19, Date.valueOf(dossier.getDateDebutde_EP()));
			stm.setDate(20, Date.valueOf(dossier.getDateFin_EP()));
			stm.setDate(21, Date.valueOf(dossier.getDateSignateureDuPv()));
			stm.setString(22, dossier.getAvisDe_CEP());
			stm.setDate(23, Date.valueOf(dossier.getDateEnvoiDuPVa_LABHOER()));
			stm.setString(24, dossier.getAvisABHOER());
			stm.setString(25, dossier.getAutorisation());
			
			stm.setInt(26, dossier.getIdDossier());
			
			int result = stm.executeUpdate();
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("here the problem");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	private FileInputStream FiletoBlob(File file) {
		try {
			return  new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}


































