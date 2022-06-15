package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_UnittestQuery {

	public static void main(String[] args) throws SQLException 
	
	{
		String empname ="shweta roy" ;
		Connection connection = null;
		try
		{
			Driver driverRef= new Driver();
	
	DriverManager.registerDriver(driverRef);
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
	Statement stat = connection.createStatement();
	String query = "select* from emplyoee_info";
	ResultSet result= stat.executeQuery(query);
	
	while(result.next())
	{
		String actempname = result.getString(2);
		if(actempname.equals(empname))
		{
			System.out.println("project is created");
			
			
		}
		else
		{
			System.out.println("project is not created");
			
		}
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
