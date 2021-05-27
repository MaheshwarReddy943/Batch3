package org.pages;

import java.util.List;

import org.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookSearch extends TestBase {
	@FindBy(xpath = "//input[@name=\"q\"]")
	WebElement searchBar;

	@FindBy(xpath = "//div[normalize-space()='Price -- Low to High']")
	WebElement sort;

	@FindBy(xpath = "//div[contains(text(),'Language')]")
	WebElement language;

	@FindBy(xpath = "//div[@class='_3879cV'][contains(text(),'English')]")
	WebElement lang;

	@FindBy(xpath = "//div[contains(text(),'Customer Ratings')]")
	WebElement ratings;

	@FindBy(xpath = "//div[@title='4★ & above']//div[@class='_1Y4Vhm _4FO7b6']")
	WebElement rate;

	@FindBy(xpath = "//div[@class='_1YAKP4']//select[@class='_2YxCDZ']")
	WebElement minprice;

	@FindBy(xpath = "//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
	WebElement maxprice;

	@FindBy(xpath = "//a[@title='Books']")
	WebElement category;

	@FindBy(xpath = "//a[normalize-space()='Lifestyle, Hobby and Sport Books']")
	WebElement booktype;

	@FindBy(xpath = "//a[@title='Why Not Me? A Feeling of Millions (English)']")
	WebElement selectbook;

	@FindBy(xpath = "//a[normalize-space()='Wabi Sabi']")
	WebElement filterbook;
	
	@FindBy(xpath = "//span[@class='_10Ermr']")
	WebElement result;

	// Initializing the Page Objects
	public BookSearch(WebDriver wd) {
		PageFactory.initElements(wd, this);
	}


	public String getTitleofPage() throws Exception {
		Thread.sleep(3000);
		return driver.getTitle();
	}
	public String getResult() {
		String pr = result.getText();
		return pr;
	}
	public void Sort() throws Exception {
		Thread.sleep(3000);
		sort.click();

	}

	public void Lang() throws Exception {
		Thread.sleep(3000);
		language.isEnabled();
		Thread.sleep(3000);
		lang.click();

	}

	public void Ratings() throws Exception {
		Thread.sleep(3000);
		ratings.isEnabled();
		Thread.sleep(3000);
		rate.click();

	}

	public void BookCategory() throws Exception {
		Thread.sleep(3000);
		category.isEnabled();
		Thread.sleep(3000);
		booktype.click();
	}

	public WebElement MinPrice() throws Exception {
		return minprice;
	}

	public WebElement MaxPrice() throws Exception {
		return maxprice;
	}

	public void selectBook() throws Exception {

		Thread.sleep(3000);
		selectbook.click();

	}

	public void FilterBook() throws Exception {

		Thread.sleep(3000);
		filterbook.click();
	}
}
