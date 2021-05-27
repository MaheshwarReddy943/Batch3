package org.tests;

import org.base.CustomListener;
import org.base.TestBase;
import org.junit.Assert;
import org.pages.CartPage;
import org.pages.HomePage;
import org.pages.Login;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListener.class)
public class CartPageTest extends TestBase {
	Login login;
	HomePage homepage;
	CartPage cartpage;
	public CartPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() throws Exception {
		intialization();
		login = new Login(driver);
		login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
		cartpage=new CartPage(driver);
		homepage=new HomePage(driver);
		homepage.cartsel();
	}
	
	@Test(priority = 1)
	public void sreachPageTitle() throws Exception {
		cartpage.getTitleofPage();
		Assert.assertEquals(cartpage.getTitleofPage(), "Shopping Cart | Flipkart.com");
	
	}
	@Test(priority = 2)
	public void pincodesval() throws Exception {
		//cartpage.pincodes(prps.getProperty("pincode"));
		boolean b=cartpage.pincodes("500009");
		Assert.assertTrue(b);
	}
	
	@Test(priority = 3)
	public void mobile_image() {
		Assert.assertTrue(cartpage.mobileimage());
	}
	
	@Test(priority = 4 )
	public void save_me_later() throws Exception {
		//cartpage.savelaterlist();
		boolean b= cartpage.savelaterlist();
		Assert.assertTrue(b);
	}
	@Test(priority = 5 )
	public void move_to_cart() throws Exception {
		cartpage.movetocart();
	}
	@Test(priority = 9)
	public void place_orders() throws Exception {
		cartpage.placeorders();
		Thread.sleep(3000);
		Assert.assertEquals("Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order", driver.getTitle());	
	}
	@Test(priority = 7 )
	public void add_one_more() throws Exception {
		boolean b=cartpage.addonemore();
		Assert.assertTrue(b);
	}
	@Test(priority = 8 )
	public void minus_one() throws Exception {
		boolean b=cartpage.minusone();
		Assert.assertTrue(b);
	}
	@Test(priority = 6)
	public void remove_from_list() throws Exception {
		boolean b = cartpage.removefromlist();
		Assert.assertTrue(b);
	}
	@AfterClass
	public void close()
	{
		//driver.close();
		driver.quit();
	}

}
