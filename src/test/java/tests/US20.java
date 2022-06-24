package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.US_20_21_Page;
import utilities.Driver;

public class US20 {

    @Test
    public  void test01() {
        US_20_21_Page us_20_21_Page = new US_20_21_Page();

        //1-kullanıcı  https://tradylinn.com/  adresine gider
        Driver.getDriver().get("https://www.tradylinn.com");
        //2- Satıcı olarak giriş yapılır
        //3-hesabim a tiklanir
        us_20_21_Page.hesabim.click();
        //4-story manager'e tiklanir
        //5-incelemelere tiklanir
        //6-product reviews tiklanir
        //7-kullanıcı bilgisi gorunur oldugunu test eder
      //  Driver.closeDriver();

    }


    @Test
    public void test02() {
        //1-kullanıcı  https://tradylinn.com/  adresine gider
        //2- Satıcı olarak giriş yapılır
        //3-hesabim a tiklanir
        //4-story manager'e tiklanir
        //5-incelemelere tiklanir
        //6-product reviews tiklanir
        //7-kullanıcı commentinin gorunur oldugunu test eder
        //8-kullanıcı comment tarihinin gorunur oldugunu test eder



    }

}