package dbConnect;
import model.*;

import java.sql.*;
import java.util.ArrayList;


public class DBSaleOrder implements IFDBSaleOrder{
	private  Connection con;
	private ArrayList<SaleOrder> storage = new ArrayList<>();
	
	/** Creates a new instance of DBSaleOrder */
	public DBSaleOrder() {
		con = ConnectDB.getInstance().getDBcon();
	}


    public void addSale(SaleOrder mySale)
    {
    	this.storage.add(mySale);
    	System.out.println("Added");
    }

    public void deleteSale(SaleOrder sale)
    {
        this.storage.remove(sale);
    }
    
    public SaleOrder findById(int id)
    {
        for (SaleOrder sale : this.storage) {
        	System.out.println(sale.getId());
            if (sale.getId() == id) {
                return sale;
            }
        }

        return null;
    }
    
	//Implements the methods from the interface
	// get all SaleOrders
	public ArrayList<SaleOrder> getAllSaleOrder(boolean retriveAssociation)
	{
		return miscWhere("", retriveAssociation);
	}
	
	
	//get one SaleOrder having the id
	public SaleOrder findSaleOrder(int id, boolean retriveAssociation)
	{   String wClause = "  id = '" + id + "'";
	return singleWhere(wClause, retriveAssociation);
	}
	
	
	//insert a new SaleOrder
	@Override
	public int insertSaleOrder(SaleOrder prod) throws Exception
	{  //call to get the next id number
		int nextId = GetMax.getMaxId("Select max(id) from SaleOrder");
		nextId = nextId + 1;
		System.out.println("next ssn = " +  nextId);

		int rc = -1;
		String query="INSERT INTO SaleOrder(customerCpr,typeOrder, date, deliveryStatus, deliveryDate)  VALUES('"+
				prod.getCustomerCpr()  + "','"  +
				prod.getTypeOrder()  + "','"  +
				prod.getDate()  + "','"  +
				prod.getDeliveryStatus() + "','" +
				prod.getDeliveryDate() + ")";
			
		
		try{ // insert new SaleOrder 
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}//end try
		catch(SQLException ex){
			System.out.println("SaleOrder is inserted");
			throw new Exception ("SaleOrder is not inserted correct");
		}
		return(rc);
	}
	@Override
	public int updateSaleOrder(SaleOrder prod)
	{
		SaleOrder orderObj  = prod;
		int rc=-1;

		String query="UPDATE SaleOrder SET "+
				"customerCpr ='"+ orderObj.getCustomerCpr()+"', "+
				"typeOrder ='"+ orderObj.getTypeOrder() + "', " +
				"date ='"+ orderObj.getDate() + "', " +
				"deliveryStatus ='"+ orderObj.getDeliveryStatus() + "', " +
				"deliveryDate ='"+ orderObj.getDeliveryDate() + "'";
				
		System.out.println("Update query:" + query);
		try{ // update SaleOrder
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);

			stmt.close();
		}//slut try
		catch(Exception ex){
			System.out.println("Update exception in SaleOrder db: " +ex);
		}
		return(rc);
	}

	public int deleteSaleOrder(int id)
	{
		int rc=-1;

		String query="DELETE FROM SaleOrder WHERE id = '" +
				id + "'";
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}
		catch(Exception ex){
			System.out.println("Delete exception in SaleOrder db: "+ex);
		}
		return(rc);
	}
	
	public SaleOrder getLastId() throws Exception {
		
		ResultSet results;
		SaleOrder saleObj = new SaleOrder();
		
		String query="SELECT IDENT_CURRENT('saleOrder')";
		
		try{ 
			
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			if( results.next() ){
				saleObj.setCustomerCpr(results.getString(1));
                stmt.close();
                          
			} else{
				saleObj = null;
            }

		
		}
		catch(SQLException ex){
			System.out.println(ex);
			throw new Exception ("Couldn't get last ID");
		}
		return saleObj;
		
			
		}



	private ArrayList<SaleOrder> miscWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		ArrayList<SaleOrder> list = new ArrayList<SaleOrder>();	

		String query =  buildQuery(wClause);

		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while( results.next() ){
				SaleOrder orderObj = new SaleOrder();
				orderObj = buildSaleOrder(results);	
				list.add(orderObj);	
			}
			stmt.close();     

		}	
		catch(Exception e){
			System.out.println("Query exception - select: "+e);
			e.printStackTrace();
		}
		return list;
	}

 	
	private SaleOrder singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		SaleOrder orderObj = new SaleOrder();

		String query =  buildQuery(wClause);
		
		try{ // read the SaleOrder from the database
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

		}//end try	
		catch(Exception e){
			System.out.println("Query exception: "+e);
		}
		return orderObj;
	}

	private String buildQuery(String wClause)
	{
		String query="SELECT id,customerCpr, typeOrder, date, deliveryStatus, deliveryDate FROM SaleOrder";

		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;

		return query;
	}
	
	//method to build an SaleOrder object
	private SaleOrder buildSaleOrder(ResultSet results)
	{   SaleOrder orderObj = new SaleOrder();
	try{ // the columns from the table SaleOrder  are used
		orderObj.setCustomerCpr(results.getString("customerCpr"));
		orderObj.setTypeOrder(results.getString("typeOrder"));
		//orderObj.setDate(results.getDate("date"));
		orderObj.setDeliveryStatus(results.getString("deliveryStatus"));
		orderObj.setDeliveryDate(results.getDate("deliveryDate"));

		

	}
	catch(Exception e)
	{
		System.out.println("error in building the SaleOrder object");
	}
	return orderObj;
	}

}  


