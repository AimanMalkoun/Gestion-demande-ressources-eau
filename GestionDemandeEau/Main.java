package GestionDemandeEau;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import Connectivity.ConnectionClassMaria;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		try {
			
			
/*
 * This is the section for the Login. It is the first window (stage) that the user sees
 * He is asked to type his password.
 * 
 * the password is then compared to the database password.
 * 
 * if it is the same the user gets access to his dashboard
 * if it is not the right password 
 * he ges an error message
 * 
 */


	    	
			Parent loginRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/LoginStage.fxml")); //load the scene in root
			Scene loginScene = new Scene(loginRoot);
			primaryStage.setTitle("Gestion des demandes d'autorisation pour l'utilisation des ressources en eau.");
			primaryStage.setScene(loginScene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}

//-----Dashbaord-----
/*
 * BorderPane root =
 * (BorderPane)FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"))
 * ; Scene scene = new Scene(root); primaryStage.setScene(scene);
 * primaryStage.show();
 */

//-----Login Stage-----
/*
 * Pane root =
 * (Pane)FXMLLoader.load(getClass().getResource("../Fxml/LoginStage.fxml"));
 * Scene scene = new Scene(root); primaryStage.setScene(scene);
 * primaryStage.show();
 */

//-----Modify Folder-----
/*
 * BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(
 * "../Fxml/ModifyFolder.fxml")); Scene scene = new Scene(root);
 * primaryStage.setScene(scene); primaryStage.show();
 */