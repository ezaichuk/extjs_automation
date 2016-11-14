package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import test.pages.HomePage;

import java.util.List;

/**
 * Created by Lubchik on 06.11.2016.
 */
public class LeftList extends TestNgTestBase {
    private HomePage homepage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void TestHomePageIsOpened() {
        driver.get(baseUrl);

        Assert.assertTrue("English alphabet".equals(homepage.leftPanelHeader.getText()));
        Assert.assertTrue("English letter".equals(homepage.rightPanelHeader.getText()));
    }

    @Test
    public void TestHomePageLeftTable() throws InterruptedException {
        driver.get(baseUrl);

        //Collapsing List
        homepage.ClickLeftList();
        Thread.sleep(1000);
        Assert.assertTrue(homepage.IsCollapsedLeftLettersList());

        //Expanding List
        homepage.ClickLeftList();
        Thread.sleep(1000);
        Assert.assertFalse(homepage.IsCollapsedLeftLettersList());
    }

    @Test
    public void DeleteLetters() {
        driver.get(baseUrl);

        homepage.DeleteLeftLetters();
        Assert.assertFalse(homepage.leftLettersTable.getText().contains("C"), "Letter C is not deleted. Probably, DELETE functionality is not working");
    }


}
