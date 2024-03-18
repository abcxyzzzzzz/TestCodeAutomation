package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SetUp {
    public static void setUp(WebDriver driver){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
        driver.get("https://crm-dev.lsat.vn/login");
    }
}
