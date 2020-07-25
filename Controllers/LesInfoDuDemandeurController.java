package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Demandeur;
import Classes.ImagesOrPdfChooser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

public class LesInfoDuDemandeurController implements Initializable{
	
	public static final Demandeur demandeur = new Demandeur();
	private File cinFile = null, demandeFile = null;
	
	@FXML
    private HBox hbox1;

    @FXML
    private Pane pane1;

    @FXML
    private HBox titleHbox;
	@FXML
	private BorderPane borderPane;
	
	@FXML
	private ScrollPane scrollPane;
	
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
    			
    			FXMLLoader loader= new FXMLLoader();
    			loader.setLocation(getClass().getResource("../Fxml/Les-informations-concernant-l'immobilier.fxml"));
    			Parent demandeurRoot = loader.load();
    			
				Scene demandeurScene = new Scene(demandeurRoot);
				Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				primaryStage.setScene(demandeurScene);
				
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
    	
        if(event.getSource() == cinFileButton) {
        	
            ImagesOrPdfChooser.desplay("Choisir la CIN", "CIN.pdf");
            File file = ImagesOrPdfChooser.result;
        	if(file != null) {
        		cinFile = file;
        		cinFilePath.setText(cinFile.getName());
        	}
        	
        }else if(event.getSource() == demandeFileButton){
        	
            ImagesOrPdfChooser.desplay("Choisir la demande de creusement", "Demande_de_creusement.pdf");
            File file = ImagesOrPdfChooser.result;
        	if(file != null) {
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
	    	
	    	if(dateDepotDossierInput.getValue() == null) {
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
