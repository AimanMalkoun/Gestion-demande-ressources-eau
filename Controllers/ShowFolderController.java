package Controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connectivity.ConnectionClassMaria;
//import Pages.FolderSearch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ShowFolderController{
	
    
    static String cinToModify;

    @FXML
    private Label folderId;

    @FXML
    private Label cinDemandeur;

    @FXML
    private Label nomComplet;
	
	@FXML
    private TextField cinInputSearch;

    @FXML
    void SearchFolderUsingCin(ActionEvent event) {
    	
    	ConnectionClassMaria conection =  new ConnectionClassMaria(); 
    	
		try {
			Statement statement = conection.connection.createStatement();
	    	ResultSet query;
			query = statement.executeQuery("select `IdDossier`,`nom` || ' ' || `prenom` as 'nom complet', `cin` from dossier where `cin`= '" + cinInputSearch.getText()+ "'");
			while(query.next())
			{
				folderId.setText(query.getString("IdDossier"));
				nomComplet.setText(query.getString("nom complet"));
				cinDemandeur.setText(query.getString("cin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        }  

    @FXML
    void showFolderUsingCin(ActionEvent event) {

    }
    
    @FXML
    void modifySelectedFolder(MouseEvent event) throws IOException {
    	if (folderId.getText().contentEquals("") || nomComplet.getText().contentEquals("") || cinDemandeur.getText().contentEquals(""))
    	{
    	}
    	else
    	{
    		Statement statement;
			try {
		    	ConnectionClassMaria conection =  new ConnectionClassMaria(); 				
				statement = conection.connection.createStatement();
				ResultSet query = statement.executeQuery("select `IdDossier` from dossier where `cin`= '" + cinInputSearch.getText()+ "'");
				while(query.next())
				{
					FXMLLoader loader= new FXMLLoader();
					loader.setLocation(getClass().getResource("../Fxml/afficher-un-dossier.fxml"));
					Parent showFolderInfo = loader.load();
					
					DisplayFolderController nextControler = loader.getController();
					nextControler.setMessage(query.getInt("IdDossier"));
					
					Scene showFolderInfoScene = new Scene(showFolderInfo);
					Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
					primaryStage.setScene(showFolderInfoScene);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
    		
    	}
    }
    
    @FXML
    void disconnect(ActionEvent event) {
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.close();
    }
    
    @FXML
    void changePassword(ActionEvent event) throws IOException {
    	Parent ChangePasswordRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/ChangePassword.fxml"));
		Scene ChangePasswordScene = new Scene(ChangePasswordRoot);
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(ChangePasswordScene);
    }
    
    @FXML
    void goToHome(ActionEvent event) throws IOException {
    	Parent dashboardRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
		Scene dashboardScene = new Scene(dashboardRoot);
		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		primaryStage.setScene(dashboardScene);
    }
    
  
}
