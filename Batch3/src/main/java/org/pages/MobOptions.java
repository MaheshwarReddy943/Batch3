package org.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.base.TestBase;


public class MobOptions extends TestBase  {
	
	              
	      @FindBy(xpath="//div[@class='_1YAKP4']//select[@class='_2YxCDZ']")
          WebElement min;
   
          @FindBy(xpath="//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
          WebElement max;
          
          @FindBy(xpath="//div[@title='6 GB & Above']//div[@class='_24_Dny']")
          WebElement RAM;
          
          @FindBy(xpath="//div[@title='SAMSUNG']//div[@class='_24_Dny']")
          WebElement Brand;
          
          @FindBy(xpath="//div[contains(text(),'Internal Storage')]")
          WebElement IntStorageClick;
          
          @FindBy(xpath="//div[@title='128 - 255.9 GB']//div[@class='_24_Dny']")
          WebElement IntStorageSelect;
          
          @FindBy(xpath="//div[contains(text(),'Network Type')]")
          WebElement NetworkClick;
          
          @FindBy(xpath="//div[@title='4G VOLTE']//div[@class='_24_Dny']")
          WebElement NetworkSelect;
          
          @FindBy(xpath="//div[contains(text(),'Sim Type')]")
          WebElement SimtypeClick;
          
          @FindBy(xpath="//div[@title='Dual Sim']//div[@class='_24_Dny']")
          WebElement SimtypeSelect;
                  
          @FindBy(xpath="//span[@class='PTpXCl']")
          WebElement Findlookingfor;
          
          @FindBy(xpath="//span[normalize-space()='Yes']")
          WebElement Findlookingyes;
          
          @FindBy(xpath="//button[normalize-space()='Submit']")
          WebElement Submit;
          
          @FindBy(xpath="//span[@class='p5OkKU']")
          WebElement Thankyou;
                  
          @FindBy(xpath="//span[normalize-space()='Back to top']")
          WebElement BackToTop;
          
          @FindBy(xpath="//div[normalize-space()='SAMSUNG Galaxy F62 (Laser Grey, 128 GB)']")
          WebElement ProductClick;
          
    	public MobOptions(WebDriver wd) 
      	{
      	PageFactory.initElements(wd, this);
      	Logger = Logger.getLogger(MobOptions.class.getName());
      	}
    	
    	
    	// To get the Page title     
    	public String getTitleofPage() throws Exception {
    	
    		return driver.getTitle(); 
    	} 
    	
    	public void PrintResult() throws Exception {

    	}
    	  
            	
        public WebElement MinPrice() throws Exception {
        	Thread.sleep(4000);
        	return min;
    	
    	}
    	public WebElement MaxPrice() throws Exception {
    		Thread.sleep(3000);
    		return max;
    		
    		
    	}
        
    	// To select RAM
    	
    	public void selectRAM() throws Exception {
    		Thread.sleep(2000);
    		RAM.isEnabled();
    		Thread.sleep(2000);;
    		RAM.click();
    		
    	}
        
        // To select Internal Storage
        
        public void StorageSelect() throws Exception {
        	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	IntStorageClick.isEnabled();
        	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	IntStorageClick.click();
        	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	IntStorageSelect.click();
        }
        	
       // To select the Network Type
               
        public void NetworkSelect() throws Exception {
        	Thread.sleep(2000);
        	NetworkClick.isEnabled();
       	   	Thread.sleep(3000);
        	NetworkClick.click();
        	Thread.sleep(2000);
        	NetworkSelect.click();
        }
        
        // To select the Sim Type      
        public void SimTypeSelect() throws Exception {
        	Thread.sleep(2000);
        	SimtypeClick.isEnabled();
        	Thread.sleep(2000);
        	SimtypeClick.click();
        	Thread.sleep(2000);
        	SimtypeSelect.click();
        
          }
        
        // To Select the Brand check box
        public void BrandChk() throws Exception {
        	Thread.sleep(2000);
        	Brand.isEnabled();
        	Thread.sleep(2000);
        	Brand.click();
        	
        }
                
        
       //End to End to click on the product  
        public void SelectAll() throws Exception {
        	Thread.sleep(2000);
    		RAM.click();
        	Thread.sleep(2000);
        	Brand.click();
        	Thread.sleep(2000);
        	IntStorageClick.click();
        	Thread.sleep(3000);
        	IntStorageSelect.click();
        	Thread.sleep(2000);
        	NetworkClick.click();
        	Thread.sleep(2000);
        	NetworkSelect.click();
        	Thread.sleep(2000);
        	SimtypeClick.click();
        	Thread.sleep(2000);
        	SimtypeSelect.click();
        	Thread.sleep(2000);
        	Findlookingfor.isDisplayed();
    		Thread.sleep(2000);
        	Findlookingyes.click();
        	Thread.sleep(3000);
        	Submit.click();
        	Thread.sleep(3000);
            Thankyou.isDisplayed();
            Thread.sleep(3000);
        	BackToTop.click();
        	Thread.sleep(2000); 
        	ProductClick.click();
            Thread.sleep(1000);
    		
        } 
       
 }
    
          
        
	
