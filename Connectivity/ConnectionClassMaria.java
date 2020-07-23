package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClassMaria {
	public Connection connection;

	public ConnectionClassMaria(){
		String dbName = "gestiondeamndeeau";
		String userName = "root";
		String password = "";

		try {
			connection = (Connection) DriverManager.getConnection("jdbc:sqlite:src\\SQLiteDB\\gestiondeamndeeau.sqlite");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
