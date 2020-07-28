package Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Classes.PasswordChange;
import Connectivity.ConnectionClass;
import Connectivity.ConnectionClassMaria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChangePasswordController {
	
	private String realPassword;
	
	@FXML
    private TextField previousPassword;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField confirmedPassword;
    @FXML
    private Label passwordMessage_2;
    @FXML
    private Label passwordMessage_1;
    @FXML
    private Label succMessage;

    @FXML
    void changePasswordConfirmation(ActionEvent event){
    	

		ConnectionClass conn = new ConnectionClass();
		Connection connection = conn.getConnection();
		
    	
    	try {
    		Statement statement = connection.createStatement();
	    	ResultSet query = statement.executeQuery("SELECT * FROM `login` ;");
	    	
	    	
	    	while(query.next())
			{
				realPassword = query.getString("Password");
			}
	    	if(realPassword.equals(previousPassword.getText())){// && newPassword.getText().equals(confirmedPassword.getText()))
	    	    	if(newPassword.getText().equals(confirmedPassword.getText())) {
	    	    		if(PasswordChange.lengthMethode(newPassword.getText())) {
	    	    			statement.executeUpdate("update Login set Password = '" + newPassword.getText() + "' where password = '" + previousPassword.getText() + "';");
	    	    			succMessage.setText("\u062a\u0645 \u062a\u063a\u064a\u0631 \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u0628\u0646\u062c\u0627\u062d");
	    	    		}
	    	    		else
	    	    			passwordMessage_2.setText("\u064a\u062c\u0628 \u0623\u0646 \u062a\u0643\u0648\u0646 \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u0628\u064a\u0646 \u0035\u002d\u0031\u0035 \u062d\u0631\u0641\u064b\u0627");
	    	    	}
	    	    	else
	    	    		passwordMessage_2.setText("\u062a\u0623\u0643\u064a\u062f \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u062e\u0627\u0637\u0626");
	    	}
	
	    	else{
	    		passwordMessage_1.setText("\u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u0627\u0644\u0633\u0627\u0628\u0642\u0629 \u062e\u0627\u0637\u0626\u0629");
	    	}
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    	}

    }

    @FXML
    void disconnect(ActionEvent event) {

		try {
			
			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("../Fxml/LoginStage.fxml"));
			Parent LoginRoot = loader.load();
			
			Scene LoginScene = new Scene(LoginRoot);
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			primaryStage.setScene(LoginScene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
    	
    	Parent dashboardRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
		Scene dashboardScene = new Scene(dashboardRoot);
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(dashboardScene);
		
    }
}
