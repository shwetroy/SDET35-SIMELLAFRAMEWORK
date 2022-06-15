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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.simella.pomrepository.CampaignVerificationPage;
import com.crm.simella.pomrepository.CreateCampaignHomepage;
import com.crm.simella.pomrepository.CreateCampaignPage;
import com.crm.simella.pomrepository.HomePage;
import com.crm.simella.pomrepository.LoginPage;

import generic_Utility.BaseClass;
import generic_Utility.Excel_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.PropertyFile_Utility;
import generic_Utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWTest extends BaseClass
{
@Test(groups="smokeTest")
	public  void createCamp() throws Throwable
	{

	
		
		//PropertyFile_Utility plib = new PropertyFile_Utility();
		 Java_Utility jlib = new Java_Utility();
	     Excel_Utility elib = new Excel_Utility();
	   // WebDriver_Utility wblib = new WebDriver_Utility();
	    
	  /*  String browser = plib.getPropertykey("browser");
	    String Url1 = plib.getPropertykey("url1");
	    String Un1 = plib.getPropertykey("un1");
	    String pass = plib.getPropertykey("pwd1");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		wblib.webdriver_utility(driver);
		
		
		
		driver.get(Url1);
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(Un1, pass);*/
		HomePage hp = new HomePage(driver);
		hp.morebutton();
		hp.clickoncamp();
		hp.viewCampaignHome();
		
		CreateCampaignHomepage cp = new CreateCampaignHomepage(driver);
		
		cp.campaignPage();
		
		/*driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Un1);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='More']")).click();
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();*/
		
	     int intrannum	=jlib.getRandomNum();
		
		
	    String value = elib.getdatafromexcel("sheet1", 0, 0) +intrannum;
		
		/*driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(value);
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();*/
	    CreateCampaignPage ccp = new CreateCampaignPage(driver);
	    ccp.createCampaign(value);
	    ccp.save();
	    CampaignVerificationPage cvp = new CampaignVerificationPage(driver);
	     WebElement vf = cvp.getVerify();
		
		String actmsg = vf.getText();
		Assert.assertEquals(actmsg.contains(value),true);
		/*if(actmsg.contains(value))
			{
				System.out.println("Successful");
			}
			else
			{
				System.out.println("Not Successful");
		}*/
		
	//	hp.logout();
			
		/*	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
             wblib.actionclass(driver, ele);
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();*/
		     
		 //    driver.close();
	
	
		
	}
}

