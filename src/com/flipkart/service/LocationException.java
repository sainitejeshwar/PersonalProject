package com.flipkart.service;

public class LocationException extends Exception {
	public LocationException(String location) {
		System.out.println(location + "Cannot be Accepted For Delivery");
	}

}
