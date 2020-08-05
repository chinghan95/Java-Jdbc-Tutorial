/**
 * By default, when fetch data, the cursor only can move 
 * from top to bottom and from right to left. It means
 * that with default ResultSet you can't call:
 * 		1. ResultSet.previous() : step back a record
 * 		2. On the same record, you can't call ResultSet.getXXX(4) first, 
 * 			and then call ResultSet.getXXX(2).
 */

package org.o7planning.tutorial.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.o7planning.tutorial.jdbc.ConnectionUtils;

public class ScrollableResultSetExample {
	
	public static void main(String[] args) throws ClassNotFoundException,
					SQLException {
		
		// Get Connection
		Connection connection = ConnectionUtils.getMyConnection();
		
		// Create a statement object, can be scrolled, but not sensitive to changes under DB.
		// An intentional call causes to an Exception
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		String sql = "Select EMP_ID, EMP_NO, EMP_NAME from Employee";
		
		// Execute SQL statement returns a ResultSet object
		// The ResultSet represents set of rows retrieved due to query execution
		ResultSet rs = statement.executeQuery(sql);
		
		// Junp the cursor to last record
		boolean last = rs.last();
		System.out.println("last: " + last);
		
		if(last) {
            // Print out data of last record
            System.out.println("EmpId:" + rs.getInt(1));
            System.out.println("EmpNo:" + rs.getString(2));
            System.out.println("EmpName:" + rs.getString(3));
        }
		
		System.out.println("--------------------");
		
		// Move cursor to previous record
        boolean previous = rs.previous();
        System.out.println("Previous 1: "+ previous);
         
        // Move cursor to previous record
        previous = rs.previous();
        System.out.println("Previous 2: "+ previous);  
        
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
