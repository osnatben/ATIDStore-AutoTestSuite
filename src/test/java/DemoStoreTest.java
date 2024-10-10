import Classes.*;
import Classes.Navigations.*;
import Extentions.DemoStoreExtentions;
import Interfaces.BrowserDriver;
import TestWatcher.TestWatcherTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

/**
 * The DemoStoreTest class contains test cases for verifying the functionalities
 * of the ATID Demo Store application. It uses the JUnit 5 framework along with
 * the Selenium WebDriver for browser automation.
 *
 * <p>This class is structured to provide a clean and isolated testing environment,
 * ensuring that each test starts with a fresh instance of the browser and does not
 * depend on the results of previous tests.</p>
 *
 * <p>The first three test cases focus on distinct functionalities:
 * 1. **NavigationStore_01**: Verifies the navigation to the home page and checks the page title.
 * 2. **SelectProdudcts_02**: Tests the selection of random products and ensures that the cart updates correctly.
 * 3. **MakingOrderAndRegisteringPayment_03**: Validates the order placement and payment processing, checking for error messages.</p>
 *
 * <p>The fourth test case, **PurchaseTwoRandomProducts_04**, combines the functionality tested in the first three,
 * but is deliberately separated to ensure independence in case of failures. Each test is designed to
 * start and finish in a clean state.</p>
 */
@ExtendWith({DemoStoreExtentions.class, TestWatcherTest.class})
public class DemoStoreTest {

    static BrowserDriver browser;
    HomePage homePage;
    NavigationAccessories navigationAccessories;
    ProductSelector productSelector;
    CartManager cartManager;
    NavigationShoppingCart navigationShoppingCart;
    NavigationPurchasePayment navigationPurchasePayment;
    NavigationSendingPaymentForm navigationSendingPaymentForm;
    FormFilling formFilling;

    /**
     * Sets up the browser driver before any tests are run.
     * This method is called once before all tests.
     */
    @BeforeAll
    public static void setUpBeforeAll() {
        browser = new ChromeDriverDriver(); // Initialize the ChromeDriver
    }

    /**
     * Sets up the testing environment before each test.
     * Initializes the necessary page objects and navigates to the home page.
     */
    @BeforeEach
    public void startTest() {
        DemoStoreExtentions demoStoreExtentions = new DemoStoreExtentions();
        demoStoreExtentions.WriteToLog("BeforeEach"); // Log the start of the test

        // Initialize page objects
        homePage = new HomePage(browser);
        cartManager = new CartManager(browser);
        productSelector = new ProductSelector(browser);

        // Navigate to the home page
        browser.navigateTo("https://atid.store/");

        // Initialize navigation objects
        navigationAccessories = new NavigationAccessories(browser);
        navigationShoppingCart = new NavigationShoppingCart(browser);
        navigationPurchasePayment = new NavigationPurchasePayment(browser);
        navigationSendingPaymentForm = new NavigationSendingPaymentForm(browser);
        formFilling = new FormFilling(browser);
    }

    /**
     * Closes the browser session after all tests are completed.
     * This method is called once after all tests have run.
     */
    @AfterAll
    public static void endSession() {
        browser.quit(); // Quit the browser
    }
    /**
     * Tests the navigation to the home page and verifies the page title.
     */
    @Test
    public void NavigationStore_01() {
        homePage.navigate();
        assertEquals("ATID Demo Store – ATID College Demo Store for" +
                " Practicing QA Automation", browser.getPageTitle());
    }

    /**
     * Tests the selection of random products and verifies that the cart count is updated correctly.
     */
    @Test
    public void SelectProdudcts_02() {
        navigationAccessories.navigate();
        assertEquals("Accessories – ATID Demo Store", browser.getPageTitle());

        int CurrentProductQuantity = cartManager.getNunProduct();

        WebElement firstRandomProduct = productSelector.selectRandomProduct();
        cartManager.addToCart(firstRandomProduct);

        navigationAccessories.navigate();
        WebElement secondRandomProduct = productSelector.selectRandomProduct();
        cartManager.addToCart(secondRandomProduct);

        assertEquals(CurrentProductQuantity + 2, cartManager.getNunProduct());
    }

    /**
     * Tests the order placement and payment processing, verifying the error messages for invalid payment.
     */
    @Test
    public void MakingOrderAndRegisteringPayment_03() {
        navigationAccessories.navigate();

        WebElement firstRandomProduct = productSelector.selectRandomProduct();
        cartManager.addToCart(firstRandomProduct);

        navigationShoppingCart.navigate();
        navigationPurchasePayment.navigate();

        formFilling.readCSVAndFillForm("src/test/java/Resources/data.csv");

        assertTrue(browser.getDriver().findElement(By.cssSelector("ul.woocommerce-error li"))
                        .getText().contains("Invalid payment method."),
                "Expected message 'Invalid payment method.' not found.");
    }

    /**
     * Tests the process of purchasing two random products, validating the order placement and payment.
     * This test case incorporates elements from the first three tests to ensure comprehensive coverage.
     */
    @Test
    public void PurchaseTwoRandomProducts_04() {
        navigationAccessories.navigate();
        assertEquals("Accessories – ATID Demo Store", browser.getPageTitle());

        int CurrentProductQuantity = cartManager.getNunProduct();

        WebElement firstRandomProduct = productSelector.selectRandomProduct();
        cartManager.addToCart(firstRandomProduct);

        navigationAccessories.navigate();
        WebElement secondRandomProduct = productSelector.selectRandomProduct();
        cartManager.addToCart(secondRandomProduct);

        assertEquals(CurrentProductQuantity + 2, cartManager.getNunProduct());

        navigationShoppingCart.navigate();
        navigationPurchasePayment.navigate();

        formFilling.readCSVAndFillForm("src/test/java/Resources/data.csv");

        assertTrue(browser.getDriver().findElement(By.cssSelector("ul.woocommerce-error li"))
                        .getText().contains("Invalid payment method."),
                "Expected message 'Invalid payment method.' not found.");
    }
}
