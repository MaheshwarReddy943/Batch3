package org.pages;

import org.base.CustomListener;
import org.base.TestBase;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;


public class FashionBags extends TestBase {
	
	@FindBy(xpath="//img[@alt='Fashion']")

    WebElement fashion;

    @FindBy(xpath="//div[@class='_1YAKP4']//select[@class='_2YxCDZ']")

    WebElement min;

    @FindBy(xpath="//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")

    WebElement max;

    @FindBy(xpath="//div[contains(text(),'Brand')]")

    WebElement brand;

    @FindBy(xpath="//div[@class='_3879cV'][normalize-space()='ADIDAS']")

    WebElement adidas;

    @FindBy(xpath="//a[normalize-space()=\"Bags, Suitcases & Luggage\"]")

    WebElement bag;

    @FindBy(xpath="//a[normalize-space()=\"Backpacks\"]")

    WebElement backpack;

    @FindBy(xpath="//a[@title='Medium 23 L Backpack Power IV Graphic Backpack']")

    WebElement selectProduct;

    @FindBy(xpath="//button[normalize-space()='BUY NOW']")

    WebElement buynow;

	//@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	//WebElement loginbunt;
	
	
	public FashionBags(WebDriver wb) {
		PageFactory.initElements(wb, this);
		Logger = Logger.getLogger(FashionBags.class.getName());
		}
	
	//to get title 
	public String getTitleofPage() throws Exception {
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	
	public void fashionFlipkart() throws Exception {
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(fashion).build().perform();
		//Thread.sleep(3000);
		action.moveToElement(bag).build().perform();
	backpack.click();
		
	}
	public WebElement MinPrice() throws Exception {
		Thread.sleep(2000);
		return min;
	}
	/*public WebElement MaxPrice() throws Exception {
		Thread.sleep(3000);
		return max;
	}*/
	public void Brand() throws Exception {
		Thread.sleep(3000);
		brand.isEnabled();
		Thread.sleep(3000);
		brand.click();
		Thread.sleep(2000);
		adidas.click();
		
	}

	public void Product() throws Exception {
		Thread.sleep(3000);
		brand.isEnabled();
		Thread.sleep(3000);
		brand.click();
		Thread.sleep(2000);
		adidas.click();
		Thread.sleep(3000);
		selectProduct.click();
		
		
	}
	
	
	
	
	/*public HomePage validateLogin(String pn, String pass) {
		emailorphone.sendKeys(pn);
		password.sendKeys(pass);
		loginbunt.click();
		return new HomePage(driver);
		
	}*/

	
	
	
 
	/*public void min() throws Exception {
		Thread.sleep(3000);
		min.isEnabled();
		Thread.sleep(3000);
		applebrand.click();
		
	}
	public void ratings() throws Exception {
		Thread.sleep(3000);
		customerrats.isEnabled();
		Thread.sleep(3000);
		ratng.click();
		
	}
	public void selectProduct() throws Exception {
		
		Thread.sleep(3000);
		selectProduct.click();
		
	}
	*/

}
