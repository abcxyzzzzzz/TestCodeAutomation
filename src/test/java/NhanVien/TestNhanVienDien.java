package NhanVien;

import locators.ElectricManager;
import locators.EmployssLocators;
import approval.NhanVien.DongYYeuCau;
import locators.PublicLocators;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestUtils;
import setup.SetUp;

import java.util.concurrent.TimeUnit;

public class TestNhanVienDien {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest(WebDriver driver) throws InterruptedException {
        LoginPage.login(driver, "nhanviendien@qtsc.com.vn", "nhanviendien");
    }
    @Test (dependsOnMethods = "loginTest")
    public void tiepNhanTicket(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, EmployssLocators.YEU_CAU_DV_NV);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CUA_TOI);
        TestUtils.fillInputField(driver, ElectricManager.IN_PUT ,MaTicket);
        Thread.sleep(1000);
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CHUYEN_NHAN_VIEN);
        DongYYeuCau.DongYYeuCau(driver);

    }
    @AfterTest
    public void finish() {
        //driver.quit();
    }
}
