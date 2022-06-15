package com.crm.comcast.contactTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.simella.pomrepository.ContactHomePage;
import com.crm.simella.pomrepository.ContactVerificationPage;
import com.crm.simella.pomrepository.CreateContactPage;
import com.crm.simella.pomrepository.HomePage;
import com.crm.simella.pomrepository.LoginPage;

import generic_Utility.BaseClass;
import generic_Utility.Excel_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.PropertyFile_Utility;
import generic_Utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteContactTest extends BaseClass
{
@Test(groups="regressionTest")
	public void deleteContact() throws Throwable
	{

	
	//	PropertyFile_Utility plib = new PropertyFile_Utility();
		 Java_Utility jlib = new Java_Utility();
	     Excel_Utility elib = new Excel_Utility();
	  /*  WebDriver_Utility wblib = new WebDriver_Utility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
	     wblib.webdriver_utility(driver);
		    String browser = plib.getPropertykey("browser");
		    String Url1 = plib.getPropertykey("url1");
		    String Un1 = plib.getPropertykey("un1");
		    String pass = plib.getPropertykey("pwd1");
		driver.get(Url1);
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(Un1, pass);*/
		
		
		
		ContactHomePage cp = new ContactHomePage(driver);
		cp.clickcontact();
		cp.contactpage();
		/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Un1);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();*/
		
		
		
		int intrannum = jlib.getRandomNum();
		
		String value = elib.getdatafromexcel("sheet1",0, 0)+intrannum;
		Thread.sleep(2000);
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContactPage(value);
		ccp.saveonclick();
		/*driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(value);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();*/
		Thread.sleep(2000);
		
	/*driver.findElement(By.xpath("//a[.='Contacts']")).click();
		
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(value);
		WebElement ele = driver.findElement(By.xpath("//select[@id='bas_searchfield']"));
		
		
		wblib.selectclass(ele, "Last Name");
		
		driver.findElement(By.xpath("//input[@value=' Search Now ']")).click();*/
		
		
       //  driver.findElement(By.xpath("//a[.='del'][1]")).click();
        
      
      //   wblib.alertaction(driver, "Are You Sure You want to Delete?");
		
		
		ContactVerificationPage cvp = new ContactVerificationPage(driver);
	    WebElement vf = cvp.getVerify();
		String getmsg = vf.getText();
		Assert.assertEquals(getmsg.contains(value),true);
		/*if(getmsg.contains(value))
		{
			System.out.println("Verified");
		}
		else
		{
			System.out.println("Not verified");
		}*/
		ccp.deleteContact();
		wblib.webdriver_utility(driver);
       /* HomePage hp= new HomePage(driver);
        hp.logout();*/
		 
		/*WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
      
		wblib.actionclass(driver, ele1);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
	     
		//driver.close();
			
		
		}
		
}
