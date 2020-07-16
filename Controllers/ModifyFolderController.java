package Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connectivity.ConnectionClassMaria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ModifyFolderController {
	
	@FXML
    private TextField cinInputSearch;

    @FXML
    void SearchFolderUsingCin(ActionEvent event) {
    	ConnectionClassMaria conection =  new ConnectionClassMaria(); 
    	
		try {
			Statement statement = conection.connection.createStatement();
	    	ResultSet query;
			query = statement.executeQuery("select `IdDossier`,`Nom`|| ' ' ||`Prenom` as `nom complet`, `Carte d'identite National` from dossier where `Carte d'identite National`= 'he' ;");
			while(query.next())
			{
				//realPassword = query.getString("Password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void showFolderUsingCin(ActionEvent event) {

    }

}
