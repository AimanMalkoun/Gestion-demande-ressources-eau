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
    private Label messagePassword;

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
    			messagePassword.setText("\u062a\u0645 \u062a\u062d\u062f\u064a\u062b \u0643\u0644\u0645\u0629 \u0627\u0644\u0633\u0631 \u0628\u0646\u062c\u0627\u062d");
		}

    	else
    	{
    		Alert a = new Alert(Alert.AlertType.WARNING);
    		a.setHeaderText(null);
    		a.setTitle("\u0645\u0634\u0643\u0644\u0629 \u0641\u064a \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631");
    		a.setContentText("\u0645\u0646 \u0641\u0636\u0644\u0643 \u0627\u0639\u062f \u0627\u0644\u0645\u062d\u0627\u0648\u0644\u0629 \u0645\u0631\u0629 \u0623\u062e\u0631\u0649\u002e \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u0627\u0644\u062a\u064a \u062a\u0645 \u0625\u062f\u062e\u0627\u0644\u0647\u0627 \u062e\u0627\u0637\u0626\u0629 \u0623\u0648 \u0623\u0646 \u062a\u0623\u0643\u064a\u062f \u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u063a\u064a\u0631 \u0635\u062d\u064a\u062d");
    		a.showAndWait();
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
    	
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	Parent dashboardRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
		Scene dashboardScene = new Scene(dashboardRoot, primaryStage.getWidth(), primaryStage.getHeight());
		primaryStage.setScene(dashboardScene);
		
    }
}
