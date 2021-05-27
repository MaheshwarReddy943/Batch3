package org.pages;

import org.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHoverAppliance extends TestBase {
	@FindBy(xpath= "//img[@alt='Appliances']")
	WebElement appliances;
	
	@FindBy(xpath = "//a[normalize-space()='Refrigerators']")
	WebElement refrigerator;
	
	@FindBy(xpath = "//a[normalize-space()='All']")
	WebElement typeofref ;
	
	public MouseHoverAppliance(WebDriver wb) {
        PageFactory.initElements(wb, this);
        Logger = Logger.getLogger(MouseHoverAppliance.class.getName());
	}
	public void clickOnApp() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		
		action.moveToElement(appliances).build().perform();
		action.moveToElement(refrigerator).build().perform();
		
		typeofref.click();
		Thread.sleep(2000);
		
		
		
	}
	
	
	

}
