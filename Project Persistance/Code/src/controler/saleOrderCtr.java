package controler;
import model.*;
import dbConnect.*;

import java.util.ArrayList;

public class saleOrderCtr {
	
    public saleOrderCtr() {
        
    }
    
    public ArrayList<SaleOrder> getAll()
    {
      IFDBSaleOrder sale = new DBSaleOrder();
      ArrayList<SaleOrder> allOrder = new ArrayList<SaleOrder>();
      allOrder = sale.getAllSaleOrder(false);
      return allOrder;
    }
    
    public SaleOrder getLastId() throws Exception {
		
		IFDBSaleOrder sale = new DBSaleOrder();
		SaleOrder allCus = sale.getLastId();
		
	    return allCus;
    }
    public void deleteCustomer(String cpr) {
    	IFDBCust dbCus = new DBCustomer();
    	int rc = dbCus.delete(cpr);
    }
    
    public void insertSale(String name, String cpr, String address, String zipCode, String city, String phoneNo) throws Exception
    {    
    	SaleLine mySaleLine = new SaleLine();
    	
    	
    	
        Customer cusObj = new Customer();
        cusObj.setName(name);
        cusObj.setCpr(cpr);
        cusObj.setAddress(address);
        cusObj.setZipCode(zipCode);
        cusObj.setCity(city);
        cusObj.setPhoneNo(phoneNo);
  
         try{
        	 
        	ConnectDB.startTransaction();
          	IFDBCust dbCus = new DBCustomer();
     	 	dbCus.insertCustomer(cusObj);
     	 	ConnectDB.commitTransaction();
         }
         catch(Exception e)
         {
        	 ConnectDB.rollbackTransaction();
             throw new Exception("Customer not inserted");
         }
    }
    
   
	public Customer findByCpr(String cpr)
    {
    	IFDBCust dbCus = new DBCustomer();
        return dbCus.findCustomer(cpr, false);
    }

	public void updateEmp(String name, String cpr, String address, String zipCode, String city, String phoneNo) throws Exception
      {
          Customer cusObj = new Customer();
         cusObj.setName(name);
         cusObj.setCpr(cpr);
         cusObj.setAddress(address);
         cusObj.setZipCode(zipCode);
         cusObj.setCity(city);
         cusObj.setPhoneNo(phoneNo);
  
         try{
        	 
        	ConnectDB.startTransaction();
          	IFDBCust dbCus = new DBCustomer();
     	 	dbCus.updateCustomer(cusObj);
     	 	ConnectDB.commitTransaction();
         }
         catch(Exception e)
         {
        	 ConnectDB.rollbackTransaction();
             throw new Exception("Customer not updated");
     }
      
      
  }

	public void insertProduct(int mySaleId, String product, int quantity) {
		
		IFDBSaleOrder ifdbSale = new DBSaleOrder();
		
		SaleOrder mySale = ifdbSale.findById(mySaleId);
		System.out.println(mySale);
		if(mySale != null) {
			mySale.addProductSaleLine(product, quantity);
			System.out.println("Found Sale");
		} else {
			SaleOrder newSale = new SaleOrder(mySaleId);
			ifdbSale.addSale(newSale);
			newSale.addProductSaleLine(product, quantity);
			System.out.println("New Sale");
		}
		
		
	}

    
}
