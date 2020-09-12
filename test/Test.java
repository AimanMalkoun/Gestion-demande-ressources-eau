package test;

import alerts.DeleteConfirmationAlert;
import javafx.application.Application;
import javafx.stage.Stage;

public class Test extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
		if(DeleteConfirmationAlert.desplay())
			System.out.println("true");
		
	}

}
