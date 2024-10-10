package Classes;

import Interfaces.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

/**
 * The ProductSelector class is responsible for selecting random products from an e-commerce product listing page.
 * It interacts with a web browser using Selenium WebDriver and allows for the selection of a single random product.
 */
public class ProductSelector {

    private WebDriver driver;

    /**
     * Constructor that initializes the ProductSelector with a given BrowserDriver instance.
     *
     * @param browser the BrowserDriver interface that provides access to the WebDriver instance
     */
    public ProductSelector(BrowserDriver browser) {
        this.driver = browser.getDriver();
    }

    /**
     * Selects a random product from the product listing page.
     * This method finds all product elements on the page, randomly selects one, and returns it.
     *
     * @return a randomly selected WebElement representing a product on the page
     */
    public WebElement selectRandomProduct() {
        // Finds all the product elements on the page
        List<WebElement> products = driver.findElements(By.cssSelector("li.product.type-product"));

        // Randomly selects one product from the list
        Random random = new Random();
        WebElement selectedProduct = products.get(random.nextInt(products.size()));

        return selectedProduct;
    }
}
