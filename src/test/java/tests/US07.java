package tests;

import org.testng.annotations.Test;
import pages.US_05_06_07_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US07 {
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

        //Kullanici Urunler butonuna tiklar
        us_05_06_07_page.urunButonu.click();

    }
}
