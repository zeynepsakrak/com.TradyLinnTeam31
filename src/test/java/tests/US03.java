package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_03_04_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.Login.login;


public class US03 extends TestBaseRapor {
    US_03_04_Page thirdPage;
    JavascriptExecutor jse;
    Actions actions;

    @Test(priority = 1)
    public void US03_TC01() {
        thirdPage = new US_03_04_Page();
        jse = (JavascriptExecutor) Driver.getDriver();
        actions = new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("Urunlere gitme", "Urunlerden siparislere gidilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Hesabim'a tiklar
        ReusableMethods.waitFor(5);
        thirdPage.hesabimButonu.click();
        extentTest.info("Hesabima tiklandi");
        //6. 'Siparisler'e tiklar
        thirdPage.hesabimSiparislerButonu.click();
        extentTest.info("Siparislere tiklandi");
        //7. 'Ürünlere göz at/Alisverise devam et' tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.hesabimAlisveriseDevamEtButonu);
        ReusableMethods.waitFor(1);
        thirdPage.hesabimAlisveriseDevamEtButonu.click();
        extentTest.info("Ürünlere göz at/Alisverise devam et tiklandi");
        //8. Ürünlerin goruntulendigini kontrol eder
        Assert.assertTrue(thirdPage.urunlerElementListesi.size() != 0);
        extentTest.pass("Ürünlerin goruntulendi");
        Driver.closeDriver();
    }

    @Test(priority = 2)
    public void US03_TC02() {
        thirdPage = new US_03_04_Page();
        jse = (JavascriptExecutor) Driver.getDriver();
        actions = new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("Sepete urun ekleme", "Secilen 5 urun sepete eklenmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        ReusableMethods.waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Hemen Basla' butonuna tiklar
        ReusableMethods.sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        extentTest.info("Hemen Basla butonuna tiklandi");
        //6. Ilk 5 ürünü, 'Sepete Ekle' butonuna tiklayarak sepete ekler
        int count = 0;
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));
                ReusableMethods.waitFor(1);
                thirdPage.urunlerElementListesi.get(i).click();
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.sepeteEkleButonu);
                ReusableMethods.waitFor(1);
                thirdPage.sepeteEkleButonu.click();
                count++;
                Driver.getDriver().navigate().back();
                Driver.getDriver().navigate().back();
                if (count == 5) break;
            }
        }
        extentTest.info("Ilk 5 ürünü, Sepete Ekle butonuna tiklayarak sepete eklendi");
        //7. Sepetteki ürün miktarinin 5 oldugunu kontrol eder
        Assert.assertEquals(thirdPage.sepetimIkonu.getText().replace("Sepetim\n", ""), "5");
        extentTest.pass("Sepetteki ürün miktarinin 5 oldugunu kontrol edildi");
        Driver.closeDriver();
    }

    @Test(priority = 3)
    public void US03_TC03() {
        thirdPage = new US_03_04_Page();
        jse = (JavascriptExecutor) Driver.getDriver();
        actions = new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("Sepete urun ekleme", "Secilen 5 urun sepete eklenmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        ReusableMethods.waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Hemen Basla' butonuna tiklar
        ReusableMethods.sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        extentTest.info("Hemen Basla butonuna tiklandi");
        //6. Bir ürünü 'Sepete Ekle' butonuna tiklayarak sepete ekler
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));
                ReusableMethods.waitFor(1);
                thirdPage.urunlerElementListesi.get(i).click();
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.sepeteEkleButonu);
                ReusableMethods.waitFor(1);
                thirdPage.sepeteEkleButonu.click();
                break;
            }
        }
        extentTest.info("Bir ürünü Sepete Ekle butonuna tiklayarak sepete eklendi");
        //7. 'Sepetim' butonuna tiklar
        thirdPage.sepetimIkonu.click();
        extentTest.info("Sepetim butonuna tiklandi");
        //8. 'Sepeti Görüntüle' butonuna tiklar
        thirdPage.sepetiGoruntule.click();
        extentTest.info("Sepeti Görüntüle butonuna tiklandi");
        //9. Sepete gidildigini kontrol eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"));
        extentTest.info("Sepete gidildigi kontrol edildi");
        //10. 'Ödeme sayfasina git'e tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.odemeSayfasinaGitButonu);
        ReusableMethods.waitFor(1);
        thirdPage.odemeSayfasinaGitButonu.click();
        extentTest.info("Ödeme sayfasina gite tiklandi");
        //11. checkout'a gidildigini kontrol eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout"));
        extentTest.pass("checkouta gidildigi kontrol edildi");
        Driver.closeDriver();
    }

    @Test(priority = 4)
    public void US03_TC04() {
        thirdPage = new US_03_04_Page();
        jse = (JavascriptExecutor) Driver.getDriver();
        actions = new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("Siparise adres girme", "Tum adres bilgleri basarili girilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        ReusableMethods.waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Hemen Basla' butonuna tiklar
        ReusableMethods.sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        extentTest.info("Hemen Basla butonuna tiklandi");
        //6. Bir ürünü 'Sepete Ekle' butonuna tiklayarak sepete ekler
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));
                ReusableMethods.waitFor(1);
                thirdPage.urunlerElementListesi.get(i).click();
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.sepeteEkleButonu);
                ReusableMethods.waitFor(1);
                thirdPage.sepeteEkleButonu.click();
                break;
            }
        }
        extentTest.info("Bir ürünü Sepete Ekle butonuna tiklayarak sepete eklendi");
        //7. 'Sepetim' butonuna tiklar
        thirdPage.sepetimIkonu.click();
        extentTest.info("Sepetim butonuna tiklandi");
        //8. 'Sepeti Görüntüle' butonuna tiklar
        thirdPage.sepetiGoruntule.click();
        extentTest.info("Sepeti Görüntüle butonuna tiklandi");
        //9. Kargo bilgilerini girer
        ReusableMethods.waitFor(5);
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.odemeSayfasinaGitButonu);
        ReusableMethods.waitFor(1);
        thirdPage.odemeSayfasinaGitButonu.click();
        ReusableMethods.waitForVisibility(thirdPage.faturaDetaylariIsim, 15);
        actions.click(thirdPage.faturaDetaylariIsim).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys("Ali").perform();
        actions.click(thirdPage.faturaDetaylariSoyisim).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys("Bal").perform();
        actions.click(thirdPage.faturaDetaylariSokak).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys("Gumus Sok.").perform();
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.faturaDetaylariPostaKodu);
        ReusableMethods.waitFor(1);
        actions.click(thirdPage.faturaDetaylariPostaKodu).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys(ConfigReader.getProperty("kargoBilgileriPostaKodu")).perform();
        actions.click(thirdPage.faturaDetaylariIlce).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys(ConfigReader.getProperty("kargoBilgileriIlce")).perform();
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.faturaDetaylariSehir);
        ReusableMethods.waitFor(1);
        thirdPage.faturaDetaylariSehir.click();
        actions.click(thirdPage.faturaDetaylariSehir).sendKeys(ConfigReader.getProperty("kargoBilgileriSehir") + Keys.ENTER).perform();
        actions.click(thirdPage.faturaDetaylariTelefon).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys(ConfigReader.getProperty("kargoBilgileriTelefon")).perform();
        extentTest.info("Kargo detaylari girildi");
        //10. Kargo bilgilerinin girildigini kontrol eder
        Assert.assertTrue(thirdPage.siparisiOnaylaButonu.isEnabled());
        extentTest.pass("Kargo bilgilerinin girildigi kontrol edildi");
        Driver.closeDriver();
    }

    @Test(priority = 5)
    public void US03_TC05() {
        thirdPage = new US_03_04_Page();
        jse = (JavascriptExecutor) Driver.getDriver();
        actions = new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("Siparis verme", "Siparis verilebilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        ReusableMethods.waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Hemen Basla' butonuna tiklar
        ReusableMethods.sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        extentTest.info("Hemen Basla butonuna tiklandi");
        //6. Bir ürünü 'Sepete Ekle' butonuna tiklayarak sepete ekler
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));
                ReusableMethods.waitFor(1);
                thirdPage.urunlerElementListesi.get(i).click();
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.sepeteEkleButonu);
                ReusableMethods.waitFor(1);
                thirdPage.sepeteEkleButonu.click();
                break;
            }
        }
        extentTest.info("Bir ürünü Sepete Ekle butonuna tiklayarak sepete eklendi");
        //7. 'Sepetim' butonuna tiklar
        thirdPage.sepetimIkonu.click();
        extentTest.info("Sepetim butonuna tiklandi");
        //8. 'Sepeti Görüntüle' butonuna tiklar
        thirdPage.sepetiGoruntule.click();
        extentTest.info("Sepeti Görüntüle butonuna tiklandi");
        //9. 'Odeme Sayfasina Git'e tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.odemeSayfasinaGitButonu);
        ReusableMethods.waitFor(1);
        thirdPage.odemeSayfasinaGitButonu.click();
        extentTest.info("Odeme Sayfasina Gite tiklandi");
        //10. 'Fatura Detaylarini' girer
        ReusableMethods.waitForVisibility(thirdPage.faturaDetaylariIsim, 15);
        actions.click(thirdPage.faturaDetaylariIsim).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys("Ali").perform();
        actions.click(thirdPage.faturaDetaylariSoyisim).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys("Bal").perform();
        actions.click(thirdPage.faturaDetaylariSokak).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys("Gumus Sok.").perform();
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.faturaDetaylariPostaKodu);
        ReusableMethods.waitFor(1);
        actions.click(thirdPage.faturaDetaylariPostaKodu).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys(ConfigReader.getProperty("kargoBilgileriPostaKodu")).perform();

        actions.click(thirdPage.faturaDetaylariIlce).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys(ConfigReader.getProperty("kargoBilgileriIlce")).perform();
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.faturaDetaylariSehir);
        ReusableMethods.waitFor(1);
        thirdPage.faturaDetaylariSehir.click();
        actions.click(thirdPage.faturaDetaylariSehir).sendKeys(ConfigReader.getProperty("kargoBilgileriSehir") + Keys.ENTER).perform();
        actions.click(thirdPage.faturaDetaylariTelefon).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).sendKeys(ConfigReader.getProperty("kargoBilgileriTelefon")).perform();
        extentTest.info("Fatura Detaylarini girildi");
        //11. 'Siparisi onaylaya' tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.siparisiOnaylaButonu);
        ReusableMethods.waitFor(1);
        thirdPage.siparisiOnaylaButonu.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Siparisi onaylaya tiklandi");
        //12. Fatura detaylarinin girildigini ve siparis verildigini kontrol eder
        Assert.assertTrue(thirdPage.tesekkurlerYaziElementi.isDisplayed());
        extentTest.pass("Fatura detaylarinin girildigi ve siparis verildigi kontrol edildi");
        Driver.closeDriver();
    }
}