package dbConnect;

import static org.junit.Assert.*;

import org.junit.Test;



public class TestForDatabase {

	@Test
	public void test() {
		ConnectDB dbCon = ConnectDB.getInstance();
		if(dbCon != null)
		{
			System.out.println("Conecction to DB is ok");
		}
		else{
		    fail("Can not connect to the DB");
		}
	}

}
