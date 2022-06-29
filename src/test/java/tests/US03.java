package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_03_04_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

import static tests.Login.login;
import static tests.ReusableMethods.*;


public class US03 extends TestBaseRapor {
    US_03_04_Page thirdPage = new US_03_04_Page();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void US03_TC01() {
        extentTest=extentReports.createTest("Urunlere gitme", "Urunlerden siparislere gidilmelidir");
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
        extentTest.info("Stoklardan siparislere gidildi");
        Driver.closeDriver();
    }

    @Test
    public void US03_TC02() {
        extentTest=extentReports.createTest("Sepete urun ekleme", "Secilen 5 urun sepete eklenmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(8);
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
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.sepeteEkleButonu);
                waitFor(1);
                thirdPage.sepeteEkleButonu.click();
                count++;
                Driver.getDriver().navigate().back();
                Driver.getDriver().navigate().back();
                if (count == 5) break;
            }
        }
        //7. Sepetteki ürün miktarinin 5 oldugunu kontrol eder
        Assert.assertEquals(thirdPage.sepetimIkonu.getText().replace("Sepetim\n", ""), "5");
        extentTest.info("Secilen 5 urun sepete eklendi");
        Driver.closeDriver();
    }

    @Test
    public void US03_TC03() {
        extentTest=extentReports.createTest("Sepete urun ekleme", "Secilen 5 urun sepete eklenmelidir");
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
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.sepeteEkleButonu);
                waitFor(1);
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
        extentTest.info("Sepetim sayfasina gidildi");
        //10. 'Ödeme sayfasina git'e tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.odemeSayfasinaGitButonu);
        waitFor(1);
        thirdPage.odemeSayfasinaGitButonu.click();
        //11. checkout'a gidildigini kontrol eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout"));
        extentTest.info("Checkout sayfasina gidildi");
        Driver.closeDriver();
    }

    @Test
    public void US03_TC04() {
        extentTest=extentReports.createTest("Siparise adres girme", "Tum adres bilgleri basarili girilmelidir");
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
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.sepeteEkleButonu);
                waitFor(1);
                thirdPage.sepeteEkleButonu.click();
                break;
            }
        }
        //7. 'Sepetim' butonuna tiklar
        thirdPage.sepetimIkonu.click();
        //8. 'Sepeti Görüntüle' butonuna tiklar
        thirdPage.sepetiGoruntule.click();
        //9. Kargo bilgilerini girer
        waitFor(1);

        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.korgoBilgileriSehirElementi);
        waitFor(3);

        thirdPage.korgoBilgileriSehirElementi.click();
        actions.click(thirdPage.korgoBilgileriSehirSearchElementi)
                .sendKeys(ConfigReader.getProperty("kargoBilgileriSehir") + Keys.ENTER).perform();
        actions.click(thirdPage.korgoBilgileriIlceElementi).keyDown(Keys.CONTROL).sendKeys("A")
                .keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .sendKeys(ConfigReader.getProperty("kargoBilgileriIlce")).perform();
        actions.click(thirdPage.korgoBilgileriPostaKoduElementi).keyDown(Keys.CONTROL).sendKeys("A")
                .keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .sendKeys(ConfigReader.getProperty("kargoBilgileriPostaKodu")).perform();
        //10. 'Fiyati Güncelle'ye tiklar
        thirdPage.fiyatiGuncelleButonu.click();
        waitForVisibility(thirdPage.fiyatiGuncelleButonu, 10);
        //11. Kargo bilgilerinin girildigini kontrol eder
        String expectedPostaKodu = ConfigReader.getProperty("kargoBilgileriPostaKodu");
        String text = thirdPage.gonderiAdresiTextElement.getText();
        System.out.println(text);
        System.out.println(expectedPostaKodu);
        Assert.assertTrue(thirdPage.gonderiAdresiTextElement.getText().contains(expectedPostaKodu));
        extentTest.info("Adres bilgileri girildi");
        Driver.closeDriver();
    }

    @Test
    public void US03_TC05() {
        extentTest=extentReports.createTest("Siparis verme", "Siparis verilebilmelidir");
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
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.sepeteEkleButonu);
                waitFor(1);
                thirdPage.sepeteEkleButonu.click();
                break;
            }
        }
        //7. 'Sepetim' butonuna tiklar
        thirdPage.sepetimIkonu.click();
        //8. 'Sepeti Görüntüle' butonuna tiklar
        thirdPage.sepetiGoruntule.click();
        //9. 'Odeme Sayfasina Git'e tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.odemeSayfasinaGitButonu);
        waitFor(1);
        thirdPage.odemeSayfasinaGitButonu.click();
        //10. 'Fatura Detaylarini' girer
        waitForVisibility(thirdPage.faturaDetaylariIsim, 15);
        actions.click(thirdPage.faturaDetaylariIsim)
                .keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .sendKeys("Ali").perform();
        actions.click(thirdPage.faturaDetaylariSoyisim)
                .keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .sendKeys("Bal").perform();
        actions.click(thirdPage.faturaDetaylariSokak)
                .keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .sendKeys("Gumus Sok.").perform();
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.faturaDetaylariPostaKodu);
        waitFor(1);
        actions.click(thirdPage.faturaDetaylariPostaKodu)
                .keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .sendKeys(ConfigReader.getProperty("kargoBilgileriPostaKodu")).perform();

        actions.click(thirdPage.faturaDetaylariIlce)
                .keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .sendKeys(ConfigReader.getProperty("kargoBilgileriIlce")).perform();
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.faturaDetaylariSehir);
        waitFor(1);
        thirdPage.faturaDetaylariSehir.click();
        actions.click(thirdPage.faturaDetaylariSehir)
                .sendKeys(ConfigReader.getProperty("kargoBilgileriSehir") + Keys.ENTER).perform();
        actions.click(thirdPage.faturaDetaylariTelefon)
                .keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .sendKeys(ConfigReader.getProperty("kargoBilgileriTelefon")).perform();
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.faturaDetaylariGonderiYeri);
        waitFor(1);
        actions.click(thirdPage.faturaDetaylariGonderiYeri)
                .keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE)
                .sendKeys(ConfigReader.getProperty("kargoBilgileriGonderiYeri")).perform();
        //11. 'Siparisi onaylaya' tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.siparisiOnaylaButonu);
        waitFor(1);
        //12. Fatura detaylarinin girildigini ve siparis verildigini kontrol eder
        Assert.assertTrue(thirdPage.siparisiOnaylaButonu.isDisplayed());
        extentTest.info("Fatura detaylari girildi");
        Driver.closeDriver();
    }
}