package org.pages;

import org.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends TestBase {
	
	@FindBy(xpath="//div[@class='_3nWYNs']//img")
	WebElement applelogo;
	@FindBy(xpath="//span[@class='B_NuCI']")
	WebElement pname;
	@FindBy(xpath="//input[@id='pincodeInputId']")
	WebElement pncode;
	@FindBy(xpath="//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")
	WebElement addcart;
	@FindBy(xpath="//button[normalize-space()='BUY NOW']")
	WebElement buynow;
	public SearchResultPage(WebDriver wb) {
		PageFactory.initElements(wb, this);
		Logger = Logger.getLogger(Login.class.getName());
		
		}
	public boolean productName() throws Exception {
		 Logger.info("validating product name");	
		Thread.sleep(3000);
		return pname.isDisplayed();
	}
	public String getTitleofPage() throws Exception {
		 Logger.info("validating page title");	
		Thread.sleep(3000);
		return driver.getTitle();
	}
	public boolean appleLogo() throws Exception {
		Logger.info("validating apple logo in the page");	
		Thread.sleep(3000);
		return applelogo.isDisplayed();
	}
	public void pincode(String pc) throws Exception {
		Logger.info("validating pincode picode box in the page");	
		Thread.sleep(3000);
		pncode.sendKeys(pc+Keys.ENTER);	
	}
	public void addtocart() throws Exception {
		Logger.info("validating add to cart button and navigeted right page");	
		Thread.sleep(3000);
		try {
			addcart.click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void buyNow() throws Exception {
		Logger.info("validating add to save button and navigeted right page");
		Thread.sleep(3000);
		 try {
			buynow.click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
