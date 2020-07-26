package Controllers;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

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
    private TableColumn<FolderTable, String> typeDemandeCl;
    @FXML
    private TableColumn<FolderTable, String> dateDepot;
    @FXML
    private BorderPane bordePane;
    @FXML
    void showFolderUsingCin(ActionEvent event) {

    }
    
    @FXML
    void goToHome(ActionEvent event) throws IOException {

    	Parent root = FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
    	bordePane.getChildren().setAll(root);
    	
    }

    @FXML
    void searchForFile(MouseEvent event) {
    	
    	
    }
    @FXML
    void searchFile(ActionEvent event) {

    	
    	if(!cinInputSearch.getText().isEmpty()) {
    		dataTable();
        	tableInfo.setItems(getFolderInfo(cinInputSearch.getText()));
    	}
    }
    
    @FXML
    void disconnect(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("../Fxml/LoginStage.fxml"));
    	bordePane.getChildren().setAll(root);
    }
    
    @FXML
    void showAllFiles(MouseEvent event) {
    	
    	dataTable();
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
			result = statement.executeQuery("SELECT `IdDossier`,`nom`, `prenom` , `cin`, `typeDemande`, `DateDepot` FROM `dossier` ORDER BY IdDossier DESC");
			while(result.next())
			{
				
				folders.add( new FolderTable(result.getInt("IdDossier"), result.getDate("DateDepot"), result.getString("typeDemande"), result.getString("cin"),  result.getString("nom") + " " + result.getString("prenom")) );
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return folders;
		
	}
	
	private ObservableList<FolderTable> getFolderInfo(String cin){
		ObservableList<FolderTable> folders = FXCollections.observableArrayList();
		
		ConnectionClass conection =  new ConnectionClass(); 
    	
		try {
			Statement statement = conection.getConnection().createStatement();
	    	ResultSet result;
			result = statement.executeQuery("SELECT `IdDossier`,`nom`, `prenom` , `cin`, `typeDemande`, `DateDepot` FROM `dossier` WHERE cin = '" + cin + "'");
			while(result.next())
			{
				
				folders.add( new FolderTable(result.getInt("IdDossier"),result.getDate("DateDepot") ,result.getString("typeDemande"), result.getString("cin"),  result.getString("nom") + " " + result.getString("prenom")) );
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return folders;
		
	}
	
	private void dataTable() {
    	idColumn.setText("\u0631\u0642\u0645 \u0627\u0644\u0645\u062c\u0644\u062f");
    	idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    	
    	dateDepot.setText("\u062a\u0627\u0631\u064a\u062e \u0625\u064a\u062f\u0627\u0639 \u0627\u0644\u0645\u0644\u0641");
    	dateDepot.setCellValueFactory(new PropertyValueFactory<>("dateDepot"));

    	cinColumn.setText("\u0631\u0642\u0645 \u0628\u0637\u0627\u0642\u0629 \u0627\u0644\u062a\u0639\u0631\u064a\u0641 \u0627\u0644\u0648\u0637\u0646\u064a\u0629");
    	cinColumn.setCellValueFactory(new PropertyValueFactory<>("cin"));

    	nomCompletColumn.setText("\u0627\u0644\u0627\u0633\u0645 \u0627\u0644\u0643\u0627\u0645\u0644");
    	nomCompletColumn.setCellValueFactory(new PropertyValueFactory<>("nomPrenom"));
    	
    	typeDemandeCl.setText("\u0646\u0648\u0639 \u0627\u0644\u0637\u0644\u0628");
    	typeDemandeCl.setCellValueFactory(new PropertyValueFactory<>("typeDemande"));
	} 
}
