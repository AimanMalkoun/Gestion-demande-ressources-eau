package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

	// Event Listener on Button[#modifyButton].onAction
	@FXML
	public void modifyButtonMethode(ActionEvent event) {

	}

	// Event Listener on Button[#saveBuuton].onAction
	@FXML
	public void savebuttonMethode(ActionEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("../Fxml/AEteEnregistrer.fxml"));
		borderPane.getChildren().setAll(root);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		locationPoin.setText(InformationsConcernantPointDeauController.poinDeau.getLocalisationPoint());
		debit.setText(""+InformationsConcernantPointDeauController.poinDeau.getDebit());
		profondeur.setText(""+InformationsConcernantPointDeauController.poinDeau.getProfondeur());
		rabattement.setText(""+InformationsConcernantPointDeauController.poinDeau.getRabattement());
		planEau.setText(""+InformationsConcernantPointDeauController.poinDeau.getPlanEau());
	}
}
