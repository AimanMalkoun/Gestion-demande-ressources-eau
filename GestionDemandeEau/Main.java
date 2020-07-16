package GestionDemandeEau;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//    -----Modify Folder-----
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../Fxml/ModifyFolder.fxml"));
			
			Scene scene = new Scene(root);
			
			primaryStage.setTitle("Gestion des demandes d'autorisation pour l'utilisation des ressources en eau.");
			primaryStage.setScene(scene);
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
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
*/

//-----Login Stage-----
/*
		Pane root = (Pane)FXMLLoader.load(getClass().getResource("../Fxml/LoginStage.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
*/

//-----Modify Folder-----
/*
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("../Fxml/ModifyFolder.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
*/