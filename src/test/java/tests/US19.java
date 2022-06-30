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
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");

        homePage.hesabim.click();
        extentTest.info("Hesabim butonuna tiklandi");

        homePage.StoreManager.click();
        extentTest.info("Store Manager butonuna tiklandi");

        waitForClickablility(myPage.takipci,5);
        myPage.takipci.sendKeys(Keys.ENTER);
        bekle();
        extentTest.info("Takipciler butonuna tiklandi");

        Assert.assertTrue(myPage.takipciIsim.isDisplayed());
        extentTest.info("Takipcilerin isimlerinin gorunurlugu test edildi");

        Assert.assertTrue(myPage.takipciEposta.isDisplayed());
        extentTest.info("Takipcilerin e-postalarinin gorunurlugu test edildi");

        extentTest.pass("Takipcilerin isim ve e-postalarinin gorunurlugu test edildi");
        Driver.getDriver().close();
    }

    @Test
    public void  US19_TC02() {
        extentTest = extentReports.createTest("US19_TC02","Işlemler tanımlanmalı");

        login();
        waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");

        homePage.hesabim.click();
        extentTest.info("Hesabim butonuna tiklandi");

        homePage.StoreManager.click();
        extentTest.info("Store Manager butonuna tiklandi");

        myPage.takipci.sendKeys(Keys.ENTER);
        waitFor(5);
        extentTest.info("Takipciler butonuna tiklandi");

        Assert.assertTrue(myPage.takipciIslem.isDisplayed());
        extentTest.info("Takipcilerin işlemlerinin gorunurlugu test edildi");

        extentTest.pass("Takipcilerin işlemlerinin gorunurlugu test edildi");
        Driver.getDriver().close();
    }
}
