package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.US_19_22_Page;

import static tests.Login.login;
import static tests.ReusableMethods.bekle;
import static tests.ReusableMethods.waitFor;

public class US19 {
    US_19_22_Page myPage= new US_19_22_Page();
    Homepage homePage = new Homepage();

    @Test
    public void  US19_TC01() {
        login();
        waitFor(15);
        homePage.hesabim.click();
        homePage.StoreManager.click();
        bekle();
        myPage.takipci.sendKeys(Keys.ENTER);
        bekle();
        Assert.assertTrue(myPage.takipciEposta.isDisplayed());
    }

    @Test
    public void  US19_TC02() {
        login();
        waitFor(15);
        homePage.hesabim.click();
        homePage.StoreManager.click();
        myPage.takipci.sendKeys(Keys.ENTER);
        waitFor(5);
        Assert.assertTrue(myPage.takipciIslem.isDisplayed());
    }
}
