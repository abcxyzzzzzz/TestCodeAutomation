package locators;

import org.openqa.selenium.By;

public class PublicLocators {
    public static final By TICKET_CUA_TOI = By.xpath("(//a[@data-href='/ticket-runtime/create___/ticket-runtime/detail___/ticket-runtime/update'])[1]");
    public static final By TICKET_HANH_DONG = By.xpath("(//td[@data-pin='none'])");
    public static final By TICKET_XAC_NHAN  = By.xpath("//button[contains(text(),'Xác nhận')]");
    public static final By TICKET_CHUYEN_NHAN_VIEN = By.xpath("//button[contains(text(),'Hành động')]");
    public static final By TICKET_CAN_DUYET = By.xpath("//div[@class='generateActionWF']//button[1]//div[1]");
    public static final By GHI_CHU_LY_DO = By.xpath("//textarea[@placeholder='Nhập Ghi chú / Lý do ...']");
}
