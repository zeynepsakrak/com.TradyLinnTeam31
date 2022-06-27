package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_13_14_Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Random;

import static tests.Login.login;

public class US13 {
    US_13_14_Page us_13_14_page = new US_13_14_Page();
    Actions action = new Actions(Driver.getDriver());

    @Test(priority = 1)
    public void US13_TC01() {
        extentTest=extentReports.createTest("US13_TC01","Coupon kodu verilmeli");
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
        us_13_14_page.draftButonu.click();          //9. Kullanıcı "Draft" butonuna tiklar
        ReusableMethods.bekle();
        String expectedCode = codeID;
        String actualcode = us_13_14_page.codeText.getAttribute("value");
        Assert.assertEquals(actualcode, expectedCode);  //10. Kullanıcı "Code" alanına veri girildiğine test eder
        extentTest.info("'Kupon Code' alanına veri girilebiliyor");
    }

    @Test(dependsOnMethods = "US13_TC01", priority = 2)
    public void US13_TC02() {
        extentTest=extentReports.createTest("US13_TC02","Tanimlama yazılmalı");
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır
        action.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle();
        us_13_14_page.descriptionText.sendKeys(ConfigReader.getProperty("tradyDescriptionSabit"), Keys.TAB);//8. Kullanıcı "Description" alanına veri girer
        us_13_14_page.draftButonu.click();                              //9. Kullanıcı "Draft" butonuna tiklar
        ReusableMethods.bekle();
        String expectedDescription = ConfigReader.getProperty("tradyDescriptionSabit");
        String actualDescription = us_13_14_page.descriptionText.getAttribute("value");
        Assert.assertEquals(actualDescription, expectedDescription);    //10. Kullanıcı "Description" alanına veri girildiğine test eder
        extentTest.info("'Description' alanına veri girilebiliyor");
    }

    @Test(dependsOnMethods = "US13_TC01", priority = 3)
    public void US13_TC03() {
        extentTest=extentReports.createTest("US13_TC02","Tanimlama yazılmalı");
        //US13_TC03_Indirim sekli / discount
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır

        //8. Kullanıcı "Discount Type" alanı "Percentage discount" seçilir.
        action.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle();
        Select select = new Select(us_13_14_page.discountTypeText);
        select.selectByIndex(1);


        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        ReusableMethods.bekle();

        //10. Kullanıcı "Discount Type" alanı "Percentage discount" olduğunu test eder
        String expectedDescription = "Fixed Product Discount";
        String actualDescription = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDescription, expectedDescription);

        //11. Kullanıcı "Discount Type" alanı "Fixed Product Discount" seçilir.
        action.sendKeys(Keys.PAGE_UP).perform();
        select = new Select(us_13_14_page.discountTypeText);
        select.selectByIndex(0);

        //12. Kullanıcı "Draft" butonuna tiklar
        ReusableMethods.bekle();
        us_13_14_page.draftButonu.click();
        ReusableMethods.bekle();

        //13. Kullanıcı "Discount Type" alanı "Fixed Product Discount" olduğunu test eder
        expectedDescription = "Percentage discount";
        actualDescription = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test(dependsOnMethods = "US13_TC01", priority = 4)
    public void US13_TC04() {
        //US13_TC02_Tanimlama yazılmalı
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır
        action.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle();
        //8. Kullanıcı "Coupon Amount" alanına veri girer
        us_13_14_page.couponAmountText.clear();
        us_13_14_page.couponAmountText.sendKeys(ConfigReader.getProperty("tradyCouponAmount"), Keys.TAB);

        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        ReusableMethods.bekle();
        //10. Kullanıcı "Coupon Amount" alanına veri girildiğine test eder
        String expectedDescription = ConfigReader.getProperty("tradyCouponAmount");
        String actualDescription = us_13_14_page.couponAmountText.getAttribute("value");
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test(dependsOnMethods = "US13_TC01", priority = 5)
    public void US13_TC05() {
        //US13_TC02_Tanimlama yazılmalı
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır
        action.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle();

        //8. Kullanıcı "Coupon expiry date" alanına veri girer
        us_13_14_page.couponexpirydateText.sendKeys(ConfigReader.getProperty("tradyKCouponExpiryDate"), Keys.TAB);

        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        ReusableMethods.bekle();

        //10.Kullanıcı "Coupon expiry date" alanına veri girildiğine test eder
        String expectedDescription = ConfigReader.getProperty("tradyKCouponExpiryDate");
        String actualDescription = us_13_14_page.couponexpirydateText.getAttribute("value");
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test(dependsOnMethods = "US13_TC01", priority = 6)
    public void US13_TC06() {
        //US13_TC02_Tanimlama yazılmalı
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır

        //8. Kullanıcı "Allow free shipping" alanına tik atar
        action.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle();
        us_13_14_page.allowfreeshippingCheck.click();

        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        ReusableMethods.bekle();

        //10. Kullanıcı "Allow free shipping" alanı tikli olduğunu test eder
        Assert.assertTrue(us_13_14_page.allowfreeshippingCheck.isSelected());
    }

    @Test(dependsOnMethods = "US13_TC01", priority = 7)
    public void US13_TC07() {
        //US13_TC02_Tanimlama yazılmalı
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır
        action.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.bekle();

        //8. Kullanıcı "Show on store" alanına tik atar
        us_13_14_page.showonstoreCheck.click();

        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        ReusableMethods.bekle();

        //10. Kullanıcı "Show on store" alanı tikli olduğunu test eder
        Assert.assertTrue(us_13_14_page.showonstoreCheck.isSelected());

        //11. Kullanıcı "Submit" butonuna tıklar
        ReusableMethods.bekle();
        us_13_14_page.submitButonu.click();

        //12. Kullanıcı Kayıt yapıldığını kontrol eder
        Assert.assertTrue(us_13_14_page.submitOnayYazisi.getText().contains("Coupon Successfully Published."));
    }

}
