package Classes;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangeFileAlert {
	
	static File result = null;
	
	public static File desplay(String title) {
		
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		Button input = new Button("Choisir un fichier");
		input.setPrefSize(150, 30);

		Label path = new Label("");
		path.setStyle("-fx-font-color: red");
		
		//choose file
		input.setOnMouseClicked(e -> {
			
				FileChooser fc = new FileChooser();
				fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("image/pdf/docx", "*.jpg", "*.png", "*.pdf", "*.docx"));
				File file = fc.showOpenDialog(new Stage());
				
				if(file != null) {
					path.setText(file.getPath());
					result = file;
				}
				
			});
		
		Button okButton = new Button("OK"), annulerButton = new Button("annuler");
		
		//Handling buttons actions
		
		okButton.setOnMouseClicked(event -> {
			window.close();
		});
		
		annulerButton.setOnMouseClicked(e -> {
			result = null;
			window.close();
		});
		
		window.setOnCloseRequest(e -> {
			result = null;
		});
		
		//Creating scene
		HBox layout = new HBox(30);
		layout.getChildren().addAll(annulerButton, okButton);
		layout.setAlignment(Pos.CENTER);
		
		VBox root = new VBox(10);
		root.getChildren().addAll(input, path, layout);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25, 25, 15, 25));
		
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.setTitle(title);
		window.showAndWait();
		
		return result;
		
	}
}
