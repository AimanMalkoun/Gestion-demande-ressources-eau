package Controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class AEteEnregistrerController implements Initializable {
	@FXML
	private BorderPane boderPane;
	@FXML
	private Button back;
	@FXML
	private Button downloadReceipt;

	// Event Listener on Button[#back].onAction
	@FXML
	public void handelBackMethode(ActionEvent event) throws IOException {
		cleanup(); // will clean the previous input except the import files
		Parent root = FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
		boderPane.getChildren().setAll(root);
	}

	private void cleanup() {
		LesInfoDuDemandeurController.demandeur.setNom("");
		LesInfoDuDemandeurController.demandeur.setPrenom("");
		LesInfoDuDemandeurController.demandeur.setCin("");
		LesInfoDuDemandeurController.demandeur.setTypeDemande("");
		
		LesInfoDelImmobilierController.InfoSurImmobilier.setLocalisation("");
		LesInfoDelImmobilierController.InfoSurImmobilier.setDouar("");
		LesInfoDelImmobilierController.InfoSurImmobilier.setCommune("");
		LesInfoDelImmobilierController.InfoSurImmobilier.setProvince("");
		
		InformationsConcernantPointDeauController.poinDeau.setLocalisationPoint("");
		InformationsConcernantPointDeauController.poinDeau.setDebit(0);
		InformationsConcernantPointDeauController.poinDeau.setRabattement(0);
		InformationsConcernantPointDeauController.poinDeau.setProfondeur(0);
		
		LesInfoDuDemandeurController.demandeur.setDateDepotDossier(null);
		
		
		
	}

	@FXML
	public void downloadReceiptMethode(ActionEvent event) throws SQLException {
		String nomPrenom = null, cin = null, nomImmobiler = null, commune = null, prevince = null;
		Date dateDepot = null;
		  
		/* se connecter avec la base de donnÃ©es */
		
		ConnectionClass conn = new ConnectionClass();
		Connection connection = conn.getConnection();
		Statement stat = connection.createStatement();
		String sql = "SELECT Nom, Prenom, cin, localisationImmobilier, Douar, Commune, Province, DateDepot   FROM dossier WHERE idDossier = " + EnregistrerController.idDossier;
		ResultSet result = stat.executeQuery(sql);
		if (result.next()) {
			nomPrenom = " " + result.getString("Nom") + "  " + result.getString("Prenom") + " " ;
			cin = " " + result.getString("cin") + " ";
			nomImmobiler = " " + result.getString("localisationImmobilier") + " " + result.getString("Douar") + " ";
			commune = " " + result.getString("Commune") + " ";
			prevince = " " + result.getString("Province") + " ";
			dateDepot = result.getDate("DateDepot");
		}
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\Demandes\\" + nomPrenom +".pdf"));
			Font small = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 14);
			Font normal = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 18);
			Font big0 = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 22);
			Font big = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 24);
			document.open();
			PdfPTable table = new PdfPTable(1);
			table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

			/* les elements du paragraphe 1 */

			Paragraph para1 = new Paragraph(30);
			para1.add(new Phrase("\n \u0627\u0644\u0645\u0645\u0644\u0643\u0629 \u0627\u0644\u0645\u063a\u0631\u0628\u064a\u0629 \n", big0));// ÙˆØ²Ø§Ø±Ø© Ø§Ù„ØªØ¬Ù‡ÙŠØ² ÙˆØ§Ù„Ù†Ù‚Ù„ ÙˆØ§Ù„Ù„ÙˆØ¬ÙŠØ³ØªÙŠÙƒ ÙˆØ§Ù„Ù…Ø§Ø¡ ",
																	// normal));
			para1.add(new Phrase("\u0648\u0632\u0627\u0631\u0629 \u0627\u0644\u062a\u062c\u0647\u064a\u0632 \u0648\u0627\u0644\u0646\u0642\u0644 \u0648\u0627\u0644\u0644\u0648\u062c\u064a\u0633\u062a\u064a\u0643 \u0648\u0627\u0644\u0645\u0627\u0621", big0));
			para1.add(new Phrase("\n \u0642\u0637\u0627\u0639 \u0627\u0644\u0645\u0627\u0621\n", big));
			para1.add(new Phrase(
					"\u0627\u0644\u0645\u062f\u0631\u064a\u0629 \u0627\u0644\u0627\u0642\u0644\u064a\u0645\u064a\u0629 \u0644\u0644\u062a\u062c\u0647\u064a\u0632 \u0648\u0627\u0644\u0646\u0642\u0644 \u0648\u0627\u0644\u0644\u0648\u062c\u064a\u0633\u062a\u064a\u0643 \u0648\u0627\u0644\u0645\u0627\u0621 \u0628\u0623\u0633\u0641\u064a \u005c\u006e \u0627\u0644\u0645\u0635\u0644\u062d\u0629 \u0627\u0644\u0627\u0642\u0644\u064a\u0645\u064a\u0629 \u0644\u0644\u0645\u0627\u0621 \u0628\u0623\u0633\u0641\u064a \n",
					normal));
			para1.add(new Phrase("\n \u0648\u0635\u0644 \u0625\u064a\u062f\u0627\u0639\n", big));
			para1.setAlignment(Paragraph.ALIGN_CENTER);

			/* les elements du paragraphe 2 */

			Paragraph para2 = new Paragraph(30);// " \n ÙŠØ´Ù‡Ø¯ Ø±Ø¦ÙŠØ³ Ø§Ù„Ù…ØµÙ„Ø­Ø© Ø§Ù„Ø§Ù‚Ù„ÙŠÙ…ÙŠØ© Ù„Ù„Ù…Ø§Ø¡ Ø¨Ø£Ø³Ù�ÙŠ Ø§Ù† Ø§Ù„Ø³ÙŠØ¯", normal);
			para2.add(new Phrase("\n \u064a\u0634\u0647\u062f \u0631\u0626\u064a\u0633 \u0627\u0644\u0645\u0635\u0644\u062d\u0629 \u0627\u0644\u0627\u0642\u0644\u064a\u0645\u064a\u0629 \u0644\u0644\u0645\u0627\u0621 \u0628\u0623\u0633\u0641\u064a \u0627\u0646 \u0627\u0644\u0633\u064a\u062f ", normal));
			para2.add(new Phrase(nomPrenom, big));
			para2.add(new Phrase(" \u062d\u0627\u0645\u0644 \u0644\u0644\u0628\u0637\u0627\u0642\u0629 \u0627\u0644\u0648\u0637\u0646\u064a\u0629 \u0631\u0642\u0645 ", normal));
			para2.add(new Phrase(cin, big));
			para2.add(new Phrase(" \u0642\u062f \u0648\u0636\u0639  \u0644\u0630\u0627 \u0647\u0630\u0647 \u0627\u0644\u0645\u0635\u0644\u062d\u0629  \u0628\u062a\u0627\u0631\u064a\u062e ", normal));
			para2.add(new Phrase(" "+dateDepot + " ", big));
			para2.add(new Phrase(" \u0645\u0644\u0641 \u0637\u0644\u0628 \u0627\u0644\u062a\u0631\u062e\u064a\u0635 \u0644\u0625\u0646\u062c\u0627\u0632 \u062b\u0642\u0628  \u0645\u0627\u0626\u064a \u0645\u0646 \u0623\u062c\u0644 \u0633\u0642\u064a \u0628\u0627\u0644\u0639\u0642\u0627\u0631 \u0627\u0644\u0645\u0633\u0645\u0649 ", normal));
			para2.add(new Phrase(nomImmobiler, big));
			para2.setAlignment(Paragraph.ALIGN_LEFT);
			para2.setSpacingAfter(30);
			/* les elements du paragraphe 3 */

			Paragraph para3 = new Paragraph(30);
			para3.add(new Phrase(" \u0627\u0644\u062c\u0645\u0627\u0639\u0629", normal));
			para3.add(new Phrase(commune, big));
			para3.add(new Phrase(" \u0627\u0644\u0642\u064a\u0627\u062f\u0629  ", normal));
			para3.add(new Phrase(" \u0627\u0633\u0645 \u0627\u0644\u0642\u064a\u0627\u062f\u0629  ", big));
			para3.add(new Phrase(" \u0627\u0644\u062f\u0627\u0626\u0631\u0629  ", normal));
			para3.add(new Phrase(" \u0627\u0633\u0645 \u0627\u0644\u062f\u0627\u0626\u0631\u0629  ", big));
			para3.add(new Phrase(" \u0627\u0644\u0627\u0642\u0644\u064a\u0645  ", normal));
			para3.add(new Phrase(prevince+ ".", big));
			para3.setAlignment(Paragraph.ALIGN_LEFT);

			/* les elements du paragraphe 4 */

			Paragraph para4 = new Paragraph("\n  Ø¥Ù…Ø¶Ø§Ø¡ : \n", big);
			para4.setAlignment(Paragraph.ALIGN_CENTER);
			para4.setSpacingAfter(35);

			/* les elements du paragraphe 5 */

			Paragraph para5 = new Paragraph(30);
			para5.add(new Phrase("\u0625\u0645\u0636\u0627\u0621  : ", big0));
			para5.add(new Phrase("\u0645\u0644\u062d\u0648\u0638\u0629 ",
					small));
			para5.setAlignment(Paragraph.ALIGN_LEFT);
			para5.setSpacingAfter(50);

			PdfPCell cell = new PdfPCell();
			cell.setPadding(20);
			cell.addElement(para1);
			cell.addElement(para2);
			cell.addElement(para3);
			cell.addElement(para4);
			cell.addElement(para5);
			table.addCell(cell);
			table.setWidthPercentage(100);
			document.add(table);
			document.close();
			Desktop.getDesktop().open(new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\Demandes\\" + nomPrenom +".pdf"));

		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
}
