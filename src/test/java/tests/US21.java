package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_20_21_Page;
import utilities.Driver;

import static tests.Login.login;

public class US21 {
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void test01() throws InterruptedException {
        US_20_21_Page us_20_21_Page = new US_20_21_Page();
        //1-kullanıcı  https://tradylinn.com/  adresine gider
        //2- Satıcı olarak giriş yapılır
        Thread.sleep(4000);
        login();
        Thread.sleep(11000);
        //3-hesabim a tiklanir
        us_20_21_Page.hesabim.click();
        Thread.sleep(10000);

        //4-story manager'e tiklanir
        us_20_21_Page.storeManejer.click();
        Thread.sleep(4000);

        //5-raporlar tiklanir
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",us_20_21_Page.raporlar);
        //actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_UP,Keys.PAGE_UP).perform();
        Thread.sleep(8000);
        us_20_21_Page.raporlar.click();
        Thread.sleep(8000);

        //6-year butunu tiklanir yillik raporun gorunur oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(4000);
        us_20_21_Page.yearButon.click();
        Thread.sleep(5000);
        Assert.assertTrue(us_20_21_Page.yearRapor.isDisplayed());
        //7-last month butunu tiklanir son ay raporunun gorunur oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(10000);
        us_20_21_Page.lastMonthButon.click();

        Assert.assertTrue(us_20_21_Page.lastMonthRapor.isDisplayed());
        //8-This month butunu tikla bu ay raporunun gorunur oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(10000);
        us_20_21_Page.thisMonthButon.click();
        Thread.sleep(5000);
        Assert.assertTrue(us_20_21_Page.thisMonthRapor.isDisplayed());
        //9-last 7 day butunu tikla last 7 day raporunun gorunur oldugunu
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(10000);
        us_20_21_Page.last7DayButon.click();
        Thread.sleep(7000);
        Assert.assertTrue(us_20_21_Page.last7DayRapor.isDisplayed());

    }
    
    @Test
    public void test02() throws InterruptedException {
        US_20_21_Page us_20_21_Page=new US_20_21_Page();
        //1-kullanıcı  https://tradylinn.com/  adresine gider
        //2- Satıcı olarak giriş yapılır
        Thread.sleep(4000);
        login();
        Thread.sleep(11000);

        //3-hesabim a tiklanir
        us_20_21_Page.hesabim.click();
        Thread.sleep(10000);

        //4-story manager'e tiklanir
        us_20_21_Page.storeManejer.click();
        Thread.sleep(4000);

        //5-raporlar tiklanir
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",us_20_21_Page.raporlar);
        //actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_UP,Keys.PAGE_UP).perform();
        Thread.sleep(8000);
        us_20_21_Page.raporlar.click();
        Thread.sleep(8000);

        //6-costum a "2022-06-20 to 2022-06-30" tarihi girilir costum raporunun gorunur oldugunu test eder
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us_20_21_Page.costumButon.click();
        Thread.sleep(5000);
        us_20_21_Page.costumRapor20Haz.click();
        us_20_21_Page.costumRapor30Haz.click();
        Thread.sleep(5000);

    }

}

