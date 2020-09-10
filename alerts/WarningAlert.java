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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WarningAlert {
	static boolean answer = false;
	public static void desplay(String title, String message) {
			
			Stage window = new Stage();
			window.setResizable(false);
			window.initModality(Modality.APPLICATION_MODAL);
	
			//creating nodes
			Label messageLabel = new Label(message);
			messageLabel.setStyle("-fx-text-fill: #2b4067");
			
			Button okButton = new Button("\u062d\u0633\u0646\u0627");
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
			
			GridPane.setHalignment(okButton, HPos.CENTER);
			
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
	public static void desplay(String title, String message, String message2, String titleButton) {
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		//creating nodes
		Label messageLabel = new Label(message);
		messageLabel.setAlignment(Pos.CENTER);
		messageLabel.setStyle("-fx-text-fill: #2b4067; -fx-font-size: 14px");
		
		Label messageLabe2 = new Label(message2);
		messageLabe2.setAlignment(Pos.CENTER);
		messageLabe2.setStyle("-fx-text-fill: #2b4067; -fx-font-size: 14px");
		
		Button okButton = new Button(titleButton);
		okButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white");
		okButton.setPrefWidth(50);
		okButton.setPrefHeight(30);
		okButton.setCursor(Cursor.HAND);
		
		//handling action events
		okButton.setOnMouseClicked(e -> {
			window.close();
		});

		//Creating the root node
		VBox root = new VBox(20);
		root.getChildren().addAll(messageLabel, messageLabe2, okButton);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25, 25, 25, 25));
		
		//Creating the  scene.
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.setTitle("\u0627\u0646\u062a\u0628\u0627\u0647" );
		window.getIcons().add(new Image("/Image/Logo5.png"));
		window.showAndWait();
		window.centerOnScreen();
		
	}
	public static boolean displayChoice() {
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);
	
		Button yesButton = new Button("\u0646\u0639\u0645"), noButton = new Button("\u0644\u0627");
		
		yesButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white;");
		yesButton.setPrefWidth(40);
		noButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white;");
		noButton.setPrefWidth(40);;
		
	
		yesButton.setOnMouseClicked(e -> {
			answer = true;
			window.close();
		});
		noButton.setOnMouseClicked(e -> {
			answer = false;
			window.close();
		});
		
		
		Label message1 = new Label();
		message1.setText("\u0644\u0642\u062f \u0646\u0633\u064a\u062a \u062a\u062d\u0645\u064a\u0644 \ufeed\ufebb\ufede \u0627\u0644\u0625\ufef3\ufeaa\ufe8d\ufec9!");
		message1.setAlignment(Pos.CENTER);
		message1.setStyle("-fx-text-fill: #2b4067; -fx-font-size: 14px");
		
		Label message2 = new Label();
		message2.setText("\u0647\u0644 \u062a\u0631\u063a\u0628 \u0628\u062a\u062d\u0645\u064a\u0644\u0647\u061f");
		message2.setAlignment(Pos.CENTER);
		message2.setStyle("-fx-text-fill: #2b4067; -fx-font-size: 14px");
		
		HBox hbox = new HBox(50);
		hbox.getChildren().addAll(noButton, yesButton);
		hbox.setAlignment(Pos.CENTER);
		
		VBox root = new VBox(15);
		root.getChildren().addAll(message1, message2, hbox);
	
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25, 25, 25, 25));
		Scene scene = new Scene(root);
		
		window.setScene(scene);
		window.setTitle("\u0627\u0646\u062a\u0628\u0627\u0647" );
		window.getIcons().add(new Image("/Image/Logo5.png"));
		window.showAndWait();
		window.centerOnScreen();
		
		return answer;
	}
	
}