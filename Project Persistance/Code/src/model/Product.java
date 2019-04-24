package model;

public class Product {
	
	private int id; 
	private String name;
	private double purchasePrice;
	private double salesPrice;
	private double rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private String nameOfSupplier;
	
	public Product()
	{}
	
	public Product(int id, String name,double purchasePrice, double salesPrice,double rentPrice, String countryOfOrigin, int minStock, String nameOfSupplier) {
		
		this.id=id; 
		this.name=name;
		this.purchasePrice=purchasePrice;
		this.salesPrice=salesPrice;
		this.rentPrice=rentPrice;
		this.countryOfOrigin=countryOfOrigin;
		this.minStock=minStock;
		this.nameOfSupplier=nameOfSupplier;
	}

	public int getId() { 
		return id; 
	}
	
	public void setId(int id) { 
		this.id=id; 
	}
	
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice=purchasePrice;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	
	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	
	public String getNameOfSupplier() {
		return nameOfSupplier;
	}

	public void setNameOfSupplier(String nameOfSupplier) {
		this.nameOfSupplier = nameOfSupplier;
	}
	
	

}
