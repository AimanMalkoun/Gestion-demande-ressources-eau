package Controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connectivity.ConnectionClassMaria;
//import Pages.FolderSearch;
import javafx.collections.ObservableList;
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

public class ModifyFolderController{
	
    //ObservableList<FolderSearch> data;
    
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
			query = statement.executeQuery("select `IdDossier`,concat(nom, ' ' , prenom) as 'nom complet', `Carte d'identite National` from dossier where `Carte d'identite National`= '" + cinInputSearch.getText()+ " '");
			while(query.next())
			{
				folderId.setText(query.getString("IdDossier"));
				nomComplet.setText(query.getString("nom complet"));
				cinDemandeur.setText(query.getString("Carte d'identite National"));
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
    		Parent deamandeurInfoRoot = (Parent)FXMLLoader.load(getClass().getResource("../Fxml/ModifyFolderInfo.fxml"));
    		Scene deamandeurInfoScene = new Scene(deamandeurInfoRoot);
    		cinToModify = cinInputSearch.getText();
    		Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    		primaryStage.setScene(deamandeurInfoScene);
    	}
    }
}
