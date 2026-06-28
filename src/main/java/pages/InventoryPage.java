package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    // Dynamic Advanced XPath builder method
    private By getAddToCartButton(String itemName) {
        return By.xpath("//div[text()='" + itemName + "']/ancestor::div[@class='inventory_item']//button");
    }

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Action method using our advanced dynamic locator
    public void addItemToCart(String itemName) {
        driver.findElement(getAddToCartButton(itemName)).click();
    }
}