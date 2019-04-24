package model;

public class Customer {
	
	private int ID;
	private String cpr; 
	private String name;
	private String address; 
	private String zipCode; 
	private String city; 
	private String phoneNo; 
	

	public Customer() {
		
	}

	public Customer(int id, String cpr, String name, String address, String zipCode, String city, String phoneNo) { 
		this.ID = id; 
		this.cpr = cpr; 
		this.name = name; 
		this.address = address; 
		this.zipCode = zipCode; 
		this.city = city; 
		this.phoneNo = phoneNo; 
	}
	
	public int getId() {
		return this.ID;
	}
	
	public String getCpr() { 
		return cpr; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() { 
		return address; 
	}
	
	public String getZipCode() { 
		return zipCode; 
	}
	
	public String getCity() {
		return city; 
	}
	
	public String getPhoneNo() {
		return phoneNo; 
	}
	
	public void setId(int id) { 
		this.ID = id; 
	}
	
	public void setCpr(String cpr) { 
		this.cpr = cpr; 
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) { 
		this.address = address; 
	}
	
	public void setZipCode(String zipCode) { 
		this.zipCode = zipCode; 
	}
	
	public void setCity(String city) { 
		this.city = city; 
	}
	
	public void setPhoneNo(String phoneNo) { 
		this.phoneNo = phoneNo; 
	}
	
}
