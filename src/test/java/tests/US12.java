package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_11_12_Page;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.Login.login;
import static tests.ReusableMethods.waitFor;

public class US12 extends TestBaseRapor {
    US_11_12_Page myPage=new US_11_12_Page();
    @Test
    public void US12_TC01(){
        extentTest=extentReports.createTest("Siparisler","Siparisler Listelenebilmeli");

        //1-Kullanici vendor olarak hesabina gider
        login();
        waitFor(8);
        myPage.hesabimButonu.click();
        extentTest.info("Vendor Olarak Hesaba Girildi");

        //2-Kullanici siparisler butonuna tiklar

        myPage.siparislerButonu.click();

        extentTest.info("Siparisler Butonu Tiklandi");
        //3-Kullanici siparislerin listelendigini kontrol eder
        Assert.assertTrue(myPage.siparislerListesi.size()!=0);
        Driver.closeDriver();
        extentTest.info("Siparisler Basarili Bir Sekilde Listelendi");

    }
    @Test
    public void US12_TC02(){
        extentTest=extentReports.createTest("Indirilecek Urunler","İndirilecek Urunler Listelenebilmeli");
      //  1-Kullanici vendor olarak hesabina gider
        login();
        waitFor(8);
        myPage.hesabimButonu.click();
        extentTest.info("Vendor Olarak Hesaba Girildi");


      //  2-Kullanici Indirmeler butonuna tiklar
        myPage.indirmelerButonu.click();
        extentTest.info("Indirmeler Butonu Tiklandi");
      //  3-Kullanici indirilecek urunlerin listesinin goruntulendigini kontrol eder
        Assert.assertTrue(myPage.indirmelerListesi.size()!=0);

        extentTest.info("İndirilecek Urunler Listesi Basarili Bir Sekilde Listelenebildi");
        Driver.closeDriver();
    }
    @Test

    public void US12_TC03(){
        extentTest=extentReports.createTest("Fatura ve Gonderim Adresi","Fatura Adresi ve Gonderim Adresi Goruntulenmeli");
       // 1-Kullanici vendor olarak hesabina gider
        login();
        waitFor(8);
        myPage.hesabimButonu.click();
        extentTest.info("Vendor Olarak Hesaba Girildi");
       // 2-Kullanici Adresler butonuna tiklar
        myPage.adreslerButonu.click();
        extentTest.info("Indirmeler Butonu Tiklandi");

       // 3-Kullanici Fatura adresi ve gonderim adresinin goruntulendigini kontrol eder
        Assert.assertTrue(myPage.faturaGonderimAdresi.isDisplayed());
        Assert.assertFalse(myPage.faturaAdres.isEmpty());
        for (int i = 0; i < myPage.faturaAdres.size(); i++) {
            Assert.assertFalse(myPage.faturaAdres.isEmpty());

        }

        extentTest.info("Fatura Adresi ve Gonderim Adresi Basarili Bir Sekilde Goruntulendi");
        Driver.closeDriver();
    }
      @Test
    public void US12_TC04(){
          extentTest=extentReports.createTest("Hesap Detaylari","Hesap Bilgileri ve Eposta Adresi Goruntulenebilmeli," +
                  "Kullanici Hesap Bigilerinde Degisiklik Yapabilmeli");

       // 1-Kullanici vendor olarak hesabina gider
        login();
        waitFor(8);
        myPage.hesabimButonu.click();
          extentTest.info("Vendor Olarak Hesaba Girildi");

       // 2-Kullanici Hesap Detaylari butonuna tiklar
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        myPage.hesapDetaylariButonu.click();
          extentTest.info("Hesap Detaylari Butonu Tiklandi");

        // 3-Kullanici hesap bilgisi ve eposta adresinin goruntulendigini kontrol eder
        Assert.assertTrue(myPage.hesapDetaylariAd.isDisplayed());
        Assert.assertTrue(myPage.hesapDetaylariSoyad.isDisplayed());
        Assert.assertTrue(myPage.hesapDetaylariGorunenAd.isDisplayed());
        Assert.assertTrue(myPage.hesapDetaylariEmail.isDisplayed());
          extentTest.info("Hesap Bilgileri ve Eposta Adresi  Goruntulendi");


        // 4-Kullanici hesap  bilgilerinde degisiklik yapar

        Faker faker=new Faker();
        myPage.hesapDetaylariAd.clear();
        myPage.hesapDetaylariAd.sendKeys(faker.name().firstName());

        myPage.hesapDetaylariSoyad.clear();
        myPage.hesapDetaylariSoyad.sendKeys(faker.name().lastName());

        myPage.hesapDetaylariGorunenAd.clear();
        myPage.hesapDetaylariGorunenAd.sendKeys(faker.name().fullName());
          extentTest.info("Hesap Bilgilerinde Degisiklik Yapildi");



        // 5-Kullanici degisiklikleri kaydet butonuna tiklar
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",myPage.degisklikleriKaydetButonu);
        js.executeScript("arguments[0].click();", myPage.degisklikleriKaydetButonu);

          extentTest.info("Degisiklikleri Kaydet Butonuna Tiklandi");




        // 6-Kullanici Hesap bilgileri başarıyla değiştirildi yazisinin goruntulendigini kontrol eder

        Assert.assertTrue(myPage.hesapBigileriDegistirildiYazisi.isDisplayed());

          extentTest.info("Kullanici Hesap Bigilerinde Degisiklik Yapildi");

          Driver.closeDriver();
    }

}
