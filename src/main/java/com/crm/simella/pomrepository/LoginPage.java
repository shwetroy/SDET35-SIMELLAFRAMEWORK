package com.crm.simella.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 

{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	
		
@FindBy(name="user_name")
private WebElement username;

@FindBy(name="user_password")
private WebElement password;

@FindBy(id="submitButton")
private WebElement login;
public WebDriver getDriver() {
	return driver;
}

public WebElement getUsername() {
	return username;
}

public WebElement getPassword() {
	return password;
}

public WebElement getLogin() {
	return login;
}

public void LoginToApp(String uname, String pass)
{
	username.sendKeys(uname);
	password.sendKeys(pass);
	login.click();
	
}



}


