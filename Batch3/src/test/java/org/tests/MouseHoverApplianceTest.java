package org.tests;

import org.base.CustomListener;
import org.base.TestBase;
import org.pages.HomePage;
import org.pages.Login;
import org.pages.MouseHoverAppliance;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)

public class MouseHoverApplianceTest extends TestBase {
	HomePage homePage;
	Login login;
	MouseHoverAppliance mouseHover;
	
	@BeforeMethod
	public void setUp() throws Exception {
		intialization();
		Login login = new Login(driver);
		
		homePage=login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
        mouseHover= new MouseHoverAppliance(driver);
	}
	@Test
	public void clickOn_app() throws Exception {
		mouseHover.clickOnApp();
		Logger.info("Hovering over Appliances");
	
}
	@AfterMethod
	public void close()
	{
		driver.close();
		driver.quit();
	} 

}
