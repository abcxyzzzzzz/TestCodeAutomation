package CSKH;

import locators.CSKHLocators;
import locators.PublicLocators;
import login.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.SetUp;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TaoYeuCauTuMail {
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
    public void openNewTabAndLoginToGmail() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://mail.google.com");
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        emailInput.sendKeys("nhoktuyenhuynh12@gmail.com");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button/span"))
                .click();
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
        TestUtils.clickElement(driver, CSKHLocators.TICKET_MANAGER_LINK);
        TestUtils.clickElement(driver, CSKHLocators.TICKET_CUA_TOI_CSKH);
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        driver.findElement(PublicLocators.TICKET_CHUYEN_NHAN_VIEN).click();
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

    public void Duyet() throws InterruptedException {
        driver.findElement(CSKHLocators.TICKET_DUYET_TRA_VE).click();
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO, "Duyệt");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.TICKET_XAC_NHAN).click();
    }

    public void tuChoi() throws InterruptedException {
        driver.findElement(CSKHLocators.TICKET_TU_CHOI_TRA_VE).click();
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO, "Từ chối");
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.findElement(PublicLocators.TICKET_XAC_NHAN).click();
    }

    @AfterTest
    public void tearDown() {
        // driver.quit();
    }
}
