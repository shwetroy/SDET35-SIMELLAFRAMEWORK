package com.crm.comcast.campaignTest;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCmapaignWithProduct
{

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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Url1);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Un1);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		Random ran = new Random();
		int rannum = ran.nextInt(1000);
		FileInputStream fis1 = new FileInputStream("./testfolder/data1.xlsx");
		Workbook book =  WorkbookFactory.create(fis1);
		Sheet s = book.getSheet("Sheet1");
		Row r = s.getRow(0);
		Cell c = r.getCell(0);
		String value = c.getStringCellValue()+rannum;

		//System.out.println(value+rannum);
		book.close();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(value);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		Thread.sleep(2000);
		String pid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for (String ids : allid) 
		{
			driver.switchTo().window(ids);
			String urll = driver.getCurrentUrl();
			if(urll.equals("http://localhost:8888/index.php?module=Products&action=Popup&html=Popup_picker&form=HelpDeskEditView&popuptype=specific&fromlink="))
			{
				driver.findElement(By.xpath("//a[.='Simella']")).click();
				driver.switchTo().window(pid);
			}
		}
	
		
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.titleContains("admin"));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		
		
		
		
		String url1 = driver.getCurrentUrl();
        if (url1.equals("http://localhost:8888/index.php?action=DetailView&module=Campaigns&record=56&parenttab=Marketing&start="))
        {
        	System.out.println("Successful");
        }
        else
        {
        	System.out.println("Not Succesful");
        }
        	Thread.sleep(2000);
		
	
	
		
	}
}


