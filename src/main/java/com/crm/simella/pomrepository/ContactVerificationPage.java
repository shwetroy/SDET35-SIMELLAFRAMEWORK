package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactVerificationPage
{
	WebDriver driver;

	public ContactVerificationPage(WebDriver driver)
	{
		this.driver =driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verify;
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement verifythePage;

	public WebElement getVerifythePage() {
		return verifythePage;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getVerify() {
		return verify;
	}
	
	
}
