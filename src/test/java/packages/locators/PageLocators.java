package packages.locators;

import org.openqa.selenium.By;

public class PageLocators {

    //Public Locators 
    public static final By TICKET_CUA_TOI = By.xpath("(//a[@data-href='/ticket-runtime/create___/ticket-runtime/detail___/ticket-runtime/update'])[1]");
    public static final By TICKET_HANH_DONG = By.xpath("(//td[@data-pin='none'])[2]");
    public static final By TICKET_XAC_NHAN  = By.xpath("//button[contains(text(),'Xác nhận')]");
    public static final By TICKET_CHUYEN_NHAN_VIEN = By.xpath("//button[contains(text(),'Hành động')]"); 
    public static final By TICKET_CAN_DUYET = By.xpath("//div[@class='generateActionWF']//button[1]//div[1]");
    public static final By GHI_CHU_LY_DO = By.xpath("//textarea[@placeholder='Nhập Ghi chú / Lý do ...']");

    //Chăm sóc khách hàng
    public static final By TICKET_MANAGER_LINK = By.xpath("//a[@href='/ticket-manager']");
    public static final By REQUEST_LIST = By.xpath("//span[contains(text(),'Danh sách yêu cầu')]");
    public static final By CREATE_NEW_REQUEST = By.xpath("//button[contains(text(),'Tạo mới Yêu cầu')]");
    public static final By SELECT_DEPARTMENT = By.xpath("//input[@id='react-select-11-input']");
    public static final By SELECT_DIVISION = By.xpath("//input[@id='react-select-12-input']"); 
    public static final By SELECT_REQUEST_SERVICE = By.xpath("//input[@id='react-select-12-input']");
    public static final By CREATE_TICKET_BUTTON = By.xpath("//button[normalize-space()='Thêm Ticket']");
    public static final By SAVE_FORWARD_BUTTON = By.xpath("//button[contains(text(),'Lưu và Chuyển tiếp tới Phòng ban/Bộ phận')]");
    public static final By CATEGORIES_SELECT = By.xpath("//input[@id='react-select-10-input']");
    public static final By PRIORITY_SELECT = By.xpath("//input[@id='react-select-9-input']");
    public static final By AGENT_NOTE_FIELD = By.xpath("//textarea[@placeholder='Nhập Agent ghi chú ...']");
    public static final By TICKET_CONTENT_FIELD = By.xpath("//textarea[@placeholder='Nhập Nội dung ...']");

    //Trưởng phòng điện
    public static final By YEU_CAU_DICH_VU = By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/ul/li[3]/a");
    public static final By TICKET_KHONG_CAN_DUYET = By.xpath("//div[contains(text(),'Xử lý cần không cần duyệt')]");
    public static final By TICKET_TU_CHOI = By.xpath("//div[contains(text(),'Từ chối tiếp nhận')]");
    public static final By TEN_NHAN_VIEN_THUC_HIEN = By.xpath("//input[@id='react-select-32-input']");
    public static final By TICKET_DUYET_TRA_VE  = By.xpath("//div[contains(text(),'Duyệt')]");
    public static final By TICKET_TU_CHOI_TRA_VE  = By.xpath("//div[contains(text(),'Từ chối')]");


    //NhanVien
    public static final By YEU_CAU_DV_NV  = By.xpath("//li[4]");
    public static final By TU_CHOI_FORM_SUBMIT_NV  = By.xpath("//div[contains(text(),'Từ chối')]");
    public static final By TRUOC_XU_LY  = By.xpath("//textarea[@placeholder='Nhập Ghi chú ...']");
    public static final By UPDATE_KQ_TRUOC_XU_LY  = By.xpath("//button[contains(text(),'Cập nhật kết quả trước khi xử lý')]");
    public static final By SAU_XU_LY  = By.xpath("//textarea[@name='noteAfter']");
    public static final By UPDATE_KQ_SAU_XU_LY  = By.xpath("//button[contains(text(),'Cập nhật kết quả sau khi xử lý')]");
    public static final By KHONG_THE_XU_LY  = By.xpath("//div[contains(text(),'Không thể xử lý')]");
    public static final By CO_THE_XU_LY  = By.xpath("//div[contains(text(),'Xử lý thành công')]");
    public static final By HANH_DONG_THUC_HIEN  = By.xpath("//div[@id='Send-Browsing']");
}
