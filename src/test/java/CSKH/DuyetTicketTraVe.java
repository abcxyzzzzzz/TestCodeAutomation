package CSKH;

import locators.CSKHLocators;
import locators.ElectricManager;
import locators.PublicLocators;
import login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.SetUp;
import utils.TestUtils;
import approval.CSKH.Duyet;
import approval.CSKH.TuChoi;

import java.util.concurrent.TimeUnit;

public class DuyetTicketTraVe {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest(WebDriver driver) throws InterruptedException {
        LoginPage.login(driver,"nhanviencskh@qtsc.com.vn", "nhanviencskh");
    }
    @Test(dependsOnMethods = "loginTest")
    public void createTicketTest(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, CSKHLocators.TICKET_MANAGER_LINK);
        TestUtils.clickElement(driver, CSKHLocators.TICKET_CUA_TOI_CSKH);
        String text = "Chờ nghiệm thu";
        String getText = driver.findElement(By.xpath("(//td[@data-pin='none'])[9]")).getText().trim();
        Assert.assertEquals(text,getText);
        TestUtils.fillInputField(driver, ElectricManager.IN_PUT ,MaTicket);
        Thread.sleep(1000);
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CHUYEN_NHAN_VIEN);

        Thread.sleep(1000);
        Duyet.Duyet(driver);
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
