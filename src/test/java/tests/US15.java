package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_15_16_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.ReusableMethods.waitFor;


public class US15 extends TestBaseRapor {
    US_15_16_Page us_15_16_page=new US_15_16_Page();

    @Test
    public void US15_TC_01_02_03() throws InterruptedException {

        //1- Siteye git:https://tradylinn.com/ gidilebilir
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentReports.createTest("US15_TC_01_02_03","Gecerli email ve sifre ile giris yapabilmeli");
        //2 -Vendor "My Account" butonuna tiklanir
        us_15_16_page.myAccount.click();
        //extentTest.info("myAccount butonu basilabildi");
        //3- Vendor "username or email address" ve "password" bilgileri girer ve "login" butonuna tiklanir
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        ReusableMethods.waitFor(1);
        us_15_16_page.login.sendKeys(Keys.ENTER);
        //extentTest.info("login butonu basilabildi");
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
}