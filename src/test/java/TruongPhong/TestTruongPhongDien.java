package TruongPhong;

import approval.TruongPhongDien.XuLyTruongPhongDien;
import locators.ElectricManager;
import locators.PublicLocators;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import setup.SetUp;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.util.concurrent.TimeUnit;

public class TestTruongPhongDien {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        SetUp.setUp(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest(WebDriver driver) throws InterruptedException {
        LoginPage.login(driver, "truongphongdien@qtsc.com.vn", "truongphongdien");
    }

    @Test(dependsOnMethods = "loginTest")
    public void chuyenTiepTickket(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, ElectricManager.YEU_CAU_DICH_VU);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CUA_TOI);
        // Kiểm tra trạng thái ticket
        String textKiemTra = "Đã chuyển tiếp";
        String getText = driver.findElement(ElectricManager.KIEM_TRA_TRANG_THAI).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.fillInputField(driver, ElectricManager.IN_PUT, MaTicket);
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CHUYEN_NHAN_VIEN);
        XuLyTruongPhongDien.XuLyCanDuyet(driver);
    }
    @Test(dependsOnMethods = "loginTest")
    public void CHuyenKhongCanDuyet(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, ElectricManager.YEU_CAU_DICH_VU);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CUA_TOI);
        // Kiểm tra trạng thái ticket
        String textKiemTra = "Đã chuyển tiếp";
        String getText = driver.findElement(ElectricManager.KIEM_TRA_TRANG_THAI).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.fillInputField(driver, ElectricManager.IN_PUT, MaTicket);
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CHUYEN_NHAN_VIEN);
        XuLyTruongPhongDien.XuKhongLyCanDuyet(driver);
    }
    @Test(dependsOnMethods = "loginTest")
    public void TuChoi(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, ElectricManager.YEU_CAU_DICH_VU);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CUA_TOI);
        // Kiểm tra trạng thái ticket
        String textKiemTra = "Đã chuyển tiếp";
        String getText = driver.findElement(ElectricManager.KIEM_TRA_TRANG_THAI).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.fillInputField(driver, ElectricManager.IN_PUT, MaTicket);
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CHUYEN_NHAN_VIEN);
        XuLyTruongPhongDien.TuChoi(driver);
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
