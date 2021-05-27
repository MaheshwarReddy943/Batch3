package org.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
public class BookSearchTest extends TestBase {

	Login login;
	BookSearch srch;
	Logger log = Logger.getLogger(BookSearchTest.class);

	public BookSearchTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		log.info(
				"****************************** Starting test cases execution in SearchTest *****************************************");
		intialization();
		login = new Login(driver);
		HomePage homePage = login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));
		srch = new BookSearch(driver);
		homePage.searchAny("Books");
	}

	@Test(priority = 1)
	public void sreachPageTitle() throws Exception {
		log.info("Validate the tile of the result page");
		srch.getTitleofPage();
		Assert.assertEquals(srch.getTitleofPage(),
				"Books- Buy Products Online at Best Price in India - All Categories | Flipkart.com");

	}

	@Test(priority = 2)
	public void Printres() throws Exception {
		log.info("Get the result number");
		String pr = srch.getResult();
		log.info("The search result number is = " + pr);
		log.info("Print all the book titles in the result page after search");
		List<WebElement> flipkartTotalItems = driver
				.findElements(By.xpath("//div[@class='_1AtVbE col-12-12']//div//div//div//a[2][@title]"));
		for (int i = 0; i < flipkartTotalItems.size(); i++) {
			log.info("Book " + i + " : " + flipkartTotalItems.get(i).getAttribute("title"));
		}
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
	}

	@Test(priority = 3)
	public void sort() throws Exception {
		log.info("Sort the results to 'Price- low to high'");
		Thread.sleep(3000);
		srch.Sort();
	}

	@Test(priority = 4)
	public void Lang() throws Exception {
		log.info("Select language");
		Thread.sleep(3000);
		srch.Lang();
	}

	@Test(priority = 5)
	public void customer_ratings() throws Exception {
		log.info("Select rating");
		Thread.sleep(3000);
		srch.Ratings();
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void price() throws Exception {
		log.info("select min and max prices");
		Select min = new Select(srch.MinPrice());
		min.selectByValue("200");
		Thread.sleep(3000);
		Select max = new Select(srch.MaxPrice());
		max.selectByValue("1000");
	}

	@Test(priority = 6)
	public void CategotySelect() throws Exception {
		log.info("Select a book category");
		Thread.sleep(3000);
		srch.BookCategory();
		Thread.sleep(3000);
	}

	@Test(priority = 7)
	public void Filters() throws Exception {
		log.info("Apply all the filters");
		Thread.sleep(3000);
		log.info("Language - English");
		srch.Lang();

		Thread.sleep(3000);
		log.info("Rating - 4* and above");
		srch.Ratings();

		Thread.sleep(3000);
		log.info("Minumum price - 500");
		Select min = new Select(srch.MinPrice());
		min.selectByValue("500");
		Thread.sleep(3000);
		log.info("Maximum price - 1000");
		Select max = new Select(srch.MaxPrice());
		max.selectByValue("1000");
		Thread.sleep(3000);
		log.info("Book Category - lifestyle");
		srch.BookCategory();
		Thread.sleep(3000);
		log.info("select a book");
		srch.FilterBook();
	}

	@AfterMethod
	public void TearDown() {
		driver.close();
		driver.quit();
	}
}
