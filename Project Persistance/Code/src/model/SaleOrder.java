package model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SaleOrder {

	private int id;
	private String customerCpr; 
	private String typeOrder;
	private LocalDate date; 
	private String deliveryStatus; 
	private Date deliveryDate; 
	
	private HashMap<String,Integer> products;
	
	
	public SaleOrder(){
	
	}
	
	public SaleOrder(int ID){
		products = new HashMap<>();
		this.id = ID; 
	}
	
	public SaleOrder(String customerCpr, String typeOrder, LocalDate date, String deliveryStatus, Date deliveryDate) {
		this.customerCpr = customerCpr; 
		this.typeOrder=typeOrder;
		this.date = LocalDate.now(); 
		this.deliveryStatus = "Ordered"; 
		this.deliveryDate = deliveryDate; 
	}
	
	public int getId() {
		return id;
	}
	
	public String getCustomerCpr() { 
		return customerCpr; 
	}
	
	public LocalDate getDate() { 
		return date; 
	}
	
	public String getTypeOrder() {
		return typeOrder; 
	}
	
	public String getDeliveryStatus() {
		return deliveryStatus; 
	}
	
	public Date getDeliveryDate() { 
		return deliveryDate; 
	}
	
	public void setCustomerCpr(String customerCpr) { 
		this.customerCpr = customerCpr; 
	}
	
	public void setDate(LocalDate date) { 
		this.date = date; 
	}
	
	public void setTypeOrder(String typeOrder) { 
		this.typeOrder = typeOrder;
	}
	
	public void setDeliveryStatus(String deliveryStatus) { 
		this.deliveryStatus = deliveryStatus; 
	}
	
	public void setDeliveryDate(Date deliveryDate) { 
		this.deliveryDate = deliveryDate; 
	}
	
	public void addProductSaleLine(String product, int quantity) {
		products.put(product, quantity);
		for (Entry<String, Integer> entry : products.entrySet()) {
		    System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
	

}
