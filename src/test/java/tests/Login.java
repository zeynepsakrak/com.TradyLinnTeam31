package tests;

import org.testng.annotations.Test;
import pages.Homepage;
import utilities.ConfigReader;
import utilities.Driver;

public class Login {
     public static void login() {
          Homepage homepage=new Homepage();
          Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
          homepage.girisButonu.click();
          homepage.userName.sendKeys(ConfigReader.getProperty("validVendorEmail"));
          homepage.pasword.sendKeys(ConfigReader.getProperty("validVendorPassword"));
          try {
               Thread.sleep(1000);
          } catch (InterruptedException e) {
               e.printStackTrace();
          }
          homepage.girisYapButonu.click();
     }
}
