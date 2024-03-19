package RunTestCase;

import CSKH.DuyetTicketTraVe;
import locators.CSKHLocators;
import login.LoginPage;
import login.Logout;
import CSKH.TestCSKH;
import TruongPhong.TestTruongPhongDien;
import TruongPhong.TruongPhongDienDuyetTicket;
import NhanVien.TestNhanVienDien;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.SetUp;
import utils.TestUtils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class LuongKhongCanDuyet {
    WebDriver driver = new ChromeDriver();
    TestCSKH testCSKH = new TestCSKH();
    TestTruongPhongDien testTruongPhongDien = new TestTruongPhongDien();
    TruongPhongDienDuyetTicket truongPhongDienDuyetTicket = new TruongPhongDienDuyetTicket();
    TestNhanVienDien testNhanVienDien = new TestNhanVienDien();
    DuyetTicketTraVe duyetTicketTraVe = new DuyetTicketTraVe();
    String IDTicket = null;

    @BeforeTest
    public void setup() {
        System.out.println("Tiến hành set up");
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LoginTest() throws InterruptedException {
        System.out.println("Tiến hành đăng nhập ");
        testCSKH.loginTest(driver);
    }

    @Test(dependsOnMethods = "LoginTest")
    public void CreateTicketTest() throws InterruptedException {
        System.out.println("Tiến hành tạo ticket");
        testCSKH.createTicketTest(driver);
        IDTicket = TestCSKH.SelectMaTicket(driver);
    }

    @Test(dependsOnMethods = "CreateTicketTest")
    public void Logout() throws InterruptedException {
        System.out.println("Tiến hành đăng xuất");
        Logout.Logout(driver);
    }

    @Test(dependsOnMethods = "Logout")
    public void LoginTruongPhongDien() throws InterruptedException {
        System.out.println("Tiến hành đăng nhập trưởng phòng điện");
        testTruongPhongDien.loginTest(driver);
    }

    @Test(dependsOnMethods = "LoginTruongPhongDien")
    public void ChuyenTiepTicket() throws InterruptedException {
        System.out.println("Tiến hành chuyển tiếp Ticket");
        testTruongPhongDien.CHuyenKhongCanDuyet(driver, IDTicket);
    }

    @Test(dependsOnMethods = "ChuyenTiepTicket")
    public void DangXuat() throws InterruptedException {
        System.out.println("Tiến hành đăng xuất");
        Logout.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuat")
    public void Login() throws InterruptedException {
        System.out.println("Tiến hành đăng nhập nhân viên điện");
        testNhanVienDien.loginTest(driver);
    }

    @Test(dependsOnMethods = "Login")
    public void XuLyTicket() throws InterruptedException {
        System.out.println("Tiến hành xử lý");
        testNhanVienDien.tiepNhanTicket(driver, IDTicket);
    }

    @Test(dependsOnMethods = "XuLyTicket")
    public void DangXuat1() throws InterruptedException {
        System.out.println("Tiến hành đăng xuất");
        Logout.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuat1")
    public void LoginTruongPhongDien1() throws InterruptedException {
        System.out.println("Tiến hành đăng nhập trưởng phòng điện");
        testTruongPhongDien.loginTest(driver);
    }

    @Test(dependsOnMethods = "LoginTruongPhongDien1")
    public void LoginCSKH1() throws InterruptedException {
        System.out.println("Tiến hành đăng nhập CSKH");
        testCSKH.loginTest(driver);
    }

    @Test(dependsOnMethods = "LoginCSKH1")
    public void DuyetTraVeTicket() throws InterruptedException {
        System.out.println("Tiến hành duyệt");
        duyetTicketTraVe.createTicketTest(driver, IDTicket);
    }
    @AfterTest
    public void Close() {
        driver.quit();
    }

}