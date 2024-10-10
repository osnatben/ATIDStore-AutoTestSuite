package Classes.Navigations;

import Interfaces.BrowserDriver;
import Interfaces.Navigatable;
import org.openqa.selenium.WebDriver;

/**
 * The HomePage class implements the Navigatable interface, representing the home page of the ATID Demo Store.
 * It provides functionality to navigate to the home page URL.
 */
public class HomePage implements Navigatable {

    private WebDriver driver;

    /**
     * Constructs a HomePage instance with the specified BrowserDriver.
     *
     * @param browser The browser driver used to interact with the web page.
     */
    public HomePage(BrowserDriver browser) {
        this.driver = browser.getDriver();
    }

    /**
     * Navigates to the home page of the ATID Demo Store.
     * This method opens the home page in the web browser.
     */
    @Override
    public void navigate() {
        driver.get("https://atid.store/");
    }
}
