package com.flipkart.service;

import java.util.ArrayList;
import com.flipkart.bean.Customer;

public class CustomerOperation implements Operations {
	
	ArrayList<Customer> CustArr = new ArrayList<Customer>();
	
	@Override
	public void addCustomer(Customer cust) {
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