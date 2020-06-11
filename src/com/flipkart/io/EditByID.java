package com.flipkart.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditByID {
	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://localhost/bootcamp";
	
	static final String USER = "root";
	static final String PASS =	"root";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(JDBC_Driver);
			System.out.println("Connecting...");
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String sql = "update customer set Name = ? , Location = ? , Address = ? where ID=?";
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, "yo");
			stmt.setString(2, "ff");
			stmt.setString(3, "fdfd");
			stmt.setInt(4, 102);
			System.out.println(stmt.executeUpdate());
			
			stmt.close();
			conn.close();
			
			
			
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
		}
		finally {
			try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		
		System.out.println("Connection Closed!!");
		
		
	}

}
