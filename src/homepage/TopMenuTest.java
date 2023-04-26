package homepage;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;

import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        if (menu == "Desktops") {

            mouseHoverOnElement(By.linkText("Desktops"));
            clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

            String title = driver.getTitle();

            Assert.assertEquals("title not matched: ", "Desktops", title);

        } else if (menu == "Laptops & Notebooks") {

            mouseHoverOnElement(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
            clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
            String title = driver.getTitle();
            Assert.assertEquals("title not matched: ", "Laptops & Notebooks", title);
        } else if (menu == "Components") {
            mouseHoverOnElement(By.linkText("Components"));
            clickOnElement(By.xpath("//a[normalize-space()='Show AllComponents']"));
              String title = driver.getTitle();
              Assert.assertEquals("Title is not same.", "Components", title);

        } else {
            System.out.println("Please enter valid Top-menu name or check actual Top-menu name");
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        selectMenu("Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        selectMenu("Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        selectMenu("Components");
    }

    @After
    public void teardown() {
        closeBrowser();
    }
}
