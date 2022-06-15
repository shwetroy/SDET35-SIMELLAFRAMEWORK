package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductHomePage 
{
WebDriver driver;
public ProductHomePage()
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//img[@img=src=\'themes/softed/images/btnL3Add.gif\']")
private WebElement productclick;

public WebDriver getDriver() 
{
	return driver;
}
public WebElement getProductclick() {
	return productclick;
}

public void clickOnProduct()
{
	productclick.click();	
}
}
