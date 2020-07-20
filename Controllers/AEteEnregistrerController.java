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
		Parent root = FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
		boderPane.getChildren().setAll(root);
	}

	@FXML
	public void downloadReceiptMethode(ActionEvent event) throws SQLException {
		String nomPrenom = null, cin = null, nomImmobiler = null, commune = null, prevince = null;
		Date dateDepot = null;
		  
		/* se connecter avec la base de données */
		
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
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\user\\Desktop\\Demandes\\" + nomPrenom +".pdf"));
			Font small = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 14);
			Font normal = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 18);
			Font big0 = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 22);
			Font big = FontFactory.getFont("C:/Windows/Fonts/arial.ttf", BaseFont.IDENTITY_H, 24);
			document.open();
			PdfPTable table = new PdfPTable(1);
			table.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);

			/* les elements du paragraphe 1 */

			Paragraph para1 = new Paragraph(30);
			para1.add(new Phrase("\n المملكة المغربية \n", big0));// وزارة التجهيز والنقل واللوجيستيك والماء ",
																	// normal));
			para1.add(new Phrase("وزارة التجهيز والنقل واللوجيستيك والماء", big0));
			para1.add(new Phrase("\n قطاع الماء\n", big));
			para1.add(new Phrase(
					"المدرية الاقليمية للتجهيز والنقل واللوجيستيك والماء بأسفي \n المصلحة الاقليمية للماء بأسفي \n",
					normal));
			para1.add(new Phrase("\n وصل إيداع\n", big));
			para1.setAlignment(Paragraph.ALIGN_CENTER);

			/* les elements du paragraphe 2 */

			Paragraph para2 = new Paragraph(30);// " \n يشهد رئيس المصلحة الاقليمية للماء بأسفي ان السيد", normal);
			para2.add(new Phrase("\n يشهد رئيس المصلحة الاقليمية للماء بأسفي ان السيد ", normal));
			para2.add(new Phrase(nomPrenom, big));
			para2.add(new Phrase(" حامل للبطاقة الوطنية رقم ", normal));
			para2.add(new Phrase(cin, big));
			para2.add(new Phrase(" قد وضع  لذا هذه المصلحة  بتاريخ ", normal));
			para2.add(new Phrase(" "+dateDepot + " ", big));
			para2.add(new Phrase(" ملف طلب الترخيص لإنجاز ثقب  مائي من أجل سقي بالعقار المسمى : ", normal));
			para2.add(new Phrase(nomImmobiler, big));
			para2.setAlignment(Paragraph.ALIGN_LEFT);
			para2.setSpacingAfter(30);
			/* les elements du paragraphe 3 */

			Paragraph para3 = new Paragraph(30);
			para3.add(new Phrase("الجماعة", normal));
			para3.add(new Phrase(commune, big));
			para3.add(new Phrase(" القيادة ", normal));
			para3.add(new Phrase(" اسم القيادة  ", big));
			para3.add(new Phrase(" الدائرة ", normal));
			para3.add(new Phrase(" اسم الدائرة  ", big));
			para3.add(new Phrase(" الاقليم ", normal));
			para3.add(new Phrase(prevince+ ".", big));
			para3.setAlignment(Paragraph.ALIGN_LEFT);

			/* les elements du paragraphe 4 */

			Paragraph para4 = new Paragraph("\n  إمضاء : \n", big);
			para4.setAlignment(Paragraph.ALIGN_CENTER);
			para4.setSpacingAfter(35);

			/* les elements du paragraphe 5 */

			Paragraph para5 = new Paragraph(30);
			para5.add(new Phrase("ملحوظة : ", big0));
			para5.add(new Phrase("هذا الوصل يثبت فقط إيداع ملف الترخيص  ولا يمكن اعتباره ترخيصا بحفر او جلب ماء .",
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
			Desktop.getDesktop().open(new File("C:\\Users\\user\\Desktop\\Demandes\\" + nomPrenom +".pdf"));

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
