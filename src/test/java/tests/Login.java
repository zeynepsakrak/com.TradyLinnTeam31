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
        homepage.girisButonu.click();
        waitFor(3);
        homepage.userName.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        homepage.pasword.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        homepage.girisYapButonu.click();
        waitFor(3);
    }
}
