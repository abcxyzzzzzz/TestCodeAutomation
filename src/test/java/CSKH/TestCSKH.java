package CSKH;

import io.github.bonigarcia.wdm.WebDriverManager;
import locators.PageLocators;
import login.LoginPage;
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
import utils.TestUtils;

import java.util.concurrent.TimeUnit;

public class TestCSKH {

    WebDriver driver;
    WebDriverWait wait;
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
    public void createTicketTest() throws InterruptedException {
        driver.findElement(PageLocators.TICKET_MANAGER_LINK).click();
        driver.findElement(PageLocators.REQUEST_LIST).click();
        driver.findElement(PageLocators.CREATE_NEW_REQUEST).click();
        TestUtils.clickElement(driver, PageLocators.CREATE_NEW_REQUEST);
        Thread.sleep(1000);
        driver.navigate().refresh();
        driver.findElement(By.xpath("//button[@class='btn-label btn btn-info btn-sm']")).click();
        Thread.sleep(1000);
        // Chọn đối tượng trong bảng
        TestUtils.doubleClickElement(driver, PageLocators.DATA_BANG);
        TestUtils.fillInputField(driver, PageLocators.TICKET_CONTENT_FIELD, "Sửa chữa hệ thống điện trường học");

        TestUtils.fillInputField(driver, PageLocators.AGENT_NOTE_FIELD, "Nhanh nhất có thể nhé");

        TestUtils.selectDropDow(driver,PageLocators.PRIORITY_SELECT,"Cao");

        TestUtils.selectDropDow(driver,PageLocators.CATEGORIES_SELECT,"Yêu cầu");

        TestUtils.selectDropDow(driver,PageLocators.SELECT_DEPARTMENT,"PKTDN - PHÒNG KỸ THUẬT ĐIỆN NƯỚC");

        TestUtils.selectDropDow(driver,PageLocators.SELECT_DIVISION,"điện");

        TestUtils.selectDropDow(driver,PageLocators.SELECT_REQUEST_SERVICE,"Điện áp tăng cao");

        driver.findElement(PageLocators.CREATE_TICKET_BUTTON).click();
        Thread.sleep(2000);

        // Chuyển tiếp
        driver.findElement(PageLocators.SAVE_FORWARD_BUTTON).click();
        Thread.sleep(4000);

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
