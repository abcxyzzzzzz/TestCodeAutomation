package QuanLyKhachHang;
import io.github.bonigarcia.wdm.WebDriverManager;
import locators.PageLocators;
import login.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Random;
import utils.TestUtils;

import java.util.concurrent.TimeUnit;
public class QuanLyCongTy {
    WebDriver driver;
    LoginPage loginPage;
    Random random;

    @BeforeTest
    public void setup() {
        random = new Random();
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
        loginPage.login("nhanviencskh@qtsc.com.vn", "nhanviencskh1");
    }
    @Test(dependsOnMethods = "loginTest")
    public void taoCongTy() throws InterruptedException{
        
        driver.findElement(PageLocators.QLKH).click();
        driver.findElement(PageLocators.QLCT).click();
        driver.findElement(PageLocators.TAO_MOI_CONG_TY).click();
        String text_CTY = generateRandomCompanyName();
        String getText = driver.findElement(PageLocators.DATA_TEN_CONG_TY).getText().trim();
        Assert.assertNotEquals(getText, text_CTY);
        TestUtils.fillInputField(driver,PageLocators.INPUT_TEN_CONG_TY,text_CTY);
        TestUtils.fillInputField(driver,PageLocators.INPUT_TEN_VIET_TAT,"nhà báo Việt Nam");
        //Chọn tòa nhà đại diện
        WebElement toaNhaDaiDien = driver.findElement(PageLocators.INPUT_TOA_NHA_DAI_DIEN);
        toaNhaDaiDien.click();
        toaNhaDaiDien.sendKeys("Trường mầm non Quang Trung");
        Thread.sleep(500);
        toaNhaDaiDien.sendKeys(Keys.ENTER);
        TestUtils.fillInputField(driver,PageLocators.INPUT_DIA_CHI_VAN_PHONG,"456 Phan Xích Long");
        TestUtils.fillInputField(driver,PageLocators.INPUT_DIA_CHI_TANG,"Tầng 9");
        TestUtils.fillInputField(driver,PageLocators.INPUT_DIA_CHI_PHONG,"123");
        TestUtils.fillInputField(driver,PageLocators.INPUT_EMAIL,generateRandomEmail());    
        TestUtils.fillInputField(driver,PageLocators.INPUT_SDT,generateRandomPhoneNumber());
        //Chọn phân loại doanh nghệp
        WebElement phanLoaiDoanhNghep = driver.findElement(PageLocators.INPUT_LOAI_DOANH_NGHEP);
        phanLoaiDoanhNghep.click();
        phanLoaiDoanhNghep.sendKeys("Trong nước");
        Thread.sleep(500);
        phanLoaiDoanhNghep.sendKeys(Keys.ENTER);
        driver.findElement(PageLocators.BUTTON_SAVE).click();
        Thread.sleep(1000);
        driver.findElement(PageLocators.BUTTON_CLOSE).click();
    }
    public String generateRandomEmail() {
        return "test_account_" + Math.floor(Math.random() * 111) + "@gmail.com";
    }
    public String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder("03");
        for (int i = 0; i < 8; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }
    public String generateRandomCompanyName() {
        String[] words = {"ABC", "XYZ", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWX", "YZZ"};
        StringBuilder sb = new StringBuilder("Công ti TNHH ");
        for (int i = 0; i < 1; i++) {
            sb.append(words[random.nextInt(words.length)]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    @AfterTest
    public void finish() {

        //driver.quit();
    }
}
