package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_11_12_Page;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.Login.login;
import static tests.ReusableMethods.waitFor;

public class US11 extends TestBaseRapor {
    US_11_12_Page myPage = new US_11_12_Page();

    @Test
    public void US11_TC01() throws InterruptedException {
        extentTest=extentReports.createTest("Urun Cesidi","Kullanici Urun Cesidini Secebilmeli");
        //1-Kullanici vendor olarak hesabina gider
        login();
        waitFor(8);
        myPage.hesabimButonu.click();
        extentTest.info("Vendor Olarak Hesaba Girildi");


        //2- Kullanici Store Manager butonuna tiklar
        myPage.storeManagerButonu.click();
        extentTest.info("Store Manager Butonuna Tiklandi");

        //3- Kullanici Urunler butonuna tiklar
        myPage.urunlerButonu.click();
        extentTest.info("Urunler Butonuna Tiklandi");

        //4-Kullanici Urunlerin listelendigini kontrol eder
        Assert.assertTrue(myPage.urunlerListesi.size() != 0);
        extentTest.info("Urunlerin Listelendigi Goruldu");


        //5-Kullanici ilk urune tiklar
        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js1.executeScript("arguments[0].scrollIntoView(true);", myPage.ilkUrun);
        js1.executeScript("arguments[0].click();", myPage.ilkUrun);
        extentTest.info("Ilk Urune Tiklandi");


        //6-"Kullanici Toptan Urun Gosterme Ayarlari
        //butonuna tiklar"
        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js2.executeScript("arguments[0].scrollIntoView(true);", myPage.toptanUrunGostermeAyarlariButonu);
        js2.executeScript("arguments[0].click();", myPage.toptanUrunGostermeAyarlariButonu);
        extentTest.info("Toptan Urun Gosterme Ayarlari Butonuna Tiklandi");

        //7-Kullanici Toptan Ürün Gösterme Ayarları
        //bolumunun goruntulendigini kontrol eder"

        Assert.assertTrue(myPage.toptanUrunGostermeMenusu.isDisplayed());
        extentTest.info("Toptan Urun Gosterme Ayarlari Menusu Goruntulendi");

        //8-Kullanici Urun cesidini secer


        Select select = new Select(myPage.urunCesidi);
        select.selectByValue("Carton");
        Thread.sleep(6000);
        extentTest.info("Urun Cesidi Secildi");


        //9-Kullanici submit butonuna tiklar
        myPage.submitButonu.click();
        extentTest.info("Submit Butonuna Tiklandi");
        Thread.sleep(6000);
        //10-Kullanici Secilen Urun Cesidinin Girildigini Kontrol Eder
         String secilenUrunCesidi="Carton";
        Assert.assertTrue(myPage.urunCesidi.getAttribute("value").contains(secilenUrunCesidi));

        extentTest.info("Urun Cesidi Basarili Bir Sekilde Secilebildi");



       Driver.closeDriver();


    }

    @Test
    public void US11_TC02() throws InterruptedException {
        extentTest=extentReports.createTest("Units Per Piece","Kullanici Units per piece  Secenegine Bir Deger Girebilmeli");
        //1-Kullanici vendor olarak hesabina gider
        login();
        waitFor(8);
        myPage.hesabimButonu.click();
        extentTest.info("Vendor Olarak Hesaba Girildi");


        //2- Kullanici Store Manager butonuna tiklar
        myPage.storeManagerButonu.click();
        extentTest.info("Store Manager Butonuna Tiklandi");

        //3- Kullanici Urunler butonuna tiklar
        myPage.urunlerButonu.click();
        extentTest.info("Urunler Butonuna Tiklandi");

        //4-Kullanici Urunlerin listelendigini kontrol eder
        Assert.assertTrue(myPage.urunlerListesi.size() != 0);
        extentTest.info("Urunlerin Listelendigi Goruldu");


        //5-Kullanici ilk urune tiklar
        JavascriptExecutor js3 = (JavascriptExecutor) Driver.getDriver();
        js3.executeScript("arguments[0].scrollIntoView(true);", myPage.ilkUrun);
        js3.executeScript("arguments[0].click();", myPage.ilkUrun);
        extentTest.info("Ilk Urune Tiklandi");


        //6-"Kullanici Toptan Urun Gosterme Ayarlari
        //butonuna tiklar"
        JavascriptExecutor js4 = (JavascriptExecutor) Driver.getDriver();
        js4.executeScript("arguments[0].scrollIntoView(true);", myPage.toptanUrunGostermeAyarlariButonu);
        js4.executeScript("arguments[0].click();", myPage.toptanUrunGostermeAyarlariButonu);
        extentTest.info("Toptan Urun Gosterme Ayarlari Butonuna Tiklandi");

        //7-Kullanici Toptan Ürün Gösterme Ayarları
        //bolumunun goruntulendigini kontrol eder"

        Assert.assertTrue(myPage.toptanUrunGostermeMenusu.isDisplayed());
        extentTest.info("Toptan Urun Gosterme Ayarlari Menusu Goruntulendi");


        // 8-Kullanici Units per piece  secenegine bir deger girer
        myPage.unitsPerPiece.clear();
        myPage.unitsPerPiece.sendKeys("3");
        extentTest.info("Units Per Piece Secenegine Deger Girildi");

        Thread.sleep(6000);


        //9-Kullanici submit butonuna tiklar
        JavascriptExecutor js5 = (JavascriptExecutor) Driver.getDriver();
        js5.executeScript("arguments[0].scrollIntoView(true);", myPage.submitButonu);
        js5.executeScript("arguments[0].click();", myPage.submitButonu);


        extentTest.info("Submit Butonuna Tiklandi");
        Thread.sleep(6000);

        //10-Kullanici Girilen Degerin Units Per Piece  Seceneginde Gorundugunu Kontrol Eder
        String secilenUnitsPerPiece="3";
        Assert.assertTrue(myPage.unitsPerPiece.getAttribute("value").contains(secilenUnitsPerPiece));

        extentTest.info("Urun Cesidi Basarili Bir Sekilde Secilebildi");

       Driver.closeDriver();

    }

