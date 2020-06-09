package com.flipkart.client;

import java.util.*;
import com.flipkart.bean.Customer;
import com.flipkart.service.CustomerOperation;
import com.flipkart.service.LocationException;
import com.flipkart.service.Operations;

public class CustomerClient {
	public static void main(String[] args){
		
		Operations custOperations = new CustomerOperation();
		Scanner inputScanner = new Scanner(System.in);
		int opt = 0;
		do{
			try 
			{
				System.out.println("\n\nChoices: \n1.Add Customer \n2.Delete Customer \n3.Edit Customer\n4.List all Customers\n");
				System.out.println(">>>  ");
				opt = Integer.parseInt(inputScanner.nextLine());
				switch(opt) {
				
				case 1:
					Customer tempCustomer1 = new Customer();
					
					System.out.println("ID : ");
					tempCustomer1.setID(Integer.parseInt(inputScanner.nextLine()));
					
					System.out.println("Name : ");
					tempCustomer1.setName(inputScanner.nextLine());
					
					boolean flag=true;
					while(flag) {
						try {
							System.out.println("Location : ");
							tempCustomer1.setLocation(inputScanner.nextLine());
							flag = false;
						} catch (LocationException e) {}
					}
					System.out.println("Address : ");
					tempCustomer1.setAddress(inputScanner.nextLine());
					
					custOperations.addCustomer(tempCustomer1);
					break;
					
				case 2:
					System.out.println("Enter ID to delete : ");
					System.out.println(custOperations.deleteCustomer(Integer.parseInt(inputScanner.nextLine())));
					break;
					
				case 3:
					System.out.println("Enter ID to edit : ");
					int id = Integer.parseInt(inputScanner.nextLine());
					Customer tempCustomer2 = new Customer();
					tempCustomer2.setID(id);
					
					System.out.println("Name : ");
					tempCustomer2.setName(inputScanner.nextLine());
					
					boolean flag1=true;
					while(flag1) {
						try {
							System.out.println("Location : ");
							tempCustomer2.setLocation(inputScanner.nextLine());
							flag1 = false;
						} catch (LocationException e) {}
					}
					System.out.println("Address : ");
					tempCustomer2.setAddress(inputScanner.nextLine());
					System.out.println(custOperations.editCustomer(id, tempCustomer2));
					break;
					
				case 4:
					System.out.println(custOperations.listCustomer());
					break;
					
				default:
					System.out.println("Aborting .. !!");
					opt = 5;
					break;
				}
			}
			catch (Exception e) 
			{
				System.out.println("Invalid Entry.! ERROR :: "+e.getMessage());
			}
			
		}
		while(opt == 1 || opt == 2 || opt == 3 || opt == 4);
			inputScanner.close();
	}
}
