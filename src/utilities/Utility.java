package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Utility extends BaseTest {


    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }


    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }


    public String getTextFromElement(By by) {

        WebElement element = driver.findElement(by);

        return element.getText();
    }


    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }


    public void selectByValue(By by, String text) {
        WebElement value = driver.findElement(by);
        Select select = new Select(value);
        select.selectByValue(text);
    }


    public void selectByIndex(By by, int num) {
        WebElement index = driver.findElement(by);
        Select select = new Select(index);
        select.selectByIndex(num);
    }

    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }


    public void sendTextToAlert(By by, String text) {
        driver.switchTo().alert().sendKeys(text);
    }


    public String getTextFromAlert(By by) {
        return driver.switchTo().alert().getText();
    }


    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement xyz = driver.findElement(by);
        actions.moveToElement(xyz).build().perform();
    }


    public void mouseHoverAndClickOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement text1 = driver.findElement(by);
        actions.moveToElement(text1).click().build().perform();
    }

    public static String getRandomEmail() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while (random.length() < 10) {
            int index = (int) (rnd.nextFloat() * chars.length());
            random.append(chars.charAt(index));
        }
        String email = random.toString() + "@gmail.com";
        return email;
    }
}