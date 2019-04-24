package dbConnect;
import model.*;

import java.sql.*;
import java.util.ArrayList;

public class DBCustomer implements IFDBCust{
    private  Connection con;
    /** Creates a new instance of DBEmployee */
    public DBCustomer() {
      con = ConnectDB.getInstance().getDBcon();
    }
    
    public ArrayList<Customer> getAllCustomers(boolean retriveAssociation)
    {
        return miscWhere("", retriveAssociation);
    }
    
    
    public Customer findCustomer(String cpr, boolean retriveAssociation)
    {   String wClause = "  cpr = '" + cpr + "'";
        return singleWhere(wClause, retriveAssociation);
    }
   
    /*public Customer searchEmployeeFname(String attValue, boolean retriveAssociation)
    {
        String wClause = "fname like '%" + attValue + "%'";
        System.out.println("SearchEmployye " + wClause);
        return singleWhere(wClause, retriveAssociation);
    }
     
    public Customer searchCustomerByName(String attValue, boolean retriveAssociation)
    {
        String wClause = "lname = '" + attValue + "'";
        return singleWhere(wClause, retriveAssociation);
    }*/
   
    @Override
    public int insertCustomer(Customer cus) throws Exception
    {
  
       int rc = -1;
	   String query="INSERT customer(cpr,name,address,zipcode,city,phoneno) VALUES('"+cus.getCpr()+"','"+cus.getName()+"','"+cus.getAddress()+"','"+cus.getZipCode()+"','"+cus.getCity()+"','"+cus.getPhoneNo()+"')";     
      try{
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
      }
       catch(SQLException ex){
          throw new Exception ("Customer is not inserted correct");
       }
       return(rc);
    }
    
    @Override
	public int updateCustomer(Customer cus)
	{
		Customer cusObj  = cus;
		int rc=-1;

		String query="UPDATE customer SET "+
		 	  "name ='"+ cusObj.getName()+"', "+
		 	  "address ='"+ cusObj.getAddress() + "', " +
              "zipcode ='"+ cusObj.getZipCode() + "', " +
              "city ='"+ cusObj.getCity() + "', " +
              "phoneno ='"+ cusObj.getPhoneNo() + "' " +
	          "WHERE cpr = '"+ cusObj.getCpr() + "'";
                
  		try{
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in employee db: " +ex);
	  	}
		return(rc);
	}
	
	public int delete(String cpr)
	{
        int rc=-1;
	  
	  	String query="DELETE FROM customer WHERE cpr = '" + cpr + "'";
	  	
	  	try{
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	rc = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}
   	        catch(Exception ex){
	 	  	System.out.println("Delete exception in employee db: "+ex);
   	        }
		return(rc);
	}
	 
	private ArrayList<Customer> miscWhere(String wClause, boolean retrieveAssociation)
	{
        ResultSet results;
	    ArrayList<Customer> list = new ArrayList<Customer>();	
		
	    String query =  buildQuery(wClause);
  
        try{
        	Statement stmt = con.createStatement();
        	stmt.setQueryTimeout(5);
        	results = stmt.executeQuery(query);

			while( results.next() ){
		     	 Customer cusObj = new Customer();
		     	 cusObj = buildCustomer(results);	
	             list.add(cusObj);	
			}
            stmt.close();     
          	
		}
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	private Customer singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Customer cusObj = new Customer();
                
        String query =  buildQuery(wClause);
        
		try{
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                cusObj = buildCustomer(results);
                stmt.close();
                          
			} else{
                cusObj = null;
            }
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return cusObj;
	}

	private String buildQuery(String wClause)
	{
	    String query="SELECT id,cpr,name,address,zipcode,city,phoneno FROM customer";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private Customer buildCustomer(ResultSet results)
      {   
		Customer cusObj = new Customer();
          try{
        	  	cusObj.setId(results.getInt("id"));
                cusObj.setCpr(results.getString("cpr"));
                cusObj.setName(results.getString("name"));
                cusObj.setAddress(results.getString("address"));
                cusObj.setZipCode(results.getString("zipcode"));
                cusObj.setCity(results.getString("city"));
                cusObj.setPhoneNo(results.getString("phoneno"));
          }
         catch(Exception e)
         {
             System.out.println("error in building the customer object");
         }
         return cusObj;
      }




}  
    

