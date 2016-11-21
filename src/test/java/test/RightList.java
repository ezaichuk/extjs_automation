package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.pages.HomePage;

/**
 * Created by Lubchik on 15.11.2016.
 */
public class RightList extends TestNgTestBase {
    private HomePage homepage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void IsCheckedAllUncheckedAll() throws InterruptedException {
        driver.get(baseUrl);

        //Check all
        homepage.CheckAllCheckbox();
        Assert.assertTrue(homepage.IsCheckedAllRightLettersList());
        Thread.sleep(5000);

        //Uncheck all
        homepage.CheckAllCheckbox();
        Assert.assertFalse(homepage.IsCheckedAllRightLettersList());
        Thread.sleep(5000);

        homepage.IsCheckedAllRightLettersList();

    }



}
