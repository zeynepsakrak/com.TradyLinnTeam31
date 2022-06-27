package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_03_04_Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

import static tests.Login.login;
import static tests.ReusableMethods.sepetiBosalt;
import static tests.ReusableMethods.waitFor;

public class US03 {
    US_03_04_Page thirdPage = new US_03_04_Page();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void US03_TC01() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        //5. 'Hesabim'a tiklar
        waitFor(5);
        thirdPage.hesabimButonu.click();
        //6. 'Siparisler'e tiklar
        thirdPage.hesabimSiparislerButonu.click();
        //7. 'Ürünlere göz at/Alisverise devam et' tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.hesabimAlisveriseDevamEtButonu);
        waitFor(1);
        thirdPage.hesabimAlisveriseDevamEtButonu.click();
        //8. Ürünlerin goruntulendigini kontrol eder
        Assert.assertTrue(thirdPage.urunlerElementListesi.size() != 0);
        Driver.closeDriver();
    }

    @Test
    public void US03_TC02() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(5);
        //5. 'Hemen Basla' butonuna tiklar
        sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        //6. Ilk 5 ürünü, 'Sepete Ekle' butonuna tiklayarak sepete ekler
        int count = 0;
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));
                waitFor(1);
                thirdPage.urunlerElementListesi.get(i).click();
                thirdPage.sepeteEkleButonu.click();
                count++;
                Driver.getDriver().navigate().back();
                Driver.getDriver().navigate().back();
                if (count == 5) break;
            }
        }
        //7. Sepetteki ürün miktarinin 5 oldugunu kontrol eder
        Assert.assertEquals(thirdPage.sepetimIkonu.getText().replace("Sepetim\n", ""), "5");
        Driver.closeDriver();
    }

    @Test
    public void US03_TC03() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(8);
        //5. 'Hemen Basla' butonuna tiklar
        sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        //6. Bir ürünü 'Sepete Ekle' butonuna tiklayarak sepete ekler
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));
                waitFor(1);
                thirdPage.urunlerElementListesi.get(i).click();
                thirdPage.sepeteEkleButonu.click();
                break;
            }
        }
        //7. 'Sepetim' butonuna tiklar
        thirdPage.sepetimIkonu.click();
        //8. 'Sepeti Görüntüle' butonuna tiklar
        thirdPage.sepetiGoruntule.click();
        //9. Sepete gidildigini kontrol eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"));
        //10. 'Ödeme sayfasina git'e tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.odemeSayfasinaGitButonu);
        waitFor(1);
        thirdPage.odemeSayfasinaGitButonu.click();
        //11. checkout'a gidildigini kontrol eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout"));
        Driver.closeDriver();
    }

    @Test
    public void US03_TC04() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(5);
        //5. 'Hemen Basla' butonuna tiklar
        sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        //6. Bir ürünü 'Sepete Ekle' butonuna tiklayarak sepete ekler
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));
                waitFor(1);
                thirdPage.urunlerElementListesi.get(i).click();
                thirdPage.sepeteEkleButonu.click();
                break;
            }
        }
        //7. 'Sepetim' butonuna tiklar
        thirdPage.sepetimIkonu.click();
        //8. 'Sepeti Görüntüle' butonuna tiklar
        thirdPage.sepetiGoruntule.click();
        //9. Kargo bilgilerini girer
        //Select select = new Select(myPage.korgoBilgileriSehirElementi);
        //Thread.sleep(1000);
        //select.selectByVisibleText("Adana");

        //myPage.korgoBilgileriSehirElementi.sendKeys("Adana");
        waitFor(1);
        thirdPage.korgoBilgileriIlceElementi.sendKeys("Ceyhan");
        thirdPage.korgoBilgileriPostaKoduElementi.sendKeys("01270");
        //10. 'Fiyati Güncelle'ye tiklar
        thirdPage.fiyatiGuncelleButonu.click();
        //11. Kargo bilgilerinin girildigini kontrol eder
        String expectedResult = "Sehitkamil";
        String actualResult = thirdPage.korgoBilgileriIlceElementi.getText();
        Assert.assertEquals(expectedResult, actualResult);
        //12. 'Temizle' butonuna tiklar
        thirdPage.sepetiTemizle.click();
    }

    @Test
    public void US03_TC05() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(5);
        //5. 'Hemen Basla' butonuna tiklar
        sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        //6. Bir ürünü 'Sepete Ekle' butonuna tiklayarak sepete ekler
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));
                waitFor(1);
                thirdPage.urunlerElementListesi.get(i).click();
                thirdPage.sepeteEkleButonu.click();
                break;
            }
        }
        //7. 'Sepetim' butonuna tiklar
        thirdPage.sepetimIkonu.click();
        //8. 'Sepeti Görüntüle' butonuna tiklar
        thirdPage.sepetiGoruntule.click();
        //9. 'Odeme Sayfasina Git'e tiklar
        thirdPage.odemeSayfasinaGitButonu.click();
        //10. 'Fatura Detaylarini' girer
        //11. 'Siparisi onaylaya' tiklar
        //12. Fatura detaylarinin girildigini ve siparis verildigini kontrol eder

    }
}