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
    public void US01_TC02() throws InterruptedException {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        Thread.sleep(8000);
        firstPage.hesabim.click();
        //5_Orders butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.ordersButonu.isDisplayed(),
                "Orders butonu görülmedi.");
        //6_Downloads butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.downloadsButonu.isDisplayed(),
                "Downloads butonu görülmedi.");
        //7_Addresses butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.addressesButonu.isDisplayed(),
                "Addresses butonu görülmedi.");
        //8_Account details butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.accountDetailsButonu.isDisplayed(),
                "Account butonu görülmedi.");
        //9_Whislist butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.whislistButonu.isDisplayed(),
                "Whislist butonu görülmedi.");
        //10_Logout butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.logoutButonu.isDisplayed(),
                "Logout butonu görülmedi.");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test
    public void US01_TC03() throws InterruptedException {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        Thread.sleep(8000);
        //5_Store manager butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.storeManagerDashboard.isDisplayed(),
                "Dashboard altinda Store manager butonu görülmedi.");
        //6_Orders butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.ordersButonuDashboard.isDisplayed(),
                "Dashboard altinda Orders butonu görülmedi.");
        //7_Downloads butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.downloadsButonuDashboard.isDisplayed(),
                "Dashboard altinda Downloads butonu görülmedi.");
        //8_Addresses butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.addressesButonuDashboard.isDisplayed(),
                "Dashboard altinda Addresses butonu görülmedi.");
        //9_Account details butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.accountDetailsButonuDashboard.isDisplayed(),
                "Dashboard altinda Account details butonu görülmedi.");
        //10_Appointments butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.appoinmentsButonuDashboard.isDisplayed(),
                "Dashboard altinda Appointments butonu görülmedi.");
        //11_Wishlist butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.whislistButonuDashboard.isDisplayed(),
                "Dashboard altinda Wishlist butonu görülmedi.");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test
    public void US01_TC04() throws InterruptedException {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        Thread.sleep(8000);
        firstPage.hesabim.click();
        //5_Support tickets butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.supportTicketsButonuDashboard.isDisplayed(),
                "Dashboard altinda Support tickets butonu görülmedi.");
        //6_Followings butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.followingsButonuDashboard.isDisplayed(),
                "Dashboard altinda Followings butonu görülmedi.");
        //7_Logout butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.logoutButonuDashboard.isDisplayed(),
                "Dashboard altinda Logout butonu görülmedi.");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test
    public void US03_TC01() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        //5. 'Hesabim'a tiklar
        thirdPage.hesabimButonu.click();
        //6. 'Siparisler'e tiklar
        thirdPage.hesabimSiparislerButonu.click();
        //7. 'Ürünlere göz at/Alisverise devam et' tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.hesabimAlisveriseDevamEtButonu);
        thirdPage.hesabimAlisveriseDevamEtButonu.click();
        //8. Ürünlerin goruntulendigini kontrol eder
        Assert.assertTrue(thirdPage.urunlerElementListesi.size() != 0);
        Driver.closeDriver();
    }
    @Test
    public void US03_TC02() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        //5. 'Hemen Basla' butonuna tiklar
        sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        //6. Ilk 5 ürünü, 'Sepete Ekle' butonuna tiklayarak sepete ekler
        int count = 0;
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));
                thirdPage.urunlerElementListesi.get(i).click();
                thirdPage.sepeteEkleButonu.click();
                count++;
                Driver.getDriver().navigate().back();
                Driver.getDriver().navigate().back();
                if (count == 5) break;
            }
        }
        //7. Sepetteki ürün miktarinin 5 oldugunu kontrol eder
        Assert.assertEquals(thirdPage.sepetimIkonu.getText().replace("Sepetim\n", ""), "5");
        Driver.closeDriver();
    }
    @Test
    public void US03_TC03() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        //5. 'Hemen Basla' butonuna tiklar
        sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        //6. Bir ürünü 'Sepete Ekle' butonuna tiklayarak sepete ekler
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));

                thirdPage.urunlerElementListesi.get(i).click();
                thirdPage.sepeteEkleButonu.click();
                break;
            }
        }
        //7. 'Sepetim' butonuna tiklar
        thirdPage.sepetimIkonu.click();
        //8. 'Sepeti Görüntüle' butonuna tiklar
        thirdPage.sepetiGoruntule.click();
        //9. Sepete gidildigini kontrol eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("cart"));
        //10. 'Ödeme sayfasina git'e tiklar
        jse.executeScript("arguments[0].scrollIntoView();", thirdPage.odemeSayfasinaGitButonu);

        thirdPage.odemeSayfasinaGitButonu.click();
        //11. checkout'a gidildigini kontrol eder
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout"));
        Driver.closeDriver();
    }
    @Test
    public void US03_TC04() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        //5. 'Hemen Basla' butonuna tiklar
        sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        //6. Bir ürünü 'Sepete Ekle' butonuna tiklayarak sepete ekler
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));

                thirdPage.urunlerElementListesi.get(i).click();
                thirdPage.sepeteEkleButonu.click();
                break;
            }
        }
        //7. 'Sepetim' butonuna tiklar
        thirdPage.sepetimIkonu.click();
        //8. 'Sepeti Görüntüle' butonuna tiklar
        thirdPage.sepetiGoruntule.click();
        //9. Kargo bilgilerini girer
        //Select select = new Select(myPage.korgoBilgileriSehirElementi);
        //Thread.sleep(1000);
        //select.selectByVisibleText("Adana");
        //myPage.korgoBilgileriSehirElementi.sendKeys("Adana");
        thirdPage.korgoBilgileriIlceElementi.sendKeys("Ceyhan");
        thirdPage.korgoBilgileriPostaKoduElementi.sendKeys("01270");
        //10. 'Fiyati Güncelle'ye tiklar
        thirdPage.fiyatiGuncelleButonu.click();
        //11. Kargo bilgilerinin girildigini kontrol eder
        String expectedResult = "Sehitkamil";
        String actualResult = thirdPage.korgoBilgileriIlceElementi.getText();
        Assert.assertEquals(expectedResult, actualResult);
        //12. 'Temizle' butonuna tiklar
        thirdPage.sepetiTemizle.click();
    }
    @Test
    public void US03_TC05() {
        //1. Kullanıcı https://tradylinn.com adresine gider
        //2. 'Giris Yap/Uye Ol' butonuna tiklar
        //3. Email ve Password girer
        //4. 'Giris Yap' butonuna tiklar
        login();
        //5. 'Hemen Basla' butonuna tiklar
        sepetiBosalt();
        thirdPage.hemenBaslaButonu.click();
        //6. Bir ürünü 'Sepete Ekle' butonuna tiklayarak sepete ekler
        for (int i = 0; i < thirdPage.urunlerElementListesi.size(); i++) {
            if (!thirdPage.urunlerElementListesi.get(i).getText().contains("STOKLAR TÜKENDI")) {
                jse.executeScript("arguments[0].scrollIntoView();", thirdPage.urunlerElementListesi.get(i));

                thirdPage.urunlerElementListesi.get(i).click();
                thirdPage.sepeteEkleButonu.click();
                break;
            }
        }
        //7. 'Sepetim' butonuna tiklar
        thirdPage.sepetimIkonu.click();
        //8. 'Sepeti Görüntüle' butonuna tiklar
        thirdPage.sepetiGoruntule.click();
        //9. 'Odeme Sayfasina Git'e tiklar
        thirdPage.odemeSayfasinaGitButonu.click();
        //10. 'Fatura Detaylarini' girer
        //11. 'Siparisi onaylaya' tiklar
        //12. Fatura detaylarinin girildigini ve siparis verildigini kontrol eder
    }
    @Test(priority = 1)
    public void InventoryGit() {
        urun_ekle_menusune_gidilir();
        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle();
        page.Inventory.click();
        waitFor(3);
    }
    @Test(priority = 2)
    public void US08_TC01() {
        //extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giris yapabilmeli");
        waitFor(2);
        page.ManageStock.click();
        waitFor(5);
        page.StockMiktar.click();
        page.StockMiktar.clear();
        page.StockMiktar.sendKeys("10");
        waitFor(5);
        page.Submit.click();
        waitFor(3);
        System.out.println(page.StockMiktar.getText());
        Assert.assertTrue(page.StockMiktar.getText().contains("10"));
        //extentTest.info("Urun miktarı stock belirlendi");
    }
    @Test(priority = 3)
    public void US08_TC02() {
        Select select =new Select(page.AllowBlackorder);
        List<WebElement> ActualList= select.getOptions();
        List<WebElement> expectedList=new ArrayList<>();
        for (WebElement each:ActualList) {
            each.click();
            System.out.println(each.getText());
            expectedList.add(each);
        }
        Assert.assertEquals(ActualList,expectedList);
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
    @Test(priority = 1)
    public void US14_TC01() {
        extentTest = extentReports.createTest("US14_TC01", "Minimum spend / en az alma miktari girilmeli");
        login();                                    //1., 2., 3. Stepler
        ReusableMethods.bekle();
        us_13_14_page.hesabimButonu.click();        //4. Kullanıcı "Hesabım" butonunu tıklar
        us_13_14_page.storeManagerButonu.click();   //5. Kullanıcı "Store Manager" butonunu tıklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us_13_14_page.kuponlarButonu.click();       //6. Kullanıcı "Kuponlar" butonunu tıklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us_13_14_page.kuponlarYeniButonu.click();   //7. Kullanıcı "Yeni ekle" butonunu tıklar
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
    @Test(dependsOnMethods = "US14_TC01", priority = 2)
    public void US14_TC02() {
        extentTest = extentReports.createTest("US14_TC02", "Maximum spend / maksimum alma miktarı girilmeli");
        //1., 2., 3. 4., 5., 6., 7., 8.  Stepler US14_TC01 testten alıyor
        actions.sendKeys(Keys.PAGE_UP).perform();
        us_13_14_page.restrictionButonu.click();        //9. Kullanıcı "Restriction" butonunu tıklar
        us_13_14_page.maximumspendText.sendKeys(ConfigReader.getProperty("tradymaximumspend")); //10. Kullanıcı "Maximum spend" alanına veri girer
        us_13_14_page.draftButonu.click();              //11. Kullanıcı "Draft" butonuna tiklar
        ReusableMethods.bekle();
        String expectedDescription = ConfigReader.getProperty("tradymaximumspend");
        String actualDescription = us_13_14_page.maximumspendText.getAttribute("value");
        Assert.assertEquals(actualDescription, expectedDescription);    //12. Kullanıcı "Maximum spend" alanına veri girildiğine test eder
        extentTest.info("'Maximum spend' alanına maximum satın alma miktarı girilebiliyor.");
    }
    @Test(dependsOnMethods = "US14_TC01", priority = 3)
    public void US14_TC03() throws InterruptedException {
        extentTest = extentReports.createTest("US14_TC03", "Individual use only / kisisel kullanım sadece secenegi olmalı");
        //1., 2., 3. 4., 5., 6., 7., 8.  Stepler US14_TC01 testten alıyor
        actions.sendKeys(Keys.PAGE_UP).perform();
        us_13_14_page.restrictionButonu.click();            //9. Kullanıcı "Restriction" butonunu tıklar
        us_13_14_page.IndividualuseonlyCheck.click();       //10. Kullanıcı "Individual use only" alanına tik atar
        us_13_14_page.draftButonu.click();                  //11. Kullanıcı "Draft" butonuna tiklar
        ReusableMethods.bekle();
        Assert.assertTrue(us_13_14_page.IndividualuseonlyCheck.isSelected());   //12. Kullanıcı "Individual use only" alanı tikli olduğunu test eder
        extentTest.info("'Individual use only' alanı tik atılıp seçilebiliyor.");
    }
    @Test(dependsOnMethods = "US14_TC01", priority = 4)
    public void US14_TC04() {
        extentTest = extentReports.createTest("US14_TC04", "Exclude sale items / bazi satis ürünleri disinda tut");
        //1., 2., 3. 4., 5., 6., 7., 8.  Stepler US14_TC01 testten alıyor
        us_13_14_page.restrictionButonu.click();            //9. Kullanıcı "Restriction" butonunu tıklar
        us_13_14_page.excludesaleitemsCheck.click();        //10. Kullanıcı "Exclude sale items" alanına tik atar
        us_13_14_page.draftButonu.click();                  //11. Kullanıcı "Draft" butonuna tiklar
        ReusableMethods.bekle();
        Assert.assertTrue(us_13_14_page.excludesaleitemsCheck.isSelected());    //12. Kullanıcı "Exclude sale items" alanı tikli olduğunu test eder
        extentTest.info("'Exclude sale items' alanı tik atılıp seçilebiliyor.");
    }
    @Test(dependsOnMethods = "US14_TC01", priority = 5)
    public void US14_TC05() {
        extentTest = extentReports.createTest("US14_TC05", "Exclude categories / bazi kategorileri disinda tut");
        //1., 2., 3. 4., 5., 6., 7., 8.  Stepler US14_TC01 testten alıyor
        ReusableMethods.bekle();
        us_13_14_page.restrictionButonu.click();        //9. Kullanıcı "Restriction" butonunu tıklar

        Select select = new Select(us_13_14_page.excludecategories);    //10. Kullanıcı "Exclude categories" alanına "Besin takviyesi" ve "Yeni ürünler" seçer
        ReusableMethods.waitFor(3);
        select.selectByIndex(6);
        select.selectByIndex(16);
        List<WebElement> secilen = select.getAllSelectedOptions();
        String expectedcategories = "";
        for (WebElement each : secilen) {
            expectedcategories += "×" + each.getText();
        }
        us_13_14_page.draftButonu.click();        //11. Kullanıcı "Draft" butonuna tiklar
        ReusableMethods.bekle();
        String actualcategories = "";
        for (WebElement each : us_13_14_page.categoriesSelectedList) {
            actualcategories += each.getText();
        }
        Assert.assertEquals(actualcategories, expectedcategories);   // 12. Kullanıcı "Exclude categories" alanında "Besin takviyesi" ve "Yeni ürünler" seçili olduğunu test eder
        extentTest.info("'Exclude categories' alanına bazı katagoriler seçilip hariç tutulabiliyor.");

        ReusableMethods.bekle();
        us_13_14_page.submitButonu.click();  //13. Kullanıcı "Submit" butonuna tıklar

        Assert.assertTrue(us_13_14_page.submitOnayYazisi.getText().contains("Coupon Successfully Published.")); //14. Kullanıcı Kayıt yapıldığını kontrol eder
        extentTest.info("Veriler Girildikten Sonra Kayıt işlemi yapılıp, Ürüne Kısıtlamalar getirilebiliyor.");
        Driver.closeDriver();
    }
    @Test
    public void US15_TC_01_02_03() throws InterruptedException {
        //1- Siteye git:https://tradylinn.com/ gidilebilir
        Driver.getDriver().get(ConfigReader.getProperty("tradllyinnUrl"));
        extentReports.createTest("US15_TC_01_02_03","Gecerli email ve sifre ile giris yapabilmeli");
        //2 -Vendor "My Account" butonuna tiklanir
        us_15_16_page.myAccount.click();
        //3- Vendor "username or email address" ve "password" bilgileri girer ve "login" butonuna tiklanir
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("tradllyinnEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("tradllyinnPassword"));
        ReusableMethods.waitFor(1);
        us_15_16_page.login.sendKeys(Keys.ENTER);
        //4-Vendor "Store Manager" butonuna tiklanir
        us_15_16_page.storeManager.click();
        //5-Vendor "Coupons" butonuna tiklanir
        us_15_16_page.coupons.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(10);
        //6- Vendor "add new "butonuna tiklanir
        us_15_16_page.addNew.click();
        //7- Vendor "limit" butonuna tiklanir
        Actions action = new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(10);
        us_15_16_page.limit.click();
        //8- Vendor "Usage limit per coupon" limiti bilgileri eklenebilir
        us_15_16_page.usageLimitCoupon.sendKeys("5");
        Assert.assertTrue(us_15_16_page.usageLimitCoupon.getAttribute("value").contains("5"));
        Thread.sleep(2000);
        extentReports.createTest("kupon basina kullanim limiti eklenebilir");
        //8-  Vendor "Limit usage to X items" limiti bilgileri uygulanabilir
        us_15_16_page.usLimitItems.sendKeys("15");
        Assert.assertTrue(us_15_16_page.usLimitItems.getAttribute("value").contains("15"));
        Thread.sleep(2000);
        extentReports.createTest("kullanimi belirlenen urunlerle uygulanabildi");
        //8- Vendor "Usage limit per user" limit bilgileri uygulanabilir
        us_15_16_page.perUser.sendKeys("10");
        Thread.sleep(2000);
        Assert.assertTrue(us_15_16_page.perUser.getAttribute("value").contains("10"));
        extentReports.createTest("kullanici basina kullanim siniri uygulanabildi");
        Driver.closeDriver();
    }
    @Test
    public void US17_TC01() throws InterruptedException {
        us_17_18_page = new US_17_18_Page();
        //US17_TC01_Billing address ile Shipping address ayni oldugu durumda kisi adres bilgisi eklenebilmeli
        // 1-Kullanici https://tradylinn.com/ adresine gider
        // 2-Kullanici Giris yap secenegine tiklar
        // 3-Dogru kullanici adi  ve sifre bilgileri ile giris yapar
        login();
        Thread.sleep(5000);
        // 4-Hesabim butonuna tiklar
        // 5-Store Manager butonuna tiklar
        us_17_18_page.storeManagerButonu.click();
        // 6-Musteriler butonuna tiklar
        // 7-Yeni ekle butonuna tiklar
        // 8-Billing Address bolumunde istenen isim, soy isim, firma ismi, telefon,
        //   adres1, adres2, ulke, sehir, posta kodu kisimlarina bilgi girisi yapar
        //    Add Customer Username box bilgi girisi:
        us_17_18_page.usernameBox.sendKeys(ConfigReader.getProperty("NewCustomerUsername"));
        //    Add Customer Email box bilgi girisi:
        us_17_18_page.emailBox.sendKeys(ConfigReader.getProperty("NewCustomerEmail"));
        //    Add Customer First Name box bilgi girisi:
        us_17_18_page.firstNameBox.sendKeys(ConfigReader.getProperty("NewCustomerFirstName"));
        //    Add Customer Last Name box bilgi girisi:
        us_17_18_page.lastNameBox.sendKeys(ConfigReader.getProperty("NewCustomerLastName"));
        //    Billing First Name box bilgi girisi:
        us_17_18_page.billingFirstNameBox.sendKeys(ConfigReader.getProperty("NewCustomerFirstName"));
        //    Billing Last Name box bilgi girisi:
        us_17_18_page.billingLastNameBox.sendKeys(ConfigReader.getProperty("NewCustomerLastName"));
        //    Billing Company Name box bilgi girisi:
        us_17_18_page.billingCompanyNameBox.sendKeys(ConfigReader.getProperty("NewCustomerCompanyName"));
        //    Billing Phone box bilgi girisi:
        us_17_18_page.billingPhoneBox.sendKeys(ConfigReader.getProperty("NewCustomerPhone"));
        //    Billing Address1 box bilgi girisi:
        us_17_18_page.billingAddress1Box.sendKeys(ConfigReader.getProperty("NewCustomerBillingAddress1"));
        //    Billing Address2 box bilgi girisi:
        us_17_18_page.billingAddress2Box.sendKeys(ConfigReader.getProperty("NewCustomerBillingAddress2"));
        //    Billing Country dropDown bilgi girisi:
        Select select1 = new Select(us_17_18_page.billingCountryDropDown);
        select1.getFirstSelectedOption().click();
        //    Billing City/Town box bilgi girisi:
        us_17_18_page.billingCityBox.sendKeys(ConfigReader.getProperty("NewCustomerCity"));
        //    Billing State/County dropDown bilgi girisi:
        Select select2 = new Select(us_17_18_page.billingStateDropDown);
        select2.selectByIndex(34);
        //    Billing Postcode/Zip box bilgi girisi:
        us_17_18_page.billingZipBox.sendKeys(ConfigReader.getProperty("NewCustomerZip"));
        // 9-Submit butonunu tiklar
        us_17_18_page.submitButonu.click();
        // 10-Acilan pop-up menu (alert)'den Kaydet butonunu tiklar
        // 11-Müsteriler butonuna tiklar
        // 12-Girilen musteri bilgilerini gorur.
    }
    @Test
    public void US17_TC02() throws InterruptedException {
        us_17_18_page = new US_17_18_Page();
        // US17_TC02_Billing address ile Shipping address farkli oldugu durumda kisi adres bilgisi eklenebilmeli
        // 1-Kullanici https://tradylinn.com/ adresine gider
        // 2-Kullanici Giris yap secenegine tiklar
        // 3-Dogru kullanici adi  ve sifre bilgileri ile giris yapar
        login();
        Thread.sleep(5000);
        // 4-Hesabim butonuna tiklar
        // 5-Store Manager butonuna tiklar
        us_17_18_page.storeManagerButonu.click();
        // 6-Musteriler butonuna tiklar
        // 7-Yeni ekle butonuna tiklar
        // 8-Billing Address bolumunde istenen isim, soy isim, firma ismi, telefon,
        //   adres1, adres2, ulke, sehir, semt, posta kodu kisimlarina bilgi girisi yapar
        //    Add Customer Username box bilgi girisi:
        us_17_18_page.usernameBox.sendKeys(ConfigReader.getProperty("NewCustomerUsername"));
        //    Add Customer Email box bilgi girisi:
        us_17_18_page.emailBox.sendKeys(ConfigReader.getProperty("NewCustomerEmail"));
        //    Add Customer First Name box bilgi girisi:
        us_17_18_page.firstNameBox.sendKeys(ConfigReader.getProperty("NewCustomerFirstName"));
        //    Add Customer Last Name box bilgi girisi:
        us_17_18_page.lastNameBox.sendKeys(ConfigReader.getProperty("NewCustomerLastName"));
        //    Billing First Name box bilgi girisi:
        us_17_18_page.billingFirstNameBox.sendKeys(ConfigReader.getProperty("NewCustomerFirstName"));
        //    Billing Last Name box bilgi girisi:
        us_17_18_page.billingLastNameBox.sendKeys(ConfigReader.getProperty("NewCustomerLastName"));
        //    Billing Company Name box bilgi girisi:
        us_17_18_page.billingCompanyNameBox.sendKeys(ConfigReader.getProperty("NewCustomerCompanyName"));
        //    Billing Phone box bilgi girisi:
        us_17_18_page.billingPhoneBox.sendKeys(ConfigReader.getProperty("NewCustomerPhone"));
        //    Billing Address1 box bilgi girisi:
        us_17_18_page.billingAddress1Box.sendKeys(ConfigReader.getProperty("NewCustomerBillingAddress1"));
        //    Billing Address2 box bilgi girisi:
        us_17_18_page.billingAddress2Box.sendKeys(ConfigReader.getProperty("NewCustomerBillingAddress2"));
        //    Billing Country dropDown bilgi girisi:
        Select select1 = new Select(us_17_18_page.billingCountryDropDown);
        select1.getFirstSelectedOption().click();
        //    Billing City/Town box bilgi girisi:
        us_17_18_page.billingCityBox.sendKeys(ConfigReader.getProperty("NewCustomerCity"));
        //    Billing State/County dropDown bilgi girisi:
        Select select2 = new Select(us_17_18_page.billingStateDropDown);
        select2.selectByIndex(34);
        //    Billing Postcode/Zip box bilgi girisi:
        us_17_18_page.billingZipBox.sendKeys(ConfigReader.getProperty("NewCustomerZip"));
        // 9-"Same as Billing" kutucugunu tiklar (Default secili olarak geliyor)
        us_17_18_page.checkBox.click();
        // 10-Shipping icin istenen isim, soy isim, firma ismi,
        // adres1, adres2, ulke, sehir, semt, posta kodu kisimlarina bilgi girisi yapar
        //    Shipping First Name box bilgi girisi:
        us_17_18_page.shippingFirstNameBox.sendKeys(ConfigReader.getProperty("NewCustomerFirstName"));
        //    Shipping Last Name box bilgi girisi:
        us_17_18_page.shippingLastNameBox.sendKeys(ConfigReader.getProperty("NewCustomerLastName"));
        us_17_18_page.shippingCompanyNameBox.sendKeys(ConfigReader.getProperty("NewCustomerCompanyName"));
        us_17_18_page.shippingAddress1Box.sendKeys(ConfigReader.getProperty("NewCustomerShippingAddress1"));
        us_17_18_page.shippingAddress2Box.sendKeys(ConfigReader.getProperty("NewCustomerShippingAddress2"));
        Select select3 = new Select(us_17_18_page.shippingCountryDropDown);
        select3.getFirstSelectedOption().click();
        us_17_18_page.shippingCityBox.sendKeys(ConfigReader.getProperty("NewCustomerShippingCity"));
        us_17_18_page.shippingStateBox.sendKeys(ConfigReader.getProperty("NewCustomerCounty"));
        us_17_18_page.shippingZipBox.sendKeys(ConfigReader.getProperty("NewCustomerZip"));
        // 11-Submit butonunu tiklar
        us_17_18_page.submitButonu.click();
        // 12-Acilan pop-up menu (alert)'den Kaydet butonunu tiklar
        // 13-Müsteriler butonunu tiklar
    }
    @Test
    public  void test01() throws InterruptedException {
        US_20_21_Page us_20_21_Page = new US_20_21_Page();
        //1-kullanıcı  https://tradylinn.com/  adresine gider
        //2- Satıcı olarak giriş yapılır
        login();
        Thread.sleep(5000);
        //3-hesabim a tiklanir
        us_20_21_Page.hesabim.click();
        Thread.sleep(5000);
        //4-story manager'e tiklanir
        us_20_21_Page.storeManejer.click();
        Thread.sleep(4000);
        //5-incelemelere tiklanir
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",us_20_21_Page.inceleme);
        Thread.sleep(4000);
        us_20_21_Page.inceleme.click();
        Thread.sleep(2000);
        //6-product reviews tiklanir
        us_20_21_Page.productReviews.click();
        //7-kullanıcı bilgisi gorunur oldugunu test eder
        String actualDescription=us_20_21_Page.kullaniciBilgisi.getText();
        System.out.println("KullaniciAdi = " + actualDescription);
        Assert.assertTrue(us_20_21_Page.kullaniciBilgisi.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void test02() throws InterruptedException {
        US_20_21_Page us_20_21_Page = new US_20_21_Page();
        //1-kullanıcı  https://tradylinn.com/  adresine gider
        //2- Satıcı olarak giriş yapılır
        login();
        Thread.sleep(5000);
        //3-hesabim a tiklanir
        us_20_21_Page.hesabim.click();
        Thread.sleep(9000);
        //4-story manager'e tiklanir
        us_20_21_Page.storeManejer.click();
        Thread.sleep(4000);
        //5-incelemelere tiklanir
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",us_20_21_Page.inceleme);
        Thread.sleep(4000);
        us_20_21_Page.inceleme.click();
        Thread.sleep(2000);
        //6-product reviews tiklanir
        us_20_21_Page.productReviews.click();
        //7-kullanıcı commentinin gorunur oldugunu test eder
        String actualDescription1=us_20_21_Page.kullaniciCommenti.getText();
        System.out.println("kullaniciCommenti = " + actualDescription1);
        Assert.assertTrue(us_20_21_Page.kullaniciCommenti.isDisplayed());
        //8-kullanıcı comment tarihinin gorunur oldugunu test eder
        String actualDescription2=us_20_21_Page.kullaniciCommentiTarihi.getText();
        System.out.println("kullaniciCommentiTarihi = " + actualDescription2);
        Assert.assertTrue(us_20_21_Page.kullaniciCommentiTarihi.isDisplayed());
        Driver.closeDriver();
    }
}
