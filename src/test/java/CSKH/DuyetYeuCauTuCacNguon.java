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
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.util.concurrent.TimeUnit;

public class DuyetYeuCauTuCacNguon {

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
    }

    @Test(dependsOnMethods = "loginTest")
    public void createTicketTest() throws InterruptedException {
        driver.findElement(PageLocators.TICKET_MANAGER_LINK).click();
        driver.findElement(PageLocators.YEU_CAU_CHO_TIEP_NHAN).click();
        String textKiemTra = "Tạo mới";
        String getText = driver.findElement(PageLocators.KIEM_TRA_TRANG_THAI_YEU_CAU).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.doubleClickElement(driver,PageLocators.CLICK_DATA_TABLE);
        driver.findElement(PageLocators.TIEP_NHAN_YEU_CAU).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
        TestUtils.fillInputField(driver, PageLocators.TICKET_CONTENT_FIELD, "Sửa chữa hệ thống điện trường học");
        TestUtils.fillInputField(driver, PageLocators.AGENT_NOTE_FIELD, "Nhanh nhất có thể nhé");

        // Mức độ ưu tiên
        WebElement priorityElement = driver.findElement(PageLocators.PRIORITY_SELECT);
        priorityElement.click();
        priorityElement.sendKeys("Cao");
        priorityElement.sendKeys(Keys.ENTER);

        // Phân loại ticket
        WebElement categoriesElement = driver.findElement(PageLocators.CATEGORIES_SELECT);
        categoriesElement.click();
        categoriesElement.sendKeys("Yêu cầu");
        categoriesElement.sendKeys(Keys.ENTER);

        // Chọn phòng ban
        WebElement departmentElement = driver.findElement(PageLocators.SELECT_DEPARTMENT);
        departmentElement.click();
        departmentElement.sendKeys("PKTDN - PHÒNG KỸ THUẬT ĐIỆN NƯỚC");
        Thread.sleep(500);
        departmentElement.sendKeys(Keys.ENTER);

        // Chọn bộ phận
        WebElement divisionElement = driver.findElement(PageLocators.SELECT_DIVISION);
        divisionElement.click();
        Thread.sleep(1000);
        divisionElement.sendKeys(Keys.ENTER);

        // Chọn yêu cầu dịch vụ
        WebElement requestElement = driver.findElement(PageLocators.SELECT_REQUEST_SERVICE);
        requestElement.click();
        requestElement.sendKeys("Điện áp tăng cao");
        Thread.sleep(2000);
        requestElement.sendKeys(Keys.ENTER);

        // Tạo ticket
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
