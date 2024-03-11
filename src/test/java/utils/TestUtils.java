package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestUtils {

    public static void doubleClickElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public static void fillInputField(WebDriver driver, By locator, String text) {
        WebElement field = driver.findElement(locator);
        field.sendKeys(text);
    }

    // Add other utility methods as needed for your tests
}
