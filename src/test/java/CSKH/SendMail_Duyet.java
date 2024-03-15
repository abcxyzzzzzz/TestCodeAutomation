package CSKH;

import io.github.bonigarcia.wdm.WebDriverManager;
import locators.PageLocators;
import login.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
public class SendMail_Duyet {
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
    public void openNewTabAndLoginToGmail() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://mail.google.com");
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        emailInput.sendKeys("nhoktuyenhuynh12@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button/span")).click();
        Thread.sleep(1000);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys("minh210402");
        driver.findElement(By.xpath("//span[contains(text(), 'Tiếp theo')]")).click();
        Thread.sleep(2000);
        sendEmailTest();
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public void sendEmailTest() throws InterruptedException {
        driver.findElement(By.xpath("//div[contains(text(), 'Soạn')]")).click();
        Thread.sleep(2000);
        WebElement recipientInput = driver.findElement(By.xpath("//textarea[@name='to']"));
        recipientInput.sendKeys("recipient_email@example.com");
        WebElement subjectInput = driver.findElement(By.xpath("//input[@name='subjectbox']"));
        subjectInput.sendKeys("Test email");
        WebElement bodyInput = driver.findElement(By.xpath("//div[@aria-label='Nội dung email']"));
        bodyInput.sendKeys("Nội dung email test");
        driver.findElement(By.xpath("//div[contains(text(), 'Gửi')]")).click();
        Thread.sleep(5000);
    }
    
    @Test(dependsOnMethods = "sendEmailTest")
    public void createTicketTest() throws InterruptedException {
        driver.findElement(PageLocators.TICKET_MANAGER_LINK).click();
        driver.findElement(PageLocators.TICKET_CUA_TOI_CSKH).click();
        TestUtils.doubleClickElement(driver, PageLocators.TICKET_HANH_DONG);
        driver.findElement(PageLocators.TICKET_CHUYEN_NHAN_VIEN).click();
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
        driver.findElement(PageLocators.TICKET_DUYET_TRA_VE).click();
        WebElement reasonCancel = driver.findElement(PageLocators.GHI_CHU_LY_DO);
        TestUtils.fillInputField(driver, PageLocators.GHI_CHU_LY_DO, "Duyệt");
        Thread.sleep(2000);
        driver.findElement(PageLocators.TICKET_XAC_NHAN).click();
    }
    public void tuChoi()throws InterruptedException{
        driver.findElement(PageLocators.TICKET_TU_CHOI_TRA_VE).click();
        WebElement reasonCancel = driver.findElement(PageLocators.GHI_CHU_LY_DO);
        TestUtils.fillInputField(driver, PageLocators.GHI_CHU_LY_DO, "Từ chối");
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.findElement(PageLocators.TICKET_XAC_NHAN).click();
    }
    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}
