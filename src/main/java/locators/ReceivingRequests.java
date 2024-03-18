package locators;

import org.openqa.selenium.By;

public class ReceivingRequests {
    public static final By YEU_CAU_CHO_TIEP_NHAN = By.xpath("//span[contains(text(),'Yêu cầu chờ tiếp nhận')]");
    public static final By CLICK_DATA_TABLE = By.xpath("(//td[@data-pin='none'])[1]");
    public static final By TIEP_NHAN_YEU_CAU = By.xpath("//button[contains(text(),'Tiếp nhận yêu cầu')]");
    public static final By KIEM_TRA_TRANG_THAI_YEU_CAU  = By.xpath("(//td[@data-pin='none'])[7]");
}
