package tests;

import org.apache.poi.ss.formula.functions.Value;
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
    public void TC01() throws InterruptedException {
        us_13_14_page=new US_13_14_Page();
        //US13_TC01_Coupon kodu verilmeli
        //1., 2., 3. Stepler
        login();
        Thread.sleep(5000);

        //4. Kullanıcı "Hesabım" butonunu tıklar
        us_13_14_page.hesabimButonu.click();

        //5. Kullanıcı "Store Manager" butonunu tıklar
        us_13_14_page.storeManagerButonu.click();

        //6. Kullanıcı "Kuponlar" butonunu tıklar
        us_13_14_page.kuponlarButonu.click();

        //7. Kullanıcı "Yeni ekle" butonunu tıklar
        us_13_14_page.kuponlarYeniButonu.click();

        //8. Kullanıcı "Code" alanına veri girer
        us_13_14_page.codeText.sendKeys(ConfigReader.getProperty("tradyCouponCode"), Keys.TAB);

        //9. Kullanıcı "Submit" butonuna tiklar
        us_13_14_page.draftButonu.click();

        //10. Kullanıcı "Code" alanına veri girildiğine test eder
        String expectedCode=ConfigReader.getProperty("tradyCouponCode");
        String actualcode=us_13_14_page.codeText.getAttribute("value");
        System.out.println("Beklenen:"+expectedCode + "Gerçekleşen:"+actualcode);
        Assert.assertEquals(actualcode,expectedCode);

    }
}
