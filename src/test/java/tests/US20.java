package tests;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pages.US_20_21_Page;
import utilities.Driver;

import static tests.Login.login;

public class US20 {

    @Test
    public  void test01() throws InterruptedException {
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
        String actualDescription=us_20_21_Page.kullaniciBilgisi.getText();

        System.out.println("KullaniciAdi = " + actualDescription);
        Assert.assertTrue(us_20_21_Page.kullaniciBilgisi.isDisplayed());

        Driver.closeDriver();

    }


    @Test
    public void test02() throws InterruptedException {
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


        //8-kullanıcı comment tarihinin gorunur oldugunu test eder

        String actualDescription2=us_20_21_Page.kullaniciCommentiTarihi.getText();
        System.out.println("kullaniciCommentiTarihi = " + actualDescription2);

        Assert.assertTrue(us_20_21_Page.kullaniciCommentiTarihi.isDisplayed());

        Driver.closeDriver();

    }

}