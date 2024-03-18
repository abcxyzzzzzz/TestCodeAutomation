package locators;

import org.openqa.selenium.By;

public class EmployssLocators {
    public static final By YEU_CAU_DV_NV  = By.xpath("//li[4]");
    public static final By TU_CHOI_FORM_SUBMIT_NV  = By.xpath("//div[contains(text(),'Từ chối')]");
    public static final By TRUOC_XU_LY  = By.xpath("//textarea[@placeholder='Nhập Ghi chú ...']");
    public static final By UPDATE_KQ_TRUOC_XU_LY  = By.xpath("//button[contains(text(),'Cập nhật kết quả trước khi xử lý')]");
    public static final By SAU_XU_LY  = By.xpath("//textarea[@name='noteAfter']");
    public static final By UPDATE_KQ_SAU_XU_LY  = By.xpath("//button[contains(text(),'Cập nhật kết quả sau khi xử lý')]");
    public static final By KHONG_THE_XU_LY  = By.xpath("//div[contains(text(),'Không thể xử lý')]");
    public static final By CO_THE_XU_LY  = By.xpath("//div[contains(text(),'Xử lý thành công')]");
}
