package CSKH;

import locators.CSKHLocators;
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

import java.util.concurrent.TimeUnit;

public class Approval_Ticket_Return {
    WebDriver driver;
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage.login(driver,"nhanviencskh@qtsc.com.vn", "nhanviencskh");
    }

    @Test(dependsOnMethods = "loginTest")
    public void createTicketTest() throws InterruptedException {
        TestUtils.clickElement(driver, CSKHLocators.TICKET_MANAGER_LINK);
        TestUtils.clickElement(driver, CSKHLocators.TICKET_CUA_TOI_CSKH);
        String text = "Chờ nghiệm thu1";
        String getText = driver.findElement(By.xpath("(//td[@data-pin='none'])[9]")).getText().trim();
        Assert.assertEquals(text,getText);
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CHUYEN_NHAN_VIEN);

        Thread.sleep(1000);
        int numChuyenTiep = 1;
        switch (numChuyenTiep) {
            case 1:
                Duyet();
                break;
            case 2:
                tuChoi();
                break;
        }
    }

    public void Duyet()throws InterruptedException{
        driver.findElement(CSKHLocators.TICKET_DUYET_TRA_VE).click();
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO, "Duyệt");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.TICKET_XAC_NHAN).click();
    }
    public void tuChoi()throws InterruptedException{
        driver.findElement(CSKHLocators.TICKET_TU_CHOI_TRA_VE).click();
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO, "Từ chối");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.TICKET_XAC_NHAN).click();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
