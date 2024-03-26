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

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class WorkFlow1 {
    WebDriver driver = new ChromeDriver();
    TestCSKH testCSKH = new TestCSKH();
    TestTruongPhongDien testTruongPhongDien = new TestTruongPhongDien();
    TestNhanVienDien testNhanVienDien = new TestNhanVienDien();
    DuyetTicketTraVe duyetTicketTraVe = new DuyetTicketTraVe();
    String IDTicket = null;
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
    public void DangNhapCSKH() throws Exception {
        System.out.println("Tiến hành đăng nhập ");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver,sheetLogin,1);
    }

    @Test(dependsOnMethods = "DangNhapCSKH")
    public void TaoTicket() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành tạo ticket");
        System.out.println("------------------------------------------------");
        testCSKH.createTicketTest(driver, time);
        IDTicket = TestCSKH.SelectMaTicket(driver, time);
    }

    @Test(dependsOnMethods = "TaoTicket")
    public void DangXuat() throws InterruptedException {
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        LoginPage.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuat")
    public void DangNhapTruongPhongDien() throws Exception {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng nhập trưởng phòng điện");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver,sheetLogin,2);

    }

    @Test(dependsOnMethods = "DangNhapTruongPhongDien")
    public void ChuyenTicketChoNhanVien() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành chuyển tiếp Ticket");
        System.out.println("------------------------------------------------");
        testTruongPhongDien.CHuyenKhongCanDuyet(driver, IDTicket);
    }

    @Test(dependsOnMethods = "ChuyenTicketChoNhanVien")
    public void DangXuatTruongPhongDien() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        LoginPage.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuatTruongPhongDien")
    public void DangNhapNhanVienDien() throws Exception {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng nhập nhân viên điện");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver,sheetLogin,3);
    }

    @Test(dependsOnMethods = "DangNhapNhanVienDien")
    public void XuLyTicket() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành xử lý");
        System.out.println("------------------------------------------------");
        testNhanVienDien.NhanVienTiepNhan(driver,2, IDTicket);
    }

    @Test(dependsOnMethods = "XuLyTicket")
    public void DangXuatNhanVienDien() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        LoginPage.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuatNhanVienDien")
    public void DangNhapTruongPhongDienLan2() throws Exception {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng nhập trưởng phòng điện");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver,sheetLogin,2);
    }

    @Test(dependsOnMethods = "DangNhapTruongPhongDienLan2")
    public void XuLyTicketNhanVienTraVe() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành xử lý ticket");
        System.out.println("------------------------------------------------");
        testTruongPhongDien.duyetTicket(driver, IDTicket);
    }

    @Test(dependsOnMethods = "XuLyTicketNhanVienTraVe")
    public void DangXuatTruongPhongDienLan2() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        LoginPage.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuatTruongPhongDienLan2")
    public void DangNhapCSKHLan2() throws Exception {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng nhập CSKH");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver,sheetLogin,1);
    }

    @Test(dependsOnMethods = "DangNhapCSKHLan2")
    public void DuyetTicketTraVe() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành duyệt");
        System.out.println("------------------------------------------------");
        duyetTicketTraVe.DuyetTraVe(driver, IDTicket);
    }
    @AfterMethod
    public void Capture(ITestResult result) throws InterruptedException {
        TestUtils.takeScreenshot(driver,result);
    }
    @AfterTest
    public void Close()  {
        driver.quit();
    }

}
