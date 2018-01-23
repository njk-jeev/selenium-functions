package com.yahoo.login.tests.yahoologin;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.yahoo.login.tests.common.BaseTest;
import com.yahoo.login.tests.pages.YahooLoginPage;
import com.yahoo.login.tests.util.ActionUtil;
import org.testng.Reporter;

public class YahooLogInTest extends BaseTest implements Cloneable {
	
	
	
	@Test(enabled = false)
    public void yahooSignInIsDisplayTest() throws InterruptedException{
		
		YahooLoginPage ylp = new YahooLoginPage(driverThread.get(), System.getProperty("TEST_URL"));
		//Reporter.log("Browser Opened");
		Assert.assertTrue(ylp.isSignInDisplayed());
		ActionUtil.captureScreenShot(driverThread.get());
	}
	
	@Test(enabled = true)
    public void yahooClickSignInTest() throws InterruptedException{
		
		YahooLoginPage ylp = new YahooLoginPage(driverThread.get(), System.getProperty("TEST_URL"));
		
		
		
		Reporter.log("Browser Opened");
		Thread.sleep(5000);
		
		ylp.signin();
		ylp.clickSignIn();
	}
	
	@Test(enabled = false)
    public void loginTest(){
		
		YahooLoginPage ylp = new YahooLoginPage(driverThread.get(), System.getProperty("TEST_URL"));
		ylp.clickSignIn();
	}
	
	
	
	
	
}
