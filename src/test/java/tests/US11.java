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
        extentTest=extentReports.createTest("US11_TC01","Kullanici Urun Cesidini Secebilmeli");
        //1-Kullanici vendor olarak hesabina gider
        login();
        waitFor(8);
        myPage.hesabimButonu.click();
        //2- Kullanici Store Manager butonuna tiklar
        myPage.storeManagerButonu.click();
        //3- Kullanici Urunler butonuna tiklar
        myPage.urunlerButonu.click();

        //4-Kullanici Urunlerin listelendigini kontrol eder
        Assert.assertTrue(myPage.urunlerListesi.size() != 0);

        //5-Kullanici ilk urune tiklar
        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js1.executeScript("arguments[0].scrollIntoView(true);", myPage.ilkUrun);


        js1.executeScript("arguments[0].click();", myPage.ilkUrun);


        //6-"Kullanici Toptan Ürün Gösterme Ayarları
        //butonuna tiklar"
        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js2.executeScript("arguments[0].scrollIntoView(true);", myPage.toptanUrunGostermeAyarlariButonu);


        js2.executeScript("arguments[0].click();", myPage.toptanUrunGostermeAyarlariButonu);

        //7-Kullanici Toptan Ürün Gösterme Ayarları
        //bolumunun goruntulendigini kontrol eder"

        Assert.assertTrue(myPage.toptanUrunGostermeMenusu.isDisplayed());
        //8-Kullanici Urun cesidini secer


        Select select = new Select(myPage.urunCesidi);
        select.selectByValue("Carton");
        Thread.sleep(6000);


        //9-Kullanici submit butonuna tiklar


        myPage.submitButonu.click();

        //10-Kullanici Product Successfully Published yazisinin goruntulendigini kontrol eder
        Thread.sleep(5000);
        Assert.assertTrue(myPage.productSuccessfullyPublished.isDisplayed());

        Driver.closeDriver();
        extentTest.info("Urun Cesidi Basarili Bir Sekilde Secilebildi");

    }

    @Test
    public void US11_TC02() throws InterruptedException {
        extentTest=extentReports.createTest("US11_TC02","Kullanici Units per piece  Secenegine Bir Deger Girebilmeli");
        //1-Kullanici vendor olarak hesabina gider
        login();
        waitFor(6);
        myPage.hesabimButonu.click();
        //2- Kullanici Store Manager butonuna tiklar
        myPage.storeManagerButonu.click();
        //3- Kullanici Urunler butonuna tiklar
        myPage.urunlerButonu.click();

        //4-Kullanici Urunlerin listelendigini kontrol eder
        Assert.assertTrue(myPage.urunlerListesi.size() != 0);

        //5-Kullanici ilk urune tiklar
        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js1.executeScript("arguments[0].scrollIntoView(true);", myPage.ilkUrun);


        js1.executeScript("arguments[0].click();", myPage.ilkUrun);


        //6-"Kullanici Toptan Ürün Gösterme Ayarları
        //butonuna tiklar"
       JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js2.executeScript("arguments[0].scrollIntoView(true);", myPage.toptanUrunGostermeAyarlariButonu);


       js2.executeScript("arguments[0].click();", myPage.toptanUrunGostermeAyarlariButonu);

        //7-Kullanici Toptan Ürün Gösterme Ayarları
        //bolumunun goruntulendigini kontrol eder"

        Assert.assertTrue(myPage.toptanUrunGostermeMenusu.isDisplayed());
        // 8-Kullanici Units per piece  secenegine bir deger girer

        myPage.unitsPerPiece.clear();
        myPage.unitsPerPiece.sendKeys("2");

        Thread.sleep(6000);


        //9-Kullanici submit butonuna tiklar

        myPage.submitButonu.click();

        //10-Kullanici Product Successfully Published yazisinin goruntulendigini kontrol eder
        Thread.sleep(5000);
        Assert.assertTrue(myPage.productSuccessfullyPublished.isDisplayed());

        Driver.closeDriver();
        extentTest.info("Units per piece  Secenegine Deger Girilebildi");
    }

    @Test
    public void US11_TC03() throws InterruptedException {
        extentTest=extentReports.createTest("US11_TC03","Kullanici Minimum quantity  Secenegine Bir Deger Girebilmeli");
        //1-Kullanici vendor olarak hesabina gider
        login();
        waitFor(8);
        myPage.hesabimButonu.click();
        //2- Kullanici Store Manager butonuna tiklar
        myPage.storeManagerButonu.click();
        //3- Kullanici Urunler butonuna tiklar
        myPage.urunlerButonu.click();

        //4-Kullanici Urunlerin listelendigini kontrol eder
        Assert.assertTrue(myPage.urunlerListesi.size() != 0);

        //5-Kullanici ilk urune tiklar
        JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
        js1.executeScript("arguments[0].scrollIntoView(true);", myPage.ilkUrun);


        js1.executeScript("arguments[0].click();", myPage.ilkUrun);


        //6-"Kullanici Toptan Ürün Gösterme Ayarları
        //butonuna tiklar"
        JavascriptExecutor js2 = (JavascriptExecutor) Driver.getDriver();
        js2.executeScript("arguments[0].scrollIntoView(true);", myPage.toptanUrunGostermeAyarlariButonu);


        js2.executeScript("arguments[0].click();", myPage.toptanUrunGostermeAyarlariButonu);

        //7-Kullanici Toptan Ürün Gösterme Ayarları
        //bolumunun goruntulendigini kontrol eder"

        Assert.assertTrue(myPage.toptanUrunGostermeMenusu.isDisplayed());
        // 8-Kullanici Minimum quantity  secenegine bir deger girer
        myPage.minumumQuantity.clear();
        myPage.minumumQuantity.sendKeys("1");

        Thread.sleep(6000);


        //9-Kullanici submit butonuna tiklar

        myPage.submitButonu.click();

        //10-Kullanici Product Successfully Published yazisinin goruntulendigini kontrol eder
        Thread.sleep(5000);
        Assert.assertTrue(myPage.productSuccessfullyPublished.isDisplayed());
        Driver.closeDriver();
        extentTest.info("Minimum quantity  Secenegine Deger Girilebildi");
    }
}
