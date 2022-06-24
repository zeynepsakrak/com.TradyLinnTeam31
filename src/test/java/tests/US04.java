package tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.US_03_04_Page;
import utilities.ConfigReader;

import static tests.Login.login;
import static tests.ReusableMethods.sepetiBosalt;

public class US04 {

    @Test
    public void US04_TC01() throws InterruptedException {
        US_03_04_Page forthPage = new US_03_04_Page();
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        Thread.sleep(5000);
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        sepetiBosalt();
        forthPage.urunAramaKutusu.sendKeys(ConfigReader.getProperty("aranacakUrun"));
        forthPage.aramaMercegi.click();
        Thread.sleep(5000);
        //6. Aranan urunu sepete ekler
        forthPage.sepeteEkleButonu.click();
        //7. Urunun sepete eklendigini kontrol eder
        System.out.println(forthPage.sepetimIkonu.getText());
        //8. 'Sepetim' butonuna tiklar
        forthPage.sepetimIkonu.click();
        //9. 'Sepeti goruntule' butonuna tiklar
        forthPage.sepetiGoruntule.click();
        //10. Fiyat miktar ve ara toplam degerlerinin goruldugunu kontrol eder

    }

    @Test
    public void US04_TC02() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        //6. Aranan urunu sepete ekler
        //7. 'Sepetim' butonuna tiklar
        //8. 'Sepeti goruntule' butonuna tiklar
        //9. Miktar bolumundeki arti'ya tiklar
        //10. Urun miktarinin arttigini kontrol eder
        //11. Miktar bolumundeki eksi'ye tiklar
        //12. Urun miktarinin eksildigini kontrol eder
    }

    @Test
    public void US04_TC03() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        //6. Aranan urunu sepete ekler
        //7. 'Sepetim' butonuna tiklar
        //8. 'Sepeti goruntule' butonuna tiklar
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
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        //6. Aranan urunu sepete ekler
        //7. 'Sepetim' butonuna tiklar
        //8. 'Sepeti goruntule' butonuna tiklar
        //9. 'Temizle' butonuna tiklar
        //10. Sepetteki urunlerin silindigini kontrol eder
    }

    @Test
    public void US04_TC05() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        //6. Aranan urunu sepete ekler
        //7. 'Sepetim' butonuna tiklar
        //8. 'Sepeti goruntule' butonuna tiklar
        //9. 'Kupon Discount' seceneginin ulasilabilir oldugunu kontrol eder
    }

    @Test
    public void US04_TC06() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        //6. Aranan urunu sepete ekler
        //7. 'Sepetim' butonuna tiklar
        //8. 'Sepeti goruntule' butonuna tiklar
        //9. 'Alisverise devam et' buttonunun ulasilabilir oldugunu kontrol eder
    }

    @Test
    public void US04_TC07() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Kullanici Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        //5. 'Arama bolumu'ne istenen urunu girip arama butonuna basar
        //6. Aranan urunu sepete ekler
        //7. 'Sepetim' butonuna tiklar
        //8. 'Sepeti goruntule' butonuna tiklar
        //9. 'Odeme Sayfasina Git'e tiklar
        //10. 'Fatura Detaylari ve Ara toplam' tutarinin gorntulendigini kontrol eder
    }
}
