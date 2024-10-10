package Classes;

import Interfaces.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The FormFilling class automates the process of filling out a billing form on an e-commerce website using Selenium WebDriver.
 * It allows filling out the form with provided data or by reading from a CSV file.
 */
public class FormFilling {

    private WebDriver driver;

    @FindBy(id = "billing_first_name")
    private WebElement firstName;

    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @FindBy(id = "select2-billing_country-container")
    private WebElement countryContainer;

    @FindBy(id = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_postcode")
    private WebElement postcode;

    @FindBy(id = "billing_city")
    private WebElement city;

    @FindBy(id = "billing_phone")
    private WebElement phone;

    @FindBy(id = "billing_email")
    private WebElement email;

    @FindBy(id = "place_order")
    private WebElement btn_submit;

    /**
     * Constructor that initializes the FormFilling class with a BrowserDriver instance.
     * Initializes the WebElement fields using PageFactory.
     *
     * @param browser the BrowserDriver interface that provides access to the WebDriver instance
     */
    public FormFilling(BrowserDriver browser) {
        this.driver = browser.getDriver();
        PageFactory.initElements(driver, this);
    }

    /**
     * Fills the billing form with the given user details.
     *
     * @param firstName the first name of the user
     * @param lastName the last name of the user
     * @param address the billing address
     * @param postcode the postal code
     * @param city the city
     * @param phone the phone number
     * @param email the email address
     * @param country the country (selected from a dropdown)
     */
    public void fillForm(String firstName, String lastName, String address, String postcode,
                         String city, String phone, String email, String country) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        this.postcode.sendKeys(postcode);
        this.city.sendKeys(city);
        this.phone.sendKeys(phone);
        this.email.sendKeys(email);
        countryContainer.click();
        new Select(driver.findElement(By.id("billing_country"))).selectByVisibleText(country);
    }

    /**
     * Reads customer data from a CSV file and fills out the billing form for each row.
     * The form is submitted after being filled.
     *
     * @param csvFilePath the path to the CSV file containing the user data
     */
    public void readCSVAndFillForm(String csvFilePath) {
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            // Read the header line
            br.readLine();

            while ((line = br.readLine()) != null) {
                // Split the line by commas to extract the form data
                String[] data = line.split(cvsSplitBy);
                // Fill the form with the extracted data
                fillForm(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7]);
                // Submit the form
                btn_submit.click();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
