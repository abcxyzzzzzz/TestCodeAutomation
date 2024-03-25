//package ChienDichCSKH;
//
//import locators.CSKHChienDich;
//import login.LoginPage;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import setup.SetUp;
//import utils.TestUtils;
//
//import java.util.concurrent.TimeUnit;
//
//public class TaoThongBaoMoi {
//
//    WebDriver driver;
//    WebDriverWait wait;
//
//    @BeforeTest
//    public void setup() {
//        driver = new ChromeDriver();
//        SetUp.setUp(driver);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//    }
//
//    @Test
//    public void loginTest() throws InterruptedException {
//        LoginPage.login(driver, "nhanviencskh@qtsc.com.vn", "nhanviencskh");
//    }
//
//    @Test(dependsOnMethods = "loginTest")
//    public void createTicketTest() throws InterruptedException {
//        TestUtils.clickElement(driver, CSKHChienDich.NG_CHIEN_DICH);
//        TestUtils.clickElement(driver, CSKHChienDich.NG_DS_THONG_BAO);
//        TestUtils.clickElement(driver, CSKHChienDich.BUTTON_CREATE_NOTIFICATION);
//        TestUtils.fillInputField(driver, CSKHChienDich.NAME_NOTIFI, "Sửa chữa hệ thống điện trường học");
//        TestUtils.fillInputField(driver, CSKHChienDich.MA_NOTIFI, "Sửa chữa hệ thống điện trường học");
//        TestUtils.fillInputField(driver, CSKHChienDich.MO_TA, "Sửa chữa hệ thống điện trường học");
//        TestUtils.selectDropDow(driver, CSKHChienDich.LOAI_THONG_BAO, "noti");
//        TestUtils.selectDropDow(driver, CSKHChienDich.NOI_SU_DUNG, "noti");
//        TestUtils.fillInputField(driver, CSKHChienDich.TIEU_DE, "Chúc mừng sinh nhật");
//        TestUtils.fillInputField(driver, CSKHChienDich.NOI_DUNG_POPUP, "Chúc mừng sinh nhật");
//    }
//
//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }
//}
