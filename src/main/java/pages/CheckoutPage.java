package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class CheckoutPage {
        private WebDriver driver;

        // Store Checkout Page Locators
        private By cartIcon = By.className("shopping_cart_link");
        private By checkoutButton = By.id("checkout");
        private By firstNameField = By.id("first-name");
        private By lastNameField = By.id("last-name");
        private By postalCodeField = By.id("postal-code");
        private By continueButton = By.id("continue");
        private By finishButton = By.id("finish");
        private By successHeader = By.className("complete-header");

        // Constructor
        public CheckoutPage(WebDriver driver) {
            this.driver = driver;
        }

        // 3. cart & checkout methods

        public void goToCart() {
            driver.findElement(cartIcon).click();
        }

        public void clickCheckout() {
            driver.findElement(checkoutButton).click();
        }

        public void fillShippingInformation(String firstName, String lastName, String zipCode) {
            driver.findElement(firstNameField).sendKeys(firstName);
            driver.findElement(lastNameField).sendKeys(lastName);
            driver.findElement(postalCodeField).sendKeys(zipCode);
        }

        public void clickContinue() {
            driver.findElement(continueButton).click();
        }

        public void clickFinish() {
            driver.findElement(finishButton).click();
        }

        public String getConfirmationMessage() {
            return driver.findElement(successHeader).getText();
        }
}
