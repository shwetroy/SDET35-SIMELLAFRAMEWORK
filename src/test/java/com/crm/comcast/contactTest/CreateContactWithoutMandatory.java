package com.crm.comcast.contactTest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.simella.pomrepository.ContactHomePage;
import com.crm.simella.pomrepository.ContactVerificationPage;
import com.crm.simella.pomrepository.CreateContactPage;
import generic_Utility.BaseClass;

public class CreateContactWithoutMandatory extends BaseClass
{
@Test
	public  void createContactwithoutMandate() 
	{
	ContactHomePage chp = new ContactHomePage(driver);
	
	chp.clickcontact();
	chp.contactpage();
	CreateContactPage ccp = new CreateContactPage(driver);
	ccp.alertMsgonSavingWithoutLastName();
	
	ContactVerificationPage cvp = new ContactVerificationPage(driver);
	WebElement vf = cvp.getVerifythePage();
	String actmsg = vf.getText();
	if(actmsg.contains("Creating New Contact"))
	{
	System.out.println("Verified");
	}
	else
	{
		System.out.println("Not Verified");
	}
	
	}
	
	
	
	

	}


