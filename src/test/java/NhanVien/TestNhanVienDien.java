package NhanVien;

import io.github.bonigarcia.wdm.WebDriverManager;
import locators.PageLocators;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestUtils;

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
    }

    @Test (dependsOnMethods = "loginTest")
    public void tiepNhanTicket() throws InterruptedException {
        TestUtils.clickElement(driver, PageLocators.YEU_CAU_DV_NV);
        TestUtils.clickElement(driver, PageLocators.TICKET_CUA_TOI);
        TestUtils.doubleClickElement(driver, PageLocators.TICKET_HANH_DONG);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PageLocators.TICKET_CHUYEN_NHAN_VIEN);
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
        TestUtils.clickElement(driver, PageLocators.TICKET_CAN_DUYET);
        TestUtils.fillInputField(driver,PageLocators.GHI_CHU_LY_DO,"Tôi có thể thực hiện yêu cầu này");
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PageLocators.TICKET_XAC_NHAN);
        Thread.sleep(5000);
        TestUtils.fillInputField(driver, PageLocators.TRUOC_XU_LY, "Kết quả trước khi thực hiện hành động");
        TestUtils.clickElement(driver, PageLocators.UPDATE_KQ_TRUOC_XU_LY);
        Thread.sleep(1000);
        TestUtils.fillInputField(driver,PageLocators.SAU_XU_LY,"Kết quả sau khi thực hiện hành động");
        Thread.sleep(1000);
        TestUtils.clickElement(driver, PageLocators.UPDATE_KQ_SAU_XU_LY);
        Thread.sleep(4000);

        int thucHien = 1;
        switch (thucHien) {
            case 1:
                TestUtils.clickElement(driver,PageLocators.TICKET_CHUYEN_NHAN_VIEN);
                TestUtils.clickElement(driver,PageLocators.CO_THE_XU_LY);
                TestUtils.fillInputField(driver,PageLocators.GHI_CHU_LY_DO,"Tôi đã thực hiện yêu cầu này");
                TestUtils.clickElement(driver,PageLocators.TICKET_XAC_NHAN);
                Thread.sleep(1000);
                break;

            case 2:
                TestUtils.clickElement(driver,PageLocators.TICKET_CHUYEN_NHAN_VIEN);
                TestUtils.clickElement(driver,PageLocators.KHONG_THE_XU_LY);
                TestUtils.fillInputField(driver,PageLocators.GHI_CHU_LY_DO,"Tôi không thể thực hiện yêu cầu này");
                TestUtils.clickElement(driver,PageLocators.TICKET_XAC_NHAN);
                Thread.sleep(1000);
                break;
        }
    }

    private void handleRejection() throws InterruptedException {
        TestUtils.clickElement(driver,PageLocators.TICKET_CHUYEN_NHAN_VIEN);
        TestUtils.clickElement(driver,PageLocators.TU_CHOI_FORM_SUBMIT_NV);
        TestUtils.fillInputField(driver,PageLocators.GHI_CHU_LY_DO, "Tôi không thể thực hiện yêu cầu này");
        Thread.sleep(2000);
        TestUtils.clickElement(driver,PageLocators.TICKET_XAC_NHAN);

    }

    @AfterTest
    public void finish() {
        //driver.quit();
    }
}
