package dbConnect;
import model.*;

import java.util.ArrayList;

public interface IFDBCust {

    public ArrayList<Customer> getAllCustomers(boolean retriveAssociation);

    public Customer findCustomer(String cpr, boolean retriveAssociation);

    public int insertCustomer(Customer cus) throws Exception;
  
    public int updateCustomer(Customer cus);

    public int delete(String cpr);
    
}
