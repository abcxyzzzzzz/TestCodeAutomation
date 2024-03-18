package login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout {
    public static void Logout(WebDriver driver) throws InterruptedException {
        WebStorage webStorage = (WebStorage) driver;
        webStorage.getLocalStorage().clear();
        driver.navigate().refresh();
        //Assert.assertTrue(validateUIHelpers.verifyUrl(url), "Không phải trang Login.");

    }
}
