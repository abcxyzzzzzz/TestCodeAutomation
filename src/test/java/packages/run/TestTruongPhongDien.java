package packages.run;

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

public class TestTruongPhongDien {
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
        loginPage.login("truongphongdien@qtsc.com.vn", "truongphongdien");
        Thread.sleep(5000);
    }

    @Test(dependsOnMethods = "loginTest")
    public void chuyenTiepTickket() throws InterruptedException {
        driver.findElement(PageLocators.YEU_CAU_DICH_VU).click();
        driver.findElement(PageLocators.TICKET_CUA_TOI).click();
        WebElement tElement = driver.findElement(PageLocators.TICKET_HANH_DONG);
        TestUtils.doubleClickElement(driver, tElement);
        Thread.sleep(2000);
        driver.findElement(PageLocators.TICKET_CHUYEN_NHAN_VIEN).click();
        int numChuyenTiep = 1;
        switch (numChuyenTiep) {
            case 1:
                driver.findElement(PageLocators.TICKET_CAN_DUYET).click();
                WebElement tenNhanVienYC = driver.findElement(PageLocators.TEN_NHAN_VIEN_THUC_HIEN);
                tenNhanVienYC.click();
                tenNhanVienYC.sendKeys("Nhân viên điện");
                Thread.sleep(1000);
                tenNhanVienYC.sendKeys(Keys.ENTER);
                driver.findElement(PageLocators.GHI_CHU_LY_DO)
                        .sendKeys("Công việc bạn có thể thực hiện được");
                        Thread.sleep(2000);
                driver.findElement(PageLocators.TICKET_XAC_NHAN).click();
                break;
            case 2:
                driver.findElement(PageLocators.TICKET_KHONG_CAN_DUYET).click();
                WebElement tenNhanVien = driver.findElement(PageLocators.TEN_NHAN_VIEN_THUC_HIEN);
                tenNhanVien.click();
                tenNhanVien.sendKeys("Nhân viên điện");
                Thread.sleep(1000);
                tenNhanVien.sendKeys(Keys.ENTER);
                driver.findElement(PageLocators.GHI_CHU_LY_DO)
                        .sendKeys("Công việc bạn có thể thực hiện được");
                        Thread.sleep(2000);
                driver.findElement(PageLocators.TICKET_XAC_NHAN).click();
                break;
            case 3:
                driver.findElement(PageLocators.TICKET_TU_CHOI).click();
                WebElement reasonCancel = driver.findElement(PageLocators.GHI_CHU_LY_DO);
                reasonCancel.click();
                reasonCancel.sendKeys("Tôi không có nhân viên nào có thể thực hiện yêu cầu này");
                Thread.sleep(2000);
                driver.findElement(PageLocators.TICKET_XAC_NHAN).click();
                break;
        }
        Thread.sleep(4000);

    }
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
