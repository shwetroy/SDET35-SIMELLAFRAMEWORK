package practise;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class Multiple {

	public static void main(String[] args) throws SQLException
	{   Connection connection = null;
	    
	    try
	    {
	    Driver driver_ref = new Driver();
	    DriverManager.registerDriver(driver_ref);
	    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
	    Statement stat = connection.createStatement();
	    String query ="insert into product_info values('121','mobile','oneplus','100')";
	    int result1 = stat.executeUpdate(query);
	     String query1 ="insert into product_info values('131','tv','samsung','200')";
	   int result = stat.executeUpdate(query1); 
		
	}
	catch (Exception e)
	{
		
	}
	    finally
	    {
	    	
	    	connection.close();
	    }
	    
	    
	    
	    
		
	
		

	}

}


