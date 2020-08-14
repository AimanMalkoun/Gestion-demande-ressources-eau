package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	
	//public Connection connection;
	public String dbName = "gestiondeamndeeauglobal";
	public String userName = "root";
	public String password = "";
	
	public Connection getConnectionLocal() {
	
		try {
			 return DriverManager.getConnection("jdbc:sqlite:src/SQLiteDB/gestiondeamndeeau.sqlite");
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Connection getConnectionGlobal() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, userName, password);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}
