package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import alerts.DeleteConfirmationAlert;
import alerts.WarningAlert;
import Classes.FolderTable;
import Connectivity.ConnectionClass;
import Connectivity.ConnectionClassDossier;
import javafx.beans.binding.Bindings;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ModifyFolder2Controller implements Initializable{
	
	Thread th = new Thread();
	Task<Void> task;
	
	@FXML
    private BorderPane rootPane;
	
    @FXML
    private TableView<FolderTable> tableInfo;
    
	@FXML
    private TextField cinInputSearch;

    @FXML
    private TableColumn<FolderTable, String> cinColumn;

    @FXML
    private TableColumn<FolderTable, String> nomCompletColumn;
    @FXML
    private TableColumn<FolderTable, String> typeDemandeCl;
    @FXML
    private TableColumn<FolderTable, String> dateDepot;

    @FXML
    void goToHome(ActionEvent event) throws IOException {

		if (th.isAlive()) 
			task.cancel();
		
    	Parent root = FXMLLoader.load(getClass().getResource("../Fxml/Dashboard.fxml"));
    	Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	Scene dashBoard = new Scene(root, primaryStage.getWidth(), primaryStage.getHeight());
    	primaryStage.setScene(dashBoard);
    }

    @FXML
    void searchForFile(MouseEvent event) {
    	
    	search();
    	
    }

    @FXML
    void handlEnterAction(KeyEvent event) {

    	if(event.getCode().equals(KeyCode.ENTER))
    		search();
    	
    }
    
    
    private void search() {

    	if(!cinInputSearch.getText().isEmpty()) {
        	boolean answer = getFolderInfo(cinInputSearch.getText());
        	if(!answer) {
        		WarningAlert.desplay("\u062a\u0646\u0628\u064a\u0647", "\u0644\u0627 \u064a\u0648\u062c\u062f \u0647\u0630\u0627 \u0627\u0644\u0631\u0642\u0645");
        		cinInputSearch.setText("");
        	}
    	}
    }
    
    
    @FXML
    void disconnect(ActionEvent event) throws IOException {

		if (th.isAlive()) 
			task.cancel();
		
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
    	
    	getFolderInfo();
    	
    }
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//delete temporary files
		File directory = new File(EnregistrerController.class.getClassLoader().getResource("tempFiles").getPath());
    	if(directory.listFiles().length > 0)
    		for (File file : directory.listFiles())
    			if(!file.delete())System.out.println("file :" + file.getName() + " not deleted");;
		
    	setTableColumns();
    	tableInfo.setPlaceholder(new Label(""));
    	
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

		if (th.isAlive()) 
			task.cancel();
		
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
			
			if (!th.isAlive()) {
			
				//first let the user confirm the delete order
				if(DeleteConfirmationAlert.desplay()) {
					FolderTable folder = row.getItem();
			
					//remove folder from dataBase
					ConnectionClassDossier connection = new ConnectionClassDossier();
					int result = connection.removeFolder(folder.getId());

					if(result > 0) {
						//remove folder from tableView
						System.out.println(folder.getId());
						if(tableInfo.getItems().remove(folder))
							System.out.println("row removed from table");
					}
				}
			}
				
		}
		

		//this method riderects to modifyFolderIni.fxml in order to modify folder in the dataBase
		private void modifyRow(TableRow<FolderTable> row, ActionEvent event) {

			if (!th.isAlive()){
			
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
				
					e.printStackTrace();
				}
			}
		}

	
	//this method return the table items as observabaleList of type FolderTable
		
	private void getFolderInfo(){
		
		if (th.isAlive())
			task.cancel();
			
		
		tableInfo.getItems().clear();
		task = new Task<Void>() {
		    					@Override 
		    					protected Void call() throws Exception, SQLException {
		    						
		    						ConnectionClass conection =  new ConnectionClass(); 
		    				    	
		    						Statement statement = conection.getConnection().createStatement(), statement2 = conection.getConnection().createStatement();
		    						ResultSet result;
		    						result = statement.executeQuery("SELECT `IdDossier` FROM `dossier` ORDER BY IdDossier DESC");
		    						while(result.next())
		    						{

		    							if(this.isCancelled()) {
		    								statement2.close();
		    								result.close();
		    								statement.close();
		    								conection.getConnection().close();
		    								System.out.println("canceled!");
		    								break;
		    							}
		    							String sql = "SELECT `nom`, `prenom` , `cin`, `typeDemande`, `idDossierYear` FROM `dossier` WHERE `IdDossier`= " + result.getInt("IdDossier");
		    							
		    							ResultSet result2 = statement2.executeQuery(sql);
		    							tableInfo.getItems().add( new FolderTable(result.getInt("idDossier"), result2.getString("idDossierYear"), result2.getString("typeDemande"), result2.getString("cin"),  result2.getString("nom") + " " + result2.getString("prenom")) );

			    						statement2.close();
			    						result2.close();
		    						}
    								result.close();
    								statement.close();
    								conection.getConnection().close();
		    						
		    						return null;
		    					}
					};
		th = new Thread(task);
		th.setDaemon(true);
		th.start();
	}
	
	private boolean getFolderInfo(String idDossierYear){
		
		tableInfo.getItems().clear();
		
		ConnectionClass conection =  new ConnectionClass(); 
    	
		try {
			
			Statement statement = conection.getConnection().createStatement();
	    	ResultSet result;
			result = statement.executeQuery("SELECT `IdDossier`,`nom`, `prenom` , `cin`, `typeDemande`, `idDossierYear` FROM `dossier` WHERE idDossierYear = '" + idDossierYear + "'");
			while(result.next())
			{
				tableInfo.getItems().add( new FolderTable(result.getInt("IdDossier"),result.getString("idDossierYear") ,result.getString("typeDemande"), result.getString("cin"),  result.getString("nom") + " " + result.getString("prenom")) );
				return true;
			}
			
			conection.getConnection().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	private void setTableColumns() {

    	dateDepot.setText("\u0631\u0642\u0645 \u0627\u0644\u0645\u0644\u0641");
    	dateDepot.setCellValueFactory(new PropertyValueFactory<>("dateDepot"));

    	cinColumn.setText("\u0631\u0642\u0645 \u0628\u0637\u0627\u0642\u0629 \u0627\u0644\u062a\u0639\u0631\u064a\u0641 \u0627\u0644\u0648\u0637\u0646\u064a\u0629");
    	cinColumn.setCellValueFactory(new PropertyValueFactory<>("cin"));

    	nomCompletColumn.setText("\u0627\u0644\u0627\u0633\u0645 \u0627\u0644\u0643\u0627\u0645\u0644");
    	nomCompletColumn.setCellValueFactory(new PropertyValueFactory<>("nomPrenom"));
    	
    	typeDemandeCl.setText("\u0646\u0648\u0639 \u0627\u0644\u0637\u0644\u0628");
    	typeDemandeCl.setCellValueFactory(new PropertyValueFactory<>("typeDemande"));
    	
	} 
	
}
