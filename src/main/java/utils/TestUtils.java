package utils;

import exel.ExcelHelpers;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestUtils {
    public static void doubleClickElement(WebDriver driver, By Locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(Locator);
        actions.doubleClick(element).perform();
    }
    public static void fillInputField(WebDriver driver, By locator, String text) {
        WebElement field = driver.findElement(locator);
        field.sendKeys(text);
    }
    public static void clickElement(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }

    public static void selectDropDow( WebDriver driver, By locator, String text) throws InterruptedException{
        WebElement mauthongbao = driver.findElement(locator);
        mauthongbao.click();
        mauthongbao.sendKeys(text);
        Thread.sleep(2000);
        mauthongbao.sendKeys(Keys.ENTER);
    }
    public static String SetText(String nameSheet, String tenCot, int soHangCanLay) throws Exception {
        ExcelHelpers excelHelper = new ExcelHelpers();
        excelHelper.setExcelFile("src/test/resources/Book1.xlsx", nameSheet);
        return excelHelper.getCellData(tenCot, soHangCanLay);
    }
    public static void takeScreenshot(WebDriver driver, ITestResult result) throws InterruptedException {
        Thread.sleep(1000);
        //Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Test Case
        //Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        //passed = SUCCESS và failed = FAILURE
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Tạo tham chiếu của TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                // Gọi hàm capture screenshot - getScreenshotAs
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
                File theDir = new File("./Screenshots/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
                String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
                // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + "_" + timeStamp + ".png"));
                System.out.println("Đã chụp màn hình: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

}
