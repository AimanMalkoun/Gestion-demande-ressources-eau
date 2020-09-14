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
	public static String dbHost;
	public static String dbName;
	public static String userName;
	public static String password;
	
	public static Connection getConnectionLocal() throws SQLException {
	
		if(sqliteConnection == null)
			sqliteConnection =  DriverManager.getConnection("jdbc:sqlite:SQLiteDB/gestiondeamndeeau.sqlite");
		
		return sqliteConnection;
	}
	
	public static Connection getConnectionGlobal() throws  SQLException, ClassNotFoundException {

		String filePath = ConnectionClass.class.getClassLoader().getResource("database").getPath() + "/host.txt";
		File file = new File(filePath); 
	    Scanner sc;
		try {
			sc = new Scanner(file);
		    sc.useDelimiter("\\Z");

		    dbHost = sc.nextLine();
		    dbName = sc.nextLine();
		    userName = sc.nextLine();
		    password = sc.nextLine();
		    password = password.equals(" ") ? "" : password;
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
			Class.forName("com.mysql.jdbc.Driver");
			sqlConnection = DriverManager.getConnection("jdbc:mysql://"+ dbHost + "/" + dbName, userName, password);

		return sqlConnection;
	}
}
