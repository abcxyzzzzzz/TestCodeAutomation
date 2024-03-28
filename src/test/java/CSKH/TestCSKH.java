package CSKH;

import approval.CSKH.RandomCSKH;
import locators.CSKHLocators;
import login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class TestCSKH {
    public void createTicketTest(WebDriver driver, String timeString) throws InterruptedException {
        TestUtils.clickElement(driver, CSKHLocators.QuanLy);
        TestUtils.clickElement(driver, CSKHLocators.DanhSachYC);
        TestUtils.clickElement(driver, CSKHLocators.TaoYC);
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        TestUtils.clickElement(driver, CSKHLocators.TimKiem);
        Thread.sleep(1000);
        // Chọn đối tượng trong bảng
        TestUtils.fillInputField(driver, CSKHLocators.NguoiLienHeTaoTicket, RandomCSKH.Random_nguoi_lien_he_tao_ticket());
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, CSKHLocators.DuLieuBang);
        TestUtils.fillInputField(driver, CSKHLocators.NoiDungTicket, timeString);
        Thread.sleep(500);
        TestUtils.fillInputField(driver, CSKHLocators.NoiDungGhiChu, RandomCSKH.generateRandomGhiChu());
        TestUtils.selectDropDow(driver, CSKHLocators.MucDoTicket, RandomCSKH.generateRandomMucDo());
        TestUtils.selectDropDow(driver, CSKHLocators.PhanLoaiTicket, RandomCSKH.generateRandomPhanLoai());
        TestUtils.selectDropDow(driver, CSKHLocators.PhongBan, "PKTDN - PHÒNG KỸ THUẬT ĐIỆN NƯỚC");
        TestUtils.selectDropDow(driver, CSKHLocators.BoPhan, "điện");
        TestUtils.selectDropDow(driver, CSKHLocators.YCDichVu, "Điện áp tăng cao");
        TestUtils.clickElement(driver, CSKHLocators.TaoTicket);
        Thread.sleep(4000);
        String textNull = driver.findElement(CSKHLocators.KiemTraND).getText().trim();
        String textNull2 = driver.findElement(CSKHLocators.KiemTraTruongPhong).getText().trim();
        String textNull3 = driver.findElement(CSKHLocators.KiemTraBoPhan).getText().trim();
        if (textNull.isEmpty()) {
            TestUtils.fillInputField(driver, CSKHLocators.NoiDungTicket, timeString);
        }else{
            TestUtils.clickElement(driver, CSKHLocators.LuuTicket);
            Thread.sleep(10000);
        }
//        if (textNull2.isEmpty()) {
//            TestUtils.selectDropDow(driver, CSKHLocators.PhongBan, "PKTDN - PHÒNG KỸ THUẬT ĐIỆN NƯỚC");
//        }if (textNull3.isEmpty()) {
//            TestUtils.selectDropDow(driver, CSKHLocators.BoPhan, "điện");
//            TestUtils.selectDropDow(driver, CSKHLocators.YCDichVu, "Điện áp tăng cao");
//        }
//        TestUtils.clickElement(driver, CSKHLocators.TaoTicket);
//        Thread.sleep(4000);

    }

    @Test(dependsOnMethods = "createTicketTest")
    public static String SelectMaTicket(WebDriver driver, String timeString) throws InterruptedException {
        TestUtils.fillInputField(driver, CSKHLocators.TimKiemNoiDung, timeString);
        Thread.sleep(1000);
        TestUtils.doubleClickElement(driver, CSKHLocators.ChonDuLieuBang);
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String MaTicket = driver.findElement(By.xpath("(//td[contains(@data-pin,'none')])[101]")).getText().trim();
        return MaTicket;
    }
}
