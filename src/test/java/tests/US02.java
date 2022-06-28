package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_01_02_Page;

import static tests.Login.login;

public class US02 {
    US_01_02_Page firstPage=new US_01_02_Page();


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
        ReusableMethods.sayfayiKapat();
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
        Assert.assertTrue(firstPage.ordersButonu.isDisplayed());
        //6_Downloads butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.downloadsButonu.isDisplayed());
        //7_Addresses butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.addressesButonu.isDisplayed());
        //8_Account details butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.accountDetailsButonu.isDisplayed());
        //9_Whislist butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.whislistButonu.isDisplayed());
        //10_Logout butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.logoutButonu.isDisplayed());
        //ReusableMethods.sayfayiKapat();
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
        Assert.assertTrue(firstPage.storeManagerDashboard.isDisplayed());
        //6_Orders butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.ordersButonuDashboard.isDisplayed());
        //7_Downloads butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.downloadsButonuDashboard.isDisplayed());
        //8_Addresses butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.addressesButonuDashboard.isDisplayed());
        //9_Account details butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.accountDetailsButonuDashboard.isDisplayed());
        //10_Appointments butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.appoinmentsButonuDashboard.isDisplayed());
        //11_Wishlist butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.whislistButonuDashboard.isDisplayed());
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
        Assert.assertTrue(firstPage.supportTicketsButonuDashboard.isDisplayed());
        //6_Followings butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.followingsButonuDashboard.isDisplayed());
        //7_Appointments butonunun görüldüğünü test eder.
        Assert.assertTrue(firstPage.appoinmentsButonuDashboard.isDisplayed());
    }
}
