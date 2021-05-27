package org.pages;

import java.util.ArrayList;
import java.util.List;

import org.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search extends TestBase {
	
	@FindBy(xpath="//input[@name=\"q\"]")
	WebElement searchBar;
	@FindBy(xpath="//img[@class='_3U-Vxu']")
	WebElement assured;
	@FindBy(xpath="//div[@class='_2gmUFU _3V8rao'][normalize-space()='Brand']")
	WebElement branddw;
	@FindBy(xpath="//div[@title='APPLE']//div[@class='_24_Dny']")
	WebElement applebrand;
	@FindBy(xpath="//div[contains(text(),'Customer Ratings')]")
	WebElement customerrats;
	@FindBy(xpath="//div[@class='_1YAKP4']//select[@class='_2YxCDZ']")
    WebElement min;
	@FindBy(xpath="//div[@class=\"_1YAKP4\"]//option[@class=\"_3AsjWR\"]")
	List<WebElement> minsel;
	@FindBy(xpath="//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
	WebElement max;
	@FindBy(xpath="//div[@class=\"_3uDYxP\"]//option[@class=\"_3AsjWR\"]")
	List<WebElement> maxsel;
	@FindBy(xpath="//div[@title='4★ & above']//div[@class='_1Y4Vhm _4FO7b6']//div[1]")
	WebElement ratng;
	@FindBy(xpath="//div[@class=\"_4rR01T\"]")
	List<WebElement> resultsProduct;
	@FindBy(xpath="//div[@class='_3sckoD']")
	WebElement applevald;
	@FindBy(xpath="//span[@class='B_NuCI']")
	WebElement titlevald;
	@FindBy(xpath="//div[contains(text(),'Internal Storage')]")
	WebElement instore;
	@FindBy(xpath="//div[contains(text(),'Battery Capacity')]")
	WebElement battery;
	
	
	public Search(WebDriver wb) {
		PageFactory.initElements(wb, this);
		 Logger = Logger.getLogger(Login.class.getName());
		
		}
	
	//to get title 
	public String getTitleofPage() throws Exception {
		Logger.info("validating page title");	
		Thread.sleep(3000);
		return driver.getTitle();
	}
	public void assuredFlipkart() throws Exception {
		Logger.info("validating assuredFlipkart");	
		Thread.sleep(3000);
		if(assured.isEnabled()) {
		assured.click();
		}
		else {
			System.out.println("flipkart assured checkbox is not clickable");
		}
		
	}
	public int  minval() throws Exception {
		Logger.info("validating min price");
		Thread.sleep(3000);
		min.click();
		Thread.sleep(3000);
		minsel.size();
		Thread.sleep(3000);
		minsel.get(1).click();
		return minsel.size();
	}
	public int maxvals() throws Exception {
		Logger.info("validating max price");
		Thread.sleep(3000);
		max.click();
		Thread.sleep(3000);
		maxsel.size();
		Thread.sleep(3000);
		maxsel.get(10).click();
		return maxsel.size();
	}
	public void branddw() throws Exception {
		Logger.info("validating brand check box");
		Thread.sleep(3000);
		if(branddw.isEnabled()) {
		Thread.sleep(3000);
		applebrand.click();
		Thread.sleep(3000);
		
		}
		else {
			System.out.println("brand checkbox is not clickable");
		}
	
	}
	
	public boolean brandvalidate() {
		Logger.info("validating brand is displayed in fliters");
		applevald.isDisplayed();
		return applevald.isDisplayed();
	}
	
	public boolean ratings() throws Exception {
		Logger.info("validating rating chexk box");
		Thread.sleep(3000);
		if(customerrats.isEnabled()) {
		Thread.sleep(3000);
		ratng.click();
		Thread.sleep(3000);
		}
		else {
			System.out.println("Rating checkbox is not clickable");
		}
		return customerrats.isEnabled();
	}
	 
	public boolean internalstore() {
		Logger.info("validating internal storage dropdown");
		return instore.isEnabled();
	}
	
	public boolean batteryCapacity() {
		Logger.info("validating Battery Capacity dropdown");
		return battery.isEnabled();
	}
	
	public int resultsProduct() throws Exception {
		Logger.info("validating number of products is displayed");
		Thread.sleep(3000);
		resultsProduct.size();
		return resultsProduct.size();
	}
	public boolean selProduct() throws Exception {
		Logger.info("validating slected products is navigeted right window or not");
		Thread.sleep(3000);
		resultsProduct.get(0).click();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    //driver.close();
	    driver.switchTo().window(tabs2.get(1));
		Thread.sleep(3000);
		return titlevald.isDisplayed();
		
	}

}
