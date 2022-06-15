package practise;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class Nonselect {

	public static void main(String[] args) throws SQLException
	{   Connection connection = null;
	    int result = 0;
	    try
	    {
	    Driver driver_ref = new Driver();
	    DriverManager.registerDriver(driver_ref);
	    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
	    Statement stat = connection.createStatement();
	    String query ="insert into employee_info values('106','rupsa','belur','student')";
	     result = stat.executeUpdate(query);
		
	}
	catch (Exception e)
	{
		
	}
	    finally
	    {
	    	if(result==1)
	    	{
	    		System.out.println("row inserted");
	    	}
	    	else
	    	{
	    		System.out.println("row is not inserted");
	    	}
	    	connection.close();
	    }
	    
	    
	    
	    
		
	
		

	}

}
