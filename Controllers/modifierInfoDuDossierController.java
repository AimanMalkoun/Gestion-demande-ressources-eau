package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Classes.ChangeChoiceAlert;
import Classes.ChangeDateAlert;
import Classes.ChangeFileAlert;
import Classes.ChangeNumberAlert;
import Classes.ChangeStringAlert;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import matrouhTest.Test;

public class modifierInfoDuDossierController implements Initializable{


	@FXML
    private Label nomLabel;

    @FXML
    private Button nomButton;

    @FXML
    private Label prenomLabel;

    @FXML
    private Button prenomButton;

    @FXML
    private Label provinceLabel;

    @FXML
    private Button provinceButton;

    @FXML
    private Label communeLabel;

    @FXML
    private Button communeButton;

    @FXML
    private Label douarLabel;

    @FXML
    private Button douarButton;

    @FXML
    private Label attestationPoscessionLocalisationImmobilierLabel;

    @FXML
    private Button attestationPocessionImmobilierFileButton;

    @FXML
    private Label localisationImmobilierLabel;

    @FXML
    private Button localisationImmobilierButton;

    @FXML
    private Label demandeDeCcreusementPathLabel;

    @FXML
    private Button demandeCreusementFileButton;

    @FXML
    private Label typeDeDemandeLabel;

    @FXML
    private Button typeDemandeButton;

    @FXML
    private Label carteCinPathLabel;

    @FXML
    private Button cinFileButton;

    @FXML
    private Label codCinLabel;

    @FXML
    private Button codCinButton;

    @FXML
    private Label LocalisationPointEauLabel;

    @FXML
    private Button localisationPointEauButton;

    @FXML
    private Label planEauPathLabel;

    @FXML
    private Button planEauButton;

    @FXML
    private Label rabattementLabel;

    @FXML
    private Button rabatementButton;

    @FXML
    private Label DateDepotDossierLabel;

    @FXML
    private Button dateDepotDossierButton;

    @FXML
    private Label dateDenvoiAlabhouerEljaidaLabel;

    @FXML
    private Button dateDenvoiAlabhouerEljaidaButton;

    @FXML
    private Label dateDebutEnquetePublicLabel;

    @FXML
    private Button dateDebutEnquetePublicButton;

    @FXML
    private Label dateFinEnquetePublicLabel;

    @FXML
    private Button dateFinEnquetePublicButton;

    @FXML
    private Label dateSignaturPVparCEPLabel;

    @FXML
    private Button dateSignaturPVparCEPButton;

    @FXML
    private Label AvisDeCEPLabel;

    @FXML
    private Button AvisDeCEPButton;

    @FXML
    private Label dateEnvoitPvAbhoerEljadidaLabel;

    @FXML
    private Button dateEnvoitPvAbhoerEljadidaButton;

    @FXML
    private Label AvisAbhoerLabel;

    @FXML
    private Button AvisAbhoerButton;

    @FXML
    private Label profondeurLabel;

    @FXML
    private Button ProfondeurButton;

    @FXML
    private Label debitLabel;

    @FXML
    private Button debitButton;

    @FXML
    private Label autorisationLabel;

    @FXML
    private Button autorisationButton;

    @FXML
    void annuler(MouseEvent event) {
    	
    	try {
			Test.window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../Fxml/ModifyFolder.fxml"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void changeAttribut(MouseEvent event) {
    	
    		if(event.getSource() == nomButton){
    			//string
    			ChangeStringAlert.desplay("Nom", "changer le nom");
    			
    		}
    		else if(event.getSource() == prenomButton) {
    			//string
    			ChangeStringAlert.desplay("Prenom", "changer le prenom");
    			
    		}else if (event.getSource() == codCinButton) {
    			//string
    			ChangeStringAlert.desplay("CIN", "changer le CIN");
    		
    		}else if(event.getSource() == provinceButton) {
    			//string
    			ChangeStringAlert.desplay("Province", "changer le provine");
    			
    		}else if(event.getSource() == communeButton) {
    			//string
    			ChangeStringAlert.desplay("Commune", "changer la commune");
    			
    		}else if(event.getSource() == douarButton) {
    			//string
    			ChangeStringAlert.desplay("Douar", "Changer le douar");
    			
    		}else if(event.getSource() == attestationPocessionImmobilierFileButton) {
    			//file
    			ChangeFileAlert.desplay("Changer l'attestation de pocession de l'immobilier");
    			
    		}else if(event.getSource() == localisationImmobilierButton) {
    			//string
    			ChangeStringAlert.desplay("Localisation de l'immobilier", "changer la localisation de l'immobilier");
    			
    		}else if(event.getSource() == demandeCreusementFileButton) {
    			//file
    			ChangeFileAlert.desplay("Changer la demande");
    			
    		}else if(event.getSource() == typeDemandeButton) {
    			//choice
    			String items[] =  {"forage", "pompage"};
    			ChangeChoiceAlert.desplay("changer le type de demande", items, "pompage");
    			
    		}else if(event.getSource() == cinFileButton) {
    			//file
    			ChangeFileAlert.desplay("Changer la CIN");
    			
    		}else if(event.getSource() == localisationPointEauButton) {
    			//string
    			ChangeStringAlert.desplay("Localistaion du point d'eau", "changer la localistaion du point d'eau");
    			
    		}else if(event.getSource() == planEauButton) {
    			//file
    			ChangeFileAlert.desplay("Changer le plan d'eau");
    			
    		}else if(event.getSource() == rabatementButton) {
    			//float
    			ChangeNumberAlert.desplay("Debit", "changer le debit");
    			
    		}else if(event.getSource() == dateDepotDossierButton) {
    			//date
    			ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));
    			
    		}else if(event.getSource() == dateDenvoiAlabhouerEljaidaButton) {
    			//date
    			ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));
    			
    		}else if(event.getSource() == dateDebutEnquetePublicButton) {
    			//date
    			ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));
    			
    		}else if(event.getSource() == dateFinEnquetePublicButton) {
    			//date
    			ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));
    			
    		}else if(event.getSource() == dateSignaturPVparCEPButton) {
    			//date
    			ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));
    			
    		}else if(event.getSource() == AvisDeCEPButton) {
    			//choice
    			String items[] =  {"pas encor decide", "oui", "non"};
    			ChangeChoiceAlert.desplay("changer l'Avis de CEP", items, "pas encor decide");
    			
    		}else if(event.getSource() == dateEnvoitPvAbhoerEljadidaButton) {
    			//date
    			ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));
    			
    		}else if(event.getSource() == AvisAbhoerButton) {
    			//choice
    			String items[] =  {"pas encor decide", "oui", "non"};
    			ChangeChoiceAlert.desplay("changer l'Avis d'ABOHER", items, "pas encor decide");
    			
    		}else if(event.getSource() == ProfondeurButton) {
    			//float
    			ChangeNumberAlert.desplay("Pofondeur", "changer le pofondeur");
    			
    		}else if(event.getSource() == debitButton) {
    			//float
    			ChangeNumberAlert.desplay("Debit", "changer le debit");
    			
    		}else if(event.getSource() == autorisationButton) {
    			//choice
    			String items[] =  {"pas encor decide", "oui", "non"};
    			ChangeChoiceAlert.desplay("changer l'autoriation", items, "pas encor decide");
    			
    		}
    		
    }

    @FXML
    void enregistrer(MouseEvent event) {
    	ChangeStringAlert.desplay("Nom", "title");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}

