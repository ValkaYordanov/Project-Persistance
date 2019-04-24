package dbConnect;
import model.*;

import java.sql.*;
import java.util.ArrayList;


public class DBProduct implements IFDBProduct{
	private  Connection con;
	/** Creates a new instance of DBEmployee */
	public DBProduct() {
		con = ConnectDB.getInstance().getDBcon();
	}

	//Implements the methods from the interface
	// get all products
	public ArrayList<Product> getAllProduct(boolean retriveAssociation)
	{
		return miscWhere("", retriveAssociation);
	}
	
	public ArrayList<Product> getAllProductName(boolean retriveAssociation)
	{
		return miscWhereName("", retriveAssociation);
	}
	
	
	//get one product having the rentPrice
	public Product findProduct(String id, boolean retriveAssociation)
	{   String wClause = "  id = '" + id + "'";
	return singleWhere(wClause, retriveAssociation);
	}
	
	//insert a new product
	@Override
	public int insertProduct(Product prod) throws Exception
	{  //call to get the next id number

		int rc = -1;
		String query="INSERT INTO product(name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, nameOfSupplier)  VALUES('"+
				prod.getName()  + "','"  +
				prod.getPurchasePrice()  + "','"  +
				prod.getSalesPrice() + "','" +
				prod.getRentPrice() + "','" +
				prod.getCountryOfOrigin() + "','" +
				prod.getMinStock() + "','" +
				prod.getNameOfSupplier() + "')";


		System.out.println(query);
		try{ // insert new product 
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}//end try
		catch(SQLException ex){
			System.out.println("Product is inserted");
			throw new Exception ("Product is not inserted correct");
		}
		return(rc);
	}
	
	
	@Override
	public int updateProduct(Product prod)
	{
		Product prodObj  = prod;
		int rc=-1;

		String query="UPDATE product SET "+
				"name ='"+ prodObj.getName()+"', "+
				"purchasePrice ='"+ prodObj.getPurchasePrice() + "', " +
				"salesPrice ='"+ prodObj.getSalesPrice() + "', " +
				"rentPrice ='"+ prodObj.getRentPrice() + "', " +
				"countryOfOrigin ='"+ prodObj.getCountryOfOrigin() + "', " +
				"minStock ='"+ prodObj.getMinStock() + "', " +
				"nameOfSupplier = '"+ prodObj.getNameOfSupplier() +"' "+
		        "WHERE id = '"+ prodObj.getId() + "'";
		
		System.out.println("Update query:" + query);
		try{ // update product
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);

			stmt.close();
		}
		catch(Exception ex){
			System.out.println("Update exception in product db: " +ex);
		}
		return(rc);
	}

	public int deleteProduct(String id)
	{
		int rc=-1;

		String query="DELETE FROM product WHERE id = '" +
				id + "'";
		System.out.println(query);
		try{ // delete from product
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}//slut try	
		catch(Exception ex){
			System.out.println("Delete exception in product db: "+ex);
		}
		return(rc);
	}

	private ArrayList<Product> miscWhere(String wClause, boolean retrieveAssociation)
	{
        ResultSet results;
	    ArrayList<Product> list = new ArrayList<Product>();	
		
	    String query =  buildQuery(wClause);
  
        try{
        	Statement stmt = con.createStatement();
        	stmt.setQueryTimeout(5);
        	results = stmt.executeQuery(query);

			while( results.next() ){
		     	 Product prodObj = new Product();
		     	 prodObj = buildProduct(results);	
	             list.add(prodObj);	
			}
            stmt.close();     
          	
		}
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	private ArrayList<Product> miscWhereName(String wClause, boolean retrieveAssociation)
	{
        ResultSet results;
	    ArrayList<Product> list = new ArrayList<Product>();	
		
	    String query =  buildQueryName(wClause);
  
        try{
        	Statement stmt = con.createStatement();
        	stmt.setQueryTimeout(5);
        	results = stmt.executeQuery(query);

			while( results.next() ){
		     	 Product prodObj = new Product();
		     	 prodObj = buildProductName(results);	
	             list.add(prodObj);	
			}
            stmt.close();     
          	
		}
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}

	private Product singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Product prodObj = new Product();
                
        String query =  buildQuery(wClause);
        
		try{
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                prodObj = buildProduct(results);
                stmt.close();
                          
			} else{
                prodObj = null;
            }
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return prodObj;
	}

	private String buildQuery(String wClause)
	{
	    String query="SELECT id, name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, nameOfSupplier FROM Product";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private String buildQueryName(String wClause)
	{
	    String query="SELECT name FROM Product";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private Product buildProduct(ResultSet results)
      {   
		Product prodObj = new Product();
          try{
        	  	prodObj.setId(results.getInt("id"));
                prodObj.setName(results.getString("name"));
                prodObj.setPurchasePrice(results.getDouble("purchasePrice"));
                prodObj.setSalesPrice(results.getDouble("salesPrice"));
                prodObj.setRentPrice(results.getDouble("rentPrice"));
                prodObj.setCountryOfOrigin(results.getString("countryOfOrigin"));
                prodObj.setMinStock(results.getInt("minStock"));
                prodObj.setNameOfSupplier(results.getString("nameOfSupplier"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the Product object");
         }
         return prodObj;
      }
	
	private Product buildProductName(ResultSet results)
    {   
		Product prodObj = new Product();
        try{
              prodObj.setName(results.getString("name"));
        }
       catch(Exception e)
       {
           System.out.println("error in building the Product object");
       }
       return prodObj;
    }


}  


