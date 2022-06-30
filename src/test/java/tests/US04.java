package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_03_04_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static java.lang.Integer.parseInt;
import static tests.Login.login;


public class US04 extends TestBaseRapor {
    US_03_04_Page forthPage;

    @Test(priority = 1)
    public void US04_TC01() {
        forthPage = new US_03_04_Page();
        extentTest = extentReports.createTest("Sepet detaylari gorme", "Sepetteki urun detaylari goruntulenmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        ReusableMethods.waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        ReusableMethods.sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        ReusableMethods.waitFor(11);
        forthPage.aramaMercegi.click();
        extentTest.info("Arama bolumune istenen urunu girip arama butonuna tiklandi");
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        extentTest.info("Aranan urunu sepete eklendi");
        //7. Urunun sepete eklendigini kontrol eder
        ReusableMethods.waitFor(2);
        Assert.assertEquals(forthPage.sepetimIkonu.getText().replace("Sepetim\n", ""), "1");
        extentTest.info("Urunun sepete eklendigi kontrol edildi");
        //8. 'Sepetim' butonuna tiklar
        forthPage.sepetimIkonu.click();
        extentTest.info("Sepetim butonuna tiklandi");
        //9. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        extentTest.info("Sepeti goruntule butonuna tiklandi");
        //10. Fiyat miktar ve ara toplam degerlerinin goruldugunu kontrol eder
        Assert.assertTrue(forthPage.secilenUrunlerFiyatListesi.get(0).isDisplayed());
        Assert.assertTrue(forthPage.secilenUrunlerMiktarListesi.get(0).isDisplayed());
        Assert.assertTrue(forthPage.secilenUrunlerAraToplamListesi.get(0).isDisplayed());
        extentTest.pass("Fiyat miktar ve ara toplam degerlerinin goruldugunu kontrol edildi");
        Driver.closeDriver();
    }

    @Test(priority = 2)
    public void US04_TC02() {
        forthPage = new US_03_04_Page();
        extentTest = extentReports.createTest("Urun miktari arttirma/azaltma", "Urun miktarlari arttirilip azaltilmalidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        ReusableMethods.waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        ReusableMethods.sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        ReusableMethods.waitFor(11);
        forthPage.aramaMercegi.click();
        extentTest.info("Arama bolumune istenen urunu girip arama butonuna tiklandi");
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        extentTest.info("Aranan urunu sepete eklendi");
        //7. 'Sepetim' butonuna tiklar
        ReusableMethods.waitForVisibility(forthPage.sepetimIkonu, 15);
        //waitFor(2);
        forthPage.sepetimIkonu.click();
        extentTest.info("Sepetim butonuna tiklandi");
        //8. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        ReusableMethods.waitFor(2);
        extentTest.info("Sepeti goruntule butonuna tiklandi");
        //9. Miktar bolumundeki arti'ya tiklar
        int ilkMiktar = parseInt(forthPage.secilenUrunlerMiktarListesi.get(0).getAttribute("value"));
        forthPage.artiButonListesi.get(0).click();
        forthPage.sepetiYenileButonu.click();
        ReusableMethods.waitFor(3);
        int artmisMiktar = parseInt(forthPage.secilenUrunlerMiktarListesi.get(0).getAttribute("value"));
        extentTest.info("Miktar bolumundeki artiya tiklandi");
        //10. Urun miktarinin arttigini kontrol eder
        Assert.assertTrue(artmisMiktar > ilkMiktar);
        ReusableMethods.waitFor(2);
        extentTest.info("Urun miktarinin arttigini kontrol edildi");
        //11. Miktar bolumundeki eksi'ye tiklar
        forthPage.eksiButonListesi.get(0).click();
        forthPage.sepetiYenileButonu.click();
        ReusableMethods.waitFor(3);
        int azalmisMiktar = parseInt(forthPage.secilenUrunlerMiktarListesi.get(0).getAttribute("value"));
        extentTest.info("Miktar bolumundeki eksiye tiklandi");
        //12. Urun miktarinin eksildigini kontrol eder
        Assert.assertTrue(azalmisMiktar < artmisMiktar);
        extentTest.pass("Urun miktarinin eksildigi kontrol edildi");
        Driver.closeDriver();
    }

    @Test(priority = 3)
    public void US04_TC03() {
        forthPage = new US_03_04_Page();
        extentTest = extentReports.createTest("Stok fazlasi urun ekleme", "Stoktan fazla urun eklenmemelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        ReusableMethods.waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        ReusableMethods.sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        ReusableMethods.waitFor(11);
        forthPage.aramaMercegi.click();
        extentTest.info("Arama bolumune istenen urunu girip arama butonuna tiklandi");
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        extentTest.info("Aranan urunu sepete eklendi");
        //7. 'Sepetim' butonuna tiklar
        ReusableMethods.waitFor(2);
        forthPage.sepetimIkonu.click();
        extentTest.info("Sepetim butonuna tiklandi");
        //8. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        ReusableMethods.waitFor(1);
        extentTest.info("Sepeti goruntule butonuna tiklandi");
        //9. Miktar bolumundeki arti'ya tiklar
        int ilkMiktar = parseInt(forthPage.secilenUrunlerAraToplamListesi.get(0).getText().replaceAll("\\D+", ""));
        forthPage.artiButonListesi.get(0).click();
        extentTest.info("Miktar bolumundeki artiya tiklandi");
        //10. 'Sepeti Yenile'ye tiklayarak 'Ara toplam'in degistigini kontrol eder
        forthPage.sepetiYenileButonu.click();
        ReusableMethods.waitFor(3);
        int artmisMiktar = parseInt(forthPage.secilenUrunlerAraToplamListesi.get(0).getText().replaceAll("\\D+", ""));
        Assert.assertTrue(ilkMiktar < artmisMiktar);
        ReusableMethods.waitFor(3);
        extentTest.info("Sepeti Yenileye tiklayarak Ara toplamin degistigini kontrol edildi");
        //11.Urun miktarina stoktan fazla deger girer
        for (int i = 0; i < (Integer.parseInt(ConfigReader.getProperty("stokMiktari")) - 1); i++) {
            forthPage.artiButonListesi.get(0).click();
        }
        forthPage.sepetiYenileButonu.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Urun miktarina stoktan fazla deger girildi");
        //12. Stoktan fazla deger girilemedigini kontrol eder
        int artirmaSonrasi = parseInt(forthPage.secilenUrunlerMiktarListesi.get(0).getAttribute("value"));
        Assert.assertEquals(artirmaSonrasi, parseInt(ConfigReader.getProperty("stokMiktari")));
        extentTest.info("Stoktan fazla deger girilemedigini kontrol edildi");
        //13.Urun miktarina gecerli bir deger girer
        ReusableMethods.waitFor(3);
        forthPage.eksiButonListesi.get(0).click();
        forthPage.sepetiTemizle.click();
        extentTest.pass("Urun miktarina gecerli bir deger girildi");
        Driver.closeDriver();
    }

    @Test(priority = 4)
    public void US04_TC04() {
        forthPage = new US_03_04_Page();
        extentTest = extentReports.createTest("Sepeti bosaltma", "Sepet bosaltilabilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        ReusableMethods.waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        ReusableMethods.sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        ReusableMethods.waitFor(11);
        forthPage.aramaMercegi.click();
        extentTest.info("Arama bolumune istenen urunu girip arama butonuna tiklandi");
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        extentTest.info("Aranan urunu sepete eklendi");
        //7. 'Sepetim' butonuna tiklar
        ReusableMethods.waitFor(2);
        forthPage.sepetimIkonu.click();
        extentTest.info("Sepetim butonuna tiklandi");
        //8. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        extentTest.info("Sepeti goruntule butonuna tiklandi");
        //9. 'Temizle' butonuna tiklar
        ReusableMethods.jse.executeScript("arguments[0].scrollIntoView();", forthPage.sepetiTemizle);
        ReusableMethods.waitFor(1);
        forthPage.sepetiTemizle.click();
        extentTest.info("Temizle butonuna tiklandi");
        //10. Sepetteki urunlerin silindigini kontrol eder
        Assert.assertEquals(forthPage.sepetimIkonu.getText().replace("Sepetim\n", ""), "0");
        extentTest.pass("Sepetteki urunlerin silindigi kontrol edildi");
        Driver.closeDriver();
    }

    @Test(priority = 5)
    public void US04_TC05() {
        forthPage = new US_03_04_Page();
        extentTest = extentReports.createTest("Coupon kullanma", "Coupon secenegi kullanilabilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        ReusableMethods.waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        ReusableMethods.sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        ReusableMethods.waitFor(11);
        forthPage.aramaMercegi.click();
        extentTest.info("Arama bolumune istenen urunu girip arama butonuna tiklandi");
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        extentTest.info("Aranan urunu sepete eklendi");
        //7. 'Sepetim' butonuna tiklar
        ReusableMethods.waitFor(2);
        forthPage.sepetimIkonu.click();
        extentTest.info("Sepetim butonuna tiklandi");
        //8. 'Sepeti goruntule' butonuna tiklar
        ReusableMethods.waitFor(2);
        forthPage.sepetiGoruntule.click();
        extentTest.info("Sepeti goruntule butonuna tiklandi");
        //9. 'Kupon Discount' seceneginin ulasilabilir oldugunu kontrol eder
        Assert.assertTrue(forthPage.kuponKullanButonu.isEnabled());
        extentTest.pass("Kupon Discount seceneginin ulasilabilir oldugunu kontrol edildi");
        Driver.closeDriver();
    }

    @Test(priority = 6)
    public void US04_TC06() {
        forthPage = new US_03_04_Page();
        extentTest = extentReports.createTest("Alisverise devam etme", "Sepetten alisveris sayfasina gidilebilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        ReusableMethods.waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        ReusableMethods.sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        ReusableMethods.waitFor(11);
        forthPage.aramaMercegi.click();
        extentTest.info("Arama bolumune istenen urunu girip arama butonuna tiklandi");
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        extentTest.info("Aranan urunu sepete eklendi");
        //7. 'Sepetim' butonuna tiklar
        ReusableMethods.waitFor(2);
        forthPage.sepetimIkonu.click();
        extentTest.info("Sepetim butonuna tiklandi");
        //8. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        extentTest.info("Sepeti goruntule butonuna tiklandi");
        //9. 'Alisverise devam et' buttonunun ulasilabilir oldugunu kontrol eder
        Assert.assertTrue(forthPage.sepetimAlisveriseDevamEtButonu.isEnabled());
        extentTest.pass("Alisverise devam et buttonunun ulasilabilir oldugunu kontrol edildi");
        Driver.closeDriver();
    }

    @Test(priority = 7)
    public void US04_TC07() {
        forthPage = new US_03_04_Page();
        extentTest = extentReports.createTest("Kargo bilgileri goruntuleme", "Kargo bilgileri goruntulenebilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        ReusableMethods.waitFor(10);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        ReusableMethods.sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        ReusableMethods.waitFor(11);
        forthPage.aramaMercegi.click();
        extentTest.info("Arama bolumune istenen urunu girip arama butonuna tiklandi");
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        extentTest.info("Aranan urunu sepete eklendi");
        //7. 'Sepetim' butonuna tiklar
        ReusableMethods.waitFor(2);
        forthPage.sepetimIkonu.click();
        extentTest.info("Sepetim butonuna tiklandi");
        //8. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        extentTest.info("Sepeti goruntule butonuna tiklandi");
        //9. 'Odeme Sayfasina Git'e tiklar
        forthPage.odemeSayfasinaGitButonu.click();
        extentTest.info("Odeme Sayfasina Gite tiklandi");
        //10. 'Fatura Detaylari ve Ara toplam tutari'nin gorntulendigini kontrol eder
        Assert.assertTrue(forthPage.faturaDetaylariTitle.isDisplayed());
        Assert.assertTrue(forthPage.odemeSayfasiAraToplam.isDisplayed());
        extentTest.pass("Fatura Detaylari ve Ara toplam tutarinin goruntulendigi kontrol edildi");
        Driver.closeDriver();
    }
}