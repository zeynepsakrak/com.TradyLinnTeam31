package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.US_05_06_07_Page;
import utilities.ConfigReader;
import utilities.Driver;

import static tests.Login.login;

public class US05 {
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

        // Kullanici; status, stock, price ve date stunlarinin görünür oldugu kontrol edilir
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        Assert.assertTrue(us_05_06_07_page.Status.isDisplayed());
        Assert.assertTrue(us_05_06_07_page.Stock.isDisplayed());
        Assert.assertTrue(us_05_06_07_page.Price.isDisplayed());
        Assert.assertTrue(us_05_06_07_page.Date.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void TC02() throws InterruptedException {
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

        //Kullanici Yeni Ekle butonuna tiklar
        us_05_06_07_page.yeniEkleButonu.click();

        // Kullanici Virtual ve Downloadable seceneklerinin oldugunu kontrol eder
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        Assert.assertTrue(us_05_06_07_page.virtualClick.isEnabled());
        Assert.assertTrue(us_05_06_07_page.downloadableClick.isEnabled());
        Driver.closeDriver();
    }
    @Test
    public void TC03() throws InterruptedException {
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

        //Kullanici Yeni Ekle butonuna tiklar
        us_05_06_07_page.yeniEkleButonu.click();

        // Kullanici Product Title, Price ve Sale Price box'lara veri girisi yapar
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.click(us_05_06_07_page.productTitle)
                .sendKeys(ConfigReader.getProperty("productTitle"))
                    .sendKeys(Keys.TAB).sendKeys(ConfigReader
                        .getProperty("regularPrice")).sendKeys(Keys.TAB)
                            .sendKeys(ConfigReader.getProperty("salePrice")).perform();
        Driver.closeDriver();
    }

    @Test
    public void TC04() throws InterruptedException {
       // Kullanici vendor olarak hesabina gider
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

        //Kullanici Yeni Ekle butonuna tiklar
        us_05_06_07_page.yeniEkleButonu.click();

        // Kullanici Product Title, Price ve Sale Price box'lara veri girisi yapar
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.click(us_05_06_07_page.productTitle)
                .sendKeys(ConfigReader.getProperty("productTitle"))
                .sendKeys(Keys.TAB).sendKeys(ConfigReader
                        .getProperty("regularPrice")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("salePrice")).perform();


        /*
        6- Kullanici ürün resmi yuklemek icin Large Photo kutusuna tiklar
        7- Kullanici Dosya Yükle butonuna tiklar
        8- Kullanici Dosya Secin butonuna tiklar
        9- Kullanici bir resim dosyasini secer (Foto yolu yazilir) ve Sec butonunu tiklar
        10- Kullanici Galeri Images icin kücük resim bosluguna tiklar
        11- Kullanici Dosya Yükle butonuna tiklar
        12- Kullanici Dosya Secin butonuna tiklar
        13- Kullanici bir resim dosyasini secer ve ADD TO GALLERY butonunu tiklar
         */

    }
}
