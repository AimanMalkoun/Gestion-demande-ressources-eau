package Connectivity;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionClass {
	
	public Connection connection;
	
	public Connection getConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			 connection = DriverManager.getConnection("jdbc:sqlite:src/SQLiteDB/gestiondeamndeeau.sqlite");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
}
