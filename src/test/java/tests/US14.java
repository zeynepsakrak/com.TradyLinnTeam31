package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_13_14_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import javax.swing.*;
import java.util.List;
import java.util.Random;

import static tests.Login.login;

public class US14 extends TestBaseRapor {
    US_13_14_Page us_13_14_page = new US_13_14_Page();
    Actions action = new Actions(Driver.getDriver());

    @Test(priority = 1)
    public void US14_TC01() {
        extentTest = extentReports.createTest("US14_TC01", "Minimum spend / en az alma miktari girilmeli");
        login();                                    //1., 2., 3. Stepler
        ReusableMethods.bekle();
        us_13_14_page.hesabimButonu.click();        //4. Kullanıcı "Hesabım" butonunu tıklar
        us_13_14_page.storeManagerButonu.click();   //5. Kullanıcı "Store Manager" butonunu tıklar
        action.sendKeys(Keys.PAGE_DOWN).perform();
        us_13_14_page.kuponlarButonu.click();       //6. Kullanıcı "Kuponlar" butonunu tıklar
        action.sendKeys(Keys.PAGE_DOWN).perform();
        us_13_14_page.kuponlarYeniButonu.click();   //7. Kullanıcı "Yeni ekle" butonunu tıklar
        action.sendKeys(Keys.PAGE_DOWN).perform();
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
        action.sendKeys(Keys.PAGE_UP).perform();
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
        action.sendKeys(Keys.PAGE_UP).perform();
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
}
