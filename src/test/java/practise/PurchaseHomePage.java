package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseHomePage
{
	WebDriver driver;
	public PurchaseHomePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
@FindBy(xpath="//img[@title='Create Purchase Order...']")
private WebElement newpurchase;

}
