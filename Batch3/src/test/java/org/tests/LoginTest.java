package org.tests;

import org.base.CustomListener;
import org.base.TestBase;
import org.pages.HomePage;
import org.pages.Login;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.testng.Assert;
@Listeners(CustomListener.class)
public class LoginTest extends TestBase {
	Login login;
	HomePage homepage;
	public LoginTest() {

		super();	
	}

	@BeforeMethod
	public void setUp() throws Exception {
		intialization();
		login = new Login(driver);
	}
	@Test(priority = 1)
	public void LoginpageTitle() {
		
	String loginpagetitle	= login.getTitleofPage();
	Assert.assertEquals(loginpagetitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}
	@Test(priority = 2)
	public void validateLogo() throws Exception {
		boolean b =login.logintext();
		Assert.assertTrue(b);
	}
	@Test(priority = 3)
	public void login_with_valid_vals() throws Exception {
		homepage=login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
		boolean b =login.fflogo();
		Assert.assertTrue(b);
	}
	@Test(priority = 4)
	public void login_with_invalid_vals() throws Exception {
		homepage=login.validateLogin(prps.getProperty("invalphone"), prps.getProperty("invalpass"));
		boolean b =login.logintext();
		Assert.assertTrue(b);
		boolean c =login.failmsg();
		Assert.assertTrue(c);
	}
	@Test(priority = 5)
	public void forgot_pass() throws Exception {
		boolean b =login.forgotpass();
		Assert.assertTrue(b);
	}
	@Test(priority = 6)
	public void create_Account() throws Exception {
		boolean b =login.createAccount();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void close()
	{
		//driver.close();
		driver.quit();
	}
}
