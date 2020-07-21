package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Immobilier;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class LesInfoDelImmobilierController implements Initializable {

	public static final Immobilier InfoSurImmobilier = new Immobilier();
	private File attestationFile;

	@FXML
	private TextField localisation;

	@FXML
	private TextField douar;

	@FXML
	private TextField commune;

	@FXML
	private TextField province;

	@FXML
	private Button attistationFileButton;

	@FXML
	private Label attestationFilePath;

	@FXML
	private Label textError;

	@FXML
	void precedent(MouseEvent event) {
		try {

			Parent dashboardRoot = (Parent) FXMLLoader
					.load(getClass().getResource("../Fxml/InformationsDuDemandeur.fxml"));
			Scene dashboardScene = new Scene(dashboardRoot);
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			primaryStage.setScene(dashboardScene);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void suivant(MouseEvent event) {

		if (checked()) {
			InfoSurImmobilier.setLocalisation(localisation.getText());
			InfoSurImmobilier.setDouar(douar.getText());
			InfoSurImmobilier.setCommune(commune.getText());
			InfoSurImmobilier.setProvince(province.getText());
			InfoSurImmobilier.setAttestationDePocession(attestationFile);

			try {

				Parent dashboardRoot = (Parent) FXMLLoader
						.load(getClass().getResource("../Fxml/InformationsConcernantPointDeau.fxml"));
				Scene dashboardScene = new Scene(dashboardRoot);
				Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				primaryStage.setScene(dashboardScene);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			textError.setText("veuillez remplir tous les champs correctement");
		}

	}

	@FXML
	void uploadFile(MouseEvent event) {

		FileChooser fc = new FileChooser();
		fc.getExtensionFilters()
				.addAll(new FileChooser.ExtensionFilter("image/pdf/docx", "*.jpg", "*.png", "*.pdf", "*.docx"));

		File file = fc.showOpenDialog(new Stage());
		if(file != null) {
			attestationFile = file;
			attestationFilePath.setText(file.getName());
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		initialiserInputs();
		attestationFilePath.setText(attestationFile != null ? attestationFile.getName() : "");

	}

	private boolean checked() {
		boolean condition = true;
		if (localisation.getText().isEmpty()) {
			localisation.setStyle("-fx-border-color: red");
			condition = condition && false;
		}

		if (douar.getText().isEmpty()) {
			douar.setStyle("-fx-border-color: red");
			condition = condition && false;
		}

		if (commune.getText().isEmpty()) {
			commune.setStyle("-fx-border-color: red");
			condition = condition && false;
		}

		if (province.getText().isEmpty()) {
			province.setStyle("-fx-border-color: red");
			condition = condition && false;
		}

		if (attestationFile == null) {
			attistationFileButton.setStyle("-fx-border-color: red");
			condition = condition && false;
		}

		return condition;
	}

	public void initialiserInputs() {
		// initialiser le champs du localisation
		if (InfoSurImmobilier.getLocalisation() != null)
			localisation.setText(InfoSurImmobilier.getLocalisation());

		// initialiser le champs du douar
		if (InfoSurImmobilier.getDouar() != null)
			douar.setText(InfoSurImmobilier.getDouar());

		// initialiser le champs du commune
		if (InfoSurImmobilier.getCommune() != null)
			commune.setText(InfoSurImmobilier.getCommune());

		// initialiser le chapms du type du province
		if (InfoSurImmobilier.getProvince() != null)
			province.setText(InfoSurImmobilier.getProvince());

		// initialiser le path du fichier d'attestation de pocession d'immobilier
		if (InfoSurImmobilier.getAttestationDePocession() != null)
			attestationFile = InfoSurImmobilier.getAttestationDePocession();
	}

}
