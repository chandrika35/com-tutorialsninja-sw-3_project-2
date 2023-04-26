package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTEst extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        mouseHoverOnElement(By.linkText("Desktops"));
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/select[1]"), "Name (Z - A)");
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        mouseHoverOnElement(By.linkText("Desktops"));
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/select[1]"), "Name (A - Z)");

        clickOnElement(By.xpath("//a[text()='HP LP3065']"));

        String expectedText = "HP LP3065";

        String actualText = getTextFromElement(By.xpath("//a[text()='HP LP3065']"));

        Assert.assertEquals("not on HP LP3065 page", expectedText, actualText);

        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]"));
        String year = "2022";
        String month = "November";
        String date = "30";

        while (true) {

            String monthYear = driver.findElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();

            String arr[] = monthYear.split(" ");

            String mon = arr[0];

            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }
        }

        List<WebElement> allDate = driver.findElements(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));

        for (WebElement date1 : allDate) {

            if (date1.getText().equalsIgnoreCase(date)) {
                date1.click();
                break;
            }
        }

        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "");

        clickOnElement(By.xpath("//button[@id='button-cart']"));

        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!" + "\n×";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        Assert.assertEquals("not added to cart", expectedMessage, actualMessage);


        clickOnElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/a[2]"));
        String expTextShoppingCart = "Shopping Cart  (1.00kg)", expTextProductName = "HP LP3065", expTextDeliveryDate = "Delivery Date:2022-11-30", expTextModel = "Product 21", expTextTotal = "$122.00";

        String actTextShoppingCart = getTextFromElement(By.xpath("//div[@id='content']/h1"));

        Assert.assertEquals("shopping cart not visible", expTextShoppingCart, actTextShoppingCart);

        String actTextProductName = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));

        Assert.assertEquals("Product name not visible", expTextProductName, actTextProductName);

        String actDeliveryDate = getTextFromElement(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"));
        Assert.assertEquals("Delivery date not visible", expTextDeliveryDate, actDeliveryDate);

        String actTextModel = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]"));

        Assert.assertEquals("model not displayed", expTextModel, actTextModel);

        String actTextTotal = getTextFromElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]"));

        Assert.assertEquals("Total not displayed", expTextTotal, actTextTotal);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
