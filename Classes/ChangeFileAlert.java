package Classes;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		
		//choose file
		input.setOnMouseClicked(e -> {
				FileChooser fc = new FileChooser();
				FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(*.jpg)", "*JPG");
				FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("PNG files(*.png)", "*PNG");
				FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("PDF files(*.pdf)", "*PDF");
				fc.getExtensionFilters().addAll(ext1, ext2, ext3);
				File file = fc.showOpenDialog(new Stage());
		        result = file;
			});
		
		Button okButton = new Button("OK"), annulerButton = new Button("annuler");
		
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
		window.showAndWait();
		
		return result;
		
	}
}
