package utils;

import exel.ExcelHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
}
