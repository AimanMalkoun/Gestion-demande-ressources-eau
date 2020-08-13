

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




public class CreatePdfWithImages{
	
	public static File createPdf(List<File> imagesList, String fileName) {
		//get destination path
		String destPath = "src/tempFiles" + "/" + fileName;
		
		//creating pdf writer
		Document document = new Document();
		
		try {

			FileOutputStream output = new FileOutputStream(destPath);
			PdfWriter pdfWriter = PdfWriter.getInstance(document, output);
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
			pdfWriter.close();
			output.close();
			
		} catch (FileNotFoundException | DocumentException e) {

			e.printStackTrace();
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return new File(destPath);
		
	}
}
