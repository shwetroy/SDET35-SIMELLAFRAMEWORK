package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriver_Utility;

public class ContactHomePage extends WebDriver_Utility
{
WebDriver driver;

public ContactHomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements( driver,this);
}

@FindBy(xpath="//a[@href=\"index.php?module=Contacts&action=index\"]")
private WebElement clickoncontact;

public WebElement getClickoncontact()
{
	return clickoncontact;
}

@FindBy(xpath="//img[@title=\'Create Contact...\']")
private WebElement contactpage;

public WebDriver getDriver() {
	return driver;
}

public WebElement getContactpage() {
	return contactpage;
}

public void contactpage()
{
	contactpage.click();
	
}
public void clickcontact()
{
	clickoncontact.click();
}



}
