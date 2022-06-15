package practise;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Tofetchspecificdata
{

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testfolder/data1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		 Sheet s = book.getSheet("Sheet1");
		
			Row r = s.getRow(0);
			 Cell c = r.getCell(0);
			 String value = c.getStringCellValue();
			 
			 if(value.equals("Shweta Roy"))
			 {
				 Row r1 = s.getRow(1);
				 Cell c1 = r1.getCell(0);
				 String value1 = c1.getStringCellValue();
				 System.out.println(value1);
				 
			 }
		 }
	}
