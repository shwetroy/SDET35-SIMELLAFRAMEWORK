package practise;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Writedatainexcel {

	
	public static void main(String[] args) throws Throwable
	{
	FileInputStream fis = new FileInputStream("./testfolder/data1.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	Sheet s = book.getSheet("Sheet1");
	Row r = s.createRow(5);
	Cell c = r.createCell(0);
	c.setCellValue("Bangalore");
	FileOutputStream fout = new FileOutputStream("./testfolder/data1.xlsx");
	book.write(fout);
	book.close();

	}

}
