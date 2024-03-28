package locators;

import org.openqa.selenium.By;

public class CustomerManagement {
    public static final By QuanLyKhachHang  = By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/ul/li[5]/a");
    public static final By QuanLyCongTy  = By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/ul/li[5]/ul/li[1]");
    public static final By TaoMoi = By.xpath("//button[contains(text(),'Tạo mới Công ty')]");
}
