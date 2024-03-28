package TruongPhong;

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
    public void chuyenTiepTickket(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, ElectricManager.YCDichVu);
        TestUtils.clickElement(driver, PublicLocators.TicKetCuaToi);
        // Kiểm tra trạng thái ticket
        String textKiemTra = "Đã chuyển tiếp";
        String getText = driver.findElement(ElectricManager.KiemTraTrangThai).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.fillInputField(driver, ElectricManager.Nhap, MaTicket);
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, PublicLocators.HanhDong);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.ChuyenNhanVien);
        TestUtils.clickElement(driver, PublicLocators.CanDuyet);
        TestUtils.selectDropDow(driver, ElectricManager.NhanVienThucHien,"Nhân viên điện");
        TestUtils.fillInputField(driver,PublicLocators.LyDo,"Công việc bạn có thể thực hiện được");
        Thread.sleep(2000);
        TestUtils.clickElement(driver,PublicLocators.XacNhan);
        Thread.sleep(5000);
    }

    @Test(dependsOnMethods = "loginTest")
    public void CHuyenKhongCanDuyet(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, ElectricManager.YCDichVu);
        TestUtils.clickElement(driver, PublicLocators.TicKetCuaToi);
        // Kiểm tra trạng thái ticket
        String textKiemTra = "Đã chuyển tiếp";
        String getText = driver.findElement(ElectricManager.KiemTraTrangThai).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.fillInputField(driver, ElectricManager.Nhap, MaTicket);
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, PublicLocators.HanhDong);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.ChuyenNhanVien);
        TestUtils.clickElement(driver, ElectricManager.KhongCanDuyet);
        TestUtils.selectDropDow(driver,ElectricManager.NhanVienThucHien,"Nhân viên điện" );
        TestUtils.fillInputField(driver, PublicLocators.LyDo,"Công việc bạn có thể thực hiện được");
        Thread.sleep(5000);
        TestUtils.clickElement(driver,PublicLocators.XacNhan);

    }

    @Test(dependsOnMethods = "loginTest")
    public void TuChoi(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, ElectricManager.YCDichVu);
        TestUtils.clickElement(driver, PublicLocators.TicKetCuaToi);
        // Kiểm tra trạng thái ticket
        String textKiemTra = "Đã chuyển tiếp";
        String getText = driver.findElement(ElectricManager.KiemTraTrangThai).getText().trim();
        Assert.assertEquals(getText, textKiemTra);
        TestUtils.fillInputField(driver, ElectricManager.Nhap, MaTicket);
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, PublicLocators.HanhDong);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.ChuyenNhanVien);
        TestUtils.clickElement(driver, ElectricManager.TuChoi);
        TestUtils.fillInputField(driver, PublicLocators.LyDo,"Tôi không có nhân viên nào có thể thực hiện yêu cầu này");
        Thread.sleep(5000);
        TestUtils.clickElement(driver,PublicLocators.XacNhan);
    }

    // Duyệt ticket nhaan viên trả về
    public void duyetTicket(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, ElectricManager.YCDichVu);
        TestUtils.clickElement(driver, PublicLocators.TicKetCuaToi);
        TestUtils.fillInputField(driver, ElectricManager.Nhap, MaTicket);
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, PublicLocators.HanhDong);
        Thread.sleep(2000);
        driver.findElement(PublicLocators.ChuyenNhanVien).click();
        // Xử lý
        TestUtils.clickElement(driver, ElectricManager.DuyetTraVe);
        TestUtils.fillInputField(driver, PublicLocators.LyDo, "Đã xử lý");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.XacNhan).click();
        Thread.sleep(4000);
    }

    public void tuChoiDuyetTicket(WebDriver driver, String MaTicket) throws InterruptedException {
        TestUtils.clickElement(driver, ElectricManager.YCDichVu);
        TestUtils.clickElement(driver, PublicLocators.TicKetCuaToi);
        TestUtils.fillInputField(driver, ElectricManager.Nhap, MaTicket);
        Thread.sleep(2000);
        TestUtils.doubleClickElement(driver, PublicLocators.HanhDong);
        Thread.sleep(2000);
        driver.findElement(PublicLocators.ChuyenNhanVien).click();
        // Xử lý
        TestUtils.clickElement(driver, ElectricManager.TuChoiTraVe);
        TestUtils.fillInputField(driver, PublicLocators.LyDo, "Công việc bạn không thể thực hiện được");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.XacNhan).click();
        Thread.sleep(4000);
    }
}
