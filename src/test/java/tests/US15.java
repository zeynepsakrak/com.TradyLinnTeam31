package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_15_16_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US15 {
    US_15_16_Page us_15_16_page=new US_15_16_Page();

    @Test
    public void Test01_02_03() throws InterruptedException {


        //1- Siteye git:https://tradylinn.com/ gidilebilir
        Driver.getDriver().get(ConfigReader.getProperty("tradllyinnUrl"));

        //2 -Vendor "My Account" butonuna tiklanir
        us_15_16_page.myAccount.click();

        //3- Vendor "username or email address" ve "password" bilgileri girer ve "login" butonuna tiklanir
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("tradllyinnEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("tradllyinnPassword"));
        us_15_16_page.login.sendKeys(Keys.ENTER);

        //4-Vendor "Store Manager" butonuna tiklanir
        us_15_16_page.storeManager.click();

        //5-Vendor "Coupons" butonuna tiklanir
        us_15_16_page.coupons.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        //6- Vendor "add new "butonuna tiklanir
        us_15_16_page.addNew.click();

        //7- Vendor "limit" butonuna tiklanir


        Actions action=new Actions(Driver.getDriver());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        us_15_16_page.limit.click();

        //8- Vendor "Usage limit per coupon" limiti bilgileri eklenebilir

        //action.sendKeys(Keys.TAB);
        us_15_16_page.usageLimitCoupon.sendKeys("5");
        us_15_16_page.usLimitItems.sendKeys("5");
        us_15_16_page.perUser.sendKeys("5");

        Assert.assertTrue(us_15_16_page.usageLimitCoupon.getAttribute("value").contains("5"));
        Assert.assertTrue(us_15_16_page.usLimitItems.getAttribute("value").contains("5"));
        Assert.assertTrue(us_15_16_page.perUser.getAttribute("value").contains("5"));
        //Driver.closeDriver();



    }
}

