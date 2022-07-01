package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_17_18_Page;
import utilities.Driver;
import utilities.TestBaseRapor;


import static tests.Login.login;
import static tests.ReusableMethods.waitForPageToLoad;

public class US18 extends TestBaseRapor {
    US_17_18_Page us_17_18_page;

    @Test
    public void US18_TC01() throws InterruptedException {
        extentTest = extentReports.createTest("Geri iade plani olmali", "Geri iade edilecek urune ait bilgileri gorebilmelidir");
        us_17_18_page = new US_17_18_Page();
        Actions actions=new Actions(Driver.getDriver());


        // 1-Kullanici https://tradylinn.com/ adresine gider
        // 2-Giris Yap/Uye Ol butonuna tiklar
        // 3-Dogru kullanici adi ve sifre bilgileri ile giris yapar

        login();
        Thread.sleep(7000);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password bilgileri ile giris yapildi");

        // 4-Hesabim butonuna tiklar
        us_17_18_page.hesabim.click();
        extentTest.info("Hesabim butonuna tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0,200)");
        // 5-Store Manager butonuna tiklar
        us_17_18_page.storeManager.click();
        extentTest.info("Store Manager butonuna tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);

        // 6-Geri odeme butonuna tiklar
        us_17_18_page.refundButonu.click();
        extentTest.info("Geri odeme butonuna tiklandi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(10000);
        waitForPageToLoad(120);

        // 7-Geri iade edilecek urune ait Request ID, Order ID, Amount, Type ve Reason bilgilerini gorur
        String expected1="# 44";
        WebElement RequestID = Driver.getDriver().findElement(By.xpath("//span[@class='wcfm_dashboard_item_title']"));
        String actual1 = RequestID.getText();
        Assert.assertEquals(actual1, expected1);

        String expected2="#11782";
        WebElement OrderID = Driver.getDriver().findElement(By.xpath("//a[@href='https://tradylinn.com/store-manager/orders-details/11782']"));
        String actual2 = OrderID.getText();
        Assert.assertEquals(actual2, expected2);

        Thread.sleep(2000);
        String expected3="500.00₺";
        WebElement Amount = Driver.getDriver().findElement(By.xpath("//span[@class='woocommerce-Price-amount amount']"));
        //String actual3= String.valueOf(Amount.toString().contains("500.00"));
        String actual3 = Amount.getText();
        Assert.assertEquals(actual3, expected3);

        String expected4="Full Refund";
        WebElement Type = Driver.getDriver().findElement(By.xpath("//*[text()='Full Refund']"));
        String actual4 = Type.getText();
        Assert.assertEquals(actual4, expected4);

        String expected5="Hatalı ürün";
        WebElement Reason = Driver.getDriver().findElement(By.xpath("//*[text()='Hatalı ürün']"));
        String actual5 = Reason.getText();
        Assert.assertEquals(actual5, expected5);

        extentTest.pass("Geri iade edilecek urune ait bilgileri goruldu");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);


        // 8-Kullanici sayfayi kapatir
        Driver.closeDriver();
    }
}
