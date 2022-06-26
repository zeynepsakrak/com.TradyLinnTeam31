package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_17_18_Page;
import utilities.ConfigReader;
import utilities.Driver;

import static tests.Login.login;

public class US17 {
    US_17_18_Page us_17_18_page;

    @Test
    public void US17_TC01() throws InterruptedException {
        us_17_18_page = new US_17_18_Page();

        //US17_TC01_Billing address ile Shipping address ayni oldugu durumda kisi adres bilgisi eklenebilmeli
        // 1-Kullanici https://tradylinn.com/ adresine gider
        // 2-Kullanici Giris yap secenegine tiklar
        // 3-Dogru kullanici adi  ve sifre bilgileri ile giris yapar

        login();
        Thread.sleep(5000);

        // 4-Hesabim butonuna tiklar

        // 5-Store Manager butonuna tiklar
        us_17_18_page.storeManagerButonu.click();

        // 6-Musteriler butonuna tiklar

        // 7-Yeni ekle butonuna tiklar

        // 8-Billing Address bolumunde istenen isim, soy isim, firma ismi, telefon,
        //   adres1, adres2, ulke, sehir, posta kodu kisimlarina bilgi girisi yapar

        //    Add Customer Username box bilgi girisi:
        us_17_18_page.usernameBox.sendKeys(ConfigReader.getProperty("NewCustomerUsername"));
        //    Add Customer Email box bilgi girisi:
        us_17_18_page.emailBox.sendKeys(ConfigReader.getProperty("NewCustomerEmail"));
        //    Add Customer First Name box bilgi girisi:
        us_17_18_page.firstNameBox.sendKeys(ConfigReader.getProperty("NewCustomerFirstName"));
        //    Add Customer Last Name box bilgi girisi:
        us_17_18_page.lastNameBox.sendKeys(ConfigReader.getProperty("NewCustomerLastName"));
        //    Billing First Name box bilgi girisi:
        us_17_18_page.billingFirstNameBox.sendKeys(ConfigReader.getProperty("NewCustomerFirstName"));
        //    Billing Last Name box bilgi girisi:
        us_17_18_page.billingLastNameBox.sendKeys(ConfigReader.getProperty("NewCustomerLastName"));
        //    Billing Company Name box bilgi girisi:
        us_17_18_page.billingCompanyNameBox.sendKeys(ConfigReader.getProperty("NewCustomerCompanyName"));
        //    Billing Phone box bilgi girisi:
        us_17_18_page.billingPhoneBox.sendKeys(ConfigReader.getProperty("NewCustomerPhone"));
        //    Billing Address1 box bilgi girisi:
        us_17_18_page.billingAddress1Box.sendKeys(ConfigReader.getProperty("NewCustomerBillingAddress1"));
        //    Billing Address2 box bilgi girisi:
        us_17_18_page.billingAddress2Box.sendKeys(ConfigReader.getProperty("NewCustomerBillingAddress2"));
        //    Billing Country dropDown bilgi girisi:
        Select select1 = new Select(us_17_18_page.billingCountryDropDown);
        select1.getFirstSelectedOption().click();
        //    Billing City/Town box bilgi girisi:
        us_17_18_page.billingCityBox.sendKeys(ConfigReader.getProperty("NewCustomerCity"));
        //    Billing State/County dropDown bilgi girisi:
        Select select2 = new Select(us_17_18_page.billingStateDropDown);
        select2.selectByIndex(34);
        //    Billing Postcode/Zip box bilgi girisi:
        us_17_18_page.billingZipBox.sendKeys(ConfigReader.getProperty("NewCustomerZip"));

        // 9-Submit butonunu tiklar
        us_17_18_page.submitButonu.click();

        // 10-Acilan pop-up menu (alert)'den Kaydet butonunu tiklar

        // 11-Müsteriler butonuna tiklar

        // 12-Girilen musteri bilgilerini gorur.

    }

