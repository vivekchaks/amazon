package com.qa.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.BasePage;


public class LoginPage extends BasePage{
	
	// 1. page factory -- page objects
	
	@FindBy(xpath = "//a[@id= 'nav-link-accountList']")
	WebElement acctbtn;
	
	@FindBy(xpath = "//input[@id= 'ap_email']")
	WebElement emailid;
	
	@FindBy(xpath = "//input[@id= 'continue']")
	WebElement continuebtn;
	
	@FindBy(xpath = "//input[@id= 'ap_password']")
	WebElement passwrd;
	
	@FindBy(xpath = "//input[@id = 'signInSubmit']")
	WebElement loginbtn;
	
	
	// 2. create the constructor of Loginpage class and initialize your page
		// objects
	public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	
	
	
	public SearchPage doLogin(String username, String pwd){
		
		acctbtn.click();
		emailid.sendKeys(username);
		continuebtn.click();
		passwrd.sendKeys(pwd);
		loginbtn.click();
		
		return new SearchPage(driver);
		
		
	}

}
