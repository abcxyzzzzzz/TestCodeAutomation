package approval.CSKH;

import locators.CSKHLocators;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import utils.TestUtils;

public class TiepNhanTicketTuChoi {
    public static void TiepNhanTicketTuChoi(WebDriver driver)throws InterruptedException{
        driver.findElement(CSKHLocators.TiepNhanTraVe).click();
        TestUtils.fillInputField(driver, PublicLocators.LyDo, "Từ chối");
        Thread.sleep(2000);
        driver.findElement(PublicLocators.XacNhan).click();
    }
}
