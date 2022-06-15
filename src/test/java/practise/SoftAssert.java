package practise;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class SoftAssert 
{
@Test
public void CreateContact()
{
	System.out.println("test1");
	System.out.println("test2");
	org.testng.asserts.SoftAssert soft=new org.testng.asserts.SoftAssert();
	
	soft.assertEquals("a", "b");
	System.out.println("test3");
	System.out.println("test4");
	soft.assertAll();
}

@Test
public void CreateOrganisation()
{
	System.out.println("test5");
	System.out.println("test6");
	System.out.println("test7");
}

}
