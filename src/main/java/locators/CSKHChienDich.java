package locators;

import org.openqa.selenium.By;

public class CSKHChienDich {
    public static final By ChienDich = By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/ul/li[9]/a");
    public static final By ThongBao = By.xpath("//span[contains(text(),'Danh sách mẫu thông báo')]");
    public static final By TaoThongBao = By.xpath("//button[contains(text(),'Tạo mới mẫu thông báo')]");
    public static final By TenThongBao = By.xpath("//input[@placeholder='Nhập Tên mẫu thông báo ...']");
    public static final By MaThongBao = By.xpath("//input[@placeholder='Nhập Mã mẫu thông báo ...']");
    public static final By MoTa = By.xpath("//input[@placeholder='Nhập Mô tả ...']");
    public static final By LoaiThongBao = By.xpath("/html/body/div[4]/div/div[1]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/input");
    public static final By NoiSuDung = By.xpath("/html/body/div[4]/div/div[1]/div/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[1]/div[2]/input");
    public static final By TieuDe = By.xpath("//input[@placeholder='Nhập Tiêu đề ...']");
    public static final By NoiDungPopup = By.xpath("//input[@placeholder='Nhập Nội dung Popup ...']");
}
