package locators;

import org.openqa.selenium.By;

public class InputForm {
    public static final By INPUT_TEN_CONG_TY= By.xpath("//input[@placeholder='Nhập Tên công ty ...']");
    public static final By INPUT_TEN_VIET_TAT= By.xpath("//input[@placeholder='Nhập Tên viết tắt ...']");
    public static final By INPUT_TOA_NHA_DAI_DIEN= By.xpath("/html/body/div[8]/div/div[1]/div/div/div/div[2]/div/div/div[1]/div/div/div/div/div[4]/div/div[1]/div/div[1]/div[2]/input");
    public static final By INPUT_DIA_CHI_VAN_PHONG= By.xpath("//input[@placeholder='Nhập Địa chỉ văn phòng đại diện ...']");
    public static final By INPUT_DIA_CHI_TANG= By.xpath("//input[@placeholder='Nhập Địa chỉ tầng ...']");
    public static final By INPUT_DIA_CHI_PHONG= By.xpath("//input[@placeholder='Nhập Địa chỉ phòng ...']");
    public static final By INPUT_EMAIL= By.xpath("//input[@name='enterpriseInfo-email']");
    public static final By INPUT_SDT= By.xpath("//input[@name='enterpriseInfo-phone']");
    public static final By INPUT_LOAI_DOANH_NGHEP= By.xpath("/html/body/div[8]/div/div[1]/div/div/div/div[2]/div/div/div[4]/div/div/div/div/div[4]/div/div/div/div[1]/div[2]/input");
    public static final By BUTTON_CLOSE = By.xpath("//button[contains(text(),'Đóng')]");
    public static final By BUTTON_SAVE = By.xpath("//button[contains(text(),'Lưu')]");
}
