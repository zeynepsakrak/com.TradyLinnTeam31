package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_05_06_07_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.ReusableMethods.bekle;

public class US06 extends TestBaseRapor{
    US_05_06_07_Page us_05_06_07_page;
    @Test
    public void UC06_TC01() throws InterruptedException {
        extentTest=extentReports.createTest("UC06_TC01", "Catagori tiklanabilir ve isaretlenebilir");
        //Kullanici vendor olarak hesabina gider
        us_05_06_07_page=new US_05_06_07_Page();
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest.info("tradylinn Anasayfaya gidildi");
        us_05_06_07_page.girisButonu.click();
        extentTest.info("Giris butonu tiklandi");
        us_05_06_07_page.userName.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        extentTest.info("Gecerli bit mail gidildi");
        us_05_06_07_page.pasword.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        extentTest.info("Gecerli bir Password gidildi");
        us_05_06_07_page.girisYapButonu.click();
        extentTest.info("Giris yapildi");
        bekle();
        us_05_06_07_page.hesabimButonu.click();
        extentTest.info("hesabim buttonu tiklandi");
        //Kullanici Store Manager butonuna tiklar
        us_05_06_07_page.storeManagerButonu.click();
        extentTest.info("storManager Buttonu tiklandi");
        //Kullanici Urunler butonuna ve yeni ekle butonuna tiklar
        us_05_06_07_page.urunButonu.click();
        us_05_06_07_page.yeniEkleButonu.click();
        extentTest.info("Yeni ekle buttonu tiklandi");
        /*
        Kullanici Catagories kismina gider
        Kullanici secilen ürünlerin katagorilerinin tiklanabildigi ve isaretlendigi kontrol edilir
         */
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle();
        actions.click(us_05_06_07_page.categories).sendKeys(Keys.PAGE_DOWN).perform();
        us_05_06_07_page.musikClickBox.click();
        extentTest.info("Musik katagorisi tiklandi");
        Assert.assertTrue(us_05_06_07_page.musikClickBox.isSelected());
        extentTest.pass("Musik katagorisinin isaretli oldugu goruldu");
        Driver.closeDriver();
    }
}
