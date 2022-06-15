package practise;

import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActiWeb {

	public static void main(String[] args) throws Throwable 
	{
		
FileInputStream fis = new FileInputStream("./testfolder/test.properties");
Properties pro = new Properties();
pro.load(fis);
 String brow = pro.getProperty("browser1");
 String urln = pro.getProperty("url2");
 String uname = pro.getProperty("un2");
 String psd = pro.getProperty("pwd2");
 WebDriver driver = null;
 if(brow.equals("chrome"))
 {
	 WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
	 
 }
 else if(brow.equals("firefox"))
 {
WebDriverManager.firefoxdriver().setup();

driver = new FirefoxDriver();
 }
 else
 {
	 driver = new ChromeDriver(); 
 }
     driver.get(urln);
    driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(psd);
	driver.findElement(By.xpath("//div[.='Login ']")).click();

	}

	
}
