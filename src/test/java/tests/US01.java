package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_01_02_Page;
import utilities.ConfigReader;
import utilities.Driver;

import static tests.Login.login;

public class US01 {
    US_01_02_Page firstPage=new US_01_02_Page();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void US01_TC01() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        //3_Kullanıcı Become a vendor butonunun göründüğünü test eder
        Assert.assertTrue(firstPage.saticiOl.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void US01_TC02() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        //5_Kullanıcı Email kutusunun göründüğünü test eder
        softAssert.assertTrue(firstPage.emailKutusu.isDisplayed(),"Email kutusu gorunmuyor.");
        //6_Kullanıcı Password kutusunun göründüğünü test eder
        softAssert.assertTrue(firstPage.emailKutusu.isDisplayed(),"Password kutusu gorunmuyor.");
        //7_Kullanıcı Confirm Password kutusunun göründüğünü test eder
        softAssert.assertTrue(firstPage.emailKutusu.isDisplayed(),"Confirm Password kutusu gorunmuyor.");
        softAssert.assertAll();
    }

    @Test
    public void US01_TC03() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        //5_Kullanıcı geçerli bir mail girer
        firstPage.emailKutusu.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        //6_Kullanıcı Register Butonuna tıklar.
        firstPage.registerButonu.click();
        //7_Kullanıcı Email butonunun yeşil yandığını test eder

    }

    @Test
    public void US01_TC04() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        //5_Kullanıcı mail kutusunu boş bırakır.
        firstPage.emailKutusu.sendKeys("");
        //6_Kullanıcı Register Butonuna tıklar.
        firstPage.registerButonu.click();
        //7_Kullanıcı Email: This field is required uyarısının göründüğünü test eder

    }

    @Test
    public void US01_TC05() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        //5_Kullanıcı geçerli bir mail girer
        firstPage.emailKutusu.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        //6_Kullanıcı kucuk harf, büyük harf, rakam ve special karakter kullanarak şifre girer
        firstPage.passwordKutusu.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        //7_Kullanıcı strong yazısını görür

        //8_Kullanıcı tekrar şifre girer
        firstPage.confirmPasswordKutusu.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        //9_Kullanıcı register butonuna tıklar
        firstPage.registerButonu.click();
        //10_Kullanıcı This Email already exists.Please login to the site
        // and apply as vendor uyarısının görünmediğini test eder


    }

    @Test
    public void US01_TC06() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        //5_Kullanıcı geçerli bir mail girer
        firstPage.emailKutusu.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        //6_Kullanıcı kucuk harf, büyük harf, rakam ve special karakter kullanarak şifre girer
        firstPage.passwordKutusu.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        //7_Kullanıcı strong yazısının göründüğünü test eder

    }

    @Test
    public void US01_TC07() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        //2_Kullanıcı Sign Up butonuna tıklar.
        firstPage.uyeOl.click();
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        firstPage.saticiOl.click();
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        String accualUrl= Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://tradylinn.com/vendor-register/";
        softAssert.assertEquals(accualUrl,accualUrl,
                "Beklenen URL bulunamadi.");
        //5_Kullanıcı geçerli bir mail girer
        firstPage.emailKutusu.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        //6_Kullanıcı kucuk harf, büyük harf, rakam ve special karakter kullanarak şifre girer
        firstPage.passwordKutusu.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        //7_Kullanıcı strong yazısını görür

        //8_Kullanıcı tekrar şifre girer
        firstPage.confirmPasswordKutusu.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        //9_Kullanıcı register butonuna tıklar
        firstPage.registerButonu.click();
        //10_Kullanıcı Password and Confirm-password are not the same uyarısının görünmediğini test eder
    }

    @Test
    public void US01_TC08() {
        // ...
    }

}
