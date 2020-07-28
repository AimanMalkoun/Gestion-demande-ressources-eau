package Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Classes.DeleteAlert;
import Classes.FolderTable;
import Connectivity.ConnectionClass;
import Connectivity.ConnectionClassDossier;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ModifyFolder2Controller implements Initializable{
	
	@FXML
    private BorderPane rootPane;
	
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
    void showFolderUsingCin(ActionEvent event) {

    }
    
    @FXML
    void goToHome(ActionEvent event) throws IOException {

    	Parent root = FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	Scene dashBoard = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());
    	primaryStage.setScene(dashBoard);
    }

    @FXML
    void searchForFile(MouseEvent event) {
    	
    	if(!cinInputSearch.getText().isEmpty()) {
        	tableInfo.setItems(getFolderInfo(cinInputSearch.getText()));
    	}
    	
    }
    @FXML
    void searchFile(ActionEvent event) {

    }
    
    @FXML
    void disconnect(ActionEvent event) throws IOException {
    	
    	Parent root = FXMLLoader.load(getClass().getResource("../Fxml/LoginStage.fxml"));
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	Scene login = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());
    	primaryStage.setScene(login);
    	
    }
    
    @FXML
    void handlTableViewAction(MouseEvent event) {

    }
    
    @FXML
    void showAllFiles(MouseEvent event) {
    	
    	tableInfo.setItems(getFolderInfo());
    	
    }
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

    	setTableColumns();
    	
	}
	

	public void setMessage(int message) {
		
		if(message == 0)  //in case of modify folder
			initializeMenuItems();
		else  //in case of show folder
			nitializeRowsForMouseClick();
		
	}
	
	private void nitializeRowsForMouseClick() {
		
		tableInfo.setRowFactory(tv -> {
			
		    TableRow<FolderTable> row = new TableRow<>();
		    row.setOnMouseClicked(event -> {
		        if (! row.isEmpty() && event.getButton() == MouseButton.PRIMARY 
		             && event.getClickCount() == 2) {

		        	FolderTable selectedFolder = row.getItem();
		            goToShowFolderPage(selectedFolder);
		        }
		    });
		    
		    return row ;
		
		});
		
	}

	private void goToShowFolderPage(FolderTable selectedFolder) {

		try {

			FXMLLoader loader= new FXMLLoader();
			loader.setLocation(getClass().getResource("../Fxml/afficher-un-dossier.fxml"));
			Parent showFolderRoot = loader.load();
			
			DisplayFolderController nextControler = loader.getController();
			nextControler.setMessage(selectedFolder.getId());
			
			Stage primaryStage = (Stage) rootPane.getScene().getWindow();
			Scene showFolderScene = new Scene(showFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
			primaryStage.setScene(showFolderScene);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	//this method is for initializing a menu to show when you click on right button of the mouse
	private void initializeMenuItems() {

		tableInfo.setRowFactory(new Callback<TableView<FolderTable>, TableRow<FolderTable>>() { 
			
	        @Override  
	        public TableRow<FolderTable> call(TableView<FolderTable>tableView) {  
	            	
	        	final TableRow<FolderTable>row = new TableRow<>();  
	        	final ContextMenu contextMenu = new ContextMenu();  
	        	final MenuItem modifyMenuItem = new MenuItem("\u062a\u0639\u062f\u064a\u0644 \u0627\u0644\u0645\u0644\u0641");  
	        	final MenuItem removeMenuItem = new MenuItem("\u062d\u0630\u0641 \u0627\u0644\u0645\u0644\u0641");  
	        
	        
	        		//handle action when you click on remove in the menu
	        		modifyMenuItem.setOnAction( event -> modifyRow(row, event) );
	        	
	        		//handle action when you click on remove in the menu
	        		removeMenuItem.setOnAction( e -> removeRow(row) );  
	                
	                
	        		contextMenu.getItems().addAll(modifyMenuItem, removeMenuItem);
	                
	        		// Set context menu on row, but use a binding to make it only show for non-empty rows:  
	        		row.contextMenuProperty().bind(  Bindings.when(row.emptyProperty())
	        											 	 .then((ContextMenu)null)
	        											 	 .otherwise(contextMenu)  
	           							   	  	   );  
	                
	        		return row ;  
	        	}
	            
	        });
		
		
	}
	
	//this method is for removing a folder from dataBase and the table items
		private void removeRow(TableRow<FolderTable> row){
			
			//first let the user confirm the delete order
			if(DeleteAlert.desplay()) {
				FolderTable folder = row.getItem();
			
				//remove folder from dataBase
				ConnectionClassDossier connection = new ConnectionClassDossier();
				int result = connection.removeFolder(folder.getId());

				if(result > 0) {
					//remove folder from tableView
					tableInfo.getItems().remove(folder);
				}
			}
				
		}
		

		//this method riderects to modifyFolderIni.fxml in order to modify folder in the dataBase
		private void modifyRow(TableRow<FolderTable> row, ActionEvent event) {

			try {

				FXMLLoader loader= new FXMLLoader();
				loader.setLocation(getClass().getResource("../Fxml/modifier les informations du dossier.fxml"));
				Parent modifyFolderRoot = loader.load();
				
				modifierInfoDuDossierController nextControler = loader.getController();
				nextControler.setMessage(row.getItem().getId());
				
				Stage primaryStage = (Stage) rootPane.getScene().getWindow();
				Scene modifyFolderScene = new Scene(modifyFolderRoot, primaryStage.getWidth(), primaryStage.getHeight());
				primaryStage.setScene(modifyFolderScene);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	
	//this method return the table items as observabaleList of type FolderTable
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
	
	private void setTableColumns() {
    	idColumn.setText("\u0631\u0642\u0645 \u0627\u0644\u0645\u0644\u0641");
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

















