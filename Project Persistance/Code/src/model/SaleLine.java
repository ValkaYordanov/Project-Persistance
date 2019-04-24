package model;

import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;


public class SaleLine {
	
	public HashMap<String,Integer> products;
	
	
	public SaleLine(){
		products = new HashMap<>();
	}
	
	public void addSalesLine(String name, int quantity) {
		products.put(name, quantity);
	}
	
}
