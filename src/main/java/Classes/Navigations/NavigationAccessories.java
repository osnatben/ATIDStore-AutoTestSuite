package Classes.Navigations;

import Interfaces.BrowserDriver;
import Interfaces.Navigatable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The NavigationAccessories class implements the Navigatable interface
 * to provide navigation functionality to the accessories section of the application.
 * It contains methods to interact with the accessories button.
 */
public class NavigationAccessories implements Navigatable {

    private WebDriver driver;

    @FindBy(id = "menu-item-671")
    private WebElement btn_Accessories;

    /**
     * Constructor that initializes the NavigationAccessories with a BrowserDriver instance.
     *
     * @param browser the BrowserDriver used to interact with the web browser
     */
    public NavigationAccessories(BrowserDriver browser) {
        this.driver = browser.getDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the accessories section by clicking the accessories button.
     */
    @Override
    public void navigate() {
        btn_Accessories.click();
    }
}
