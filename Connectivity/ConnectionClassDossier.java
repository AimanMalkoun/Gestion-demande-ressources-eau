package Connectivity;



import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.DossierForDownload;

public class ConnectionClassDossier {

	private ConnectionClass conection;
	public ConnectionClassDossier() {
		conection =  new ConnectionClass();// TODO Auto-generated constructor stub
	}
	
	//getters and setters
	public ConnectionClass getConnection() {
		return conection;
	}
	public void setConnectTo(ConnectionClass connection) {
		this.conection = connection;
	}
	
	
	public DossierForDownload getDossierFromDatabase(int ID) {
		
		DossierForDownload dossier = new DossierForDownload();
		
		String sqlRequette = "SELECT * "
						   + "FROM `dossier` "
						   + "WHERE `IdDossier` = '"+ ID+"'" ;
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
				
				dossier.setNomImmobilier(result.getString("nomImmobilier"));
				dossier.setQuiada(result.getString("qiyada"));
				dossier.setDaaira(result.getString("daaira"));
				dossier.setDouar(result.getString("Douar"));
				dossier.setCommune(result.getString("Commune"));
				dossier.setProvince(result.getString("Province"));
				dossier.setAttestationDePocession(result.getBlob("attistationPocession"));
				dossier.setPlanImmobilier(result.getBlob("planImmo"));
				
				dossier.setLocalisationPoint(result.getString("localisationPointEau"));
				dossier.setProfondeur(result.getFloat("Profendeur"));
				dossier.setDebit(result.getFloat("Debit"));
				dossier.setPlanEau(result.getFloat("PlanDeau"));
				
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
							"SET `Nom`=?," + 
							"    `Prenom`=3," + 
							"    `cin`=?," + 
							"    `cinImg`=?," + 
							"    `typeDemande`=?," + 
							"    `demandeCreusement`=?," + 
							"    `attistationPocession`=?," + 
							"    `Douar`=?," + 
							"    `Commune`=?," + 
							"    `Province`=?," + 
							"    `localisationPointEau`=?," + 
							"    `Debit`=?," + 
							"    `Profendeur`=?," + 
							"    `PlanDeau`=?," + 
							"    `daaira`=?," + 
							"    `DateDepot`=?," + 
							"    `dateEnvoiABHOER`=?," + 
							"    `dateDebut_EP`=?," + 
							"    `dateFin_EP`=?," + 
							"    `dateSignature_PV`=?," + 
							"    `AvisDeCEP`=?," + 
							"    `DateEnvoiDuPV_ABHOER`=?," + 
							"    `AvisABHOER`=?," + 
							"    `Autorisation`=?," + 
							"    `qiyada`=?," + 
							"    `planImmo`=?," + 
							"    `nomImmobilier`=?" + 
							"WHERE `IdDossier`= ?";
		try {
			
			PreparedStatement stm = conection.connection.prepareStatement(sqlRequete);
			
			stm.setString(1, dossier.getNom());
			stm.setString(2, dossier.getPrenom());
			stm.setString(3, dossier.getCin());
			stm.setBlob(4, dossier.getCinFile());
			stm.setString(5, dossier.getTypeDemande());
			stm.setBlob(6, dossier.getDemandeFile());

			stm.setBlob(7, dossier.getAttestationDePocession());
			stm.setString(8, dossier.getDouar());
			stm.setString(9, dossier.getCommune());
			stm.setString(10, dossier.getProvince());

			stm.setString(11, dossier.getLocalisationPoint());
			stm.setFloat(12, dossier.getDebit());
			stm.setFloat(13, dossier.getProfondeur());
			stm.setFloat(14, dossier.getPlanEau());
			
			stm.setString(15, dossier.getDaaira());
			
			stm.setDate(16, Date.valueOf(dossier.getDateDepotDossier()));
			stm.setDate(17, Date.valueOf(dossier.getDateEnvoiA_LABHOER()));
			stm.setDate(18, Date.valueOf(dossier.getDateDebutde_EP()));
			stm.setDate(19, Date.valueOf(dossier.getDateFin_EP()));
			stm.setDate(20, Date.valueOf(dossier.getDateSignateureDuPv()));
			stm.setString(21, dossier.getAvisDe_CEP());
			stm.setDate(22, Date.valueOf(dossier.getDateEnvoiDuPVa_LABHOER()));
			stm.setString(24, dossier.getAvisABHOER());
			stm.setString(25, dossier.getAutorisation());
			
			stm.setString(26, dossier.getQuiada());
			stm.setBlob(27, dossier.getPlanImmobilier());
			stm.setString(28, dossier.getNomImmobilier());
			
			stm.setInt(29, dossier.getIdDossier());
			
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


































