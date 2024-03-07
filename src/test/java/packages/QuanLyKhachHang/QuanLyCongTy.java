package packages.QuanLyKhachHang;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v120.page.Page;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import packages.locators.PageLocators;
import packages.login.LoginPage;
import packages.utils.TestUtils;

import java.util.concurrent.TimeUnit;
public class QuanLyCongTy {
    WebDriver driver;
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
    public void taoCongTy() throws InterruptedException{
        driver.findElement(PageLocators.QLKH).click();
        driver.findElement(PageLocators.QLCT).click();
        driver.findElement(PageLocators.TAO_MOI_CONG_TY).click();
        TestUtils.fillInputField(driver,PageLocators.INPUT_TEN_CONG_TY,"Công ty nhà báo Việt Nam");
        TestUtils.fillInputField(driver,PageLocators.INPUT_TEN_VIET_TAT,"nhà báo Việt Nam");
        //Chọn tòa nhà đại diện
        WebElement toaNhaDaiDien = driver.findElement(PageLocators.INPUT_TOA_NHA_DAI_DIEN);
        toaNhaDaiDien.click();
        toaNhaDaiDien.sendKeys("Trường mầm non Quang Trung");
        Thread.sleep(500);
        toaNhaDaiDien.sendKeys(Keys.ENTER);
        TestUtils.fillInputField(driver,PageLocators.INPUT_DIA_CHI_VAN_PHONG,"456 Phan Xích Long");
        TestUtils.fillInputField(driver,PageLocators.INPUT_DIA_CHI_TANG,"Tầng 9");
        TestUtils.fillInputField(driver,PageLocators.INPUT_DIA_CHI_PHONG,"123");
        TestUtils.fillInputField(driver,PageLocators.INPUT_EMAIL,"nhabao123@gmail.com");
        TestUtils.fillInputField(driver,PageLocators.INPUT_SDT,"123456");
        //Chọn phân loại doanh nghệp
        WebElement phanLoaiDoanhNghep = driver.findElement(PageLocators.INPUT_LOAI_DOANH_NGHEP);
        phanLoaiDoanhNghep.click();
        phanLoaiDoanhNghep.sendKeys("Trong nước");
        Thread.sleep(500);
        phanLoaiDoanhNghep.sendKeys(Keys.ENTER);
        driver.findElement(PageLocators.BUTTON_SAVE).click();
        Thread.sleep(10000);
        driver.findElement(PageLocators.BUTTON_CLOSE).click();





    }
    @AfterTest
    public void finish() {

        //driver.quit();
    }
}
