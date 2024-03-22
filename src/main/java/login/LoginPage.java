package login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Exel.TestExel;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    public static void login(WebDriver driver,String username, String password) throws InterruptedException {
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        emailField.sendKeys(username);
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']"));
        passwordField.sendKeys(password);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Thread.sleep(5000);
        /*String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://crm-dev.lsat.vn/dashboard")) {
            System.out.println("Đăng nhập thành công, đã chuyển hướng đến trang Dashboard.");
        } else {
            Assert.assertTrue( "Không phải trang Dashboard.", false);
            driver.quit();
        }*/
    }
}
