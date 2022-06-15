package practise;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

import generic_Utility.Excel_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.PropertyFile_Utility;
import generic_Utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWTest
{

	public static void main(String[] args) throws Throwable
	{

	/*	FileInputStream fis = new FileInputStream("./testfolder/test.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String browser = pro.getProperty("browser");
		String Url1 = pro.getProperty("url1");
		String Un1 = pro.getProperty("un1");
		String pass = pro.getProperty("pwd1");*/
		
		PropertyFile_Utility plib = new PropertyFile_Utility();
		 Java_Utility jlib = new Java_Utility();
	     Excel_Utility elib = new Excel_Utility();
	    WebDriver_Utility wblib = new WebDriver_Utility();
	    
	    String browser = plib.getPropertykey("browser");
	    String Url1 = plib.getPropertykey("url1");
	    String Un1 = plib.getPropertykey("un1");
	    String pass = plib.getPropertykey("pwd1");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		wblib.webdriver_utility(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get(Url1);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Un1);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		/*Random ran = new Random();
		int rannum = ran.nextInt(1000);*/
	int intrannum	=jlib.getRandomNum();
		
		/*FileInputStream fis1 = new FileInputStream("./testfolder/data1.xlsx");
		Workbook book =  WorkbookFactory.create(fis1);
		Sheet s = book.getSheet("Sheet1");
		Row r = s.getRow(0);
		Cell c = r.getCell(0);
		String value = c.getStringCellValue()+rannum;

		//System.out.println(value+rannum);
		book.close();*/
	String value = elib.getdatafromexcel("sheet1", 0, 0) +intrannum;
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(value);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		Thread.sleep(2000);
		String actmsg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actmsg.contains(value))
			{
				System.out.println("Successful");
			}
			else
			{
				System.out.println("Not Successful");
		}
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

	        Thread.sleep(3000);
			/*Actions act = new Actions(driver);
			act.moveToElement(ele).perform();*/
	        wblib.actionclass(driver, ele);
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		     Thread.sleep(2000);
		     driver.close();
	
	
		
	}
}

