package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_19_22_Page;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.Collections;

import static tests.Login.login;
import static tests.ReusableMethods.bekle;
import static tests.ReusableMethods.waitFor;

public class US22 extends TestBaseRapor {
    US_19_22_Page myPage= new US_19_22_Page();

    @Test
    public void US22_TC01() throws InterruptedException {
        extentTest = extentReports.createTest("US22_TC01",
                "Tumunu gor linki olmali ve tiklandigin o kategorinin ana tayfalarına götürmeli");

        login();
        waitFor(15);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");

        Assert.assertTrue(myPage.indirimliTumunuGor.isDisplayed());
        extentTest.info("İndirimli ürünler kısmında Tümünü Gör linki'nin görünürlüğü test edildi");

        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);
        extentTest.info("Tümünü Gör butonuna tiklandi");

        myPage.indirimliIlkUrun.click();
        extentTest.info("Ilk urune tiklandi");

        String actualUrl="https://tradylinn.com/urun/amigurumi-bebek/";
        String expectedUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.equals(expectedUrl));
        extentTest.info("Ürünün satış sayfasına gidildi");

        extentTest.pass("Tumunu gor linki nin gorunurlugu test edildi ve tiklandigin o kategorinin ana tayfalarına gidildi");
        Driver.getDriver().close();
    }

    @Test
    public void US22_TC02() {
        extentTest = extentReports.createTest("US22_TC02",
                "İndirimli Ürünleri siralanabilmeli");

        login();
        waitFor(15);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");

        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);
        extentTest.info("Tümünü Gör butonuna tiklandi");

        myPage.sirala.click();
        extentTest.info("Sırala butonuna tiklandi");

        Select select= new Select(myPage.sirala);
        String expected = "Varsayılan Sıralama";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,expected);
        extentTest.info("\"Varsayılan Sıralama\" default olarak seçili oldugu test edildi");

        Assert.assertTrue(myPage.siralama1.isDisplayed());
        Assert.assertTrue(myPage.siralama2.isDisplayed());
        Assert.assertTrue(myPage.siralama3.isDisplayed());
        Assert.assertTrue(myPage.siralama4.isDisplayed());
        Assert.assertTrue(myPage.siralama5.isDisplayed());
        Assert.assertTrue(myPage.siralama6.isDisplayed());
        extentTest.info("Diger seceneklerin gorunurlugu test edildi");

        extentTest.pass("İndirimli Ürünler siralandi");
        Driver.getDriver().close();
    }

    @Test
    public void US22_TC03() {
        extentTest = extentReports.createTest("US22_TC03",
                "Fiyata göre sırala: Düşükten yükseğe seçildiğinde fiyatlar kucukten buyuge gore sıralanmalı");

        login();
        waitFor(15);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");

        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);
        extentTest.info("Tümünü Gör butonuna tiklandi");

        Select select= new Select(myPage.sirala);
        extentTest.info("Sırala butonuna tiklandi");
        select.selectByIndex(4);
        bekle();
        extentTest.info("\"Fiyata göre sırala: Düşükten yükseğe\" seçeneğine tiklandi");

        ArrayList<Double> urunlerDouble = new ArrayList<>();
        for (WebElement each: myPage.indirimliUrunler){
            String fiyatStr = each.getText().replaceAll("₺", "");;
            urunlerDouble.add(Double.parseDouble(fiyatStr));
        }

        ArrayList<Double> kontrolListe = new ArrayList<>(urunlerDouble);
        Collections.sort(kontrolListe);
        Assert.assertEquals(kontrolListe,urunlerDouble);
        extentTest.info("Ürünlerin fiyat sıralaması küçükten büyüğe olduğu test edildi");

        extentTest.pass("Fiyata göre sırala: Düşükten yükseğe seçildiğinde fiyatlar kucukten buyuge gore sıralandi");
        Driver.getDriver().close();
    }

    @Test
    public void US22_TC04() {
        extentTest = extentReports.createTest("US22_TC04",
                "Fiyata göre sırala: Yüksekten düşüğe seçildiğinde fiyatlar büyükten kucuge gore sıralanmalı");

        login();
        waitFor(15);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Kullanici Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");

        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);
        extentTest.info("Tümünü Gör butonuna tiklandi");

        myPage.sirala.click();
        extentTest.info("Sırala butonuna tiklandi");

        Select select= new Select(myPage.sirala);

        select.selectByIndex(5);
        bekle();
        extentTest.info("\"Fiyata göre sırala: Yüksekten düşüğe\" seçeneğine tiklandi");

        ArrayList<Double> urunlerDouble = new ArrayList<>();
        for (WebElement each: myPage.indirimliUrunler){
            String fiyatStr = each.getText().replaceAll("₺", "");;
            urunlerDouble.add(Double.parseDouble(fiyatStr));
        }

        ArrayList<Double> kontrolListe = new ArrayList<>(urunlerDouble);
        Collections.sort(kontrolListe);
        Assert.assertEquals(kontrolListe,urunlerDouble);
        extentTest.info("Ürünlerin fiyat sıralaması büyükten küçüğe olduğu test edildi");

        extentTest.pass("Fiyata göre sırala: Yüksekten düşüğe seçildiğinde fiyatlar büyükten kucuge gore sıralandi");
        Driver.getDriver().close();
    }
}
