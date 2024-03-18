package locators;

import org.openqa.selenium.By;

public class CSKHLocators {
    public static final By TICKET_DUYET_TRA_VE  = By.xpath("//div[contains(text(),'Duyệt')]");
    public static final By TICKET_TU_CHOI_TRA_VE  = By.xpath("//div[contains(text(),'Từ chối')]");
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
}
