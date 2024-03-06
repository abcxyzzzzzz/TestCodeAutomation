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

public class TestNhanVienDien {
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
        loginPage.login("nhanviendien@qtsc.com.vn", "nhanviendien");
        Thread.sleep(5000);
    }

    @Test
    public void tiepNhanTicket() throws InterruptedException {
        driver.findElement(PageLocators.YEU_CAU_DV_NV).click();
        driver.findElement(PageLocators.TICKET_CUA_TOI).click();
        WebElement tElement = driver.findElement(PageLocators.TICKET_HANH_DONG);
        TestUtils.doubleClickElement(driver, tElement);
        Thread.sleep(2000);
        driver.findElement(PageLocators.TICKET_CHUYEN_NHAN_VIEN).click();
        int numTiepNhan = 1;
        switch (numTiepNhan) {
            case 1:
                handleApproval();
                break;
            case 2:
                handleRejection();
                break;
        }
    }

    private void handleApproval() throws InterruptedException {
        driver.findElement(PageLocators.TICKET_CAN_DUYET).click();
        WebElement lyDoDongY = driver.findElement(PageLocators.GHI_CHU_LY_DO);
        lyDoDongY.click();
        lyDoDongY.sendKeys("Tôi có thể thực hiện yêu cầu này");
        Thread.sleep(2000);
        driver.findElement(PageLocators.TICKET_XAC_NHAN).click();
        Thread.sleep(5000);
        WebElement truocXuLy = driver.findElement(PageLocators.TRUOC_XU_LY);
        truocXuLy.click();
        truocXuLy.sendKeys("Kết quả trước khi thực hiện hành động");
        Thread.sleep(1000);
        driver.findElement(PageLocators.UPDATE_KQ_TRUOC_XU_LY).click();
        Thread.sleep(1000);
        WebElement sauXuLy = driver.findElement(PageLocators.SAU_XU_LY);
        sauXuLy.click();
        sauXuLy.sendKeys("Kết quả sau khi thực hiện hành động");
        Thread.sleep(1000);
        driver.findElement(PageLocators.UPDATE_KQ_SAU_XU_LY).click();
        Thread.sleep(4000);

        int thucHien = 1;
        switch (thucHien) {
            case 1:
                driver.findElement(PageLocators.TICKET_CHUYEN_NHAN_VIEN).click();
                driver.findElement(PageLocators.CO_THE_XU_LY).click();
                WebElement lyDoThanhCong = driver.findElement(PageLocators.GHI_CHU_LY_DO);
                lyDoThanhCong.click();
                Thread.sleep(1000);
                lyDoThanhCong.sendKeys("Tôi đã thực hiện yêu cầu này");
                driver.findElement(PageLocators.TICKET_XAC_NHAN).click();
                break;

            case 2:
                driver.findElement(PageLocators.TICKET_CHUYEN_NHAN_VIEN).click();
                driver.findElement(PageLocators.KHONG_THE_XU_LY).click();
                WebElement lyDoTuChoi = driver.findElement(PageLocators.GHI_CHU_LY_DO);
                lyDoTuChoi.click();
                lyDoTuChoi.sendKeys("Tôi không thể thực hiện yêu cầu này");
                Thread.sleep(2000);
                driver.findElement(PageLocators.TICKET_XAC_NHAN).click();
                break;
        }
        // Approve the action

    }

    private void handleRejection() throws InterruptedException {
        driver.findElement(PageLocators.TICKET_CHUYEN_NHAN_VIEN).click();
        driver.findElement(PageLocators.TU_CHOI_FORM_SUBMIT_NV).click();
        WebElement lyDoTuChoi = driver.findElement(PageLocators.GHI_CHU_LY_DO);
        lyDoTuChoi.click();
        lyDoTuChoi.sendKeys("Tôi không thể thực hiện yêu cầu này");
        Thread.sleep(2000);
        driver.findElement(PageLocators.TICKET_XAC_NHAN).click();
    }

    @AfterTest
    public void finish() {
        driver.quit();
    }
}
