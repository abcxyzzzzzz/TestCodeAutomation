package approval.CSKH;

import locators.CSKHLocators;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import utils.TestUtils;

public class Duyet_TuCHoiTicKetTraVe {
    public static void Duyet(WebDriver driver)throws InterruptedException{
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CHUYEN_NHAN_VIEN);
        TestUtils.clickElement(driver, CSKHLocators.TICKET_DUYET_TRA_VE);
        Thread.sleep(1000);
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO, "Duyệt");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.TICKET_XAC_NHAN).click();
    }
    public static void TuChoi(WebDriver driver)throws InterruptedException{
        TestUtils.doubleClickElement(driver, PublicLocators.TICKET_HANH_DONG);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.TICKET_CHUYEN_NHAN_VIEN);
        TestUtils.clickElement(driver, CSKHLocators.TICKET_TU_CHOI_TRA_VE);
        Thread.sleep(1000);
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO, "Từ chối");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.TICKET_XAC_NHAN).click();
    }
}
