package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_03_04_Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class US03 {
    US_03_04_Page myPage = new US_03_04_Page();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void US03_TC01() throws InterruptedException {
        //1. Kullanıcı https://tradylinn.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        myPage.homePageGirisYapButonu.click();
        //3. Email ve Password girer
        myPage.girisYapUsernameBox.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        myPage.girisYapPasswordBox.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        //4. 'Giris Yap' butonuna tiklar
        myPage.girisYapButonu.click();
        //5. 'Hesabim'a tiklar
        Thread.sleep(10000);
        myPage.hesabimButonu.click();
        //6. 'Siparisler'e tiklar
        myPage.hesabimSiparislerButonu.click();
        //7. 'Ürünlere göz at/Alisverise devam et' tiklar
        jse.executeScript("arguments[0].scrollIntoView();", myPage.hesabimAlisveriseDevamEtButonu);
        Thread.sleep(1000);
        myPage.hesabimAlisveriseDevamEtButonu.click();
        //8. Ürünlerin goruntulendigini kontrol eder
        Assert.assertTrue(myPage.urunlerElementListesi.size() != 0);
        Driver.closeDriver();
    }

    @Test
    public void US03_TC02() throws InterruptedException {
        //1. Kullanıcı https://tradylinn.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        myPage.homePageGirisYapButonu.click();
        //3. Email ve Password girer
        myPage.girisYapUsernameBox.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        myPage.girisYapPasswordBox.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        //4. 'Giris Yap' butonuna tiklar
        myPage.girisYapButonu.click();
        //5. Tradylinn ikonuna tiklarak anasayfaya gider
        Thread.sleep(10000);
        // myPage.tradylinnIkonu.click();
        //6. 'Hemen Basla' butonuna tiklar
        myPage.hemenBaslaButonu.click();
        //7. Ilk 5 ürünü, 'Sepete Ekle' butonuna tiklayarak sepete ekler

        //int i = 12;
        //WebElement urun = Driver.getDriver().findElement(By.xpath("(//figure[@class='product-media'])[" + i + "]"));
        //jse.executeScript("arguments[0].scrollIntoView();", urun);
        //Thread.sleep(1000);
        //urun.click();

        //System.out.println(myPage.urunlerElementListesi.get(4).getText());
        for (int i = 0; i < myPage.urunlerElementListesi.size(); i++) {
            if (!myPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", myPage.urunlerElementListesi.get(i));
                Thread.sleep(1000);
                myPage.urunlerElementListesi.get(i).click();
                myPage.sepeteEkleButonu.click();
                Driver.getDriver().navigate().back();
                Driver.getDriver().navigate().back();
                System.out.println(myPage.urunlerElementListesi.get(i).getText());
            }
            // WebElement urun = Driver.getDriver().findElement(By.xpath("(//figure[@class='product-media'])[" + i + "]"));
            // jse.executeScript("arguments[0].scrollIntoView();", urun);

        }
        System.out.println(myPage.sepetimIkonu.getText());
        //8. Sepetteki ürün miktarinin 5 oldugunu kontrol eder
        Assert.assertTrue(myPage.sepetimIkonu.getText().contains("5"));

    }
}
