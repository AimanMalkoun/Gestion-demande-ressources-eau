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
import Classes.Dossier;
import Connectivity.ConnectionClassDossier;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import matrouhTest.Test;

public class modifierInfoDuDossierController implements Initializable{

	private Dossier dossier = new Dossier(); 

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
    private Label demandeDeCreusementPathLabel;

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
    		
    		Parent ModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/ModifyFolder.fxml"));
			Scene ModifyFolderScene = new Scene(ModifyFolderRoot);
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(ModifyFolderScene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void changeAttribut(MouseEvent event) {
    	
    		if(event.getSource() == nomButton){
    			//string
    			String result = ChangeStringAlert.desplay("Nom", "changer le nom");
    			
    			if(result != null){
    				
    				dossier.getDemandeur().setNom(result);
    				nomLabel.setText(result);
    				
    			}
    			
    		}
    		else if(event.getSource() == prenomButton) {
    			//string
    			String result = ChangeStringAlert.desplay("Prenom", "changer le prenom");
    			
    			if(result != null){
    				dossier.getDemandeur().setPrenom(result);
    				prenomLabel.setText(result);
    			}
    			
    		}else if (event.getSource() == codCinButton) {
    			//string
    			String result = ChangeStringAlert.desplay("CIN", "changer le CIN");
    			
    			if(result != null){
    				dossier.getDemandeur().setCin(result);
    				codCinLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == provinceButton) {
    			//string
    			String result = ChangeStringAlert.desplay("Province", "changer le provine");

    			if(result != null){
    				dossier.getImmobilier().setProvince(result);
    				provinceLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == communeButton) {
    			//string
    			String result = ChangeStringAlert.desplay("Commune", "changer la commune");

    			if(result != null){
    				dossier.getImmobilier().setCommune(result);
    				communeLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == douarButton) {
    			//string
    			String result = ChangeStringAlert.desplay("Douar", "Changer le douar");

    			if(result != null){
    				dossier.getImmobilier().setDouar(result);
    				douarLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == attestationPocessionImmobilierFileButton) {
    			//file
    			File result = ChangeFileAlert.desplay("Changer l'attestation de pocession de l'immobilier");
    			
    			if(result != null){
    				dossier.getImmobilier().setAttestationDePocession(result);
    				attestationPoscessionLocalisationImmobilierLabel.setText(result.getPath());
    			}
    			
    		}else if(event.getSource() == localisationImmobilierButton) {
    			//string
    			String result = ChangeStringAlert.desplay("Localisation de l'immobilier", "changer la localisation de l'immobilier");

    			if(result != null){
    				dossier.getImmobilier().setLocalisation(result);
    				localisationImmobilierLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == demandeCreusementFileButton) {
    			//file
    			File result = ChangeFileAlert.desplay("Changer la demande");
    			
    			if(result != null){
    				dossier.getDemandeur().setDemandeFile(result);
    				demandeDeCreusementPathLabel.setText(result.getPath());
    			}
    			
    		}else if(event.getSource() == typeDemandeButton) {
    			//choice
    			String items[] =  {"forage", "pompage"};
    			String result = ChangeChoiceAlert.desplay("changer le type de demande", items, "pompage");
    			
    			dossier.getDemandeur().setTypeDemande(result);
    			typeDeDemandeLabel.setText(result);
    			
    		}else if(event.getSource() == cinFileButton) {
    			//file
    			File result = ChangeFileAlert.desplay("Changer la CIN");
    			if(result != null){
    				dossier.getDemandeur().setCinFile(result);
    				carteCinPathLabel.setText(result.getPath());
    			}
    		}else if(event.getSource() == localisationPointEauButton) {
    			//string
    			String result = ChangeStringAlert.desplay("Localistaion du point d'eau", "changer la localistaion du point d'eau");

    			if(result != null){
    				dossier.getPointDeau().setLocalisationPoint(result);
    				LocalisationPointEauLabel.setText(result);
    			}
    			
    		}else if(event.getSource() == planEauButton) {
    			//file
    			File result = ChangeFileAlert.desplay("Changer le plan d'eau");
    			if(result != null){
    				dossier.getPointDeau().setPlanEau(result);
    				planEauPathLabel.setText(result.getPath());
    			}
    		}else if(event.getSource() == rabatementButton) {
    			//float
    			float result = ChangeNumberAlert.desplay("Debit", "changer le debit");
    			
    			if(result != 0) {
    				dossier.getPointDeau().setRabattement(result);
    				rabattementLabel.setText(Float.toString(result));
    			}
    			
    		}else if(event.getSource() == dateDepotDossierButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));
    			
    			dossier.getDemandeur().setDateDepotDossier(result);
    			DateDepotDossierLabel.setText(result.toString());
    			
    			
    		}else if(event.getSource() == dateDenvoiAlabhouerEljaidaButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));

    			dossier.setDateEnvoiA_LABHOER(result);
    			dateDenvoiAlabhouerEljaidaLabel.setText(result.toString());
    			
    		}else if(event.getSource() == dateDebutEnquetePublicButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));

    			dossier.setDateDebutde_EP(result);
    			dateDebutEnquetePublicLabel.setText(result.toString());
    			
    		}else if(event.getSource() == dateFinEnquetePublicButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));

