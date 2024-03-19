package CSKH;

import locators.CSKHLocators;
import locators.ReceivingRequests;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.SetUp;
import utils.TestUtils;

import java.util.concurrent.TimeUnit;

public class DuyetYeuCauTuCacNguon {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage.login(driver, "nhanviencskh@qtsc.com.vn", "nhanviencskh");
        Thread.sleep(5000);
    }

    @Test(dependsOnMethods = "loginTest")
    public void createTicketTest() throws InterruptedException {
        TestUtils.clickElement(driver, CSKHLocators.TICKET_MANAGER_LINK);
        TestUtils.clickElement(driver, ReceivingRequests.YEU_CAU_CHO_TIEP_NHAN);
        String textKiemTra = "Tạo mới";
        String getText = driver.findElement(ReceivingRequests.KIEM_TRA_TRANG_THAI_YEU_CAU).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.doubleClickElement(driver, ReceivingRequests.CLICK_DATA_TABLE);
        TestUtils.clickElement(driver, ReceivingRequests.TIEP_NHAN_YEU_CAU);

        Thread.sleep(1000);
        driver.navigate().refresh();
        TestUtils.fillInputField(driver, CSKHLocators.TICKET_CONTENT_FIELD, "Sửa chữa hệ thống điện trường học");
        TestUtils.fillInputField(driver, CSKHLocators.AGENT_NOTE_FIELD, "Nhanh nhất có thể nhé");
        TestUtils.selectDropDow(driver, CSKHLocators.PRIORITY_SELECT, "Cao");
        TestUtils.selectDropDow(driver, CSKHLocators.CATEGORIES_SELECT, "Yêu cầu");
        TestUtils.selectDropDow(driver, CSKHLocators.SELECT_DEPARTMENT, "PKTDN - PHÒNG KỸ THUẬT ĐIỆN NƯỚC");
        TestUtils.selectDropDow(driver, CSKHLocators.SELECT_DIVISION, "điện");
        TestUtils.selectDropDow(driver, CSKHLocators.SELECT_REQUEST_SERVICE, "Điện áp tăng cao");
        TestUtils.clickElement(driver, CSKHLocators.CREATE_TICKET_BUTTON);
        Thread.sleep(2000);

        // Chuyển tiếp
        TestUtils.clickElement(driver, CSKHLocators.SAVE_FORWARD_BUTTON);
        Thread.sleep(4000);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
