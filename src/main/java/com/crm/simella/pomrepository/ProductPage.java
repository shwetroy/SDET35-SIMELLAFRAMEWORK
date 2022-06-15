package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
WebDriver driver;
public ProductPage() 

{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(name="productname")
private WebElement productname;

@FindBy(xpath="//input[@title=\'Save [Alt+S]\']")
private WebElement savebutton;

public WebElement getSavebutton() {
	return savebutton;
}
public WebDriver getDriver() {
	return driver;
}
public WebElement getProductname() {
	return productname;
}

public void nameOfProduct(String proname)
{
	productname.sendKeys(proname);
}
public void save() 
{
	savebutton.click();
}

}
