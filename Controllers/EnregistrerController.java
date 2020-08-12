package Controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.ResourceBundle;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
	private Label cinFile;

	@FXML
	private Label douar;
	@FXML
	private Label commune;
	@FXML
	private Label province;
	@FXML
	private Label AttestationPossession;

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
	private Label demande;
	@FXML
	private Label daira;
	@FXML
	private Label qiyada;
	@FXML
	private Label palnImm;
	@FXML
	private Label nomImmobilier;
	@FXML
	BorderPane borderPane;
	public static int idDossier = 20200000;
	public static String idDossierYear;

	// Event Listener on Button[#modifyButton].onAction
	@FXML
	public void modifyButtonMethode(ActionEvent event) throws IOException {

		try {

			FXMLLoader loader = new FXMLLoader();
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			loader.setLocation(getClass().getResource("../Fxml/InformationsDuDemandeur.fxml"));
			Parent demandeurRoot = loader.load();

			Scene demandeurScene = new Scene(demandeurRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(demandeurScene);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Event Listener on Button[#saveBuuton].onAction
	@FXML
	public void savebuttonMethode(ActionEvent event) throws IOException, SQLException {

		/* se connecter avec la base de donn�es */

		ConnectionClass conn = new ConnectionClass();
		Connection connection = conn.getConnection();

		Statement statId = connection.createStatement();

		/* S�lectionner le plus grand idDossier */
		String sqlId = "SELECT MAX(IdDossier)  FROM dossier";
		ResultSet result = statId.executeQuery(sqlId);
		if (result.next()) {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			idDossier = result.getInt(1) + 1;
			idDossierYear =  idDossier + "/" + year ; 
			
		}
		/*
		 * Creation de l'objet InputStream afin de le stocker dans la base de donn�es
		 */

		InputStream cinFile = new FileInputStream(LesInfoDuDemandeurController.demandeur.getCinFile());
		InputStream demandeCreusement = new FileInputStream(LesInfoDuDemandeurController.demandeur.getDemandeFile());
		InputStream attistation = new FileInputStream(LesInfoDelImmobilierController.InfoSurImmobilier.getAttestationDePocession());
		InputStream planImmFile = new FileInputStream(LesInfoDelImmobilierController.InfoSurImmobilier.getPlanImmobilier());
		/* la requite sql de l'insertion */

		String sql = "INSERT INTO `dossier`(`IdDossier`, `Nom`, `Prenom`, `cin`, `cinImg`, `typeDemande`,"
				+ " `demandeCreusement`, `attistationPocession`, `Douar`, `Commune`, `Province`, `localisationPointEau`"
				+ ", `Debit`, `Profendeur`, `PlanDeau`, `daaira`, `DateDepot`, `dateEnvoiABHOER`, "
				+ "`dateDebut_EP`, `dateFin_EP`, `dateSignature_PV`, `AvisDeCEP`, `DateEnvoiDuPV_ABHOER`, "
				+ "`AvisABHOER`, `Autorisation`, `qiyada`, `planImmo`, `nomImmobilier`, `idDossierYear`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {

			/* l'insertion des el�ments dans la base de donnees */

			PreparedStatement stat = connection.prepareStatement(sql);
			stat.setInt(1, idDossier);
			stat.setString(2, LesInfoDuDemandeurController.demandeur.getNom());
			stat.setString(3, LesInfoDuDemandeurController.demandeur.getPrenom());
			stat.setString(4, LesInfoDuDemandeurController.demandeur.getCin());
			stat.setBytes(5, cinFile.readAllBytes());
			stat.setString(6, LesInfoDuDemandeurController.demandeur.getTypeDemande());
			stat.setBytes(7, demandeCreusement.readAllBytes());
			stat.setBytes(8, attistation.readAllBytes());
			stat.setString(9, LesInfoDelImmobilierController.InfoSurImmobilier.getDouar());
			stat.setString(10, LesInfoDelImmobilierController.InfoSurImmobilier.getCommune());
			stat.setString(11, LesInfoDelImmobilierController.InfoSurImmobilier.getProvince());
			stat.setString(12, InformationsConcernantPointDeauController.poinDeau.getLocalisationPoint());
			stat.setFloat(13, InformationsConcernantPointDeauController.poinDeau.getDebit());
			stat.setFloat(14, InformationsConcernantPointDeauController.poinDeau.getProfondeur());
			stat.setFloat(15, InformationsConcernantPointDeauController.poinDeau.getPlanEau());
			stat.setString(16, LesInfoDelImmobilierController.InfoSurImmobilier.getDaaira());

			stat.setString(17, LesInfoDuDemandeurController.demandeur.getDateDepotDossier());
			stat.setString(18, "");
			stat.setString(19, "");
			stat.setString(20, "");
			stat.setString(21, "");
			stat.setString(22, "\u0644\u0627 \u0634\u064a\u0621");
			stat.setString(23, "");
			stat.setString(24, "\u0644\u0627 \u0634\u064a\u0621");
			stat.setString(25, "\u0644\u0627 \u0634\u064a\u0621");
			stat.setString(26, LesInfoDelImmobilierController.InfoSurImmobilier.getQuiada());
			stat.setBytes(27, planImmFile.readAllBytes());
			stat.setString(28, LesInfoDelImmobilierController.InfoSurImmobilier.getNomImmobilier());
			stat.setString(29, idDossierYear);
			stat.execute();
			
			stat.close();
			connection.close();

			//close the file input stream
			cinFile.close();
			demandeCreusement.close();
			attistation.close();
			planImmFile.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("../Fxml/AEteEnregistrer.fxml"));
			Parent AEteEnregistrerRoot = loader.load();

			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene AEteEnregistrerScene = new Scene(AEteEnregistrerRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(AEteEnregistrerScene);

		} catch (IOException e) {

			e.printStackTrace();
		}
	
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/* Les information du demandeur */

		firstName.setText(LesInfoDuDemandeurController.demandeur.getNom());
		lastName.setText(LesInfoDuDemandeurController.demandeur.getPrenom());
		codeCin.setText(LesInfoDuDemandeurController.demandeur.getCin());
		dateDepot.setText("" + LesInfoDuDemandeurController.demandeur.getDateDepotDossier());
		typeDemande.setText(LesInfoDuDemandeurController.demandeur.getTypeDemande());
		cinFile.setText(LesInfoDuDemandeurController.demandeur.getCinFile().getName());
		demande.setText(LesInfoDuDemandeurController.demandeur.getDemandeFile().getName());

		/* Les information concernant l'mmobilier */

		nomImmobilier.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getNomImmobilier());
		daira.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getDaaira());
		douar.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getDouar());
		commune.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getCommune());
		province.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getProvince());
		AttestationPossession
				.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getAttestationDePocession().getName());
		qiyada.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getQuiada());
		palnImm.setText(LesInfoDelImmobilierController.InfoSurImmobilier.getPlanImmobilier().getName());

		/* Les information concernant le point d'eau */

		locationPoin.setText(InformationsConcernantPointDeauController.poinDeau.getLocalisationPoint());
		debit.setText("" + InformationsConcernantPointDeauController.poinDeau.getDebit());
		profondeur.setText("" + InformationsConcernantPointDeauController.poinDeau.getProfondeur());
		planEau.setText("" + InformationsConcernantPointDeauController.poinDeau.getPlanEau());

	}
}
