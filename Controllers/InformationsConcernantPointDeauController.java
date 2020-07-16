package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.PointDeau;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

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
	private Label textError;
	@FXML
	private Button chooseFileImageButton;
	@FXML
	private Button backMethode;
	private File file;
	public static PointDeau poinDeau;

	@FXML
	public void chooseFileImageMethode(ActionEvent event) {
		/*
		 *la m�thode a pour but d'ouvrir une session dans laquelle l'utilisateur peut 
		 *s�lectionner un fichier ou une image.
		 */
		FileChooser fileChoosed = new FileChooser();
		fileChoosed.setTitle("Uplouding an image");
		fileChoosed.getExtensionFilters()
				.add(new FileChooser.ExtensionFilter("image/pdf/docx", "*.jpg", "*.png", "*.pdf", "*.docx"));
		file = fileChoosed.showOpenDialog(null);
	}

	@FXML
	public void goMethode(ActionEvent event) throws IOException {
		/*
		 *initialisation de l'objet <<poinDeau>> par les champs remplis. 
		 */
		if (isStringValide(locationEau) & isFloatValide(debit) & isFloatValide(profondeur) & isFloatValide(rabattement)
				& file != null) {
			poinDeau = new PointDeau(locationEau.getText().toString(), new Float(debit.getText()),
					new Float(profondeur.getText()), file, new Float(rabattement.getText()));
			Parent root = FXMLLoader.load(getClass().getResource("../Fxml/Enregistrer.fxml"));
			borderPan.getChildren().setAll(root);
		} else {
			textError.setText("S.V.P veuillez remplir tous les champs correctement");
		}
	}

	@FXML
	public void backMethode(ActionEvent event) {

	}

	public boolean isFloatValide(TextField text) {
		/*
		 *La m�thode a pour but de v�rifier est ce que le param�tre texte est du type Float.
		 */
		try {
			float nbr = Float.parseFloat(text.getText());
			return true;
		} catch (NumberFormatException e) {
			text.setStyle("-fx-border-color: red;");
			return false;
		}
	}

	public boolean isStringValide(TextField text) {
		/*
		 *La m�thode a pour but de v�rifier est ce que le param�tre texte est du type String.
		 */
		try {
			float nbr = Float.parseFloat(text.getText());
			text.setStyle("-fx-border-color: red;");
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
