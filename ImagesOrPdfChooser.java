
import java.io.File;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ImagesOrPdfChooser {
	
	public static File result;
	
	public static void desplay(String title, String fileName) {
		
		result = null;
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		Button inputImages = new Button("\u0645\u062c\u0645\u0648\u0639\u0629 \u0635\u0648\u0631"), inputPdf = new Button("\u0645\u0644\u0641 pdf");
		inputImages.setPrefSize(150, 30);
		inputPdf.setPrefSize(150, 30);

		Label pathLabel = new Label("");
		pathLabel.setStyle("-fx-font-color: red");
		
		//choose file
		inputImages.setOnMouseClicked(e -> {

				window.close();
				FileChooser fc = new FileChooser();
				fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("images", "*.jpg", "*.png"));
				List<File> images = fc.showOpenMultipleDialog(new Stage());
				
				if(images != null && !images.isEmpty()) {
					
					result = CreatePdfWithImages.createPdf(images, fileName);
					
				}
			});
		
		inputPdf.setOnMouseClicked(e -> {

			window.close();
			FileChooser fc = new FileChooser();
			fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("pdf", "*.pdf"));
			result  = fc.showOpenDialog(new Stage());
			
		});
		
		window.setOnCloseRequest(e -> {
			result = null;
		});
		

		//Creating scene
		HBox layout = new HBox(30);
		layout.getChildren().addAll(inputImages, inputPdf);
		layout.setAlignment(Pos.CENTER);

		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(25, 25, 15, 25));
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.setTitle(title);
		window.getIcons().add(new Image("Image/Logo5.png"));
		window.showAndWait();
		
		
	}
}
