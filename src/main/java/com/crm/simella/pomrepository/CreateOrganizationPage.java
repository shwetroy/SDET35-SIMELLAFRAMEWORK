package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage 
{
WebDriver driver;
public CreateOrganizationPage (WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements( driver,this);
}
@FindBy(name="accountname")
private WebElement accname;

@FindBy(xpath="//input[@title=\'Save [Alt+S]\']")
private WebElement save;

public void account(String acname)
{
	accname.sendKeys(acname);
}

public void savebutton()
{
	save.click();
}

}
