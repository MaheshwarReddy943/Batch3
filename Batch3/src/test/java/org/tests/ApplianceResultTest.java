package org.tests;

import org.base.CustomListener;
import org.base.TestBase;
import org.pages.ApplianceResult;
import org.pages.HomePage;
import org.pages.Login;
import org.pages.MouseHoverAppliance;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)

public class ApplianceResultTest extends TestBase {
	
	Login login;
    ApplianceResult res;
    MouseHoverAppliance mos;
    @BeforeMethod
    public void setUp() throws Exception {
        intialization();
        login = new Login(driver);
        HomePage homePage = login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
        res = new ApplianceResult(driver);
        mos = new MouseHoverAppliance(driver);
        mos.clickOnApp();
        
    }
  @Test(priority = 1)
    public void sreachPageTitle() throws Exception {
        res.getTitleofPage();
        Logger.info("Asserting Title of current page");
       // System.out.println(res.getTitleofPage());
     Assert.assertEquals(res.getTitleofPage(), "Refrigerator Store Online - Buy Refrigerator Online at Best Price in India | Flipkart.com");
    } 
  @Test(priority = 2)
    public void selection() throws Exception{
        res.assuredFlipkart();
        Thread.sleep(3000);
        res.assuredFlipkart();
        Thread.sleep(3000);
        res.minval();
        Thread.sleep(3000);
        res.branddw();
        Logger.info("Selecting Product");
       }
    @Test(priority = 3)
    public void assured_flipkart() throws Exception {
        res.assuredFlipkart();
    }
    @Test(priority = 4)
    public void max_vals() throws Exception {
    //    res.maxvals();
    	Logger.info("Checking values in max. dropdown");
        Assert.assertEquals(7, res.maxvals());
        
        
    }
    @Test(priority = 5)
    public void min_vals() throws Exception {
      //  res.minval();
    	Logger.info("Checking values in min. dropdown");
        Assert.assertEquals(7, res.minval() );
        
    }
    
    
    @Test(priority = 6)
    public void brand_dropdown() throws Exception {
        res.branddw();
        Logger.info("Asserting Brand checkbox");
    //    Assert.assertTrue(res.branddw());
    }
    
    @Test(priority = 7)
    public void number_Product() throws Exception {
        res.resultsProduct();
        Logger.info("Checking number of products");
        Assert.assertEquals(24, res.resultsProduct());
    }
    @Test(priority = 8)
    public void sel_Product() throws Exception {
        res.selProduct();
        Thread.sleep(2000);
        driver.getTitle();
        Logger.info("Asserting title of the page");
        Assert.assertEquals(driver.getTitle(), "Whirlpool 265 L Frost Free Double Door 3 Star Convertible Refrigerator Online at Best Price in India | Flipkart.com");

        //Assert.assertEquals(driver.getTitle(), "Whirlpool 265 L Frost Free Double Door 3 Star Convertible Refrigerator Online at Best Price in India | Flipkart.com");

    }
    @AfterMethod
    public void close()
    {
    //   driver.close();
        driver.quit();
    }

 

}
 


