package locators;

import org.openqa.selenium.By;

public class ElectricManager {
    public static final By YEU_CAU_DICH_VU = By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/ul/li[3]/a");
    public static final By TICKET_KHONG_CAN_DUYET = By.xpath("//div[contains(text(),'Xử lý cần không cần duyệt')]");
    public static final By TICKET_TU_CHOI = By.xpath("//div[contains(text(),'Từ chối tiếp nhận')]");
    public static final By TEN_NHAN_VIEN_THUC_HIEN = By.xpath("//input[@id='react-select-32-input']");
    public static final By TICKET_DUYET_TRA_VE  = By.xpath("//div[contains(text(),'Duyệt')]");
    public static final By TICKET_TU_CHOI_TRA_VE  = By.xpath("//div[contains(text(),'Từ chối')]");
    public static final By KIEM_TRA_TRANG_THAI  = By.xpath("(//td[@data-pin='none'])[9]");
}
