package tests;

import org.testng.annotations.Test;
import pages.Homepage;
import utilities.ConfigReader;
import utilities.Driver;

import static tests.ReusableMethods.waitFor;


public class Login {
    public static void login() {
        Homepage homepage = new Homepage();
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        waitFor(5);
        homepage.girisButonu.click();
        waitFor(5);
        homepage.userName.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        homepage.pasword.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        waitFor(5);
        homepage.girisYapButonu.click();
        waitFor(5);
    }
}
