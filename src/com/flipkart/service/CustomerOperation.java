package com.flipkart.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import com.flipkart.bean.Customer;

public class CustomerOperation implements Operations {
	
	
	static final String JDBC_Driver = "com.mysql.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://localhost/bootcamp";
	
	static final String USER = "root";
	static final String PASS =	"root";
	
	ArrayList<Customer> CustArr = new ArrayList<Customer>();
	
	@Override
	public void addCustomer(Customer cust) {
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		try {
//			Class.forName(JDBC_Driver);
//			System.out.println("Connecting...");
//			conn = DriverManager.getConnection(DB_URL, USER , PASS);
//			
//			String sql = "insert into customers values (?,?,?,?)";
//			stmt = conn.prepareStatement(sql);
//			
//			stmt.executeUpdate();
//			
//			stmt.close();
//			conn.close();
//			
//			
//		}
//		catch (Exception e) {
//			System.out.println("Error : "+e.getMessage());
//		}
//		finally {
//			try{
//		         if(stmt!=null)
//		            stmt.close();
//		      }catch(SQLException se2){
//		      }
//		      try{
//		         if(conn!=null)
//		            conn.close();
//		      }catch(SQLException se){
//		         se.printStackTrace();
//		      }
//		}
		
		CustArr.add(cust);
		return;
	}
	@Override
	public String deleteCustomer(int ID ) {
		String res = "Not found.!!";
		for(Customer c: CustArr) {
			if(c.getID() == ID) {
				CustArr.remove(c);
				res = "Deleted";
				break;
			}
		}
		return res;
	}
	@Override
	public String editCustomer(int ID , Customer cust) {
		String res = "Invalid ID";
		int ind =0 ;
		for(Customer c: CustArr) {
			if(c.getID()==ID) {
				CustArr.set(ind, cust);
				res = "Updated";
				break;
			}
			ind++;
		}
		return res;
	}
	@Override
	public String listCustomer() {
		String res = "";
		for(Customer c : CustArr) {
				res = res	+"\nID : "+c.getID()+"\n"+"Name : "+c.getName()+"\n"+"Location : "
							+c.getLocation()+"\n"+"Address : "+c.getAddress()+"\n";
			}
		return res;
	}
	
}