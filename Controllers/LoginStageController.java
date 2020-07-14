package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginStageController {
	
	  	@FXML
	    private TextField userId;

	    @FXML
	    private PasswordField password;

	    @FXML
	    void login(ActionEvent event) {
	    	
	    	System.out.println("The username entred:" + userId.getText() + " , the password: " + password.getText());

	    }

}
