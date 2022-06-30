package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_11_12_Page;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.Login.login;
import static tests.ReusableMethods.waitFor;


public class US11 extends TestBaseRapor {
    US_11_12_Page myPage;
    Actions actions;
    @Test
    public void US11_TC01() throws InterruptedException {
        myPage=new US_11_12_Page();
        actions=new Actions(Driver.getDriver());

        extentTest=extentReports.createTest("US11_TC01","Kullanici Urun Cesidini Secebilmeli");
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

       //4- Kullanici  Yeni Urun Ekle Butonuna Tiklar
        myPage.yeniUrunEkle.click();
        extentTest.info("Yeni Urun Ekle Butonuna Tiklandi");


        //5-"Kullanici Toptan Urun Gosterme Ayarlari
        //butonuna tiklar"
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
      myPage.toptanUrunGostermeAyarlariButonu.click();

        extentTest.info("Toptan Urun Gosterme Ayarlari Butonuna Tiklandi");
        Thread.sleep(5000);


        //6-Kullanici Urun cesidini secer
        Select select = new Select(myPage.urunCesidi);
        select.selectByValue("Carton");
        Thread.sleep(6000);
        extentTest.info("Urun Cesidi Secildi");

        //7-Kullanici Secilen Urun Cesidinin Girildigini Kontrol Eder
         String secilenUrunCesidi="Carton";
        Assert.assertTrue(myPage.urunCesidi.getAttribute("value").contains(secilenUrunCesidi));

        extentTest.pass("Urun Cesidi Basarili Bir Sekilde Secilebildi");



       Driver.closeDriver();


    }

    @Test
    public void US11_TC02() throws InterruptedException {
        myPage=new US_11_12_Page();
        actions=new Actions(Driver.getDriver());
        extentTest=extentReports.createTest("US11_TC02","Kullanici Units per piece  Secenegine Bir Deger Girebilmeli");
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

        //4- Kullanici  Yeni Urun Ekle Butonuna Tiklar
        myPage.yeniUrunEkle.click();
        extentTest.info("Yeni Urun Ekle Butonuna Tiklandi");


        //5-"Kullanici Toptan Urun Gosterme Ayarlari
        //butonuna tiklar"
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        myPage.toptanUrunGostermeAyarlariButonu.click();

        extentTest.info("Toptan Urun Gosterme Ayarlari Butonuna Tiklandi");
        Thread.sleep(5000);

        // 6-Kullanici Units per piece  secenegine bir deger girer
        myPage.unitsPerPiece.clear();
        myPage.unitsPerPiece.sendKeys("3");
        extentTest.info("Units Per Piece Secenegine Deger Girildi");

        Thread.sleep(6000);


        //7-Kullanici Girilen Degerin Units Per Piece  Seceneginde Gorundugunu Kontrol Eder
        String secilenUnitsPerPiece="3";
        Assert.assertTrue(myPage.unitsPerPiece.getAttribute("value").contains(secilenUnitsPerPiece));

        extentTest.pass("Units Per Piece Secenegine Bir Deger Girilebildi");

       Driver.closeDriver();

    }

    @Test
    public void US11_TC03() throws InterruptedException {
        myPage=new US_11_12_Page();
        actions=new Actions(Driver.getDriver());
        extentTest=extentReports.createTest("US11_TC03","Kullanici Minimum quantity  Secenegine Bir Deger Girebilmeli");
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

        //4- Kullanici  Yeni Urun Ekle Butonuna Tiklar
        myPage.yeniUrunEkle.click();
        extentTest.info("Yeni Urun Ekle Butonuna Tiklandi");


        //5-"Kullanici Toptan Urun Gosterme Ayarlari
        //butonuna tiklar"
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        myPage.toptanUrunGostermeAyarlariButonu.click();

        extentTest.info("Toptan Urun Gosterme Ayarlari Butonuna Tiklandi");
        Thread.sleep(5000);

        // 6-Kullanici Minimum quantity  secenegine bir deger girer
        myPage.minumumQuantity.clear();
        myPage.minumumQuantity.sendKeys("3");
        extentTest.info("Minumum Quantity Secenegine Deger Girildi");

        Thread.sleep(6000);

        //7-Kullanici Girilen Degerin Minumum Quantity Seceneginde Gorundugunu Kontrol Eder
        String secilenMinumumQuantity="3";
        Assert.assertTrue(myPage.minumumQuantity.getAttribute("value").contains(secilenMinumumQuantity));
        extentTest.pass("Minimum quantity  Secenegine Deger Girilebildi");
        Driver.closeDriver();
    }
}