        @Test
        public void US17_TC02() throws InterruptedException {
            us_17_18_page = new US_17_18_Page();


            // US17_TC02_Billing address ile Shipping address farkli oldugu durumda kisi adres bilgisi eklenebilmeli
            // 1-Kullanici https://tradylinn.com/ adresine gider
            // 2-Kullanici Giris yap secenegine tiklar
            // 3-Dogru kullanici adi  ve sifre bilgileri ile giris yapar

            login();
            Thread.sleep(5000);

            // 4-Hesabim butonuna tiklar

            // 5-Store Manager butonuna tiklar
            us_17_18_page.storeManagerButonu.click();

            // 6-Musteriler butonuna tiklar

            // 7-Yeni ekle butonuna tiklar

            // 8-Billing Address bolumunde istenen isim, soy isim, firma ismi, telefon,
            //   adres1, adres2, ulke, sehir, semt, posta kodu kisimlarina bilgi girisi yapar

            //    Add Customer Username box bilgi girisi:
            us_17_18_page.usernameBox.sendKeys(ConfigReader.getProperty("NewCustomerUsername"));
            //    Add Customer Email box bilgi girisi:
            us_17_18_page.emailBox.sendKeys(ConfigReader.getProperty("NewCustomerEmail"));
            //    Add Customer First Name box bilgi girisi:
            us_17_18_page.firstNameBox.sendKeys(ConfigReader.getProperty("NewCustomerFirstName"));
            //    Add Customer Last Name box bilgi girisi:
            us_17_18_page.lastNameBox.sendKeys(ConfigReader.getProperty("NewCustomerLastName"));
            //    Billing First Name box bilgi girisi:
            us_17_18_page.billingFirstNameBox.sendKeys(ConfigReader.getProperty("NewCustomerFirstName"));
            //    Billing Last Name box bilgi girisi:
            us_17_18_page.billingLastNameBox.sendKeys(ConfigReader.getProperty("NewCustomerLastName"));
            //    Billing Company Name box bilgi girisi:
            us_17_18_page.billingCompanyNameBox.sendKeys(ConfigReader.getProperty("NewCustomerCompanyName"));
            //    Billing Phone box bilgi girisi:
            us_17_18_page.billingPhoneBox.sendKeys(ConfigReader.getProperty("NewCustomerPhone"));
            //    Billing Address1 box bilgi girisi:
            us_17_18_page.billingAddress1Box.sendKeys(ConfigReader.getProperty("NewCustomerBillingAddress1"));
            //    Billing Address2 box bilgi girisi:
            us_17_18_page.billingAddress2Box.sendKeys(ConfigReader.getProperty("NewCustomerBillingAddress2"));
            //    Billing Country dropDown bilgi girisi:
            Select select1 = new Select(us_17_18_page.billingCountryDropDown);
            select1.getFirstSelectedOption().click();
            //    Billing City/Town box bilgi girisi:
            us_17_18_page.billingCityBox.sendKeys(ConfigReader.getProperty("NewCustomerCity"));
            //    Billing State/County dropDown bilgi girisi:
            Select select2 = new Select(us_17_18_page.billingStateDropDown);
            select2.selectByIndex(34);
            //    Billing Postcode/Zip box bilgi girisi:
            us_17_18_page.billingZipBox.sendKeys(ConfigReader.getProperty("NewCustomerZip"));


            // 9-"Same as Billing" kutucugunu tiklar (Default secili olarak geliyor)
            us_17_18_page.checkBox.click();

            // 10-Shipping icin istenen isim, soy isim, firma ismi,
            // adres1, adres2, ulke, sehir, semt, posta kodu kisimlarina bilgi girisi yapar

            //    Shipping First Name box bilgi girisi:
            us_17_18_page.shippingFirstNameBox.sendKeys(ConfigReader.getProperty("NewCustomerFirstName"));
            //    Shipping Last Name box bilgi girisi:
            us_17_18_page.shippingLastNameBox.sendKeys(ConfigReader.getProperty("NewCustomerLastName"));
            us_17_18_page.shippingCompanyNameBox.sendKeys(ConfigReader.getProperty("NewCustomerCompanyName"));
            us_17_18_page.shippingAddress1Box.sendKeys(ConfigReader.getProperty("NewCustomerShippingAddress1"));
            us_17_18_page.shippingAddress2Box.sendKeys(ConfigReader.getProperty("NewCustomerShippingAddress2"));

            Select select3 = new Select(us_17_18_page.shippingCountryDropDown);
            select3.getFirstSelectedOption().click();

            us_17_18_page.shippingCityBox.sendKeys(ConfigReader.getProperty("NewCustomerShippingCity"));
            us_17_18_page.shippingStateBox.sendKeys(ConfigReader.getProperty("NewCustomerCounty"));
            us_17_18_page.shippingZipBox.sendKeys(ConfigReader.getProperty("NewCustomerZip"));

            // 11-Submit butonunu tiklar
            us_17_18_page.submitButonu.click();

            // 12-Acilan pop-up menu (alert)'den Kaydet butonunu tiklar

            // 13-Müsteriler butonunu tiklar



    }
}