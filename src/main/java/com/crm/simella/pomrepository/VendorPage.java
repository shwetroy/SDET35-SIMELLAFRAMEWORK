package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage 
{
	WebDriver driver;
	public VendorPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
@FindBy	(name="vendorname")
private WebElement vendorname;

@FindBy(xpath="//img[@title='Select']")
private WebElement save;
public WebDriver getDriver() {
	return driver;
}

public WebElement getVendorname() {
	return vendorname;
}

public WebElement getSave() {
	return save;
}
public void nameOfVendor(String vendname)
{
	vendorname.sendKeys(vendname);
}
public void saveButton()
{
	save.click();
}
}
