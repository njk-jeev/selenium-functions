package com.yahoo.login.tests.pages;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage extends LoadableComponent<BasePage>{

	
	private static final long TIMEOUT_IN_SECONDS = 10;
	protected WebDriver driver = null;
	protected String url = null;
	protected String site = null;
	protected boolean isAbsoluteUrl = false;
	protected Set<By> loadedConditions = new HashSet<By>();
	
	
	/**
	   * Sets driver and intialized page elements.
	   * 
	   * @param driver
	   */
	  protected BasePage(WebDriver driver) {
	    if (driver == null)
	      throw new RuntimeException("Failed due to Driver/Grid Issues.");
	    this.driver = driver;
	    PageFactory.initElements(this.driver, this);
	  }

	  /**
	   * Sets driver, url.Loads url and initializes elements on the page.
	   * 
	   * @param driver
	   * @param page
	   */
	  protected BasePage(WebDriver driver, String url) {
	    this.driver = driver;
	    this.url = url;
	    load();
	    PageFactory.initElements(this.driver, this);
	   
	  }

	  /**
	   * Sets driver, url and
	   * 
	   * @param driver
	   * @param url
	   * @param isAbsoluteUrl
	   *          TODO: Check the usage of this method and remove it if possible.
	   */
	  protected BasePage(WebDriver driver, String url, boolean isAbsoluteUrl) {
	    this.driver = driver;
	    this.url = url;
	    this.isAbsoluteUrl = isAbsoluteUrl;
	    load();
	    PageFactory.initElements(this.driver, this);
	    
	  }

	  /**
	   * Add a constraint that must be met in order for the page to be considered
	   * loaded. This should be used by implementing page objects in a domain
	   * specific manner.
	   * 
	   * @param matchCondition
	   *          .
	   */
	  protected void addLoadedCondition(By matchCondition) {
	    loadedConditions.add(matchCondition);
	  }

	  @Override
	  protected void load() {
	    if (driver == null)
	      throw new RuntimeException("Failed due to Driver/Grid Issues. "
	          + System.getProperty("TEST_URL"));
	    try {
	      driver.get(url);
	    } catch (Exception e) {
	      throw new RuntimeException("Failed to open the url on browser: " + e);
	    }
	  }

	  @Override
	  protected void isLoaded() throws Error {
	    for (final By condition : loadedConditions) {
	      Wait<WebDriver> wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
	      wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver driver) {
	          driver.findElement(condition);
	          return Boolean.valueOf(true);
	        }
	      });
	    }
	  }

}
