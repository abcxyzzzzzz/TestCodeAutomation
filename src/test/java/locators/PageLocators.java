package locators;

import org.openqa.selenium.By;

public class PageLocators {

    //Public Locators 
    public static final By TICKET_CUA_TOI = By.xpath("(//a[@data-href='/ticket-runtime/create___/ticket-runtime/detail___/ticket-runtime/update'])[1]");
    public static final By TICKET_HANH_DONG = By.xpath("(//td[@data-pin='none'])");
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
    public static final By SELECT_REQUEST_SERVICE = By.xpath("//input[@id='react-select-13-input']");
    public static final By CREATE_TICKET_BUTTON = By.xpath("//button[normalize-space()='Thêm Ticket']");
    public static final By SAVE_FORWARD_BUTTON = By.xpath("//button[contains(text(),'Lưu và Chuyển tiếp tới Phòng ban/Bộ phận')]");
    public static final By CATEGORIES_SELECT = By.xpath("//input[@id='react-select-10-input']");
    public static final By PRIORITY_SELECT = By.xpath("//input[@id='react-select-9-input']");
    public static final By AGENT_NOTE_FIELD = By.xpath("//textarea[@placeholder='Nhập Agent ghi chú ...']");
    public static final By TICKET_CONTENT_FIELD = By.xpath("//textarea[@placeholder='Nhập Nội dung ...']");
    public static final By TICKET_CUA_TOI_CSKH = By.xpath("//a[@data-href='/ticket-runtime/create___/ticket-runtime/detail___/ticket-runtime/update']");
    public static final By DATA_TEN_CONG_TY = By.xpath("(//td[@data-pin='none'])[1]");
    public static final By DATA_BANG = By.xpath("(//tr)[16]");
    public static final By TIM_KIEM = By.xpath("//button[@class='btn-label btn btn-info btn-sm']");


    //Tiếp nhận yêu cầu từ các nguông
    public static final By YEU_CAU_CHO_TIEP_NHAN = By.xpath("//span[contains(text(),'Yêu cầu chờ tiếp nhận')]");
    public static final By CLICK_DATA_TABLE = By.xpath("(//td[@data-pin='none'])[1]");
    public static final By TIEP_NHAN_YEU_CAU = By.xpath("//button[contains(text(),'Tiếp nhận yêu cầu')]");
    public static final By KIEM_TRA_TRANG_THAI_YEU_CAU  = By.xpath("(//td[@data-pin='none'])[7]");




    //Trưởng phòng điện
    public static final By YEU_CAU_DICH_VU = By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/ul/li[3]/a");
    public static final By TICKET_KHONG_CAN_DUYET = By.xpath("//div[contains(text(),'Xử lý cần không cần duyệt')]");
    public static final By TICKET_TU_CHOI = By.xpath("//div[contains(text(),'Từ chối tiếp nhận')]");
    public static final By TEN_NHAN_VIEN_THUC_HIEN = By.xpath("//input[@id='react-select-32-input']");
    public static final By TICKET_DUYET_TRA_VE  = By.xpath("//div[contains(text(),'Duyệt')]");
    public static final By TICKET_TU_CHOI_TRA_VE  = By.xpath("//div[contains(text(),'Từ chối')]");
    public static final By KIEM_TRA_TRANG_THAI  = By.xpath("(//td[@data-pin='none'])[9]");


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


    //Quản lý khách hàng
    public static final By QLKH  = By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/ul/li[5]/a");
    public static final By QLCT  = By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/ul/li[5]/ul/li[1]");
    public static final By TAO_MOI_CONG_TY = By.xpath("//button[contains(text(),'Tạo mới Công ty')]");


    //InputForm
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




    //Chiến dịch CSKH
    public static final By NG_CHIEN_DICH = By.xpath("/html/body/div[1]/div[6]/div[1]/div[2]/div/div[1]/div[2]/div/div/div/div/ul/li[9]/a");
    public static final By NG_DS_THONG_BAO = By.xpath("//span[contains(text(),'Danh sách mẫu thông báo')]");
    public static final By BUTTON_CREATE_NOTIFICATION = By.xpath("//button[contains(text(),'Tạo mới mẫu thông báo')]");
    public static final By NAME_NOTIFI = By.xpath("//input[@placeholder='Nhập Tên mẫu thông báo ...']");
    public static final By MA_NOTIFI = By.xpath("//input[@placeholder='Nhập Mã mẫu thông báo ...']");
    public static final By MO_TA = By.xpath("//input[@placeholder='Nhập Mô tả ...']");
    public static final By LOAI_THONG_BAO = By.xpath("/html/body/div[4]/div/div[1]/div/div/div[2]/div[2]/div[1]/div/div[1]/div[1]/div[1]/div[2]/input");
    public static final By NOI_SU_DUNG = By.xpath("/html/body/div[4]/div/div[1]/div/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[1]/div[2]/input");
    public static final By TIEU_DE = By.xpath("//input[@placeholder='Nhập Tiêu đề ...']");
    public static final By NOI_DUNG_POPUP = By.xpath("//input[@placeholder='Nhập Nội dung Popup ...']");




}
