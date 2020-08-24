package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	
	private static Connection sqliteConnection = null; // for local connection
	private static Connection sqlConnection = null;    //for global connection
	
	//public Connection connection;
	public static String dbName = "gestiondeamndeeauglobal";
	public static String userName = "root";
	public static String password = "";
	
	public static Connection getConnectionLocal() throws SQLException {
	
		if(sqliteConnection == null)
			sqliteConnection =  DriverManager.getConnection("jdbc:sqlite:src/SQLiteDB/gestiondeamndeeau.sqlite");
		
		return sqliteConnection;
	}
	
	public static Connection getConnectionGlobal() throws  SQLException, ClassNotFoundException {
			
			Class.forName("com.mysql.jdbc.Driver");
			sqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, userName, password);

		return sqlConnection;
	}
}
