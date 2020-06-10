package com.flipkart.client;

import java.util.*;

import org.apache.log4j.Logger;

import com.flipkart.bean.Customer;
import com.flipkart.service.CustomerOperation;
import com.flipkart.service.LocationException;
import com.flipkart.service.Operations;

public class CustomerClient {
	private static  Logger logger = Logger.getLogger(CustomerClient.class);
	public static void main(String[] args){
		
		Operations custOperations = new CustomerOperation();
		Scanner inputScanner = new Scanner(System.in);
		int opt = 0;
		do{
			try 
			{
				logger.debug("\n\nChoices: \n1.Add Customer \n2.Delete Customer \n3.Edit Customer\n4.List all Customers\n");
				logger.info(">>>  ");
				opt = Integer.parseInt(inputScanner.nextLine());
				switch(opt) {
				
				case 1:
					Customer tempCustomer1 = new Customer();
					
					logger.info("ID : ");
					tempCustomer1.setID(Integer.parseInt(inputScanner.nextLine()));
					
					logger.info("Name : ");
					tempCustomer1.setName(inputScanner.nextLine());
					
					boolean flag=true;
					while(flag) {
						try {
							logger.info("Location : ");
							tempCustomer1.setLocation(inputScanner.nextLine());
							flag = false;
						} catch (LocationException e) {
							logger.error(e.getMessage());
						}
					}
					logger.info("Address : ");
					tempCustomer1.setAddress(inputScanner.nextLine());
					
					custOperations.addCustomer(tempCustomer1);
					break;
					
				case 2:
					logger.info("Enter ID to delete : ");
					logger.debug(custOperations.deleteCustomer(Integer.parseInt(inputScanner.nextLine())));
					break;
					
				case 3:
					logger.info("Enter ID to edit : ");
					int id = Integer.parseInt(inputScanner.nextLine());
					Customer tempCustomer2 = new Customer();
					tempCustomer2.setID(id);
					
					logger.info("Name : ");
					tempCustomer2.setName(inputScanner.nextLine());
					
					boolean flag1=true;
					while(flag1) {
						try {
							logger.info("Location : ");
							tempCustomer2.setLocation(inputScanner.nextLine());
							flag1 = false;
						} catch (LocationException e) {
							logger.error(e.getMessage());
						}
					}
					logger.info("Address : ");
					tempCustomer2.setAddress(inputScanner.nextLine());
					logger.debug(custOperations.editCustomer(id, tempCustomer2));
					break;
					
				case 4:
					logger.debug(custOperations.listCustomer());
					break;
					
				default:
					logger.error("Aborting .. !!");
					opt = 5;
					break;
				}
			}
			catch (Exception e) 
			{
				logger.error("Invalid Entry.! ERROR :: "+e.getMessage());
			}
			
		}
		while(opt == 1 || opt == 2 || opt == 3 || opt == 4);
			inputScanner.close();
	}
}
