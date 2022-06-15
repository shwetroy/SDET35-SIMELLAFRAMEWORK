package practise;


		import java.io.FileInputStream;
import java.util.Iterator;
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

import com.crm.simella.pomrepository.HomePage;
import com.crm.simella.pomrepository.LoginPage;
import com.crm.simella.pomrepository.VendorHomePage;
import com.crm.simella.pomrepository.VendorPage;

import generic_Utility.Excel_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.PropertyFile_Utility;
import generic_Utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

		public class PuchaseOrderTestCase28
		{

			public static void main(String[] args) throws Throwable
			{

			
				PropertyFile_Utility plib = new PropertyFile_Utility();
				Java_Utility jlib = new Java_Utility();
			     Excel_Utility elib = new Excel_Utility();
			    WebDriver_Utility wblib = new WebDriver_Utility();
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				
				wblib.webdriver_utility(driver);
				String browser =plib.getPropertykey("browser");
				String Url1 = plib.getPropertykey("url1");
			    String Un1 = plib.getPropertykey("un1");
			    String pass = plib.getPropertykey("pwd1");
				driver.get(Url1);
				LoginPage lp = new LoginPage(driver);
				lp.LoginToApp(Un1, pass);
				HomePage hp = new HomePage(driver);
				hp.morebutton();
				hp.vendorButton();
				VendorHomePage vhp = new VendorHomePage(driver);
				vhp.clickOnVendor();
				
			/*	driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Un1);
				driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
				driver.findElement(By.xpath("//input[@type='submit']")).click();
				driver.findElement(By.xpath("//a[.='More']")).click();
				driver.findElement(By.name("Vendors")).click();
				driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();*/
				
				int intrannum1 = jlib.getRandomNum();
				
				String value=elib.getdatafromexcel("sheet1", 0, 0)+intrannum1;
				VendorPage vp = new VendorPage(driver);
				vp.nameOfVendor(value);
				vp.saveButton();
				hp.morebutton();
				hp.purchaseOrderButton();
				
				/*driver.findElement(By.name("vendorname")).sendKeys(value);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				driver.findElement(By.xpath("//a[.='More']")).click();
				driver.findElement(By.name("Purchase Order")).click();
				driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();*/
				
			
				int intrannum2 = jlib.getRandomNum();
				
				String value1 = elib.getdatafromexcel("sheet1", 1, 0)+intrannum2;
			/*	driver.findElement(By.name("subject")).sendKeys(value1);
				
				driver.findElement(By.xpath("//img[@title='Select']")).click();*/
				
				wblib.switchToWindow(driver, "Vendors&action");
				/*String parent = driver.getWindowHandle();
				System.out.println(parent);
				Set<String> set1 = driver.getWindowHandles();
				Iterator<String> it1= set1.iterator();//loop
				while(it1.hasNext())
				{
					String cid = it1.next();
					driver.switchTo().window(cid);
					String title1 = driver.getTitle();
					if (title1.contains("Vendors&action"))
					{
						break;
					}
				}*/
				
				driver.findElement(By.id("search_txt")).sendKeys(value);
				driver.findElement(By.name("search")).click();
				driver.findElement(By.linkText(value)).click();
				Thread.sleep(2000);
			//	driver.switchTo().window(parent);
				wblib.switchToWindow(driver, "PurchaseOrder&action");
				
				driver.findElement(By.name("ship_street")).sendKeys("Beliaghata Main Road kolkata");
				driver.findElement(By.xpath("//input[@onclick='return copyAddressLeft(EditView)']")).click();
				
			
				
				driver.findElement(By.id("searchIcon1")).click();
				wblib.switchToWindow(driver, "Products&action") ;
			/*	String parent1 = driver.getWindowHandle();
				Set<String> child = driver.getWindowHandles();
				Iterator<String> it2 =child.iterator();
				while(it2.hasNext()) 
				{
					
					String cid = it2.next();
					driver.switchTo().window(cid);
					String title = driver.getTitle();
					if(title.contains("Products&action"))
					{
						System.out.println("Verify");
					}
					else
					{
						System.out.println("Not Verified");
					}
					
				}*/
				
				    
			        driver.findElement(By.id("search_txt")).sendKeys("Sim1");
					driver.findElement(By.name("search")).click();
					driver.findElement(By.xpath("//a[.='Sim1']")).click();
					Thread.sleep(2000);
					//driver.switchTo().window(parent1);
					wblib.switchToWindow(driver, "PurchaseOrder&action");
					Thread.sleep(3000);
				     
				     driver.findElement(By.id("qty1")).sendKeys("1");
					 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					 
					 
					 
					 WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
						
				     
						wblib.actionclass(driver, ele1);
						driver.findElement(By.xpath("//a[.='Sign Out']")).click();
					    
						driver.close();
				

	}

}
