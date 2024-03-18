package locators;

import org.openqa.selenium.By;

public class CSKHChienDich {
    public static final By NG_CHIEN_DICH = By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/ul/li[9]/a");
    public static final By NG_DS_THONG_BAO = By.xpath("//span[contains(text(),'Danh sách mẫu thông báo')]");
    public static final By BUTTON_CREATE_NOTIFICATION = By.xpath("//button[contains(text(),'Tạo mới mẫu thông báo')]");
    public static final By NAME_NOTIFI = By.xpath("//input[@placeholder='Nhập Tên mẫu thông báo ...']");
    public static final By MA_NOTIFI = By.xpath("//input[@placeholder='Nhập Mã mẫu thông báo ...']");
    public static final By MO_TA = By.xpath("//input[@placeholder='Nhập Mô tả ...']");
    public static final By LOAI_THONG_BAO = By.xpath("/html/body/div[4]/div/div[1]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/input");
    public static final By NOI_SU_DUNG = By.xpath("/html/body/div[4]/div/div[1]/div/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[1]/div[2]/input");
    public static final By TIEU_DE = By.xpath("//input[@placeholder='Nhập Tiêu đề ...']");
    public static final By NOI_DUNG_POPUP = By.xpath("//input[@placeholder='Nhập Nội dung Popup ...']");
}
