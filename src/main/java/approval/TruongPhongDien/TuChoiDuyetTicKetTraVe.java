package TruongPhong;

import locators.ElectricManager;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import utils.TestUtils;

public class NotApprovalTicket {
    public static void NotApprovalTicket(WebDriver driver)throws InterruptedException{
        driver.findElement(ElectricManager.TICKET_TU_CHOI_TRA_VE).click();
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO, "Công việc bạn không thể thực hiện được");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.TICKET_XAC_NHAN).click();
    }
}
