package approval.CSKH;

import locators.CSKHLocators;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import utils.TestUtils;

public class Duyet_TuCHoiTicKetTraVe {
    public static void Duyet(WebDriver driver)throws InterruptedException{
        TestUtils.doubleClickElement(driver, PublicLocators.HanhDong);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.ChuyenNhanVien);
        TestUtils.clickElement(driver, CSKHLocators.DuyetTraVe);
        Thread.sleep(1000);
        TestUtils.fillInputField(driver, PublicLocators.LyDo, "Duyệt");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.XacNhan).click();
    }
    public static void TuChoi(WebDriver driver)throws InterruptedException{
        TestUtils.doubleClickElement(driver, PublicLocators.HanhDong);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.ChuyenNhanVien);
        TestUtils.clickElement(driver, CSKHLocators.TuChoiTraVe);
        Thread.sleep(1000);
        TestUtils.fillInputField(driver, PublicLocators.LyDo, "Từ chối");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.XacNhan).click();
    }
}
