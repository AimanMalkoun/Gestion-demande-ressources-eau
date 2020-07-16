package matrouhTest;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class Test extends Application{
		
		public static Stage window;
		
		@Override
		public void start(Stage primaryStage) {
			
			window = primaryStage;
			
			//Les informations du demandeur
			try {
				
				Parent root = FXMLLoader.load(Test.class.getClassLoader().getResource("Fxml/Les-informations-concernant-l'immobilier.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setTitle("Gestion des demandes d'autorisation pour l'utilisation des ressources en eau.");
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		public static void main(String[] args) {
			launch(args);
		}
	}

	

//Les informations du demandeur
	  /*try {
	
			Parent root = FXMLLoader.load(Test.class.getClassLoader().getResource("Fxml/InformationsDuDemandeur.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Gestion des demandes d'autorisation pour l'utilisation des ressources en eau.");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}*/
