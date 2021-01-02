package Connectivity;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;

import Classes.DossierForDownload;

public class ConnectionClassDossier {

	private Connection localConection;

	public ConnectionClassDossier() throws SQLException, ClassNotFoundException {
		localConection = ConnectionClass.getConnectionLocal();
		
	}

	// getters and setters
	public Connection getConnection() {
		return localConection;
	}

	public void setConnectTo(Connection connection) {
		this.localConection = connection;
	}

	public DossierForDownload getDossierFromDatabase(int ID) {

		DossierForDownload dossier = new DossierForDownload();

		String sqlRequette = "SELECT * " + "FROM `dossier` " + "WHERE `IdDossier` = " + ID + "";
		try {

			if (localConection.isClosed())
				localConection = ConnectionClass.getConnectionLocal();

			Statement stm = localConection.createStatement();
			ResultSet result = stm.executeQuery(sqlRequette);
			if (result.next()) {
				dossier.setIdDossier(ID);
				dossier.setIdDossierYear(result.getString("idDossierYear"));

				dossier.setNom(result.getString("Nom"));
				dossier.setPrenom(result.getString("Prenom"));
				dossier.setCin(result.getString("cin"));
				dossier.setTypeDemande(result.getString("typeDemande"));
				dossier.setDateDepotDossier(result.getString("DateDepot"));
				dossier.setCinFile(result.getBytes("cinImg")== null ? null : new SerialBlob(result.getBytes("cinImg")));
				dossier.setDemandeFile(result.getBytes("demandeCreusement") == null ? null : new SerialBlob(result.getBytes("demandeCreusement")));

				dossier.setNomImmobilier(result.getString("nomImmobilier"));
				dossier.setQuiada(result.getString("qiyada"));
				dossier.setDaaira(result.getString("daaira"));
				dossier.setDouar(result.getString("Douar"));
				dossier.setCommune(result.getString("Commune"));
				dossier.setProvince(result.getString("Province"));
				dossier.setAttestationDePocession(result.getBytes("attistationPocession") == null ? null : new SerialBlob(result.getBytes("attistationPocession")));
				dossier.setPlanImmobilier(result.getBytes("planImmo") == null ? null : new SerialBlob(result.getBytes("planImmo")));

				dossier.setLocalisationPoint(result.getString("localisationPointEau"));
				dossier.setProfondeur(result.getFloat("Profendeur"));
				dossier.setDebit(result.getFloat("Debit"));
				dossier.setPlanEau(result.getFloat("PlanDeau"));

				dossier.setAvisABHOER((result.getString("AvisABHOER")));
				dossier.setAvisDe_CEP((result.getString("AvisDeCEP")));

				dossier.setAutorisation(result.getString("Autorisation"));
				
				
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

	public void updateDossierToDatabase(DossierForDownload dossier) throws ClassNotFoundException, SQLException {

		String sqliteRequete = "UPDATE `dossier` " + // this query is for local database
				"SET `Nom`=?," + "    `Prenom`=?," + "    `cin`=?," + "    `cinImg`=?," + "    `typeDemande`=?,"
				+ "    `demandeCreusement`=?," + "    `attistationPocession`=?," + "    `Douar`=?," + "    `Commune`=?,"
				+ "    `Province`=?," + "    `localisationPointEau`=?," + "    `Debit`=?," + "    `Profendeur`=?,"
				+ "    `PlanDeau`=?," + "    `daaira`=?," + "    `DateDepot`=?," + "    `dateEnvoiABHOER`=?,"
				+ "    `dateDebut_EP`=?," + "    `dateFin_EP`=?," + "    `dateSignature_PV`=?," + "    `AvisDeCEP`=?,"
				+ "    `DateEnvoiDuPV_ABHOER`=?," + "    `AvisABHOER`=?," + "    `Autorisation`=?," + "    `qiyada`=?,"
				+ "    `planImmo`=?," + "    `nomImmobilier`=?" + "WHERE `IdDossier`= ?";

		try {

			if (localConection.isClosed())
				localConection = ConnectionClass.getConnectionLocal();

			// update to local database
			PreparedStatement stm = localConection.prepareStatement(sqliteRequete);

			stm.setString(1, dossier.getNom());
			stm.setString(2, dossier.getPrenom());
			stm.setString(3, dossier.getCin());
			stm.setBytes(4, dossier.getCinFile() == null ? (byte[])null : IOUtils.toByteArray(dossier.getCinFile().getBinaryStream()));
			stm.setString(5, dossier.getTypeDemande());
			stm.setBytes(6, dossier.getDemandeFile() == null ? (byte[])null : IOUtils.toByteArray(dossier.getDemandeFile().getBinaryStream()));

			stm.setBytes(7, dossier.getAttestationDePocession() == null ? (byte[])null : IOUtils.toByteArray(dossier.getAttestationDePocession().getBinaryStream()));
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
			stm.setBytes(26, dossier.getPlanImmobilier() == null ? (byte[])null : IOUtils.toByteArray(dossier.getPlanImmobilier().getBinaryStream()));
			stm.setString(27, dossier.getNomImmobilier());

			stm.setInt(28, dossier.getIdDossier());

			stm.executeUpdate();


		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();

		}

	}

	public int removeFolder(int id) throws ClassNotFoundException, SQLException {

		if (localConection.isClosed())
			localConection = ConnectionClass.getConnectionLocal();

		String sqlQuery = "DELETE FROM `dossier` WHERE `IdDossier` = ?;"; // this query is for the local database
		int resultLocal = 0;

		PreparedStatement stm;
		try {

			stm = localConection.prepareStatement(sqlQuery);
			stm.setInt(1, id);
			resultLocal = stm.executeUpdate(); // delete for local database
			
			return resultLocal;
		} catch (SQLException e) {

			return resultLocal;
		}
		
	}

}