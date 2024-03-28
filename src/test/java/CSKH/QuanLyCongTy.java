package CSKH;

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
    Random random;

    public void taoCongTy(WebDriver driver) throws InterruptedException {

        driver.findElement(CustomerManagement.QuanLyKhachHang).click();
        driver.findElement(CustomerManagement.QuanLyCongTy).click();
        driver.findElement(CustomerManagement.TaoMoi).click();
        ChonToaNhaDaiDien(driver);
        // Chọn phân loại doanh nghệp
        TestUtils.selectDropDow(driver, InputForm.LoaiDoanhNghiep, "Trong nước");
        // driver.findElement(InputForm.BUTTON_SAVE).click();
        Thread.sleep(1000);
        // driver.findElement(InputForm.BUTTON_CLOSE).click();
    }

    public void ChonToaNhaDaiDien(WebDriver driver) throws InterruptedException {
        // Chọn tòa nhà đại diện
        String text_CTY = generateRandomCompanyName();
        String getText = driver.findElement(CSKHLocators.TenCongTy).getText().trim();
        Assert.assertNotEquals(getText, text_CTY);
        TestUtils.fillInputField(driver, InputForm.TenCongTy, text_CTY);
        TestUtils.fillInputField(driver, InputForm.TenVietTat, "nhà báo Việt Nam");
        TestUtils.selectDropDow(driver, InputForm.ToaNhaDaiDien, "Trường mầm non Quang Trung");
        TestUtils.fillInputField(driver, InputForm.DiaChiVanPhong, "456 Phan Xích Long");
        TestUtils.fillInputField(driver, InputForm.DiaChiTang, "Tầng 9");
        TestUtils.fillInputField(driver, InputForm.DiaChiPhong, "123");
        TestUtils.fillInputField(driver, InputForm.Email, generateRandomEmail());
        TestUtils.fillInputField(driver, InputForm.SDT, generateRandomPhoneNumber());
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
}
