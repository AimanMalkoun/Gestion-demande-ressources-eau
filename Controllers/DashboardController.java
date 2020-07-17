package Controllers;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DashboardController {


    @FXML
    void CreateNewFolder(MouseEvent event) throws IOException {
    	Parent deamandeurInfoRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/InformationsDuDemandeur.fxml"));
		Scene deamandeurInfoScene = new Scene(deamandeurInfoRoot);
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(deamandeurInfoScene);
    }

    @FXML
    void ModifyExistingFolder(MouseEvent event) throws IOException {
    	Parent searchModifyFolderRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/ModifyFolder.fxml"));
		Scene searchModifyFolderScene = new Scene(searchModifyFolderRoot);
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(searchModifyFolderScene);
    }
    
    @FXML
    void disconnect(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.close();
    }
}
