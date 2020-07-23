package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connectivity.*;

public class LoginStageController {
		
		private String realPassword;
	    @FXML
	    private PasswordField password;

	    @FXML
	    void login(ActionEvent event) throws SQLException, IOException 
	    {
	    	ConnectionClassMaria conection =  new ConnectionClassMaria(); 
	    	Statement statement = conection.connection.createStatement();
	    	ResultSet query = statement.executeQuery("SELECT * FROM `login` ;");
	    	
	    	while(query.next())
			{
				realPassword = query.getString("Password");
			}
	    	if(realPassword.equals(password.getText()))
	    	{
	    		Parent dashboardRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
				Scene dashboardScene = new Scene(dashboardRoot);
				Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				primaryStage.setScene(dashboardScene);
			}
	    	
	    	else
	    	{
	    		Alert a = new Alert(Alert.AlertType.WARNING);
	    		a.setHeaderText(null);
	    		a.setTitle("\u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u0644\u064a\u0633\u062a \u0635\u062d\u064a\u062d\u0629");
	    		a.setContentText("\u0647\u0645\u0645\u0645\u0645\u0645\u002c \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u0644\u064a\u0633\u062a \u0635\u062d\u064a\u062d\u0629\u002e \u0645\u0646 \u0641\u0636\u0644\u0643 \u062d\u0627\u0648\u0644 \u0645\u0631\u0629 \u0627\u062e\u0631\u0649");
	    		a.showAndWait();
	    	}
				
	    }
	    
}
