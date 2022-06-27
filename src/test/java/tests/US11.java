package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_11_12_Page;
import utilities.Driver;

import static tests.Login.login;
import static tests.ReusableMethods.waitFor;

public class US11 {
   US_11_12_Page myPage=new US_11_12_Page();

   @Test
   public void US11_TC01(){
       //1-Kullanici vendor olarak hesabina gider
       login();
       waitFor(8);
       myPage.hesabimButonu.click();
       //2- Kullanici Store Manager butonuna tiklar
       myPage.storeManagerButonu.click();
       //3- Kullanici Urunler butonuna tiklar
       myPage.urunlerButonu.click();

       //4-Kullanici Urunlerin listelendigini kontrol eder
       Assert.assertTrue(myPage.urunlerListesi.size()!=0);

       //5-Kullanici ilk urune tiklar
       JavascriptExecutor js1 = (JavascriptExecutor) Driver.getDriver();
       js1.executeScript("arguments[0].scrollIntoView(true);",myPage.ilkUrun);


       js1.executeScript("arguments[0].click();", myPage.ilkUrun);


       //6-"Kullanici Toptan Ürün Gösterme Ayarları
       //butonuna tiklar"

       //7-Kullanici Toptan Ürün Gösterme Ayarları
       //bolumunun goruntulendigini kontrol eder"
       //8-Kullanici Urun cesidini secer
       //9-Kullanici submit butonuna tiklar
       //10-Kullanici Product Successfully Published yazisinin goruntulendigini kontrol eder
   }
   @Test
    public void unitsPerPiece(){
      // 1-Kullanici vendor olarak hesabina gider
      // 2- Kullanici Store Manager butonuna tiklar
      // 3- Kullanici Urunler butonuna tiklar
      // 4-Kullanici Urunlerin listelendigini kontrol eder
      // 5-Kullanici ilk urune tiklar
      // "6-Kullanici Toptan Ürün Gösterme Ayarları
      // butonuna tiklar"
      // "7-Kullanici Toptan Ürün Gösterme Ayarları
      // bolumunun goruntulendigini kontrol eder"
      // 8-Kullanici Units per piece  secenegine bir deger girer
      // 9-Kullanici submit butonuna tiklar
      // 10-Kullanici Product Successfully Published yazisinin goruntulendigini kontrol eder
   }
   @Test
    public void minumumQuantity(){
      // 1-Kullanici vendor olarak hesabina gider
      // 2- Kullanici Store Manager butonuna tiklar
      // 3- Kullanici Urunler butonuna tiklar
      // 4-Kullanici Urunlerin listelendigini kontrol eder
      // 5-Kullanici ilk urune tiklar
      // "6-Kullanici Toptan Ürün Gösterme Ayarları
      // butonuna tiklar"
      // "7-Kullanici Toptan Ürün Gösterme Ayarları
      // bolumunun goruntulendigini kontrol eder"
      // 8-Kullanici Minimum quantity  secenegine bir deger girer
      // 9-Kullanici submit butonuna tiklar
      // 10-Kullanici Product Successfully Published yazisinin goruntulendigini kontrol eder
   }
}
