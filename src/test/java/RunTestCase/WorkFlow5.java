package RunTestCase;

import CSKH.DuyetTicketTraVe;
import CSKH.TestCSKH;
import NhanVien.TestNhanVienDien;
import TruongPhong.TestTruongPhongDien;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.SetUp;
import approval.CSKH.RandomCSKH;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class WorkFlow5 {
    WebDriver driver = new ChromeDriver();
    TestCSKH testCSKH = new TestCSKH();
    TestTruongPhongDien testTruongPhongDien = new TestTruongPhongDien();
    TestNhanVienDien testNhanVienDien = new TestNhanVienDien();
    DuyetTicketTraVe duyetTicketTraVe = new DuyetTicketTraVe();
    String IDTicket = null;
    String sheetLogin = "Sheet1";

    @BeforeTest
    public void setup() {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành set up");
        System.out.println("------------------------------------------------");
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LoginTest() throws Exception {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng nhập ");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver,sheetLogin,1);
    }

    @Test(dependsOnMethods = "LoginTest")
    public void CreateTicketTest() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành tạo ticket");
        System.out.println("------------------------------------------------");
        testCSKH.createTicketTest(driver, RandomCSKH.Random_nguoi_lien_he_tao_ticket());
        IDTicket = TestCSKH.SelectMaTicket(driver);
    }

    @Test(dependsOnMethods = "CreateTicketTest")
    public void Logout() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        LoginPage.Logout(driver);
    }

    @Test(dependsOnMethods = "Logout")
    public void LoginTruongPhongDien() throws Exception {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng nhập trưởng phòng điện");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver,sheetLogin,2);
    }

    @Test(dependsOnMethods = "LoginTruongPhongDien")
    public void ChuyenTiepTicket() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành chuyển tiếp Ticket");
        System.out.println("------------------------------------------------");
        testTruongPhongDien.CHuyenKhongCanDuyet(driver, IDTicket);
    }

    @Test(dependsOnMethods = "ChuyenTiepTicket")
    public void DangXuat() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        LoginPage.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuat")
    public void Login() throws Exception {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng nhập nhân viên điện");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver,sheetLogin,3);
    }

    @Test(dependsOnMethods = "Login")
    public void XuLyTicket() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành xử lý");
        System.out.println("------------------------------------------------");
        testNhanVienDien.NhanVienTiepNhan(driver,1, IDTicket);
    }

    @Test(dependsOnMethods = "XuLyTicket")
    public void DangXuat1() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng xuất");
        System.out.println("------------------------------------------------");
        LoginPage.Logout(driver);
    }

    @Test(dependsOnMethods = "DangXuat1")
    public void LoginCSKH1() throws Exception {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành đăng nhập CSKH");
        System.out.println("------------------------------------------------");
        LoginPage.login(driver,sheetLogin,1);
    }

    @Test(dependsOnMethods = "LoginCSKH1")
    public void DuyetTraVeTicket() throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println("Tiến hành duyệt");
        System.out.println("------------------------------------------------");
        duyetTicketTraVe.TuChoiTraVe(driver,IDTicket);
    }
    @AfterTest
    public void Close() {
        driver.quit();
    }
}
