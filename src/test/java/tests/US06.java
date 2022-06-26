package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_05_06_07_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US06 {
    US_05_06_07_Page us_05_06_07_page;
    @Test
    public void TC01() throws InterruptedException {
        //Kullanici vendor olarak hesabina gider
        us_05_06_07_page=new US_05_06_07_Page();
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        us_05_06_07_page.girisButonu.click();
        us_05_06_07_page.userName.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        us_05_06_07_page.pasword.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        us_05_06_07_page.girisYapButonu.click();
        Thread.sleep(5000);
        us_05_06_07_page.hesabimButonu.click();
        //Kullanici Store Manager butonuna tiklar
        us_05_06_07_page.storeManagerButonu.click();
        //Kullanici Urunler butonuna ve yeni ekle butonuna tiklar
        us_05_06_07_page.urunButonu.click();
        us_05_06_07_page.yeniEkleButonu.click();
        /*
        Kullanici Catagories kismina gider
        Kullanici secilen ürünlerin katagorilerinin tiklanabildigi ve isaretlendigi kontrol edilir
         */
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);

        actions.click(us_05_06_07_page.categories).sendKeys(Keys.PAGE_DOWN).perform();
        us_05_06_07_page.musikClickBox.click();
        Assert.assertTrue(us_05_06_07_page.musikClickBox.isSelected());
        Driver.closeDriver();
    }
}
