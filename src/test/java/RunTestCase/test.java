package RunTestCase;

import CSKH.DuyetTicketTraVe;
import CSKH.TestCSKH;
import TruongPhong.TestTruongPhongDien;
import NhanVien.TestNhanVienDien;
import login.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.SetUp;
import approval.CSKH.RandomCSKH;
import utils.TestUtils;

import java.awt.*;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class test {
    WebDriver driver = new ChromeDriver();
    TestCSKH testCSKH = new TestCSKH();
    TestTruongPhongDien testTruongPhongDien = new TestTruongPhongDien();
    TestNhanVienDien testNhanVienDien = new TestNhanVienDien();
    DuyetTicketTraVe duyetTicketTraVe = new DuyetTicketTraVe();
    String IDTicket = "T20240327008";
    String sheetLogin = "Sheet1";
    String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    @BeforeTest
    public void ChuanBi() {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành set up");
        System.out.println("------------------------------------------------");
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void DangNhapNhanVienDien() throws Exception {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng nhập nhân viên điện");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver, sheetLogin, 3);
    }

    @Test(dependsOnMethods = "DangNhapNhanVienDien")
    public void XuLyTicket() throws InterruptedException, AWTException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành xử lý");
        System.out.println("------------------------------------------------");
        testNhanVienDien.NhanVienTiepNhantest(driver, 2, IDTicket);
    }
}
