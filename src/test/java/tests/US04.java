package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_03_04_Page;
import utilities.ConfigReader;
import utilities.Driver;

import static tests.Login.login;
import static tests.ReusableMethods.*;

public class US04 {
    US_03_04_Page forthPage = new US_03_04_Page();

    @Test
    public void US04_TC01() {
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
        Driver.closeDriver();
    }

    @Test
    public void US04_TC02() {
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
        System.out.println(forthPage.secilenUrunlerMiktarListesi.get(0).getText());
        //9. Miktar bolumundeki arti'ya tiklar
        forthPage.secilenUrunlerMiktarListesi.get(0).sendKeys("5"+Keys.ENTER);
        forthPage.artiButonListesi.get(0).click();
        forthPage.sepetiYenileButonu.click();
        waitFor(5);
        //10. Urun miktarinin arttigini kontrol eder
        System.out.println(forthPage.secilenUrunlerMiktarListesi.get(0).getText());
        Assert.assertEquals(forthPage.secilenUrunlerMiktarListesi.get(0).getText(), "2");
        //11. Miktar bolumundeki eksi'ye tiklar
        forthPage.eksiButonListesi.get(0).click();
        //12. Urun miktarinin eksildigini kontrol eder
        Assert.assertEquals(forthPage.secilenUrunlerMiktarListesi.get(0).getText(), "1");
    }

    @Test
    public void US04_TC03() {
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
        //9. Miktar bolumundeki arti'ya tiklar
        //10. 'Sepeti Yenile'ye tiklayarak 'Ara toplam'in degistigini kontrol eder
        //11.Urun miktarina stoktan fazla deger girer
        //12. Stoktan fazla deger girilemedigini kontrol eder
        //13.Urun miktarina gecerli bir deger girer
    }

    @Test
    public void US04_TC04() {
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
        //9. 'Temizle' butonuna tiklar
        jse.executeScript("arguments[0].scrollIntoView();", forthPage.sepetiTemizle);
        waitFor(1);
        forthPage.sepetiTemizle.click();
        //10. Sepetteki urunlerin silindigini kontrol eder
        Assert.assertEquals(forthPage.sepetimIkonu.getText().replace("Sepetim\n", ""), "0");
        Driver.closeDriver();
    }

    @Test
    public void US04_TC05() {
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
        //9. 'Kupon Discount' seceneginin ulasilabilir oldugunu kontrol eder
        Assert.assertTrue(forthPage.kuponKullanButonu.isEnabled());
    }

    @Test
    public void US04_TC06() {
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
        //9. 'Alisverise devam et' buttonunun ulasilabilir oldugunu kontrol eder
        Assert.assertTrue(forthPage.sepetimAlisveriseDevamEtButonu.isEnabled());
        Driver.closeDriver();
    }

    @Test
    public void US04_TC07() {
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
        Driver.closeDriver();
        }


}
