package com.crm.simella.pomrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriver_Utility;

public class HomePage extends WebDriver_Utility
{
WebDriver driver;

public HomePage (WebDriver driver)
{
	this.driver=driver;
PageFactory.initElements(driver,this);	
}
@FindBy(xpath="//a[.='Organizations']")
private WebElement organization;

@FindBy(xpath="//a[.='More']")
private WebElement more;

@FindBy(name="Campaigns")
private WebElement campaignclick;

@FindBy(xpath="//img[@alt='Create Campaign...']")
private WebElement campaign;

@FindBy(xpath="//a[.='Contacts']")
private WebElement contact;

@FindBy(xpath="//a[.='Products']")
private WebElement product;

@FindBy(xpath="//a[.='Vendors']")
private WebElement vendor;

@FindBy(xpath="//a[.='Purchase Order']")
private WebElement purchaseorder;

@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement administrator;

@FindBy(linkText = "Sign Out")
private WebElement signingout;

public WebDriver getDriver() {
	return driver;
}

public WebElement getOrganization() {
	return organization;
}

public WebElement getMore() {
	return more;
}

public WebElement getCampaign() {
	return campaign;
}

public WebElement getContact() {
	return contact;
}

public WebElement getProduct() {
	return product;
}

public WebElement getVendor() {
	return vendor;
}

public WebElement getPurchaseorder() {
	return purchaseorder;
}

public WebElement getAdministrator() {
	return administrator;
}

public WebElement getSigningout() {
	return signingout;
}

public WebElement getCampaignclick()
{
	return campaignclick;
}
public void logout()
{
	actionclass(driver, administrator);
	
	signingout.click();
}

public void ViewHomePage()
{

	contact.click();
	
	}

public void viewOrganizationHome()
{
	organization.click();
}

public void clickoncamp()
{
	campaignclick.click();
}
public void viewCampaignHome() 
{
	campaign.click();
}
public void morebutton()
{
	more.click();
}
public void productButton()
{
	product.click();
}
public void vendorButton()
{
	vendor.click();
}
public void purchaseOrderButton()
{
	purchaseorder.click();
}
}

