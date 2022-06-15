package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class VendorHomePage
{
WebDriver driver;
public VendorHomePage (WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
}
@FindBy(xpath="//img[@title='Create Vendor...']")
private WebElement vendorbutton;
public WebDriver getDriver() {
	return driver;
}
public WebElement getVendorbutton() {
	return vendorbutton;
}

public void clickOnVendor()
{
	vendorbutton.click();
}

}
