package Controllers;

import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class DashboardController {


    @FXML
    void CreateNewFolder(MouseEvent event) {
    	System.out.println("new folder created");
    }

    @FXML
    void ModifyExistingFolder(MouseEvent event) {
    	System.out.println("folder modified");
    }
}
