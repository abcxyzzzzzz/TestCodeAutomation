package approval.CSKH;

import locators.CSKHLocators;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import utils.TestUtils;

public class Duyet {
    public static void Duyet(WebDriver driver)throws InterruptedException{
        driver.findElement(CSKHLocators.TICKET_DUYET_TRA_VE).click();
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO, "Duyệt");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.TICKET_XAC_NHAN).click();
    }
}
