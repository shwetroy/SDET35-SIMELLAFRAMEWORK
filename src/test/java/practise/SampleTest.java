package practise;

import org.testng.annotations.Test;

public class SampleTest
{
	@Test()
	
	public void createContactTest()

	{
		System.out.println("contacts created");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	
	public void modifyContactTest() 
	{
	System.out.println("Contacts Modified");
     }
	
	@Test(invocationCount = 4)
	public void deleteContactTest()
	{
		System.out.println("Contacts Deleted");
	}
}

