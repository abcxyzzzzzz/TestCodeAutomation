package locators;

import org.openqa.selenium.By;

public class ReceivingRequests {
    public static final By YeuCauDoi = By.xpath("//span[contains(text(),'Yêu cầu chờ tiếp nhận')]");
    public static final By ChonBang = By.xpath("(//td[@data-pin='none'])[1]");
    public static final By TiepNhan = By.xpath("//button[contains(text(),'Tiếp nhận yêu cầu')]");
    public static final By KiemTraTrangThai  = By.xpath("(//td[@data-pin='none'])[7]");
}
