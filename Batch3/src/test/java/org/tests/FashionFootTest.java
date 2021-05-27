package org.tests;



import java.util.ArrayList;

import org.base.TestBase;

import org.openqa.selenium.support.ui.Select;

import org.pages.HomePage;

import org.pages.Login;

import org.pages.FashionFoot;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;



public class FashionFootTest extends TestBase  {

    

    Login login;

    FashionFoot srch;

    

    

    

    public FashionFootTest() {

        super();

    }



    @BeforeMethod

    public void setUp() throws Exception {

        intialization();

        login = new Login(driver);

        HomePage homePage = login.validateLogin(prps.getProperty("phone"), prps.getProperty("password"));

        srch=new FashionFoot(driver);

        srch.fashionFlipkart();

        //srch=new Fashion(driver);

        //homePage.searchAny(prps.getProperty("tosearch"));
       
        

    }
@Test(priority = 3)

    public void price_limit() throws Exception {

        Select min = new Select(srch.MinPrice());

        min.selectByValue("4000");

        Thread.sleep(3000);

        Logger.info("Selecting Min Price");

    }



    @Test(priority = 4)

    public void Branding() throws Exception {
    	
    	

        Thread.sleep(4000);

        srch.Brand();
        Logger.info("Selecting Brand");
    }

    @Test(priority = 5)

    public void Select_Prod() throws Exception {

        Thread.sleep(4000);

        srch.Product();
        Logger.info("Selecting Product");
    }



@Test(priority = 6)

public void ProductSelect() throws Exception {

    Thread.sleep(4000);

    srch.EndtoEnd();
    Logger.info("Checking End To End");
}

    @AfterMethod

    public void close()

    {

        //driver.close();

        //driver.quit();

    }



}