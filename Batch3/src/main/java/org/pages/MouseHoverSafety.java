package org.pages;

import java.util.concurrent.TimeUnit;

import org.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MouseHoverSafety extends TestBase {

	@FindBy(xpath = "//a[normalize-space()='DETTOL Instant Hand Sanitizer Bottle']")
	WebElement select;

	@FindBy(xpath = "//img[@alt='DETTOL Instant Hand Sanitizer Bottle']")
	WebElement img;
	@FindBy(xpath = "//input[@id='pincodeInputId']")
	WebElement pncode;
	@FindBy(xpath = "//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")
	WebElement addcart;
	@FindBy(xpath = "//button[normalize-space()='SHOP']")
	WebElement shop;
	@FindBy(xpath = "//div[@class='_30jeq3 _16Jk6d']")
	WebElement price;

	// Initializing the Page Objects
	public MouseHoverSafety(WebDriver wd) {
		PageFactory.initElements(wd, this);

	}

	public String getTitleofPage() {
		return driver.getTitle();

	}

	public void itemsel() throws Exception {
		select.click();
	}

	public String getPrice() {
		String pr = price.getText();
		return pr;
	}

	public boolean itemimg() throws Exception {
		Thread.sleep(3000);
		return img.isDisplayed();
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
			shop.isEnabled();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
