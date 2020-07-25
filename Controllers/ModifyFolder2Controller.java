package Controllers;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Classes.FolderTable;
import Connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ModifyFolder2Controller implements Initializable{


    @FXML
    private TableView<FolderTable> tableInfo;
	
	@FXML
    private TextField cinInputSearch;

    @FXML
    private TableColumn<FolderTable, Integer> idColumn;

    @FXML
    private TableColumn<FolderTable, String> cinColumn;

    @FXML
    private TableColumn<FolderTable, String> nomCompletColumn;

    @FXML
    void showFolderUsingCin(ActionEvent event) {

    }
    
    @FXML
    void goToHome(ActionEvent event) {

    }

    @FXML
    void searchForFile(MouseEvent event) {

    }
    
    @FXML
    void disconnect(ActionEvent event) {

    }
    
    @FXML
    void showAllFiles(MouseEvent event) {
    	
    	idColumn.setText("Id");
    	idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

    	cinColumn.setText("CIN");
    	cinColumn.setCellValueFactory(new PropertyValueFactory<>("cin"));

    	nomCompletColumn.setText("Nom et Prenom");
    	nomCompletColumn.setCellValueFactory(new PropertyValueFactory<>("nomPrenom"));
    	
    	tableInfo.setItems(getFolderInfo());
    	
    	
    }
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	private ObservableList<FolderTable> getFolderInfo(){
		ObservableList<FolderTable> folders = FXCollections.observableArrayList();
		
		ConnectionClass conection =  new ConnectionClass(); 
    	
		try {
			Statement statement = conection.getConnection().createStatement();
	    	ResultSet result;
			result = statement.executeQuery("select `IdDossier`,`nom`, `prenom` , `cin` from dossier");
			while(result.next())
			{
				
				folders.add( new FolderTable(result.getInt("IdDossier"), result.getString("cin"),  result.getString("nom") + " " + result.getString("prenom")) );
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return folders;
		
	}

}
