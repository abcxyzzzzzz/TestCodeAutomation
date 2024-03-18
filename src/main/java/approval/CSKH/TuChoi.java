package approval.CSKH;

import locators.CSKHLocators;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import utils.TestUtils;

public class TuChoi {
    public void TuChoi(WebDriver driver)throws InterruptedException{
        driver.findElement(CSKHLocators.TICKET_TU_CHOI_TRA_VE).click();
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO, "Từ chối");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.TICKET_XAC_NHAN).click();
    }
}
