/**
 * PrepareStatement is an extends interface of Statement.
 * PrepareStatement is used for preparing SQL statement, reusing many times, 
 * and helping speed up the program.
 */

package org.o7planning.tutorial.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.o7planning.tutorial.jdbc.ConnectionUtils;

public class PrepareStatementExample {

	public static void main(String[] args) throws ClassNotFoundException,
    			SQLException{
		
		// Get a connection
        Connection connection = ConnectionUtils.getMyConnection();
		
        // Create a SQL statement with two parameters(?)
        String sql = "Select emp.Emp_ID, emp.Emp_NO, emp.Emp_Name,"
        			+ " emp.Dept_Id from Employee emp "
        			+ "where emp.Emp_Name like? and emp.Dept_ID=?";
        
        // Create a PreparedStatement object
        PreparedStatement pstm = connection.prepareStatement(sql);
        
        // Set value for the first parameter (First '?')
        pstm.setString(1, "%S");
        
        // Set value for the second parameter (Second '?')
        pstm.setInt(2, 20);
        
        ResultSet rs = pstm.executeQuery();
        
        while(rs.next()) {
        	System.out.println(" ---- ");
        	  System.out.println("EmpId : " + rs.getInt("Emp_Id"));
              System.out.println("EmpNo : " + rs.getString(2));
              System.out.println("EmpName : " + rs.getString("Emp_Name"));
        }
        
        System.out.println();
        System.out.println("Set other parameters ..");
        
        // Reuse PreparedStatement
        // Set other values
        pstm.setString(1, "KI%");
        pstm.setInt(2,10);
        
        // Execute statement.
        rs = pstm.executeQuery();
        
        while (rs.next()) {
            System.out.println(" ---- ");
            System.out.println("EmpId : " + rs.getInt("Emp_Id"));
            System.out.println("EmpNo : " + rs.getString(2));
            System.out.println("EmpName : " + rs.getString("Emp_Name"));
        }
	}

}
