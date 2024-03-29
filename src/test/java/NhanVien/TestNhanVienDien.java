package NhanVien;

import locators.ElectricManager;
import locators.EmployssLocators;
import approval.NhanVien.NhanVienTiepNhanYeuCau;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.TestUtils;

import java.awt.*;

public class TestNhanVienDien {
    public void NhanVienTiepNhan(WebDriver driver,int thuchien, String MaTicket) throws InterruptedException, AWTException {
        TestUtils.clickElement(driver, EmployssLocators.YeuCauDV);
        TestUtils.clickElement(driver, PublicLocators.TicKetCuaToi);
        TestUtils.fillInputField(driver, ElectricManager.Nhap, MaTicket);
        Thread.sleep(2000);
        String textKiemTra = "Chờ triển khai";
        String getText = driver.findElement(EmployssLocators.KiemTraTrangThai).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.doubleClickElement(driver, PublicLocators.HanhDong);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.ChuyenNhanVien);

        NhanVienTiepNhanYeuCau.DongYYeuCau(driver,thuchien);
    }
    public void tuChoiTicket(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, EmployssLocators.YeuCauDV);
        TestUtils.clickElement(driver, PublicLocators.TicKetCuaToi);
        TestUtils.fillInputField(driver, ElectricManager.Nhap, MaTicket);
        Thread.sleep(2000);
        String textKiemTra = "Chờ triển khai";
        String getText = driver.findElement(EmployssLocators.KiemTraTrangThai).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.doubleClickElement(driver, PublicLocators.HanhDong);
        Thread.sleep(2000);
        NhanVienTiepNhanYeuCau.TuChoiYeuCau(driver);
    }
    public void NhanVienTiepNhantest(WebDriver driver,int thuchien, String MaTicket) throws InterruptedException, AWTException {
        TestUtils.clickElement(driver, EmployssLocators.YeuCauDV);
        TestUtils.clickElement(driver, PublicLocators.TicKetCuaToi);
        TestUtils.fillInputField(driver, ElectricManager.Nhap, MaTicket);
        Thread.sleep(2000);
        String textKiemTra = "Chờ triển khai";
        String getText = driver.findElement(EmployssLocators.KiemTraTrangThai).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.doubleClickElement(driver, PublicLocators.HanhDong);
        Thread.sleep(2000);
        NhanVienTiepNhanYeuCau.dongy(driver,thuchien);
    }
}
