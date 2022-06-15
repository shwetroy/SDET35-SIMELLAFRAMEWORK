package com.crm.comcast.organization.organiszationTest;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.simella.pomrepository.CreateOraganizationHomePage;
import com.crm.simella.pomrepository.CreateOrganizationPage;
import com.crm.simella.pomrepository.HomePage;
import com.crm.simella.pomrepository.LoginPage;
import com.crm.simella.pomrepository.OrganizationVerificationPage;

import generic_Utility.BaseClass;
import generic_Utility.Excel_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.PropertyFile_Utility;
import generic_Utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTests extends BaseClass
{
@Test(groups="smokeTest")
	public void createOrganization() throws Throwable
	{

		
	//	PropertyFile_Utility plib = new PropertyFile_Utility();
		 Java_Utility jlib = new Java_Utility();
	     Excel_Utility elib = new Excel_Utility();
	 /*   WebDriver_Utility wblib = new WebDriver_Utility();
	    
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
		HomePage hp = new HomePage(driver);
		hp.viewOrganizationHome();
	/*	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Un1);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();*/
		
		CreateOraganizationHomePage co = new CreateOraganizationHomePage(driver);
		co.createorg();
		int intrannum = jlib.getRandomNum();
		
		
		
		String value = elib.getdatafromexcel("sheet1", 0, 0)+intrannum;
		/*driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(value);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();*/
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.account(value);
		cop.savebutton();
		
		OrganizationVerificationPage ovp = new OrganizationVerificationPage(driver);
		WebElement vf = ovp.getVerify();
	
		String actmsg = vf.getText();
		Assert.assertEquals(actmsg.contains(value),true);
	   /* if(actmsg.contains(value))
		{
			System.out.println("Successful");
		}
		else
		{
			System.out.println("Not Successful");
	}*/
		/*WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

        wblib.actionclass(driver, ele);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
	//    hp.logout();
	     
	//	driver.close();
	}
}

