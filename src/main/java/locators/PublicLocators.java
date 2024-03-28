package locators;

import org.openqa.selenium.By;

public class PublicLocators {
    public static final By TicKetCuaToi = By.xpath("(//a[@data-href='/ticket-runtime/create___/ticket-runtime/detail___/ticket-runtime/update'])[1]");
    public static final By HanhDong = By.xpath("(//td[@data-pin='none'])");
    public static final By XacNhan  = By.xpath("//button[contains(text(),'Xác nhận')]");
    public static final By ChuyenNhanVien = By.xpath("//button[contains(text(),'Hành động')]");
    public static final By CanDuyet = By.xpath("//div[@class='generateActionWF']//button[1]//div[1]");
    public static final By LyDo = By.xpath("//textarea[@placeholder='Nhập Ghi chú / Lý do ...']");
}
