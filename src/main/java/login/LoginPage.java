package login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
import utils.TestUtils;

public class LoginPage {
    public static void login(WebDriver driver, String sheet, int soThuTuCuaHangCanLay) throws Exception {
        String userName = TestUtils.SetText(sheet,"UserName",soThuTuCuaHangCanLay);
        String passWord = TestUtils.SetText(sheet,"Password",soThuTuCuaHangCanLay);
        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        emailField.sendKeys(userName);
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']"));
        passwordField.sendKeys(passWord);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Thread.sleep(5000);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://crm-dev.lsat.vn/dashboard")) {
            System.out.println("Đăng nhập thành công, đã chuyển hướng đến trang Dashboard.");
        } else {
            Assert.assertTrue( "Không phải trang Dashboard.", false);
            driver.quit();
        }
    }
    public static void Logout(WebDriver driver) throws InterruptedException {
        WebStorage webStorage = (WebStorage) driver;
        webStorage.getLocalStorage().clear();
        driver.navigate().refresh();
        //Assert.assertTrue(validateUIHelpers.verifyUrl(url), "Không phải trang Login.");
    }
}
