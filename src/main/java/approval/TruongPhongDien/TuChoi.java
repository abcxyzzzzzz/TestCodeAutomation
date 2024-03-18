package approval.TruongPhongDien;

import locators.ElectricManager;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import utils.TestUtils;

public class TuChoi {
    public static void TuChoi(WebDriver driver)throws InterruptedException{
        TestUtils.clickElement(driver, ElectricManager.TICKET_TU_CHOI);
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO,"Tôi không có nhân viên nào có thể thực hiện yêu cầu này");
        Thread.sleep(2000);
        TestUtils.clickElement(driver,PublicLocators.TICKET_XAC_NHAN);
    }
}
