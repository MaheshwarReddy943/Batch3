package org.tests;

import org.base.CustomListener;
import org.base.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.pages.HomePage;
import org.pages.Login;
import org.pages.FashionBags;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListener.class)
public class FasshionBagTest extends TestBase  {
	
	Login login;
	FashionBags srch;
	
	
	
	public FasshionBagTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		intialization();
		login = new Login(driver);
		HomePage homePage = login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
	  srch=new FashionBags(driver);
		//srch=new Fashion(driver);
		//homePage.searchAny(prps.getProperty("tosearch"));
		srch.fashionFlipkart();
	}
	@Test(priority = 2)
	public void sreachPageTitle() throws Exception {
		
		Assert.assertEquals(srch.getTitleofPage(), "Backpacks (??????) - Buy College Bags, School Bags &Travel Backpacks For Men, Women, Girls & Boys Online | Flipkart.com");
		Logger.info("Check Title of the Page "); 
	} 
	@Test(priority = 3)
	public void price_limit() throws Exception {
		Select min = new Select(srch.MinPrice());
		min.selectByValue("5000");
		Thread.sleep(3000);
		/*Select max = new Select(srch.MaxPrice());
		max.selectByValue("5000+");
		Thread.sleep(2000); */
		
		Logger.info("Min and Max price selection");
	}

	@Test(priority = 4)
	public void Branding() throws Exception {
		srch.Brand();
		Logger.info("Selecting Brand");
	}
	@Test(priority = 5)
	public void Select_Prod() throws Exception {
		srch.Product();
		Logger.info("Checking a product");
	}

	@AfterMethod
	public void close()
	{
		//driver.close();
		//driver.quit();
	}

}
