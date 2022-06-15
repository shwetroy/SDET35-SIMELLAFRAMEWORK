package practise;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testfolder/data1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		 Sheet s = book.getSheet("Sheet1");
		 Row r = s.getRow(0);
		 Cell c = r.getCell(0);
		 String value = c.getStringCellValue();
		 System.out.println(value);
		 book.close();
		

	}

}
