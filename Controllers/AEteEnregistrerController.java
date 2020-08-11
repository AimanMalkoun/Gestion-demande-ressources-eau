package Controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.ResourceBundle;

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

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class AEteEnregistrerController implements Initializable {
	@FXML
	private BorderPane boderPane;
	@FXML
	private Button back;
	@FXML
	private Button downloadReceipt;
	@FXML
	private Label textError;
	String path;
	@FXML
	public void handelBackMethode(ActionEvent event) throws IOException {
		
		cleanup(); // will clean the previous input except the import files

		try {
			
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("../Fxml/Dashboard.fxml"));
			Parent DashboardRoot = loader.load();
			
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene DashboardScene = new Scene(DashboardRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(DashboardScene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void cleanup() {
		LesInfoDuDemandeurController.demandeur.setNom("");
		LesInfoDuDemandeurController.demandeur.setPrenom("");
		LesInfoDuDemandeurController.demandeur.setCin("");
		LesInfoDuDemandeurController.demandeur.setTypeDemande("");
		LesInfoDuDemandeurController.demandeur.setCinFile(null);
		LesInfoDuDemandeurController.demandeur.setDemandeFile(null);
		LesInfoDuDemandeurController.demandeur.setDateDepotDossier(null);
		
		LesInfoDelImmobilierController.InfoSurImmobilier.setNomImmobilier("");
		LesInfoDelImmobilierController.InfoSurImmobilier.setDaaira("");
		LesInfoDelImmobilierController.InfoSurImmobilier.setQuiada("");
		LesInfoDelImmobilierController.InfoSurImmobilier.setAttestationDePocession(null);
		LesInfoDelImmobilierController.InfoSurImmobilier.setDouar("");
		LesInfoDelImmobilierController.InfoSurImmobilier.setCommune("");
		LesInfoDelImmobilierController.InfoSurImmobilier.setProvince("");
		LesInfoDelImmobilierController.InfoSurImmobilier.setPlanImmobilier(null);;
		
		
		InformationsConcernantPointDeauController.poinDeau.setLocalisationPoint("");
		InformationsConcernantPointDeauController.poinDeau.setDebit(0);
		InformationsConcernantPointDeauController.poinDeau.setProfondeur(0);
		InformationsConcernantPointDeauController.poinDeau.setPlanEau(0);
		

	}

	@FXML
	public void downloadReceiptMethode(ActionEvent event) throws SQLException, DocumentException, IOException {
		String nomPrenom = null, 
				cin = null, 
				nomImmobiler = null,
				commune = null,
				prevince = null,
				daaira = null,
				qiyada = null,
				typeDemande = null,
				dateDepot = null;
	
		
		
		DirectoryChooser dirChooser = new DirectoryChooser();
		File file = dirChooser.showDialog(null);
		if(file != null) {
			path = file.getAbsolutePath();
			
		/* se connecter avec la base de donnees */

		ConnectionClass conn = new ConnectionClass();
		Connection connection = conn.getConnection();
		Statement stat = connection.createStatement();
		String sql = "SELECT `Nom`,`Prenom`,`cin`,`nomImmobilier`,`Commune`,`Province`, `typeDemande`, `DateDepot`, `qiyada`, `daaira`, `idDossierYear` FROM dossier WHERE `IdDossier` = "
				+ Integer.toString(EnregistrerController.idDossier);
		ResultSet result = stat.executeQuery(sql);
		if (result.next()) {
			nomPrenom = " " + result.getString("Nom") + "  " + result.getString("Prenom") + " ";
			cin = " " + result.getString("cin") + " ";
			nomImmobiler = " " + result.getString("nomImmobilier") + " ";
			commune = " " + result.getString("Commune") + " ";
			typeDemande = result.getString("typeDemande");
			prevince = " " + result.getString("Province") + " ";
			dateDepot = result.getString("DateDepot");
			daaira  = " " + result.getString("daaira") + " ";
			qiyada = " " + result.getString("qiyada") + " ";
		}
		Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(path+ "\\"+ cin + ".pdf"));
			Font small = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 14);
			Font normal = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 17);
			Font big0 = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 22);
			Font big = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 24);
			document.open();
			PdfPTable table = new PdfPTable(1);
			table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

			/* les elements du paragraphe 1 */
			Paragraph para1_1 = new Paragraph(20);
			para1_1.add(new Phrase("\u0631\u0642\u0645 \u0627\u0644\u0645\u0644\u0641 : " + Calendar.getInstance().get(Calendar.YEAR) + "/" + EnregistrerController.idDossier , small));
			para1_1.setAlignment(Paragraph.ALIGN_LEFT);
			para1_1.setSpacingAfter(20);
			/* les elements du paragraphe 1 */

			Paragraph para1 = new Paragraph(35);
			para1.add(new Phrase(
					"\n \u0627\u0644\u0645\u0645\u0644\u0643\u0629 \u0627\u0644\u0645\u063a\u0631\u0628\u064a\u0629 \n",
					big0));
			para1.add(new Phrase(
					"\u0648\u0632\u0627\u0631\u0629 \u0627\u0644\u062a\u062c\u0647\u064a\u0632 \u0648\u0627\u0644\u0646\u0642\u0644 \u0648\u0627\u0644\u0644\u0648\u062c\u064a\u0633\u062a\u064a\u0643 \u0648\u0627\u0644\u0645\u0627\u0621\n",
					big0));
			
			para1.add(new Phrase(
					"\u0627\u0644\u0645\u062f\u064a\u0631\u064a\u0629 \u0627\u0644\u0627\u0642\u0644\u064a\u0645\u064a\u0629 \u0644\u0644\u062a\u062c\u0647\u064a\u0632 \u0648\u0627\u0644\u0646\u0642\u0644 \u0648\u0627\u0644\u0644\u0648\u062c\u064a\u0633\u062a\u064a\u0643 \u0648\u0627\u0644\u0645\u0627\u0621 \u0628\u0623\u0633\u0641\u064a \u005c\u006e \u0627\u0644\u0645\u0635\u0644\u062d\u0629 \u0627\u0644\u0627\u0642\u0644\u064a\u0645\u064a\u0629 \u0644\u0644\u0645\u0627\u0621 \u0628\u0623\u0633\u0641\u064a \u005c\u006e",
					normal));
			para1.add(new Phrase("\n \u0648\u0635\u0644 \u0625\u064a\u062f\u0627\u0639\n", big));
			para1.setAlignment(Paragraph.ALIGN_CENTER);

			/* les elements du paragraphe 2 */

			Paragraph para2 = new Paragraph(30);
			para2.add(new Phrase(
					"\n \u064a\u0634\u0647\u062f \u0631\u0626\u064a\u0633 \u0627\u0644\u0645\u0635\u0644\u062d\u0629 \u0627\u0644\u0627\u0642\u0644\u064a\u0645\u064a\u0629 \u0644\u0644\u0645\u0627\u0621 \u0628\u0623\u0633\u0641\u064a \u0627\u0646 \u0627\u0644\u0633\u064a\u062f ",
					normal));
			para2.add(new Phrase(nomPrenom, big0));
			para2.add(new Phrase(
					" \u062d\u0627\u0645\u0644 \u0644\u0644\u0628\u0637\u0627\u0642\u0629 \u0627\u0644\u0648\u0637\u0646\u064a\u0629 \u0631\u0642\u0645 ",
					normal));
			para2.add(new Phrase(cin, big0));
			para2.add(new Phrase(
					" \u0642\u062f \u0648\u0636\u0639  \u0644\u0630\u0627 \u0647\u0630\u0647 \u0627\u0644\u0645\u0635\u0644\u062d\u0629  \u0628\u062a\u0627\u0631\u064a\u062e",
					normal));
			para2.add(new Phrase("\n" + dateDepot + " ", big0));
			para2.add(new Phrase(" \ufee3\ufee0\ufed2 ", normal));
			para2.add(new Phrase(" " + typeDemande + " ", big0));
			para2.add(new Phrase( "\u0645\u0646 \u0623\u062c\u0644 \u0627\u0644\u0633\u0642\u064a \u0628\u0627\u0644\u0639\u0642\u0627\u0631 \u0627\u0644\u0645\u0633\u0645\u0649 :",normal));
			para2.add(new Phrase(nomImmobiler, big0));
			para2.setAlignment(Paragraph.ALIGN_LEFT);
			/* les elements du paragraphe 3 */

			Paragraph para3 = new Paragraph(30);
			para3.add(new Phrase("\u0627\u0644\u062c\u0645\u0627\u0639\u0629", normal));
			para3.add(new Phrase(commune, big0));
			para3.add(new Phrase(" \u0627\u0644\u0642\u064a\u0627\u062f\u0629  ", normal));
			para3.add(new Phrase(qiyada, big0));
			para3.add(new Phrase(" \u0627\u0644\u062f\u0627\u0626\u0631\u0629  ", normal));
			para3.add(new Phrase(daaira, big0));
			para3.add(new Phrase(" \u0627\u0644\u0627\u0642\u0644\u064a\u0645  ", normal));
			para3.add(new Phrase(prevince + ".", big0));
			para3.setAlignment(Paragraph.ALIGN_LEFT);
			para3.setSpacingAfter(20);
			/* les elements du paragraphe 4 */

			Paragraph para4 = new Paragraph("\n \ufe87\ufee3\ufec0\ufe8e\ufe80 : \n", big);
			para4.setAlignment(Paragraph.ALIGN_CENTER);
			para4.setSpacingAfter(60);

			/* les elements du paragraphe 5 */

			Paragraph para5 = new Paragraph(30);
			para5.add(new Phrase("\u0645\u0644\u062d\u0648\u0638\u0629 : ", big0));
			para5.add(new Phrase(" \ufeeb\ufeac\ufe8d \ufe8d\ufedf\ufeee\ufebb\ufede \ufef3\ufe9c\ufe92\ufe96 \ufed3\ufed8\ufec2 \ufe87\ufef3\ufeaa\ufe8d\ufec9 \ufee3\ufee0\ufed2 \ufe8d\ufedf\ufe98\ufeae\ufea7\ufef4\ufeba  \ufeed\ufefb \ufef3\ufee4\ufedc\ufee6 \ufe8d\ufecb\ufe98\ufe92\ufe8e\ufead\ufee9 \ufe97\ufeae\ufea7\ufef4\ufebc\ufe8e \ufe91\ufea4\ufed4\ufeae \ufe8d\ufeed \ufe9f\ufee0\ufe90 \ufee3\ufe8e\ufe80.", small));
			para5.setAlignment(Paragraph.ALIGN_LEFT);
			para5.setSpacingAfter(20);

			PdfPCell cell = new PdfPCell();
			cell.setPadding(20);
			cell.addElement(para1_1);
			cell.addElement(para1);
			cell.addElement(para2);
			cell.addElement(para3);
			cell.addElement(para4);
			cell.addElement(para5);
			table.addCell(cell);
			table.setWidthPercentage(100);
			document.add(table);
			document.close();

			Desktop.getDesktop().open(new File(path+ "\\" + cin + ".pdf"));
		}
		else {
			textError.setText("\u064a\u0631\u062c\u0649 \u0627\u062e\u062a\u064a\u0627\u0631 \u0645\u062c\u0644\u062f \u0644\u062a\u0646\u0632\u064a\u0644 \u0627\u0644\u0631\u0627\u0628\u0637");
		}


	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}