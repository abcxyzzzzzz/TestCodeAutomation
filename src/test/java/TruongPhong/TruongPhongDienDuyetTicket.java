package TruongPhong;

import approval.TruongPhongDien.DuyetTicketTraVe;
import locators.ElectricManager;
import locators.PublicLocators;
import login.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import setup.SetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.util.concurrent.TimeUnit;

public class TruongPhongDienDuyetTicket {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest(WebDriver driver) throws InterruptedException {
        LoginPage.login(driver, "truongphongdien@qtsc.com.vn", "truongphongdien");
        Thread.sleep(10000);
    }
    @Test(dependsOnMethods = "loginTest")
    public void duyetTicket(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, ElectricManager.YEU_CAU_DICH_VU);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CUA_TOI);
        TestUtils.fillInputField(driver,ElectricManager.IN_PUT ,MaTicket);
        Thread.sleep(1000);
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        Thread.sleep(2000);
        driver.findElement(PublicLocators.TICKET_CHUYEN_NHAN_VIEN).click();
        //Xử lý
        DuyetTicketTraVe.DuyetTicketTraVe(driver);

        Thread.sleep(4000);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
