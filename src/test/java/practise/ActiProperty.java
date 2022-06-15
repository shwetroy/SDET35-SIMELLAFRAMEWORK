package practise;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActiProperty {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream("./testfolder/test.properties");
		Properties pro = new Properties();
		pro.load(fis);
		System.setProperty("webdriver.gecko.driver","./softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get(pro.getProperty("url2"));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(pro.getProperty("un2"));
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pro.getProperty("pwd2"));
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		

	}

}
