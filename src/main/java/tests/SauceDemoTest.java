package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.InventoryPage;
import pages.CheckoutPage;
import java.time.Duration;

public class SauceDemoTest {
    public static void main(String[] args) {
        // Initialize WebDriver with modern synchronization waits
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            // Navigate to the retail application
            driver.get("https://www.saucedemo.com/");

            // Instantiate Page Objects (POM pattern)
            LoginPage loginPage = new LoginPage(driver);
            InventoryPage inventoryPage = new InventoryPage(driver);
            CheckoutPage checkoutPage = new CheckoutPage(driver);

            // Step 1: login credentials
            loginPage.login("standard_user", "secret_sauce");

            // Step 2: adding products using Advanced Parent-Child Chaining XPath
            inventoryPage.addItemToCart("Sauce Labs Backpack");
            inventoryPage.addItemToCart("Sauce Labs Bolt T-Shirt");

            // Step 3: adding to cart & checking out
            checkoutPage.goToCart();
            checkoutPage.clickCheckout();

            // Step 4: shipping details
            checkoutPage.fillShippingInformation("Sai", "Satish", "411036");
            checkoutPage.clickContinue();

            // Step 5: Finalize Payment / Process Transaction Click
            checkoutPage.clickFinish();

            // Step 6: Verifying Final Order
            String successMsg = checkoutPage.getConfirmationMessage();
            if (successMsg.equalsIgnoreCase("Thank you for your order!")) {
                System.out.println("SUCCESS: Complete end-to-end checkout pipeline verified perfectly!");
            } else {
                System.out.println("FAILURE: Order confirmation text did not match expected value.");
            }

            Thread.sleep(3000); // Brief pause to visually audit the final success screen

        } catch (Exception e) {
            System.out.println("Test automation encountered a roadblock: " + e.getMessage());
        } finally {
            // closing browser
            driver.quit();
        }
    }
}