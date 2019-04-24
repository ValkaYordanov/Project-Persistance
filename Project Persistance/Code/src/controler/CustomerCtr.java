package controler;
import model.*;
import dbConnect.*;

import java.util.ArrayList;

import controler.CustomerCtr;

public class CustomerCtr {
	
    public CustomerCtr() {
        
    }
    
    public ArrayList<Customer> getAll()
    {
      IFDBCust dbCus = new DBCustomer();
      ArrayList<Customer> allCus = new ArrayList<Customer>();
      allCus = dbCus.getAllCustomers(false);
      return allCus;
    }
    public void deleteCustomer(String cpr) {
    	IFDBCust dbCus = new DBCustomer();
    	int rc = dbCus.delete(cpr);
    }
    public void insertCustomer(String name, String cpr, String address, String zipCode, String city, String phoneNo) throws Exception
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
     	 	dbCus.insertCustomer(cusObj);
     	 	ConnectDB.commitTransaction();
         }
         catch(Exception e)
         {
        	 ConnectDB.rollbackTransaction();
             throw new Exception("Customer not inserted");
         }
    }
    
    /*public Employee findByFname(String fname)
    {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.searchEmployeeFname(fname, true);
    }
     public Employee findByLname(String lname)
    {
        IFDBEmp dbEmp = new DBEmployee();
        return dbEmp.searchEmployeeLname(lname, true);
    }
    */
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
      /*
      //find the projects the employee is working on
      public ArrayList<WorksOn> findProject(String ssn)
      {
          IFDBWorksOn dbWorksOn = new DBWorksOn();
          ArrayList<WorksOn> result = dbWorksOn.findWorksOn(ssn);
          return result;
      }
      
     
       */
    
}
