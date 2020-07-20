package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Demandeur;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import matrouhTest.Test;
import javafx.fxml.Initializable;

public class LesInfoDuDemandeurController implements Initializable{
	
	public static final Demandeur demandeur = new Demandeur();
	private File cinFile = null, demandeFile = null;
	
	@FXML
    private TextField nomIput;

    @FXML
    private TextField prenomInput;

    @FXML
    private TextField cinInput;

    @FXML
    private DatePicker dateDepotDossierInput;

    @FXML
    private ChoiceBox<String> typeDemandeChoice;

    @FXML
    private Button cinFileButton;
    
    @FXML
    private Label cinFilePath;

    @FXML
    private Button demandeFileButton;
    
    @FXML
    private Label demandeFilePath;

    @FXML
    private Button suivantButton;
    
    @FXML
    private Label textError;

    @FXML
    void suivant(MouseEvent event) {
    	
    	if(checked()) {
    		
    		demandeur.setNom(nomIput.getText());
    		demandeur.setPrenom(prenomInput.getText());
    		demandeur.setCin(cinInput.getText());
    		demandeur.setDateDepotDossier(dateDepotDossierInput.getValue());
    		demandeur.setTypeDemande(typeDemandeChoice.getValue());
    		demandeur.setCinFile(cinFile);
    		demandeur.setDemandeFile(demandeFile);
		
    		try {
    			
    			Parent dashboardRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/Les-informations-concernant-l'immobilier.fxml"));
				Scene dashboardScene = new Scene(dashboardRoot);
				Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				primaryStage.setScene(dashboardScene);
				
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    
    	}else {
    		textError.setText("veuillez remplir tous les champs correctement");
    	}
    }
	
    @FXML
    void uploadFile(MouseEvent event) {
    	
    	FileChooser fc = new FileChooser();
    	fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("image/pdf/docx", "*.jpg", "*.png", "*.pdf", "*.docx"));
        
        File file = fc.showOpenDialog(new Stage());
        if(file != null) {
        	if(event.getSource() == cinFileButton) {
        		cinFile = file;
        		cinFilePath.setText(cinFile.getName());
        	}else if(event.getSource() == demandeFileButton){
        		demandeFile = file;
        		demandeFilePath.setText(demandeFile.getName());
        	}
        }
        
    }
	
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		typeDemandeChoice.getItems().addAll("Type de demande","Forage", "Pompage");
		initialiserInputs();
		cinFilePath.setText(cinFile != null ? cinFile.getName() : "");
		demandeFilePath.setText(demandeFile != null ? demandeFile.getName() : "");
		
	}
	
	 private boolean checked() {
	    	
	    	boolean condition = true;
	    	if(nomIput.getText().isEmpty()){
	    		nomIput.setStyle("-fx-border-color: red");
	    		condition = condition && false;
	    	}
	    	
	    	if(prenomInput.getText().isEmpty()) {
	    		prenomInput.setStyle("-fx-border-color: red");
	    		condition = condition && false;
	    	}
	    	
	    	if(cinInput.getText().isEmpty()) {
	    		cinInput.setStyle("-fx-border-color: red");
	    		condition = condition && false;
	    	}
	    	
	    	if(dateDepotDossierInput == null) {
	    		dateDepotDossierInput.setStyle("-fx-border-color: red");
	    		condition = condition && false;
	    	}
	    	
	    	if(typeDemandeChoice.getValue() == "Type de demande") {
	    		typeDemandeChoice.setStyle("-fx-border-color: red");
	    		condition = condition && false;
	    	}
	    	
	    	if(cinFile == null) {
	    		cinFileButton.setStyle("-fx-border-color: red");
	    		condition = condition && false;
	    	}
	    	
	    	if(demandeFile == null) {
	    		demandeFileButton.setStyle("-fx-border-color: red");
	    		condition = condition && false;
	    	}
	    	
	    	return condition;
	    }
	 
	 //---------
	 private void initialiserInputs() {
		 
		 //initialiser le champs du nom
		 if(demandeur.getNom() != null)
			 nomIput.setText(demandeur.getNom());
		 
		//initialiser le champs du prenom
		 if(demandeur.getPrenom() != null)
			 prenomInput.setText(demandeur.getPrenom());
		 
		//initialiser le champs du cin
		 if(demandeur.getCin() != null)
			 cinInput.setText(demandeur.getCin());
		 
		//initialiser le champs du date de depot du dossier
		 if(demandeur.getNom() != null)
			 dateDepotDossierInput.setValue(demandeur.getDateDepotDossier());
		 
		//initialiser le chapms du type de demande
		 if(demandeur.getTypeDemande() == null)
			 typeDemandeChoice.setValue("Type de demande");
		 else
			 typeDemandeChoice.setValue(demandeur.getTypeDemande());
		 
		//initialiser le fichierdu cin
		 if(demandeur.getCinFile() != null)
			cinFile = demandeur.getCinFile();
		 
		//initialiser le fichier de demande
		 if(demandeur.getDemandeFile() != null)
			 demandeFile = demandeur.getDemandeFile();
		    
	 }
	
}
