package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.base.TestBase;



public class Prod extends TestBase {

	  @FindBy(xpath="//div[contains(@class,'CXW8mj _3nMexc')]//img[@alt='SAMSUNG Galaxy F62 (Laser Grey, 128 GB)']")
	  WebElement Samsungimg;
	
	  
	  @FindBy(xpath="//button[normalize-space()='Ask expert']")
	  WebElement AskExpert;
	  
	  @FindBy(xpath="//label[contains(@for,'BUY_WITHOUT_EXCHANGE')]//div[contains(@class,'_1XFPmK')]")
	  WebElement BuyWithoutExchange;
	  
	  @FindBy(xpath="//span[1]//li[1]//div[1]//span[1]")
	  WebElement TandC;
	  
	 	  
	  @FindBy(xpath="//span[@class='_3IIjhd']")
	  WebElement KnowMore;
	  
	  @FindBy(xpath="//div[@class='_20cDxP']")
	  WebElement ViewDetails;
	  
	 
	  
	
	  
	  public Prod(WebDriver wd) {
			PageFactory.initElements(wd, this);
			Logger = Logger.getLogger(Prod.class.getName());
			}
		public String getTitleofPage() throws Exception {
    		Thread.sleep(3000);
    		return driver.getTitle(); 
    	} 
    	
    	public void PrintResult() throws Exception {

    	}
	  	 	  
	  public void SamsungImg() throws Exception {
			Thread.sleep(2000);
			 Samsungimg.isDisplayed();
		}
		 	  
	  public void AskExp() throws Exception {
		  Thread.sleep(3000);
		  AskExpert.isEnabled();
	  }
	  
	  public void BuyWithoutEx() throws Exception {
		  Thread.sleep(4000);
		   BuyWithoutExchange.isSelected();
	  }
	  
	  public void TC() throws Exception {
		  Thread.sleep(2000);
		  TandC.isEnabled();
	  } 
	 
	 
	  public void Know() throws Exception {
		  Thread.sleep(4000);
		   KnowMore.isEnabled();
	  } 
	
	  public void ViewD() throws Exception {
		  Thread.sleep(4000);
		   ViewDetails.isEnabled();
	  } 
	 
}
	
	
	

