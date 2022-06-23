package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_13_14_Page;
import utilities.ConfigReader;
import utilities.Driver;

import static tests.Login.login;

public class US13 {
    US_13_14_Page us_13_14_page;
    @Test
    public void tC01() throws InterruptedException {
     login();
        us_13_14_page=new US_13_14_Page();
        //US13_TC01_Coupon kodu verilmeli
        //giriş yapar
        //4. Kullanıcı "Hesabım" butonunu tıklar
        Thread.sleep(5000);
        us_13_14_page.hesabimButonu.click();
        //5. Kullanıcı "Store Manager" butonunu tıklar
        us_13_14_page.storeManagerButonu.click();
        //6. Kullanıcı "Kuponlar" butonunu tıklar
        us_13_14_page.kuponlarButonu.click();
        //7. Kullanıcı "Yeni ekle" butonunu tıklar
        us_13_14_page.kuponlarYeniButonu.click();
        //8. Kullanıcı "Code" alanına veri girer
        us_13_14_page.codeText.sendKeys(ConfigReader.getProperty("tradyCouponCode"), Keys.TAB);
        //9. Kullanıcı "Code" alanına veri girildiğine test eder
        String expectedCode=ConfigReader.getProperty("tradyCouponCode");
        String actualcode=us_13_14_page.codeText.getText();
        System.out.println("Beklenen:"+expectedCode + "Gerçekleşen:"+actualcode);
        Assert.assertEquals(actualcode,expectedCode);

    }
}
