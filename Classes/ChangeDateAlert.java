package Classes;

import java.time.LocalDate;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangeDateAlert {
	public static LocalDate desplay(String title, LocalDate selectedValue) {
		LocalDate result = null;
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		DatePicker input = new DatePicker();
		input.setPrefSize(150, 30);
		input.setValue(selectedValue);
		
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
