package Classes;

import Interfaces.BrowserDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * The ChromeDriverDriver class implements the BrowserDriver interface
 * and provides a wrapper around the Selenium ChromeDriver for web automation.
 * It initializes the ChromeDriver and manages browser settings.
 */
public class ChromeDriverDriver implements BrowserDriver {

    private WebDriver driver;

    /**
     * Constructor that sets up the ChromeDriver using WebDriverManager.
     * Initializes the Chrome browser, maximizes the window, and sets an implicit wait.
     */
    public ChromeDriverDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Navigates the browser to the specified URL.
     *
     * @param url the URL to navigate to
     */
    @Override
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Returns the title of the current page.
     *
     * @return the title of the current page as a String
     */
    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Quits the browser and closes all associated windows.
     */
    @Override
    public void quit() {
        driver.quit();
    }

    /**
     * Returns the current instance of WebDriver.
     *
     * @return the WebDriver instance
     */
    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
