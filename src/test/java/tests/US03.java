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

import static tests.Login.login;

public class US03 {
    US_03_04_Page myPage = new US_03_04_Page();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void US03_TC01() throws InterruptedException {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        //5. 'Hesabim'a tiklar
        Thread.sleep(5000);
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
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        Thread.sleep(5000);
        //5. 'Hemen Basla' butonuna tiklar
        myPage.sepetimIkonu.click();
        myPage.sepetiGoruntule.click();
        jse.executeScript("arguments[0].scrollIntoView();", myPage.sepetiTemizle);
        Thread.sleep(1000);
        myPage.sepetiTemizle.click();
        myPage.tradylinnIkonu.click();
        myPage.hemenBaslaButonu.click();
        //6. Ilk 5 ürünü, 'Sepete Ekle' butonuna tiklayarak sepete ekler
        int count = 0;
        for (int i = 0; i < myPage.urunlerElementListesi.size(); i++) {
            if (!myPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", myPage.urunlerElementListesi.get(i));
                Thread.sleep(1000);
                myPage.urunlerElementListesi.get(i).click();
                myPage.sepeteEkleButonu.click();
                count++;
                Driver.getDriver().navigate().back();
                Driver.getDriver().navigate().back();
                if (count == 5) break;
            }
        }
        //7. Sepetteki ürün miktarinin 5 oldugunu kontrol eder
        Assert.assertTrue(myPage.sepetimIkonu.getText().contains("5"));
        Driver.closeDriver();
    }

    @Test
    public void US03_TC03() throws InterruptedException {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        Thread.sleep(5000);
        //5. 'Hemen Basla' butonuna tiklar
        myPage.sepetimIkonu.click();
        myPage.sepetiGoruntule.click();
        jse.executeScript("arguments[0].scrollIntoView();", myPage.sepetiTemizle);
        Thread.sleep(1000);
        myPage.sepetiTemizle.click();
        myPage.tradylinnIkonu.click();
        myPage.hemenBaslaButonu.click();
        //6. Bir ürünü 'Sepete Ekle' butonuna tiklayarak sepete ekler
        for (int i = 0; i < myPage.urunlerElementListesi.size(); i++) {
            if (!myPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", myPage.urunlerElementListesi.get(i));
                Thread.sleep(1000);
                myPage.urunlerElementListesi.get(i).click();
                myPage.sepeteEkleButonu.click();
                break;
            }
        }
        //7. 'Sepetim' butonuna tiklar
        myPage.sepetimIkonu.click();
        //8. 'Sepeti Görüntüle' butonuna tiklar
        myPage.sepetiGoruntule.click();
        //9. Sepete gidildigini kontrol eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"));
        //10. 'Ödeme sayfasina git'e tiklar
        jse.executeScript("arguments[0].scrollIntoView();", myPage.odemeSayfasinaGitButonu);
        Thread.sleep(1000);
        myPage.odemeSayfasinaGitButonu.click();
        //11. checkout'a gidildigini kontrol eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout"));
        Driver.closeDriver();
    }
}
