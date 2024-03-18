package approval.NhanVien;

import locators.EmployssLocators;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import utils.TestUtils;

public class TuChoiYeuCau {
    public static void TuChoiYeuCau(WebDriver driver) throws InterruptedException {
        TestUtils.clickElement(driver, PublicLocators.TICKET_CHUYEN_NHAN_VIEN);
        TestUtils.clickElement(driver, EmployssLocators.TU_CHOI_FORM_SUBMIT_NV);
        TestUtils.fillInputField(driver,PublicLocators.GHI_CHU_LY_DO, "Tôi không thể thực hiện yêu cầu này");
        Thread.sleep(2000);
        TestUtils.clickElement(driver,PublicLocators.TICKET_XAC_NHAN);

    }
}
