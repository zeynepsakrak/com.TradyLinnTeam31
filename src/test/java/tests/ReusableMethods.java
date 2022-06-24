package tests;

import org.openqa.selenium.JavascriptExecutor;
import pages.Homepage;
import utilities.ConfigReader;
import utilities.Driver;

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
}
