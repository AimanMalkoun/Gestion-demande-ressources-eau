package pdfClasses;
	
import java.io.IOException;

import Controllers.ShowPdf2;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ShowPdf {
	
	static int pageCounte = 0;
	
	public static void display2(String pdfPath, String title) {
		
		try {

			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(ShowPdf.class.getResource("../Fxml/showPdf2.fxml"));
			Parent showFolderRoot = loader.load();

			Stage primaryStage = new Stage();
			primaryStage.setTitle(title);
			
			ShowPdf2 nextControler = loader.getController();
			nextControler.setMessage(pdfPath, primaryStage);
			

			Scene showFolderScene = new Scene(showFolderRoot);
			primaryStage.setScene(showFolderScene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
