package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionClass {
public Connection connection;
	public Connection getConnection() {
		String dbName = "gestiondeamndeeau";
		String userName = "root";
		String password = "";

		try {
			 connection = DriverManager.getConnection("jdbc:sqlite:../SQLiteDB/gestiondeamndeeau.sqlite");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
}
