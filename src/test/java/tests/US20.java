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
        Thread.sleep(8000);
        extentTest.info("1-https://tradylinn.com/  adresine gidildi\n" +
                "        2-Satıcı olarak giriş yapildi");

        //3-hesabim butonuna  a tiklanir
        us_20_21_Page.hesabim.click();
        Thread.sleep(8000);
        extentTest.info("3-hesabim butonuna  a tiklandi");

        //4-story manager'e tiklanir
        us_20_21_Page.storeManejer.click();
        Thread.sleep(4000);
        extentTest.info("4-story manager'e tiklandi");

        //5-incelemelere tiklanir
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",us_20_21_Page.inceleme);
        Thread.sleep(4000);
        us_20_21_Page.inceleme.click();
        Thread.sleep(2000);
        extentTest.info("5-incelemelere tiklandi");

        //6-product reviews tiklanir
        us_20_21_Page.productReviews.click();
        extentTest.info("6-product reviews tiklandi");

        //7-kullanıcı bilgisi gorunur oldugunu test eder
        String actualResult=us_20_21_Page.kullaniciBilgisi.getText();
        System.out.println("KullaniciAdi = " + actualResult);
        Assert.assertTrue(us_20_21_Page.kullaniciBilgisi.isDisplayed());

        Driver.closeDriver();
        extentTest.pass("kullanici bilgisi görüntülendi");

    }


    @Test
    public void US20_TC02() throws InterruptedException {
        extentTest=extentReports.createTest("US20_TC02","kullanıcı commentinin,rating,comment tarihinin goruntulendigini kontrol eder");
        US_20_21_Page us_20_21_Page = new US_20_21_Page();
        //1-kullanıcı  https://tradylinn.com/  adresine gider
        //2- Satıcı olarak giriş yapılır
        login();
        Thread.sleep(5000);
        extentTest.info("1-https://tradylinn.com/  adresine gidildi\n" +
                "        2-Satıcı olarak giriş yapildi");

        //3-hesabim a tiklanir
        us_20_21_Page.hesabim.click();
        Thread.sleep(9000);
        extentTest.info("3-hesabim butonuna  a tiklandi");

        //4-story manager'e tiklanir
        us_20_21_Page.storeManejer.click();
        Thread.sleep(4000);
        extentTest.info("4-story manager'e tiklandi");

        //5-incelemelere tiklanir
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",us_20_21_Page.inceleme);
        Thread.sleep(4000);
        us_20_21_Page.inceleme.click();
        Thread.sleep(2000);
        extentTest.info("5-incelemelere tiklandi");

        //6-product reviews tiklanir
        us_20_21_Page.productReviews.click();
        Thread.sleep(4000);
        extentTest.info("6-product reviews tiklandi");

        //7-kullanıcı commentinin gorunur oldugunu test eder
        String actualDescription1=us_20_21_Page.kullaniciCommenti.getText();
        System.out.println("kullaniciCommenti = " + actualDescription1);
        Assert.assertTrue(us_20_21_Page.kullaniciCommenti.isDisplayed());
        extentTest.info("7-kullanıcı commenti goruntulendi");


        //8-kullanıcı rating nin gorunur oldugunu test eder
        String actualResult=us_20_21_Page.kullaniciRating.getText();
        System.out.println("kullaniciRating = " + actualResult);
        Assert.assertTrue(us_20_21_Page.kullaniciCommenti.isDisplayed());
        extentTest.info("8-kullanıcı rating goruntulendi");


        //9-kullanıcı comment tarihinin gorunur oldugunu test eder
        String actualResult1=us_20_21_Page.kullaniciCommentiTarihi.getText();
        System.out.println("kullaniciCommentiTarihi = " + actualResult1);
        Assert.assertTrue(us_20_21_Page.kullaniciCommentiTarihi.isDisplayed());
        extentTest.pass("kullanıcı commentinin,rating,comment tarihi görüntülendi");
        Driver.closeDriver();


    }

}