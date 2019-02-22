package com.automation.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automatiom.qa.base.TestBase;
import com.automation.qa.pages.HomePage;
import com.automation.qa.pages.LoginPage;
import com.automation.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	String sheetName="Registration";
	
	public HomePageTest(){
		super();
	}
		@BeforeMethod
	public void setup(){
		initialization();
		loginPage = new LoginPage();
		homePage= new HomePage();
		testUtil= new TestUtil();
		homePage=loginPage.login(prop.getProperty("email_id"));
		
	}
	
	@DataProvider
	public Object getRegistrationData(){
		Object data [] []= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getRegistrationData")
	public void createNewRegustrationTest(String First_Name,String Last_Name,String Email_Address,String Phone,String Country, String Year, 
			String Month,String Day,String Password,String Confirm_Password){
		homePage.createNewRegustration(First_Name, Last_Name, Email_Address, Phone, Country, Year, Month, Day, Password, Confirm_Password);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
