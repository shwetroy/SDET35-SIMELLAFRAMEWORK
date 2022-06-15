package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UnitTesting {

	public static void main(String[] args) throws SQLException
	{
	Connection connection = null;
	String empname ="shweta roy";
	try
	{
     Driver driver_ref = new Driver();
     DriverManager.registerDriver(driver_ref);
     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
     Statement stat = connection.createStatement();
     String query ="select * from employee_info";
     ResultSet result = stat.executeQuery(query);
     while(result.next())
     {
    	 String actempname = result.getString(2);
    	 if(actempname.equals(empname));
    	 System.out.println("project is created");
    	 
     }
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
