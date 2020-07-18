package GestionDemandeEau;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import Controllers.LoginStageController;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
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
			
			
			
			
			//This will be uncomented in the end
			/*
			Pane loginRoot = (Pane)FXMLLoader.load(getClass().getResource("../Fxml/LoginStage.fxml")); //load the scene in root
			Scene loginScene = new Scene(loginRoot);
			primaryStage.setTitle("Gestion des demandes d'autorisation pour l'utilisation des ressources en eau.");
			primaryStage.setScene(loginScene);
			primaryStage.show();
			*/
			
			
			Parent dashboardRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/InformationsConcernantPointDeau.fxml"));
			Scene dashboardScene = new Scene(dashboardRoot);
			
			primaryStage.setTitle("Gestion des demandes d'autorisation pour l'utilisation des ressources en eau.");
			primaryStage.setScene(dashboardScene);
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