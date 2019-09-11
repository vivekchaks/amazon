package com.qa.amazon.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.amazon.base.BasePage;

public class ProductListPage extends BasePage{
	
	// 1. page factory -- page objects
	
	
	@FindBy(xpath = "//span[@class = 'a-button-text a-declarative']")
	WebElement sortdrpdwn;
	
	@FindBy(xpath = "//input[@id= 'add-to-cart-button']")
	WebElement addtocartbtn;
	
	@FindBy(xpath = "//a[@id = 'hlb-view-cart-announce']")
	WebElement cartbtn;
	
	@FindBy(xpath = "//span[@class = 'a-size-medium sc-product-title a-text-bold']")
	WebElement itemname;
	


	public ProductListPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void selectOptions(String value){
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[@class = 'a-nostyle a-list-link']//li//a"));
		
            for(WebElement option : options){
			
			System.out.println("Sorting Options : "+option.getText());
			
			if(option.getText().trim().equalsIgnoreCase(value)){
				
				option.click();
				break;
			}
		}
			
	}
	
	
	public void itemslist(String value){
		
		List<WebElement> itemsname = driver.findElements(By.xpath("//span[@class = 'a-size-medium a-color-base a-text-normal']"));
		
            for(WebElement option : itemsname){
			
			System.out.println("List of Item Names : "+option.getText());
			
			if(option.getText().trim().equalsIgnoreCase(value)){
				
				option.click();
				break;
			}
		}
		
	}
	
	
	public void gotoItemPage(){
		
		ProductListPage prdlstpg = new ProductListPage(driver);
		
		sortdrpdwn.click();
		prdlstpg.selectOptions("Price: Low to High");
		prdlstpg.itemslist("Uj Enterprise Compatible Micro-USB to USB 2.0 A Charge and Sync Cable for Asus Zenfone Zoom S Android Smartphones (White)");
		
		String mainWindow=driver.getWindowHandle();
		 // It returns no. of windows opened by WebDriver and will return Set of Strings
		 Set<String> set =driver.getWindowHandles();
		 // Using Iterator to iterate with in windows
		 Iterator<String> itr= set.iterator();
		 while(itr.hasNext()){
		 String childWindow=itr.next();
		 // Compare whether the main windows is not equal to child window. If not equal, we will close.
		 if(!mainWindow.equals(childWindow)){
		 driver.switchTo().window(childWindow);
		 System.out.println(driver.switchTo().window(childWindow).getTitle());
		 addtocartbtn.click();
		 cartbtn.click();
		 
		 String itemtext = itemname.getText();
		 Assert.assertEquals(itemtext, "Uj Enterprise Compatible Micro-USB to USB 2.0 A Charge and Sync Cable for Asus Zenfone Zoom S Android Smartphones (White)");
		 driver.close();
		 }
		 
		}
		 // Switching to the main window
		 driver.switchTo().window(mainWindow);
		 }

		
		
	}
	
	
	


