package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignHomepage
{
WebDriver driver;
public CreateCampaignHomepage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
	
}
@FindBy(xpath="//img[@alt='Create Campaign...']")
private WebElement clickoncampaign;
public WebDriver getDriver() {
	return driver;
}
public WebElement getClickoncampaign() {
	return clickoncampaign;
}
public void campaignPage()
{
	clickoncampaign.click();	
}
}
