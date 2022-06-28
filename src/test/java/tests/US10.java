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

import java.util.ArrayList;
import java.util.List;

import static tests.ReusableMethods.*;

public class US10 extends TestBaseRapor {
    US_08_09_10_Page page=new US_08_09_10_Page();
    Actions actions=new Actions(Driver.getDriver());
    @Test(priority = 1)
    public void testName(){
        urun_ekle_menusune_gidilir();
        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle();
        page.Attributes.click();
        bekle();

    }

    @Test(priority = 2)
    public void US10_TC01() {
        extentTest=extentReports.createTest("US10_TC01","Renk secenegi; beyaz, siyah, yeşil vs tum renkler belirtilmeli");
        waitFor(5);
        page.colorOk.click();
        waitFor(3);
        Select select2 =new Select(page.colorSelectAll);
        List<WebElement> colors= select2.getOptions();
        List<WebElement> expectedList=new ArrayList<>();
        for (WebElement each:colors) {
            each.click();
            expectedList.add(each);
        }
        Assert.assertEquals(colors,expectedList);
        extentTest.info("Renk secenegi; beyaz, siyah, yeşil vs tum renkler belirtildi");
    }

    @Test(priority = 3)
    public void US10_TC02() {
        extentTest=extentReports.createTest("US10_TC02","Renk secenegi; beyaz, siyah, yeşil vs tum renkler belirtilmeli");
        waitFor(3);
        page.sizeOk.click();
        Select select3 =new Select(page.sizeSelectAll);
        List<WebElement> size= select3.getOptions();
        List<WebElement> expectedList2=new ArrayList<>();
        for (WebElement each:size) {
            each.click();
            expectedList2.add(each);
        }
        Assert.assertEquals(size,expectedList2);
        extentTest.info("Size secenegi; small, medium, large, extra large olarak belirlendi");
    }
}
