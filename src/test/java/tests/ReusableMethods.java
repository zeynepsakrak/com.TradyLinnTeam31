package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Homepage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

import java.time.Duration;

import static tests.Login.login;

public class ReusableMethods {
    static  JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
static Actions actions=new Actions(Driver.getDriver());
    public static void sepetiBosalt() {
        Homepage homepage=new Homepage();
        if (!homepage.sepetimIkonu.getText().contains("0")) {
            homepage.sepetimIkonu.click();
            homepage.sepetiGoruntule.click();
           bekle();
            homepage.sepetiTemizle.click();
            homepage.tradylinnIkonu.click();
        }
    }
    public static void bekle(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void urun_ekle_menusune_gidilir() {

        Homepage homepage=new Homepage();
        login();
        jse.executeScript("arguments[0].scrollIntoView();",homepage.hesabim);
    bekle();
        homepage.hesabim.click();
        bekle();
        homepage.StoreManager.click();
       // jse.executeScript("arguments[0].scrollIntoView();",homepage.urun);
        waitForVisibility(homepage.Home,5);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        homepage.urun.click();
     bekle();
     homepage.yeniUrunEkle.click();

    }

}
