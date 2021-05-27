package org.pages;

import org.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends TestBase {
	
	@FindBy(xpath="//input[@placeholder='Enter delivery pincode']")
	WebElement pincode;
	@FindBy(xpath="//img[@class='_396cs4 _3exPp9']")
	WebElement mobileimg;
	
	@FindBy(xpath="//span[normalize-space()='Hyderabad - 500009']")
	WebElement pinvalidate;
	@FindBy(xpath="//div[normalize-space()='Save for later']")
	WebElement savelater;
	@FindBy(xpath="//img[@class='_2giOt4']")
	WebElement savelatervalidate;
	@FindBy(xpath="//div[normalize-space()='Move to cart']")
	WebElement movetocart;
	@FindBy(xpath="//div[normalize-space()='Remove']")
	WebElement remove;
	@FindBy(xpath="//div[@class='_1DATsP']")
	WebElement rmsg;
	@FindBy(xpath="//div[@class='_3dsJAO _24d-qY RxvIII']")
	WebElement cnclbtn;
	
	@FindBy(xpath="//span[normalize-space()='Place Order']")
	WebElement placeorder;
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//button[2]")
	WebElement addonemore;
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//button[1]")
	WebElement minusone;
	
	
	public CartPage(WebDriver wb) {
		PageFactory.initElements(wb, this);
		Logger = Logger.getLogger(Login.class.getName());
		
	}
	
	//validating the cart page title
	public String getTitleofPage() throws Exception {
		Logger.info("validating page title");	
		Thread.sleep(3000);
		return driver.getTitle();
	}
	
	
	public boolean mobileimage() {
		Logger.info("validating internal storage dropdown");
		return mobileimg.isDisplayed();
	}
	
	//validate pincode 
	
	public boolean pincodes(String str) throws Exception {
		Logger.info("validating pincode bar in the page");	
		Thread.sleep(3000);
		pincode.sendKeys(str+Keys.ENTER);
		Thread.sleep(3000);
		return pinvalidate.isDisplayed();
		
	}
	
	//validate save later 
	public boolean savelaterlist() throws Exception {
		Logger.info("validating  savelater button");	
		Thread.sleep(3000);
		savelater.click();
		Thread.sleep(3000);
		return savelatervalidate.isDisplayed();
	}
	//validate move to cart 
	public void movetocart() throws Exception {
		Logger.info("validating  validating move to cart");	
		Thread.sleep(3000);
		movetocart.click();
		Thread.sleep(3000);
	}
	public void placeorders() throws Exception {
		Logger.info("validating  place order");	
		Thread.sleep(3000);
		placeorder.click();
	}
	public boolean addonemore() throws Exception {
		Logger.info("validating  + button");	
		Thread.sleep(3000);
		return addonemore.isEnabled();
	}
	public boolean minusone() throws Exception {
		Logger.info("validating  - button");	
		Thread.sleep(3000);
		return minusone.isEnabled();
	}
	public boolean removefromlist() throws Exception {
		Logger.info("validating  remove button");	
		Thread.sleep(3000);
		remove.click();
		Thread.sleep(3000);
		boolean b =rmsg.isDisplayed();
		cnclbtn.click();
		return b;
	}
	
}
