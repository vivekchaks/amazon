package com.qa.amazon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.amazon.base.BasePage;
import com.qa.amazon.pages.LoginPage;
import com.qa.amazon.pages.SearchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;




public class LoginPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	SearchPage searchpage;
	
	
	@BeforeMethod
	public void setUp(){
		
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		
		
	}
	
	
	@Test
	public void loginTestWithCorrectCredentialsTest(){
		searchpage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
