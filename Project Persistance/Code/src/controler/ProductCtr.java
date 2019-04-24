	
package controler;
	import model.*;
	import dbConnect.*;

	import java.util.ArrayList;
	
	public class ProductCtr {
   	    
	    /** Creates a new instance of CtrEmp 
	     * @return */
	    public  ProductCtr() {
	    }
	        
	    	  public ArrayList<Product> getAll()
	    	    {
	    	      IFDBProduct dbProd = new DBProduct();
	    	      ArrayList<Product> allProd = new ArrayList<Product>();
	    	      allProd = dbProd.getAllProduct(false);
	    	      return allProd;
	    	    }
	    	  public ArrayList<Product> getAllName()
	    	    {
	    	      IFDBProduct dbProd = new DBProduct();
	    	      ArrayList<Product> allProd = new ArrayList<Product>();
	    	      allProd = dbProd.getAllProductName(false);
	    	      return allProd;
	    	    }
	    	    public void deleteProduct(String id) {
	    	    	IFDBProduct dbProd = new DBProduct();
	    	    	int rc = dbProd.deleteProduct(id);
	    	    }
	    	    public void insertProduct(String name,double purchasePrice, double salesPrice,double rentPrice, String countryOfOrigin, int minStock, String nameOfSupplier) throws Exception
	    	    {    
	    	         Product prodObj = new Product();
	    	         prodObj.setName(name);
	    	         prodObj.setPurchasePrice(purchasePrice);
	    	         prodObj.setSalesPrice(salesPrice);
	    	         prodObj.setRentPrice(rentPrice);
	    	         prodObj.setCountryOfOrigin(countryOfOrigin);
	    	         prodObj.setMinStock(minStock);
	    	         prodObj.setNameOfSupplier(nameOfSupplier);
	    	  
	    	         try{
	    	        	 
	    	        	ConnectDB.startTransaction();
	    	          	IFDBProduct dbProd = new DBProduct();
	    	     	 	dbProd.insertProduct(prodObj);
	    	     	 	ConnectDB.commitTransaction();
	    	         }
	    	         catch(Exception e)
	    	         {
	    	        	 ConnectDB.rollbackTransaction();
	    	             throw new Exception("Product not inserted");
	    	         }
	    	    }
	    	    
	    	    
	    	    public Product findById(String id)
	    	    {
	    	    	IFDBProduct dbProd = new DBProduct();
	    	        return dbProd.findProduct(id, false);
	    	    }
	        
	          public void updateProduct(int id,String name,double purchasePrice, double salesPrice,double rentPrice, String countryOfOrigin, String nameOfSupplier) throws Exception
	          {
	        	  
	    	         Product prodObj = new Product();
	    	         prodObj.setId(id);
	    	         prodObj.setName(name);
	    	         prodObj.setPurchasePrice(purchasePrice);
	    	         prodObj.setSalesPrice(salesPrice);
	    	         prodObj.setRentPrice(rentPrice);
	    	         prodObj.setCountryOfOrigin(countryOfOrigin);
	    	      // prodObj.setMinStock(minStock);
	    	         prodObj.setNameOfSupplier(nameOfSupplier);
	      
	             try{
	            	 
	            	ConnectDB.startTransaction();
	              	IFDBProduct dbProd = new DBProduct();
	         	 	dbProd.updateProduct(prodObj);
	         	 	ConnectDB.commitTransaction();
	             }
	             catch(Exception e)
	             {
	            	 ConnectDB.rollbackTransaction();
	                 throw new Exception("Product not updated");
	             }
	              
	              
	          }
	    }
	    
	
