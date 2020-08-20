
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import Classes.PasswordChange;
import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ForgotPassWordController {
	@FXML
	private PasswordField backUpPassword;
	@FXML
	private Label backUpMessage;
	@FXML
	private PasswordField NewPassword;
	@FXML
	private PasswordField confermPassword;
	@FXML
	private Label errorChange;
	private final String backUpKey = "Eau_Safi_2020";
	
	
	@FXML
	public void backToLoginPage(MouseEvent event) throws IOException {
		
		Parent root = FXMLLoader.load(getClass().getResource("Fxml/LoginStage.fxml"));
		Stage primaryStage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getHeight()));
	}
	
	// Event Listener on Button.onAction
	@FXML
	public void updatePasswordHandler(ActionEvent event) throws SQLException, IOException {
		if(backUpPassword.getText().equals(backUpKey)) {
			if(NewPassword.getText().equals(confermPassword.getText())) {
				if(PasswordChange.lengthMethode(NewPassword.getText())) {
					ConnectionClass conn = new ConnectionClass();
					Connection connection = conn.getConnectionLocal();
					Statement statement = connection.createStatement();
					statement.executeUpdate("UPDATE `login` SET `Password`='"+ NewPassword.getText() +"'");
					
										/* Pop up window */
					
					PasswordChange.displayPopUpWindow();
					
										/* back to the login page*/	
					
					Parent root = FXMLLoader.load(getClass().getResource("Fxml/LoginStage.fxml"));
					Stage primaryStage  = (Stage) ((Node) event.getSource()).getScene().getWindow();
					primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getHeight()));
				}
				else
					errorChange.setText("\u064a\u062c\u0628 \u0623\u0646 \u062a\u0643\u0648\u0646 \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u0628\u064a\u0646 \u0035\u002d\u0031\u0035 \u062d\u0631\u0641\u064b\u0627");
			}
			else
				errorChange.setText("\u062a\u0623\u0643\u064a\u062f \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u062e\u0627\u0637\u0626");
		}
		else
			backUpMessage.setText("\u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u0627\u0644\u0627\u062d\u062a\u064a\u0627\u0637\u064a\u0629  \u062e\u0627\u0637\u0626\u0629");
	}
}
