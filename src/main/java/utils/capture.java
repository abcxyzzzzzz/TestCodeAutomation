package utils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class capture {

    //Lấy đường dẫn đến project hiện tại
    static String projectPath = System.getProperty("user.dir") + "/";
    //Tạo format ngày giờ để xíu gắn dô cái name của screenshot hoặc record video
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

    public static void takeScreenshot(WebDriver driver,ITestResult result) throws InterruptedException {
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
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
                System.out.println("Đã chụp màn hình: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }

}
