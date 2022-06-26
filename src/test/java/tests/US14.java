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

import javax.swing.*;
import java.util.List;
import java.util.Random;

import static tests.Login.login;

public class US14 {
    US_13_14_Page us_13_14_page = new US_13_14_Page();
    Actions action = new Actions(Driver.getDriver());

    @Test(priority = 1)
    public void US14_TC01(){
        //US14_TC01_Minimum spend / en az alma miktari girilmeli
        //1., 2., 3. Stepler
        login();
        ReusableMethods.bekle();

        //4. Kullanıcı "Hesabım" butonunu tıklar
        us_13_14_page.hesabimButonu.click();

        //5. Kullanıcı "Store Manager" butonunu tıklar
        us_13_14_page.storeManagerButonu.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();

        //6. Kullanıcı "Kuponlar" butonunu tıklar
        us_13_14_page.kuponlarButonu.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();

        //7. Kullanıcı "Yeni ekle" butonunu tıklar
        us_13_14_page.kuponlarYeniButonu.click();
        action.sendKeys(Keys.PAGE_DOWN).perform();

        //8. Kullanıcı "Code" alanına veri girer
        Random rnd = new Random();
        String codeID = String.valueOf(rnd.nextInt(10000));
        us_13_14_page.codeText.sendKeys(codeID, Keys.TAB);

        //9. Kullanıcı "Restriction" butonunu tıklar
        us_13_14_page.restrictionButonu.click();

        //10. Kullanıcı "Minimum spend" alanına veri girer
        us_13_14_page.minimumspendText.sendKeys(ConfigReader.getProperty("tradyminimumspend"));

        //11. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        ReusableMethods.bekle();

        //12. Kullanıcı "Minimum spend" alanına veri girildiğine test eder
        String expectedDescription = ConfigReader.getProperty("tradyminimumspend");
        String actualDescription = us_13_14_page.minimumspendText.getAttribute("value");
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test(dependsOnMethods = "US14_TC01", priority = 2)
    public void US14_TC02() {
        //US14_TC02_Maximum spend / maksimum alma miktarı girilmeli
        //1., 2., 3. 4., 5., 6., 7., 8.  Stepler US14_TC01 testten alıyor

        //9. Kullanıcı "Restriction" butonunu tıklar
        action.sendKeys(Keys.PAGE_UP).perform();
        us_13_14_page.restrictionButonu.click();

        //10. Kullanıcı "Maximum spend" alanına veri girer
        us_13_14_page.maximumspendText.sendKeys(ConfigReader.getProperty("tradymaximumspend"));

        //11. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        ReusableMethods.bekle();

        //12. Kullanıcı "Maximum spend" alanına veri girildiğine test eder
        String expectedDescription = ConfigReader.getProperty("tradymaximumspend");
        String actualDescription = us_13_14_page.maximumspendText.getAttribute("value");
        Assert.assertEquals(actualDescription, expectedDescription);
    }

    @Test(dependsOnMethods = "US14_TC01", priority = 3)
    public void US14_TC03() throws InterruptedException {
        //US14_TC03_Individual use only / kisisel kullanım sadece secenegi olmalı
        //1., 2., 3. 4., 5., 6., 7., 8.  Stepler US14_TC01 testten alıyor

        //9. Kullanıcı "Restriction" butonunu tıklar
        action.sendKeys(Keys.PAGE_UP).perform();
        us_13_14_page.restrictionButonu.click();

        //10. Kullanıcı "Individual use only" alanına tik atar
        us_13_14_page.IndividualuseonlyCheck.click();

        //11. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        ReusableMethods.bekle();

        //12. Kullanıcı "Individual use only" alanı tikli olduğunu test eder
        Assert.assertTrue(us_13_14_page.IndividualuseonlyCheck.isSelected());
    }

    @Test(dependsOnMethods = "US14_TC01", priority = 4)
    public void US14_TC04() {
        //US14_TC04_Exclude sale items / bazi satis ürünleri disinda tut
        //1., 2., 3. 4., 5., 6., 7., 8.  Stepler US14_TC01 testten alıyor

        //9. Kullanıcı "Restriction" butonunu tıklar
        us_13_14_page.restrictionButonu.click();

        //10. Kullanıcı "Exclude sale items" alanına tik atar
        us_13_14_page.excludesaleitemsCheck.click();

        //11. Kullanıcı "Draft" butonuna tiklar
        us_13_14_page.draftButonu.click();
        ReusableMethods.bekle();

        //12. Kullanıcı "Exclude sale items" alanı tikli olduğunu test eder
        Assert.assertTrue(us_13_14_page.excludesaleitemsCheck.isSelected());
    }

    @Test(dependsOnMethods = "US14_TC01", priority = 5)
    public void US14_TC05() {
        //US14_TC05_Exclude categories / bazi kategorileri disinda tut
        //1., 2., 3. 4., 5., 6., 7., 8.  Stepler US14_TC01 testten alıyor

        //9. Kullanıcı "Restriction" butonunu tıklar
        ReusableMethods.bekle();
        us_13_14_page.restrictionButonu.click();

        //10. Kullanıcı "Exclude categories" alanına "Besin takviyesi" ve "Yeni ürünler" seçer
        Select select = new Select(us_13_14_page.excludecategories);
        select.selectByIndex(6);
        select.selectByIndex(16);
        List<WebElement> secilen=select.getAllSelectedOptions();
        String expectedcategories="";
        for (WebElement each: secilen){
            expectedcategories+="×"+each.getText();
        }

       //11. Kullanıcı "Draft" butonuna tiklar
          us_13_14_page.draftButonu.click();
        ReusableMethods.bekle();

        // 12. Kullanıcı "Exclude categories" alanında "Besin takviyesi" ve "Yeni ürünler" seçili olduğunu test eder
        String actualcategories="";
        for (WebElement each:us_13_14_page.categoriesSelectedList){
            actualcategories+=each.getText();
        }
        Assert.assertEquals(actualcategories,expectedcategories);

        //13. Kullanıcı "Submit" butonuna tıklar
        ReusableMethods.bekle();
        us_13_14_page.submitButonu.click();

        //14. Kullanıcı Kayıt yapıldığını kontrol eder
        Assert.assertTrue(us_13_14_page.submitOnayYazisi.getText().contains("Coupon Successfully Published."));
    }
}
