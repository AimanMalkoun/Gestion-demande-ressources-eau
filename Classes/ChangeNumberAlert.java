package Classes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangeNumberAlert {
	static float result = 0;
	
	public static float desplay(String promptText, String title) {
		
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		TextField input = new TextField();
		input.setPrefSize(150, 30);
		input.setPromptText(promptText);
		
		Label textError = new Label("");
		textError.setStyle("-fx-font-color: red");
		
		Button okButton = new Button("OK"), annulerButton = new Button("annuler");
		
		//Handling actions
		okButton.setOnMouseClicked(event -> {
			
			if(!input.getText().isEmpty()) {
				try {
					result = Float.parseFloat(input.getText());
					window.close();
				}catch(Exception exception) {
					input.setStyle("-fx-border-color: red;");
					textError.setText("svp inserez un valide nombre");
				}
			}else {
				input.setStyle("-fx-border-color: red;");
				textError.setText("svp inserez un nombre!");
			}
			
		});
		
		annulerButton.setOnMouseClicked(e -> {
			result = 0;
			window.close();
		});
		
		window.setOnCloseRequest(e -> {
			result = 0;
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
		window.showAndWait();
		
		return result;
		
	}
}
