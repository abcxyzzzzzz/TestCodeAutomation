package approval.NhanVien;

import locators.EmployssLocators;
import locators.PublicLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.TestUtils;
import java.util.concurrent.TimeUnit;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class NhanVienTiepNhanYeuCau {
    public static void DongYYeuCau(WebDriver driver, int thuchien) throws InterruptedException, AWTException {
        TestUtils.clickElement(driver, PublicLocators.CanDuyet);
        TestUtils.fillInputField(driver,PublicLocators.LyDo,"Tôi có thể thực hiện yêu cầu này");
        Thread.sleep(2000);
        TestUtils.clickElement(driver, PublicLocators.XacNhan);
        Thread.sleep(5000);
        TestUtils.fillInputField(driver, EmployssLocators.TruocXuLy, "Kết quả trước khi thực hiện hành động");
        TestUtils.uploadImages(driver,"D:\\Tuyên\\Memes\\2 (26).jpg","(//div[@role='presentation'])[1]");
        TestUtils.uploadImages(driver,"D:\\Tuyên\\Memes\\2 (27).jpg","(//div[@role='presentation'])[1]");
        TestUtils.uploadImages(driver,"D:\\Tuyên\\Memes\\2 (28).jpg","(//div[@role='presentation'])[1]");
        TestUtils.uploadImages(driver,"D:\\Tuyên\\Memes\\2 (29).jpg","(//div[@role='presentation'])[1]");
        TestUtils.clickElement(driver, EmployssLocators.UpdateTruocXuLy);
        Thread.sleep(5000);
        TestUtils.fillInputField(driver,EmployssLocators.SauXuLy,"Kết quả sau khi thực hiện hành động");
        TestUtils.uploadImages(driver,"D:\\Tuyên\\Memes\\2 (25).jpg","(//div[@role='presentation'])[2]");
        TestUtils.uploadImages(driver,"D:\\Tuyên\\Memes\\2 (24).jpg","(//div[@role='presentation'])[2]");
        TestUtils.uploadImages(driver,"D:\\Tuyên\\Memes\\2 (23).jpg","(//div[@role='presentation'])[2]");
        TestUtils.uploadImages(driver,"D:\\Tuyên\\Memes\\2 (22).jpg","(//div[@role='presentation'])[2]");
        Thread.sleep(5000);
        TestUtils.clickElement(driver, EmployssLocators.UpdateSauXuLy);
        Thread.sleep(4000);

        int thucHien = thuchien;
        switch (thucHien) {
            case 1:
                TestUtils.clickElement(driver,PublicLocators.ChuyenNhanVien);
                TestUtils.clickElement(driver,EmployssLocators.CoTheXuLy);
                TestUtils.fillInputField(driver,PublicLocators.LyDo,"Tôi đã thực hiện yêu cầu này");
                TestUtils.clickElement(driver,PublicLocators.XacNhan);
                Thread.sleep(1000);
                break;

            case 2:
                TestUtils.clickElement(driver,PublicLocators.ChuyenNhanVien);
                TestUtils.clickElement(driver,EmployssLocators.KhongTheXuLy);
                TestUtils.fillInputField(driver,PublicLocators.LyDo,"Tôi không thể thực hiện yêu cầu này");
                TestUtils.clickElement(driver,PublicLocators.XacNhan);
                Thread.sleep(1000);
                break;
        }
    }
    public static void TuChoiYeuCau(WebDriver driver) throws InterruptedException {
        TestUtils.clickElement(driver, PublicLocators.ChuyenNhanVien);
        TestUtils.clickElement(driver, EmployssLocators.TuChoi);
        TestUtils.fillInputField(driver,PublicLocators.LyDo, "Tôi không thể thực hiện yêu cầu này");
        Thread.sleep(2000);
        TestUtils.clickElement(driver,PublicLocators.XacNhan);

    }
    public static void dongy(WebDriver driver, int thuchien) throws InterruptedException, AWTException {
        Thread.sleep(5000);
        TestUtils.fillInputField(driver, EmployssLocators.TruocXuLy, "Kết quả trước khi thực hiện hành động");
        TestUtils.uploadImages(driver,"D:\\Tuyên\\Memes\\2 (26).jpg","(//div[@role='presentation'])[1]");
        TestUtils.clickElement(driver, EmployssLocators.UpdateTruocXuLy);
        Thread.sleep(1000);
        TestUtils.fillInputField(driver,EmployssLocators.SauXuLy,"Kết quả sau khi thực hiện hành động");
        TestUtils.uploadImages(driver,"D:\\Tuyên\\Memes\\2 (27).jpg","(//div[@role='presentation'])[2]");
        Thread.sleep(1000);
        TestUtils.clickElement(driver, EmployssLocators.UpdateSauXuLy);
        Thread.sleep(4000);

        int thucHien = thuchien;
        switch (thucHien) {
            case 1:
            case 2:
        }
    }
}
