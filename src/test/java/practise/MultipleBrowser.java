package practise;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowser{

	public static void main(String[] args) throws Throwable
	{
	// get the java representation of the object for physical file
		
     FileInputStream fis = new FileInputStream("./testfolder/test.properties");
     
     //create  a object to property class to load all the keys
     
     Properties pro = new Properties();
     pro.load(fis);
     
     //read the value using getProperty("")
     
     String browser = pro.getProperty("browser");
     
    	 
     String Url1 = pro.getProperty("url1");
     String Un1 = pro.getProperty("un1");
     String pass = pro.getProperty("pwd1");
     
     // launch the browser
     WebDriver driver = null;
     if(browser.equals("chrome"))
     {
    	 WebDriverManager.chromedriver().setup();
    	 driver = new ChromeDriver();
    	 
     }
     else if(browser.equals("firefox"))
     {
    WebDriverManager.chromedriver().setup();
    driver = new FirefoxDriver();
     }
     else
     {
    	 driver = new ChromeDriver(); 
     }
    
     driver.get(Url1);
     driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Un1);
	 driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
     
     
     
     
	}

}

