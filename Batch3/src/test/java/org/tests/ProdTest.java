package org.tests;




import java.util.ArrayList;

import org.base.TestBase;
import org.pages.HomePage;
import org.pages.Login;
import org.pages.MobOptions;
import org.pages.Prod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.base.CustomListener;


@Listeners(CustomListener.class)
       public class ProdTest extends TestBase {
	          Login login;
	          HomePage hm;
	          MobOptions mobl;
	          Prod prod;
	
                 
       @BeforeMethod
       public void setUp() throws Exception {
			intialization();
			login = new Login(driver);
			HomePage hm=login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
			
			prod = new Prod(driver);
			mobl = new MobOptions(driver);
			hm = new HomePage(driver);
			hm.Mobiles();
		    mobl.SelectAll();
		  
		    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	        driver.switchTo().window(tabs2.get(0));
	        //driver.close();
	        driver.switchTo().window(tabs2.get(1));
       }
       
       
       //To check the title of the page
               
       @Test(priority = 1)
		public void searchPageTitle() throws Exception {
			mobl.getTitleofPage();
			Assert.assertEquals(mobl.getTitleofPage(), "SAMSUNG Galaxy F62 ( 128 GB Storage, 8 GB RAM ) Online at Best Price On Flipkart.com");
			 Logger.info("Check Title of the Page "); 
		}   
       
       //To check the Samsung Image is displayed or not 
       @Test(priority = 1)
		public void checkSamsungImg() throws Exception {
    	   prod.SamsungImg();
    	   Logger.info("Check Samsung Image is Displayed"); 
		
		}
     
       //To check the Ask Expert button is enabled 
       @Test(priority = 3)
		public void AskExpertCheck() throws Exception {
  	       prod.AskExp();
  	     Logger.info("Check Ask Expert"); 
		
		}
       
       //To check Buy without exchange is selected 
       @Test(priority = 4)
		public void ExchangeOptions() throws Exception {
 	       prod.BuyWithoutEx();
 	      Logger.info("Check Buy without exchange is selected"); 
		
		}
      
      //To check T&C is enabled
       
       @Test(priority = 5)
		public void TermsConditions() throws Exception {
 	       prod.TC();
 	      Logger.info("Terms & Conditions Link is enabled"); 
		
		}
       
       
       
       //To check Know More is enabled
       @Test(priority = 7)
		public void KnowMoreCheck() throws Exception {
	       prod.Know();
	       Logger.info("Know More is Enabled"); 
		
		}
       
       //To check the View Details option is enabled 
       @Test(priority = 8)
		public void ViewDetailsCheck() throws Exception {
	       prod.ViewD();
	       Logger.info("View Details Check"); 
		
		}
       
       @AfterMethod
  	   public void close()
  	 {
  		//driver.close();
  		//driver.quit();
  		
  	}
      }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
       