package Interfaces;

import org.openqa.selenium.WebDriver;

/**
 * Interface for managing browser actions and WebDriver instance.
 * This interface provides methods for getting the WebDriver instance,
 * navigating to a specific URL, retrieving the current page title, and closing the browser.
 */
public interface BrowserDriver {

    /**
     * Retrieves the WebDriver instance for interacting with the browser.
     *
     * @return the WebDriver instance
     */
    WebDriver getDriver();

    /**
     * Navigates the browser to a specified URL.
     *
     * @param url the URL to navigate to
     */
    void navigateTo(String url);

    /**
     * Retrieves the title of the current page.
     *
     * @return the title of the current page as a String
     */
    String getPageTitle();

    /**
     * Closes the browser and quits the WebDriver session.
     */
    void quit();
}
