package com.crm.simella.pomrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriver_Utility;

public class CreateCampaignPage extends WebDriver_Utility
{
WebDriver driver;

public CreateCampaignPage(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver,this);
	
}
@FindBy(xpath="//input[@name='campaignname']")
private WebElement nameofcampaign;

@FindBy(xpath="//input[@value='  Save  ']")
private WebElement save;

@FindBy(xpath="//img[@alt='Select']")
private WebElement selectbutton;

@FindBy(name="search_text")
private WebElement searchtextfied;

@FindBy(name="search")
private WebElement searchOnbutton;

@FindBy(xpath="//a[.='Simella']")
private WebElement fetchTheProduct;


public WebElement getFetchTheProduct() {
	return fetchTheProduct;
}

public WebElement getSearchtextfied() {
	return searchtextfied;
}

public WebElement getSearchOnbutton() {
	return searchOnbutton;
}

public WebElement getSelectbutton() 
{
	return selectbutton;
}

public WebDriver getDriver()
{
	return driver;
}

public WebElement getNameofcampaign()
{
	return nameofcampaign;
}

public WebElement getSave()
{
	return save;
	
}
public void createCampaign(String campname)
{
	nameofcampaign.sendKeys(campname);
}

public void clickOnAddPro()
{
	selectbutton.click();
}

public void addProduct(String prodname)
{
	
	
    switchToWindow(driver,"Products&action");
    searchtextfied.sendKeys(prodname);
    searchOnbutton.click();
    fetchTheProduct.click();
   switchToWindow(driver,"Campaigns&action" );
    
    
	
}
public void save() 
{
	save.click();
}
}
