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

public class ExitApplication {
	/* methode to display Pop up window */
	static boolean answer = false;
	public static boolean displayExitApplication() {
		

		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		Button yesButton = new Button("\u0646\u0639\u0645");
		Button noButton = new Button("\u0644\u0627");
		
		yesButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white;");
		yesButton.setPadding(new Insets(5));
		noButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white;");
		noButton.setPadding(new Insets(5, 12, 5, 12));
		
		Label message1 = new Label();
		message1.setAlignment(Pos.CENTER);
		message1.setStyle("-fx-text-fill: #2b4067; -fx-font-size: 14px");
		yesButton.setOnMouseClicked(e -> {
			answer = true;
			window.close();
		});
		noButton.setOnMouseClicked(e -> {
			answer = false;
			window.close();
		});
		message1.setText(
				"\u0647\u0644 \u062d\u0642\u0627 \u062a\u0631\u064a\u062f \u0627\u0644\u062e\u0631\u0648\u062c \u061f");

		HBox hbox = new HBox(50);
		hbox.getChildren().addAll(noButton, yesButton);
		hbox.setAlignment(Pos.CENTER);
		
		VBox root = new VBox(30);
		root.getChildren().addAll(message1, hbox);

		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25, 25, 25, 25));
		Scene scene = new Scene(root, 200, 100);
		window.setScene(scene);
		window.setTitle("\u0627\u0644\u062e\u0631\u0648\u062c \u0645\u0646 \u0627\u0644\u062a\u0637\u0628\u064a\u0642");
		window.getIcons().add(new Image("/Image/Logo5.png"));
		window.showAndWait();
		window.centerOnScreen();
		
		return answer;
	}

}
