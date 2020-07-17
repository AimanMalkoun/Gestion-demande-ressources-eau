package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionClass {
	public Connection connection;

	public Connection getConnection() {
		String dbName = "tutoimage";
		String userName = "root";
		String password = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, userName, password);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return connection;
	}
}
