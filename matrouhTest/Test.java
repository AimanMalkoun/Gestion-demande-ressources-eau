package matrouhTest;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;

public class Test extends Application{
		
	   @Override
	    public void start(Stage primaryStage) throws Exception {
	        Task<Void> task = new Task<Void>() {
	            @Override
	            protected Void call() throws Exception {
	                new AnotherClass().doHeavyCalculations(this);
	                return null;
	            }
	        };

	        Button start = new Button("Start");
	        start.setOnMouseClicked(event -> new Thread(task).start());

	        Button cancel = new Button("Cancel");
	        cancel.setOnMouseClicked(event -> task.cancel());

	        primaryStage.setScene(new Scene(new HBox(30, start, cancel), 300, 150));
	        primaryStage.show();
	    }

	    private class AnotherClass {

	        public void doHeavyCalculations(Task<Void> task) {
	            while (true) {
	                if (task.isCancelled()) {
	                    System.out.println("Canceling...");
	                    break;
	                } else {
	                    System.out.println("Working...");
	                }
	            }
	        }

	    }

	}
