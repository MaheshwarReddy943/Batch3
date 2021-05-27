package org.tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import org.base.CustomListener;
import org.base.TestBase;
import org.pages.HomePage;
import org.pages.Login;
import org.pages.MobOptions;
import org.pages.Prod;
import org.pages.PtBuy;

@Listeners(CustomListener.class)

public class PtBuyTest extends TestBase  {
	
	Login login;
	MobOptions mobl;
	HomePage homePage;
	Prod prod;
	PtBuy pb;
	
	
	public PtBuyTest() {
		super();
	}    
      
	@BeforeMethod
	public void setUp() throws Exception {

    	  
    	  intialization();
			login = new Login(driver);
			HomePage homePage=login.validateLogin(prps.getProperty("phonenum"), prps.getProperty("password"));
			
			prod = new Prod(driver);
			mobl = new MobOptions(driver);
			homePage = new HomePage(driver);
			homePage.Mobiles();
		    mobl.SelectAll();
		    pb = new PtBuy(driver);
		    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	        driver.switchTo().window(tabs2.get(0));
	        //driver.close();
	        driver.switchTo().window(tabs2.get(1));
	        pb.ProceedToBuy();
	        driver.manage().timeouts().implicitlyWait(03, TimeUnit.SECONDS);
    
	}
	
	
	@Test(priority = 0)
	public void ProceedBuyCheck() throws Exception {
		pb.ProceedToBuy();
        Logger.info("Proceed to Buy Checking"); 
	}
	
	
	
	
    //To check + option is enabled
	@Test(priority = 1)
	public void AddOption() throws Exception {
		boolean b = pb.Addingopt();
        Assert.assertTrue(b);
        Logger.info("Add option is enabled"); 
	}
	
	
	//To check Remove Option is enabled 
	@Test(priority = 2)
	public void RemoveOptionCheck() throws Exception {
		boolean b = pb.RemoveOpt();
        Assert.assertTrue(b);
        Logger.info("Check Remove option is Enabled"); 
	}
	
	//To check Continue Button is enabled 
	
	@Test(priority = 3)
	public void ContinueButtonCheck() throws Exception {
		boolean b = pb.ContinueButton();
        Assert.assertTrue(b);
        Logger.info("Check Continue is enabled"); 
	}
	
	//To check the Change Button is enabled 
	
	@Test(priority = 4)
	public void ChangeButtonCheck() throws Exception {
		boolean b = pb.ChangeButton();
        Assert.assertTrue(b);
        Logger.info("Check Change button is enabled"); 
	}
	
	//To check the Summary of the order is displayed 
	@Test(priority = 5)
	public void OrderSummaryCheck() throws Exception {
		boolean b = pb.SummaryCheck();
        Assert.assertTrue(b);
        Logger.info("Check Summary Check is available"); 
	}
	

	
	  @AfterMethod
  	   public void close()
  	 {
  		driver.close();
  		driver.quit();
  		
  	}
      }
		
		
    
    
    
    
    
    
    
    
    
    
    
    
 

    
