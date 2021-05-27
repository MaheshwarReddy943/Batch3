package org.pages;

import org.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;


public class Login extends TestBase {

	

	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	WebElement emailorphone;

	@FindBy(xpath="//input[@type='password']")
	WebElement password;

	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement loginbunt;
	@FindBy(xpath="//span[@class='_36KMOx']//span[contains(text(),'Login')]")
	WebElement logintxt;
	@FindBy(xpath="//img[@title='Flipkart']")
	WebElement fliplogo;
	@FindBy(xpath="//span[contains(text(),'Your username or password is incorrect')]")
	WebElement failmsg;
	@FindBy(xpath="//span[normalize-space()='Forgot?']")
	WebElement forgotpass;
	@FindBy(xpath="//span[contains(text(),'Please enter valid Email ID/Mobile number')]")
	WebElement formsg;
	
	@FindBy(xpath="//a[normalize-space()='New to Flipkart? Create an account']")
	WebElement createAccount;
	@FindBy(xpath="//div[@class='_3oBhRa col col-2-5 _4H6HH5']")
	WebElement newaccmsg;
	
	
	public Login(WebDriver wb) {
		PageFactory.initElements(wb, this);
		 Logger = Logger.getLogger(Login.class.getName());
		
	}
	public String getTitleofPage() {
		Logger.info("validating login title");	
		return driver.getTitle();
		
	}
	public boolean logintext() throws Exception {
	Thread.sleep(3000);
	Logger.info("validating login text");	
		return  logintxt.isDisplayed();
	}
	
	public HomePage validateLogin(String pn, String pass) {
		Logger.info("validating login by giving valid values");	
		if(emailorphone.isEnabled()) 
		{
			emailorphone.sendKeys(pn);
		}
			
		if(password.isEnabled())
		{
			password.sendKeys(pass);	
		}
		
		if(loginbunt.isEnabled())
		{
			loginbunt.click();
		}
		else {
			System.out.println("Please try again");
		}
		return new HomePage(driver);
		
	}
	
	public boolean fflogo() throws InterruptedException {
		Thread.sleep(3000);
		Logger.info("validating login title");	
		return  fliplogo.isDisplayed();
	}
	public boolean failmsg() throws InterruptedException {
		Thread.sleep(3000);
		Logger.error("validating fail message");	
		return  failmsg.isDisplayed();
	}
	public boolean forgotpass() throws InterruptedException {
		if(forgotpass.isEnabled()) {
		forgotpass.click();
		Thread.sleep(3000);
		Logger.info("validating forgot password");	
		}
		else {
			System.out.println("'Forgot password' is not clickable");
		}
		return  formsg.isDisplayed();
	}
	public boolean createAccount() throws InterruptedException {
		
		if(createAccount.isEnabled()) {
		createAccount.click();
		Thread.sleep(3000);
		Logger.info("validating create Account");	
		}
		else {
			System.out.println("create account is not clickable");
		}
		return  newaccmsg.isDisplayed();
	}
}
