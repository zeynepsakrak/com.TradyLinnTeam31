package tests;

import org.apache.poi.ss.formula.functions.Value;
import org.openqa.selenium.Keys;
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

    @Test (priority = 1)
    public void US13_TC01() throws InterruptedException {
        //US13_TC01_Coupon kodu verilmeli
        //1., 2., 3. Stepler
        login();
        Thread.sleep(8000);

        //4. Kullanıcı "Hesabım" butonunu tıklar
        us_13_14_page.hesabimButonu.click();

        //5. Kullanıcı "Store Manager" butonunu tıklar
        us_13_14_page.storeManagerButonu.click();

        //6. Kullanıcı "Kuponlar" butonunu tıklar
        us_13_14_page.kuponlarButonu.click();

        //7. Kullanıcı "Yeni ekle" butonunu tıklar
        us_13_14_page.kuponlarYeniButonu.click();

        //8. Kullanıcı "Code" alanına veri girer
        Random rnd = new Random();
        String codeID= String.valueOf(rnd.nextInt(10000));
        us_13_14_page.codeText.sendKeys(codeID,Keys.TAB);

        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();

        //10. Kullanıcı "Code" alanına veri girildiğine test eder
        String expectedCode = codeID;
        String actualcode = us_13_14_page.codeText.getAttribute("value");
        Assert.assertEquals(actualcode, expectedCode);

    }

    @Test(dependsOnMethods = "US13_TC01",priority = 2)
    public void US13_TC02() throws InterruptedException {
        //US13_TC02_Tanimlama yazılmalı
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır
        Thread.sleep(5000);

        //8. Kullanıcı "Description" alanına veri girer
        us_13_14_page.descriptionText.sendKeys(ConfigReader.getProperty("tradyDescriptionSabit"), Keys.TAB);
        Thread.sleep(5000);

        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        Thread.sleep(5000);

        //10. Kullanıcı "Description" alanına veri girildiğine test eder
        String expectedDescription = ConfigReader.getProperty("tradyDescriptionSabit");
        String actualDescription = us_13_14_page.descriptionText.getAttribute("value");
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test(dependsOnMethods = "US13_TC01",priority = 3)
    public void US13_TC03() throws InterruptedException {
        //US13_TC03_Indirim sekli / discount
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır

        //8. Kullanıcı "Discount Type" alanı "Percentage discount" seçilir.
        Thread.sleep(5000);
        Select select=new Select(us_13_14_page.discountTypeText);
        select.selectByIndex(1);
        Thread.sleep(5000);

        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        Thread.sleep(5000);

        //10. Kullanıcı "Discount Type" alanı "Percentage discount" olduğunu test eder
        String expectedDescription = "Fixed Product Discount";
        String actualDescription = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDescription, expectedDescription);

        //11. Kullanıcı "Discount Type" alanı "Fixed Product Discount" seçilir.
        select=new Select(us_13_14_page.discountTypeText);
        select.selectByIndex(0);

        //12. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        Thread.sleep(5000);

        //13. Kullanıcı "Discount Type" alanı "Fixed Product Discount" olduğunu test eder
        expectedDescription = "Percentage discount";
        actualDescription = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test(dependsOnMethods = "US13_TC01",priority = 4)
    public void US13_TC04() throws InterruptedException {
        //US13_TC02_Tanimlama yazılmalı
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır

        //8. Kullanıcı "Coupon Amount" alanına veri girer
        us_13_14_page.couponAmountText.clear();
        us_13_14_page.couponAmountText.sendKeys(ConfigReader.getProperty("tradyCouponAmount"), Keys.TAB);

        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        Thread.sleep(5000);
        //10. Kullanıcı "Coupon Amount" alanına veri girildiğine test eder
        String expectedDescription = ConfigReader.getProperty("tradyCouponAmount");
        String actualDescription = us_13_14_page.couponAmountText.getAttribute("value");
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test(dependsOnMethods = "US13_TC01",priority = 5)
    public void US13_TC05() throws InterruptedException {
        //US13_TC02_Tanimlama yazılmalı
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır

        //8. Kullanıcı "Coupon expiry date" alanına veri girer
        us_13_14_page.couponexpirydateText.sendKeys(ConfigReader.getProperty("tradyKCouponExpiryDate"), Keys.TAB);

        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        Thread.sleep(5000);

        //10.Kullanıcı "Coupon expiry date" alanına veri girildiğine test eder
        String expectedDescription = ConfigReader.getProperty("tradyKCouponExpiryDate");
        String actualDescription = us_13_14_page.couponexpirydateText.getAttribute("value");
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test(dependsOnMethods = "US13_TC01",priority = 6)
    public void US13_TC06() throws InterruptedException {
        //US13_TC02_Tanimlama yazılmalı
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır

        //8. Kullanıcı "Allow free shipping" alanına tik atar
        us_13_14_page.allowfreeshippingCheck.click();

        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        Thread.sleep(5000);

        //10. Kullanıcı "Allow free shipping" alanı tikli olduğunu test eder
        Assert.assertTrue(us_13_14_page.allowfreeshippingCheck.isSelected());
    }

    @Test(dependsOnMethods = "US13_TC01",priority = 7)
    public void US13_TC07() throws InterruptedException {
        //US13_TC02_Tanimlama yazılmalı
        //1.,2., 3., 4., 5., 6., 7. adımlar US13_TC01 test metoduna bağlı çalışır

        //8. Kullanıcı "Show on store" alanına tik atar
        us_13_14_page.showonstoreCheck.click();
        Thread.sleep(3000);
        //9. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        Thread.sleep(5000);

        //10. Kullanıcı "Show on store" alanı tikli olduğunu test eder
        Assert.assertTrue(us_13_14_page.showonstoreCheck.isSelected());

        //11. Kullanıcı "Submit" butonuna tıklar
        us_13_14_page.submitButonu.click();

        //12. Kullanıcı Kayıt yapıldığını kontrol eder
        Assert.assertTrue(us_13_14_page.submitOnayYazisi.getText().contains("Coupon Successfully Published."));
    }
}
