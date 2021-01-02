package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	
	private static Connection sqliteConnection = null; 
	

	
	public static Connection getConnectionLocal() throws SQLException {
	
		if(sqliteConnection == null)
			sqliteConnection =  DriverManager.getConnection("jdbc:sqlite:src/SQLiteDB/gestiondeamndeeau.sqlite");
		
		return sqliteConnection;
	}
	
}