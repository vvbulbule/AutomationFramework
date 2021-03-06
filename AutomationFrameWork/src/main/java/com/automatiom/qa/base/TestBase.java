/* Author:  Vikrant Bulbule 1 5 March 2019*/


package com.automatiom.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.automation.qa.util.TestUtil;
import com.automation.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;




public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventLitener;
	
	// Constructor to Read the Configuration File
	public TestBase(){
		try{
			prop= new Properties();
			//FileInputStream ip =new FileInputStream("/home/vbulbule/git/AutomationFramework/AutomationFrameWork/src/main/java/com/automation/qa/config/config.properties");
			FileInputStream ip =new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/automation/qa/config/config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			//System.setProperty("webdriver.chrome.driver", "/home/vbulbule/Selenium 3.14/chromedriver");
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver");
			WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver();
			
		} else if (browserName.equals("FF")){
			WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventLitener = new WebEventListener();
		e_driver.register(eventLitener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	
}
