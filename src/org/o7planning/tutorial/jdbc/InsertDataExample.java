/**
 * Insert a new data in database.
 */

package org.o7planning.tutorial.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.o7planning.tutorial.jdbc.ConnectionUtils;

public class InsertDataExample {

	public static void main(String[] args) throws ClassNotFoundException, 
			SQLException {

		// Get Connection 
		Connection connection = ConnectionUtils.getMyConnection();
		
		Statement statement = connection.createStatement();
		
		String sql = "Insert into Salary_Grade (Grade, High_Salary, Low_Salary)" 
				 		+ " values (2, 20000, 1000) ";
		
		// Execute statement
		// executeUpdate(String) using for Insert, Update, Delete statement.
		int rowCount = statement.executeUpdate(sql);
		
		System.out.println("Row Count affected = " + rowCount);
	}

}
