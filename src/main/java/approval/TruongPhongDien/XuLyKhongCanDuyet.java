package approval.TruongPhongDien;

import locators.ElectricManager;
import locators.PublicLocators;
import org.openqa.selenium.WebDriver;
import utils.TestUtils;

public class XuLyKhongCanDuyet {
    public static void XuKhongLyCanDuyet(WebDriver driver)throws InterruptedException{
        TestUtils.clickElement(driver, ElectricManager.TICKET_KHONG_CAN_DUYET);
        TestUtils.selectDropDow(driver,ElectricManager.TEN_NHAN_VIEN_THUC_HIEN,"Nhân viên điện" );
        TestUtils.fillInputField(driver, PublicLocators.GHI_CHU_LY_DO,"Công việc bạn có thể thực hiện được");
        Thread.sleep(2000);
        TestUtils.clickElement(driver,PublicLocators.TICKET_XAC_NHAN);

    }
}
