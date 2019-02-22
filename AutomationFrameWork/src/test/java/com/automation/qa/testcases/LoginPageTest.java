package com.automation.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automatiom.qa.base.TestBase;
import com.automation.qa.pages.HomePage;
import com.automation.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void validateLoginPageTitleTest(){
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Index");
	}
	
	@Test (priority=2)
	public void validateLaginPageLogoTest(){
		boolean flag= loginPage.validateLaginPageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test (priority=3)
	public void loginTest(){
		homePage=loginPage.login(prop.getProperty("email_id"));
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
}
