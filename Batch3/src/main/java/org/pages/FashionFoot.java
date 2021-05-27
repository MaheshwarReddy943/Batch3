package org.pages;

import java.util.ArrayList;

import org.base.CustomListener;
import org.base.TestBase;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;


public class FashionFoot extends TestBase {
@FindBy(xpath="//img[@alt='Fashion']")
WebElement fashion;
@FindBy(xpath="//div[@class='_1YAKP4']//select[@class='_2YxCDZ']")
WebElement min;
@FindBy(xpath="//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
WebElement max;
@FindBy(xpath="//div[contains(text(),'Brand')]")
WebElement brand;

@FindBy(xpath="//div[@class='_3879cV'][normalize-space()='Bata']")
WebElement bata;
@FindBy(xpath="//a[normalize-space()=\"Men Footwear\"]")
WebElement foot;
@FindBy(xpath="//a[normalize-space()=\"Men's Formal Shoes\"]")
WebElement formal;
@FindBy(xpath="//a[normalize-space()='Office Formal Shoes Lace Up For Men']")
WebElement selectProduct;
@FindBy(xpath="//a[normalize-space()='7']")
WebElement size;

 @FindBy(xpath="//button[normalize-space()='ADD TO CART']")
WebElement buynow;

 //@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
//WebElement loginbunt;

public FashionFoot(WebDriver wb) {
PageFactory.initElements(wb, this);
Logger = Logger.getLogger(FashionFoot.class.getName());
}
public void fashionFlipkart() throws Exception {
Actions action = new Actions(driver);
Thread.sleep(2000);
action.moveToElement(fashion).build().perform();
//Thread.sleep(3000);
action.moveToElement(foot).build().perform();
formal.click();
}
public WebElement MinPrice() throws Exception {
	Thread.sleep(3000);
return min;
}

public void Brand() throws Exception {
	
Thread.sleep(3000);
brand.isEnabled();
brand.click();
Thread.sleep(3000);
bata.click();
}

 public void Product() throws Exception {
	 brand.click();
Thread.sleep(3000);
bata.click();
Thread.sleep(3000);
selectProduct.click();
}




public void EndtoEnd() throws Exception {
	 brand.click();
	 Thread.sleep(3000);
	 bata.click();
	 Thread.sleep(3000);
	 selectProduct.click();
	 Thread.sleep(3000);
	 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
     driver.switchTo().window(tabs2.get(0));
     //driver.close();
     driver.switchTo().window(tabs2.get(1)); 
     Thread.sleep(2000);
	 size.click();
	 Thread.sleep(2000);
	 /*buynow.isEnabled();
	 
	 buynow.click();
	 Thread.sleep(3000); */
}

}