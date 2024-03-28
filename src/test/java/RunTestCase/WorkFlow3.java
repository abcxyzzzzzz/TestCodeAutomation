package RunTestCase;

import CSKH.DuyetTicketTraVe;
import approval.CSKH.RandomCSKH;
import login.LoginPage;
import CSKH.TestCSKH;
import TruongPhong.TestTruongPhongDien;
import NhanVien.TestNhanVienDien;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.SetUp;
import utils.TestUtils;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class WorkFlow3 {
    WebDriver driver = new ChromeDriver();
    TestCSKH testCSKH = new TestCSKH();
    String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    TestTruongPhongDien testTruongPhongDien = new TestTruongPhongDien();
    TestNhanVienDien testNhanVienDien = new TestNhanVienDien();
    DuyetTicketTraVe duyetTicketTraVe = new DuyetTicketTraVe();
    String IDTicket = null;
    String sheetLogin = "Sheet1";

    @BeforeTest
    public void ChuanBi() {
        System.out.println("Tiến hành set up");
        System.out.println("------------------------------------------------");
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void DangNhapCSKH() throws Exception {
        System.out.println("Tiến hành đăng nhập ");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver, sheetLogin, 1);
    }

    @Test(dependsOnMethods = "DangNhapCSKH")
    public void CreateTicketTest() throws InterruptedException {
        System.out.println("Tiến hành tạo ticket");
        System.out.println("------------------------------------------------");
        testCSKH.createTicketTest(driver, time);
        IDTicket = TestCSKH.SelectMaTicket(driver, time);
    }

    @Test(dependsOnMethods = "CreateTicketTest")
    public void Logout() throws InterruptedException {
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        LoginPage.Logout(driver);
    }

    @Test(dependsOnMethods = "Logout")
    public void LoginTruongPhongDien() throws Exception {
        System.out.println("Tiến hành đăng nhập trưởng phòng điện");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver, sheetLogin, 2);
    }

    @Test(dependsOnMethods = "LoginTruongPhongDien")
    public void ChuyenTiepTicket() throws InterruptedException {
        System.out.println("Tiến hành chuyển tiếp Ticket");
        System.out.println("------------------------------------------------");
        testTruongPhongDien.CHuyenKhongCanDuyet(driver, IDTicket);
    }

    @Test(dependsOnMethods = "ChuyenTiepTicket")
    public void DangXuat() throws InterruptedException {
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        LoginPage.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuat")
    public void Login() throws Exception {
        System.out.println("Tiến hành đăng nhập nhân viên điện");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver, sheetLogin, 3);
    }

    @Test(dependsOnMethods = "Login")
    public void XuLyTicket() throws InterruptedException, AWTException {
        System.out.println("Tiến hành xử lý");
        System.out.println("------------------------------------------------");
        testNhanVienDien.NhanVienTiepNhan(driver, 2, IDTicket);
    }

    @Test(dependsOnMethods = "XuLyTicket")
    public void DangXuat1() throws InterruptedException {
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        LoginPage.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuat1")
    public void LoginTruongPhongDien1() throws Exception {
        System.out.println("Tiến hành đăng nhập trưởng phòng điện");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver, sheetLogin, 2);
    }

    @Test(dependsOnMethods = "LoginTruongPhongDien1")
    public void XuLyTicketTraVe() throws InterruptedException {
        System.out.println("Tiến hành xử lý ticket");
        System.out.println("------------------------------------------------");
        testTruongPhongDien.tuChoiDuyetTicket(driver, IDTicket);
    }

    @Test(dependsOnMethods = "XuLyTicketTraVe")
    public void DangXuat2() throws InterruptedException {
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        LoginPage.Logout(driver);
    }

    @AfterTest
    public void Close() {
        driver.quit();
    }

}
