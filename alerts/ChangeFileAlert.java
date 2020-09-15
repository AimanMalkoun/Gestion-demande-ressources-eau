package alerts;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import Classes.ImagesOrPdfChooser;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangeFileAlert {
	
	static File result = null;
	
	public static File desplay(String title, String filename) {
		
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		Button input = new Button("\u0627\u062e\u062a\u064a\u0627\u0631 \u0645\u0644\u0641");
		input.setCursor(Cursor.HAND);
		input.setPrefSize(150, 30);

		Label fileName = new Label("");
		fileName.setStyle("-fx-font-color: red");
		
		//choose file
		input.setOnMouseClicked(e -> {
			
			ImagesOrPdfChooser.desplay(title, filename);
			File file = ImagesOrPdfChooser.result;
				
				if(file != null) {
					System.out.println(FilenameUtils.getExtension(file.getName()));
					fileName.setText(file.getName());
					result = file;
				}
				
			});
		
		Button okButton = new Button("\u062a\u0623\u0643\u064a\u062f"), 
			   annulerButton = new Button("\u0625\u0644\u063a\u0627\u0621");
		okButton.setCursor(Cursor.HAND);
		annulerButton.setCursor(Cursor.HAND);
		
		okButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white");
		annulerButton.setStyle("-fx-background-color: #2b4067; -fx-text-fill: white");
		
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
		root.getChildren().addAll(input, fileName, layout);
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
