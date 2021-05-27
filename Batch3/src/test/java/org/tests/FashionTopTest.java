package org.tests;

import org.base.TestBase;
import org.openqa.selenium.support.ui.Select;
import org.pages.HomePage;
import org.pages.Login;
import org.pages.FashionTop;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FashionTopTest extends TestBase  {
	
	Login login;
	FashionTop srch;
	
	
	
	public FashionTopTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		intialization();
		login = new Login(driver); 
		HomePage homePage = login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
		srch=new FashionTop(driver);
		srch.fashionFlipkart();
		//srch=new Fashion(driver);
		//homePage.searchAny(prps.getProperty("tosearch")
		 
	}
	
	
	@Test(priority = 1)
	public void price_limit() throws Exception {
	Select min = new Select(srch.MinPrice());
	min.selectByValue("500");
	Thread.sleep(3000);
	Select max = new Select(srch.MaxPrice());
	max.selectByValue("2500");
	Thread.sleep(4000);
	Logger.info("Checking price limit "); 
	}

	@Test(priority = 2)
	public void Branding() throws Exception {
	Thread.sleep(5000);
	srch.Brand();
	Logger.info("Checking brand "); 
	}
	@Test(priority = 3)
	public void B_Rating() throws Exception {
	srch.Rating();
	Logger.info("Checking product rating "); 
	}
	@Test(priority = 4)
	public void Select_Prod1() throws Exception {
	Thread.sleep(3000);
	srch.Product();
	Logger.info("selecting the product"); 
	}
	
	
	@AfterMethod
	public void close()
	{
		//driver.close();
		//driver.quit();
	}

}
