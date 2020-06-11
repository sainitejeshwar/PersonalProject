package com.flipkart.constants;

public class SQLConstantQueries {
	public static final String INSERT_CUSTOMER = "insert into customer values(?,?,?,?)";
	public static final String DELETE_CUSTOMER = "delete from customer where ID =(?)";
	public static final String LIST_CUSTOMER = "select * from customer where id = ?";
	public static final String LIST_ALL_CUSTOMER = "select * from customer";
	public static final String UPDATE_CUSTOMER = "update customer set Name = ? , Location = ? , Address = ? where ID=?";
}
