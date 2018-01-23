package com.yahoo.login.tests.common;

import static com.yahoo.login.tests.common.BrowserType.getBrowserType;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.yahoo.login.tests.common.BrowserType.Browser;

/**
 * Decides DesiredCapabilities to be set for RemoteWebDriver based on the BROWSER pram in
 *  pom.xml.
 * 
 *
 */
public class Capability {

  private static final String BROWSER_PROFILE_NAME = "BROWSER_PROFILE_NAME";

	/**
	 * Returns DesiredCapabilities for a browser, based on the browser type input. 
	 * @return DesiredCapabilities
	 */
	static DesiredCapabilities getCapabilities(){
		Browser browser = getBrowserType();
		if(browser.equals(Browser.FF)) {
		  String profileName = System.getProperty(BROWSER_PROFILE_NAME.toUpperCase());
      if (profileName != null && !profileName.isEmpty()) {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE, BrowserType.getCustomProfile(profileName));
        return capabilities;
      }
			return DesiredCapabilities.firefox();
		}else if(browser.equals(Browser.ANDROID)) {
			return DesiredCapabilities.appium();
		}else if(browser.equals(Browser.IE)) {
			return DesiredCapabilities.internetExplorer();
		}else if(browser.equals(Browser.CHROME)) {
			return DesiredCapabilities.chrome();
		}else if(browser.equals(Browser.IPHONE)) {
			return DesiredCapabilities.iphone();
	  }else if(browser.equals(Browser.HTML_UNIT)) {
	   return DesiredCapabilities.htmlUnit();
	  }else{
	  	throw new RuntimeException("Browser type not supported.It should be one of these FF or" +
			" IE or chrome or iphone or ipad or html_unit.");
	  }
	}
}


