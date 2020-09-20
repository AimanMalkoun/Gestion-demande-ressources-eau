package Connectivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectionClass {
	
	private static Connection sqliteConnection = null; // for local connection
	private static Connection sqlConnection = null;    //for global connection
	
	//public Connection connection;
	public static String dbName = null;
	public static String userName = null;
	public static String password = null;
	
	public static Connection getConnectionLocal() throws SQLException {
	
		if(sqliteConnection == null)
			sqliteConnection =  DriverManager.getConnection("jdbc:sqlite:SQLiteDB/gestiondeamndeeau.sqlite");
		
		return sqliteConnection;
	}
	
	public static Connection getConnectionGlobal() throws  SQLException, ClassNotFoundException, FileNotFoundException {
		
			File file = new File("BdConnection.txt"); 
		    Scanner sc = new Scanner(file);
		    sc.useDelimiter("\\Z");
		    dbName = sc.nextLine();
		    userName = sc.nextLine();
		    password = sc.nextLine();
			Class.forName("com.mysql.jdbc.Driver");
			sqlConnection = DriverManager.getConnection("jdbc:"+dbName, userName, password);

		return sqlConnection;
	}
}
