package TruongPhong;

import io.github.bonigarcia.wdm.WebDriverManager;
import locators.PageLocators;
import login.LoginPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.TestUtils;

import java.util.concurrent.TimeUnit;


public class TestTruongPhongDien {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver.manage().window().maximize();
        driver.get("https://crm-dev.lsat.vn/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() throws InterruptedException {
        loginPage.login("truongphongdien@qtsc.com.vn", "truongphongdien");
        Thread.sleep(5000);

    }

    @Test(dependsOnMethods = "loginTest")
    public void chuyenTiepTickket() throws InterruptedException {
        TestUtils.clickElement(driver, PageLocators.YEU_CAU_DICH_VU);
        TestUtils.clickElement(driver, PageLocators.TICKET_CUA_TOI);

        //Kiểm tra trạng thái ticket
        String textKiemTra = "Đã chuyển tiếp";
        String getText = driver.findElement(PageLocators.KIEM_TRA_TRANG_THAI).getText().trim();
        Assert.assertEquals(getText, textKiemTra);

        TestUtils.doubleClickElement(driver, PageLocators.TICKET_HANH_DONG);
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PageLocators.TICKET_CHUYEN_NHAN_VIEN);

        int numChuyenTiep = 1;
        switch (numChuyenTiep) {
            case 1:
                coTheXuLy();
                break;
            case 2:
                khongTheXuLy();
                break;
            case 3:
                tuChoi();
                break;
        }
        Thread.sleep(4000);
    }
    public void coTheXuLy()throws InterruptedException{
        TestUtils.clickElement(driver,PageLocators.TICKET_CAN_DUYET);
        TestUtils.selectDropDow(driver,PageLocators.TEN_NHAN_VIEN_THUC_HIEN,"Nhân viên điện");
                TestUtils.fillInputField(driver,PageLocators.GHI_CHU_LY_DO,"Công việc bạn có thể thực hiện được");
                        Thread.sleep(2000);
        TestUtils.clickElement(driver,PageLocators.TICKET_XAC_NHAN);
    }
    
    public void khongTheXuLy()throws InterruptedException{
        TestUtils.clickElement(driver,PageLocators.TICKET_KHONG_CAN_DUYET);
        TestUtils.selectDropDow(driver,PageLocators.TEN_NHAN_VIEN_THUC_HIEN,"Nhân viên điện" );
        TestUtils.fillInputField(driver,PageLocators.GHI_CHU_LY_DO,"Công việc bạn có thể thực hiện được");
        Thread.sleep(2000);
        TestUtils.clickElement(driver,PageLocators.TICKET_XAC_NHAN);

    }
    
    public void tuChoi()throws InterruptedException{
        TestUtils.clickElement(driver,PageLocators.TICKET_TU_CHOI);
        TestUtils.fillInputField(driver,PageLocators.GHI_CHU_LY_DO,"Tôi không có nhân viên nào có thể thực hiện yêu cầu này");
        Thread.sleep(2000);
        TestUtils.clickElement(driver,PageLocators.TICKET_XAC_NHAN);
    }
    
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
