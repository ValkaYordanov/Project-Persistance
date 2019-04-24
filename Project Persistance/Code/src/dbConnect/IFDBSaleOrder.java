package dbConnect;
import model.*;

import java.util.ArrayList;

public interface IFDBSaleOrder {
    // get all orders
    public ArrayList<SaleOrder> getAllSaleOrder(boolean retriveAssociation);
    //get one order having the id
    public SaleOrder findSaleOrder(int id, boolean retriveAssociation);
    //insert a new order
    public int insertSaleOrder(SaleOrder saleOrder) throws Exception;
    //update information about an order
    public int updateSaleOrder(SaleOrder saleOrder);
    
    public SaleOrder findById(int id);
    public void addSale(SaleOrder mySale);
    
    public SaleOrder getLastId() throws Exception;
    
    // delete order
    public int deleteSaleOrder(int id);
    
}
