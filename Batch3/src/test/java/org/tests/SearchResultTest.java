package org.tests;

import java.util.ArrayList;

import org.base.CustomListener;
import org.base.TestBase;
import org.pages.HomePage;
import org.pages.Login;
import org.pages.Search;
import org.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)
public class SearchResultTest extends TestBase  {
	Login login;
	SearchResultPage sr;
	Search srch;
	
	@BeforeMethod
	public void setUp() throws Exception {
		intialization();
		login = new Login(driver);
		HomePage homePage = login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
		homePage.searchAny(prps.getProperty("tosearch"));
		srch=new Search(driver);
		sr = new SearchResultPage(driver);
		srch.selProduct();	
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    //driver.close();
	    driver.switchTo().window(tabs2.get(1));
}
	
	@Test(priority = 1)
	public void sreachPageTitle() throws Exception {
		sr.getTitleofPage();
		Assert.assertEquals(sr.getTitleofPage(), "APPLE iPhone 11 ( 64 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com");
	
	}
	@Test(priority = 2) 
	public void product_name() throws Exception {
		
		Assert.assertTrue(sr.productName());
	}
	@Test(priority = 3)
	public void apple_logo() throws Exception {
		sr.appleLogo();
	}
	@Test(priority = 4)
	public void pin_code() throws Exception {
		sr.pincode("500009");
	}
	@Test(priority = 5)
	public void add_to_cart() throws Exception {
		sr.addtocart();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "Shopping Cart | Flipkart.com");
	}
	@Test(priority = 6)
	public void buy_Now() throws Exception {
		sr.buyNow();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order");
	}
	@AfterMethod
	public void close()
	{
		//driver.close();
		driver.quit();
	}
}