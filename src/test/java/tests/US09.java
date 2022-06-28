package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_08_09_10_Page;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static tests.ReusableMethods.*;

public class US09 {
    US_08_09_10_Page page=new US_08_09_10_Page();
    Actions actions=new Actions(Driver.getDriver());
    @Test(priority = 1)
    public void testName(){
        urun_ekle_menusune_gidilir();
        bekle();
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle();
        page.Shipping.click();
        bekle();
    }

    @Test(priority = 2)
    public void US09_TC01() {
        waitFor(10);
        page.Weight.click();
        page.Weight.clear();
        page.Weight.sendKeys("10");

        waitFor(8);
        page.Length.click();
        page.Length.clear();
        page.Length.sendKeys("20");
        //Assert.assertTrue(page.Length.getText().contains("20"));
        waitFor(10);
        page.height.click();
        page.height.clear();
        page.height.sendKeys("30");
        //Assert.assertTrue(page.height.getText().contains("30"));
        page.width.click();
        page.width.clear();
        page.width.sendKeys("30");
        //Assert.assertTrue(page.width.getText().contains("30"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);
        Assert.assertTrue(page.Length.getText().contains("20"));
        waitFor(3);

    }

    @Test(priority = 3)
    public void US09_TC02() {
        Select select =new Select(page.processingTime);
        List<WebElement> processingTime= select.getOptions();
        List<WebElement> expectedList=new ArrayList<>();
        for (WebElement each:processingTime) {
            each.click();
            System.out.println(each.getText());
            expectedList.add(each);
        }
        Assert.assertEquals(processingTime,expectedList);

    }
}
