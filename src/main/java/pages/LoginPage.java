package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class LoginPage {
        private WebDriver driver;

        // 1. Store the locators at the top using By
        private By usernameField = By.id("user-name");
        private By passwordField = By.id("password");
        private By loginButton = By.id("login-button");

        // 2. Constructor to pass the driver from the test script
        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        // 3. Clean action methods
        public void enterUsername(String username) {
            driver.findElement(usernameField).sendKeys(username);
        }

        public void enterPassword(String password) {
            driver.findElement(passwordField).sendKeys(password);
        }

        public void clickLogin() {
            driver.findElement(loginButton).click();
        }

        // Combined business flow for convenience
        public void login(String username, String password) {
            this.enterUsername(username);
            this.enterPassword(password);
            this.clickLogin();
        }
    }

