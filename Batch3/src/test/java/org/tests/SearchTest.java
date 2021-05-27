package org.tests;

import org.testng.Assert;

import org.base.CustomListener;
import org.base.TestBase;
import org.pages.HomePage;
import org.pages.Login;
import org.pages.Search;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)

public class SearchTest extends TestBase  {
	
	Login login;
	Search srch;
	public SearchTest() {
		super();
	}

	@BeforeClass
	public void setUp() throws Exception {
		intialization();
		login = new Login(driver);
		HomePage homePage = login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
		 srch=new Search(driver);
		 homePage.searchAny(prps.getProperty("tosearch"));
		 
	}
	
	@Test(priority = 1)
	public void sreachPageTitle() throws Exception {
		srch.getTitleofPage();
		Assert.assertEquals(srch.getTitleofPage(), "APPLE IPhone 11 (Black, 64 GB)- Buy Products Online at Best Price in India - All Categories | Flipkart.com");
	}
	@Test(priority = 2)
	public void assured_flipkart() throws Exception {
		srch.assuredFlipkart();
	}
	@Test
	public void max_vals() throws Exception {
		srch.maxvals();
		Assert.assertEquals(11, srch.maxvals());
		
	}
	@Test
	public void min_vals() throws Exception {
		srch.minval();
		Assert.assertEquals(11, srch.minval() );
	}
	
	
	@Test(priority = 3)
	public void brand_dropdown() throws Exception {
		srch.branddw();
		Assert.assertTrue(srch.brandvalidate());
	}
	@Test(priority = 4)
	public void customer_ratings() throws Exception {
	
		Assert.assertTrue(srch.ratings());
	}
	@Test(priority = 5)
	public void internal_store() {
		Assert.assertTrue(srch.internalstore());
	}
	
	@Test(priority = 6)
	public void battery_Capacity() {
		Assert.assertTrue(srch.batteryCapacity());
	}
	
	
	@Test(priority = 7)
	public void number_Product() throws Exception {
		srch.resultsProduct();
		Assert.assertEquals(6, srch.resultsProduct());
	}
	@Test(priority = 8)
	public void sel_Product() throws Exception {
		Assert.assertTrue(srch.selProduct());  
	}
	@AfterClass
	public void close()
	{
		//driver.close();
		driver.quit();
	}

}
