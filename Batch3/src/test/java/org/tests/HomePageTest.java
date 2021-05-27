package org.tests;

 

import org.base.CustomListener;
import org.base.TestBase;
import org.openqa.selenium.Keys;
import org.pages.HomePage;
import org.pages.Login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;
@Listeners(CustomListener.class)
public class HomePageTest extends TestBase{
    HomePage homePage;
    @BeforeMethod
    public void setUp() throws Exception {
        intialization();
        Login login = new Login(driver);
        
        homePage=login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));

 

}
    
    @Test(priority = 1)
    public void LoginpageTitle() {
        String homepagetitle    = homePage.getTitleofPage();
        Assert.assertEquals(homepagetitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
        //    
        }
    
    @Test(priority = 2)
    public void validateLogo() {
        boolean b =homePage.logo();
        Assert.assertTrue(b);
    }
    @Test(priority = 3)
    public void searchbox() {
        boolean b =homePage.search();
        Assert.assertTrue(b);
        
    }
    @Test(priority = 4)
    public void cartBtns() {
        boolean b =homePage.cart();
        Assert.assertTrue(b);
        
    }
    @Test(priority = 5)
    public void my_account() {
        boolean b =homePage.myaccount();
        Assert.assertTrue(b);
        
    }
    

 

    @Test(priority = 6)
    public void more() {
        boolean b =homePage.more();
        Assert.assertTrue(b);
        
    }
    @Test(priority = 7)
    public void cartClick() throws Exception {
        homePage.cartsel();
    }

 

    @Test(priority = 8)
    public void sreach() throws Exception {
        
        homePage.searchAny(prps.getProperty("tosearch"));    
    
    }
    @Test(priority = 4)
    public void MobileOptionsClick() throws Exception {
    	Thread.sleep(5000);
    	homePage.Mobiles();
    	 Logger.info("Check Mobiles Option "); 
    }
 
 

    @AfterMethod
    public void close()
    {
        //driver.close();
        driver.quit();
    } 
    
    
}