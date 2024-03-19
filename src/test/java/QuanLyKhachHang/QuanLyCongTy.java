package QuanLyKhachHang;

import locators.CSKHLocators;
import locators.CustomerManagement;
import locators.InputForm;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import setup.SetUp;
import utils.TestUtils;

public class QuanLyCongTy {
    WebDriver driver;
    Random random;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() throws InterruptedException {
        LoginPage.login(driver, "nhanviencskh@qtsc.com.vn", "nhanviencskh");
    }

    @Test(dependsOnMethods = "loginTest")
    public void taoCongTy() throws InterruptedException {

        driver.findElement(CustomerManagement.QLKH).click();
        driver.findElement(CustomerManagement.QLCT).click();
        driver.findElement(CustomerManagement.TAO_MOI_CONG_TY).click();
        ChonToaNhaDaiDien();
        // Chọn phân loại doanh nghệp
        TestUtils.selectDropDow(driver, InputForm.INPUT_LOAI_DOANH_NGHEP, "Trong nước");
        // driver.findElement(InputForm.BUTTON_SAVE).click();
        Thread.sleep(1000);
        // driver.findElement(InputForm.BUTTON_CLOSE).click();
    }

    public void ChonToaNhaDaiDien() throws InterruptedException {
        // Chọn tòa nhà đại diện
        String text_CTY = generateRandomCompanyName();
        String getText = driver.findElement(CSKHLocators.DATA_TEN_CONG_TY).getText().trim();
        Assert.assertNotEquals(getText, text_CTY);
        TestUtils.fillInputField(driver, InputForm.INPUT_TEN_CONG_TY, text_CTY);
        TestUtils.fillInputField(driver, InputForm.INPUT_TEN_VIET_TAT, "nhà báo Việt Nam");
        TestUtils.selectDropDow(driver, InputForm.INPUT_TOA_NHA_DAI_DIEN, "Trường mầm non Quang Trung");
        TestUtils.fillInputField(driver, InputForm.INPUT_DIA_CHI_VAN_PHONG, "456 Phan Xích Long");
        TestUtils.fillInputField(driver, InputForm.INPUT_DIA_CHI_TANG, "Tầng 9");
        TestUtils.fillInputField(driver, InputForm.INPUT_DIA_CHI_PHONG, "123");
        TestUtils.fillInputField(driver, InputForm.INPUT_EMAIL, generateRandomEmail());
        TestUtils.fillInputField(driver, InputForm.INPUT_SDT, generateRandomPhoneNumber());
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
        String[] words = { "ABC", "XYZ", "DEF", "GHI", "JKL", "MNO", "PQR", "STU", "VWX", "YZZ" };
        StringBuilder sb = new StringBuilder("Công ti TNHH ");
        for (int i = 0; i < 1; i++) {
            sb.append(words[random.nextInt(words.length)]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    @AfterTest
    public void finish() {

        // driver.quit();
    }
}
