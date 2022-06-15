package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithoutDDT
{
@Test(dataProvider = "bookTicketsDataProvider")
public void bookTickets(String src,String dst,int ticket)

{
System.out.println("source is"+src+"destination is"+dst+"number of tickets is"+ticket);
	
}
@DataProvider
public  Object[][] bookTicketsDataProvider()
{
	Object[][] objarr=new Object[3][3] ;
	objarr[0][0]="Bangalore";
	objarr[0][1]="Mysore";
	objarr[0][2]=10;
	
	objarr[1][0]="Bangalore";
	objarr[1][1]="Goa";
	objarr[1][2]=20;
	
	objarr[2][0]="West Bengal";
	objarr[2][1]="Kolkata";
	objarr[2][2]=30;
	return objarr;
}
}