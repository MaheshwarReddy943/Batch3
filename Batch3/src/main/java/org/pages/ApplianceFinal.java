package org.pages;

	import org.base.TestBase;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
	
	public class ApplianceFinal extends TestBase {
		
		@FindBy(xpath="//div[@class='_3nWYNs']//img")
		WebElement wrlplogo;
		@FindBy(xpath="//input[@id='pincodeInputId']")
		WebElement pncode;
		@FindBy(xpath="//button[@class=\"_2KpZ6l _2U9uOA _3v1-ww\"]")
		WebElement addcart;
		
		public ApplianceFinal(WebDriver wb) {
			
			PageFactory.initElements(wb, this);
			Logger = Logger.getLogger(ApplianceFinal.class.getName());
			}
		public String getTitleofPage() throws Exception {
			Thread.sleep(3000);
			return driver.getTitle();
		}
		public boolean wrlplogo() throws Exception {
			Thread.sleep(3000);
			return wrlplogo.isDisplayed();
		}
		public void pincode(String pc) throws Exception {
			Thread.sleep(3000);
			pncode.sendKeys(pc+Keys.ENTER);	
		}
		public void addtocart() throws Exception {
			Thread.sleep(3000);
			try {
				addcart.click();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
			 
		}
	

