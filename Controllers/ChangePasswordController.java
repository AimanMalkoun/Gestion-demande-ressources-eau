package Controllers;

import java.sql.ResultSet;
import java.sql.Statement;
import Connectivity.ConnectionClassMaria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
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
    void changePasswordConfirmation(ActionEvent event){
    	
    	ConnectionClassMaria conection =  new ConnectionClassMaria(); 
    	try {
    	Statement statement = conection.connection.createStatement();
    	ResultSet query = statement.executeQuery("SELECT * FROM `login` ;");
    	
    	
    	while(query.next())
		{
			realPassword = query.getString("Password");
		}
    	if(realPassword.equals(previousPassword.getText()) && newPassword.getText().equals(confirmedPassword.getText()))
    	{    		
    			statement.executeUpdate("update Login set Password = '" + newPassword.getText() + "' where password = '" + previousPassword.getText() + "';");
		}

    	else
    	{
    		Alert a = new Alert(Alert.AlertType.WARNING);
    		a.setHeaderText(null);
    		a.setTitle("Problem de mot de passe");
    		a.setContentText("Veillez ressssayer. Le mot de passe entrer est faux ou la confirmation du mot de passe n'est pas correct");
    		a.showAndWait();
    	}
    }
    	catch (Exception e)
    	{
    		System.out.println("problem 1 huunn");
    	}

    }

    @FXML
    void disconnect(ActionEvent event) {
    	
    	Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.close();
    }

}