package practise;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtigerusingrandom {

	public static void main(String[] args) throws Throwable
	{
	
     FileInputStream fis = new FileInputStream("./testfolder/test.properties");
     Properties pro = new Properties();
     pro.load(fis);
      String browser = pro.getProperty("browser");
      String Url1 = pro.getProperty("url1");
     String Un1 = pro.getProperty("un1");
     String pass = pro.getProperty("pwd1");
      WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
     driver.get(Url1);
     driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Un1);
	 driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 driver.findElement(By.xpath("//a[.='Organizations']")).click();
	 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	 Random ran = new Random();
	 int rannum = ran.nextInt(1000);
	 FileInputStream fis1 = new FileInputStream("./testfolder/data1.xlsx");
	 Workbook book =  WorkbookFactory.create(fis1);
	 Sheet s = book.getSheet("Sheet1");
	 Row r = s.getRow(0);
	 Cell c = r.getCell(0);
	 String value = c.getStringCellValue();
	 
	  System.out.println(value+rannum);
	 book.close();
	 driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(value+rannum);
	 driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	 
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 Actions act = new Actions(driver);
	 act.moveToElement(ele).perform();
	 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	 driver.close();
	
	 
	//WebDriverWait wait = new WebDriverWait(driver, 10);
		//Alert al = wait.until(ExpectedConditions.alertIsPresent());
		
		//al.accept();
		
	 
     
     
     
     
	}

}
