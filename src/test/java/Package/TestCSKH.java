
package Package;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class TestCSKH {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    @BeforeTest
    public void Test() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        driver.manage().window().maximize();
        driver.get("https://crm-dev.lsat.vn/dashboard");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void login() throws InterruptedException {
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(" nhanviencskh@qtsc.com.vn");
        driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']")).sendKeys(" nhanviencskh");
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Thread.sleep(10000);
    }
    @Test
    public void testDV() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/ticket-manager']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Danh sách yêu cầu')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Tạo mới Yêu cầu')]")).click();
        Thread.sleep(1000);
        driver.navigate().refresh();
    }
    @Test
    public void testform() throws InterruptedException {
        WebElement tElement = driver.findElement(By.xpath("//button[@class='btn-label btn btn-info btn-sm']"));
        tElement.click();
        //Chọn đối tượng trong bảng
        WebElement trElement = tElement.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div/div[2]/div/div[1]/div[2]/div/table/tbody/tr[10]"));
        //double click
        Actions actions = new Actions(driver);
        actions.doubleClick(trElement).perform();
        driver.findElement(By.xpath("//textarea[@placeholder='Nhập Nội dung ...']")).sendKeys("Sửa chữa hệ thống điện trường học");
        driver.findElement(By.xpath("//textarea[@placeholder='Nhập Agent ghi chú ...']")).sendKeys("Nhanh nhất có thể nhé");
        //Mức độ ưu tiên
        WebElement Priority =  driver.findElement(By.xpath("//input[@id='react-select-9-input']"));
        Priority.click();
        Priority.sendKeys("Cao");
        Priority.sendKeys(Keys.ENTER);
        // //Phân loại ticket
        WebElement categories =  driver.findElement(By.xpath("//input[@id='react-select-10-input']"));
        categories.click();
        categories.sendKeys("Yêu cầu");
        categories.sendKeys(Keys.ENTER);
        //Phòng ban
        WebElement selcectDown =  driver.findElement(By.xpath("//input[@id='react-select-11-input']"));
        selcectDown.click();
        selcectDown.sendKeys("PKTDN - PHÒNG KỸ THUẬT ĐIỆN NƯỚC");
        selcectDown.sendKeys(Keys.ENTER);
        // //Bộ phận
        WebElement Division  =  driver.findElement(By.xpath("//input[@id='react-select-12-input']"));
        Division.click();
        Thread.sleep(1000);
        Division.sendKeys(Keys.ENTER);
        // //Yêu cầu dịch vụ
        WebElement Request =  driver.findElement(By.xpath("//input[@id='react-select-12-input']"));
        Request.click();
        Request.sendKeys(Keys.ENTER);
        //Tạo ticket
        driver.findElement(By.xpath("//button[normalize-space()='Thêm Ticket']")).click();
        Thread.sleep(2000);
        //Chuyển tiếp
        //driver.findElement(By.xpath("//button[contains(text(),'Lưu và Chuyển tiếp tới Phòng ban/Bộ phận')]")).click();
    }
    @AfterTest
    public void tearDown() {
        //driver.close();
    }
}