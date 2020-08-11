package Controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import org.jpedal.exception.PdfException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
import javafx.stage.DirectoryChooser;
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
	    String path;
	    @FXML
	    void annuler(MouseEvent event) {
	    	
	    	try {

				FXMLLoader loader= new FXMLLoader();
				loader.setLocation(getClass().getResource("../Fxml/ModifyFolder2.fxml"));
				Parent showFolderRoot = loader.load();
				
				ModifyFolder2Controller nextControler = loader.getController();
				nextControler.setMessage(1);
				
				Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				Scene showFolderScene = new Scene(showFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
				primaryStage.setScene(showFolderScene);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
    
    @FXML
    private void displayFile(MouseEvent event) throws PdfException {

    	if(event.getSource() == attestationFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getAttestationDePocession(), "attestationFile.pdf");
    		ShowPdf.display2(path, "attestationFile.pdf");
    		
    	}else if(event.getSource() == demandeFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getDemandeFile(), "demandeFile.pdf");
    		ShowPdf.display2(path, "demandeFile.pdf");
    		
    	}else if(event.getSource() == cinFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getCinFile(), "CIN.pdf");
    		ShowPdf.display2(path, "CIN.pdf");
    		
    	}else if(event.getSource() == planImmobilierFileButton) {
    		
    		String path =ConvertBlobToPdf.getPdfFromBlob(dossier.getPlanImmobilier(), "planEauFile.pdf");
    		ShowPdf.display2(path, "planEauFile.pdf");
    		
    	}
    	
    }
    
    @FXML
    void downloadFolder(MouseEvent event) throws IOException, DocumentException {
		DirectoryChooser dirChooser = new DirectoryChooser();
		File file = dirChooser.showDialog(null);
		if(file != null) {
			path = file.getAbsolutePath();
			

		}
		Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(path+ "\\"+ codCinLabel.getText() + ".pdf"));
			Font small = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 12);
			Font normal = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 15);
			Font big0 = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 18);
			Font big = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 22);
			big.setColor(19, 164, 90);
			big0.setColor(11, 50, 139);
			document.open();
			PdfPTable table = new PdfPTable(1);
			table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

			/* les elements du paragraphe 1 */
			
			Paragraph para1_1_1 = new Paragraph(20);
			para1_1_1.add(new Phrase("\u0631\u0642\u0645 \u0627\u0644\u0645\u0644\u0641 : " + Calendar.getInstance().get(Calendar.YEAR) + "/" + dossier.getIdDossier(), small));
			para1_1_1.setAlignment(Paragraph.ALIGN_LEFT);
			para1_1_1.setSpacingAfter(30);

			Paragraph para1_1 = new Paragraph(30);
			para1_1.add(new Phrase("\u0627\u0644\u0645\u0639\u0644\u0648\u0645\u0627\u062a \u0627\u0644\u062e\u0627\u0635\u0629 \u0628\u0635\u0627\u062d\u0628 \u0627\u0644\u0637\u0644\u0628", big));
			para1_1.setAlignment(Paragraph.ALIGN_CENTER);
			para1_1.setSpacingAfter(30);
			
			/*
			 *Informations about the applicant 
			 */
			Paragraph para1 = new Paragraph(30);
			para1.add(new Phrase("\u0627\u0644\u0627\u0633\u0645 \u0627\u0644\u0643\u0627\u0645\u0644 : ", normal));
			para1.add(new Phrase(nomLabel.getText() + " " +prenomLabel.getText() + "\n", big0));
			para1.add(new Phrase("\u0631\u0642\u0645 \u0628\u0637\u0627\u0642\u0629 \u0627\u0644\u062a\u0639\u0631\u064a\u0641 \u0627\u0644\u0648\u0637\u0646\u064a\u0629 : ", normal));
			para1.add(new Phrase(codCinLabel.getText() + "\n", big0));
			para1.add(new Phrase("\u0646\u0648\u0639 \u0627\u0644\u0637\u0644\u0628 : ", normal));
			para1.add(new Phrase(typeDeDemandeLabel.getText() + "\n", big0));
			para1.add(new Phrase("\u062a\u0627\u0631\u064a\u064a\u062e \u0625\u064a\u062f\u0627\u0639 \u0627\u0644\u0645\u0644\u0641 : ", normal));
			para1.add(new Phrase(DateDepotDossierLabel.getText() + "\n", big0));
			para1.setAlignment(Paragraph.ALIGN_LEFT);
			para1.setSpacingAfter(30);
			
			Paragraph para1_2 = new Paragraph(30);
			para1_2.add(new Phrase("\u0627\u0644\u0645\u0639\u0644\u0648\u0645\u0627\u062a \u0627\u0644\u062e\u0627\u0635\u0629 \u0628\u0627\u0644\u0639\u0642\u0627\u0631", big));
			para1_2.setAlignment(Paragraph.ALIGN_CENTER);
			para1_2.setSpacingAfter(30);
			/*
			 *Property informations
			 */
			Paragraph para2 = new Paragraph(30);
			para2.add(new Phrase("\u0627\u0633\u0645 \u0627\u0644\u0639\u0642\u0627\u0631 : ", normal));
			para2.add(new Phrase(nomImmobilierLabel.getText() + "\n", big0));
			para2.add(new Phrase("\u0627\u0644\u0642\u064a\u0627\u062f\u0629 : ", normal));
			para2.add(new Phrase(quiadaLabel.getText() + "\n", big0));
			para2.add(new Phrase("\u0627\u0644\u062f\u0627\u0626\u0631\u0629 : ", normal));
			para2.add(new Phrase(daairaLabel.getText() + "\n", big0));
			para2.add(new Phrase("\u0627\u0644\u062f\u0648\u0627\u0631 : ", normal));
			para2.add(new Phrase(douarLabel.getText() + "\n", big0));
			para2.add(new Phrase("\u0627\u0644\u062c\u0645\u0627\u0639\u0629 : ", normal));
			para2.add(new Phrase(communeLabel.getText() + "\n", big0));
			para2.add(new Phrase("\u0627\u0644\u0625\u0642\u0644\u064a\u0645 : ", normal));
			para2.add(new Phrase(provinceLabel.getText() + "\n", big0));
			para2.setAlignment(Paragraph.ALIGN_LEFT);
			para2.setSpacingAfter(30);
			
			Paragraph para1_3 = new Paragraph(30);
			para1_3.add(new Phrase("\u0627\u0644\u0645\u0639\u0644\u0648\u0645\u0627\u062a \u0627\u0644\u062e\u0627\u0635\u0629 \u0628\u0627\u0644\u062b\u0642\u0628 \u0627\u0644\u0645\u0627\u0626\u064a", big));
			para1_3.setAlignment(Paragraph.ALIGN_CENTER);
			para1_3.setSpacingAfter(30);
			/*
			 *Water hole information 
			 */
			Paragraph para3 = new Paragraph(30);
			para3.add(new Phrase("\u0625\u062d\u062f\u0627\u062b\u064a\u0627\u062a \u0627\u0644\u062b\u0642\u0628 \u0627\u0644\u0645\u0627\u0626\u064a : ", normal));
			para3.add(new Phrase(LocalisationPointEauLabel.getText() + "\n", big0));
			para3.add(new Phrase("\u0627\u0644\u0635\u0628\u064a\u0628 : ", normal));
			para3.add(new Phrase(debitLabel.getText() + "\n", big0));
			para3.add(new Phrase("\u0627\u0644\u0639\u0645\u0642 : ", normal));
			para3.add(new Phrase(profondeurLabel.getText() + "\n", big0));
			para3.add(new Phrase("\u0645\u0633\u062a\u0648\u0649 \u0627\u0644\u0645\u0627\u0621 : ", normal));
			para3.add(new Phrase(planEauLabel.getText() + "\n", big0));
			
			para3.setAlignment(Paragraph.ALIGN_LEFT);
			para3.setSpacingAfter(30);
			
			Paragraph para1_4 = new Paragraph(30);
			para1_4.add(new Phrase("\u0627\u0644\u0645\u0639\u0644\u0648\u0645\u0627\u062a \u0627\u0644\u0623\u062e\u0631\u0649", big));
			para1_4.setAlignment(Paragraph.ALIGN_CENTER);
			para1_4.setSpacingAfter(30);
			/*
			 *the other informations 
			 */
			Paragraph para4 = new Paragraph(30);
			para4.add(new Phrase("\u062a\u0627\u0631\u064a\u062e \u0625\u0631\u0633\u0627\u0644 \u0627\u0644\u0645\u0644\u0641 \u0625\u0644\u0649 \u0645\u0646\u062f\u0648\u0628\u064a\u0629 \u0648\u0643\u0627\u0644\u0629 \u0627\u0644\u062d\u0648\u0636 \u0627\u0644\u0645\u0627\u0626\u064a \u0644\u0627\u0645 \u0627\u0644\u0631\u0628\u064a\u0639 \u0628\u0627\u0644\u062c\u062f\u064a\u062f\u0629 : ", normal));
			para4.add(new Phrase(dateDenvoiAlabhouerEljaidaLabel.getText() + "\n", big0));
			para4.add(new Phrase("\u062a\u0627\u0631\u064a\u062e \u0628\u062f\u0627\u064a\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a : ", normal));
			para4.add(new Phrase(dateDebutEnquetePublicLabel.getText() + "\n", big0));
			para4.add(new Phrase("\u062a\u0627\u0631\u064a\u062e \u0646\u0647\u0627\u064a\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a : ", normal));
			para4.add(new Phrase(dateFinEnquetePublicLabel.getText() + "\n", big0));
			para4.add(new Phrase("\u062a\u0627\u0631\u064a\u062e \u0627\u0645\u0636\u0627\u0621 \u0627\u0644\u0645\u062d\u0636\u0631 \u0645\u0646 \u0637\u0631\u0641 \u0644\u062c\u0646\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a : ", normal));
			para4.add(new Phrase(dateSignaturPVparCEPLabel.getText() + "\n", big0));
			para4.add(new Phrase("\u0631\u0623\u064a \u0644\u062c\u0646\u0629 \u0627\u0644\u0628\u062d\u062b \u0627\u0644\u0639\u0644\u0646\u064a : ", normal));
			para4.add(new Phrase(AvisDeCEPLabel.getText() + "\n", big0));
			para4.add(new Phrase("\u062a\u0627\u0631\u064a\u062e \u0625\u0631\u0633\u0627\u0644 \u0627\u0644\u0645\u062d\u0636\u0631 \u0625\u0644\u0649 \u0645\u0646\u062f\u0648\u0628\u064a\u0629 \u0648\u0643\u0627\u0644\u0629 \u0627\u0644\u062d\u0648\u0636 \u0627\u0644\u0645\u0627\u0626\u064a \u0644\u0627\u0645 \u0627\u0644\u0631\u0628\u064a\u0639 \u0628\u0627\u0644\u062c\u062f\u064a\u062f\u0629 : ", normal));
			para4.add(new Phrase(dateEnvoitPvAbhoerEljadidaLabel.getText() + "\n", big0));
			para4.add(new Phrase("\u0631\u0623\u064a \u0648\u0643\u0627\u0644\u0629 \u0627\u0644\u062d\u0648\u0636 \u0627\u0644\u0645\u0627\u0626\u064a \u0644\u0627\u0645 \u0627\u0644\u0631\u0628\u064a\u0639 : ", normal));
			para4.add(new Phrase(AvisAbhoerLabel.getText() + "\n", big0));
			para4.add(new Phrase("\u0627\u0644\u0631\u062e\u0635\u0629 : ", normal));
			para4.add(new Phrase(autorisationLabel.getText() + "\n", big0));
			
			para4.setAlignment(Paragraph.ALIGN_LEFT);
			para4.setSpacingAfter(30);

			PdfPCell cell = new PdfPCell();
			cell.setPaddingRight(40);
			cell.setPaddingTop(20);
			cell.setPaddingBottom(20);
			cell.addElement(para1_1_1);
			cell.addElement(para1_1);
			cell.addElement(para1);
			cell.addElement(para1_2);
			cell.addElement(para2);
			cell.addElement(para1_3);
			cell.addElement(para3);
			cell.addElement(para1_4);
			cell.addElement(para4);

			table.addCell(cell);
			table.setWidthPercentage(100);
			document.add(table);
			document.close();

			Desktop.getDesktop().open(new File(path+ "\\" + codCinLabel.getText() + ".pdf"));
		}


    @FXML
    void goHomePage(MouseEvent event) {
    	
    	try {
    		
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		Parent ModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
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
    		
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		Parent ModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/LoginStage.fxml"));
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
    	DateDepotDossierLabel.setText(dossier.getDateDepotDossier());
    	
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
    	dateDenvoiAlabhouerEljaidaLabel.setText(dossier.getDateEnvoiA_LABHOER());
    	dateDebutEnquetePublicLabel.setText(dossier.getDateDebutde_EP());
    	dateFinEnquetePublicLabel.setText(dossier.getDateFin_EP());
    	dateSignaturPVparCEPLabel.setText(dossier.getDateSignateureDuPv());
    	AvisDeCEPLabel.setText(dossier.getAvisDe_CEP());
    	dateEnvoitPvAbhoerEljadidaLabel.setText(dossier.getDateEnvoiDuPVa_LABHOER());
    	AvisAbhoerLabel.setText(dossier.getAvisABHOER());
    	autorisationLabel.setText(dossier.getAutorisation());
    	
    }
	
}
