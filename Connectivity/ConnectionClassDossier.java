package Connectivity;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;

import Classes.DossierForDownload;

public class ConnectionClassDossier {

	private ConnectionClass conection;
	public ConnectionClassDossier() {
		conection =  new ConnectionClass();
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
						   + "WHERE `IdDossier` = "+ ID +"" ;
		try {
			
			Statement stm = conection.getConnection().createStatement();
			ResultSet result = stm.executeQuery(sqlRequette);
			if(result.next()) {
				dossier.setIdDossier(ID);
				
				dossier.setNom(result.getString("Nom"));
				dossier.setPrenom(result.getString("Prenom"));
				dossier.setCin(result.getString("cin"));
				dossier.setTypeDemande(result.getString("typeDemande"));
				dossier.setDateDepotDossier(result.getString("DateDepot"));
				dossier.setCinFile(new SerialBlob(result.getBytes("cinImg")));
				dossier.setDemandeFile(new SerialBlob(result.getBytes("demandeCreusement")));
				
				dossier.setNomImmobilier(result.getString("nomImmobilier"));
				dossier.setQuiada(result.getString("qiyada"));
				dossier.setDaaira(result.getString("daaira"));
				dossier.setDouar(result.getString("Douar"));
				dossier.setCommune(result.getString("Commune"));
				dossier.setProvince(result.getString("Province"));
				dossier.setAttestationDePocession(new SerialBlob(result.getBytes("attistationPocession")));
				dossier.setPlanImmobilier(new SerialBlob(result.getBytes("planImmo")));
				
				dossier.setLocalisationPoint(result.getString("localisationPointEau"));
				dossier.setProfondeur(result.getFloat("Profendeur"));
				dossier.setDebit(result.getFloat("Debit"));
				dossier.setPlanEau(result.getFloat("PlanDeau"));
				
				dossier.setAvisABHOER((result.getString("AvisABHOER")));
				dossier.setAvisDe_CEP((result.getString("AvisDeCEP")));

				dossier.setAutorisation(result.getString("Autorisation"));
				
				//we need first to convert java.sql.Date to java.time.LocalDate to match the argument of the setter  
				dossier.setDateDepot(result.getString("DateDepot"));											
				dossier.setDateEnvoiA_LABHOER(result.getString("dateEnvoiABHOER"));
				dossier.setDateDebutde_EP(result.getString("dateDebut_EP"));
				dossier.setDateFin_EP(result.getString("dateFin_EP"));
				dossier.setDateSignateureDuPv(result.getString("dateSignature_PV"));
				dossier.setDateEnvoiDuPVa_LABHOER(result.getString("DateEnvoiDuPV_ABHOER"));
			}
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return dossier;
	}
	
	public int updateDossierToDatabase(DossierForDownload dossier) {
		System.out.println(dossier);
		
		String sqlRequete = "UPDATE `dossier` " + 
							"SET `Nom`=?," + 
							"    `Prenom`=?," + 
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

			PreparedStatement stm = conection.getConnection().prepareStatement(sqlRequete);
			
			stm.setString(1, dossier.getNom());
			stm.setString(2, dossier.getPrenom());
			stm.setString(3, dossier.getCin());
			stm.setBytes(4, IOUtils.toByteArray(dossier.getCinFile().getBinaryStream()));
			stm.setString(5, dossier.getTypeDemande());
			stm.setBytes(6, IOUtils.toByteArray(dossier.getDemandeFile().getBinaryStream()));

			stm.setBytes(7, IOUtils.toByteArray(dossier.getAttestationDePocession().getBinaryStream()));
			stm.setString(8, dossier.getDouar());
			stm.setString(9, dossier.getCommune());
			stm.setString(10, dossier.getProvince());

			stm.setString(11, dossier.getLocalisationPoint());
			stm.setFloat(12, dossier.getDebit());
			stm.setFloat(13, dossier.getProfondeur());
			stm.setFloat(14, dossier.getPlanEau());
			
			stm.setString(15, dossier.getDaaira());
			
			stm.setString(16, dossier.getDateDepotDossier());
			stm.setString(17, dossier.getDateEnvoiA_LABHOER());
			stm.setString(18, dossier.getDateDebutde_EP());
			stm.setString(19, dossier.getDateFin_EP());
			stm.setString(20, dossier.getDateSignateureDuPv());
			stm.setString(21, dossier.getAvisDe_CEP());
			stm.setString(22, dossier.getDateEnvoiDuPVa_LABHOER());
			stm.setString(23, dossier.getAvisABHOER());
			stm.setString(24, dossier.getAutorisation());
			
			stm.setString(25, dossier.getQuiada());
			stm.setBytes(26, IOUtils.toByteArray(dossier.getPlanImmobilier().getBinaryStream()));
			stm.setString(27, dossier.getNomImmobilier());
			
			stm.setInt(28, dossier.getIdDossier());
			
			int result = stm.executeUpdate();
			return result;
			
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		} catch (Exception e) {

			System.out.println("here the problem");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return 0;
		}
		
	}
	

	public int removeFolder(int id) {
		
		String sqlQuery = "DELETE FROM `dossier` WHERE `IdDossier` = ?;";
		int result = 0;
		
		try {
			
			PreparedStatement stm = conection.getConnection().prepareStatement(sqlQuery);
			stm.setInt(1, id);
			result = stm.executeUpdate();
			if(result > 0)
				System.out.println("row has been deleted");
			
			return result;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return result;
	}
	
}


































