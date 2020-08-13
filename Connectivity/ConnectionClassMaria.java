package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClassMaria {
	public Connection connection;

	public ConnectionClassMaria(){

		try {
			Class.forName("org.sqlite.JDBC");
			connection = (Connection) DriverManager.getConnection("jdbc:sqlite:src/SQLiteDB/gestiondeamndeeau.sqlite");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
