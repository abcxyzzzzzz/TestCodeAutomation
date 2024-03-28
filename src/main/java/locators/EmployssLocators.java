package locators;

import org.openqa.selenium.By;

public class EmployssLocators {
    public static final By YeuCauDV  = By.xpath("//li[4]");
    public static final By TuChoi  = By.xpath("//div[contains(text(),'Từ chối')]");
    public static final By TruocXuLy  = By.xpath("//textarea[@placeholder='Nhập Ghi chú ...']");
    public static final By UpdateTruocXuLy  = By.xpath("//button[contains(text(),'Cập nhật kết quả trước khi xử lý')]");
    public static final By SauXuLy  = By.xpath("//textarea[@name='noteAfter']");
    public static final By UpdateSauXuLy  = By.xpath("//button[contains(text(),'Cập nhật kết quả sau khi xử lý')]");
    public static final By KhongTheXuLy  = By.xpath("//div[contains(text(),'Không thể xử lý')]");
    public static final By CoTheXuLy  = By.xpath("//div[contains(text(),'Xử lý thành công')]");
}
