package generic_Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImgClass implements ITestListener
{
public void onTestFailure(ITestResult result)
{
	System.out.println("Failure");
	Java_Utility jlib = new Java_Utility();
	String testname= result.getMethod().getMethodName();
	
	EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.sdriver);
	
	File srcfile = edriver.getScreenshotAs(OutputType.FILE);
	
	File dst = new File ("./screenshot/"+testname+"-"+jlib.getSystemDateInIST()+".png");
	 try
	 {
		 FileUtils.copyFile(srcfile, dst);
	 }
	 catch (Exception e) 
	 {
		
	}
	
}
}
