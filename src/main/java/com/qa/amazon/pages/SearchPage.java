package com.qa.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.BasePage;

public class SearchPage extends BasePage{
	
	
	// 1. page factory -- page objects
	
	@FindBy(xpath = "//input[@id= 'twotabsearchtextbox']")
	WebElement prdsearch;
	
	@FindBy(xpath = "//input[@type= 'submit' and @class = 'nav-input']")
	WebElement searchbtn;

	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public ProductListPage productsearch(String productname){
		
		prdsearch.sendKeys(productname);
		searchbtn.click();
		
		return new ProductListPage(driver);
		
	}

}
