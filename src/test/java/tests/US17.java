package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_17_18_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.time.Duration;

import static tests.Login.login;
import static tests.ReusableMethods.bekle;
import static tests.ReusableMethods.waitForPageToLoad;

public class US17 extends TestBaseRapor {
    US_17_18_Page us_17_18_page;

    @Test
    public void US17_TC01() throws InterruptedException, IOException {
        us_17_18_page = new US_17_18_Page();
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        Actions actions=new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("Kisi adres bilgisi ekleme", "Billing address ile Shipping address ayni olacak bicimde eklenmelidir");

        // 1-Kullanici https://tradylinn.com/ adresine gider
        // 2-Giris Yap/Uye Ol butonuna tiklar
        // 3-Dogru kullanici adi ve sifre bilgileri ile giris yapar

        login();
        Thread.sleep(7000);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password bilgileri ile giris yapildi");

        // 4-Hesabim butonuna tiklar
        us_17_18_page.hesabim.click();
        extentTest.info("Hesabim butonuna tiklandi");

        // 5-Store Manager butonuna tiklar
        us_17_18_page.storeManager.click();
        extentTest.info("Store Manager butonuna tiklandi");

        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript("window.scrollBy(0,200)");
        // actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        waitForPageToLoad(5);
        // 6-Musteriler butonuna tiklar
        us_17_18_page.musteriler.click();
        // extentTest.info("Musteriler butonuna tiklandi");
        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // 7-Yeni ekle butonuna tiklar
        us_17_18_page.yeniMusteriEkle.click();
        // extentTest.info("Yeni ekle butonuna tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript("window.scrollBy(0,200)");
        us_17_18_page.usernameBox.sendKeys("ali.han");
        us_17_18_page.emailBox.sendKeys("alihan@gmail.com");
        us_17_18_page.firstNameBox.sendKeys("Ali");
        us_17_18_page.lastNameBox.sendKeys("Han");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Musteri bilgileri girildi");
        // 8-Billing Address bolumunde istenen isim, soy isim, firma ismi, telefon,
        //   adres1, adres2, ulke, sehir, posta kodu kisimlarina bilgi girisi yapar

        us_17_18_page.billingFirstNameBox.sendKeys("Ali");
        us_17_18_page.billingLastNameBox.sendKeys("Han");
        us_17_18_page.billingCompanyNameBox.sendKeys("Alihan Ltd.");
        us_17_18_page.billingPhoneBox.sendKeys("555 111 22 33");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us_17_18_page.billingAddress1Box.sendKeys("Atatürk Mh. Hastane Cd.");
        us_17_18_page.billingAddress2Box.sendKeys("No:10");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        Driver.getDriver().findElement(By.xpath("//option[@value='TR']")).click();
        us_17_18_page.billingCityBox.sendKeys("Balıkesir");
        WebElement ddState = Driver.getDriver().findElement(By.id("bstate"));
        Select selectState = new Select(ddState);
        selectState.selectByValue("TR10");
        us_17_18_page.billingZipBox.sendKeys("10100");
        js.executeScript("window.scrollBy(0,200)");
        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Billing bolumunde istenen bilgiler girildi");
        // 9-Submit butonunu tiklar
        us_17_18_page.submitButonu.click();
        extentTest.pass("Billing address ile Shipping address ayni olacak bicimde kisi adres bilgileri eklendi");

        // 10-Kullanici sayfayi kapatir.
        Driver.closeDriver();


    }

