package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOraganizationHomePage
{
WebDriver driver;
public CreateOraganizationHomePage(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//img[@alt='Create Organization...']")
private WebElement clickonorganization;
public WebDriver getDriver() {
	return driver;
}
public WebElement getClickonorganization() {
	return clickonorganization;
}
public void createorg()
{
	clickonorganization.click();
}
}
