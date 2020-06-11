package com.flipkart.service;


import org.apache.log4j.Logger;
import com.flipkart.DAO.CustomerDAOImpl;
import com.flipkart.bean.Customer;


public class CustomerOperation implements Operations {
	private static  Logger logger = Logger.getLogger(CustomerOperation.class);
	private CustomerDAOImpl CustomerDAO = new CustomerDAOImpl();
	
	@Override
	public void addCustomer(Customer cust) {
		logger.debug(CustomerDAO.insertCustomer(cust));
		return;
	}
	@Override
	public String deleteCustomer(int ID ) {
		String res = "Not found.!!";
		if(CustomerDAO.deleteCustomer(ID)) {
			res = "Deleted!";
		}
		return res;
	}
	@Override
	public String editCustomer(int ID , Customer cust) {
		String res = "Invalid ID";
		if(CustomerDAO.editCustomer(ID, cust)) {
			res = "Updated!";
		}
		return res;
	}
	@Override
	public String listCustomer() {
		String res = CustomerDAO.listAllCustomer();
		return res;
	}
	@Override
	public String listCustomerbyID(int ID) {
		String res = CustomerDAO.listCustomerbyID(ID);
		return res;
	}
	
}