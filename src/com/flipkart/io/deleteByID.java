package com.flipkart.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteByID {
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
			System.out.println("Connecting..!!!");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			String sql = "delete from customer where ID =(?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 101);
			stmt.executeUpdate();
			
			stmt.close();
			conn.close();
			}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
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
