package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_Utility.Excel_Utility;
import generic_Utility.Java_Utility;
import generic_Utility.PropertyFile_Utility;
import generic_Utility.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentWithDelete {

	public static void main(String[] args) throws Throwable
	{
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
	    PropertyFile_Utility plib = new PropertyFile_Utility() ;
		WebDriver_Utility wlib = new WebDriver_Utility();
		
		String browser =plib.getPropertykey("browser");
		String Url =plib.getPropertykey("url1");
		String uname =plib.getPropertykey("un1");
		String pass =plib.getPropertykey("pwd1");
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();
		wlib.webdriver_utility(driver);
		if(browser.equals("firefox"))
		{
			System.out.println("Firefox is working");
		}
		else
		{
			System.out.println("Firefox is not working");
		}
		driver.get(Url);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[.='Documents'][1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
		int rannum = jlib.getRandomNum();
		String value = elib.getdatafromexcel("sheet1", 0, 0)+rannum;
		driver.findElement(By.name("notes_title")).sendKeys(value);
		
		String msg = driver.findElement(By.xpath(//class='dvHeaderText'))).
		
	}

}
