package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Demandeur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import matrouhTest.Test;
import javafx.fxml.Initializable;

public class LesInfoDuDemandeurController implements Initializable{
	
	public static final Demandeur demandeur = new Demandeur();
	private File cinFile, demandeFile;
	
	@FXML
    private TextField nomIput;

    @FXML
    private TextField prenomInput;

    @FXML
    private TextField cinInput;

    @FXML
    private DatePicker dateDepotDossierInput;

    @FXML
    private ChoiceBox<?> typeDemandeChoice;

    @FXML
    private Button cinFileButton;

    @FXML
    private Button demandeFileButton;

    @FXML
    private Button suivantButton;

    @FXML
    void suivant(MouseEvent event) {
    	
    	if(checked()) {
    		demandeur.setNom(nomIput.getText());
    		demandeur.setPrenom(prenomInput.getText());
    		demandeur.setCin(cinInput.getText());
    		demandeur.setDateDepotDossier(dateDepotDossierInput.getValue());
    		demandeur.setCinFile(cinFile);
    		demandeur.setDemandeFile(demandeFile);
		
    		try {
    			Test.window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Fxml/Les-informations-concernant-l'immobilier.fxml"))));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    
    	}
    	System.out.println(demandeur);
    }
	
    @FXML
    void uploadFile(MouseEvent event) {
    	
    	FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)", "*JPG");
        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)", "*PNG");
        FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("PDF files(*.pdf)", "*PDF");
        fc.getExtensionFilters().addAll(ext1, ext2, ext3);
        
        File file = fc.showOpenDialog(new Stage());
        if(event.getSource() == cinFileButton) {
        	cinFile = file;
        }else if(event.getSource() == demandeFileButton){
        	demandeFile = file;
        }
        
    }
	
    
	
    private boolean checked() {
    	return true;
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
	
}
