package pdfClasses;
	
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import org.jpedal.PdfDecoder;
import org.jpedal.exception.PdfException;

import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ShowPdf {
	
	static int pageCounte = 0;
	
	public static void display(String pdfPath, String title) {
		
		// open file.
		PdfDecoder pdf = new PdfDecoder();
		try {
			pdf.openPdfFile(pdfPath);
		} catch (PdfException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// creationg the window to desplay the pdf file as images
		Stage primaryStage = new Stage();
		primaryStage.setOnCloseRequest(e -> {
			pdf.closePdfFile();
			new File(pdfPath).delete();
		});
		
		//creating buttons
		Button next = new Button("next"), back = new Button("back");
		next.setMinWidth(40);
		next.setPrefHeight(20);
		back.setMinWidth(40);
		back.setPrefHeight(20);
		
		
		//crating imag view
		ImageView image = new ImageView();
		image.setFitWidth(400);
		image.setFitHeight(550);
		image.fitWidthProperty().bind(primaryStage.widthProperty());
		//image.fitHeightProperty().bind(primaryStage.heightProperty());
		
		
		//creating hbox
		HBox hbox =  new HBox(40); 
		hbox.getChildren().addAll(back, next);
		
		
		//creating vbox
		VBox vbox = new VBox(10);
		vbox.getChildren().addAll(image, hbox);
		
		try {
			
			BorderPane root = new BorderPane();
			root.getChildren().add(vbox);
			
			Scene scene = new Scene(root,400,600);
			primaryStage.setScene(scene);
			primaryStage.setTitle(title);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//Handling buttons actions
		next.setOnAction(e -> showPage(pageCounte + 1, pdf, image, primaryStage, next, back));
	    back.setOnAction(e -> showPage(pageCounte - 1, pdf, image, primaryStage, next, back));
		
	    //calling for the method to show the first page
		showPage(1, pdf, image, primaryStage, next, back);
	}
	
	
	private static void showPage(int page,PdfDecoder pdf,  ImageView imageView, Stage stage, Button next, Button back) {
	    
	    //Check in range
	    if (page > pdf.getPageCount())
	        return;
	    if (page < 1)
	        return;



	    //Show/hide buttons as necessary
	    if (page == pdf.getPageCount())
	        next.setVisible(false);
	    else
	        next.setVisible(true);

	    if (page == 1)
	        back.setVisible(false);
	    else
	        back.setVisible(true);
	    
	    pageCounte = page;

	    //Calculate scale
	    int pW = pdf.getPdfPageData().getCropBoxWidth(page);
	    int pH = pdf.getPdfPageData().getCropBoxHeight(page);

	    Dimension s = Toolkit.getDefaultToolkit().getScreenSize();

	    s.width -= 100;
	    s.height -= 100;

	    double xScale = (double)s.width / pW;
	    double yScale = (double)s.height / pH;
	    double scale = xScale < yScale ? xScale : yScale;

	    //Work out target size
	    pW *= scale;
	    pH *= scale;

	    //Get image and set
	    
	    Image i = getPageAsImage(page, pdf);   //SwingFXUtils.toFXImage(img, null);
	    imageView.setImage(i);

	}

	private static WritableImage getPageAsImage(int page, PdfDecoder pdf) {

	    BufferedImage img;
	    try {
	    	
	        img = pdf.getPageAsImage(page);


	        //Use deprecated method since there's no real alternative 
	        //(for JavaFX 2.2+ can use SwingFXUtils instead).
	        WritableImage wr = null;
	        if (img != null) {
	            wr = new WritableImage(img.getWidth(), img.getHeight());
	            PixelWriter pw = wr.getPixelWriter();
	            for (int x = 0; x < img.getWidth(); x++) {
	                for (int y = 0; y < img.getHeight(); y++) {
	                    pw.setArgb(x, y, img.getRGB(x, y));
	                }
	            }
	        }
	        return wr;

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}
	
}
