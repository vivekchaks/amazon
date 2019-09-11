package com.qa.amazon.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.amazon.base.BasePage;
import com.qa.amazon.pages.LoginPage;
import com.qa.amazon.pages.ProductListPage;
import com.qa.amazon.pages.SearchPage;

public class SearchPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	SearchPage searchpage;
	ProductListPage productlistpage;
	
	
	@BeforeMethod
	public void setUp(){
		
		basePage = new BasePage();
		prop = basePage.initialize_Properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		searchpage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		productlistpage = new ProductListPage(driver);
		
	}
	
	@Test
	public void verifyproductsearch(){
		
		productlistpage = searchpage.productsearch(prop.getProperty("productname"));
			
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
