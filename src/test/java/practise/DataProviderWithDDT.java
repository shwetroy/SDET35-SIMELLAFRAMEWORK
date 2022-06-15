package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic_Utility.Excel_Utility;

public class DataProviderWithDDT 
{
@Test(dataProvider = "bookTicketsDataProvider")
public void bookTickets(String src, String dst, String tickets)
{
	System.out.println("source is"+src+"destination is"+dst+"no.of tickets"+tickets);
}
@DataProvider
public Object[][] bookTicketsDataProvider() throws Throwable
{
	Excel_Utility elib = new Excel_Utility();
	String src1=elib.getdatafromexcel("sheet2", 0, 0);
	String dst1=elib.getdatafromexcel("sheet2", 0, 1);
	String ticket1=elib.getdatafromexcel("sheet2",0, 2);
	
	String src2=elib.getdatafromexcel("sheet2", 1, 0);
	String dst2=elib.getdatafromexcel("sheet2", 1, 1);
	String ticket2=elib.getdatafromexcel("sheet2", 1, 2);
	
	String src3=elib.getdatafromexcel("sheet2", 2, 0);
	String dst3=elib.getdatafromexcel("sheet2", 2, 1);
	String ticket3=elib.getdatafromexcel("sheet2", 2, 2);
	
	Object[][] objarr=new Object[3][3] ;
	objarr[0][0]=src1;
	objarr[0][1]=dst1;
	objarr[0][2]=ticket1;
	
	objarr[1][0]=src2;
	objarr[1][1]=dst2;
	objarr[1][2]=ticket2;
	
	objarr[2][0]=src3;
	objarr[2][1]=dst3;
	objarr[2][2]=ticket3;
	return objarr;
}
}
