package Classes;

import Interfaces.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The CartManager class is responsible for managing the shopping cart operations
 * in the e-commerce application. It provides methods to add products to the cart
 * and retrieve the number of products currently in the cart.
 */
public class CartManager {

    private WebDriver driver;

    /**
     * Constructor that initializes the CartManager with a BrowserDriver instance.
     *
     * @param browser the BrowserDriver used to interact with the web browser
     */
    public CartManager(BrowserDriver browser) {
        this.driver = browser.getDriver();
    }

    /**
     * Adds a specified product to the shopping cart.
     *
     * @param product the WebElement representing the product to be added to the cart
     */
    public void addToCart(WebElement product) {
        product.click();
        WebElement addToCartButton = driver.findElement(By.className("single_add_to_cart_button"));

        if (addToCartButton.isDisplayed()) {
            addToCartButton.click();
        } else {
            System.out.println("Add to cart button is not displayed.");
        }

        driver.navigate().back();
    }

    /**
     * Retrieves the number of products currently in the shopping cart.
     *
     * @return the count of products in the cart as an integer
     */
    public int getNunProduct() {
        String countText = driver.findElement(By.cssSelector("span.count")).getText().trim();
        return Integer.parseInt(countText);
    }
}
