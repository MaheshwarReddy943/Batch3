package org.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.Select;
import org.pages.HomePage;
import org.pages.Login;
import org.pages.MobOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.base.TestBase;



import org.base.CustomListener;
@Listeners(CustomListener.class)
public class MobOptionsTest extends TestBase  {
		
		Login login;
		MobOptions mobl;
		HomePage hm;
		
		
		public MobOptionsTest() {
			super();
		}

		@BeforeMethod
		public void setUp() throws Exception {
			intialization();
			login = new Login(driver);
			HomePage hm=login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
			 
			mobl = new MobOptions(driver);
			hm = new HomePage(driver); 
			hm.Mobiles();
			
		}
		
		
		//To check the Title of the page
		@Test(priority = 1)
		public void searchPageTitle() throws Exception {
			mobl.getTitleofPage();
			Assert.assertEquals(mobl.getTitleofPage(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
			 Logger.info("Check Title of the Page "); 
		}   
		 
	     //To select Min and Max price check boxes is selectable
	     @Test(priority = 2)
	 	public void price() throws Exception {
	    	Select min = new Select(mobl.MinPrice());
	 		min.selectByValue("4000");
	 		Thread.sleep(4000);
	 		Select max = new Select(mobl.MaxPrice());
	 		max.selectByValue("25000");
	 		Thread.sleep(4000);
	 		 Logger.info("Check Min and Max Price selections "); 	  
	 	}
	     
	     //To check RAM select check box is enabled 
	     @Test (priority = 3)
	     
	     public void RAMCheck() throws Exception {
	    	
		   mobl.selectRAM();
		   Logger.info("Check RAM selections"); 	
	    }
	    
	     //To select Internal Storage
	    @Test (priority = 4)
	    
	    public void StorgeCheck() throws Exception {
	    	
		   mobl.StorageSelect();   
		   Logger.info("Check Storage Selections"); 	
	   }
	    
	    
	    //To select the Network Type
	   @Test (priority = 5)
	    
	     public void NetworkCheck() throws Exception {
		   mobl.NetworkSelect(); 
		   Logger.info("Check Network Selections"); 	
	   }
	    //To select Sin Type
	   @Test (priority = 6)
	 
	    public void SimTypeCheck() throws Exception {
		   mobl.SimTypeSelect() ;
		   Logger.info("Check Sim Type Selections"); 	
	}
	   //To select the Brand
	   @Test (priority = 7)
	     
	     public void BrandCheck() throws Exception {
		   mobl.BrandChk(); 
		   Logger.info("Check Brand Selections"); 
		    
	    }
	   //To click the product link selecting some options  
	     @Test (priority = 8)
	     
	     public void EndToEnd() throws Exception {
		   
	    	 mobl.SelectAll();
	    	 Logger.info("Check End To End Selections"); 
	    	 
		   
		    
	    }
	 	   
	@AfterMethod
	public void close()
	{
		driver.close();
		driver.quit();
		
	}
	   
	    
		  }

