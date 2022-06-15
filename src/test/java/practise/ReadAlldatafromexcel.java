package practise;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAlldatafromexcel
{

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testfolder/data1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		 Sheet s = book.getSheet("Sheet1");
		 for(int i= 0; i<=s.getLastRowNum(); i++)
		 {
			 Row r = s.getRow(i);
			 Cell c = r.getCell(0);
			 String value = c.getStringCellValue();
			 System.out.println(value);
			 //value=c.toString(); // to fetch both numeric and string values
		 }
	}
}
		 
