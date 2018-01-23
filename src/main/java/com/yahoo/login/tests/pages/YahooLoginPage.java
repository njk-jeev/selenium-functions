package com.yahoo.login.tests.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.*;

import java.util.List;

import com.yahoo.login.tests.pages.BasePage;

import static com.yahoo.login.tests.util.ActionUtil.pollForTextBoxAndSendKeys;
import static com.yahoo.login.tests.util.ActionUtil.clearFieldAndSendText;
import static com.yahoo.login.tests.util.ActionUtil.waitAndClick;

import org.openqa.selenium.WebDriver;


/**
 * This Page Object class is used for user login
 * 
 * @author Seyi Akintan
 * 
 */

public class YahooLoginPage extends BasePage {
	
	private static final By buttonLocator = By.xpath("//*[@id='login-signin']");
	
	@FindBy(how = How.XPATH, using = "//em[contains(text(),'Sign In')]")
	private WebElement signin;
	@FindBy(how = How.XPATH, using = "//input[@id='login-username']")
	private WebElement usernameField;
	@FindBy(how = How.XPATH, using = "//input[@id='login-passwd']")
	private WebElement passwdField;
	@FindBy(how = How.XPATH, using = "//*[@id='login-signin']")
	private WebElement loginButton;
	@FindBy(how = How.TAG_NAME, using = "title")
        private WebElement title;
	
	
	
	
	
	

      
	
	public YahooLoginPage(WebDriver driver, String url) {
		super(driver, url);
	}

         public boolean isSignInDisplayed(){
		return signin.isDisplayed();
	}

        public String getSignInText(){
		return signin.getText();
	}


        public void signin() {

         signin.click();

        }
        
        public static void sendKeys(final Alert alert, final String textToBeTyped) {
            alert.sendKeys(textToBeTyped);
            
          }
        
        
        
        
        public static void switchToWindowUsingTitle(WebDriver driver,
        	      String windowTitle) {
        	    Set<String> handlers = driver.getWindowHandles();
        	    if (handlers.size()>=1) {
        	      for (String handler : handlers) {
        	        driver.switchTo().window(handler);
        	      
        	        if (driver.getTitle().contains(windowTitle)) {
        	          break;
        	        }
        	      }
        	    }
        	  }
        
      //  WebElement drag;
      // Webelement drop;
        
        
        public void checkAlert() {
        String mainPage = driver.getWindowHandle();

        Alert alt = driver.switchTo().alert(); // to move control to alert popup

        alt.accept(); // to click on ok.

        alt.dismiss(); // to click on cancel.
        
        //Then move the control back to main web page-

        driver.switchTo().window(mainPage);
        }
	
        public void dragdrop(WebElement drag, WebElement drop) {
        Actions act = new Actions(driver);
        
       
        act.dragAndDrop(drag, drop).build().perform();
    
     
        
        }
	
	public void enterUsername(String username) {
		usernameField.clear();
		usernameField.sendKeys(username);
	
	
		}
	
	public void enterPassword(String password) {
		passwdField.clear();
		passwdField.sendKeys(password);
	}
	
	public void clickSignIn(){
	    try {
	      enterUsername("seanbrown2020@yahoo.com");
	      enterPassword("Dolo5555");
	     // clickLoginButton();
	      waitAndClick(driver, buttonLocator);
	     // clickLoginButton();
	      
	    } catch (Exception e) {
	      throw new RuntimeException("Sign in button is missing");
	    }
	  }
	
	
	public void clickLoginButton(){
		
		loginButton.click();
	}
}
