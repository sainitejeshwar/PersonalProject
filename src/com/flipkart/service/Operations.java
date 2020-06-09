package com.flipkart.service;

import com.flipkart.bean.Customer;

public interface Operations {
	public void addCustomer(Customer cust);
	public String deleteCustomer(int ID);
	public String editCustomer(int ID , Customer cust);
	public String listCustomer();

}
