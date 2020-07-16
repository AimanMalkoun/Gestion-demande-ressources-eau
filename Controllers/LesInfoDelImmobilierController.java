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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import matrouhTest.Test;

public class LesInfoDelImmobilierController implements Initializable{

	public static final Immobilier InfoSurImmobilier = new Immobilier();
	private File attestationFile;
	
	@FXML
    private TextField locatiosation;

    @FXML
    private TextField douar;

    @FXML
    private TextField commune;

    @FXML
    private TextField province;

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
    			InfoSurImmobilier.setLocalisation(locatiosation.getText());
    			InfoSurImmobilier.setLocalisation(douar.getText());
    			InfoSurImmobilier.setCommune(commune.getText());
    			InfoSurImmobilier.setProvince(province.getText());
    			InfoSurImmobilier.setAttestationDePocession(attestationFile);
    			
    			try {
        			Test.window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Fxml/les-informations-concernant-le-point d'eau.fxml"))));
        		} catch (IOException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
    			
    			System.out.println(InfoSurImmobilier);
    			
    		}
    }

    @FXML
    void uploadFile(MouseEvent event) {
    	
    	FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)", "*JPG");
        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)", "*PNG");
        FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("PDF files(*.pdf)", "*PDF");
        fc.getExtensionFilters().addAll(ext1, ext2, ext3);
        
        File file = fc.showOpenDialog(new Stage());
        attestationFile = file;
    }
	
	
    private boolean checked() {
    	return true;
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
