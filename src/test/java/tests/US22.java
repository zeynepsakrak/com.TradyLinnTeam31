package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_19_22_Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;

import static tests.Login.login;
import static tests.ReusableMethods.bekle;
import static tests.ReusableMethods.waitFor;

public class US22 {
    US_19_22_Page myPage= new US_19_22_Page();

    @Test
    public void US22_TC01() throws InterruptedException {

        // 1. Kullanıcı https://tradylinn.com/ adresine gider
        // 2. Kullanıcı "Giris yap" seçenegine tıklar
        // 3. Kullanıcı Dogru kullanici ve sifre bilgileri ile giris yapar
        login();
        waitFor(15);

        // 4. İndirimli ürünler kısmında "tümünü gör linki"nin görünürlüğü test edilir
        Assert.assertTrue(myPage.indirimliTumunuGor.isDisplayed());

        // 5. Kullanıcı "Tümünü gör" linkine tıklar
        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);

        // 6. Kullanıcı ürün'e tıklar
        myPage.indirimliIlkUrun.click();

        // 7. Satış sayfasına gidildiği test edilir
        String actualUrl="https://tradylinn.com/urun/amigurumi-bebek/";
        String expectedUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.equals(expectedUrl));
    }

    @Test
    public void US22_TC02() {
        // 1. Kullanıcı https://tradylinn.com/ adresine gider
        // 2. Kullanıcı "Giris yap" seçenegine tıklar
        // 3. Kullanıcı Dogru kullanici ve sifre bilgileri ile giris yapar
        login();
        waitFor(15);

        // 4. Kullanıcı "Tümünü gör" linkine tıklar
        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);

        // 5. Kullanıcı "Sırala" butonuna tıklar
        myPage.sirala.click();

        // 6. "Varsayılan Sıralama" default olarak seçili olduğunu test eder
        Select select= new Select(myPage.sirala);
        String expected = "Varsayılan Sıralama";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,expected);


        // "7. En çok incelenene göre sırala ->
        //     En çok oy alana göre sırala ->
        //     En yeniye göre sırala ->
        //     Fiyata göre sırala: Düşükten yükseğe ->
        //     Fiyata göre sırala: Yüksekten düşüğe""
        // seçeneklerini görünürlüğünü test eder"
        Assert.assertTrue(myPage.siralama1.isDisplayed());
        Assert.assertTrue(myPage.siralama2.isDisplayed());
        Assert.assertTrue(myPage.siralama3.isDisplayed());
        Assert.assertTrue(myPage.siralama4.isDisplayed());
        Assert.assertTrue(myPage.siralama5.isDisplayed());
        Assert.assertTrue(myPage.siralama6.isDisplayed());

        String actual2 = Driver.getDriver().findElement(By.xpath("//select[@class='orderby form-control']")).getText();

    }

    @Test
    public void US22_TC03() {

        // 1. Kullanıcı https://tradylinn.com/ adresine gider
        // 2. Kullanıcı "Giris yap" seçenegine tıklar
        // 3. Kullanıcı Dogru kullanici ve sifre bilgileri ile giris yapar
        login();
        waitFor(15);

        // 4. Kullanıcı "Tümünü gör" linkine tıklar
        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);

        // 5. Kullanıcı "Sırala" butonuna tıklar
        //myPage.sirala.click();

        // 6. Kullanıcı "Fiyata göre sırala: Düşükten yükseğe" seçeneğine tıklar
        Select select= new Select(myPage.sirala);
        select.selectByVisibleText("Fiyata göre sırala: Düşükten yükseğe");
        bekle();

        // 7. Ürünlerin fiyat sıralaması küçükten büyüğe olduğunu test eder
        ArrayList<Double> urunlerDouble = new ArrayList<>();

        for (WebElement each: myPage.indirimliUrunler){
            String fiyatStr = each.getText().replaceAll("^\\D", "");
            urunlerDouble.add(Double.parseDouble(fiyatStr));
        }

        ArrayList<Double> kontrolListe = new ArrayList<>(urunlerDouble);
        Collections.sort(kontrolListe);

        Assert.assertEquals(kontrolListe,urunlerDouble);
    }

    @Test
    public void US22_TC04() {
        // 1. Kullanıcı https://tradylinn.com/ adresine gider
        // 2. Kullanıcı "Giris yap" seçenegine tıklar
        // 3. Kullanıcı Dogru kullanici ve sifre bilgileri ile giris yapar
        login();
        waitFor(15);

        // 4. Kullanıcı "Tümünü gör" linkine tıklar
        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);

        // 5. Kullanıcı "Sırala" butonuna tıklar
        myPage.sirala.click();

        // 6. Kullanıcı "Fiyata göre sırala: Yüksekten Düşüğe" seçeneğine tıklar
        Select select= new Select(myPage.sirala);
        select.selectByVisibleText("Fiyata göre sırala: Yüksekten Düşüğe");

        // 7. Ürünlerin fiyat sıralaması büyükten küçüğe olduğunu test eder
        ArrayList<Double> urunlerDouble = new ArrayList<>();

        for (WebElement each: myPage.indirimliUrunler){
            String fiyatStr = each.getText().replaceAll("^\\D", "");
            urunlerDouble.add(Double.parseDouble(fiyatStr));
        }

        ArrayList<Double> kontrolListe = new ArrayList<>(urunlerDouble);
        Collections.sort(kontrolListe);

        Assert.assertEquals(kontrolListe,urunlerDouble);
    }
}
