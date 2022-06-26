package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_05_06_07_Page;
import utilities.Driver;

import static tests.Login.login;

public class US05 {
    US_05_06_07_Page us_05_06_07_page;

    @Test
    public void TC01() throws InterruptedException {
        //Kullanici vendor olarak hesabina gider
        login();
        us_05_06_07_page=new US_05_06_07_Page();
        Thread.sleep(3000);
        us_05_06_07_page.hesabimButonu.click();

        //Kullanici Store Manager butonuna tiklar
        us_05_06_07_page.storeManagerButonu.click();

        //Kullanici Urunler butonuna tiklar
        us_05_06_07_page.urunButonu.click();

        // Kullanici; status, stock, price ve date stunlarinin görünür oldugu kontrol edilir
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        Assert.assertTrue(us_05_06_07_page.Status.isDisplayed());
        Assert.assertTrue(us_05_06_07_page.Stock.isDisplayed());
        Assert.assertTrue(us_05_06_07_page.Price.isDisplayed());
        Assert.assertTrue(us_05_06_07_page.Date.isDisplayed());







    }
}
