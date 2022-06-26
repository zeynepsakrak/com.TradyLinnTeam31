package tests;

import org.openqa.selenium.JavascriptExecutor;
import pages.Homepage;
import utilities.ConfigReader;
import utilities.Driver;

import static tests.Login.login;

public class ReusableMethods {
    static JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    public static void sepetiBosalt() {
        Homepage homepage = new Homepage();
        if (!homepage.sepetimIkonu.getText().contains("0")) {
            homepage.sepetimIkonu.click();
            homepage.sepetiGoruntule.click();
            jse.executeScript("arguments[0].scrollIntoView();", homepage.sepetiTemizle);
            waitFor(1);
            homepage.sepetiTemizle.click();
            homepage.tradylinnIkonu.click();
        }
    }
    //   HARD WAIT WITH THREAD.SLEEP
    //   waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
