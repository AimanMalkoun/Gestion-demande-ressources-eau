package alerts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangeStringAlert {

	static String result = null;
	
	public static String desplay(String promptText, String title) {
		
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		TextField input = new TextField();
		input.setPrefSize(150, 30);
		input.setPromptText(promptText);
		
		Label textError = new Label("");
		textError.setStyle("-fx-font-color: red");
		
		Button okButton = new Button("\u062a\u0623\u0643\u064a\u062f"), annulerButton = new Button("\u0625\u0644\u063a\u0627\u0621");
		
		okButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white");
		annulerButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white");
		
		//handling actions
		okButton.setOnMouseClicked(e -> {
			
			if(!input.getText().isEmpty()) {
				result = input.getText();
				window.close();
			}else {
				input.setStyle("-fx-border-color: red;");
				textError.setText("\u0627\u0644\u0645\u0631\u062c\u0648 \u0645\u0644\u0626 \u0627\u0644\u062e\u0627\u0646\u0629 \u0628\u0645\u0627 \u064a\u0646\u0627\u0633\u0628\u0647\u0627");
			}
			
		});
		
		annulerButton.setOnMouseClicked(e -> {
			result = null;
			window.close();
		});
		
		input.setOnKeyPressed(event -> {

			if(event.getCode().equals(KeyCode.ENTER)) {
				if(!input.getText().isEmpty()) {
					result = input.getText();
					window.close();
				}else {
					input.setStyle("-fx-border-color: red;");
					textError.setText("\u0627\u0644\u0645\u0631\u062c\u0648 \u0645\u0644\u0626 \u0627\u0644\u062e\u0627\u0646\u0629 \u0628\u0645\u0627 \u064a\u0646\u0627\u0633\u0628\u0647\u0627");
				}
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
		root.getChildren().addAll(input, textError, layout);
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
