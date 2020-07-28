package Controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;

import Classes.ChangeChoiceAlert;
import Classes.ChangeDateAlert;
import Classes.ChangeFileAlert;
import Classes.ChangeNumberAlert;
import Classes.ChangeStringAlert;
import Classes.DossierForDownload;
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

public class modifierInfoDuDossierController implements Initializable{

	private DossierForDownload dossier = new DossierForDownload(); 
	
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
    			
    			
    			
    			File result = ChangeFileAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0635\u0648\u0631\u0629 \u0628\u0637\u0627\u0642\u0629 \u0627\u0644\u062a\u0639\u0631\u064a\u0641 \u0627\u0644\u0648\u0637\u0646\u064a\u0629", dossier.getCin() + "CIN.pdf");
    			if(result != null){
    				dossier.setCinFile(fileToBlob(result));
    				carteCinPathLabel.setText(result.getPath());
    			}
    			
    		}else if(event.getSource() == demandeCreusementFileButton) {
    			//file
    			File result = ChangeFileAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0645\u0644\u0641 \u0627\u0644\u0637\u0644\u0628", dossier.getCin() + "demandeFile.pdf");
    			System.out.println(result);
    			
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
    			File result = ChangeFileAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0634\u0647\u0627\u062f\u0629 \u0645\u0644\u0643\u064a\u0629 \u0627\u0644\u0639\u0642\u0627\u0631", dossier.getCin() + "attestation_Pocession_Immobilier.pdf");
    			
    			if(result != null){
    				dossier.setAttestationDePocession(fileToBlob(result));
    				attestationPoscessionImmobilierLabel.setText(result.getPath());
    			}
    			
    		}else if(event.getSource() == planImmobilierFileButton) {
    			//file
    			File result = ChangeFileAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0635\u0645\u064a\u0645 \u0627\u0644\u0639\u0642\u0627\u0631", dossier.getCin() + "plan_Immobilier.pdf");
    			
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
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0625\u064a\u062f\u0627\u0639 \u0627\u0644\u0645\u0644\u0641", dossier.getDateDepotDossier());
    			
    			dossier.setDateDepotDossier(result);
    			DateDepotDossierLabel.setText(result.toString());
    			
    			
    		}else if(event.getSource() == dateDenvoiAlabhouerEljaidaButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0625\u0631\u0633\u0627\u0644 \u0627\u0644\u0645\u0644\u0641 \u0625\u0644\u0649 \u0645\u0646\u062f\u0648\u0628\u064a\u0629 \u0648\u0643\u0627\u0644\u0629 \u0627\u0644\u062d\u0648\u0636 \u0627\u0644\u0645\u0627\u0626\u064a \u0644\u0627\u0645 \u0627\u0644\u0631\u0628\u064a\u0639 \u0628\u0627\u0644\u062c\u062f\u064a\u062f\u0629", LocalDate.now());

    			dossier.setDateEnvoiA_LABHOER(result);
    			dateDenvoiAlabhouerEljaidaLabel.setText(result.toString());
    			
    		}else if(event.getSource() == dateDebutEnquetePublicButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0628\u062f\u0627\u064a\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a", LocalDate.now());

    			dossier.setDateDebutde_EP(result);
    			dateDebutEnquetePublicLabel.setText(result.toString());
    			
    		}else if(event.getSource() == dateFinEnquetePublicButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0646\u0647\u0627\u064a\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a", LocalDate.now());

    			dossier.setDateFin_EP(result);
    			dateFinEnquetePublicLabel.setText(result.toString());
    			
    		}else if(event.getSource() == dateSignaturPVparCEPButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0627\u0645\u0636\u0627\u0621 \u0627\u0644\u0645\u062d\u0636\u0631 \u0645\u0646 \u0637\u0631\u0641 \u0644\u062c\u0646\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a", LocalDate.now());

    			dossier.setDateSignateureDuPv(result);
    			dateSignaturPVparCEPLabel.setText(result.toString());
    			
    		}else if(event.getSource() == AvisDeCEPButton) {
    			//choice
    			String items[] =  {"\u0644\u0645 \u064a\u0642\u0631\u0631 \u0628\u0639\u062f", "\u0646\u0639\u0645", "\u0644\u0627"};
    			String result = ChangeChoiceAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0631\u0623\u064a \u0644\u062c\u0646\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a", items, dossier.getAvisDe_CEP());
    			
    			dossier.setAvisDe_CEP(result);

    			AvisDeCEPLabel.setText(result);
    			
    		}else if(event.getSource() == dateEnvoitPvAbhoerEljadidaButton) {
    			//date
    			LocalDate result = ChangeDateAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u062a\u0627\u0631\u064a\u062e \u0625\u0631\u0633\u0627\u0644 \u0627\u0644\u0645\u062d\u0636\u0631 \u0625\u0644\u0649 \u0645\u0646\u062f\u0648\u0628\u064a\u0629 \u0648\u0643\u0627\u0644\u0629 \u0627\u0644\u062d\u0648\u0636 \u0627\u0644\u0645\u0627\u0626\u064a \u0644\u0627\u0645 \u0627\u0644\u0631\u0628\u064a\u0639 \u0628\u0627\u0644\u062c\u062f\u064a\u062f\u0629", LocalDate.now());

    			dossier.setDateEnvoiDuPVa_LABHOER(result);
    			dateEnvoitPvAbhoerEljadidaLabel.setText(result.toString());
    			
    		}else if(event.getSource() == AvisAbhoerButton) {
    			//choice
    			String items[] =  {"\u0644\u0645 \u064a\u0642\u0631\u0631 \u0628\u0639\u062f", "\u0646\u0639\u0645", "\u0644\u0627"};
    			String result = ChangeChoiceAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0631\u0623\u064a \u0648\u0643\u0627\u0644\u0629 \u0627\u0644\u062d\u0648\u0636 \u0627\u0644\u0645\u0627\u0626\u064a \u0644\u0623\u0645 \u0627\u0644\u0631\u0628\u064a\u0639", items, dossier.getAvisABHOER());

    			dossier.setAvisABHOER(result);
    			AvisAbhoerLabel.setText(result);
    			
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
    			String items[] =  {"\u0644\u0645 \u064a\u0642\u0631\u0631 \u0628\u0639\u062f", "\u0645\u062a\u0627\u062d\u0629", "\u063a\u064a\u0631 \u0645\u062a\u0627\u062d\u0629"};
    			String result = ChangeChoiceAlert.desplay("\u062a\u063a\u064a\u064a\u0631 \u0627\u0644\u0631\u062e\u0635\u0629", items, dossier.getAutorisation());
    			
    			dossier.setAutorisation(result);
    			autorisationLabel.setText(result);
    			
    		}
    		
    }

    @FXML
    void enregistrer(MouseEvent event) {
    	ConnectionClassDossier myDataBaseFolder = new ConnectionClassDossier();
    	System.out.println(dossier);
    	int rows = myDataBaseFolder.updateDossierToDatabase(dossier);
    	
    	System.out.println("rows updated = " + rows);

    	try {
    		
    		Parent ModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/ModifyFolder2.fxml"));
			Scene ModifyFolderScene = new Scene(ModifyFolderRoot);
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene ModifyFolderScene = new Scene(ModifyFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(ModifyFolderScene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void goHomePage(MouseEvent event) {
    	
    	try {
    		
    		Parent ModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene ModifyFolderScene = new Scene(ModifyFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(ModifyFolderScene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    @FXML
    void logOut(MouseEvent event) {

    	try {
    		
    		Parent ModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/LoginStage.fxml"));
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene ModifyFolderScene = new Scene(ModifyFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(ModifyFolderScene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	
	//recieve the message from the last controler
 	 public void setMessage(int id) {

		ConnectionClassDossier myDataBaseFolder = new ConnectionClassDossier();
		dossier = myDataBaseFolder.getDossierFromDatabase(id);
		initializeTextForLabels();
		
 	 }
	
    private void initializeTextForLabels() {
    	
    	//Set text for labels
    	nomLabel.setText(dossier.getNom());
    	prenomLabel.setText(dossier.getPrenom());
    	codCinLabel.setText(dossier.getCin());
    	typeDeDemandeLabel.setText(dossier.getTypeDemande());
    	demandeDeCreusementPathLabel.setText(dossier.getCin() + "Demande_de_creusement.pdf");
    	carteCinPathLabel.setText(dossier.getCin() + "CIN.pdf");
    	DateDepotDossierLabel.setText(dossier.getDateDepotDossier().toString());
    	
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
    	
    	dateDenvoiAlabhouerEljaidaLabel.setText(dossier.getDateEnvoiA_LABHOER().toString());
    	dateDebutEnquetePublicLabel.setText(dossier.getDateDebutde_EP().toString());
    	dateFinEnquetePublicLabel.setText(dossier.getDateFin_EP().toString());
    	dateSignaturPVparCEPLabel.setText(dossier.getDateSignateureDuPv().toString());
    	AvisDeCEPLabel.setText(dossier.getAvisDe_CEP());
    	dateEnvoitPvAbhoerEljadidaLabel.setText(dossier.getDateEnvoiDuPVa_LABHOER().toString());
    	AvisAbhoerLabel.setText(dossier.getAvisABHOER());
    	autorisationLabel.setText(dossier.getAutorisation());
    	
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

