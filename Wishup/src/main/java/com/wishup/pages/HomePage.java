package com.wishup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='ui simple dropdown item']")
	private WebElement dropDownTest;
	
	@FindBy(linkText="Logout")
	private WebElement btnLogout;
	
	
	public void moveToDropDownTest()
	{
		Actions act =new Actions(driver);
		act.moveToElement(dropDownTest).perform();
	}
	
	
	public void clickLogout()
	{
		btnLogout.click();
	}	
	
	

}
