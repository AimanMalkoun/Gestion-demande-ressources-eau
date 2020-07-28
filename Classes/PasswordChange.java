package Classes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PasswordChange {
	/* methode to display Pop up window */
	public static void displayPopUpWindow() {

		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		Button okButton = new Button("\u062a\u0623\u0643\u064a\u062f");
		Label message1 = new Label();
		Label message2 = new Label();

		okButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white");
		okButton.setPadding(new Insets(5));
		okButton.setOnMouseClicked(e -> {
			window.close();
		});

		message1.setAlignment(Pos.CENTER);
		message1.setStyle("-fx-text-fill: #2b4067; -fx-font-size: 14px");
		message1.setText("\u062a\u0645 \u062a\u063a\u064a\u064a\u0631 \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u0628\u0646\u062c\u0627\u062d");
		
		message2.setStyle("-fx-text-fill: #2b4067; -fx-font-size: 14px");
		message2.setText("\u064a\u0631\u062c\u0649 \u0627\u062f\u062e\u0627\u0644 \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u0627\u0644\u062c\u062f\u064a\u062f\u0629");
		message2.setAlignment(Pos.CENTER);

		VBox root = new VBox(30);
		root.getChildren().addAll(message1, message2, okButton);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25, 25, 25, 25));
		Scene scene = new Scene(root, 300, 200);
		window.setScene(scene);
		window.setTitle("\u0646\u0633\u064a\u062a \u0631\u0642\u0645\u0643 \u0627\u0644\u0633\u0631\u064a");
		window.getIcons().add(new Image("/Image/Logo5.png"));
		window.showAndWait();
		window.centerOnScreen();
	}

	public static boolean lengthMethode(String str) {
		if (str.length() <= 15 && str.length() >= 5)
			return true;
		else
			return false;
	}
}
