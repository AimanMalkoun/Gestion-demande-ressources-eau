package alerts;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DeleteFailedAlert {

public static void desplay() {
		
		Stage window = new Stage();
		window.setResizable(false);
		window.initModality(Modality.APPLICATION_MODAL);

		Label messageLabel = new Label("\u0628\u0639\u0636 \u0645\u0644\u0641\u0627\u062a \u0627\u0644\u0070\u0064\u0066 \u0645\u0641\u062a\u0648\u062d\u0629 \u0628\u0628\u0631\u0646\u0627\u0645\u062c \u0622\u062e\u0631\u002c \u0627\u0644\u0645\u0631\u062c\u0648 \u0625\u063a\u0644\u0627\u0642\u0647\u0627 \u0623\u0648\u0644\u0627");

		//Creating scene
		StackPane root = new StackPane(messageLabel);
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(40, 40, 40, 40));
		
		Scene scene = new Scene(root);
		window.setScene(scene);
		window.setTitle("\u062a\u0623\u0643\u064a\u062f \u062d\u0630\u0641 \u0627\u0644\u0645\u0644\u0641");
		window.getIcons().add(new Image("/Image/Logo5.png"));
		window.showAndWait();
		window.centerOnScreen();
		
	}
	
}
