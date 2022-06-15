package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_Utility.WebDriver_Utility;

public class CreateContactPage extends WebDriver_Utility

{
WebDriver driver;

public CreateContactPage(WebDriver driver)
{
	this.driver =driver;
PageFactory.initElements(driver,this);
}

@FindBy(name="lastname")
private WebElement lastname;

@FindBy(xpath="//input[@value='  Save  ']")
private WebElement save;

@FindBy(xpath="//input[@title=\'Delete [Alt+D]\']")
private WebElement delete;

public WebDriver getDriver() {
	return driver;
}

public WebElement getLastname() {
	return lastname;
}

public WebElement getSave() {
	return save;
}

public WebElement getDelete() {
	return delete;
}
public void createContactPage(String lastnam)
{
lastname.sendKeys(lastnam);

}

public void saveonclick()
{
	save.click();	
}
public void deleteContact()
{
	delete.click();
	alertaction(driver, "Are you sure you want to delete this record?");
}
public void alertMsgonSavingWithoutLastName()
{   save.click();
	alertaction(driver, "Last Name cannot be empty");
}
}
