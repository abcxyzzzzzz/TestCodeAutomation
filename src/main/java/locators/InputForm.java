package locators;

import org.openqa.selenium.By;

public class InputForm {
    public static final By TenCongTy= By.xpath("//input[@placeholder='Nhập Tên công ty ...']");
    public static final By TenVietTat= By.xpath("//input[@placeholder='Nhập Tên viết tắt ...']");
    public static final By ToaNhaDaiDien= By.xpath("/html/body/div[8]/div/div[1]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div[4]/div/div[1]/div/div[1]/div[2]/input");
    public static final By DiaChiVanPhong= By.xpath("//input[@placeholder='Nhập Địa chỉ văn phòng đại diện ...']");
    public static final By DiaChiTang= By.xpath("//input[@placeholder='Nhập Địa chỉ tầng ...']");
    public static final By DiaChiPhong= By.xpath("//input[@placeholder='Nhập Địa chỉ phòng ...']");
    public static final By Email= By.xpath("//input[@name='enterpriseInfo-email']");
    public static final By SDT= By.xpath("//input[@name='enterpriseInfo-phone']");
    public static final By LoaiDoanhNghiep= By.xpath("/html/body/div[8]/div/div[1]/div/div/div/div[2]/div/div/div[4]/div/div/div/div/div[4]/div/div/div/div[1]/div[2]/input");
    public static final By Dong = By.xpath("//button[contains(text(),'Đóng')]");
    public static final By Luu = By.xpath("//button[contains(text(),'Lưu')]");
}
