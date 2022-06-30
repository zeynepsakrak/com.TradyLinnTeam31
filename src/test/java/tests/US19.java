package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.US_19_22_Page;
import utilities.Driver;

import static tests.Login.login;
import static tests.ReusableMethods.*;

public class US19 {
    US_19_22_Page myPage= new US_19_22_Page();
    Homepage homePage = new Homepage();

    @Test
    public void  US19_TC01() {
        login();
        waitFor(10);

        homePage.hesabim.click();

        homePage.StoreManager.click();

        waitForClickablility(myPage.takipci,5);
        myPage.takipci.sendKeys(Keys.ENTER);
        bekle();

        Assert.assertTrue(myPage.takipciEposta.isDisplayed());

        Driver.getDriver().quit();
    }

    @Test
    public void  US19_TC02() {
        login();
        waitFor(10);

        homePage.hesabim.click();

        homePage.StoreManager.click();

        waitForClickablility(myPage.takipci,5);
        myPage.takipci.sendKeys(Keys.ENTER);
        waitFor(5);

        Assert.assertTrue(myPage.takipciIslem.isDisplayed());

        Driver.getDriver().close();
    }
}
