package laptopsansnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.junit.Assert;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    @Before
    public void setUp(){
        openBrowser("http://tutorialsninja.com/demo/index.php?");
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){

        mouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        String expectedText = "Price (High > Low)";
        String actualText = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/select[1]/option[5]"));

        Assert.assertEquals("not price high to low",expectedText,actualText);
    }
    @Test public void verifyThatUserPlaceOrderSuccessfully(){

        mouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));

        String expectedTextProduct = "MacBook";

        String actualTextProduct = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/h1[1]"));

        Assert.assertEquals("not on Macbook page",expectedTextProduct,actualTextProduct);

        clickOnElement(By.xpath("//button[@id='button-cart']"));
        String expectedSuccessMessage = "Success: You have added MacBook to your shopping cart!"+"\n×";
        String actualSuccessMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        Assert.assertEquals("not added to cart",expectedSuccessMessage,actualSuccessMessage);

        clickOnElement(By.xpath("//body[1]/div[2]/div[1]/a[2]"));

        String expectedTextShoppingCart = "Shopping Cart  (0.00kg)";

        String actualTextShoppingCart = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h1[1]"));

        Assert.assertEquals("not on shopping cart page",expectedTextShoppingCart,actualTextShoppingCart);
          String expectedProductName = "MacBook";

        String actualProductName = getTextFromElement(By.xpath("//div[@id='content']/form/div/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));

        Assert.assertEquals("not on shopping cart",expectedProductName,actualProductName);

        driver.findElement(By.xpath("//div[@class='input-group btn-block']/input")).clear();

        sendTextToElement(By.xpath("//div[@class='input-group btn-block']/input"),"2");

        clickOnElement(By.xpath("//button[@type='submit']"));

        String expectedModificationSuccessMessage = "Success: You have modified your shopping cart!"+"\n×";

        String actualModificationSuccessMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        Assert.assertEquals("not modified correctly",expectedModificationSuccessMessage,actualModificationSuccessMessage);

        String expectedTotal = "$1,204.00";
        String actualTotal = getTextFromElement(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"));
        Assert.assertEquals("total not displayed",expectedTotal,actualTotal);

        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        String expectedCheckout = "Checkout";
        String actualCheckout = getTextFromElement(By.xpath("//div[@id='content']/h1"));
        Assert.assertEquals("not on checkout",expectedCheckout,actualCheckout);

        String expectedNewCustomer = "New Customer";
        String actualNewCustomer = getTextFromElement(By.xpath("//div[@class='col-sm-6']/h2[text()='New Customer']"));
        Assert.assertEquals("New customer not found",expectedNewCustomer,actualNewCustomer);

        clickOnElement(By.xpath("//input[@value='guest']"));

        mouseHoverAndClickOnElement(By.id("button-account"));

        sendTextToElement(By.id("input-payment-firstname"),"SIta");

        sendTextToElement(By.id("input-payment-lastname"),"Ram");

        sendTextToElement(By.id("input-payment-email"),getRandomEmail());

        sendTextToElement(By.id("input-payment-telephone"),"0756849345");

        sendTextToElement(By.id("input-payment-address-1"),"11,Cheniesway");

        sendTextToElement(By.id("input-payment-city"),"Amersham");

        sendTextToElement(By.id("input-payment-postcode"),"W2 4HL");

        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/div[6]/select[1]"),"United Kingdom");

        selectByVisibleTextFromDropDown(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/fieldset[1]/div[7]/select[1]"),"Aberdeen");

        clickOnElement(By.xpath("//div[@class='buttons']/div[@class='pull-right']/input[@value='Continue']"));

        sendTextToElement(By.xpath("//div[@class='panel-body']/p[2]/textarea[@name='comment']"),"Comment XYZA");

        mouseHoverAndClickOnElement(By.xpath("//input[@name='agree']"));

        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        String expectedWarningMessage = "Warning: Payment method required!"+"\n×";
        String actualWarningMessage = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));

        Assert.assertEquals("No Alert",expectedWarningMessage,actualWarningMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
