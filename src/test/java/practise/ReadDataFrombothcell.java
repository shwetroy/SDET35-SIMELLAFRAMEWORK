package practise;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFrombothcell
{

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testfolder/datadriven.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		 Sheet s = book.getSheet("Sheet1");
		 for(int i= 0; i<=s.getLastRowNum(); i++)
		 {
			 
			  Row r = s.getRow(i);
		 
			  for(int j=0;j<r.getLastCellNum();j++)
			  {	  
			 Cell c = r.getCell(j);
			 String value = c.getStringCellValue();
			 System.out.println(value);
			 }
		 }
	}
	
}
