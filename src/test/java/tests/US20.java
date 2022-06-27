package tests;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.US_20_21_Page;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.Login.login;

public class US20 extends TestBaseRapor {

    @Test
    public  void US20_TC01() throws InterruptedException {
        extentTest=extentReports.createTest("US20_TC01","kullanici bilgisinin goruntulendigini kontrol eder");
        US_20_21_Page us_20_21_Page = new US_20_21_Page();

        //1-kullanıcı  https://tradylinn.com/  adresine gider
        //2- Satıcı olarak giriş yapılır
        login();
        Thread.sleep(5000);

        //3-hesabim a tiklanir
        us_20_21_Page.hesabim.click();
        Thread.sleep(5000);

        //4-story manager'e tiklanir
        us_20_21_Page.storeManejer.click();
        Thread.sleep(4000);

        //5-incelemelere tiklanir
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",us_20_21_Page.inceleme);
        Thread.sleep(4000);
        us_20_21_Page.inceleme.click();
        Thread.sleep(2000);

        //6-product reviews tiklanir
        us_20_21_Page.productReviews.click();

        //7-kullanıcı bilgisi gorunur oldugunu test eder
        String actualResult=us_20_21_Page.kullaniciBilgisi.getText();

        System.out.println("KullaniciAdi = " + actualResult);
        Assert.assertTrue(us_20_21_Page.kullaniciBilgisi.isDisplayed());

        Driver.closeDriver();
        extentTest.info("kullanici bilgisi görüntülendi");

    }


    @Test
    public void US20_TC02() throws InterruptedException {
        extentTest=extentReports.createTest("US20_TC02","kullanıcı commentinin,rating,comment tarihinin goruntulendigini kontrol eder");
        US_20_21_Page us_20_21_Page = new US_20_21_Page();
        //1-kullanıcı  https://tradylinn.com/  adresine gider
        //2- Satıcı olarak giriş yapılır
        login();
        Thread.sleep(5000);

        //3-hesabim a tiklanir
        us_20_21_Page.hesabim.click();
        Thread.sleep(9000);

        //4-story manager'e tiklanir
        us_20_21_Page.storeManejer.click();
        Thread.sleep(4000);

        //5-incelemelere tiklanir
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",us_20_21_Page.inceleme);
        Thread.sleep(4000);
        us_20_21_Page.inceleme.click();
        Thread.sleep(2000);

        //6-product reviews tiklanir
        us_20_21_Page.productReviews.click();

        //7-kullanıcı commentinin gorunur oldugunu test eder
        String actualDescription1=us_20_21_Page.kullaniciCommenti.getText();
        System.out.println("kullaniciCommenti = " + actualDescription1);
        Assert.assertTrue(us_20_21_Page.kullaniciCommenti.isDisplayed());


        //8-kullanıcı rating nin gorunur oldugunu test eder
        String actualResult=us_20_21_Page.kullaniciRating.getText();
        System.out.println("kullaniciRating = " + actualResult);
        Assert.assertTrue(us_20_21_Page.kullaniciCommenti.isDisplayed());


        //9-kullanıcı comment tarihinin gorunur oldugunu test eder
        String actualResult1=us_20_21_Page.kullaniciCommentiTarihi.getText();
        System.out.println("kullaniciCommentiTarihi = " + actualResult1);
        Assert.assertTrue(us_20_21_Page.kullaniciCommentiTarihi.isDisplayed());
        Driver.closeDriver();
        extentTest.info("kullanıcı commentinin,rating,comment tarihi görüntülendi");

    }

}