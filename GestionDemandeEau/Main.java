package GestionDemandeEau;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws IOException {
		try {

			/*
			 * This is the section for the Login. It is the first window (stage) that the
			 * user sees He is asked to type his password.
			 * 
			 * the password is then compared to the database password.
			 * 
			 * if it is the same the user gets access to his dashboard if it is not the
			 * right password he ges an error message
			 * 
			 */

			Parent loginRoot = (Parent) FXMLLoader.load(getClass().getResource("../Fxml/LoginStage.fxml")); // load the
																											// scene in
																											// root
			Scene loginScene = new Scene(loginRoot);
			primaryStage.setTitle("\u0625\u062f\u0627\u0631\u0629 \u0637\u0644\u0628\u0627\u062a \u0627\u0644\u062a\u0631\u062e\u064a\u0635 \u0644\u0627\u0633\u062a\u062e\u062f\u0627\u0645 \u0627\u0644\u0645\u0648\u0627\u0631\u062f \u0627\u0644\u0645\u0627\u0626\u064a\u0629");
			primaryStage.setScene(loginScene);

			primaryStage.getIcons().add(new Image("/Image/Logo5.png"));
			primaryStage.show();
			primaryStage.centerOnScreen();

		} catch (Exception e) {
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