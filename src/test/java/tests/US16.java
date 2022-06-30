package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_15_16_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.IOException;


public class US16 extends TestBaseRapor {
    US_15_16_Page us_15_16_page = new US_15_16_Page();

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC_01() throws InterruptedException, IOException {

        //1- Siteye git:https://tradylinn.com/ gidilebilir
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest = extentReports.createTest("US16_TC_01", "Gecerli email ve sifre ile giris yapabilmeli");

        //2 -Vendor "My Account" butonuna tiklanir
        us_15_16_page.myAccount.click();
        extentTest.info("Vendor My Account butonuna tikladi");

        //3- Vendor "username or email address" ve "password" bilgileri girer ve "login" butonuna tiklanir
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        ReusableMethods.waitFor(10);
        us_15_16_page.login.sendKeys(Keys.ENTER);
        extentTest.info("Vendor username or email address ve password bilgileri girdi ve login butonuna tikladi");

        //4-Vendor "Store Manager" butonuna tiklanir
        //us_15_16_page.storeManager.click();
        WebElement storeManager = Driver.getDriver().findElement(By.xpath("//a[normalize-space()='Store Manager']"));
        jse.executeScript("arguments[0].click();", storeManager);
        extentTest.info("Vendor Store Manager butonuna tikladi");

        //5-Vendor "customers" butonuna tiklanir
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(10);
        us_15_16_page.customers.click();
        extentTest.info("Vendor customers butonuna tikladi");

        //6- kayitli kisinin son siparisi gorulebilmeli
        Assert.assertTrue(us_15_16_page.sonSiparis.isDisplayed());
        extentTest.pass("kayitli kisinin son siparisi gorulebildi");
        ReusableMethods.getScreenshot("son siparisi goruldu");
        Driver.closeDriver();

    }

    @Test
    public void TC_02() throws InterruptedException, IOException {


        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest = extentReports.createTest("US16_TC_02", "Gecerli email ve sifre ile giris yapabilmeli");


        ReusableMethods.waitFor(5);
        WebElement myAccount = Driver.getDriver().findElement(By.xpath("//li[@id='menu-item-1074']//a[contains(text(),'Hesabım')]"));
        jse.executeScript("arguments[0].click();", myAccount);
        extentTest.info("Vendor My Account butonuna tikladi");


        ReusableMethods.waitFor(5);
        us_15_16_page.username.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        ReusableMethods.waitFor(10);
        us_15_16_page.login.sendKeys(Keys.ENTER);
        extentTest.info("Vendor username or email address ve password bilgileri girer ve login butonuna tikladi");


        ReusableMethods.waitFor(10);
        us_15_16_page.storeManager.click();
        extentTest.info("Vendor Store Manager butonuna tiklandi");


        ReusableMethods.waitFor(10);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(10);
        us_15_16_page.customers.click();
        extentTest.info("Vendor customer butonuna tiklandi");


        us_15_16_page.printButon.click();
        us_15_16_page.excelButon.click();
        us_15_16_page.csaButon.click();
        extentReports.createTest("kayitli kisilerin bilgileri \"pdf\" \"excell\" ve \"csa\" olarak tiklandi ");
        ReusableMethods.getScreenshot("son siparisi goruldu");
        Driver.closeDriver();
    }

    @Test
    public void TC_03() throws InterruptedException, IOException {


        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        extentTest = extentReports.createTest("US16_TC_03", "Gecerli email ve sifre ile giris yapabilmeli");


        us_15_16_page.myAccount.click();
        extentTest.info("Vendor My Account butonuna tikladi");


        us_15_16_page.username.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        us_15_16_page.password.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        ReusableMethods.waitFor(1);
        us_15_16_page.login.sendKeys(Keys.ENTER);
        extentTest.info("Vendor username or email address ve password bilgileri girer ve login butonuna tikladi");


        us_15_16_page.storeManager.click();
        extentTest.info("Vendor Store Manager butonuna tiklandi");


        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(10);
        us_15_16_page.customers.click();
        extentTest.info("Vendor customer butonuna tiklandi");


        us_15_16_page.newCustomers.click();
        extentTest.info("Add New Customer butonuna tiklandi");


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
        ReusableMethods.getScreenshot("kullanici bilgileri girilebildi");


        ReusableMethods.waitFor(10);
        us_15_16_page.submit.sendKeys(Keys.ENTER);
        extentTest.info("submit butonuna tiklandi");
        Driver.closeDriver();

    }
}
