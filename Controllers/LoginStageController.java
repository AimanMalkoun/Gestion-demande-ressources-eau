package Controllers;

import javax.swing.JOptionPane;

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
	    		a.setTitle("Mot de passe erone");
	    		a.setContentText("Vous avez un entrer un mot de passe faux");
	    		a.showAndWait();
	    	}
				
	    }
	    
}
