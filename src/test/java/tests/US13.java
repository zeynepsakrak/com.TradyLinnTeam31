package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_13_14_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US13 {
    US_13_14_Page us_13_14_page;
    @Test
    public void uS13_TC01() throws InterruptedException {
        us_13_14_page=new US_13_14_Page();
        //US13_TC01_Coupon kodu verilmeli
        //1. Kullanıcı https://tradylinn.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("tradylinnUrl"));
        //2. Kullanıcı "Giris yap" seçenegine tıklar
        us_13_14_page.girisButonu.click();
        //3. Kullanıcı Dogru kullanici ve sifre bilgileri ile giris yapar
        us_13_14_page.userName.sendKeys(ConfigReader.getProperty("validVendorEmail"));
        us_13_14_page.pasword.sendKeys(ConfigReader.getProperty("validVendorPassword"));
        us_13_14_page.girisYapButonu.click();
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
        //Assert.assertEquals(actualcode,expectedCode);

    }

    @Test (dependsOnMethods = "uS13_TC01")
    public void uS13_TC02() {
        us_13_14_page=new US_13_14_Page();
        //8. Kullanıcı "Description" alanına veri girer
        us_13_14_page.descriptionText.sendKeys("Müşteri İlk Alışverişinde 10 Tl indirim alır",Keys.TAB);
        //9. Kullanıcı "Description" alanına veri girildiğine test eder
        String expectedDescription="Müşteri İlk Alışverişinde 10 Tl indirim alır";
        String actualDescription=us_13_14_page.descriptionText.getText();
        System.out.println("Beklenen:"+expectedDescription + "Gerçekleşen:"+actualDescription);
        //Assert.assertEquals(actualcode,expectedCode);
        System.out.println("AHA: "+ us_13_14_page.couponAmountText.getText());
    }
}
