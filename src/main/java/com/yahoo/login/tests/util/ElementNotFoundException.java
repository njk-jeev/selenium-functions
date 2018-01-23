package com.yahoo.login.tests.util;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class ElementNotFoundException extends Exception {            //RuntimeException

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a new exception with <code>null</code> as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public ElementNotFoundException() {
    }

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ElementNotFoundException(final WebDriver driver, String message, final By locator) {
      //  super(message);
    }
}