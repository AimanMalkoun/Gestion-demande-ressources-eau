package Connectivity;

import java.sql.Connection;

public class ConnectionClassDossier {

	private Connection connection;
	public ConnectionClassDossier() {
		// TODO Auto-generated constructor stub
	}
	
	//getters and setters
	public Connection getConnection() {
		return connection;
	}
	public void setConnectTo(Connection connection) {
		this.connection = connection;
	}

}
