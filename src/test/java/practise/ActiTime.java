package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActiTime {

	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.actitime.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("manager");
		driver.findElement(By.xpath("//div[.='Login ']")).click();

	}

}