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

import java.util.ArrayList;
import java.util.List;

import static tests.ReusableMethods.*;

public class US08 {
    US_08_09_10_Page page=new US_08_09_10_Page();
    Actions actions=new Actions(Driver.getDriver());
    @Test(priority = 1)
    public void InventoryGit() {
        urun_ekle_menusune_gidilir();
        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle();
        page.Inventory.click();
        waitFor(3);
    }

    @Test(priority = 2)
    public void US08_TC01() {
        //extentTest=extentReports.createTest("Pozitif Login","Gecerli username ve sifre ile giris yapabilmeli");
        waitFor(2);
        page.ManageStock.click();
        waitFor(5);
        page.StockMiktar.click();
        page.StockMiktar.clear();
        page.StockMiktar.sendKeys("10");
       waitFor(5);
       page.Submit.click();
       waitFor(3);
        System.out.println(page.StockMiktar.getText());
        Assert.assertTrue(page.StockMiktar.getText().contains("10"));
        //extentTest.info("Urun miktarı stock belirlendi");
    }
    @Test(priority = 3)
    public void US08_TC02() {
        Select select =new Select(page.AllowBlackorder);
        List<WebElement> ActualList= select.getOptions();
        List<WebElement> expectedList=new ArrayList<>();
        for (WebElement each:ActualList) {
            each.click();
            System.out.println(each.getText());
            expectedList.add(each);
        }
        Assert.assertEquals(ActualList,expectedList);
    }
}