    @Test
    public void US11_TC03() throws InterruptedException {
        extentTest=extentReports.createTest("Minumum Quantity","Kullanici Minimum quantity  Secenegine Bir Deger Girebilmeli");
        //1-Kullanici vendor olarak hesabina gider
        login();
        waitFor(8);
        myPage.hesabimButonu.click();
        extentTest.info("Vendor Olarak Hesaba Girildi");

        //2- Kullanici Store Manager butonuna tiklar
        myPage.storeManagerButonu.click();
        extentTest.info("Store Manager Butonuna Tiklandi");

        //3- Kullanici Urunler butonuna tiklar
        myPage.urunlerButonu.click();
        extentTest.info("Urunler Butonuna Tiklandi");

        //4-Kullanici Urunlerin listelendigini kontrol eder
        Assert.assertTrue(myPage.urunlerListesi.size() != 0);
        extentTest.info("Urunlerin Listelendigi Goruldu");

        //5-Kullanici ilk urune tiklar
        JavascriptExecutor js6 = (JavascriptExecutor) Driver.getDriver();
        js6.executeScript("arguments[0].scrollIntoView(true);", myPage.ilkUrun);
        js6.executeScript("arguments[0].click();", myPage.ilkUrun);
        extentTest.info("Ilk Urune Tiklandi");

        //6-"Kullanici Toptan Ürün Gösterme Ayarları
        //butonuna tiklar"
        JavascriptExecutor js7 = (JavascriptExecutor) Driver.getDriver();
        js7.executeScript("arguments[0].scrollIntoView(true);", myPage.toptanUrunGostermeAyarlariButonu);
        js7.executeScript("arguments[0].click();", myPage.toptanUrunGostermeAyarlariButonu);
        extentTest.info("Toptan Urun Gosterme Ayarlari Butonuna Tiklandi");

        //7-Kullanici Toptan Ürün Gösterme Ayarları
        //bolumunun goruntulendigini kontrol eder"
        Assert.assertTrue(myPage.toptanUrunGostermeMenusu.isDisplayed());
        extentTest.info("Toptan Urun Gosterme Ayarlari Menusu Goruntulendi");

        // 8-Kullanici Minimum quantity  secenegine bir deger girer
        myPage.minumumQuantity.clear();
        myPage.minumumQuantity.sendKeys("3");
        extentTest.info("Minumum Quantity Secenegine Deger Girildi");

        Thread.sleep(6000);


        //9-Kullanici submit butonuna tiklar
        JavascriptExecutor js8 = (JavascriptExecutor) Driver.getDriver();
        js8.executeScript("arguments[0].scrollIntoView(true);", myPage.submitButonu);
        js8.executeScript("arguments[0].click();", myPage.submitButonu);
        extentTest.info("Submit Butonuna Tiklandi");
        Thread.sleep(8000);
        //10-Kullanici Girilen Degerin Minumum Quantity Seceneginde Gorundugunu Kontrol Eder
        String secilenMinumumQuantity="3";
        Assert.assertTrue(myPage.unitsPerPiece.getAttribute("value").contains(secilenMinumumQuantity));
        extentTest.info("Minimum quantity  Secenegine Deger Girilebildi");
        Driver.closeDriver();
    }
}