    			dossier.setDateFin_EP(result);
    			dateFinEnquetePublicLabel.setText(result.toString());
    			
    		}else if(event.getSource() == dateSignaturPVparCEPButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));

    			dossier.setDateSignateureDuPv(result);
    			dateSignaturPVparCEPLabel.setText(result.toString());
    			
    		}else if(event.getSource() == AvisDeCEPButton) {
    			/*
    			 * 
    			 * 
    			 * */
    			//choice
    			String items[] =  {"pas encor decide", "oui", "non"};
    			String result = ChangeChoiceAlert.desplay("changer l'Avis de CEP", items, "pas encor decide");
    			
    			dossier.setAvisDe_CEP(false);
    			AvisDeCEPLabel.setText(result);
    			
    			/*
    			 * 
    			 * 
    			 * */
    			
    		}else if(event.getSource() == dateEnvoitPvAbhoerEljadidaButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("Changer la date du depot du dossier", LocalDate.of(2020, 12, 21));

    			dossier.setDateEnvoiDuPVa_LABHOER(result);
    			dateEnvoitPvAbhoerEljadidaLabel.setText(result.toString());
    			
    		}else if(event.getSource() == AvisAbhoerButton) {
    			/*
    			 * 
    			 * 
    			 * */
    			//choice
    			String items[] =  {"pas encor decide", "oui", "non"};
    			String result = ChangeChoiceAlert.desplay("changer l'Avis d'ABOHER", items, "pas encor decide");

    			dossier.getDemandeur().setNom(result);
    			AvisAbhoerLabel.setText(result);
    			
    			/*
    			 * 
    			 * 
    			 * */
    		}else if(event.getSource() == ProfondeurButton) {
    			//float
    			float result = ChangeNumberAlert.desplay("Pofondeur", "changer le pofondeur");

    			if(result != 0) {
    				dossier.getPointDeau().setProfondeur(result);
    				profondeurLabel.setText(Float.toString(result));
    			}
    			
    		}else if(event.getSource() == debitButton) {
    			//float
    			float result = ChangeNumberAlert.desplay("Debit", "changer le debit");

    			if(result != 0) {
    				dossier.getPointDeau().setDebit(result);
    				debitLabel.setText(Float.toString(result));
    			}
    			
    		}else if(event.getSource() == autorisationButton) {
    			/*
    			 * 
    			 * 
    			 * */
    			//choice
    			String items[] =  {"pas encor decide", "oui", "non"};
    			String result = ChangeChoiceAlert.desplay("changer l'autoriation", items, "pas encor decide");
    			
    			dossier.getDemandeur().setNom(result);
    			autorisationLabel.setText(result);
    			
    			/*
    			 * 
    			 * 
    			 * */
    		}
    		
    }

    @FXML
    void enregistrer(MouseEvent event) {
    	System.out.println(dossier);
    	ConnectionClassDossier myDataBaseFolder = new ConnectionClassDossier();
    	int rows = myDataBaseFolder.updateDossierToDatabase(dossier);
    	System.out.println("rows updated = " + rows);

    	try {
    		
    		Parent ModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/ModifyFolder.fxml"));
			Scene ModifyFolderScene = new Scene(ModifyFolderRoot);
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(ModifyFolderScene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ConnectionClassDossier myDataBaseFolder = new ConnectionClassDossier();
		dossier = myDataBaseFolder.getDossierFromDatabase(1);
		System.out.println(dossier);
		initializeTextForLabels();
		
	}
	

    private void initializeTextForLabels() {
    	
    	/**
    	 * this zone for demandeur informations
    	 **/
    	nomLabel.setText(dossier.getDemandeur().getNom());
    	prenomLabel.setText(dossier.getDemandeur().getPrenom());
    	codCinLabel.setText(dossier.getDemandeur().getCin());
    	typeDeDemandeLabel.setText(dossier.getDemandeur().getTypeDemande());
    	//demandeDeCreusementPathLabel.setText(dossier.getDemandeur().getDemandeFile().getName());
    	//carteCinPathLabel.setText(dossier.getDemandeur().getCinFile().getName());
    	DateDepotDossierLabel.setText(dossier.getDemandeur().getDateDepotDossier().toString());
    	
    	/**
    	 * this zone for immobilier informations
    	 **/
    	provinceLabel.setText(dossier.getImmobilier().getProvince());
    	communeLabel.setText(dossier.getImmobilier().getCommune());
    	douarLabel.setText(dossier.getImmobilier().getDouar());
    	//attestationPoscessionLocalisationImmobilierLabel.setText(dossier.getImmobilier().getAttestationDePocession().getName());
    	localisationImmobilierLabel.setText(dossier.getImmobilier().getLocalisation());
    	
    	/**
    	 * this zone for point d'eau informations
    	 **/
    	LocalisationPointEauLabel.setText(dossier.getPointDeau().getLocalisationPoint());
    	rabattementLabel.setText(Float.toString(dossier.getPointDeau().getRabattement()));
    	profondeurLabel.setText(Float.toString(dossier.getPointDeau().getProfondeur()));
    	debitLabel.setText(Float.toString(dossier.getPointDeau().getDebit()));
    	//planEauPathLabel.setText(dossier.getPointDeau().getPlanEau().getName());
    	
    	/**
    	 * this zone for suivi de dossier informations
    	 **/
    	dateDenvoiAlabhouerEljaidaLabel.setText(dossier.getDateEnvoiA_LABHOER().toString());
    	dateDebutEnquetePublicLabel.setText(dossier.getDateDebutde_EP().toString());
    	dateFinEnquetePublicLabel.setText(dossier.getDateFin_EP().toString());
    	dateSignaturPVparCEPLabel.setText(dossier.getDateSignateureDuPv().toString());
    	AvisDeCEPLabel.setText(Boolean.toString(dossier.getAvisDe_CEP()));
    	dateEnvoitPvAbhoerEljadidaLabel.setText(dossier.getDateEnvoiDuPVa_LABHOER().toString());
    	AvisAbhoerLabel.setText(Boolean.toString(dossier.getAvisABHOER()));
    	autorisationLabel.setText(Boolean.toString(dossier.getAutorisation()));
    	
    }
    
    

}

