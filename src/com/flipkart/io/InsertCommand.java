package com.flipkart.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCommand {
	//STEP 1
	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://localhost/bootcamp";
	
	static final String USER = "root";
	static final String PASS =	"root";
	
	
	
	
	
	
	public static void main(String[] args) {
		
		//STEP 2
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//STEP 3  - register driver
			Class.forName(JDBC_Driver);
			
			//STEP 4 - open connection
			
			System.out.println("Connecting...");
			conn = DriverManager.getConnection(DB_URL, USER , PASS);
			
			//setting values
			String sql = "insert into customer values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 103);
			stmt.setString(2, "A");
			stmt.setString(3, "mumbai");
			stmt.setString(4, "c-2");
			System.out.println(stmt.executeUpdate());
		
			
			
			
			stmt.close();
			conn.close();
			/*Let us update age of the record with ID = 102;
			      int rows = stmt.executeUpdate();
			      System.out.println("Rows impacted : " + rows );

			      // Let us select all the records and display them.
			      sql = "SELECT id, name ,address, location FROM employeefc";
			      ResultSet rs = stmt.executeQuery(sql);

			      //STEP 5: Extract data from result set
			      while(rs.next()){
			         //Retrieve by column name
			         int eid  = rs.getInt("id");
			         String name1 = rs.getString("name");
			         String address1 = rs.getString("address");
			         String location1 = rs.getString("location");

			         //Display values
			         System.out.print("ID: " + eid);
			         System.out.print(", Age: " + name1);
			         System.out.print(", First: " + address1);
			         System.out.println(", Last: " + location1);
			      }
			      //STEP 6: Clean-up environment
			      rs.close();
			      stmt.close();
			      conn.close();*/
			
			
		}
		catch (Exception e) {
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
