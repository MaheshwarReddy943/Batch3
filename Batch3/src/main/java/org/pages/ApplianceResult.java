package org.pages;
 
import java.util.ArrayList;
import java.util.List;

import org.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplianceResult extends TestBase{
	
	@FindBy(xpath="//img[@class='_3U-Vxu']")
	WebElement assured;
	@FindBy(xpath="//div[contains(text(),'Brand')]")
	WebElement branddw;
	
	@FindBy(xpath="//div[contains(text(),'Whirlpool')]")
	//@FindBy(xpath="//div[@class='_3879cV'][normalize-space()='Whirlpool']")
	WebElement whirlpoolbrand;
	@FindBy(xpath="//div[@class='_1YAKP4']//select[@class='_2YxCDZ']")
    WebElement min;
	@FindBy(xpath="//div[@class=\"_1YAKP4\"]//option")
	//@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div/div/section[2]/div[4]/div[1]/select/option[3]")
	List<WebElement> minsel;
	@FindBy(xpath="//div[@class='_3uDYxP']//select[@class='_2YxCDZ']")
	WebElement max;
	@FindBy(xpath = "//div[@class=\"_3uDYxP\"]//option")
	//@FindBy(xpath="//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div/div/section[2]/div[4]/div[3]/select/option[5]")
	List<WebElement> maxsel;
	//@FindBy(xpath="//div[@class='_4rR01T' and text() = 'Whirlpool 265 L Frost Free Double Door 3 Star Convertible Refrigerator']")
	@FindBy(xpath="//div[@class=\"_4rR01T\"]")
	List<WebElement> resultsProduct;
	
	public ApplianceResult(WebDriver wb) {
		PageFactory.initElements(wb, this);
		Logger = Logger.getLogger(ApplianceResult.class.getName());
		}
	
	//to get title 
	public String getTitleofPage() throws Exception {
		Thread.sleep(3000);
		return driver.getTitle();
	}
	public void assuredFlipkart() throws Exception {
		Thread.sleep(3000);
		assured.click();
		
	}
	public int  minval() throws Exception {
		Thread.sleep(3000);
		min.click();
		Thread.sleep(3000);
		minsel.size();
		Thread.sleep(3000);
		minsel.get(1).click();
		return minsel.size();
	}
	public int maxvals() throws Exception {
		Thread.sleep(3000);
		max.click();
		Thread.sleep(3000);
		maxsel.size();
		Thread.sleep(3000);
		maxsel.get(4).click();
		return maxsel.size();
	}
	public void branddw() throws Exception {
		Thread.sleep(3000);
		branddw.isEnabled();
		Thread.sleep(3000);
		whirlpoolbrand.click();
		Thread.sleep(3000);
		//return whirlpoolbrand.click();
	}
	public int resultsProduct() throws Exception {
		
		Thread.sleep(3000);
		whirlpoolbrand.click();
		Thread.sleep(3000);
		resultsProduct.size();
		return resultsProduct.size();
	}
	
public void selProduct() throws Exception {
	
	Thread.sleep(3000);
	whirlpoolbrand.click();
	Thread.sleep(3000);
	resultsProduct.get(1).click();
	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(0));
    //driver.close();
    driver.switchTo().window(tabs2.get(1));
	//resultsProduct.get(0).click();
	
}
}
	
   
   
   
   
    