package CSKH;

import locators.CSKHLocators;
import login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.SetUp;
import utils.TestUtils;
import login.Logout;
import java.util.concurrent.TimeUnit;

public class TestCSKH {
    WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @Test()
    public void loginTest(WebDriver driver) throws InterruptedException {
        LoginPage.login(driver, "nhanviencskh@qtsc.com.vn", "nhanviencskh");
    }

    @Test(dependsOnMethods = "loginTest")
    public void logout() throws InterruptedException {
        Logout.Logout(driver);
    }

    @Test(dependsOnMethods = "loginTest")
    public void createTicketTest(WebDriver driver) throws InterruptedException {
        TestUtils.clickElement(driver, CSKHLocators.TICKET_MANAGER_LINK);
        TestUtils.clickElement(driver, CSKHLocators.REQUEST_LIST);
        TestUtils.clickElement(driver, CSKHLocators.CREATE_NEW_REQUEST);
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        TestUtils.clickElement(driver, CSKHLocators.TIM_KIEM);
        Thread.sleep(1000);
        // Chọn đối tượng trong bảng
        TestUtils.doubleClickElement(driver, CSKHLocators.DATA_BANG);
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
        Thread.sleep(10000);

    }

    @Test(dependsOnMethods = "createTicketTest")
    public static String SelectMaTicket(WebDriver driver) throws InterruptedException {
        driver.get("https://crm-dev.lsat.vn/ticket/list");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        String MaTicket = driver.findElement(By.xpath("(//td[@data-pin='none'])[1]")).getText().trim();
        return MaTicket;
    }

    @AfterTest
    public void tearDown() {
        // driver.quit();
    }
}
