package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class Sample_Select_Query
{
public static void main(String[]args) throws SQLException
{    Connection connection =null;
try {
	//register for a database
	Driver driver_Ref = new Driver();
	DriverManager.registerDriver(driver_Ref);
	//get the connection
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
	 
	//write the queries
	Statement stat = connection.createStatement();
	String query ="select * from students_info";
	
	//execute the queries
	ResultSet resultset = stat.executeQuery(query);
	while(resultset.next())
	{
	System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2));	
	}
}
catch (Exception e)
{
	
}
finally {
	
	//close the connection
	connection.close();
	
}
}
}
