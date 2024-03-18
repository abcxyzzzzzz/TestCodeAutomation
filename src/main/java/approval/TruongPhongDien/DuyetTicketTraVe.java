package approval.TruongPhongDien;

import locators.ElectricManager;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import utils.TestUtils;

public class DuyetTicketTraVe {
    public static void DuyetTicketTraVe(WebDriver driver)throws InterruptedException{
        TestUtils.clickElement(driver, ElectricManager.TICKET_DUYET_TRA_VE);
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO, "Công việc bạn có thể thực hiện được");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.TICKET_XAC_NHAN).click();
    }
}
