package generic_Utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility
{

	public void webdriver_utility(WebDriver driver)
	{
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


/** This is used to wait till it fetches  the address and release the control if its available
 * @return 
*@shweta
*/
	public  void waitforpage(WebDriver driver, String urlpage)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(urlpage));
	}
	/** This is used to wait till it loads the page 
	 * @shweta
	  */
	public void waitforelement(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.visibilityOf(element));
	}
	/*This is used  to give till it find that particular element
	 *@shweta 
	 */
	public void switchToWindow(WebDriver driver,String partialwindow)
	{
		//String parent = driver.getWindowHandle();
		//System.out.println(parent);
		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1= set1.iterator();//loop
		while(it1.hasNext())
		{
			String cid = it1.next();
			driver.switchTo().window(cid);
			String title1 = driver.getTitle();
			if (title1.contains(partialwindow))
			{
				break;
			}
		}
		
		
	}
	/** This is used to switch window from parent to child and then again move the control back to parent
	 * @shweta
	 */
	public void actionclass(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/** This is used to perform mouse hover action
	 * @shweta
	 */
	 public void selectclass(WebElement element,String text)
	 {
		 Select sel = new Select(element);
		 sel.selectByVisibleText(text);
	 }
	 /** This is used to perform dropdown action
	  * @shweta
	  */
	  public void alertaction(WebDriver driver, String expmsg)
	  {
		 Alert al = driver.switchTo().alert();
		 if(al.getText().trim().equalsIgnoreCase(expmsg.trim()))
		 {
			 System.out.println("Alert Msg Verified");
		 }
		 else
		 {
			 System.out.println("Alert Msg is not Verified");
	  }
	  al.accept();
}
	/** This is used to handle popup
	 * @shweta
	 */
	 
}