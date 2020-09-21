package Connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.io.IOUtils;

import Classes.DossierForDownload;

public class ConnectionClassDossier {

	private Connection localConection;
	private Connection globalConnection;

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

				// we need first to convert java.sql.Date to java.time.LocalDate to match the
				// argument of the setter
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

	public int[] updateDossierToDatabase(DossierForDownload dossier) throws ClassNotFoundException, SQLException {

		globalConnection = ConnectionClass.getConnectionGlobal();
		int resultGlobal = 0, resultLocal = 0;

		String sqliteRequete = "UPDATE `dossier` " + // this query is for local database
				"SET `Nom`=?," + "    `Prenom`=?," + "    `cin`=?," + "    `cinImg`=?," + "    `typeDemande`=?,"
				+ "    `demandeCreusement`=?," + "    `attistationPocession`=?," + "    `Douar`=?," + "    `Commune`=?,"
				+ "    `Province`=?," + "    `localisationPointEau`=?," + "    `Debit`=?," + "    `Profendeur`=?,"
				+ "    `PlanDeau`=?," + "    `daaira`=?," + "    `DateDepot`=?," + "    `dateEnvoiABHOER`=?,"
				+ "    `dateDebut_EP`=?," + "    `dateFin_EP`=?," + "    `dateSignature_PV`=?," + "    `AvisDeCEP`=?,"
				+ "    `DateEnvoiDuPV_ABHOER`=?," + "    `AvisABHOER`=?," + "    `Autorisation`=?," + "    `qiyada`=?,"
				+ "    `planImmo`=?," + "    `nomImmobilier`=?" + "WHERE `IdDossier`= ?";

		String globalSqlRequete = "UPDATE `user` SET `ID_FOLDER_YEAR`=?,`CIN`=?,`AUTORISATION`=? WHERE `ID_FOLDER`=?"; // this
																														// query
																														// is
																														// for
																														// global
																														// database

		try {

			if (localConection.isClosed())
				localConection = ConnectionClass.getConnectionLocal();

			if (globalConnection.isClosed())
				globalConnection = ConnectionClass.getConnectionGlobal();

			// update to global database
			PreparedStatement stm2 = globalConnection.prepareStatement(globalSqlRequete);

			String idDossierYear = dossier.getIdDossier() + "/" +Calendar.getInstance().get(Calendar.YEAR);

			stm2.setString(1, idDossierYear);
			stm2.setString(2, dossier.getCin());
			stm2.setInt(4, dossier.getIdDossier());
			if(dossier.getAvisDe_CEP().equals("\u0628\u0627\u0644\u0631\u0641\u0636") || dossier.getAvisABHOER().equals("\u0628\u0627\u0644\u0631\u0641\u0636"))
				stm2.setString(3, "\u0644\u0642\u062f \u062a\u0645 \u0631\u0641\u0636 \u0637\u0644\u0628\u0643\u0645");
			else
				stm2.setString(3, dossier.getAutorisation());

			// update to local database
			PreparedStatement stm = localConection.prepareStatement(sqliteRequete);

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

			resultGlobal = stm2.executeUpdate();
			resultLocal = stm.executeUpdate();

			return new int[] { resultGlobal, resultLocal };

		} catch (SQLException e) {
			
			return new int[] { resultGlobal, resultLocal };
		} catch (Exception e) {
			
			return new int[] { resultGlobal, resultLocal };
		}

	}

	public int[] removeFolder(int id) throws ClassNotFoundException, SQLException {

		globalConnection = ConnectionClass.getConnectionGlobal();
		if (globalConnection.isClosed())
			globalConnection = ConnectionClass.getConnectionGlobal();

		if (localConection.isClosed())
			globalConnection = ConnectionClass.getConnectionGlobal();

		String sqlQuery = "DELETE FROM `dossier` WHERE `IdDossier` = ?;", // this query is for the local database
				sqlQuery2 = "DELETE FROM `user` WHERE `ID_FOLDER` = ?;"; // this query is for the global database
		int resultGlobal = 0, resultLocal = 0;

		PreparedStatement stm, stm2;
		try {

			stm = localConection.prepareStatement(sqlQuery);
			stm.setInt(1, id);

			stm2 = globalConnection.prepareStatement(sqlQuery2);
			stm2.setInt(1, id);
			
			resultGlobal = stm2.executeUpdate(); // delete for global database
			resultLocal = stm.executeUpdate(); // delete for local database
			
			return new int[] { resultGlobal, resultLocal };
		} catch (SQLException e) {

			return new int[] { resultGlobal, resultLocal };
		}
		
	}

}
