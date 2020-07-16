package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.Immobilier;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import matrouhTest.Test;

public class LesInfoDelImmobilierController implements Initializable{

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
			Test.window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Fxml/InformationsDuDemandeur.fxml"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void suivant(MouseEvent event) {
    	
    		if(checked()) {
    			InfoSurImmobilier.setLocalisation(localisation.getText());
    			InfoSurImmobilier.setLocalisation(douar.getText());
    			InfoSurImmobilier.setCommune(commune.getText());
    			InfoSurImmobilier.setProvince(province.getText());
    			InfoSurImmobilier.setAttestationDePocession(attestationFile);
    			
    			try {
        			Test.window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Fxml/InformationsConcernantPointDeau.fxml"))));
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
    			System.out.println(InfoSurImmobilier);
    			
    		}else {
        		textError.setText("veuillez remplir tous les champs correctement");
        	}
    		
    }

    @FXML
    void uploadFile(MouseEvent event) {
    	
    	FileChooser fc = new FileChooser();
    	fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("image/pdf/docx", "*.jpg", "*.png", "*.pdf", "*.docx"));
        
        File file = fc.showOpenDialog(new Stage());
        attestationFile = file;
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		initialiserInputs();
		attestationFilePath.setText(attestationFile != null ? attestationFile.getPath() : "");
		
	}
	
	private boolean checked() {
		boolean condition = true;
		if(localisation.getText().isEmpty()){
			localisation.setStyle("-fx-border-color: red");
    		condition = condition && false;
    	}
    	
    	if(douar.getText().isEmpty()) {
    		douar.setStyle("-fx-border-color: red");
    		condition = condition && false;
    	}
    	
    	System.out.println(commune);
    	System.out.println(commune.getText() + "hhhhh");
    	if(commune.getText().isEmpty()) {
    		commune.setStyle("-fx-border-color: red");
    		condition = condition && false;
    	}
    	
    	if(province.getText().isEmpty()) {
    		province.setStyle("-fx-border-color: red");
    		condition = condition && false;
    	}
    	
    	if(attestationFile == null) {
    		attistationFileButton.setStyle("-fx-border-color: red");
    		condition = condition && false;
    	}
		
    	return condition;
    }
	
	public void initialiserInputs() {
		//initialiser le champs du localisation
		 if(InfoSurImmobilier.getLocalisation() != null)
			 localisation.setText(InfoSurImmobilier.getLocalisation());
		 
		//initialiser le champs du douar
		 if(InfoSurImmobilier.getDouar() != null)
			 douar.setText(InfoSurImmobilier.getDouar());
		 
		//initialiser le champs du commune
		 if(InfoSurImmobilier.getCommune() != null)
			 commune.setText(InfoSurImmobilier.getCommune());
		 
		//initialiser le chapms du type du province
		 if(InfoSurImmobilier.getProvince() != null)
			 province.setText(InfoSurImmobilier.getProvince());
		 
		//initialiser le path du fichier d'attestation de pocession d'immobilier
		 if(InfoSurImmobilier.getAttestationDePocession() != null)
			 attestationFile = InfoSurImmobilier.getAttestationDePocession();
	}

}
