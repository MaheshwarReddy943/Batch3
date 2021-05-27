package org.pages;

import org.base.CustomListener;
import org.base.TestBase;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

public class FashionTop extends TestBase {
	
	@FindBy(xpath="//img[@alt='Fashion']")
	WebElement fashion;
	@FindBy(xpath="//div[@class='_1YAKP4']//select[@class='_2YxCDZ']")
	WebElement min;
	@FindBy(xpath="//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
	WebElement max;
	@FindBy(xpath="//div[contains(text(),'Brand')]")
	WebElement brand;
	@FindBy(xpath="//div[@class='_3879cV'][normalize-space()='Raymond']")
	WebElement raymond;
	@FindBy(xpath="//div[contains(text(),'Customer Ratings')]")
	WebElement rating;
	@FindBy(xpath="//div[@title='4★ & above']//div[@class='_1Y4Vhm _4FO7b6']")
	WebElement rate;
	@FindBy(xpath= "//a[normalize-space()= \"Men's Top Wear\"]")
	WebElement top;
	@FindBy(xpath= "//a[normalize-space()= \"Men's Blazers\"]")
	WebElement blazer;
	@FindBy(xpath="//a[@title='Solid Bandhgala Formal Men Blazer'] ")
	WebElement selectProduct;
	

	
	
	
	public FashionTop(WebDriver wb) {
		PageFactory.initElements(wb, this);
		Logger = Logger.getLogger(FashionTop.class.getName());
		}
	
	
	public void fashionFlipkart() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(fashion).build().perform();
		//Thread.sleep(3000);
		action.moveToElement(top).build().perform();
	blazer.click();
		
	}
	public WebElement MinPrice() throws Exception {
		Thread.sleep(4000);
		return min;
	}
	public WebElement MaxPrice() throws Exception {
		Thread.sleep(5000);
		return max;
	}
	public void Brand() throws Exception {
		//Thread.sleep(3000);
		brand.isEnabled();
		//Thread.sleep(3000);
		raymond.click();
		
	}
	public void Rating() throws Exception {
		Thread.sleep(3000);
		rating.isEnabled();
		Thread.sleep(3000);
	    rate.click();
		
	}
	public void Product() throws Exception {
		Thread.sleep(3000);
		raymond.click();
		Thread.sleep(3000);
		selectProduct.click();
		
	}
	
	

	
	
	
 

}
