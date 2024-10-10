package Classes.Navigations;

import Interfaces.BrowserDriver;
import Interfaces.Navigatable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The NavigationPurchasePayment class implements the Navigatable interface
 * to provide navigation functionality to the purchase payment section of the application.
 * It contains methods to interact with the purchase payment button.
 */
public class NavigationPurchasePayment implements Navigatable {

    private WebDriver driver;

    @FindBy(css = ".checkout-button.alt.wc-forward")
    private WebElement btn_purchasePayment;

    /**
     * Constructor that initializes the NavigationPurchasePayment with a BrowserDriver instance.
     *
     * @param browser the BrowserDriver used to interact with the web browser
     */
    public NavigationPurchasePayment(BrowserDriver browser) {
        this.driver = browser.getDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the purchase payment page by clicking the purchase payment button.
     */
    @Override
    public void navigate() {
        btn_purchasePayment.click();
    }
}
