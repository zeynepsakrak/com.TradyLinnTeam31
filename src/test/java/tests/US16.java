package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_15_16_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.ReusableMethods.bekle;
import static tests.ReusableMethods.waitFor;

public class US16 extends TestBaseRapor{
    US_15_16_Page us_15_16_page = new US_15_16_Page();

    @Test(priority = 1)
    public void TC_01() throws InterruptedException {

        //1- Siteye git:https://tradylinn.com/ gidilebilir
        Driver.getDriver().get(ConfigReader.getProperty("tradllyinnUrl"));
        extentReports.createTest("US16_TC_01", "Gecerli email ve sifre ile giris yapabilmeli");

        //2 -Vendor "My Account" butonuna tiklanir
        us_15_16_page.myAccount.click();

        //3- Vendor "username or email address" ve "password" bilgileri girer ve "login" butonuna tiklanir
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("tradllyinnEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("tradllyinnPassword"));
        ReusableMethods.waitFor(10);
        us_15_16_page.login.sendKeys(Keys.ENTER);

        //4-Vendor "Store Manager" butonuna tiklanir
        us_15_16_page.storeManager.click();

        //5-Vendor "customers" butonuna tiklanir
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(10);
        us_15_16_page.customers.click();

        //6- kayitli kisinin son siparisi gorulebilmeli
        Assert.assertTrue(us_15_16_page.sonSiparis.isDisplayed());
        extentReports.createTest("kayitli kisinin son siparisi gorulebildi");

        ReusableMethods.waitFor(5);
        Driver.closeDriver();
    }

    @Test(dependsOnMethods = "TC_01",priority = 2)
    public void TC_02() throws InterruptedException {

        //1- Siteye git:https://tradylinn.com/ gidilebilir
        Driver.getDriver().get(ConfigReader.getProperty("tradllyinnUrl"));
        extentReports.createTest("US16_TC_02", "Gecerli email ve sifre ile giris yapabilmeli");

        //2 -Vendor "My Account" butonuna tiklanir
        ReusableMethods.waitFor(5);
        us_15_16_page.myAccount.click();

        //3- Vendor "username or email address" ve "password" bilgileri girer ve "login" butonuna tiklanir
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("tradllyinnEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("tradllyinnPassword"));

        ReusableMethods.waitFor(10);
        us_15_16_page.login.sendKeys(Keys.ENTER);

        //4-Vendor "Store Manager" butonuna tiklanir
        ReusableMethods.waitFor(10);
        us_15_16_page.storeManager.click();

        //5-Vendor "customers" butonuna tiklanir
        ReusableMethods.waitFor(10);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(10);
        us_15_16_page.customers.click();

        //6- kayitli kisilerin bilgileri "pdf" "excell" ve "csa" olarak tiklanir
        us_15_16_page.printButon.click();
        us_15_16_page.excelButon.click();
        us_15_16_page.csaButon.click();
        extentReports.createTest("kayitli kisilerin bilgileri \"pdf\" \"excell\" ve \"csa\" olarak tiklandi ");

        Driver.closeDriver();
    }

    @Test(dependsOnMethods = "TC_02",priority = 3)
    public void TC_03() throws InterruptedException {

        //1- Siteye git:https://tradylinn.com/ gidilebilir
        Driver.getDriver().get(ConfigReader.getProperty("tradllyinnUrl"));
        extentReports.createTest("US16_TC_03", "Gecerli email ve sifre ile giris yapabilmeli");

        //2 -Vendor "My Account" butonuna tiklanir
        us_15_16_page.myAccount.click();

        //3- Vendor "username or email address" ve "password" bilgileri girer ve "login" butonuna tiklanir
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("tradllyinnEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("tradllyinnPassword"));
        ReusableMethods.waitFor(1);
        us_15_16_page.login.sendKeys(Keys.ENTER);

        //4-Vendor "Store Manager" butonuna tiklanir
        us_15_16_page.storeManager.click();

        //5-Vendor "customers" butonuna tiklanir
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(10);
        us_15_16_page.customers.click();

        //6-  "Add New Customer " butonuna tiklanir
        us_15_16_page.newCustomers.click();

        //7- Kullanici bilgileri username,email,name ve lastname girilebilir
        Faker faker = new Faker();
        actions.click(us_15_16_page.newUsername).
                sendKeys(faker.internet().domainName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().domainName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().domainName()).perform();
        extentReports.createTest("Kullanici bilgileri username,email,name ve lastname girilebildi");

        //8- "submit" butonuna tiklanir
        ReusableMethods.waitFor(10);
        us_15_16_page.submit.sendKeys(Keys.ENTER);

    }
}
