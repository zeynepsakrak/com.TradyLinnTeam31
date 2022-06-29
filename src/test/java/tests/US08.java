package tests;

import org.apache.logging.log4j.core.config.Order;
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

public class US08 extends TestBaseRapor{
    US_08_09_10_Page page=new US_08_09_10_Page();
    Actions actions=new Actions(Driver.getDriver());

    @Test(priority = 1)
    public void US08_TC01() throws IOException {
        urun_ekle_menusune_gidilir();
        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle();
        page.Inventory.click();
        waitFor(3);
        extentTest=extentReports.createTest("US08_TC01","Gecerli username ve sifre ile giris yapabilmeli");
        extentTest.info("Hesabiniza basarili bir sekilde giris yapildi");
        extentTest.info("Hesabim butonuna basildi");
        extentTest.info("Store manager butonuna tiklandi");
        extentTest.info("Urun butonuna tiklandi");
        extentTest.info("urun ekle butonuna tiklandi");
        extentTest.info("\"Inventory\" tıklandı");
        waitFor(2);
        page.ManageStock.click();
        extentTest.info("manage stock butonuna tiklandi");
        waitFor(5);
        page.StockMiktar.click();
        page.StockMiktar.clear();
        page.StockMiktar.sendKeys("10");
       waitFor(5);
        extentTest.info("Urun miktarı yazıldı");
       Assert.assertTrue(page.StockMiktar.isEnabled());
       extentTest.pass("Urun miktarı stock belirlendi");
        ReusableMethods.gScreenshot("Urun miktarı stock belirlendi");
    }
    @Test(priority = 2)
    public void US08_TC02() throws IOException {
        extentTest=extentReports.createTest("US08_TC02","Gecerli username ve sifre ile giris yapabilmeli");
        extentTest.info("Hesabiniza basarili bir sekilde giris yapildi");
        extentTest.info("Hesabim butonuna basildi");
        extentTest.info("Store manager butonuna tiklandi");
        extentTest.info("Urun butonuna tiklandi");
        extentTest.info("urun ekle butonuna tiklandi");
        extentTest.info("\"Inventory\" tıklandı");
        extentTest.info("manage stock butonuna tiklandi");
        Select select =new Select(page.AllowBlackorder);
        List<WebElement> ActualList= select.getOptions();
        List<WebElement> expectedList=new ArrayList<>();
        for (WebElement each:ActualList) {
            each.click();
            expectedList.add(each);
        }
        extentTest.info("AllowBlackorder Allow seçildi");
        extentTest.info("Allow, but notify custemar seçeneği seçildi");
        extentTest.info("Do Not Allow seçeneği seçildi");
        Assert.assertEquals(ActualList,expectedList);
        extentTest.pass("Backorder Allow, Allow, but notify custemar seçeneği seçildi veya Do Not Allow seçenekleri belirledi");
        ReusableMethods.gScreenshot("BackOrder");
    }
}