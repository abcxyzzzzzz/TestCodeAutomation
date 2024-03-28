package locators;

import org.openqa.selenium.By;

public class CSKHLocators {
    public static final By DuyetTraVe  = By.xpath("//div[contains(text(),'Duyệt')]");
    public static final By TuChoiTraVe  = By.xpath("//div[contains(text(),'Từ chối')]");
    public static final By QuanLy = By.xpath("//a[@href='/ticket-manager']");
    public static final By DanhSachYC = By.xpath("//span[contains(text(),'Danh sách yêu cầu')]");
    public static final By TaoYC = By.xpath("//button[contains(text(),'Tạo mới Yêu cầu')]");
    public static final By PhongBan = By.xpath("//input[@id='react-select-11-input']");
    public static final By BoPhan = By.xpath("//input[@id='react-select-12-input']");
    public static final By YCDichVu = By.xpath("//input[@id='react-select-13-input']");
    public static final By TaoTicket = By.xpath("//button[normalize-space()='Thêm Ticket']");
    public static final By LuuTicket = By.xpath("//button[contains(text(),'Lưu và Chuyển tiếp tới Phòng ban/Bộ phận')]");
    public static final By PhanLoaiTicket = By.xpath("//input[@id='react-select-10-input']");

    public static final By NoiDungGhiChu = By.xpath("//textarea[@placeholder='Nhập Agent ghi chú ...']");
    public static final By NoiDungTicket = By.xpath("//textarea[@placeholder='Nhập Nội dung ...']");
    public static final By MucDoTicket = By.xpath("//input[@id='react-select-9-input']");
    
    public static final By TicketCuaToi = By.xpath("//a[@data-href='/ticket-runtime/create___/ticket-runtime/detail___/ticket-runtime/update']");
    public static final By TenCongTy = By.xpath("(//td[@data-pin='none'])[1]");
    public static final By DuLieuBang = By.xpath("(//tr)[16]");
    public static final By TimKiem = By.xpath("//button[@class='btn-label btn btn-info btn-sm']");
    public static final By TiepNhanTraVe = By.xpath("//div[contains(text(),'Tiếp nhận')]");
    public static final By ChonDuLieuBang = By.xpath("(//td[@data-pin='none'])[7]");
    public static final By NguoiLienHeTaoTicket = By.xpath("(//input[contains(@placeholder,'...')])[10]");
    public static final By TimKiemNoiDung = By.xpath("(//input[contains(@placeholder,'...')])[3]");
    public static final By KiemTraND = By.xpath("(//div[@class='d-flex'])[14]");
    public static final By KiemTraTruongPhong = By.xpath("/html/body/div[4]/div/div[1]/div/div/div/div[2]/div/div/div[3]/div/div/div/div[1]/div[4]/div/div[1]/div/div[1]/div[2]");
    public static final By KiemTraBoPhan = By.xpath("//div[5]//div[1]//div[1]//div[1]//div[1]//div[2]");
}
