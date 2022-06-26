package tests;

import org.openqa.selenium.JavascriptExecutor;
import pages.Homepage;
import utilities.ConfigReader;
import utilities.Driver;

import static tests.Login.login;

public class ReusableMethods {
    static  JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    public static void sepetiBosalt() throws InterruptedException {
        Homepage homepage=new Homepage();
        if (!homepage.sepetimIkonu.getText().contains("0")) {
            homepage.sepetimIkonu.click();
            homepage.sepetiGoruntule.click();
            jse.executeScript("arguments[0].scrollIntoView();", homepage.sepetiTemizle);
            Thread.sleep(1000);
            homepage.sepetiTemizle.click();
            homepage.tradylinnIkonu.click();
        }
    }
    public static void urun_ekle_menusune_gidilir(){
        Homepage homepage=new Homepage();
        login();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homepage.hesabim.click();
    homepage.StoreManager.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homepage.urun.click();
    homepage.yeniUrunEkle.click();
    }

}
