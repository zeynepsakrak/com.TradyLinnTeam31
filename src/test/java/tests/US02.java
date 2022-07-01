package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_01_02_Page;
import utilities.Driver;
import utilities.TestBaseRapor;

import static tests.Login.login;

public class US02 extends TestBaseRapor {

    US_01_02_Page firstPage;
    SoftAssert softAssert;

    @Test
    public void US02_TC01() throws InterruptedException {
        extentTest=extentReports.createTest("UC02_TC01", "Vendor olarak email ve şifre girilmeli ve sistemde My Accout görünmeli");
        firstPage=new US_01_02_Page();
        softAssert=new SoftAssert();
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        Thread.sleep(8000);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        //5_Başarılı bir şekilde login olduğunu test eder.
        Assert.assertTrue(firstPage.cikisButonu.isDisplayed());
        extentTest.pass("Başarılı bir şekilde login olduğunu görüldü");
        Driver.closeDriver();
    }

    @Test
    public void US02_TC02() throws InterruptedException {
        extentTest=extentReports.createTest("UC02_TC02", "Orders, Downloads, addresses, account details, whislist ve Logout gorulmeli");
        firstPage=new US_01_02_Page();
        softAssert=new SoftAssert();
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        Thread.sleep(8000);
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        firstPage.hesabim.click();
        //5_Orders butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.ordersButonu.isDisplayed(),
                "Orders butonu görülmedi.");
        extentTest.info("Orders butonu görüldü.");
        //6_Downloads butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.downloadsButonu.isDisplayed(),
                "Downloads butonu görülmedi.");
        extentTest.info("Downloads butonu görüldü.");
        //7_Addresses butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.addressesButonu.isDisplayed(),
                "Addresses butonu görülmedi.");
        extentTest.info("Addresses butonu görüldü.");
        //8_Account details butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.accountDetailsButonu.isDisplayed(),
                "Account butonu görülmedi.");
        extentTest.info("Account butonu görüldü.");
        //9_Whislist butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.whislistButonu.isDisplayed(),
                "Whislist butonu görülmedi.");
        extentTest.info("Whislist butonu görüldü.");
        //10_Logout butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.logoutButonu.isDisplayed(),
                "Logout butonu görülmedi.");
        extentTest.pass("Logout butonu görüldü.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test
    public void US02_TC03() throws InterruptedException {
        extentTest=extentReports.createTest("UC02_TC03", "Dashboard altında ise; Store manager, orders, downloads, addresses , account details, appointments, wishlist");
        firstPage=new US_01_02_Page();
        softAssert=new SoftAssert();
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        Thread.sleep(8000);
        //5_Store manager butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.storeManagerDashboard.isDisplayed(),
                "Dashboard altinda Store manager butonu görülmedi.");
        extentTest.info("Store manager butonu görüldü.");
        //6_Orders butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.ordersButonuDashboard.isDisplayed(),
                "Dashboard altinda Orders butonu görülmedi.");
        extentTest.info("Dashboard altinda Orders butonu görüldü.");
        //7_Downloads butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.downloadsButonuDashboard.isDisplayed(),
                "Dashboard altinda Downloads butonu görülmedi.");
        extentTest.info("Dashboard altinda Downloads butonu görüldü.");
        //8_Addresses butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.addressesButonuDashboard.isDisplayed(),
                "Dashboard altinda Addresses butonu görülmedi.");
        extentTest.info("Dashboard altinda Addresses butonu görüldü.");
        //9_Account details butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.accountDetailsButonuDashboard.isDisplayed(),
                "Dashboard altinda Account details butonu görülmedi.");
        extentTest.info("Dashboard altinda Account details butonu görüldü.");
        //10_Appointments butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.appoinmentsButonuDashboard.isDisplayed(),
                "Dashboard altinda Appointments butonu görülmedi.");
        extentTest.info("Dashboard altinda Appointments butonu görüldü.");
        //11_Wishlist butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.whislistButonuDashboard.isDisplayed(),
                "Dashboard altinda Wishlist butonu görülmedi.");
        extentTest.pass("Dashboard altinda Wishlist butonu görüldü.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

    @Test
    public void US02_TC04() throws InterruptedException {
        extentTest=extentReports.createTest("UC02_TC04", "Support tickets, followings ve log out olmali");
        firstPage=new US_01_02_Page();
        softAssert=new SoftAssert();
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign in butonuna tıklar.
        //3_Kullanıcı Email adresini girer.
        //4_Kullanıcı Password girer.
        login();
        extentTest.info("Tradylinn anasayfasina gidildi");
        extentTest.info("Giris Yap/Uye Ol butonuna tiklandi");
        extentTest.info("Email ve Password girildi");
        extentTest.info("Giris Yap butonuna tiklandi");
        Thread.sleep(8000);
        firstPage.hesabim.click();
        //5_Support tickets butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.supportTicketsButonuDashboard.isDisplayed(),
                "Dashboard altinda Support tickets butonu görülmedi.");
        extentTest.info("Dashboard altinda Support tickets butonu görüldü.");
        //6_Followings butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.followingsButonuDashboard.isDisplayed(),
                "Dashboard altinda Followings butonu görülmedi.");
        extentTest.info("Dashboard altinda Followings butonu görüldü.");
        //7_Logout butonunun görüldüğünü test eder.
        softAssert.assertTrue(firstPage.logoutButonuDashboard.isDisplayed(),
                "Dashboard altinda Logout butonu görülmedi.");
        extentTest.pass("Dashboard altinda Logout butonu görüldü.");
        softAssert.assertAll();
        Driver.closeDriver();
    }

}