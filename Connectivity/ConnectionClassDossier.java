package Connectivity;



import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.DossierForDownload;

public class ConnectionClassDossier {

	private ConnectionClassMaria conection;
	public ConnectionClassDossier() {
		conection =  new ConnectionClassMaria();// TODO Auto-generated constructor stub
	}
	
	//getters and setters
	public ConnectionClassMaria getConnection() {
		return conection;
	}
	public void setConnectTo(ConnectionClassMaria connection) {
		this.conection = connection;
	}
	
	
	public DossierForDownload getDossierFromDatabase(int ID) {
		
		DossierForDownload dossier = new DossierForDownload();
		
		String sqlRequette = "SELECT * "
						   + "FROM `dossier` "
						   + "WHERE `IdDossier` = "+ ID ;
		try {
			
			Statement stm = conection.connection.createStatement();
			ResultSet result = stm.executeQuery(sqlRequette);
			
			if(result.next()) {
				dossier.setIdDossier(ID);
				
				dossier.setNom(result.getString("Nom"));
				dossier.setPrenom(result.getString("Prenom"));
				dossier.setCin(result.getString("cin"));
				dossier.setTypeDemande(result.getString("typeDemande"));
				dossier.setDateDepotDossier(result.getDate("DateDepot").toLocalDate());
				dossier.setCinFile(result.getBlob("cinImg"));
				dossier.setDemandeFile(result.getBlob("demandeCreusement"));
				
				dossier.setLocalisation(result.getString("localisationImmobilier"));
				dossier.setDouar(result.getString("Douar"));
				dossier.setCommune(result.getString("Commune"));
				dossier.setProvince(result.getString("Province"));
				dossier.setAttestationDePocession(result.getBlob("attistationPocession"));
				
				dossier.setLocalisationPoint(result.getString("localisationPointEau"));
				dossier.setProfondeur(result.getFloat("Profendeur"));
				dossier.setDebit(result.getFloat("Debit"));
				dossier.setRabattement(result.getFloat("Rabatement"));
				dossier.setPlanEau(result.getBlob("PlanDeau"));
				
				dossier.setAvisABHOER((result.getString("AvisABHOER")));
				dossier.setAvisDe_CEP((result.getString("AvisDeCEP")));

				dossier.setAutorisation(result.getString("Autorisation"));
				
				//we need first to convert java.sql.Date to java.time.LocalDate to match the argument of the setter  
				dossier.setDateDepot(result.getDate("DateDepot").toLocalDate());											
				dossier.setDateEnvoiA_LABHOER(result.getDate("dateEnvoiABHOER").toLocalDate());
				dossier.setDateDebutde_EP(result.getDate("dateDebut_EP").toLocalDate());
				dossier.setDateFin_EP(result.getDate("dateFin_EP").toLocalDate());
				dossier.setDateSignateureDuPv(result.getDate("dateSignature_PV").toLocalDate());
				dossier.setDateEnvoiDuPVa_LABHOER(result.getDate("DateEnvoiDuPV_ABHOER").toLocalDate());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return dossier;
	}
	
	public int updateDossierToDatabase(DossierForDownload dossier) {
		
		String sqlRequete = "UPDATE `dossier` " + 
							"SET `Nom`= ?," + 
							"    `Prenom`= ?," + 
							"    `cin`= ?," + 
							"    `cinImg`= ?," + 
							"    `typeDemande`= ?," + 
							"    `demandeCreusement`= ?," + 
							"    `localisationImmobilier`= ?," + 
							"    `attistationPocession`= ?," + 
							"    `Douar`= ?," + 
							"    `Commune`= ?," + 
							"    `Province`= ?," + 
							"    `localisationPointEau`= ?," + 
							"    `Debit`= ?," + 
							"    `Profendeur`= ?," + 
							"    `PlanDeau`= ?," + 
							"    `Rabatement`= ?," + 
							"    `DateDepot`= ?," + 
							"    `dateEnvoiABHOER`= ?," + 
							"    `dateDebut_EP`= ?," + 
							"    `dateFin_EP`= ?," + 
							"    `dateSignature_PV`= ?," + 
							"    `AvisDeCEP`= ?," + 
							"    `DateEnvoiDuPV_ABHOER`= ?," + 
							"    `AvisABHOER`= ?," + 
							"    `Autorisation`= ? " + 
							"WHERE `IdDossier`= ?";
		try {
			
			PreparedStatement stm = conection.connection.prepareStatement(sqlRequete);
			
			stm.setString(1, dossier.getNom());
			stm.setString(2, dossier.getPrenom());
			stm.setString(3, dossier.getCin());
			stm.setBlob(4, dossier.getCinFile());
			stm.setString(5, dossier.getTypeDemande());
			stm.setBlob(6, dossier.getDemandeFile());
			
			stm.setString(7, dossier.getLocalisation());
			stm.setBlob(8, dossier.getAttestationDePocession());
			stm.setString(9, dossier.getDouar());
			stm.setString(10, dossier.getCommune());
			stm.setString(11, dossier.getProvince());
			
			stm.setString(12, dossier.getLocalisationPoint());
			stm.setFloat(13, dossier.getDebit());
			stm.setFloat(14, dossier.getProfondeur());
			stm.setBlob(15, dossier.getPlanEau());
			stm.setFloat(16, dossier.getRabattement());
			
			stm.setDate(17, Date.valueOf(dossier.getDateDepotDossier()));
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
}


































