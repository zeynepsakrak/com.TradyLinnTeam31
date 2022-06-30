package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.US_19_22_Page;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.Login.login;
import static tests.ReusableMethods.*;

public class US19 extends TestBaseRapor {
    US_19_22_Page myPage= new US_19_22_Page();
    Homepage homePage = new Homepage();

    @Test
    public void  US19_TC01() {
        extentTest = extentReports.createTest("US19_TC01","İsim, e-posta tanımlanmalı");

        login();
        waitFor(10);

        homePage.hesabim.click();

        homePage.StoreManager.click();

        waitForClickablility(myPage.takipci,5);
        myPage.takipci.sendKeys(Keys.ENTER);
        bekle();

        Assert.assertTrue(myPage.takipciIsim.isDisplayed());

        Assert.assertTrue(myPage.takipciEposta.isDisplayed());

        extentTest.info("Takipcilerin e-posta gorunurlugu test edildi");

        Driver.getDriver().close();
    }

    @Test
    public void  US19_TC02() {
        extentTest = extentReports.createTest("US19_TC02","İsim, e-posta tanımlanmalı");

        login();
        waitFor(10);

        homePage.hesabim.click();

        homePage.StoreManager.click();
        myPage.takipci.sendKeys(Keys.ENTER);
        waitFor(5);

        Assert.assertTrue(myPage.takipciIslem.isDisplayed());

        Driver.getDriver().close();
    }
}
