package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_20_21_Page;
import utilities.Driver;

import static tests.Login.login;

public class US21 {
    @Test
    public void test01() throws InterruptedException {
        US_20_21_Page us_20_21_Page = new US_20_21_Page();
        //1-kullanıcı  https://tradylinn.com/  adresine gider
        //2- Satıcı olarak giriş yapılır
        login();
        Thread.sleep(8000);
        //3-hesabim a tiklanir
        us_20_21_Page.hesabim.click();
        Thread.sleep(9000);

        //4-story manager'e tiklanir
        us_20_21_Page.storeManejer.click();
        Thread.sleep(4000);

        //5-raporlar tiklanir
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",us_20_21_Page.raporlar);
        Thread.sleep(8000);
        us_20_21_Page.raporlar.click();
        Thread.sleep(8000);

        //6-year butunu tikla yillik rapor gorunur oldugunu test eder
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",us_20_21_Page.yearRapor);
        Assert.assertTrue(us_20_21_Page.yearRapor.isDisplayed());
        //7-last month butunu tiklar son ay raporunun gorunur oldugunu test eder
        Assert.assertTrue(us_20_21_Page.lastMonthRapor.isDisplayed());
        //8-This month butunu tikla bu ay raporunun gorunur oldugunu test eder
        Assert.assertTrue(us_20_21_Page.thisMonthRapor.isDisplayed());
        //9-last 7 day butunu tikla last 7 day raporunun gorunur oldugunu
        Assert.assertTrue(us_20_21_Page.last7DayRapor.isDisplayed());

    }


    @Test
    public void test02() {
        //1-kullanıcı  https://tradylinn.com/  adresine gider
        //2- Satıcı olarak giriş yapılır
        //3-hesabim a tiklanir
        //4-story manager'e tiklanir
        //5-raporlar tiklanir
        //6-costum a "2022-06-20 to 2022-06-30" tarihi girilir costum raporunun gorunur oldugunu test eder



    }

}

