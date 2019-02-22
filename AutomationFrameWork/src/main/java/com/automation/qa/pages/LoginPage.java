package com.automation.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automatiom.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath="//img[contains(@id,'logo')]")
	WebElement loginLogo; 
	
	@FindBy(xpath="//input[contains(@id,'email')]")
	WebElement emailid;
	
	@FindBy(xpath="//img[contains(@id,'enterimg')]")
	WebElement loginBtn;  
	
	@FindBy(xpath="//button[text()='Sign In']")   
	WebElement SignInBtn;   
	
	
	@FindBy(xpath="//button[contains(@id,'btn2')]")
	WebElement SkipSignInBtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateLaginPageLogo(){
		return loginLogo.isDisplayed();
	}
	
	public HomePage login(String email){
		emailid.sendKeys(email);
		loginBtn.click();
		return new HomePage();
	}
	
	

}
