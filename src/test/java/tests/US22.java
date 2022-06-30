package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_19_22_Page;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;

import static tests.Login.login;
import static tests.ReusableMethods.bekle;
import static tests.ReusableMethods.waitFor;

public class US22 {
    US_19_22_Page myPage= new US_19_22_Page();

    @Test
    public void US22_TC01() throws InterruptedException {
        login();
        waitFor(15);

        Assert.assertTrue(myPage.indirimliTumunuGor.isDisplayed());

        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);

        myPage.indirimliIlkUrun.click();

        String actualUrl="https://tradylinn.com/urun/amigurumi-bebek/";
        String expectedUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.equals(expectedUrl));

        Driver.getDriver().close();
    }

    @Test
    public void US22_TC02() {
        login();
        waitFor(15);

        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);

        myPage.sirala.click();

        Select select= new Select(myPage.sirala);
        String expected = "Varsayılan Sıralama";
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,expected);

        Assert.assertTrue(myPage.siralama1.isDisplayed());
        Assert.assertTrue(myPage.siralama2.isDisplayed());
        Assert.assertTrue(myPage.siralama3.isDisplayed());
        Assert.assertTrue(myPage.siralama4.isDisplayed());
        Assert.assertTrue(myPage.siralama5.isDisplayed());
        Assert.assertTrue(myPage.siralama6.isDisplayed());

        Driver.getDriver().close();
    }

    @Test
    public void US22_TC03() {
        login();
        waitFor(15);

        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);

        Select select= new Select(myPage.sirala);
        select.selectByIndex(4);
        bekle();

        ArrayList<Double> urunlerDouble = new ArrayList<>();
        for (WebElement each: myPage.indirimliUrunler){
            String fiyatStr = each.getText().replaceAll("₺", "");;
            urunlerDouble.add(Double.parseDouble(fiyatStr));
        }

        ArrayList<Double> kontrolListe = new ArrayList<>(urunlerDouble);
        Collections.sort(kontrolListe);
        Assert.assertEquals(kontrolListe,urunlerDouble);

        Driver.getDriver().close();
    }

    @Test
    public void US22_TC04() {
        login();
        waitFor(15);

        myPage.indirimliTumunuGor.sendKeys(Keys.ENTER);

        myPage.sirala.click();

        Select select= new Select(myPage.sirala);

        select.selectByIndex(5);
        bekle();

        ArrayList<Double> urunlerDouble = new ArrayList<>();
        for (WebElement each: myPage.indirimliUrunler){
            String fiyatStr = each.getText().replaceAll("₺", "");;
            urunlerDouble.add(Double.parseDouble(fiyatStr));
        }

        ArrayList<Double> kontrolListe = new ArrayList<>(urunlerDouble);
        Collections.sort(kontrolListe);
        Assert.assertEquals(kontrolListe,urunlerDouble);

        Driver.getDriver().close();
    }
}
