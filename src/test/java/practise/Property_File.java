package practise;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Property_File {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		FileInputStream fis =  new FileInputStream("./testfolder/test.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		 System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			
			Thread.sleep(2000);
			driver.get(pro.getProperty("url1"));
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(pro.getProperty("un1"));
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pro.getProperty("pwd1"));
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
		

	}

}
