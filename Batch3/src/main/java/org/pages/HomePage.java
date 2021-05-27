package org.pages;

 

import org.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 

public class HomePage  extends TestBase{
    @FindBy(xpath="//img[@title='Flipkart']")
    WebElement fliplogo;
    
    @FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
    WebElement searchbar;
    
    @FindBy(xpath="//span[normalize-space()='Cart']")
    WebElement cartBtn;
    @FindBy(xpath="//input[@name=\"q\"]")
    WebElement searchproduct;
    @FindBy(xpath="//div[contains(text(),'My Account')]")
    WebElement myaccountdd;
    @FindBy(xpath="//div[@class='exehdJ'][normalize-space()='More']")
    WebElement moredd;
    @FindBy(xpath="//img[@alt='Mobiles']")
    WebElement MobilesOption;
    @FindBy(xpath = "//img[@alt='Beauty, Toys & More']")
	WebElement beauty;

	@FindBy(xpath = "//a[normalize-space()='Safety & Hygiene Essentials']")
	WebElement safe;

	@FindBy(xpath = "//a[normalize-space()='Sanitizers']")
	WebElement sanitizer;
    
    public HomePage(WebDriver wb) {
        PageFactory.initElements(wb, this);
        Logger = Logger.getLogger(HomePage.class.getName());
    }

 

    public String getTitleofPage() {
        Logger.info("validating Home page title");    
        return driver.getTitle();
        
    }
    public boolean logo() {
        Logger.info("validating flipkart logo");    
        return  fliplogo.isDisplayed();
    }
    
    public boolean search() {
        Logger.info("validating search box");    
        return  searchbar.isEnabled();
    }
    
    public boolean cart() {
        Logger.info("validating cart button");    
    return  cartBtn.isEnabled();
    }
    public boolean myaccount() {
        Logger.info("validating My Account button");
        return  myaccountdd.isEnabled();
        }
    public boolean more() {
        Logger.info("validating More button");
        return  moredd.isEnabled();
        }
    public void cartsel() throws Exception {
        Logger.info("validating Cart button ");
    Thread.sleep(3000);
    cartBtn.click();
    }
    public void searchAny(String search) throws Exception {
        Logger.info("validating Search ");
        Thread.sleep(3000);
        searchproduct.sendKeys(search+Keys.ENTER);
        Thread.sleep(3000);
        
    }
    public void Mobiles() throws Exception {
    	Thread.sleep(5000);
    	try {
			MobilesOption.click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}   	    	
    }
   	
    
    public void clickOnSanitizers() throws InterruptedException {
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(beauty).build().perform();
		action.moveToElement(safe).build().perform();
		sanitizer.click();
		

	}
 

}