package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.jpedal.exception.PdfException;

import Classes.DossierForDownload;

import pdfClasses.ShowPdf;
import pdfClasses.ConvertBlobToPdf;

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


public class DisplayFolderController implements Initializable {

	DossierForDownload dossier;

	@FXML
    private Label nomLabel;

    @FXML
    private Label prenomLabel;

    @FXML
    private Label provinceLabel;

    @FXML
    private Label communeLabel;

    @FXML
    private Label douarLabel;

    @FXML
    private Label attistationFileLabel;

    @FXML
    private Button attestationFileButton;

    @FXML
    private Label localisationImmobilierLabel;

    @FXML
    private Label demandeFileLabel;

    @FXML
    private Button demandeFileButton;

    @FXML
    private Label typeDemandeLabel;

    @FXML
    private Label cinFileLabel;

    @FXML
    private Button cinFileButton;

    @FXML
    private Label cinLabel;

    @FXML
    private Label localisationPointEauLabel;

    @FXML
    private Label planEauFileLabel;

    @FXML
    private Button planEauFileButton;

    @FXML
    private Label rabatementLabel;

    @FXML
    private Label dateDepotDossierLabel;

    @FXML
    private Label dateEnvoiAboherLabel;

    @FXML
    private Label dateDebutEPLabel;

    @FXML
    private Label dateFinEPLabel;

    @FXML
    private Label dateSignaturePVParEPLabel;

    @FXML
    private Label avisCEPLabelLabel;

    @FXML
    private Label datenvoiPVaAboherLabel;

    @FXML
    private Label avisAboherLabel;

    @FXML
    private Label profondeurLabel;

    @FXML
    private Label debitLabel;

    @FXML
    private Label autorisationLabel;
    
    @FXML
    private void displeyFile(MouseEvent event) throws PdfException {

    	if(event.getSource() == attestationFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getAttestationDePocession(), "attestationFile.pdf");
    		ShowPdf.display(path, "attestationFile.pdf");
    		
    	}else if(event.getSource() == demandeFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getDemandeFile(), "demandeFile.pdf");
    		ShowPdf.display(path, "demandeFile.pdf");
    		
    	}else if(event.getSource() == cinFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getCinFile(), "CIN.pdf");
    		ShowPdf.display(path, "CIN.pdf");
    		
    	}else if(event.getSource() == planEauFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getPlanEau(), "planEauFile.pdf");
    		ShowPdf.display(path, "planEauFile.pdf");
    		
    	}
    	
    }
    
    @FXML
    private void annuler(MouseEvent event) {

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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//setMessage(1);
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
    	cinLabel.setText(dossier.getCin());
    	typeDemandeLabel.setText(dossier.getTypeDemande());
    	demandeFileLabel.setText(dossier.getCin() + "demande_de_creusement.pdf");
    	cinFileLabel.setText(dossier.getCin() + "CIN.pdf");
    	dateDepotDossierLabel.setText(dossier.getDateDepotDossier().toString());
    	
    	/**
    	 * this zone for immobilier informations
    	 **/
    	provinceLabel.setText(dossier.getProvince());
    	communeLabel.setText(dossier.getCommune());
    	douarLabel.setText(dossier.getDouar());
    	attistationFileLabel.setText(dossier.getCin() + "attestation_de_pocession.pdf");
    	localisationImmobilierLabel.setText(dossier.getLocalisation());
    	
    	/**
    	 * this zone for point d'eau informations
    	 **/
    	localisationPointEauLabel.setText(dossier.getLocalisationPoint());
    	rabatementLabel.setText(Float.toString(dossier.getRabattement()));
    	profondeurLabel.setText(Float.toString(dossier.getProfondeur()));
    	debitLabel.setText(Float.toString(dossier.getDebit()));
    	planEauFileLabel.setText(dossier.getCin() + "plan_d_eau.pdf");
    	
    	/**
    	 * this zone for suivi de dossier informations
    	 **/
    	dateEnvoiAboherLabel.setText(dossier.getDateEnvoiA_LABHOER().toString());
    	dateDebutEPLabel.setText(dossier.getDateDebutde_EP().toString());
    	dateFinEPLabel.setText(dossier.getDateFin_EP().toString());
    	dateSignaturePVParEPLabel.setText(dossier.getDateSignateureDuPv().toString());
    	avisCEPLabelLabel.setText(dossier.getAvisDe_CEP());
    	dateEnvoiAboherLabel.setText(dossier.getDateEnvoiDuPVa_LABHOER().toString());
    	avisAboherLabel.setText(dossier.getAvisABHOER());
    	autorisationLabel.setText(dossier.getAutorisation());
    	
    }
	
}
