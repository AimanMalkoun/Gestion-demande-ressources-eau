package Classes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangeChoiceAlert {
	
	static String result = null;
	
	public static String desplay(String title, String[] items, String selectedValue) {
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		ChoiceBox<String> input = new ChoiceBox <String>();
		input.setPrefSize(150, 30);
		for(String e : items)
		  input.getItems().add(e);
		input.setValue(selectedValue);
		
		Button okButton = new Button("\u062a\u0623\u0643\u064a\u062f"), annulerButton = new Button("\u0625\u0644\u063a\u0627\u0621");
		
		okButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white");
		annulerButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white");
		
		//Handeling actions
		okButton.setOnMouseClicked(e -> {
				result = input.getValue();
				window.close();
		});
				
		annulerButton.setOnMouseClicked(e -> {
			result = null;
			window.close();
		});
		
		input.setOnKeyPressed(event -> {

			if(event.getCode().equals(KeyCode.ENTER)) {
				result = input.getValue();
				window.close();
			}
		});
		
		window.setOnCloseRequest(e -> {
			result = null;
		});
				
				
		//Creating scene
		HBox layout = new HBox(30);
		layout.getChildren().addAll(annulerButton, okButton);
		layout.setAlignment(Pos.CENTER);
		
		VBox root = new VBox(10);
		root.getChildren().addAll(input, layout);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25, 25, 15, 25));
		
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.setTitle(title);
		window.getIcons().add(new Image("/Image/Logo5.png"));
		window.showAndWait();
		window.centerOnScreen();
		
		return result;
		
	}
}
