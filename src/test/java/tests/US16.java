package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_15_16_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US16 {
    US_15_16_Page us_15_16_page = new US_15_16_Page();

    @Test
    public void TestCase01() throws InterruptedException {


        //1-Siteye git:https://tradylinn.com/ gidilebilir
        Driver.getDriver().get(ConfigReader.getProperty("tradllyinnUrl"));

        //2 -Vendor "My Account" butonuna tiklanir
        us_15_16_page.myAccount.click();

        //3- Vendor "username or email address" ve "password" bilgileri girer ve "login" butonuna tiklanir
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("tradllyinnEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("tradllyinnPassword"));
        us_15_16_page.login.sendKeys(Keys.ENTER);

        //4-Vendor "Store Manager" butonuna tiklanir
        us_15_16_page.storeManager.sendKeys(Keys.ENTER);

        //5-Vendor "customers" butonuna tiklanir
        //Thread.sleep(3000);
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        us_15_16_page.customers.click();

        //6- kayitli kisinin son siparisi gorulebilmeli
        Assert.assertTrue(us_15_16_page.sonSiparis.isDisplayed());
    }


    @Test
    public void TestCase02() throws InterruptedException {

        //1-Siteye git:https://tradylinn.com/ gidilebilir
        Driver.getDriver().get(ConfigReader.getProperty("tradllyinnUrl"));

        //2 -Vendor "My Account" butonuna tiklanir
        us_15_16_page.myAccount.click();

        //3- Vendor "username or email address" ve "password" bilgileri girer ve "login" butonuna tiklanir
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("tradllyinnEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("tradllyinnPassword"));
        us_15_16_page.login.sendKeys(Keys.ENTER);

        //4-Vendor "Store Manager" butonuna tiklanir
        us_15_16_page.storeManager.sendKeys(Keys.ENTER);

        //5-Vendor "customers" butonuna tiklanir
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        us_15_16_page.customers.click();

        //6- kayitli kisilerin bilgileri "pdf" "excell" ve "csa" olarak tiklanir
        us_15_16_page.printButon.click();
        us_15_16_page.excelButon.click();
        us_15_16_page.csaButon.click();
    }

    @Test
    public void TestCase03() throws InterruptedException {

        //1-Siteye git:https://tradylinn.com/ gidilebilir
        Driver.getDriver().get(ConfigReader.getProperty("tradllyinnUrl"));

        //2 -Vendor "My Account" butonuna tiklanir
        us_15_16_page.myAccount.click();

        //3- Vendor "username or email address" ve "password" bilgileri girer ve "login" butonuna tiklanir
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("tradllyinnEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("tradllyinnPassword"));
        us_15_16_page.login.sendKeys(Keys.ENTER);

        //4-Vendor "Store Manager" butonuna tiklanir
        us_15_16_page.storeManager.sendKeys(Keys.ENTER);

        //5-Vendor "customers" butonuna tiklanir
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        us_15_16_page.customers.click();

        //6-  "Add New Customer " butonuna tiklanir
        us_15_16_page.newCustomers.click();

        //7- Kullanici bilgileri username,email,name ve lastname girilebilir
        Faker faker=new Faker();
        actions.click(us_15_16_page.newUsername).
                sendKeys(faker.internet().domainName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().domainName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().domainName()).perform();

        //8- "submit" butonuna tiklanir
        Thread.sleep(5000);
        us_15_16_page.submit.sendKeys(Keys.ENTER);

        Driver.closeDriver();
    }

}
