package approval.NhanVien;

import locators.EmployssLocators;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import utils.TestUtils;

public class DongYYeuCau {
    public static void DongYYeuCau(WebDriver driver) throws InterruptedException {
        TestUtils.clickElement(driver, PublicLocators.TICKET_CAN_DUYET);
        TestUtils.fillInputField(driver,PublicLocators.GHI_CHU_LY_DO,"Tôi có thể thực hiện yêu cầu này");
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.TICKET_XAC_NHAN);
        Thread.sleep(5000);
        TestUtils.fillInputField(driver, EmployssLocators.TRUOC_XU_LY, "Kết quả trước khi thực hiện hành động");
        TestUtils.clickElement(driver, EmployssLocators.UPDATE_KQ_TRUOC_XU_LY);
        Thread.sleep(1000);
        TestUtils.fillInputField(driver,EmployssLocators.SAU_XU_LY,"Kết quả sau khi thực hiện hành động");
        Thread.sleep(1000);
        TestUtils.clickElement(driver, EmployssLocators.UPDATE_KQ_SAU_XU_LY);
        Thread.sleep(4000);

        int thucHien = 1;
        switch (thucHien) {
            case 1:
                TestUtils.clickElement(driver,PublicLocators.TICKET_CHUYEN_NHAN_VIEN);
                TestUtils.clickElement(driver,EmployssLocators.CO_THE_XU_LY);
                TestUtils.fillInputField(driver,PublicLocators.GHI_CHU_LY_DO,"Tôi đã thực hiện yêu cầu này");
                TestUtils.clickElement(driver,PublicLocators.TICKET_XAC_NHAN);
                Thread.sleep(1000);
                break;

            case 2:
                TestUtils.clickElement(driver,PublicLocators.TICKET_CHUYEN_NHAN_VIEN);
                TestUtils.clickElement(driver,EmployssLocators.KHONG_THE_XU_LY);
                TestUtils.fillInputField(driver,PublicLocators.GHI_CHU_LY_DO,"Tôi không thể thực hiện yêu cầu này");
                TestUtils.clickElement(driver,PublicLocators.TICKET_XAC_NHAN);
                Thread.sleep(1000);
                break;
        }
    }
}
