package org.pages;



import java.util.concurrent.TimeUnit;

import org.base.TestBase;
import org.base.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookResult extends TestBase {
	@FindBy(xpath = "//div[contains(@class,'CXW8mj _3nMexc')]//img[@alt='Why Not Me? A Feeling of Millions (English)']")
	WebElement bookimg;
	@FindBy(xpath = "//input[@id='pincodeInputId']")
	WebElement pncode;
	@FindBy(xpath = "//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")
	WebElement addcart;
	@FindBy(xpath = "//button[normalize-space()='SHOP']")
	WebElement buynow;

	// Initializing the Page Objects
	public BookResult(WebDriver wb) {
		PageFactory.initElements(wb, this);
	}

	public String getTitleofPage() throws Exception {
		Thread.sleep(3000);
		return driver.getTitle();
	}

	public boolean Bookimg() throws Exception {
		Thread.sleep(3000);
		return bookimg.isDisplayed();
	}

	public void pincode(String pc) throws Exception {
		Thread.sleep(3000);
		pncode.sendKeys(pc + Keys.ENTER);
	}

	public void addtocart() throws Exception {
		Thread.sleep(3000);
		try {
			addcart.click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void buyNow() throws Exception {
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		try {
			buynow.isEnabled();
			buynow.click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
