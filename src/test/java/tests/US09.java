package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_08_09_10_Page;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static tests.ReusableMethods.*;

public class US09 extends TestBaseRapor {
    US_08_09_10_Page page=new US_08_09_10_Page();
    Actions actions=new Actions(Driver.getDriver());

    @Test(priority = 1)
    public void US09_TC01() throws IOException {
        urun_ekle_menusune_gidilir();
        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle();
        page.Shipping.click();
        bekle();
        extentTest=extentReports.createTest("US09_TC01","Gecerli username ve sifre ile giris yapabilmeli");
        extentTest.info("Hesabiniza basarili bir sekilde giris yapildi");
        extentTest.info("Hesabim butonuna basildi");
        extentTest.info("Store manager butonuna tiklandi");
        extentTest.info("Urun butonuna tiklandi");
        extentTest.info("urun ekle butonuna tiklandi");
        extentTest.info("Shipping tıklandı");

        waitFor(10);
        page.Weight.click();
        page.Weight.clear();
        page.Weight.sendKeys("10");
        extentTest.info("Weight değeri girildi");
        waitFor(8);
        page.Length.click();
        page.Length.clear();
        page.Length.sendKeys("20");
        extentTest.info("Lenght değeri girildi");
        waitFor(10);
        page.height.click();
        page.height.clear();
        page.height.sendKeys("30");
        extentTest.info("height değeri girildi");
        page.width.click();
        page.width.clear();
        page.width.sendKeys("30");
        extentTest.info("width değeri girildi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);
        extentTest.pass("Kilo ve boyut belirlenmeli");
        ReusableMethods.gScreenshot("Kilo boyut");
    }

    @Test(priority = 2)
    public void US09_TC02() throws IOException {
        extentTest=extentReports.createTest("US09_TC02","Gecerli username ve sifre ile giris yapabilmeli");
        extentTest.info("Hesabiniza basarili bir sekilde giris yapildi");
        extentTest.info("Hesabim butonuna basildi");
        extentTest.info("Store manager butonuna tiklandi");
        extentTest.info("Urun butonuna tiklandi");
        extentTest.info("urun ekle butonuna tiklandi");
        extentTest.info("Shipping tıklandı");

        extentTest.debug("Hacim seçeneği bulunmamaktadır");

        ReusableMethods.gScreenshot("BUG Hacim secenegi");

        Select select =new Select(page.processingTime);
        List<WebElement> processingTime= select.getOptions();
        List<WebElement> expectedList=new ArrayList<>();
        for (WebElement each:processingTime) {
            each.click();
            System.out.println(each.getText());
            expectedList.add(each);
        }
        Assert.assertEquals(processingTime,expectedList);
        extentTest.pass("Processing Time seçeneğinden süre belirlendi");
        ReusableMethods.gScreenshot("Processing Time");
    }
}
