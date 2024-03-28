package ChienDichCSKH;

import locators.CSKHChienDich;
import login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import setup.SetUp;
import utils.TestUtils;

import java.util.concurrent.TimeUnit;

public class TaoThongBaoMoi {

   WebDriver driver;
   WebDriverWait wait;

   @BeforeTest
   public void setup() {
       driver = new ChromeDriver();
       SetUp.setUp(driver);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }

  // @Test
//    public void loginTest() throws InterruptedException {
//        LoginPage.login(driver, "nhanviencskh@qtsc.com.vn", "nhanviencskh");
//    }

   @Test(dependsOnMethods = "loginTest")
   public void createTicketTest() throws InterruptedException {
       TestUtils.clickElement(driver, CSKHChienDich.ChienDich);
       TestUtils.clickElement(driver, CSKHChienDich.ThongBao);
       TestUtils.clickElement(driver, CSKHChienDich.TaoThongBao);
       TestUtils.fillInputField(driver, CSKHChienDich.TenThongBao, "Sửa chữa hệ thống điện trường học");
       TestUtils.fillInputField(driver, CSKHChienDich.MaThongBao, "Sửa chữa hệ thống điện trường học");
       TestUtils.fillInputField(driver, CSKHChienDich.MoTa, "Sửa chữa hệ thống điện trường học");
       TestUtils.selectDropDow(driver, CSKHChienDich.LoaiThongBao, "noti");
       TestUtils.selectDropDow(driver, CSKHChienDich.NoiSuDung, "noti");
       TestUtils.fillInputField(driver, CSKHChienDich.TieuDe, "Chúc mừng sinh nhật");
       TestUtils.fillInputField(driver, CSKHChienDich.NoiDungPopup, "Chúc mừng sinh nhật");
   }

   @AfterTest
   public void tearDown() {
       driver.quit();
   }
}
