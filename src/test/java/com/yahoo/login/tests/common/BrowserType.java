package com.yahoo.login.tests.common;

import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

/**
 * Contains {@link Browser} enum and method to return Browser enums for the
 * BROWSER param specified in fashion/pom.xml.
 *  
 * 
 */
public class BrowserType {

	private static final String BROWSER = "BROWSER";
	public static final String ANDROID = "android";
	//String ANDROID = "android";
	public static final String HTMLUNIT = "htmlunit";
	public static final String IE = "internet explorer";
	public static final String APPIUM = "appium";
	public static final String IPHONE = "iPhone"; 
	public static final String IPAD = "iPad"; 
	public static final String PHANTOMJS = "phantomjs";
	public static final String CHROME = "chrome";
	public static final String FIREFOX = "firefox";
	public static final String OPERA = "opera";
	public static final String SAFARI = "safari"; 
	
	

	/**
	 * Returns {@link Browser}based on the BROWSER pram that is mentioned in the
	 * fashion/pom.xml.
	 * <p>
	 * This method could be used in tests to write tests based on browsers.
	 * </p>
	 */
	public static Browser getBrowserType() {
		String browser = System.getProperty(BROWSER);
		if (browser == null || browser.isEmpty()
				|| browser.equalsIgnoreCase(Browser.FF.toString())) {
			return Browser.FF;
		} else if (browser.equalsIgnoreCase(Browser.IE.toString())) {
			return Browser.IE;
		} else if (browser.equalsIgnoreCase(Browser.CHROME.toString())) {
			return Browser.CHROME;
		} else if (browser.equalsIgnoreCase(Browser.IPHONE.toString())
				|| browser.equalsIgnoreCase(Browser.IPAD.toString())) {
			return Browser.IPHONE;
		} else if (browser.equalsIgnoreCase(Browser.HTML_UNIT.toString())) {
			return Browser.HTML_UNIT;
		} else if (browser.equalsIgnoreCase(Browser.ANDROID.toString())) {
			return Browser.ANDROID;
		}  else {
			return Browser.UNKNOWN;
		}
	}

	public static FirefoxProfile getCustomProfile(String profileName) {
		FirefoxProfile ffProfile = null;
		if (profileName != null && !profileName.isEmpty()) {
			ProfilesIni profiles = new ProfilesIni();
			ffProfile = profiles.getProfile(profileName);
			// must check if profile exists on test machine
			if (ffProfile != null) {
				ffProfile.setAcceptUntrustedCertificates(false);
				ffProfile.setAssumeUntrustedCertificateIssuer(true);
			}
		}
		return ffProfile;
	}
	
	public static FirefoxProfile getProxyProfile(String proxyHost, String proxyPort) {
		FirefoxProfile ffProfile = new FirefoxProfile();
		ffProfile.setPreference("network.proxy.type", 1);
		ffProfile.setPreference("network.proxy.http", proxyHost);
		ffProfile.setPreference("network.proxy.http_port", proxyPort);
		return ffProfile;
	}
	
	public static FirefoxProfile getSocksProxyProfile(String proxyHost, String proxyPort) {
		FirefoxProfile ffProfile = new FirefoxProfile();
		ffProfile.setPreference("network.proxy.type", 1);
		ffProfile.setPreference("network.proxy.socks", proxyHost);
		ffProfile.setPreference("network.proxy.socks_port", proxyPort);
		return ffProfile;
	}
	
	
	/**
	 * Enum for various browser types.
	 *  
	 */
	public enum Browser {

		FF("FF"), IE("IE"), CHROME("CHROME"), IPHONE("IPHONE"), IPAD("IPAD"), HTML_UNIT(
				"HTML_UNIT"), ANDROID("ANDROID"),  UNKNOWN("UNKNOWN");

		private String browser;

		/**
		 * Constructor to set browser.
		 * 
		 * @param String
		 *            browser
		 */
		private Browser(String browser) {
			this.browser = browser;
		}

		/**
		 * Returns the enum as String.
		 */
		@Override
		public String toString() {
			return browser;
		}
	}
}
