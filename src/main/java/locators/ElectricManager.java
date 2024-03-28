package locators;

import org.openqa.selenium.By;

public class ElectricManager {
    public static final By YCDichVu = By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/ul/li[3]/a");
    public static final By KhongCanDuyet = By.xpath("//div[contains(text(),'Xử lý cần không cần duyệt')]");
    public static final By TuChoi = By.xpath("//div[contains(text(),'Từ chối tiếp nhận')]");
    public static final By NhanVienThucHien = By.xpath("//input[@id='react-select-32-input']");
    public static final By DuyetTraVe  = By.xpath("//div[contains(text(),'Duyệt')]");
    public static final By TuChoiTraVe  = By.xpath("(//button[@role='menuitem'])[24]");
    public static final By KiemTraTrangThai  = By.xpath("(//td[@data-pin='none'])[9]");
    public static final By Nhap  = By.xpath("(//input[contains(@placeholder,'...')])[2]");
}
