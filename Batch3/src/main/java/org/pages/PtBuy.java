package org.pages;

import org.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class PtBuy extends TestBase {
	

	      @FindBy(xpath="//button[normalize-space()='PROCEED TO BUY']")
	      WebElement ProceedBuy;
	  
          @FindBy(xpath="//button[normalize-space()='+']")
          WebElement AddingBtn;
          
          @FindBy(xpath="//span[normalize-space()='Remove']")
          WebElement Remove;
          
          @FindBy(xpath="//button[normalize-space()='CONTINUE']")
          WebElement Continue;
                  
          @FindBy(xpath="//button[@class='_32l7f0' and text()='Change']")
          WebElement Change;
          
          @FindBy(xpath="//span[normalize-space()='Order Summary']")
          WebElement Summary;
          
         
          
          public PtBuy(WebDriver wd) {
      		PageFactory.initElements(wd, this);
      		Logger = Logger.getLogger(PtBuy.class.getName());
      		
      	}
          public void ProceedToBuy() throws Exception {
  			Thread.sleep(5000);
  			
  			 try {
  				ProceedBuy.isEnabled();
  				ProceedBuy.click();
  			} 
  			 catch (Exception e) 
  			 {
  				
  				e.printStackTrace();
  			}	
          } 
          public boolean Addingopt() throws Exception {
      		Thread.sleep(3000);
      		return AddingBtn.isEnabled();
          }
          
          public boolean RemoveOpt() throws Exception {
      		Thread.sleep(3000);
      		return Remove.isEnabled();
          }
          
          public boolean ContinueButton() throws Exception {
      		Thread.sleep(3000);
      		return Continue.isEnabled();
          }
          
          public boolean ChangeButton() throws Exception {
      		Thread.sleep(3000);
      		return Change.isEnabled();
          }
          
          public boolean SummaryCheck() throws Exception {
      		Thread.sleep(3000);
      		 return Summary.isDisplayed();
          }
        
          
	
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

