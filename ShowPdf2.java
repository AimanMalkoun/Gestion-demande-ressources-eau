
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.jpedal.PdfDecoder;
import org.jpedal.exception.PdfException;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShowPdf2 implements Initializable{

	 @FXML
	 private VBox vboxRoot;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	public List<Image> getPdfImages(PdfDecoder pdf) throws PdfException{
		
		List<Image> images = new ArrayList<Image>();
		int nbImages = pdf.getPageCount();
		if(nbImages == 0)
			return null;
		else {
		
			for (int pageNember = 1; pageNember <= nbImages; pageNember++) {
				
				BufferedImage img = pdf.getPageAsImage(pageNember);
			    Image image = SwingFXUtils.toFXImage(img, null); 
			    images.add(image);
			    
			}
			
			return images;
		}
		
	}
	
	public void setMessage(String path, Stage window) {

		vboxRoot.prefWidthProperty().bind(window.widthProperty().subtract(40));
		
		System.out.println(vboxRoot);
		// open file.
		PdfDecoder pdf = new PdfDecoder();
		try {
					
			pdf.openPdfFile(path);
			List<Image> images = getPdfImages(pdf);
			for(Image img : images) {
				
				//crating image view
				ImageView imageView = new ImageView(img);
				imageView.fitWidthProperty().bind(vboxRoot.prefWidthProperty());
				imageView.fitHeightProperty().bind(vboxRoot.prefWidthProperty().multiply(1.5));
				
				vboxRoot.getChildren().add(imageView);
				
			}
			
		} catch (PdfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
						
		window.setOnCloseRequest(e -> {
								pdf.closePdfFile();
								new File(path).delete();
								});
		
	}

}
