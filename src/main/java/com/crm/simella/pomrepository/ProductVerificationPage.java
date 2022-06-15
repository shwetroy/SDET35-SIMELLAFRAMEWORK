package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductVerificationPage
{
	WebDriver driver;

	public  ProductVerificationPage (WebDriver driver)
	{
		this.driver =driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verify;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getVerify() {
		return verify;
	}
}
