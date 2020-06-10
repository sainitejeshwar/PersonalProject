package com.flipkart.service;

import org.apache.log4j.Logger;

public class LocationException extends Exception {
	private static Logger logger = Logger.getLogger(LocationException.class);
	private String Message;
	public LocationException(String location) {
		this.Message = location+" is not acceptable for ordering";
	}
	public String getMessage() {
		return this.Message;
	}

}
