package alerts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WarningAlert {

public static void desplay(String title, String message) {
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		Button okButton = new Button("\u062a\u0623\u0643\u064a\u062f");
		Label messageLabel = new Label(message);
		okButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white");
		okButton.setPadding(new Insets(5));
		okButton.setOnMouseClicked(e -> {
			window.close();
		});

		//Creating scene
		VBox root = new VBox(30);
		root.getChildren().addAll(messageLabel, okButton);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(40, 20, 40, 20));
		
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.setTitle(title);
		window.getIcons().add(new Image("/Image/Logo5.png"));
		window.showAndWait();
		window.centerOnScreen();
		
	}
	
}
