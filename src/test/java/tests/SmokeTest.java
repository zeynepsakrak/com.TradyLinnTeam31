package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Homepage;
import pages.US_01_02_Page;
import pages.US_03_04_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.Login.login;
import static tests.ReusableMethods.waitFor;

public class SmokeTest extends TestBaseRapor {
    US_01_02_Page firstPage=new US_01_02_Page();
    US_03_04_Page thirdPage;
    SoftAssert softAssert=new SoftAssert();
    JavascriptExecutor jse;
    Actions actions;

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
        homepage.girisYapButonu.click();
        waitFor(3);
    }
    @Test
    public void US01_TC01() throws InterruptedException {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        Thread.sleep(8000);
        //5_Başarılı bir şekilde login olduğunu test eder.
        Assert.assertTrue(firstPage.cikisButonu.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void US01_TC02() throws InterruptedException {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        Thread.sleep(8000);
        firstPage.hesabim.click();
        //5_Orders butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.ordersButonu.isDisplayed(),
                "Orders butonu görülmedi.");
        //6_Downloads butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.downloadsButonu.isDisplayed(),
                "Downloads butonu görülmedi.");
        //7_Addresses butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.addressesButonu.isDisplayed(),
                "Addresses butonu görülmedi.");
        //8_Account details butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.accountDetailsButonu.isDisplayed(),
                "Account butonu görülmedi.");
        //9_Whislist butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.whislistButonu.isDisplayed(),
                "Whislist butonu görülmedi.");
        //10_Logout butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.logoutButonu.isDisplayed(),
                "Logout butonu görülmedi.");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test
    public void US01_TC03() throws InterruptedException {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        Thread.sleep(8000);
        //5_Store manager butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.storeManagerDashboard.isDisplayed(),
                "Dashboard altinda Store manager butonu görülmedi.");
        //6_Orders butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.ordersButonuDashboard.isDisplayed(),
                "Dashboard altinda Orders butonu görülmedi.");
        //7_Downloads butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.downloadsButonuDashboard.isDisplayed(),
                "Dashboard altinda Downloads butonu görülmedi.");
        //8_Addresses butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.addressesButonuDashboard.isDisplayed(),
                "Dashboard altinda Addresses butonu görülmedi.");
        //9_Account details butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.accountDetailsButonuDashboard.isDisplayed(),
                "Dashboard altinda Account details butonu görülmedi.");
        //10_Appointments butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.appoinmentsButonuDashboard.isDisplayed(),
                "Dashboard altinda Appointments butonu görülmedi.");
        //11_Wishlist butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.whislistButonuDashboard.isDisplayed(),
                "Dashboard altinda Wishlist butonu görülmedi.");
        softAssert.assertAll();
        Driver.closeDriver();
    }
    @Test
    public void US01_TC04() throws InterruptedException {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        Thread.sleep(8000);
        firstPage.hesabim.click();
        //5_Support tickets butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.supportTicketsButonuDashboard.isDisplayed(),
                "Dashboard altinda Support tickets butonu görülmedi.");
        //6_Followings butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.followingsButonuDashboard.isDisplayed(),
                "Dashboard altinda Followings butonu görülmedi.");
        //7_Logout butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.logoutButonuDashboard.isDisplayed(),
                "Dashboard altinda Logout butonu görülmedi.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

}
