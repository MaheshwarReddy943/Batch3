package org.tests;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.base.TestBase;
import org.pages.BookResult;
import org.pages.BookSearch;
import org.pages.HomePage;
import org.pages.Login;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import org.base.CustomListener;
@Listeners(CustomListener.class)

public class BookResultTest extends TestBase {
	Login login;
	BookResult sr;
	BookSearch srch;
	Logger log = Logger.getLogger(BookResultTest.class);
	public BookResultTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		log.info("****************************** Starting test cases execution in ItemSearchResultTest *****************************************");
		intialization();
		login = new Login(driver);
		HomePage homePage = login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
		homePage.searchAny("books");
		srch = new BookSearch(driver);
		sr = new BookResult(driver);
		srch.selectBook();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		driver.switchTo().window(tabs2.get(1));
	}

	@Test(priority = 1)
	public void sreachPageTitle() throws Exception {
		log.info("Validate the tile of the the result page after search");
		sr.getTitleofPage();
		Assert.assertEquals(sr.getTitleofPage(),
				"Why Not Me? A Feeling of Millions (English): Buy Why Not Me? A Feeling of Millions (English) by Anubhav Agrawal at Low Price in India | Flipkart.com");

	}

	@Test(priority = 2)
	public void BookImg() throws Exception {
		log.info("Validate if the image link of the book is enabled or not");
		sr.Bookimg();
	}

	@Test(priority = 3)
	public void pin_code() throws Exception {
		log.info("Enter the pin code");
		sr.pincode("573202");
	}

	@Test(priority = 4)
	public void add_to_cart() throws Exception {
		log.info("Validate if the AddtoCart button is enabled or not");
		sr.addtocart();
	}

	@Test(priority = 5)
	public void buy_Now() throws Exception {
		log.info("Validate if the AddtoCart button is enabled or not");
		sr.buyNow();
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
		driver.quit();
	}
}
