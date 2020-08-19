package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.ImagesOrPdfChooser;
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
import javafx.stage.Stage;

public class LesInfoDelImmobilierController implements Initializable {

	public static final Immobilier InfoSurImmobilier = new Immobilier();
	private File attestationFile, planImmobilierFile;


	 @FXML
	    private TextField daaira;

	    @FXML
	    private TextField douar;

	    @FXML
	    private TextField commune;

	    @FXML
	    private Button suivant;

	    @FXML
	    private Button precedent;

	    @FXML
	    private Button attistationFileButton;

	    @FXML
	    private Label attestationFilePath;

	    @FXML
	    private TextField province;

	    @FXML
	    private Button planImmobilierFileButton;

	    @FXML
	    private Label planImmobilierFilePath;

	    @FXML
	    private TextField quiada;

	    @FXML
	    private TextField nomImmobilier;

	    @FXML
	    private Label textError;

	@FXML
	void precedent(MouseEvent event) {
		try {

			Parent dashboardRoot = (Parent) FXMLLoader
					.load(getClass().getResource("../Fxml/InformationsDuDemandeur.fxml"));
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene dashboardScene = new Scene(dashboardRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(dashboardScene);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void suivant(MouseEvent event) {

		if (checked()) {
			
			InfoSurImmobilier.setNomImmobilier(nomImmobilier.getText());
			InfoSurImmobilier.setDaaira(daaira.getText());
			InfoSurImmobilier.setQuiada(quiada.getText());
			InfoSurImmobilier.setDouar(douar.getText());
			InfoSurImmobilier.setCommune(commune.getText());
			InfoSurImmobilier.setProvince(province.getText());
			InfoSurImmobilier.setAttestationDePocession(attestationFile);
			InfoSurImmobilier.setPlanImmobilier(planImmobilierFile);

			try {

				Parent dashboardRoot = (Parent) FXMLLoader
						.load(getClass().getResource("../Fxml/InformationsConcernantPointDeau.fxml"));
				
				Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				Scene dashboardScene = new Scene(dashboardRoot, primaryStage.getWidth(), primaryStage.getHeight());
				primaryStage.setScene(dashboardScene);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			textError.setText("\u0627\u0644\u0645\u0631\u062c\u0648 \u0645\u0644\u0626 \u0643\u0644 \u0627\u0644\u062e\u0627\u0646\u0627\u062a \u0628\u0645\u0627 \u064a\u0646\u0627\u0633\u0628");
		}

	}

	@FXML
	void uploadFile(MouseEvent event) {
		
		if (event.getSource() == attistationFileButton) {
			ImagesOrPdfChooser.desplay("\u0625\u062e\u062a\u064a\u0627\u0631 \u0634\u0647\u0627\u062f\u0629 \u0645\u0644\u0643\u064a\u0629 \u0627\u0644\u0639\u0642\u0627\u0631", "Attestation_pocession_Immobilier.pdf");
			File file = ImagesOrPdfChooser.result;
			if(file != null) {
				attestationFile = file;
				attestationFilePath.setText(file.getName());
			}
		}
		
		if (event.getSource() == planImmobilierFileButton) {
			ImagesOrPdfChooser.desplay("\u0625\u062e\u062a\u064a\u0627\u0631 \u062a\u0635\u0645\u064a\u0645 \u0627\u0644\u0639\u0642\u0627\u0631", "plan_Immobilier.pdf");
			File file = ImagesOrPdfChooser.result;
			if(file != null) {
				planImmobilierFile = file;
				planImmobilierFilePath.setText(file.getName());
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initialiserInputs();

	}

	private boolean checked() {
		boolean condition = true;
		
		if (nomImmobilier.getText().isEmpty()) {
			nomImmobilier.setStyle("-fx-border-color: red");
			condition = condition && false;
		}
		
		if (daaira.getText().isEmpty()) {
			daaira.setStyle("-fx-border-color: red");
			condition = condition && false;
		}
		
		if (quiada.getText().isEmpty()) {
			quiada.setStyle("-fx-border-color: red");
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
		
		if (planImmobilierFile == null) {
			planImmobilierFileButton.setStyle("-fx-border-color: red");
			condition = condition && false;
		}

		return condition;
	}

	private void initialiserInputs() {
		
		// initialiser le champs du daaira
		if (InfoSurImmobilier.getNomImmobilier() != null)
			nomImmobilier.setText(InfoSurImmobilier.getNomImmobilier());
				
		// initialiser le champs du daaira
		if (InfoSurImmobilier.getDaaira() != null)
			daaira.setText(InfoSurImmobilier.getDaaira());
		
		// initialiser le champs du daaira
		if (InfoSurImmobilier.getQuiada() != null)
			quiada.setText(InfoSurImmobilier.getQuiada());

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
		if (InfoSurImmobilier.getAttestationDePocession() != null) {
			
			attestationFile = InfoSurImmobilier.getAttestationDePocession();
			attestationFilePath.setText( attestationFile.getName());
			
		}
		
		if (InfoSurImmobilier.getPlanImmobilier() != null) {
			
			planImmobilierFile = InfoSurImmobilier.getAttestationDePocession();
			planImmobilierFilePath.setText( attestationFile.getName());
			
		}
		
	}
	

}
