package Classes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DeleteAlert {
	

	private static boolean result = false;
	
	public static boolean desplay() {
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		Button yesButton = new Button("oui"), noButton = new Button("No");
		yesButton.setPrefSize(60, 30);
		noButton.setPrefSize(60, 30);

		Label messageLabel = new Label("Voulez vous supprimer ce dossier!");
		
		//choose file
		yesButton.setOnMouseClicked(e -> {
				result = true;
				window.close();
			});
		
		noButton.setOnMouseClicked(e -> {
			result = false;
			window.close();
		});

		//Creating scene
		HBox layout = new HBox(30);
		layout.getChildren().addAll(yesButton, noButton);
		layout.setAlignment(Pos.CENTER);
		
		VBox root = new VBox(20, messageLabel, layout);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25, 25, 15, 25));
		
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.setTitle("confirmation du suppression");
		window.getIcons().add(new Image("/Image/Logo5.png"));
		window.showAndWait();
		
		return result;
	}
}
