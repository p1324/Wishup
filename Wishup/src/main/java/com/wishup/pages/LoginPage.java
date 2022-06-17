package com.wishup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement userId;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement btnLogin;
	
	public void setUserName(String uname)
	{
		userId.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	
	public void clickLogin()
	{
		btnLogin.click();
	}	
	
	

}
