package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.bean.Customer;
import com.flipkart.constants.SQLConstantQueries;
import com.flipkart.utils.DBUtils;

public class CustomerDAOImpl implements CustomerDAO{
	private static  Logger logger = Logger.getLogger(CustomerDAOImpl.class);
	Connection conn = null;
	PreparedStatement stmt = null;
	
	
	@Override
	public boolean insertCustomer(Customer cust) {
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstantQueries.INSERT_CUSTOMER);
			stmt.setInt(1, cust.getID());
			stmt.setString(2, cust.getName());
			stmt.setString(3, cust.getLocation());
			stmt.setString(4, cust.getAddress());
			
			stmt.executeUpdate();
			return true;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		finally {
			try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se){
		    	  logger.error(se.getMessage());;
		      }
		}
		return false;
	}

	@Override
	public boolean editCustomer(int ID, Customer cust) {
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstantQueries.UPDATE_CUSTOMER);
			stmt.setString(1, cust.getName());
			stmt.setString(2, cust.getLocation());
			stmt.setString(3, cust.getAddress());
			stmt.setInt(4, cust.getID());
			
			stmt.executeUpdate();
			return true;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		finally {
			try{
		         if(stmt!=null)
		            stmt.close();
		  
		      }catch(SQLException se){
		    	  logger.error(se.getMessage());;
		      }
		}
		return false;
		
	}

	@Override
	public boolean deleteCustomer(int ID) {
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstantQueries.DELETE_CUSTOMER);
			stmt.setInt(1, ID);
			
			stmt.executeUpdate();
			return true;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		finally {
			try{
		         if(stmt!=null)
		            stmt.close();
		  
		      }catch(SQLException se){
		    	  logger.error(se.getMessage());;
		      }
		}
		return false;
		
	}

	@Override
	public String listAllCustomer() {
		String res = "\n";
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstantQueries.LIST_ALL_CUSTOMER);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				res = res+ rs.getInt("ID") +"," + rs.getString("Name") + "," +  rs.getString("Location") + "," + rs.getString("Address")+"\n";
			}
			rs.close();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		finally {
			try{
		         if(stmt!=null)
		            stmt.close();
		  
		      }catch(SQLException se){
		    	  logger.error(se.getMessage());;
		      }
		}
		return res;
	}

	@Override
	public String listCustomerbyID(int ID) {
		String res = "\n";
		try {
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstantQueries.LIST_CUSTOMER);
			stmt.setInt(1, ID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				res = res+ rs.getInt("ID") +"," + rs.getString("Name") + "," +  rs.getString("Location") + "," + rs.getString("Address")+"\n";
			}
			rs.close();
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		finally {
			try{
		         if(stmt!=null)
		            stmt.close();
		  
		      }catch(SQLException se){
		    	  logger.error(se.getMessage());;
		      }
		}
		return res;
	}
	

}
