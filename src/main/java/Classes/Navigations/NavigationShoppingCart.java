package Classes.Navigations;

import Interfaces.BrowserDriver;
import Interfaces.Navigatable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The NavigationShoppingCart class implements the Navigatable interface
 * to provide navigation functionality to the shopping cart section of the application.
 * It contains methods to interact with the shopping cart button.
 */
public class NavigationShoppingCart implements Navigatable {

    private WebDriver driver;

    @FindBy(className = "ast-cart-menu-wrap")
    private WebElement btn_shoppingCart;

    /**
     * Constructor that initializes the NavigationShoppingCart with a BrowserDriver instance.
     *
     * @param browser the BrowserDriver used to interact with the web browser
     */
    public NavigationShoppingCart(BrowserDriver browser) {
        this.driver = browser.getDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the shopping cart by clicking the shopping cart button.
     */
    @Override
    public void navigate() {
        btn_shoppingCart.click();
    }
}
