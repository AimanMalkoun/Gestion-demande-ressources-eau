package Controllers;


import java.io.File;
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
    	
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	Parent deamandeurInfoRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/InformationsDuDemandeur.fxml"));
		Scene deamandeurInfoScene = new Scene(deamandeurInfoRoot, primaryStage.getWidth(), primaryStage.getHeight());
		primaryStage.setScene(deamandeurInfoScene);
		
    }

    @FXML
    void ModifyExistingFolder(MouseEvent event) throws IOException {

		try {

			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("../Fxml/ModifyFolder2.fxml"));
			Parent showFolderRoot = loader.load();
			
			ModifyFolder2Controller nextControler = loader.getController();
			nextControler.setMessage(0);
			
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene showFolderScene = new Scene(showFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(showFolderScene);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    @FXML
    void disconnect(ActionEvent event) throws IOException {
    	
		Parent root = FXMLLoader.load(getClass().getResource("../Fxml/LoginStage.fxml"));
    	Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getHeight()));
		
    }
    
    @FXML
    void ChangePassword(ActionEvent event) throws IOException {
    	
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	Parent ChangePasswordRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/ChangePassword.fxml"));
		Scene ChangePasswordScene = new Scene(ChangePasswordRoot, primaryStage.getWidth(), primaryStage.getHeight());
		primaryStage.setScene(ChangePasswordScene);
		
    }
    
    @FXML
    void ShowFolderInformations(MouseEvent event) throws IOException {

		try {

			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("../Fxml/ModifyFolder2.fxml"));
			Parent showFolderRoot = loader.load();
			
			ModifyFolder2Controller nextControler = loader.getController();
			nextControler.setMessage(1);
			
			Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			Scene showFolderScene = new Scene(showFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(showFolderScene);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//delete temporary files
		File directory = new File(EnregistrerController.class.getClassLoader().getResource("tempFiles").getPath());
    	if(directory.listFiles().length > 0)
    		for (File file : directory.listFiles())
    			if(!file.delete())System.out.println("file :" + file.getName() + " not deleted");;
		
	}
}
