package practise;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.border.TitledBorder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xddf.usermodel.TileFlipMode;
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

public class CreateCampaignWithProductTest
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
	    
	    //fetching data from propertyfile
	    String browser = plib.getPropertykey("browser");
	    String Url1 = plib.getPropertykey("url1");
	    String Un1 = plib.getPropertykey("un1");
	    String pass = plib.getPropertykey("pwd1");
		
	   	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wblib.webdriver_utility(driver);
		
		driver.get(Url1);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Un1);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		/*Random ran = new Random();
		int rannum = ran.nextInt(1000);*/
		
		int intrannum = jlib.getRandomNum();
		//fetching data from excel
		
		/*FileInputStream fis1 = new FileInputStream("./testfolder/data1.xlsx");
		Workbook book =  WorkbookFactory.create(fis1);
		Sheet s = book.getSheet("Sheet1");
		Row r = s.getRow(0);
		Cell c = r.getCell(0);
		String value = c.getStringCellValue()+rannum;
		book.close();

		//System.out.println(value+rannum);*/
		String value = elib.getdatafromexcel("sheet1", 0, 0)+intrannum;
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(value);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		Thread.sleep(2000);
		wblib.switchToWindow(driver, "Products&action");
		/*String parent = driver.getWindowHandle();
		System.out.println(parent);
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1= set1.iterator();//loop
		while(it1.hasNext())
		{
			String cid = it1.next();
			driver.switchTo().window(cid);
			String title1 = driver.getTitle();
			if (title1.contains("Products&action"))
			{
				break;
			}
		}*/
	 
		driver.findElement(By.name("search_text")).sendKeys("Sim1");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='Sim1']")).click();
		
	//	driver.switchTo().window(parent);
		wblib.switchToWindow(driver, "Campaigns&action");
		
	     Thread.sleep(3000);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		String getmsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(getmsg.contains(value))
		{
			System.out.println("Verified");
		}
		else
		{
			System.out.println("Not verified");
		}
	}
}
		

