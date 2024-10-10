package Classes.Navigations;

import Interfaces.BrowserDriver;
import Interfaces.Navigatable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * The NavigationSendingPaymentForm class implements the Navigatable interface
 * to provide navigation functionality to the payment form section of the application.
 * It contains methods to interact with the send form button.
 */
public class NavigationSendingPaymentForm implements Navigatable {

    private WebDriver driver;

    @FindBy(id = "place_order")
    private WebElement btn_SendingForm;

    /**
     * Constructor that initializes the NavigationSendingPaymentForm with a BrowserDriver instance.
     *
     * @param browser the BrowserDriver used to interact with the web browser
     */
    public NavigationSendingPaymentForm(BrowserDriver browser) {
        this.driver = browser.getDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Navigates to the payment form by clicking the send form button.
     */
    @Override
    public void navigate() {
        btn_SendingForm.click();
    }
}
