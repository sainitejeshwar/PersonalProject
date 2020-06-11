package com.flipkart.DAO;

import com.flipkart.bean.Customer;

public interface CustomerDAO {
	public boolean insertCustomer(Customer cust);
	public boolean editCustomer(int ID , Customer cust);
	public boolean deleteCustomer(int ID);
	public String listAllCustomer();
	public String listCustomerbyID(int ID);
	

}
