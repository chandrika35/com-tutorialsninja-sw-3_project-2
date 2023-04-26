package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {
    @Before
    public void setUp() {
        openBrowser("http://tutorialsninja.com/demo/index.php?");
    }
@Test
    public void selectMyAccountOptions(String option) {
        List<WebElement> registerList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));//list with two options(do multi select)
        for (WebElement option1 : registerList) {
            if (option1.getText().equals(option)) {
                option1.click();
                break;
            }
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));//myaccount
        selectMyAccountOptions("Register");
        String expectedTextRegister = "Register Account";
        String actualTextRegister = getTextFromElement(By.xpath("//div[@id='content']/h1"));

        Assert.assertEquals("not on register page", expectedTextRegister, actualTextRegister);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Login");
        String expectedTextLogin = "Returning Customer";
        String actualTextLogin = getTextFromElement(By.xpath("//div[@class='well']/h2[text()='Returning Customer']"));

        Assert.assertEquals("not on login page", expectedTextLogin, actualTextLogin);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));//myaccount
        selectMyAccountOptions("Register");//to click on register button

        sendTextToElement(By.name("firstname"), "Sita");

        sendTextToElement(By.name("lastname"), "Ram");

        sendTextToElement(By.name("email"), getRandomEmail());

        sendTextToElement(By.name("telephone"), "019346254");

        sendTextToElement(By.name("password"), "sita_123");

        sendTextToElement(By.name("confirm"), "sita_123");

        clickOnElement(By.name("newsletter"));

        clickOnElement(By.name("agree"));

        clickOnElement(By.xpath("//input[@type='submit']"));
              String expectedCreation = "Your Account Has Been Created!";

        String actualCreation = getTextFromElement(By.xpath("//div[@id='content']/h1"));

        Assert.assertEquals("account not created", expectedCreation, actualCreation);

        clickOnElement(By.xpath("//a[text()='Continue']"));

        clickOnElement(By.xpath("//a[@title='My Account']"));

        selectMyAccountOptions("Logout");
        String expectedTextLogout = "Account Logout";
        String actualTextLogout = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));

        Assert.assertEquals("not logged out", expectedTextLogout, actualTextLogout);

        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        selectMyAccountOptions("Login");

        sendTextToElement(By.name("email"), "iampatel@gmail.com");

        sendTextToElement(By.name("password"), "HelloNum1");

        clickOnElement(By.xpath("//input[@value='Login']"));
        String expectedTextMyAccount = "My Account";
        String actualTextMyAccount = getTextFromElement(By.xpath("//div[@id='content']/h2[text()='My Account']"));

        Assert.assertEquals("Not on my account", expectedTextMyAccount, actualTextMyAccount);

        clickOnElement(By.xpath("//a[@title='My Account']"));

        selectMyAccountOptions("Logout");
        String expectedTextLogout = "Account Logout";
        String actualTextLogout = getTextFromElement(By.xpath("//div[@id='content']/h1"));

        Assert.assertEquals("Not logged out", expectedTextLogout, actualTextLogout);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
