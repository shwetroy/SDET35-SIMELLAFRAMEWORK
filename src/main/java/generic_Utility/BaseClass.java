package generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.simella.pomrepository.HomePage;
import com.crm.simella.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
public	PropertyFile_Utility plib=new PropertyFile_Utility();
public  WebDriver_Utility wblib=new WebDriver_Utility();
 
public WebDriver driver = null;
public static WebDriver sdriver=null;
@BeforeSuite(groups= {"smokeTest","regressionTest"})
public void baseClass()
{
	System.out.println("database connection");
}
@BeforeTest(groups= {"smokeTest","regressionTest"})
public void baseTest() 
{
System.out.println("execute script in parallel execution");	
}
@Parameters("browser")
@BeforeClass(groups= {"smokeTest","regressionTest"})
public void beforeClass(@Optional("chrome") String browser) throws Throwable
{
	//browser =plib.getPropertykey("browser");
	if(browser.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	}
	else if(browser.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
	    driver= new FirefoxDriver();
	}
	else
	{
		driver= new ChromeDriver();
	}
	wblib.webdriver_utility(driver);
	sdriver=driver;
    String Url1 = plib.getPropertykey("url1");
    driver.get(Url1);
    driver.manage().window().maximize();
}

@BeforeMethod(groups= {"smokeTest","regressionTest"})
public void beforeMethod()throws Throwable
{   
	String Un1 = plib.getPropertykey("un1");
    String pass = plib.getPropertykey("pwd1"); 
    LoginPage lp = new LoginPage(driver);
	lp.LoginToApp(Un1, pass);
	
	
}
@AfterMethod(groups= {"smokeTest","regressionTest"})
public void afterMethod()
{
	HomePage hp = new HomePage(driver);
	hp.logout();

}
@AfterClass(groups= {"smokeTest","regressionTest"})
public void afterClass()
{
	driver.close();
}
@AfterTest(groups= {"smokeTest","regressionTest"})
public void afterTest()
{
	System.out.println("Parallel execution is done");
	
}
@AfterSuite(groups= {"smokeTest","regressionTest"})
public void afterSuite()
{
	System.out.println("Database is disconnected");
}
}
