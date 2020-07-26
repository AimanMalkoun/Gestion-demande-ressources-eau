package Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DashboardController implements Initializable{


    @FXML
    void CreateNewFolder(MouseEvent event) throws IOException {
    	Parent deamandeurInfoRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/InformationsDuDemandeur.fxml"));
		Scene deamandeurInfoScene = new Scene(deamandeurInfoRoot);
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(deamandeurInfoScene);
    }

    @FXML
    void ModifyExistingFolder(MouseEvent event) throws IOException {
    	Parent searchModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/ModifyFolder2.fxml"));
		Scene searchModifyFolderScene = new Scene(searchModifyFolderRoot);
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(searchModifyFolderScene);
    }
    
    @FXML
    void disconnect(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.close();
    }
    
    @FXML
    void ChangePassword(ActionEvent event) throws IOException {
    	Parent ChangePasswordRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/ChangePassword.fxml"));
		Scene ChangePasswordScene = new Scene(ChangePasswordRoot);
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(ChangePasswordScene);
    }
    
    @FXML
    void ShowFolderInformations(MouseEvent event) throws IOException {
    	Parent ShowFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/ShowFolder.fxml"));
		Scene ShowFolderScene = new Scene(ShowFolderRoot);
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(ShowFolderScene);
    }
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
			
		
	}
}
