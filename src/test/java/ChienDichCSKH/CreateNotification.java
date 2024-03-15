package ChienDichCSKH;
import io.github.bonigarcia.wdm.WebDriverManager;
import locators.PageLocators;
import login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class CreateNotification {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver.manage().window().maximize();
        driver.get("https://crm-dev.lsat.vn/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.login("nhanviencskh@qtsc.com.vn", "nhanviencskh");
        Thread.sleep(5000);
    }

    @Test(dependsOnMethods = "loginTest")
    public void createTicketTest() throws InterruptedException {
        TestUtils.clickElement(driver, PageLocators.NG_CHIEN_DICH);
        TestUtils.clickElement(driver, PageLocators.NG_DS_THONG_BAO);
        TestUtils.clickElement(driver, PageLocators.BUTTON_CREATE_NOTIFICATION);
        TestUtils.fillInputField(driver, PageLocators.NAME_NOTIFI, "Sửa chữa hệ thống điện trường học");
        TestUtils.fillInputField(driver, PageLocators.MA_NOTIFI, "Sửa chữa hệ thống điện trường học");
        TestUtils.fillInputField(driver, PageLocators.MO_TA, "Sửa chữa hệ thống điện trường học");
        TestUtils.selectDropDow(driver,PageLocators.LOAI_THONG_BAO,"noti");
        TestUtils.selectDropDow(driver,PageLocators.NOI_SU_DUNG,"noti");
        TestUtils.fillInputField(driver,PageLocators.TIEU_DE, "Chúc mừng sinh nhật");
        TestUtils.fillInputField(driver,PageLocators.NOI_DUNG_POPUP, "Chúc mừng sinh nhật");
    }
    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}
