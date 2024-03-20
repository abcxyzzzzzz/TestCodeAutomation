package RunTestCase;

import CSKH.DuyetTicketTraVe;
import CSKH.TestCSKH;
import NhanVien.TestNhanVienDien;
import TruongPhong.TestTruongPhongDien;
import TruongPhong.TruongPhongDienDuyetTicket;
import login.Logout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.SetUp;

import java.util.concurrent.TimeUnit;

public class WorkFlow4 {
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
        System.out.println("------------------------------------------------");
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LoginTest() throws InterruptedException {
        System.out.println("Tiến hành đăng nhập ");
        System.out.println("------------------------------------------------");
        testCSKH.loginTest(driver);
    }

    @Test(dependsOnMethods = "LoginTest")
    public void CreateTicketTest() throws InterruptedException {
        System.out.println("Tiến hành tạo ticket");
        System.out.println("------------------------------------------------");
        testCSKH.createTicketTest(driver);
        IDTicket = TestCSKH.SelectMaTicket(driver);
    }

    @Test(dependsOnMethods = "CreateTicketTest")
    public void Logout() throws InterruptedException {
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        Logout.Logout(driver);
    }

    @Test(dependsOnMethods = "Logout")
    public void LoginTruongPhongDien() throws InterruptedException {
        System.out.println("Tiến hành đăng nhập trưởng phòng điện");
        System.out.println("------------------------------------------------");
        testTruongPhongDien.loginTest(driver);
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
        Logout.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuat")
    public void Login() throws InterruptedException {
        System.out.println("Tiến hành đăng nhập nhân viên điện");
        System.out.println("------------------------------------------------");
        testNhanVienDien.loginTest(driver);
    }

    @Test(dependsOnMethods = "Login")
    public void XuLyTicket() throws InterruptedException {
        System.out.println("Tiến hành xử lý");
        System.out.println("------------------------------------------------");
        testNhanVienDien.NhanVienTiepNhan(driver,1, IDTicket);
    }

    @Test(dependsOnMethods = "XuLyTicket")
    public void DangXuat1() throws InterruptedException {
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        Logout.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuat1")
    public void LoginCSKH1() throws InterruptedException {
        System.out.println("Tiến hành đăng nhập CSKH");
        System.out.println("------------------------------------------------");
        testCSKH.loginTest(driver);
    }

    @Test(dependsOnMethods = "LoginCSKH1")
    public void DuyetTraVeTicket() throws InterruptedException {
        System.out.println("Tiến hành duyệt");
        System.out.println("------------------------------------------------");
        duyetTicketTraVe.DuyetTraVe(driver,IDTicket);
    }
    @AfterTest
    public void Close() {
        driver.quit();
    }
}
