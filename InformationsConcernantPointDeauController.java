
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.PointDeau;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class InformationsConcernantPointDeauController implements Initializable {
	/*
	 * Decalaration des attrributs .
	 */

	@FXML
	private TextField locationEau;
	@FXML
	private BorderPane borderPan;
	@FXML
	private TextField debit;
	@FXML
	private TextField profondeur;
	@FXML
	private Button goButton;
	@FXML
	private TextField rabattement;
	@FXML
	private Label textError, pathPlandeau;
	@FXML
	private Button chooseFileImageButton;
	@FXML
	private Button backMethode;
	@FXML
	private TextField poinEau;

	public static PointDeau poinDeau = new PointDeau();

	@FXML
	public void chooseFileImageMethode(ActionEvent event) {

	}

	@FXML
	public void goMethode(ActionEvent event) throws IOException {
		/*
		 * initialisation de l'objet <<poinDeau>> par les champs remplis.
		 */
		if (isValideString(locationEau) & isValideFloat(debit) & isValideFloat(profondeur) &  
				isValideFloat(poinEau)	) {
			poinDeau = new PointDeau(locationEau.getText().toString(), new Float(debit.getText()),
					new Float(profondeur.getText()), new Float(poinEau.getText()));

			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("Fxml/Enregistrer.fxml"));
			Parent demandeurRoot = loader.load();
			
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene demandeurScene = new Scene(demandeurRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(demandeurScene);
			
		} else {
			textError.setText("\u0627\u0644\u0645\u0631\u062c\u0648 \u0645\u0644\u0626 \u0643\u0644 \u0627\u0644\u062e\u0627\u0646\u0627\u062a \u0628\u0645\u0627 \u064a\u0646\u0627\u0633\u0628");

		}
	}

	@FXML
	public void backButtonMethode(ActionEvent event) throws IOException {

		try {
			
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("Fxml/Les-informations-concernant-l'immobilier.fxml"));
			Parent demandeurRoot = loader.load();
			
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene demandeurScene = new Scene(demandeurRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(demandeurScene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean isValideFloat(TextField text) {
		/*
		 * La méthode a pour but de vérifier est ce que le paramètre texte est du type Float.
		 */
		try {
			float nbr = Float.parseFloat(text.getText());
			return true;
		} catch (NumberFormatException e) {
			text.setStyle("-fx-border-color: red;");
			return false;
		}
	}

	public boolean isValideString(TextField text) {
		/*
		 * La méthode a pour but de vérifier est ce que le paramètre text est du type
		 * String.
		 */
		if (text.getText().isEmpty()) {
			text.setStyle("-fx-border-color: red;");
			return false;
		} else {
			try {
				float nbr = Float.parseFloat(text.getText());
				text.setStyle("-fx-border-color: red;");
				return false;
			} catch (NumberFormatException e) {

				return true;
			}
		}
	}

	public boolean isNotValideFile(File file) {
		if (file == null) {
			chooseFileImageButton.setStyle("-fx-border-color: red;");
			return false;
		}
		return true;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		initialiserInputs();
	}

	public void initialiserInputs() {

		// initialiser le champs du localisation point d'eau
		if (poinDeau.getLocalisationPoint() != null)
			locationEau.setText(poinDeau.getLocalisationPoint());

		// initialiser le champs du debit
		if (poinDeau.getDebit() != 0)
			debit.setText("" + poinDeau.getDebit());

		// initialiser le champs du profondeur
		if (poinDeau.getProfondeur() != 0)
			profondeur.setText("" + poinDeau.getProfondeur());


		// initialiser le path du fichier d'attestation de pocession d'immobilier
		if (poinDeau.getPlanEau() != 0)
			poinEau.setText("" + poinDeau.getPlanEau());
	}

}
