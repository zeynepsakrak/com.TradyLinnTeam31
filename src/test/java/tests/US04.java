package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_03_04_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static java.lang.Integer.parseInt;
import static tests.Login.login;
import static tests.ReusableMethods.*;


public class US04 extends TestBaseRapor {
    US_03_04_Page forthPage = new US_03_04_Page();

    @Test
    public void US04_TC01() {
        extentTest = extentReports.createTest("Sepet detaylari gorme", "Sepetteki urun detaylari goruntulenmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(8);
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        waitFor(11);
        forthPage.aramaMercegi.click();
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        //7. Urunun sepete eklendigini kontrol eder
        waitFor(2);
        Assert.assertEquals(forthPage.sepetimIkonu.getText().replace("Sepetim\n", ""), "1");
        //8. 'Sepetim' butonuna tiklar
        forthPage.sepetimIkonu.click();
        //9. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        //10. Fiyat miktar ve ara toplam degerlerinin goruldugunu kontrol eder
        Assert.assertTrue(forthPage.secilenUrunlerFiyatListesi.get(0).isDisplayed());
        Assert.assertTrue(forthPage.secilenUrunlerMiktarListesi.get(0).isDisplayed());
        Assert.assertTrue(forthPage.secilenUrunlerAraToplamListesi.get(0).isDisplayed());
        extentTest.info("Sepetteki urun fiyat, miktar ve ara toplam degerleri goruntuleendi");
        Driver.closeDriver();
    }

    @Test
    public void US04_TC02() {
        extentTest = extentReports.createTest("Urun miktari arttirma/azaltma", "Urun miktarlari arttirilip azaltilmalidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(8);
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        waitFor(11);
        forthPage.aramaMercegi.click();
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        //7. 'Sepetim' butonuna tiklar
        waitForVisibility(forthPage.sepetimIkonu, 15);
        //waitFor(2);
        forthPage.sepetimIkonu.click();
        //8. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        waitFor(2);
        //9. Miktar bolumundeki arti'ya tiklar
        int ilkMiktar = parseInt(forthPage.secilenUrunlerMiktarListesi.get(0).getAttribute("value"));
        forthPage.artiButonListesi.get(0).click();
        forthPage.sepetiYenileButonu.click();
        waitFor(3);
        int artmisMiktar = parseInt(forthPage.secilenUrunlerMiktarListesi.get(0).getAttribute("value"));
        //10. Urun miktarinin arttigini kontrol eder
        Assert.assertTrue(artmisMiktar > ilkMiktar);
        waitFor(2);
        //11. Miktar bolumundeki eksi'ye tiklar
        forthPage.eksiButonListesi.get(0).click();
        forthPage.sepetiYenileButonu.click();
        waitFor(3);
        int azalmisMiktar = parseInt(forthPage.secilenUrunlerMiktarListesi.get(0).getAttribute("value"));
        //12. Urun miktarinin eksildigini kontrol eder
        Assert.assertTrue(azalmisMiktar < artmisMiktar);
        extentTest.info("Urun miktarlari arttirilip azaltildi");
        Driver.closeDriver();
    }

    @Test
    public void US04_TC03() {
        extentTest = extentReports.createTest("Stok fazlasi urun ekleme", "Stoktan fazla urun eklenmemelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(8);
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        waitFor(11);
        forthPage.aramaMercegi.click();
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        //7. 'Sepetim' butonuna tiklar
        waitFor(2);
        forthPage.sepetimIkonu.click();
        //8. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        waitFor(1);
        //9. Miktar bolumundeki arti'ya tiklar
        int ilkMiktar = parseInt(forthPage.secilenUrunlerAraToplamListesi.get(0).getText().replaceAll("\\D+", ""));
        forthPage.artiButonListesi.get(0).click();
        //10. 'Sepeti Yenile'ye tiklayarak 'Ara toplam'in degistigini kontrol eder
        forthPage.sepetiYenileButonu.click();
        waitFor(3);
        int artmisMiktar = parseInt(forthPage.secilenUrunlerAraToplamListesi.get(0).getText().replaceAll("\\D+", ""));
        Assert.assertTrue(ilkMiktar < artmisMiktar);
        waitFor(3);
        //11.Urun miktarina stoktan fazla deger girer
        for (int i = 0; i < (Integer.parseInt(ConfigReader.getProperty("stokMiktari")) - 1); i++) {
            forthPage.artiButonListesi.get(0).click();
        }
        forthPage.sepetiYenileButonu.click();
        waitFor(3);
        //12. Stoktan fazla deger girilemedigini kontrol eder
        int artirmaSonrasi = parseInt(forthPage.secilenUrunlerMiktarListesi.get(0).getAttribute("value"));
        Assert.assertEquals(artirmaSonrasi, parseInt(ConfigReader.getProperty("stokMiktari")));
        //13.Urun miktarina gecerli bir deger girer
        waitFor(2);
        forthPage.eksiButonListesi.get(0).click();
        forthPage.sepetiTemizle.click();
        extentTest.info("Stoktan fazla urun eklenemedi");
        Driver.closeDriver();
    }

    @Test
    public void US04_TC04() {
        extentTest = extentReports.createTest("Sepeti bosaltma", "Sepet bosaltilabilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(8);
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        waitFor(11);
        forthPage.aramaMercegi.click();
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        //7. 'Sepetim' butonuna tiklar
        waitFor(2);
        forthPage.sepetimIkonu.click();
        //8. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        //9. 'Temizle' butonuna tiklar
        jse.executeScript("arguments[0].scrollIntoView();", forthPage.sepetiTemizle);
        waitFor(1);
        forthPage.sepetiTemizle.click();
        //10. Sepetteki urunlerin silindigini kontrol eder
        Assert.assertEquals(forthPage.sepetimIkonu.getText().replace("Sepetim\n", ""), "0");
        extentTest.info("Sepet bosaltildi");
        Driver.closeDriver();
    }

    @Test
    public void US04_TC05() {
        extentTest = extentReports.createTest("Coupon kullanma", "Coupon secenegi kullanilabilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(8);
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        waitFor(11);
        forthPage.aramaMercegi.click();
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        //7. 'Sepetim' butonuna tiklar
        waitFor(2);
        forthPage.sepetimIkonu.click();
        //8. 'Sepeti goruntule' butonuna tiklar
        waitFor(2);
        forthPage.sepetiGoruntule.click();
        //9. 'Kupon Discount' seceneginin ulasilabilir oldugunu kontrol eder
        Assert.assertTrue(forthPage.kuponKullanButonu.isEnabled());
        extentTest.info("Coupon secenegi kullanilabilirdir");
        Driver.closeDriver();
    }

    @Test
    public void US04_TC06() {
        extentTest = extentReports.createTest("Alisverise devam etme", "Sepetten alisveris sayfasina gidilebilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(8);
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        waitFor(11);
        forthPage.aramaMercegi.click();
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        //7. 'Sepetim' butonuna tiklar
        waitFor(2);
        forthPage.sepetimIkonu.click();
        //8. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        //9. 'Alisverise devam et' buttonunun ulasilabilir oldugunu kontrol eder
        Assert.assertTrue(forthPage.sepetimAlisveriseDevamEtButonu.isEnabled());
        extentTest.info("Sepetten alisveris sayfasina donuldu");
        Driver.closeDriver();
    }

    @Test
    public void US04_TC07() {
        extentTest = extentReports.createTest("Kargo bilgileri goruntuleme", "Kargo bilgileri goruntulenebilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        waitFor(5);
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        waitFor(11);
        forthPage.aramaMercegi.click();
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        //7. 'Sepetim' butonuna tiklar
        waitFor(2);
        forthPage.sepetimIkonu.click();
        //8. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        //9. 'Odeme Sayfasina Git'e tiklar
        forthPage.odemeSayfasinaGitButonu.click();
        //10. 'Fatura Detaylari ve Ara toplam tutari'nin gorntulendigini kontrol eder
        Assert.assertTrue(forthPage.faturaDetaylariTitle.isDisplayed());
        Assert.assertTrue(forthPage.odemeSayfasiAraToplam.isDisplayed());
        extentTest.info("Kargo bilgileri goruntulendi");
        Driver.closeDriver();
    }
}