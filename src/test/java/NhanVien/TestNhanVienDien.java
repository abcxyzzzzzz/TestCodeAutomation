package NhanVien;

import approval.NhanVien.TuChoiYeuCau;
import locators.ElectricManager;
import locators.EmployssLocators;
import approval.NhanVien.NhanVienTiepNhanYeuCau;
import locators.PublicLocators;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestUtils;
import setup.SetUp;

import java.util.concurrent.TimeUnit;

public class TestNhanVienDien {
    public void NhanVienTiepNhan(WebDriver driver,int thuchien, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, EmployssLocators.YEU_CAU_DV_NV);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CUA_TOI);
        TestUtils.fillInputField(driver, ElectricManager.IN_PUT, MaTicket);
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CHUYEN_NHAN_VIEN);
        NhanVienTiepNhanYeuCau.DongYYeuCau(driver,thuchien);
    }
    public void tuChoiTicket(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, EmployssLocators.YEU_CAU_DV_NV);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CUA_TOI);
        TestUtils.fillInputField(driver, ElectricManager.IN_PUT, MaTicket);
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        Thread.sleep(2000);
        NhanVienTiepNhanYeuCau.TuChoiYeuCau(driver);
    }
}
