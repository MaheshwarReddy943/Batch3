package org.tests;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.base.TestBase;
import org.pages.HomePage;
import org.pages.Login;
import org.pages.MouseHoverSafety;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.base.CustomListener;
@Listeners(CustomListener.class)
public class MouseHoverSafetyTest extends TestBase {
	Login login;
	HomePage home;
	MouseHoverSafety mouse;
	Logger log = Logger.getLogger(MouseHoverSafetyTest.class);

	public MouseHoverSafetyTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		log.info(
				"****************************** Starting test cases execution in MouseOverTest *****************************************");
		intialization();
		login = new Login(driver);
		HomePage homePage = login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
		home = new HomePage(driver);
		mouse = new MouseHoverSafety(driver);
		log.info("Click on Sanitizer after mouse overing");
		home.clickOnSanitizers();
		log.info("Select an item(dettol) from the results");
		mouse.itemsel();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		driver.switchTo().window(tabs2.get(1));
	}

	@Test(priority = 1)
	public void ValidateResulttitle() throws Exception {
		log.info("Validate the title of the page");
		String homepagetitle = mouse.getTitleofPage();
		Assert.assertEquals(homepagetitle,
				"DETTOL Instant Hand Sanitizer Bottle - Price in India, Buy DETTOL Instant Hand Sanitizer Bottle Online In India, Reviews, Ratings & Features | Flipkart.com");

	}

	@Test(priority = 2)
	public void ItemImg() throws Exception {

		log.info("Validate if the image link of the item is enabled or not");
		try {
		mouse.itemimg();}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void printPrice() throws Exception {

		log.info("Get the price of the selected item");
		String pr = mouse.getPrice();
		log.info("The Price = " + pr);
	}

	@Test(priority = 4)
	public void pin_code() throws Exception {

		log.info("Enter the pin code");
		mouse.pincode("573202");
	}

	@Test(priority = 5)
	public void add_to_cart() throws Exception {

		log.info("Validate if the AddtoCart button is enabled or not");
		mouse.addtocart();
	}

	@Test(priority = 6)
	public void buy_Now() throws Exception {

		log.info("Validate if the Shop button is enabled or not");
		mouse.buyNow();
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
		driver.quit();
	}
}
