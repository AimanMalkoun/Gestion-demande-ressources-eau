package matrouhTest;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;

public class Test extends Application{
		
		@Override
		public void start(Stage primaryStage) {
			
			//Les informations du demandeur
			try {
				
				Parent root = FXMLLoader.load(Test.class.getClassLoader().getResource("Fxml/afficher-un-dossier.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setTitle("Gestion des demandes d'autorisation pour l'utilisation des ressources en eau.");
				primaryStage.setScene(scene);
				primaryStage.getIcons().add(new Image("/Image/Logo5.png"));
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
