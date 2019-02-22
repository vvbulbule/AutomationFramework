package com.automation.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automatiom.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//input[contains(@ng-model,'FirstName')]")
	WebElement firstName;
	
	@FindBy(xpath="//input[contains(@ng-model,'LastName')]")
	WebElement lastName;
	
	@FindBy(xpath="//input[contains(@type,'email')]")  
	WebElement emailId;
	
	@FindBy(xpath="//input[contains(@ng-model,'Phone')]")
	WebElement phnoeNo;
	
	@FindBy(xpath="//input[starts-with(@value,'Male')]")
	WebElement maleRadioBtn;
	
	@FindBy(xpath="//input[starts-with(@value,'FeMale')]")  
	WebElement feMaleRadioBtn;  
	
	@FindBy(xpath=".//*[@id='countries']")
	WebElement countryDropDown;  
	
	@FindBy(xpath=".//*[@id='yearbox']")
	WebElement YearDropDown; 
	
	@FindBy(xpath=".//*[@id='basicBootstrapForm']/div[11]/div[2]/select")
	WebElement monthDropDown; 
	
	@FindBy(xpath=".//*[@id='daybox']")  
	WebElement DayDropDown; 
	
	@FindBy(xpath=".//*[@id='firstpassword']")
	WebElement passwordText; 
	
	@FindBy(xpath=".//*[@id='secondpassword']")   
	WebElement ConfirmPass; 
	
	@FindBy(xpath=".//*[@id='submitbtn']")
	WebElement SubmitBtn; 
	
	@FindBy(xpath=".//*[@id='Button1']")
	WebElement RefreshBtn; 
	
	//Intialization of webElements
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void createNewRegustration(String ftName,String lstName,String email,String Phon,String contry, String Year, 
			String Month,String Day,String pass,String cnfPass ){
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(lstName);
		emailId.sendKeys(email);
		phnoeNo.sendKeys(Phon);
		maleRadioBtn.click();
		
	Select countryDropDown1 = new Select(countryDropDown);
	countryDropDown1.selectByVisibleText(contry);
	
	Select YearDropDown1 = new Select(YearDropDown);
	YearDropDown1.selectByVisibleText(Year);
	
	Select MonthDropDown1 = new Select(monthDropDown);
	MonthDropDown1.selectByVisibleText(Month);
	
	Select DayDropDown1 = new Select(DayDropDown);
	DayDropDown1.selectByVisibleText(Day);
	
	passwordText.sendKeys(pass);
	ConfirmPass.sendKeys(cnfPass);
	
	SubmitBtn.click();
	RefreshBtn.click();
	
	
	}
	
}
	
	
	
	
	

