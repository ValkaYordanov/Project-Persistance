package dbConnect;
import model.*;

import java.util.ArrayList;

public interface IFDBProduct {
    // get all product
    public ArrayList<Product> getAllProduct(boolean retriveAssociation);
    public ArrayList<Product> getAllProductName(boolean retriveAssociation);
    //get one product having the rentPrice
    public Product findProduct(String id, boolean retriveAssociation);
    //insert a new product
    public int insertProduct(Product prod) throws Exception;
    //update information about an product
    public int updateProduct(Product prod);
	//delete product
    public int deleteProduct(String id);
    
}
