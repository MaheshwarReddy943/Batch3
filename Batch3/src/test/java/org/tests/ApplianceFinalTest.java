package org.tests;

import org.base.TestBase;
	import java.util.ArrayList;

import org.pages.ApplianceFinal;
import org.pages.ApplianceResult;
import org.pages.HomePage;
	import org.pages.Login;
import org.pages.MouseHoverAppliance;
import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.base.CustomListener;
	@Listeners(CustomListener.class)
	
	public class ApplianceFinalTest extends TestBase{

		Login login;
		ApplianceResult res;
		ApplianceFinal finalPage;
		MouseHoverAppliance mos;
		@BeforeMethod
		public void setUp() throws Exception {
			intialization();
			login = new Login(driver);
    	HomePage homePage = login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
    	mos = new MouseHoverAppliance(driver);
        mos.clickOnApp();
			res = new ApplianceResult(driver);
			
			finalPage = new ApplianceFinal(driver);
			res.selProduct();	
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(0));
		    
		    driver.switchTo().window(tabs2.get(1));
	}
		
		@Test(priority = 1)
		public void sreachPageTitle() throws Exception {
			finalPage.getTitleofPage();
			System.out.println(driver.getTitle());
			Assert.assertEquals(finalPage.getTitleofPage(), "Whirlpool 265 L Frost Free Double Door 3 Star Convertible Refrigerator Online at Best Price in India | Flipkart.com");
		
		}
		@Test(priority = 2)
		public void logowrlp() throws Exception {
			
			boolean b = finalPage.wrlplogo();
			Assert.assertTrue(b);
		}
		@Test(priority = 3)
		public void pin_code() throws Exception {
			finalPage.pincode("305001");
		}
		@Test(priority = 4)
		public void add_to_cart() throws Exception {
			finalPage.addtocart();
			Thread.sleep(3000);
			Assert.assertEquals(driver.getTitle(), "Shopping Cart | Flipkart.com");
		}
		
		@AfterMethod
		public void close()
		{
			//driver.close();
			driver.quit();
		}
	}


