package Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;

import Classes.DossierForDownload;
import Connectivity.ConnectionClassDossier;
import alerts.ChangeChoiceAlert;
import alerts.ChangeDateAlert;
import alerts.ChangeFileAlert;
import alerts.ChangeNumberAlert;
import alerts.ChangeStringAlert;
import alerts.WarningAlert;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class modifierInfoDuDossierController implements Initializable{

	private DossierForDownload dossier = new DossierForDownload(); 
	
	Thread th = new Thread();
	

    @FXML
    private ScrollPane scrollPaneContainer;
    
	@FXML
    private Label autorisationTitleLabel;
	
	@FXML
    private Button nomButton;

    @FXML
    private Label nomLabel;

    @FXML
    private Button prenomButton;

    @FXML
    private Label prenomLabel;

    @FXML
    private Button provinceButton;

    @FXML
    private Label provinceLabel;

    @FXML
    private Button communeButton;

    @FXML
    private Label communeLabel;

    @FXML
    private Button douarButton;

    @FXML
    private Label douarLabel;

    @FXML
    private Button attestationPocessionImmobilierFileButton;

    @FXML
    private Label attestationPoscessionImmobilierLabel;

    @FXML
    private Button nomImmobilierButton;

    @FXML
    private Label nomImmobilierLabel;

    @FXML
    private Button demandeCreusementFileButton;

    @FXML
    private Label demandeDeCreusementPathLabel;

    @FXML
    private Button typeDemandeButton;

    @FXML
    private Label typeDeDemandeLabel;

    @FXML
    private Button cinFileButton;

    @FXML
    private Label carteCinPathLabel;

    @FXML
    private Button codCinButton;

    @FXML
    private Label codCinLabel;

    @FXML
    private Button localisationPointEauButton;

    @FXML
    private Label LocalisationPointEauLabel;

    @FXML
    private Button planEauButton;

    @FXML
    private Label planEauLabel;

    @FXML
    private Button dateDepotDossierButton;

    @FXML
    private Label DateDepotDossierLabel;

    @FXML
    private Button dateDenvoiAlabhouerEljaidaButton;

    @FXML
    private Label dateDenvoiAlabhouerEljaidaLabel;

    @FXML
    private Button dateDebutEnquetePublicButton;

    @FXML
    private Label dateDebutEnquetePublicLabel;

    @FXML
    private Button dateFinEnquetePublicButton;

    @FXML
    private Label dateFinEnquetePublicLabel;

    @FXML
    private Button dateSignaturPVparCEPButton;

    @FXML
    private Label dateSignaturPVparCEPLabel;

    @FXML
    private Button AvisDeCEPButton;

    @FXML
    private Label AvisDeCEPLabel;

    @FXML
    private Button dateEnvoitPvAbhoerEljadidaButton;

    @FXML
    private Label dateEnvoitPvAbhoerEljadidaLabel;

    @FXML
    private Button AvisAbhoerButton;

    @FXML
    private Label AvisAbhoerLabel;

    @FXML
    private Button ProfondeurButton;

    @FXML
    private Label profondeurLabel;

    @FXML
    private Button debitButton;

    @FXML
    private Label debitLabel;

    @FXML
    private Button autorisationButton;

    @FXML
    private Label autorisationLabel;

    @FXML
    private Button daairaButton;

    @FXML
    private Label daairaLabel;

    @FXML
    private Button quiadaButton;

    @FXML
    private Label quiadaLabel;

    @FXML
    private Button planImmobilierFileButton;

    @FXML
    private Label planImmobilierFilePathLabel;
    @FXML
    private ProgressIndicator progInd;

    @FXML
    void annuler(MouseEvent event) {
    	
    	try {

			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("../Fxml/ModifyFolder2.fxml"));
			Parent showFolderRoot = loader.load();
			
			ModifyFolder2Controller nextControler = loader.getController();
			nextControler.setMessage(0);
			
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene showFolderScene = new Scene(showFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(showFolderScene);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void changeAttribut(MouseEvent event) throws FileNotFoundException {
    	
    		if(event.getSource() == nomButton){
    			//string
    			String result = ChangeStringAlert.desplay("\u0627\u0644\u0625\u0633\u0645 \u0627\u0644\u0639\u0627\u0626\u0644\u064a", "\u062a\u063a\u064a\u064a\u0631 \u0627\u0644\u0625\u0633\u0645 \u0627\u0644\u0639\u0627\u0626\u0644\u064a");
    			
    			if(result != null){
    				
    				dossier.setNom(result);
    				nomLabel.setText(result);
    				
    			}
    			
    		}
    		else if(event.getSource() == prenomButton) {
    			//string
    			String result = ChangeStringAlert.desplay("\u0627\u0644\u0625\u0633\u0645 \u0627\u0644\u0634\u062e\u0635\u064a", "\u062a\u063a\u064a\u064a\u0631 \u0627\u0644\u0625\u0633\u0645 \u0627\u0644\u0634\u062e\u0635\u064a");
    			
    			if(result != null){
    				dossier.setPrenom(result);
    				prenomLabel.setText(result);
    			}
    			
    		}else if (event.getSource() == codCinButton) {
    			//string
    			String result = ChangeStringAlert.desplay("\u0631\u0642\u0645 \u0628\u0637\u0627\u0642\u0629 \u0627\u0644\u062a\u0639\u0631\u064a\u0641 \u0627\u0644\u0648\u0637\u0646\u064a\u0629", "\u062a\u063a\u064a\u064a\u0631 \u0631\u0642\u0645 \u0628\u0637\u0627\u0642\u0629 \u0627\u0644\u062a\u0639\u0631\u064a\u0641 \u0627\u0644\u0648\u0637\u0646\u064a\u0629");
    			
    			if(result != null){
    				dossier.setCin(result);
    				codCinLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == typeDemandeButton) {
    			//choice
    			String items[] =  {"\u0637\u0644\u0628 \u062d\u0641\u0631 \u062b\u0642\u0628 \u0645\u0627\u0626\u064a", "\u0637\u0644\u0628 \u062c\u0644\u0628 \u0627\u0644\u0645\u0627\u0621"};
    			String result = ChangeChoiceAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0646\u0648\u0639 \u0627\u0644\u0637\u0644\u0628", items, dossier.getTypeDemande());
    			
    			dossier.setTypeDemande(result);
    			typeDeDemandeLabel.setText(result);
    			
    		}else if(event.getSource() == cinFileButton) {
    			//file
    			
    			
    			
    			File result = ChangeFileAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0635\u0648\u0631\u0629 \u0628\u0637\u0627\u0642\u0629 \u0627\u0644\u062a\u0639\u0631\u064a\u0641 \u0627\u0644\u0648\u0637\u0646\u064a\u0629", "CIN.pdf");
    			if(result != null){
    				dossier.setCinFile(fileToBlob(result));
    				carteCinPathLabel.setText(result.getPath());
    			}
    			
    		}else if(event.getSource() == demandeCreusementFileButton) {
    			//file
    			File result = ChangeFileAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0645\u0644\u0641 \u0627\u0644\u0637\u0644\u0628", "demandeFile.pdf");
    			
    			if(result != null){
    				dossier.setDemandeFile(fileToBlob(result));
    				demandeDeCreusementPathLabel.setText(result.getPath());
    			}
    			
    		}else if(event.getSource() == nomImmobilierButton) {
    			//string
    			String result = ChangeStringAlert.desplay("\u0627\u0633\u0645 \u0627\u0644\u0639\u0642\u0627\u0631", "\u062a\u063a\u064a\u064a\u0631 \u0627\u0633\u0645 \u0627\u0644\u0639\u0642\u0627\u0631");

    			if(result != null){
    				dossier.setNomImmobilier(result);
    				nomImmobilierLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == attestationPocessionImmobilierFileButton) {
    			//file
    			File result = ChangeFileAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0634\u0647\u0627\u062f\u0629 \u0645\u0644\u0643\u064a\u0629 \u0627\u0644\u0639\u0642\u0627\u0631", "attestation_Pocession_Immobilier.pdf");
    			
    			if(result != null){
    				dossier.setAttestationDePocession(fileToBlob(result));
    				attestationPoscessionImmobilierLabel.setText(result.getPath());
    			}
    			
    		}else if(event.getSource() == planImmobilierFileButton) {
    			//file
    			File result = ChangeFileAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0635\u0645\u064a\u0645 \u0627\u0644\u0639\u0642\u0627\u0631", "plan_Immobilier.pdf");
    			
    			if(result != null){
    				dossier.setPlanImmobilier(fileToBlob(result));
    				planImmobilierFilePathLabel.setText(result.getPath());
    			}
    			
    		}else if(event.getSource() == quiadaButton) {
    			//string
    			String result = ChangeStringAlert.desplay("\u0627\u0644\u0642\u064a\u0627\u062f\u0629", "\u062a\u063a\u064a\u064a\u0631 \u0627\u0644\u0642\u064a\u0627\u062f\u0629");

    			if(result != null){
    				dossier.setQuiada(result);
    				quiadaLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == daairaButton) {
    			//string
    			String result = ChangeStringAlert.desplay("\u0627\u0644\u062f\u0627\u0626\u0631\u0629", "\u062a\u063a\u064a\u064a\u0631 \u0627\u0644\u062f\u0627\u0626\u0631\u0629");

    			if(result != null){
    				dossier.setDaaira(result);
    				daairaLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == provinceButton) {
    			//string
    			String result = ChangeStringAlert.desplay("\u0627\u0644\u0625\u0642\u0644\u064a\u0645", "\u062a\u063a\u064a\u064a\u0631 \u0627\u0644\u0625\u0642\u0644\u064a\u0645");

    			if(result != null){
    				dossier.setProvince(result);
    				provinceLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == communeButton) {
    			//string
    			String result = ChangeStringAlert.desplay("\u0627\u0644\u062c\u0645\u0627\u0639\u0629", "\u062a\u063a\u064a\u064a\u0631 \u0627\u0644\u062c\u0645\u0627\u0639\u0629");

    			if(result != null){
    				dossier.setCommune(result);
    				communeLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == douarButton) {
    			//string
    			String result = ChangeStringAlert.desplay("\u0627\u0644\u062f\u0648\u0627\u0631", "\u062a\u063a\u064a\u064a\u0631 \u0627\u0644\u062f\u0648\u0627\u0631");

    			if(result != null){
    				dossier.setDouar(result);
    				douarLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == localisationPointEauButton) {
    			//string
    			String result = ChangeStringAlert.desplay("\u0625\u062d\u062f\u0627\u062b\u064a\u0627\u062a \u0646\u0642\u0637\u0629 \u0627\u0644\u0645\u0627\u0621", "\u062a\u063a\u064a\u064a\u0631 \u0625\u062d\u062f\u0627\u062b\u064a\u0627\u062a \u0646\u0642\u0637\u0629 \u0627\u0644\u0645\u0627\u0621");

    			if(result != null){
    				dossier.setLocalisationPoint(result);
    				LocalisationPointEauLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == planEauButton) {
    			//float
    			float result = ChangeNumberAlert.desplay("\u0645\u0633\u062a\u0648\u0649 \u0627\u0644\u0645\u0627\u0621", "\u062a\u063a\u064a\u064a\u0631 \u0645\u0633\u062a\u0648\u0649 \u0627\u0644\u0645\u0627\u0621");
    			if(result != 0){
    				dossier.setPlanEau(result);
    				planEauLabel.setText(Float.toString(result));
    			}
    		}else if(event.getSource() == dateDepotDossierButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0625\u064a\u062f\u0627\u0639 \u0627\u0644\u0645\u0644\u0641", Date.valueOf(dossier.getDateDepotDossier()).toLocalDate());
    			
    			if(result != null) {
    				dossier.setDateDepotDossier(result.toString());
    				DateDepotDossierLabel.setText(result.toString());
    			}
    			
    			
    		}else if(event.getSource() == dateDenvoiAlabhouerEljaidaButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0625\u0631\u0633\u0627\u0644 \u0627\u0644\u0645\u0644\u0641 \u0625\u0644\u0649 \u0645\u0646\u062f\u0648\u0628\u064a\u0629 \u0648\u0643\u0627\u0644\u0629 \u0627\u0644\u062d\u0648\u0636 \u0627\u0644\u0645\u0627\u0626\u064a \u0644\u0627\u0645 \u0627\u0644\u0631\u0628\u064a\u0639 \u0628\u0627\u0644\u062c\u062f\u064a\u062f\u0629", LocalDate.now());

    			if(result != null) {
    				dossier.setDateEnvoiA_LABHOER(result.toString());
    				dateDenvoiAlabhouerEljaidaLabel.setText(result.toString());
    				
    				//set the next button to be enabled 
    				dateDebutEnquetePublicButton.setDisable(false);
    			}
    			
    		}else if(event.getSource() == dateDebutEnquetePublicButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0628\u062f\u0627\u064a\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a", LocalDate.now());

    			if(result != null) {
    				dossier.setDateDebutde_EP(result.toString());
    				dateDebutEnquetePublicLabel.setText(result.toString());

    				//set the next button to be enabled 
    				dateFinEnquetePublicButton.setDisable(false);
    			}
    			
    		}else if(event.getSource() == dateFinEnquetePublicButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0646\u0647\u0627\u064a\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a", LocalDate.now());
    			
    			if(result != null) {
    				dossier.setDateFin_EP(result.toString());
    				dateFinEnquetePublicLabel.setText(result.toString());

    				//set the next button to be enabled
    				dateSignaturPVparCEPButton.setDisable(false);
    			}
    			
    		}else if(event.getSource() == dateSignaturPVparCEPButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0627\u0645\u0636\u0627\u0621 \u0627\u0644\u0645\u062d\u0636\u0631 \u0645\u0646 \u0637\u0631\u0641 \u0644\u062c\u0646\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a", LocalDate.now());
    			
    			if(result != null) {
    				dossier.setDateSignateureDuPv(result.toString());
    				dateSignaturPVparCEPLabel.setText(result.toString());

    				//set the next button to be enabled
    				AvisDeCEPButton.setDisable(false);
    			}
    			
    		}else if(event.getSource() == AvisDeCEPButton) {
    			//choice
    			String items[] =  {"\u0644\u0627 \u0634\u064a\u0621", "\u0628\u0627\u0644\u0645\u0648\u0627\u0641\u0642\u0629", "\u0628\u0627\u0644\u0631\u0641\u0636"};
    			String result = ChangeChoiceAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0631\u0623\u064a \u0644\u062c\u0646\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a", items, dossier.getAvisDe_CEP());

    			if(result != null) {
    				
    				if(result.equals("\u0628\u0627\u0644\u0645\u0648\u0627\u0641\u0642\u0629"))  
    					dateEnvoitPvAbhoerEljadidaButton.setDisable(false);      				//set the next button to be enabled
    				
    				else if(result.equals("\u0644\u0627 \u0634\u064a\u0621") || result.equals("\u0628\u0627\u0644\u0631\u0641\u0636")){					
    					dateEnvoitPvAbhoerEljadidaButton.setDisable(true);						//set the next button to be enabled
    					dossier.setDateEnvoiDuPVa_LABHOER("XXXX-XX-XX");
        				dateEnvoitPvAbhoerEljadidaLabel.setText("XXXX-XX-XX");
    					dossier.setAvisABHOER("\u0644\u0627 \u0634\u064a\u0621");
        				AvisAbhoerLabel.setText("\u0644\u0627 \u0634\u064a\u0621");
        				AvisAbhoerButton.setDisable(true);
    					dossier.setAutorisation("\u0644\u0627 \u0634\u064a\u0621");
    		    		autorisationTitleLabel.setVisible(false);
    		    		autorisationLabel.setVisible(false);
    		    		autorisationButton.setVisible(false);
    					
    				}

    				dossier.setAvisDe_CEP(result);
    				AvisDeCEPLabel.setText(result);

    			}
    			
    		}else if(event.getSource() == dateEnvoitPvAbhoerEljadidaButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0625\u0631\u0633\u0627\u0644 \u0627\u0644\u0645\u062d\u0636\u0631 \u0625\u0644\u0649 \u0645\u0646\u062f\u0648\u0628\u064a\u0629 \u0648\u0643\u0627\u0644\u0629 \u0627\u0644\u062d\u0648\u0636 \u0627\u0644\u0645\u0627\u0626\u064a \u0644\u0627\u0645 \u0627\u0644\u0631\u0628\u064a\u0639 \u0628\u0627\u0644\u062c\u062f\u064a\u062f\u0629", LocalDate.now());
    			
    			if(result != null) {
    				dossier.setDateEnvoiDuPVa_LABHOER(result.toString());
    				dateEnvoitPvAbhoerEljadidaLabel.setText(result.toString());

    				//set the next button to be enabled
    				AvisAbhoerButton.setDisable(false);
    			}
    			
    		}else if(event.getSource() == AvisAbhoerButton) {
    			//choice
    			String items[] =  {"\u0644\u0627 \u0634\u064a\u0621", "\u0628\u0627\u0644\u0645\u0648\u0627\u0641\u0642\u0629", "\u0628\u0627\u0644\u0631\u0641\u0636"};
    			String result = ChangeChoiceAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0631\u0623\u064a \u0648\u0643\u0627\u0644\u0629 \u0627\u0644\u062d\u0648\u0636 \u0627\u0644\u0645\u0627\u0626\u064a \u0644\u0623\u0645 \u0627\u0644\u0631\u0628\u064a\u0639", items, dossier.getAvisABHOER());
    			
    			if(result != null) {
    				dossier.setAvisABHOER(result);
    				AvisAbhoerLabel.setText(result);
    				
    				//set the next line visible 
    				if(dossier.getAvisDe_CEP().equals("\u0628\u0627\u0644\u0645\u0648\u0627\u0641\u0642\u0629") && dossier.getAvisABHOER().equals("\u0628\u0627\u0644\u0645\u0648\u0627\u0641\u0642\u0629")) {

    		    		autorisationTitleLabel.setVisible(true);
    		    		autorisationLabel.setVisible(true);
    		    		autorisationButton.setVisible(true);
    		    		autorisationLabel.setText(dossier.getAutorisation());
    		    		
    		    	}else if(result.equals("\u0644\u0627 \u0634\u064a\u0621") || result.equals("\u0628\u0627\u0644\u0631\u0641\u0636")){					
    					dossier.setAutorisation("\u0644\u0627 \u0634\u064a\u0621");
    		    		autorisationTitleLabel.setVisible(false);
    		    		autorisationLabel.setVisible(false);
    		    		autorisationButton.setVisible(false);
    				}
    				
    			}
    			
    		}else if(event.getSource() == ProfondeurButton) {
    			//float
    			float result = ChangeNumberAlert.desplay("\u0627\u0644\u0639\u0645\u0642", "\u062a\u063a\u064a\u064a\u0631 \u0627\u0644\u0639\u0645\u0642");

    			if(result != 0) {
    				dossier.setProfondeur(result);
    				profondeurLabel.setText(Float.toString(result));
    			}
    			
    		}else if(event.getSource() == debitButton) {
    			//float
    			float result = ChangeNumberAlert.desplay("\u0627\u0644\u0635\u0628\u064a\u0628", "\u062a\u063a\u064a\u064a\u0631 \u0627\u0644\u0635\u0628\u064a\u0628");

    			if(result != 0) {
    				dossier.setDebit(result);
    				debitLabel.setText(Float.toString(result));
    			}
    			
    		}else if(event.getSource() == autorisationButton) {
    			//choice
    			String items[] =  {"\u0644\u0627 \u0634\u064a\u0621", "\u0645\u062a\u0627\u062d\u0629", "\u063a\u064a\u0631 \u0645\u062a\u0627\u062d\u0629"};
    			String result = ChangeChoiceAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0627\u0644\u0631\u062e\u0635\u0629", items, dossier.getAutorisation());
    			
    			if(result != null) {
    				dossier.setAutorisation(result);
    				autorisationLabel.setText(result);
    			}
    			
    		}
    		
    }

    @FXML
    void enregistrer(MouseEvent event) {

		scrollPaneContainer.setDisable(true);
    	progInd.setVisible(true);
    	
    	Task<Parent> saveTask = new Task<Parent>() {

			@Override
			protected Parent call() throws Exception {

				/* connect to the local database */
		    	ConnectionClassDossier myDataBaseFolder;
		    	int rows[] = {0, 0};
		    	try {
					
					myDataBaseFolder = new ConnectionClassDossier();
			    	rows = myDataBaseFolder.updateDossierToDatabase(dossier);
			        
				} catch (ClassNotFoundException | SQLException e1) {
					//
				}
		    	
		    	if(rows[0] == 0) {
					return null;
				}
		    	
		    	Parent showFolderRoot = null;
		    	try {

					FXMLLoader loader= new FXMLLoader();
					loader.setLocation(getClass().getResource("../Fxml/ModifyFolder2.fxml"));
					showFolderRoot = loader.load();

					ModifyFolder2Controller nextControler = loader.getController();
					nextControler.setMessage(0);
					
					return showFolderRoot;

				} catch (IOException e) {
					//
				}
				
				return showFolderRoot;
			}
    		
    	};
    	
    	saveTask.setOnSucceeded(e -> {
    		Parent showFolderRoot = saveTask.getValue();
    		if( showFolderRoot != null) {

				Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Scene showFolderScene = new Scene(showFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
				primaryStage.setScene(showFolderScene);
				
    		}else {

				progInd.setVisible(false);
				scrollPaneContainer.setDisable(false);
				String title = "\u0627\u0646\u062a\u0628\u0627\u0647"; 
				String message1 = "\u0644\u0642\u062f \u062d\u062f\u062b \u062e\u0637\u0623 \u0645\u0627!";
				String message2 = "\u0627\u0644\u0645\u0631\u062c\u0648 \u0627\u0644\u062a\u062d\u0642\u0642 \u0645\u0646 \u0627\u0644\u0625\u062a\u0635\u0627\u0644 \u0628\u0627\u0644\u0625\u0646\u062a\u0631\u0646\u062a \u0648 \u0625\u0639\u0627\u062f\u0629 \u0627\u0644\u0645\u062d\u0627\u0648\u0644\u0629 \u0645\u0631\u0629 \u0623\u062e\u0631\u0649.";
				String titleButton = "\u062d\u0633\u0646\u0627";
				WarningAlert.desplay(title, message1,  message2, titleButton);
				
    			
    		}
    	});
    	 
    	th = new Thread(saveTask);
    	th.setDaemon(false);
    	th.start();
    	
    }


    @FXML
    void goHomePage(MouseEvent event) {
    	
    	if(!th.isAlive()) {
    		try {
        		
        		Parent ModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
    			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    			Scene ModifyFolderScene = new Scene(ModifyFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
    			primaryStage.setScene(ModifyFolderScene);
    			
    		} catch (IOException e) {
    			
    			e.printStackTrace();
    		}
    	}
    }

    @FXML
    void logOut(MouseEvent event) {

    	if(!th.isAlive()) {
    		try {
        		
        		Parent ModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/LoginStage.fxml"));
    			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    			Scene ModifyFolderScene = new Scene(ModifyFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
    			primaryStage.setScene(ModifyFolderScene);
    			
    		} catch (IOException e) {
    			
    			e.printStackTrace();
    		}
    	}
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		autorisationTitleLabel.setVisible(false);
		autorisationLabel.setVisible(false);
		autorisationButton.setVisible(false);
		
	}
	
	//recieve the message from the last controler
 	 public int setMessage(int id) {

		ConnectionClassDossier myDataBaseFolder = null;
		try {
			
			myDataBaseFolder = new ConnectionClassDossier();

			
		} catch (ClassNotFoundException | SQLException e) {
			String title = "\u0627\u0646\u062a\u0628\u0627\u0647"; 
			String message1 = "\u0644\u0642\u062f \u062d\u062f\u062b \u062e\u0637\u0623 \u0645\u0627!";
			String message2 = "\u0627\u0644\u0645\u0631\u062c\u0648 \u0627\u0644\u062a\u062d\u0642\u0642 \u0645\u0646 \u0627\u0644\u0625\u062a\u0635\u0627\u0644 \u0628\u0627\u0644\u0625\u0646\u062a\u0631\u0646\u062a \u0648 \u0625\u0639\u0627\u062f\u0629 \u0627\u0644\u0645\u062d\u0627\u0648\u0644\u0629 \u0645\u0631\u0629 \u0623\u062e\u0631\u0649.";
			String titleButton = "\u062d\u0633\u0646\u0627";
			WarningAlert.desplay(title, message1,  message2, titleButton);
			return 0;
		}
		dossier = myDataBaseFolder.getDossierFromDatabase(id);
		initializeTextForLabels();
		
		if(!dossier.getDateEnvoiA_LABHOER().equals("")) {
			dateDebutEnquetePublicButton.setDisable(false);
		}

		if(!dossier.getDateDebutde_EP().equals("")) {
			dateFinEnquetePublicButton.setDisable(false);
		}

		if(!dossier.getDateFin_EP().equals("")) {
			dateSignaturPVparCEPButton.setDisable(false);
		}

		if(!dossier.getDateSignateureDuPv().equals("")) {
			AvisDeCEPButton.setDisable(false);
		}

		if(dossier.getAvisDe_CEP().equals("\u0628\u0627\u0644\u0645\u0648\u0627\u0641\u0642\u0629")) {
			dateEnvoitPvAbhoerEljadidaButton.setDisable(false);
		}

		if(!dossier.getDateEnvoiDuPVa_LABHOER().equals("")) {
			AvisAbhoerButton.setDisable(false);
		}
		
		return 1;
 	 }
	
    private void initializeTextForLabels() {
    	
    	//Set text for labels
    	nomLabel.setText(dossier.getNom());
    	prenomLabel.setText(dossier.getPrenom());
    	codCinLabel.setText(dossier.getCin());
    	typeDeDemandeLabel.setText(dossier.getTypeDemande());
    	demandeDeCreusementPathLabel.setText(dossier.getCin() + "Demande_de_creusement.pdf");
    	carteCinPathLabel.setText(dossier.getCin() + "CIN.pdf");
    	DateDepotDossierLabel.setText(dossier.getDateDepotDossier());
    	
    	nomImmobilierLabel.setText(dossier.getNomImmobilier());
    	attestationPoscessionImmobilierLabel.setText(dossier.getCin() + "Attesteation_de_pocession.pdf");
    	planImmobilierFilePathLabel.setText(dossier.getCin() + "Plan_d_immobilier.pdf");
    	quiadaLabel.setText(dossier.getQuiada());
    	daairaLabel.setText(dossier.getDaaira());
    	provinceLabel.setText(dossier.getProvince());
    	communeLabel.setText(dossier.getCommune());
    	douarLabel.setText(dossier.getDouar());
    	
    	LocalisationPointEauLabel.setText(dossier.getLocalisationPoint());
    	profondeurLabel.setText(Float.toString(dossier.getProfondeur()));
    	debitLabel.setText(Float.toString(dossier.getDebit()));
    	planEauLabel.setText(Float.toString(dossier.getPlanEau()));
    	
    	dateDenvoiAlabhouerEljaidaLabel.setText(dossier.getDateEnvoiA_LABHOER().contentEquals("") ? "XXXX-XX-XX" : dossier.getDateEnvoiA_LABHOER());  //if datedepot = date envoi we dont display anything, same for others below
    	dateDebutEnquetePublicLabel.setText(dossier.getDateDebutde_EP().contentEquals("") ? "XXXX-XX-XX" : dossier.getDateDebutde_EP());
    	dateFinEnquetePublicLabel.setText(dossier.getDateFin_EP().contentEquals("") ? "XXXX-XX-XX" : dossier.getDateFin_EP());
    	dateSignaturPVparCEPLabel.setText(dossier.getDateSignateureDuPv().contentEquals("") ? "XXXX-XX-XX" : dossier.getDateSignateureDuPv());
    	AvisDeCEPLabel.setText(dossier.getAvisDe_CEP());
    	dateEnvoitPvAbhoerEljadidaLabel.setText(dossier.getDateEnvoiDuPVa_LABHOER().contentEquals("") ? "XXXX-XX-XX" : dossier.getDateEnvoiDuPVa_LABHOER());
    	AvisAbhoerLabel.setText(dossier.getAvisABHOER());
    	
    	if(dossier.getAvisDe_CEP().equals("\u0628\u0627\u0644\u0645\u0648\u0627\u0641\u0642\u0629") && dossier.getAvisABHOER().equals("\u0628\u0627\u0644\u0645\u0648\u0627\u0641\u0642\u0629")) {

    		autorisationTitleLabel.setVisible(true);
    		autorisationLabel.setVisible(true);
    		autorisationButton.setVisible(true);
    		autorisationLabel.setText(dossier.getAutorisation());
    		
    	}
    	
    }
    
    
    //this method takes a file as argument and return it as blob
    private Blob fileToBlob(File file) {
    	
    	Blob blob = null;
		try {
			
			byte[] content = IOUtils.toByteArray(new FileInputStream(file));
	    	blob = new SerialBlob(content);
	    	
		} catch (IOException e) {

			e.printStackTrace();
			
		} catch (SerialException e) {

			e.printStackTrace();
			
		} catch (SQLException e) {

			e.printStackTrace();
		
		}
    	
    	return blob;
    	
    }
    

}

