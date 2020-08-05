package org.o7planning.tutorial.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	
	// Connect to MySQL
	public static Connection getMySQLConnection() throws SQLException, 
					ClassNotFoundException {
		String hostName = "localhost";
		String dbName = "company";
		String userName = "root";
		String password = "19950817";
		return getMySQLConnection(hostName, dbName, userName, password);
	}

	private static Connection getMySQLConnection(String hostName, String dbName, 
					String userName, String password) throws SQLException, 
					ClassNotFoundException {
		
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?serverTimezone=UTC";
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}

}
