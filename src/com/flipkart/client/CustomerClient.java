package com.flipkart.client;

import java.util.*;
import com.flipkart.bean.Customer;
import com.flipkart.service.CustomerOperation;
import com.flipkart.service.Operations;


public class CustomerClient {
	public static void main(String[] args){
		
		Operations newop = new CustomerOperation();
		Scanner inp = new Scanner(System.in);
		int op;
		do{
			System.out.println("\n\nChoices: \n1.Add Customer \n2.Delete Customer \n3.Edit Customer\n4.List all Customers\n");
			System.out.println(">>>  ");
			op = Integer.parseInt(inp.nextLine());
			switch(op) {
			case 1:
				Customer c1 = new Customer();
				System.out.println("ID : ");
				c1.setID(Integer.parseInt(inp.nextLine()));
				System.out.println("Name : ");
				c1.setName(inp.nextLine());
				System.out.println("Location : ");
				c1.setLocation(inp.nextLine());
				System.out.println("Address : ");
				c1.setAddress(inp.nextLine());
				newop.addCustomer(c1);
				break;
			case 2:
				System.out.println("Enter ID to delete : ");
				System.out.println(newop.deleteCustomer(Integer.parseInt(inp.nextLine())));
				break;
			case 3:
				System.out.println("Enter ID to edit : ");
				int id = Integer.parseInt(inp.nextLine());
				Customer c2 = new Customer();
				c2.setID(id);
				System.out.println("Name : ");
				c2.setName(inp.nextLine());
				System.out.println("Location : ");
				c2.setLocation(inp.nextLine());
				System.out.println("Address : ");
				c2.setAddress(inp.nextLine());
				System.out.println(newop.editCustomer(id, c2));
				break;
			case 4:
				System.out.println(newop.listCustomer());
				break;
			default:
				System.out.println("Aborting .. !!");
				op = 5;
				break;
			}
			
		}
		while(op == 1 || op == 2 || op == 3 || op == 4);
		inp.close();
	}
}