        @Test
        public void US17_TC02() throws InterruptedException {
            us_17_18_page = new US_17_18_Page();
            JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
            Actions actions=new Actions(Driver.getDriver());
            extentTest = extentReports.createTest("Kisi adres bilgisi ekleme", "Billing address ile Shipping address farkli olacak bicimde eklenmelidir");
            // 1-Kullanici https://tradylinn.com/ adresine gider
            // 2-Giris Yap/Uye Ol butonuna tiklar
            // 3-Dogru kullanici adi ve sifre bilgileri ile giris yapar

            login();
            Thread.sleep(7000);
            extentTest.info("Tradylinn anasayfasina gidildi");
            extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
            extentTest.info("Email ve Password bilgileri ile giris yapildi");

            // 4-Hesabim butonuna tiklar
            us_17_18_page.hesabim.click();
            extentTest.info("Hesabim butonuna tiklandi");

            // 5-Store Manager butonuna tiklar
            us_17_18_page.storeManager.click();
            extentTest.info("Store Manager butonuna tiklandi");

            bekle();
            actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
            js.executeScript("window.scrollBy(0,200)");
            actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
            waitForPageToLoad(15);
            // 6-Musteriler butonuna tiklar

            us_17_18_page.musteriler.click();
            extentTest.info("Musteriler butonuna tiklandi");
            bekle();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            // 7-Yeni ekle butonuna tiklar
            us_17_18_page.yeniMusteriEkle.click();
            extentTest.info("Yeni ekle butonuna tiklandi");
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            js.executeScript("window.scrollBy(0,200)");
            us_17_18_page.usernameBox.sendKeys("ali.han");
            us_17_18_page.emailBox.sendKeys("alihan@gmail.com");
            us_17_18_page.firstNameBox.sendKeys("Ali");
            us_17_18_page.lastNameBox.sendKeys("Han");
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            extentTest.info("Musteri bilgileri girildi");
            // 8-Billing Address bolumunde istenen isim, soy isim, firma ismi, telefon,
            //   adres1, adres2, ulke, sehir, posta kodu kisimlarina bilgi girisi yapar

            us_17_18_page.billingFirstNameBox.sendKeys("Ali");
            us_17_18_page.billingLastNameBox.sendKeys("Han");
            us_17_18_page.billingCompanyNameBox.sendKeys("Alihan Ltd.");
            us_17_18_page.billingPhoneBox.sendKeys("555 111 22 33");
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            us_17_18_page.billingAddress1Box.sendKeys("Atatürk Mh. Hastane Cd.");
            us_17_18_page.billingAddress2Box.sendKeys("No:10");
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(2000);
            Driver.getDriver().findElement(By.xpath("//option[@value='TR']")).click();
            us_17_18_page.billingCityBox.sendKeys("Balıkesir");
            WebElement ddState = Driver.getDriver().findElement(By.id("bstate"));
            Select selectState = new Select(ddState);
            selectState.selectByValue("TR10");
            us_17_18_page.billingZipBox.sendKeys("10100");
            js.executeScript("window.scrollBy(0,200)");
            bekle();
            actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
            extentTest.info("Billing bolumunde istenen bilgiler girildi");
            // 9-"Same as Billing" kutucugunu tiklar
            us_17_18_page.checkBox.click();
            extentTest.info("'Same as Billing' kutucugu tiklandi");
            // 10-Shipping icin istenen isim, soy isim, firma ismi,
            // adres1, adres2, ulke, sehir, semt, posta kodu kisimlarina bilgi girisi yapar

            us_17_18_page.shippingFirstNameBox.sendKeys("Ahmet");
            us_17_18_page.shippingLastNameBox.sendKeys("Can");
            us_17_18_page.shippingCompanyNameBox.sendKeys("Ahmetcan A.Ş.");
            us_17_18_page.shippingAddress1Box.sendKeys("Ege Mh. Gazi Cd.");
            us_17_18_page.shippingAddress2Box.sendKeys("No:5");
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(2000);
            Driver.getDriver().findElement(By.xpath("(//option[@value='TR'])[2]")).click();
            us_17_18_page.shippingCityBox.sendKeys("Balıkesir");
            WebElement ddShipState = Driver.getDriver().findElement(By.id("sstate"));
            Select selectShipState = new Select(ddShipState);
            selectShipState.selectByValue("TR10");
            us_17_18_page.shippingZipBox.sendKeys("10200");
            js.executeScript("window.scrollBy(0,200)");
            extentTest.info("Shipping bolumunde istenen bilgiler girildi");

            // 11-Submit butonunu tiklar
            us_17_18_page.submitButonu.click();
            extentTest.pass("Billing address ile Shipping address farkli olacak bicimde kisi adres bilgileri eklendi");
            // 12-Kullanici sayfayi kapatir.
            Driver.closeDriver();





    }
}