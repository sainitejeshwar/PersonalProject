package com.flipkart.bean;

import com.flipkart.service.LocationException;

public class Customer {
	
	private int ID;
	private String Name;
	private String Address;
	private String Location;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) throws LocationException{
		if(location.equals("Delhi") || location.equals("delhi"))
			throw new LocationException(location);
		else {
			Location = location;
		}
	}
	

}
