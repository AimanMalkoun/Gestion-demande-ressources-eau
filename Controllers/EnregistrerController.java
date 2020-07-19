package Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Classes.Dossier;
import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class EnregistrerController implements Initializable {
	@FXML
	private Label firstName;
	@FXML
	private Label lastName;
	@FXML
	private Label codeCin;
	@FXML
	private Label dateDepot;
	@FXML
	private Label typeDemande;
	@FXML
	private Label demandeForagePompage;
	@FXML
	private Label lcationImm;
	@FXML
	private Label douar;
	@FXML
	private Label commune;
	@FXML
	private Label province;
	@FXML
	private Label AttestationPossession;
	@FXML
	private Label rabattement;
	@FXML
	private Label locationPoin;
	@FXML
	private Label debit;
	@FXML
	private Label profondeur;
	@FXML
	private Label planEau;
	@FXML
	private Button modifyButton;
	@FXML
	private Button saveBuuton;
	@FXML
	BorderPane borderPane;
	public static int idDossier = 20200000;

	// Event Listener on Button[#modifyButton].onAction
	@FXML
	public void modifyButtonMethode(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("../Fxml/InformationsDuDemandeur.fxml"));
		borderPane.getChildren().setAll(root);

	}

	// Event Listener on Button[#saveBuuton].onAction
	@FXML
	public void savebuttonMethode(ActionEvent event) throws IOException, SQLException {

		/*se connecter avec la base de données */

		ConnectionClass conn = new ConnectionClass();
		Connection connection = conn.getConnection();
		
		Statement statId = connection.createStatement();

		/* Sélectionner le plus grand idDossier*/

		String sqlId = "SELECT MAX(IdDossier)  FROM dossier";
		ResultSet result = statId.executeQuery(sqlId);
		if (result.next()) {
			idDossier = result.getInt(1) + 1;
		}

		/*
		 * l'initialisation de l'objet Dossier avec les éléments de la page précédente
		 */

		/*Dossier dossier = new Dossier(idDossier, LesInfoDuDemandeurController.demandeur,
				LesInfoDelImmobilierController.InfoSurImmobilier, InformationsConcernantPointDeauController.poinDeau,
				dateDepot);*/


		/* Détermination de path de chaque fichier */

		String pathCIN = LesInfoDuDemandeurController.demandeur.getCinFile().getAbsolutePath();
		String pathDemandeCreusement = LesInfoDuDemandeurController.demandeur.getDemandeFile().getAbsolutePath();
		String pathAttistation = LesInfoDelImmobilierController.InfoSurImmobilier.getAttestationDePocession().getAbsolutePath();
		String pathPlanEau = InformationsConcernantPointDeauController.poinDeau.getPlanEau().getAbsolutePath();

		/* Création de l'objet InputStream afin de le stocker dans la base de données */

		InputStream cinFile = new FileInputStream(new File(pathCIN));
		InputStream demandeCreusement = new FileInputStream(new File(pathDemandeCreusement));
		InputStream attistation = new FileInputStream(new File(pathAttistation));
		InputStream planEau = new FileInputStream(new File(pathPlanEau));

		/* la requête sql de l'insertion */

		String sql = "INSERT INTO dossier (IdDossier, Nom, Prenom, cin, cinImg, typeDemande, demandeCreusement, localisationImmobilier, attistationPocession, Douar, Commune, Province, localisationPointEau,Debit, Profendeur, PlanDeau, Rabatement, DateDepot, dateEnvoiABHOER, dateDebut_EP, dateFin_EP,dateSignature_PV, AvisDeCEP, DateEnvoiDuPV_ABHOER, AvisABHOER, Autorisation) VALUES (?, ?, ?, ?, ?,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?,? ,? ,? )";
		try {

			/* l'insertion des eléments dans la base de données */

			PreparedStatement stat = connection.prepareStatement(sql);
			
			stat.setInt(1, idDossier);
			stat.setString(2, LesInfoDuDemandeurController.demandeur.getNom());
			stat.setString(3, LesInfoDuDemandeurController.demandeur.getPrenom());
			stat.setString(4, LesInfoDuDemandeurController.demandeur.getCin());
			stat.setBlob(5, cinFile);
			stat.setString(6, LesInfoDuDemandeurController.demandeur.getTypeDemande());
			stat.setBlob(7, demandeCreusement);
			stat.setString(8, LesInfoDelImmobilierController.InfoSurImmobilier.getLocalisation());
			stat.setBlob(9, attistation);
			stat.setString(10, LesInfoDelImmobilierController.InfoSurImmobilier.getDouar());
			stat.setString(11, LesInfoDelImmobilierController.InfoSurImmobilier.getCommune());
			stat.setString(12, LesInfoDelImmobilierController.InfoSurImmobilier.getProvince());
			stat.setString(13, InformationsConcernantPointDeauController.poinDeau.getLocalisationPoint());
			stat.setFloat(14, InformationsConcernantPointDeauController.poinDeau.getDebit());
			stat.setFloat(15, InformationsConcernantPointDeauController.poinDeau.getProfondeur());
			stat.setBlob(16, planEau);
			stat.setFloat(17, InformationsConcernantPointDeauController.poinDeau.getRabattement());
			stat.setDate(18,  Date.valueOf(  LesInfoDuDemandeurController.demandeur.getDateDepotDossier()));
			stat.setDate(19, Date.valueOf(  LesInfoDuDemandeurController.demandeur.getDateDepotDossier()));
			stat.setDate(20, Date.valueOf(  LesInfoDuDemandeurController.demandeur.getDateDepotDossier()));
			stat.setDate(21, Date.valueOf(  LesInfoDuDemandeurController.demandeur.getDateDepotDossier()));
			stat.setDate(22, Date.valueOf(  LesInfoDuDemandeurController.demandeur.getDateDepotDossier()));
			stat.setString(23, "");
			stat.setDate(24, Date.valueOf(  LesInfoDuDemandeurController.demandeur.getDateDepotDossier()));
			stat.setString(25, "");
			stat.setString(26, "");
			stat.execute();

		} catch (SQLException e) {
			
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		Parent root = FXMLLoader.load(getClass().getResource("../Fxml/AEteEnregistrer.fxml"));
		borderPane.getChildren().setAll(root);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/* Les information du demandeur */

		firstName.setText(LesInfoDuDemandeurController.demandeur.getNom());
		lastName.setText(LesInfoDuDemandeurController.demandeur.getPrenom());
		codeCin.setText(LesInfoDuDemandeurController.demandeur.getCin());
		dateDepot.setText("" + LesInfoDuDemandeurController.demandeur.getDateDepotDossier());
		typeDemande.setText(LesInfoDuDemandeurController.demandeur.getTypeDemande());
		demandeForagePompage.setText("" + LesInfoDuDemandeurController.demandeur.getDemandeFile());

		/* Les information concernant l'mmobilier */

		lcationImm.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getLocalisation());
		douar.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getDouar());
		commune.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getCommune());
		province.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getProvince());
		AttestationPossession
				.setText("" + LesInfoDelImmobilierController.InfoSurImmobilier.getAttestationDePocession());

		/* Les information concernant le point d'eau */

		locationPoin.setText(InformationsConcernantPointDeauController.poinDeau.getLocalisationPoint());
		debit.setText("" + InformationsConcernantPointDeauController.poinDeau.getDebit());
		profondeur.setText("" + InformationsConcernantPointDeauController.poinDeau.getProfondeur());
		rabattement.setText("" + InformationsConcernantPointDeauController.poinDeau.getRabattement());
		planEau.setText("" + InformationsConcernantPointDeauController.poinDeau.getPlanEau());

	}
}
