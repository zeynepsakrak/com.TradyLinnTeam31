package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static tests.Login.login;
import static tests.ReusableMethods.*;
import static tests.ReusableMethods.waitFor;

public class E2E extends TestBaseRapor {
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert softAssert=new SoftAssert();
    US_01_02_Page firstPage=new US_01_02_Page();
    US_03_04_Page thirdPage = new US_03_04_Page();
    US_05_06_07_Page us_05_06_07_page;
    US_08_09_10_Page page=new US_08_09_10_Page();
    US_11_12_Page myPage=new US_11_12_Page();
    US_13_14_Page us_13_14_page = new US_13_14_Page();
    US_15_16_Page us_15_16_page=new US_15_16_Page();
    US_17_18_Page us_17_18_page;
    US_20_21_Page us_20_21_Page = new US_20_21_Page();

    public static void login() {
        Homepage homepage = new Homepage();
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        homepage.girisButonu.click();
        homepage.userName.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        homepage.pasword.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        homepage.girisYapButonu.click();
    }
    @Test
    public void US01_TC01() throws InterruptedException {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        Thread.sleep(8000);
        //5_Başarılı bir şekilde login olduğunu test eder.
        Assert.assertTrue(firstPage.cikisButonu.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void US03_TC01() {
        extentTest = extentReports.createTest("Urunlere gitme", "Urunlerden siparislere gidilmelidir");
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5. 'Hesabim'a tiklar
        ReusableMethods.waitFor(5);
        thirdPage.hesabimButonu.click();
        extentTest.info("Hesabima tiklandi");
        //6. 'Siparisler'e tiklar
        thirdPage.hesabimSiparislerButonu.click();
        extentTest.info("Siparislere tiklandi");
        //7. 'Ürünlere göz at/Alisverise devam et' tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.hesabimAlisveriseDevamEtButonu);
        ReusableMethods.waitFor(1);
        thirdPage.hesabimAlisveriseDevamEtButonu.click();
        extentTest.info("Ürünlere göz at/Alisverise devam et tiklandi");
        //8. Ürünlerin goruntulendigini kontrol eder
        Assert.assertTrue(thirdPage.urunlerElementListesi.size() != 0);
        extentTest.pass("Ürünlerin goruntulendi");
        Driver.closeDriver();
    }
    @Test
    public void US05_TC01() throws InterruptedException {
        extentTest=extentReports.createTest("US05_TC01", "Store Manager olarak, Products'a gidip yeni ürün yüklenebilmeli");
        //Kullanici vendor olarak hesabina gider
        us_05_06_07_page=new US_05_06_07_Page();
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("tradylinn Anasayfaya gidildi");
        us_05_06_07_page.girisButonu.click();
        us_05_06_07_page.userName.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        extentTest.info("Gecerli bit mail gidildi");
        us_05_06_07_page.pasword.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        extentTest.info("Gecerli bir Password gidildi");
        us_05_06_07_page.girisYapButonu.click();
        extentTest.info("Giris yapildi");
        ReusableMethods.waitFor(5);
        us_05_06_07_page.hesabimButonu.click();
        extentTest.info("hesabim buttonu tiklandi");
        //Kullanici Store Manager butonuna tiklar
        us_05_06_07_page.storeManagerButonu.click();
        extentTest.info("storManager Buttonu tiklandi");
        //Kullanici Urunler butonuna tiklar
        us_05_06_07_page.urunButonu.click();
        extentTest.info("Urun buttonu tiklandi");
        // Kullanici; status, stock, price ve date stunlarinin görünür oldugu kontrol edilir
        extentTest.info("status, stock, price ve date stunlarinin görünür oldugu kontrol edildi");
        extentTest.pass("status, stock, price ve date stunlari görünüyor");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us_05_06_07_page.Status.isDisplayed());
        Assert.assertTrue(us_05_06_07_page.Stock.isDisplayed());
        Assert.assertTrue(us_05_06_07_page.Price.isDisplayed());
        Assert.assertTrue(us_05_06_07_page.Date.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void US08_TC01() throws IOException {
        urun_ekle_menusune_gidilir();
        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle();
        page.Inventory.click();
        waitFor(6);
        extentTest=extentReports.createTest("US08_TC01","Gecerli username ve sifre ile giris yapabilmeli");
        extentTest.info("Hesabiniza basarili bir sekilde giris yapildi");
        extentTest.info("Hesabim butonuna basildi");
        extentTest.info("Store manager butonuna tiklandi");
        extentTest.info("Urun butonuna tiklandi");
        extentTest.info("urun ekle butonuna tiklandi");
        extentTest.info("\"Inventory\" tıklandı");
        waitFor(2);
        page.ManageStock.click();
        extentTest.info("manage stock butonuna tiklandi");
        waitFor(5);
        page.StockMiktar.click();
        page.StockMiktar.clear();
        page.StockMiktar.sendKeys("10");
        waitFor(5);
        extentTest.info("Urun miktarı yazıldı");
        Assert.assertTrue(page.StockMiktar.isEnabled());
        extentTest.pass("Urun miktarı stock belirlendi");
        ReusableMethods.gScreenshot("Urun miktarı stock belirlendi");
    }
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
        extentTest.pass("Siparisler Basarili Bir Sekilde Listelendi");
    }
    @Test
    public void US14_TC01() {
        extentTest = extentReports.createTest("US14_TC01", "Minimum spend / en az alma miktari girilmeli");
        login();                                    //1., 2., 3. Stepler
        extentTest.info("https://tradylinn.com adresine gidildi");
        extentTest.info("Username ve Pasword girildi");
        extentTest.info("Giriş Butonuna basıldı.");
        ReusableMethods.bekle();
        us_13_14_page.hesabimButonu.click();        //4. Kullanıcı "Hesabım" butonunu tıklar
        extentTest.info("Hesabım Butonuna basıldı.");
        us_13_14_page.storeManagerButonu.click();   //5. Kullanıcı "Store Manager" butonunu tıklar
        extentTest.info("Stor Manager Butonuna basıldı.");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us_13_14_page.kuponlarButonu.click();       //6. Kullanıcı "Kuponlar" butonunu tıklar
        extentTest.info("Kuponlar Butonuna basıldı.");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us_13_14_page.kuponlarYeniButonu.click();   //7. Kullanıcı "Yeni ekle" butonunu tıklar
        extentTest.info("Kuponlar Yeni Ekle Butonuna basıldı.");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Random rnd = new Random();                  //8. Kullanıcı "Code" alanına veri girer
        String codeID = String.valueOf(rnd.nextInt(10000));
        us_13_14_page.codeText.sendKeys(codeID, Keys.TAB);
        us_13_14_page.restrictionButonu.click();    //9. Kullanıcı "Restriction" butonunu tıklar
        us_13_14_page.minimumspendText.sendKeys(ConfigReader.getProperty("tradyminimumspend")); //10. Kullanıcı "Minimum spend" alanına veri girer
        us_13_14_page.draftButonu.click();           //11. Kullanıcı "Draft" butonuna tiklar
        ReusableMethods.bekle();
        String expectedDescription = ConfigReader.getProperty("tradyminimumspend");
        String actualDescription = us_13_14_page.minimumspendText.getAttribute("value");
        Assert.assertEquals(actualDescription, expectedDescription);    //12. Kullanıcı "Minimum spend" alanına veri girildiğine test eder
        extentTest.info("'Minimum spend' alanına minimum satın alma miktarı girilebiliyor.");
    }
    @Test
    public void US15_TC_01_02_03() throws InterruptedException, IOException {
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest=extentReports.createTest("US15_TC_01_02_03","Gecerli email ve sifre ile giris yapabilmeli");
        us_15_16_page.myAccount.click();
        extentTest.info("myAccount butonu basilabildi");
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        ReusableMethods.waitFor(1);
        us_15_16_page.login.sendKeys(Keys.ENTER);
        extentTest.info("login butonu basilabildi");
        us_15_16_page.storeManager.click();
        extentTest.info("Vendor store manager butonu basilabildi");
        us_15_16_page.coupons.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(10);
        extentTest.info("Vendor coupons butonu basilabildi");
        us_15_16_page.addNew.click();
        extentTest.info("Vendor butonu basilabildi");
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(10);
        us_15_16_page.limit.click();
        extentTest.info("Vendor limit butonu basilabildi");
        us_15_16_page.usageLimitCoupon.sendKeys("5");
        Assert.assertTrue(us_15_16_page.usageLimitCoupon.getAttribute("value").contains("5"));
        Thread.sleep(2000);
        extentReports.createTest("kupon basina kullanim limiti eklenebilir");
        us_15_16_page.usLimitItems.sendKeys("15");
        Assert.assertTrue(us_15_16_page.usLimitItems.getAttribute("value").contains("15"));
        Thread.sleep(2000);
        extentReports.createTest("kullanimi belirlenen urunlerle uygulanabildi");
        us_15_16_page.perUser.sendKeys("10");
        Thread.sleep(2000);
        Assert.assertTrue(us_15_16_page.perUser.getAttribute("value").contains("10"));
        extentReports.createTest("kullanici basina kullanim siniri uygulanabildi");
        ReusableMethods.getScreenshot("Limit uygulama");
        Driver.closeDriver();
    }
}
