package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class updates {

	public static void main(String[] args) throws SQLException
	{   Connection connection = null;
	     int result = 0;
	     try
	     {
		Driver driver_ref = new Driver();
		DriverManager.registerDriver(driver_ref);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		Statement stat= connection.createStatement();
		String query = "update table employee set empname='laptop' where empid=100";
		 result = stat.executeUpdate(query);
	     }
	     
	     
		
		
		

	}

}
