package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginStageController  implements Initializable{

	private String realPassword;
	@FXML
	private PasswordField password;
	@FXML
	private Label msgError;
	
	@FXML
	void login(ActionEvent event) throws SQLException, IOException {
		ConnectionClass conn = new ConnectionClass();
		Connection connection = conn.getConnection();
		Statement statement = connection.createStatement();
		ResultSet query = statement.executeQuery("SELECT * FROM `login`;");

		while (query.next()) {
			realPassword = query.getString("Password");
		}
		if (realPassword.equals(password.getText())) {
			Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Parent dashboardRoot = (Parent) FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
			Scene dashboardScene = new Scene(dashboardRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(dashboardScene);
		}

		else {

			msgError.setText("\u0643\u0644\u0645\u0629 \u0627\u0644\u0645\u0631\u0648\u0631 \u0644\u064a\u0633\u062a \u0635\u062d\u064a\u062d\u0629");
		
		}

	}
	
    @FXML
	void forgotPassword(MouseEvent event) throws IOException {
    	
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	Parent root = FXMLLoader.load(getClass().getResource("../Fxml/ForgotPassWord.fxml"));
    	Scene forgotPass = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());
    	primaryStage.setScene(forgotPass);
    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
