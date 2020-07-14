package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ModifyFolderController {
	
	@FXML
    private TextField cinInputSearch;

    @FXML
    void SearchFolderUsingCin(ActionEvent event) {
    	System.out.println(cinInputSearch.getText());
    }

    @FXML
    void showFolderUsingCin(ActionEvent event) {

    }

}
