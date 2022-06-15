package generic_Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility
{
public String getdatafromexcel(String sheetname,int rownum, int cellnum) throws Throwable
{
FileInputStream fis = new	FileInputStream("./testfolder/data1.xlsx");
 Workbook book = WorkbookFactory.create(fis);
/* Sheet s1 = book.getSheet("sheetname");
 Row r = s1.getRow(rownum);
 Cell c = r.getCell(cellnum);
  String value = c.getStringCellValue();
  return value;*/
 /** 
  * this is used to fetch data from excel
  * By shweta
  */
 DataFormatter format= new DataFormatter();
 return format.formatCellValue(book.getSheet(sheetname).getRow(rownum).getCell(cellnum));

}
	

}
