package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jpedal.exception.PdfException;

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
import pdfClasses.ConvertBlobToPdf;
import pdfClasses.ShowPdf;


public class DisplayFolderController implements Initializable {

	DossierForDownload dossier;

	 @FXML
	    private Label nomLabel;

	    @FXML
	    private Label prenomLabel;

	    @FXML
	    private Label codCinLabel;

	    @FXML
	    private Button cinFileButton;

	    @FXML
	    private Label cinFileLabel;

	    @FXML
	    private Label typeDeDemandeLabel;

	    @FXML
	    private Button demandeFileButton;

	    @FXML
	    private Label demandeNameLabel;

	    @FXML
	    private Label nomImmobilierLabel;

	    @FXML
	    private Button planImmobilierFileButton;

	    @FXML
	    private Label planImmobilierFileNameLabel;

	    @FXML
	    private Button attestationFileButton;

	    @FXML
	    private Label attestationPoscessionImmobilierLabel;

	    @FXML
	    private Label quiadaLabel;

	    @FXML
	    private Label daairaLabel;

	    @FXML
	    private Label douarLabel;

	    @FXML
	    private Label communeLabel;

	    @FXML
	    private Label provinceLabel;

	    @FXML
	    private Label LocalisationPointEauLabel;

	    @FXML
	    private Label debitLabel;

	    @FXML
	    private Label profondeurLabel;

	    @FXML
	    private Label planEauLabel;

	    @FXML
	    private Label DateDepotDossierLabel;

	    @FXML
	    private Label dateDenvoiAlabhouerEljaidaLabel;

	    @FXML
	    private Label dateDebutEnquetePublicLabel;

	    @FXML
	    private Label dateFinEnquetePublicLabel;

	    @FXML
	    private Label dateSignaturPVparCEPLabel;

	    @FXML
	    private Label AvisDeCEPLabel;

	    @FXML
	    private Label dateEnvoitPvAbhoerEljadidaLabel;

	    @FXML
	    private Label AvisAbhoerLabel;

	    @FXML
	    private Label autorisationLabel;
    
    @FXML
    private void displayFile(MouseEvent event) throws PdfException {

    	if(event.getSource() == attestationFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getAttestationDePocession(), "attestationFile.pdf");
    		ShowPdf.display(path, "attestationFile.pdf");
    		
    	}else if(event.getSource() == demandeFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getDemandeFile(), "demandeFile.pdf");
    		ShowPdf.display(path, "demandeFile.pdf");
    		
    	}else if(event.getSource() == cinFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getCinFile(), "CIN.pdf");
    		ShowPdf.display(path, "CIN.pdf");
    		
    	}else if(event.getSource() == planImmobilierFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getPlanImmobilier(), "planEauFile.pdf");
    		ShowPdf.display(path, "planEauFile.pdf");
    		
    	}
    	
    }
	
    @FXML
    void goHomePage(MouseEvent event) {
    	
    	try {
    		
    		Parent ModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
			Scene ModifyFolderScene = new Scene(ModifyFolderRoot);
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
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
		setMessage(1);
	}

	
	public void setMessage(int idDossier) {
		
		ConnectionClassDossier myDataBaseFolder = new ConnectionClassDossier();
		dossier = myDataBaseFolder.getDossierFromDatabase(idDossier);
		initializeTextForLabels();
		
	}
	
	
	private void initializeTextForLabels() {
    	
    	/**
    	 * this zone for demandeur informations
    	 **/
    	nomLabel.setText(dossier.getNom());
    	prenomLabel.setText(dossier.getPrenom());
    	codCinLabel.setText(dossier.getCin());
    	typeDeDemandeLabel.setText(dossier.getTypeDemande());
    	demandeNameLabel.setText(dossier.getCin() + "demande.pdf");
    	cinFileLabel.setText(dossier.getCin() + "CIN.pdf");
    	DateDepotDossierLabel.setText(dossier.getDateDepotDossier().toString());
    	
    	/**
    	 * this zone for immobilier informations
    	 **/
    	nomImmobilierLabel.setText(dossier.getNomImmobilier());
    	daairaLabel.setText(dossier.getDaaira());
    	quiadaLabel.setText(dossier.getQuiada());
    	provinceLabel.setText(dossier.getProvince());
    	communeLabel.setText(dossier.getCommune());
    	douarLabel.setText(dossier.getDouar());
    	attestationPoscessionImmobilierLabel.setText(dossier.getCin() + "attestation_de_pocession.pdf");
    	planImmobilierFileNameLabel.setText(dossier.getCin() + "plan_de_l_immobilier.pdf");
    	
    	/**
    	 * this zone for point d'eau informations
    	 **/
    	LocalisationPointEauLabel.setText(dossier.getLocalisationPoint());
    	profondeurLabel.setText(Float.toString(dossier.getProfondeur()));
    	debitLabel.setText(Float.toString(dossier.getDebit()));
    	planEauLabel.setText(Float.toString(dossier.getPlanEau()));
    	
    	/**
    	 * this zone for suivi de dossier informations
    	 **/
    	dateDenvoiAlabhouerEljaidaLabel.setText(dossier.getDateEnvoiA_LABHOER().toString());
    	dateDebutEnquetePublicLabel.setText(dossier.getDateDebutde_EP().toString());
    	dateFinEnquetePublicLabel.setText(dossier.getDateFin_EP().toString());
    	dateSignaturPVparCEPLabel.setText(dossier.getDateSignateureDuPv().toString());
    	AvisDeCEPLabel.setText(dossier.getAvisDe_CEP());
    	dateEnvoitPvAbhoerEljadidaLabel.setText(dossier.getDateEnvoiDuPVa_LABHOER().toString());
    	AvisAbhoerLabel.setText(dossier.getAvisABHOER());
    	autorisationLabel.setText(dossier.getAutorisation());
    	
    }
	
}
