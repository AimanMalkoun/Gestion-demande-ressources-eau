
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
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
    void annuler(MouseEvent event) {
    	
    	cleanup();
    	
		try {
			
			Parent dashboardRoot = (Parent) FXMLLoader.load(getClass().getResource("Fxml/Dashboard.fxml"));
			
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene dashboardScene = new Scene(dashboardRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(dashboardScene);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
    }

	private void cleanup() {
		LesInfoDuDemandeurController.demandeur.setNom(null);
		LesInfoDuDemandeurController.demandeur.setPrenom(null);
		LesInfoDuDemandeurController.demandeur.setCin(null);
		LesInfoDuDemandeurController.demandeur.setTypeDemande(null);
		LesInfoDuDemandeurController.demandeur.setCinFile(null);
		LesInfoDuDemandeurController.demandeur.setDemandeFile(null);
		LesInfoDuDemandeurController.demandeur.setDateDepotDossier(null);
		
		LesInfoDelImmobilierController.InfoSurImmobilier.setNomImmobilier(null);
		LesInfoDelImmobilierController.InfoSurImmobilier.setDaaira(null);
		LesInfoDelImmobilierController.InfoSurImmobilier.setQuiada(null);
		LesInfoDelImmobilierController.InfoSurImmobilier.setAttestationDePocession(null);
		LesInfoDelImmobilierController.InfoSurImmobilier.setDouar(null);
		LesInfoDelImmobilierController.InfoSurImmobilier.setCommune(null);
		LesInfoDelImmobilierController.InfoSurImmobilier.setProvince(null);
		LesInfoDelImmobilierController.InfoSurImmobilier.setPlanImmobilier(null);;
		
		
		InformationsConcernantPointDeauController.poinDeau.setLocalisationPoint(null);
		InformationsConcernantPointDeauController.poinDeau.setDebit(0);
		InformationsConcernantPointDeauController.poinDeau.setProfondeur(0);
		InformationsConcernantPointDeauController.poinDeau.setPlanEau(0);
		

	}

    @FXML
    void suivant(MouseEvent event) {
    	
    	if(checked()) {
    		
    		demandeur.setNom(nomIput.getText());
    		demandeur.setPrenom(prenomInput.getText());
    		demandeur.setCin(cinInput.getText());
    		demandeur.setDateDepotDossier(dateDepotDossierInput.getValue().toString());
    		demandeur.setTypeDemande(typeDemandeChoice.getValue());
    		demandeur.setCinFile(cinFile);
    		demandeur.setDemandeFile(demandeFile);
		
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
    
    	}else {
    		textError.setText("\u0627\u0644\u0645\u0631\u062c\u0648 \u0645\u0644\u0626 \u0643\u0644 \u0627\u0644\u062e\u0627\u0646\u0627\u062a \u0628\u0645\u0627 \u064a\u0646\u0627\u0633\u0628");
    	}
    }
	
    @FXML
    void uploadFile(MouseEvent event) {
    	
        if(event.getSource() == cinFileButton) {
        	
            ImagesOrPdfChooser.desplay("\u0625\u062e\u062a\u064a\u0627\u0631 \u0635\u0648\u0631\u0629 \u0628\u0637\u0627\u0642\u0629 \u0627\u0644\u062a\u0639\u0631\u064a\u0641 \u0627\u0644\u0648\u0637\u0646\u064a\u0629", "CIN.pdf");
            File file = ImagesOrPdfChooser.result;
        	if(file != null) {
        		cinFile = file;
        		cinFilePath.setText(cinFile.getName());
        	}else {
        		cinFile = null;
        	}
        	
        	
        }else if(event.getSource() == demandeFileButton){
        	
            ImagesOrPdfChooser.desplay("\u0625\u062e\u062a\u064a\u0627\u0631 \u0645\u0644\u0641 \u0627\u0644\u0637\u0644\u0628", "Demande_de_creusement.pdf");
            File file = ImagesOrPdfChooser.result;
        	if(file != null) {
        		demandeFile = file;
        		demandeFilePath.setText(demandeFile.getName());
        	}else {
        		demandeFile = null;
        	}
        	
        }
        
    }
	
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		typeDemandeChoice.getItems().addAll("\u0646\u0648\u0639 \u0627\u0644\u0637\u0644\u0628","\u0637\u0644\u0628 \u062d\u0641\u0631 \u062b\u0642\u0628 \u0645\u0627\u0626\u064a", "\u0637\u0644\u0628 \u062c\u0644\u0628 \u0627\u0644\u0645\u0627\u0621");
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
	    	
	    	if(typeDemandeChoice.getValue() == "\u0646\u0648\u0639 \u0627\u0644\u0637\u0644\u0628") {
	    		typeDemandeChoice.setStyle("-fx-border-color: red");
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
		 if(demandeur.getDateDepotDossier() != null && demandeur.getDateDepotDossier() != "")
			 dateDepotDossierInput.setValue(Date.valueOf(demandeur.getDateDepotDossier()).toLocalDate());
		 else
			 dateDepotDossierInput.setValue(LocalDate.now());
		 
		//initialiser le chapms du type de demande
		 if(demandeur.getTypeDemande() == null || demandeur.getTypeDemande() == "")
			 typeDemandeChoice.setValue("\u0646\u0648\u0639 \u0627\u0644\u0637\u0644\u0628");
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
