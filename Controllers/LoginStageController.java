package Controllers;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginStageController {

	String user = "J526319", pass = "1998";
	@FXML
	private TextField userId;

	@FXML
	private PasswordField password;

	@FXML
	void login(ActionEvent event) {
		if(user.equals(userId.getText().toString()) && pass.equals(password.getText().toString())) {
			
			JOptionPane.showMessageDialog(null, "connecté");
		}
		else {
			JOptionPane.showMessageDialog(null, "Erreur");
		}
	}

}
