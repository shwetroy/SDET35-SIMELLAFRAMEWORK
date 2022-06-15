package practise;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic_Utility.BaseClass;

@Listeners(generic_Utility.ListenerImgClass.class)

public class Listener extends BaseClass
{
@Test
public void screenshot()
{
	System.out.println("Test Starts");
	
	Assert.assertEquals(false ,true);
	
	System.out.println("Test Ends");
}
}
