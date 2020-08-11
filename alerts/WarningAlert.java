package alerts;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WarningAlert {

public static void desplay(String title, String message) {
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		//creating nodes
		Label messageLabel = new Label(message);
		
		Button okButton = new Button("\u062a\u0623\u0643\u064a\u062f");
		okButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white");
		okButton.setPrefWidth(50);
		okButton.setPrefHeight(30);
		okButton.setCursor(Cursor.HAND);
		
		//handling action events
		okButton.setOnMouseClicked(e -> {
			window.close();
		});

		//Creating the root node
		GridPane layout = new GridPane();
		layout.setAlignment(Pos.CENTER);
		layout.add(messageLabel, 0, 0);
		layout.add(okButton, 0, 1);
		layout.setVgap(20);
		
		GridPane.setHalignment(okButton, HPos.RIGHT);
		
		StackPane root = new StackPane(layout);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(40, 20, 40, 20));
		root.setMinWidth(200);
		
		//creating scene
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.setTitle(title);
		window.getIcons().add(new Image("/Image/Logo5.png"));
		window.show();
		window.centerOnScreen();
		
	}
	
}
