package matrouhTest;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.io.FilenameUtils;

import Connectivity.ConnectionClass;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;

public class Test extends Application{
		
	public static void main(String[] args) {
		launch(args);
	}
	
	   @Override
	    public void start(Stage primaryStage) throws Exception {
			
	        ProgressIndicator pb = new ProgressIndicator();
	        pb.setVisible(false);
	        pb.setProgress(0f);
	        
	        
	        Task<Void> task = new Task<Void>() {
	            @Override
	            protected Void call() throws Exception {
	                new AnotherClass().doHeavyCalculations(this, pb);
	                return null;
	            }
	        };
	        
			//test.start(baseFile, journalFile);
			/*Connection con = DriverManager.getConnection("jdbc:sqlite:SQLiteDB/gestiondeamndeeau.sqlite");
			System.out.println("begining!");
			if(con.createStatement().execute(""
										   + "VACUUM; "
										   + ""))
				System.out.println("succceed!");
			else
				System.out.println("not succceed!");
			System.out.println("end!");
	        System.exit(0);*/
	        
	        
	        Button start = new Button("Start");
	        start.setOnMouseClicked(event -> new Thread(task).start());

	        Button cancel = new Button("Cancel");
	        cancel.setOnMouseClicked(event -> task.cancel());

	        primaryStage.setScene(new Scene(new HBox(30, start, cancel, pb), 300, 150));
	        primaryStage.show();
	    }

	   
	   
	    private class AnotherClass {

	        public void doHeavyCalculations(Task<Void> task, ProgressIndicator pb) {
	        	float progress =  0f;
	            while (true) {
	                if (task.isCancelled()) {
	                    System.out.println("Canceling...");
	                    pb.setVisible(false);
	                    break;
	                } else {
	                    System.out.println("Working..." + progress);
		            	progress += 1f;
		            	pb.setVisible(true);
		            	pb.setProgress(progress/100);
		            	try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
		            	if (progress > 100)
		            		task.cancel();
	                }
	            }
	        }

	    }

	}
