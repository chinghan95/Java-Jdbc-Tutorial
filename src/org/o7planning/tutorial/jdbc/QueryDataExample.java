/**
 * ResultSet is a Java object returned when you query data. 
 * Using ResultSet.next() for moving the cursor to the next records (Move by row). 
 * In a particular record, you use ResultSet.getXxx() methods for getting values in columns. 
 * Columns are arranged in ordinal number (1, 2, 3...).
 */
package org.o7planning.tutorial.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.o7planning.tutorial.jdbc.ConnectionUtils;

public class QueryDataExample {
	
	public static void main(String[] args) throws ClassNotFoundException,
					SQLException {
		
		// Get Connection
		Connection connection = ConnectionUtils.getMyConnection();
		
		// Create statement
		// Encapsulates an SQL statement which is passed to the database to be parsed, compiled, planned and executed.
		Statement statement = connection.createStatement();
		
		String sql = "Select EMP_ID, EMP_NO, EMP_NAME from Employee";
		
		// Execute SQL statement returns a ResultSet object
		// The ResultSet represents set of rows retrieved due to query execution
		ResultSet rs = statement.executeQuery(sql);
		
		// Fetch on the ResultSet
		// Move the cursor to the next record
		while(rs.next()) {
			int empId = rs.getInt(1);
			String empNo = rs.getString(2);
			String empName = rs.getNString("Emp_NAME");
			System.out.println("-------------");
			System.out.println("EmpId:" + empId);
			System.out.println("EmpNo:" + empNo);
			System.out.println("EmpName:" + empName);
		}
		
		// Close connection
		connection.close();
		
	}
}
