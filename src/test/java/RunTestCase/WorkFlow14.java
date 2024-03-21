package RunTestCase;

import CSKH.DuyetTicketTraVe;
import locators.CSKHLocators;
import login.LoginPage;
import login.Logout;
import approval.CSKH.RandomCSKH;
import CSKH.TestCSKH;
import TruongPhong.TestTruongPhongDien;
import TruongPhong.TruongPhongDienDuyetTicket;
import NhanVien.TestNhanVienDien;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.Test;
import setup.SetUp;
import utils.TestUtils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WorkFlow14 {
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
        testCSKH.createTicketTest(driver, RandomCSKH.Random_nguoi_lien_he_tao_ticket());
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
        testTruongPhongDien.TuChoi(driver, IDTicket);
    }

    @AfterTest
    public void Close() {
        driver.quit();
    }

}
