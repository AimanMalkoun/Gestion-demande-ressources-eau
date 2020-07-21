package pdfClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;



public class CreatePdfWithImages extends Application{
	
	public static File createPdf(List<File> imagesList, String fileName) {
		//get destination path
		String destPath = CreatePdfWithImages.class.getClassLoader().getResource("tempFiles").getPath() + "/" + fileName;
		
		//creating pdf writer
		Document document = new Document();
		
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream(destPath));
			document.open();
			
			for (File image : imagesList) {
				Image img = Image.getInstance(image.getAbsolutePath());
				img.setAlignment(Element.ALIGN_CENTER);
				img.scaleToFit(PageSize.A3.getWidth(), PageSize.A3.getHeight());
				document.setPageSize(PageSize.A3);
				document.newPage();
				document.add(img);
				
		    }
			document.close();
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new File(destPath);
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new ExtensionFilter("image", "*.JPG", "*.PNG"));
		List<File> files = fileChooser.showOpenMultipleDialog(new Stage());
		createPdf(files, "test.pdf");
		
	}
}