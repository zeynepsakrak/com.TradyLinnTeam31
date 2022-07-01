package tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_01_02_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.Login.login;

public class US01 extends TestBaseRapor {
    US_01_02_Page firstPage;
    SoftAssert softAssert;

    @Test
    public void US01_TC01() {
        extentTest=extentReports.createTest("UC01_TC01", "Vendor olarak kayıt icin ‘Become a vendor’ butonu ile navigate ediniz");
        firstPage=new US_01_02_Page();
        softAssert = new SoftAssert();
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("https://tradylinn.com adresine gidildi.");
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        extentTest.info("Sign Up butonuna tiklanildi.");
        //3_Kullanıcı Become a vendor butonunun göründüğünü test eder
        Assert.assertTrue(firstPage.saticiOl.isDisplayed());
        extentTest.pass("Become a vendor butonu görüldü.");
        Driver.closeDriver();
    }

    @Test
    public void US01_TC02() {
        extentTest=extentReports.createTest("UC01_TC02", "Registration sayfasında uc özellik olmalı; email, password, confirm password");
        firstPage=new US_01_02_Page();
        softAssert = new SoftAssert();
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("https://tradylinn.com adresine gidildi.");
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        extentTest.info("Sign Up butonuna tiklanildi.");
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        extentTest.info("Become a vendor butonuna tiklanildi.");
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        extentTest.info(" https://tradylinn.com/vendor-register/ url’si görüldü.");
        //5_Kullanıcı Email kutusunun göründüğünü test eder
        softAssert.assertTrue(firstPage.emailKutusu.isDisplayed(),"Email kutusu gorunmuyor.");
        extentTest.info("Email kutusu görüldü.");
        //6_Kullanıcı Password kutusunun göründüğünü test eder
        softAssert.assertTrue(firstPage.emailKutusu.isDisplayed(),"Password kutusu gorunmuyor.");
        extentTest.info("Password kutusu görüldü.");
        //7_Kullanıcı Confirm Password kutusunun göründüğünü test eder
        softAssert.assertTrue(firstPage.emailKutusu.isDisplayed(),"Confirm Password kutusu gorunmuyor.");
        extentTest.pass("Confirm Password kutusu görüldü.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test
    public void US01_TC03() {
        extentTest=extentReports.createTest("UC01_TC03", "Geçerli bir email olmalı");
        firstPage=new US_01_02_Page();
        softAssert = new SoftAssert();
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("https://tradylinn.com adresine gidildi.");
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        extentTest.info("Sign Up butonuna tiklanildi.");
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        extentTest.info("Become a vendor butonuna tiklanildi.");
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        extentTest.info(" https://tradylinn.com/vendor-register/ url’si görüldü.");
        //5_Kullanıcı geçerli bir mail girer
        firstPage.emailKutusu.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        extentTest.info("Geçerli bir mail girildi.");
        //6_Kullanıcı Register Butonuna tıklar.
        firstPage.registerButonu.click();
        extentTest.info("Register Butonuna tiklanildi.");
        //7_Kullanıcı Email: This field is required uyarısının görünmediğini test eder
        softAssert.assertFalse(firstPage.emailThisFieldIsRequiredUyarisi.isDisplayed(),"Uyari gorundu.");
        extentTest.pass("Email: This field is required uyarisi görülmedi.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test
    public void US01_TC04() {
        extentTest=extentReports.createTest("UC01_TC04", "Mail kutusu boş bırakılamaz");
        firstPage=new US_01_02_Page();
        softAssert = new SoftAssert();
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("https://tradylinn.com adresine gidildi.");
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        extentTest.info("Sign Up butonuna tiklanildi.");
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        extentTest.info("Become a vendor butonuna tiklanildi.");
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        extentTest.info(" https://tradylinn.com/vendor-register/ url’si görüldü.");
        //5_Kullanıcı mail kutusunu boş bırakır.
        firstPage.emailKutusu.sendKeys("");
        extentTest.info("Mail kutusu bos birakildi.");
        //6_Kullanıcı Register Butonuna tıklar.
        firstPage.registerButonu.click();
        extentTest.info("Register Butonuna tiklanildi.");
        //7_Kullanıcı Email: This field is required uyarısının göründüğünü test eder
        softAssert.assertTrue(firstPage.emailThisFieldIsRequiredUyarisi.isDisplayed(),"Uyari gorunmedi.");
        extentTest.pass("Email: This field is required uyarisi görüldü.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test
    public void US01_TC05() {
        extentTest=extentReports.createTest("UC01_TC05", "Email unique olmalı");
        firstPage=new US_01_02_Page();
        softAssert = new SoftAssert();
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("https://tradylinn.com adresine gidildi.");
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        extentTest.info("Sign Up butonuna tiklanildi.");
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        extentTest.info("Become a vendor butonuna tiklanildi.");
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        extentTest.info(" https://tradylinn.com/vendor-register/ url’si görüldü.");
        //5_Kullanıcı geçerli bir mail girer
        firstPage.emailKutusu.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        extentTest.info("Geçerli bir mail girildi.");
        //6_Kullanıcı kucuk harf, büyük harf, rakam ve special karakter kullanarak şifre girer
        firstPage.passwordKutusu.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        extentTest.info("Geçerli bir password girildi.");
        //7_Kullanıcı strong yazısını görür
        softAssert.assertTrue(firstPage.strongYazisi.isDisplayed(),"Kullanici gecerli bir sifre girmedi.");
        extentTest.info("Strong yazisi görüldü.");
        //8_Kullanıcı tekrar şifre girer
        firstPage.confirmPasswordKutusu.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        extentTest.info("Tekrar password girildi.");
        //9_Kullanıcı register butonuna tıklar
        firstPage.registerButonu.click();
        extentTest.info("Register Butonuna tiklanildi.");
        //10_Kullanıcı This Email already exists.Please login to the site
        // and apply as vendor uyarısının görünmediğini test eder
        extentTest.pass("This Email already exists.Please login to the site\n" +
                "        // and apply as vendor uyarisi görülmedi.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test
    public void US01_TC06() {
        extentTest=extentReports.createTest("UC01_TC06", "Gulch bir password olusturulmali: kucuk harf, büyük harf, rakam ve special karakter kullanılmalı");
        firstPage=new US_01_02_Page();
        softAssert = new SoftAssert();
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("https://tradylinn.com adresine gidildi.");
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        extentTest.info("Sign Up butonuna tiklanildi.");
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        extentTest.info("Become a vendor butonuna tiklanildi.");
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        extentTest.info(" https://tradylinn.com/vendor-register/ url’si görüldü.");
        //5_Kullanıcı geçerli bir mail girer
        firstPage.emailKutusu.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        extentTest.info("Geçerli bir mail girildi.");
        //6_Kullanıcı kucuk harf, büyük harf, rakam ve special karakter kullanarak şifre girer
        firstPage.passwordKutusu.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        extentTest.info("Geçerli bir password girildi.");
        //7_Kullanıcı strong yazısının göründüğünü test eder
        softAssert.assertTrue(firstPage.strongYazisi.isDisplayed(),"Kullanici gecerli bir sifre girmedi.");
        extentTest.pass("Strong yazisi görüldü.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test
    public void US01_TC07() {
        extentTest=extentReports.createTest("UC01_TC07", "Password ayni sekilde tekrar kullanılmalı");
        firstPage=new US_01_02_Page();
        softAssert = new SoftAssert();
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("https://tradylinn.com adresine gidildi.");
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        extentTest.info("Sign Up butonuna tiklanildi.");
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        extentTest.info("Become a vendor butonuna tiklanildi.");
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        extentTest.info(" https://tradylinn.com/vendor-register/ url’si görüldü.");
        //5_Kullanıcı geçerli bir mail girer
        firstPage.emailKutusu.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        extentTest.info("Geçerli bir mail girildi.");
        //6_Kullanıcı kucuk harf, büyük harf, rakam ve special karakter kullanarak şifre girer
        firstPage.passwordKutusu.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        extentTest.info("Geçerli bir password girildi.");
        //7_Kullanıcı strong yazısını görür
        softAssert.assertTrue(firstPage.strongYazisi.isDisplayed(),"Kullanici gecerli bir sifre girmedi.");
        extentTest.info("Strong yazisi görüldü.");
        //8_Kullanıcı tekrar şifre girer
        firstPage.confirmPasswordKutusu.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        extentTest.info("Tekrar password girildi.");
        //9_Kullanıcı register butonuna tıklar
        extentTest.info("Register Butonuna tiklanildi.");
        firstPage.registerButonu.click();
        //10_Kullanıcı Password and Confirm-password are not the same uyarısının görünmediğini test eder
        extentTest.pass("Password and Confirm-password are not the same uyarisi görülmedi.");
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test
    public void US01_TC08() {
        // Bu kısım TestCase'den cikarildi.
    }

}
