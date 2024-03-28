package CSKH;

import approval.CSKH.RandomCSKH;
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
    public void createTicketTest(WebDriver driver, String timeString) throws InterruptedException {
        TestUtils.clickElement(driver, CSKHLocators.QuanLy);
        TestUtils.clickElement(driver, ReceivingRequests.YeuCauDoi);
        String textKiemTra = "Tạo mới";
        String getText = driver.findElement(ReceivingRequests.KiemTraTrangThai).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.doubleClickElement(driver, ReceivingRequests.ChonBang);
        TestUtils.clickElement(driver, ReceivingRequests.TiepNhan);
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        TestUtils.clickElement(driver, CSKHLocators.TimKiem);
        Thread.sleep(1000);
        // Chọn đối tượng trong bảng
        TestUtils.fillInputField(driver, CSKHLocators.NguoiLienHeTaoTicket, RandomCSKH.Random_nguoi_lien_he_tao_ticket());
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, CSKHLocators.DuLieuBang);
        TestUtils.fillInputField(driver, CSKHLocators.NoiDungTicket, RandomCSKH.generateRandom());
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
//            TestUtils.selectDropDow(driver, CSKHLocators.SELECT_DEPARTMENT, "PKTDN - PHÒNG KỸ THUẬT ĐIỆN NƯỚC");
//        }if (textNull3.isEmpty()) {
//            TestUtils.selectDropDow(driver, CSKHLocators.SELECT_DIVISION, "điện");
//            TestUtils.selectDropDow(driver, CSKHLocators.SELECT_REQUEST_SERVICE, "Điện áp tăng cao");
//        }
//        TestUtils.clickElement(driver, CSKHLocators.CREATE_TICKET_BUTTON);
//        Thread.sleep(4000);

    }
}
