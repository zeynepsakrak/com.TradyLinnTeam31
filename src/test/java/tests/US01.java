package tests;

import org.testng.annotations.Test;
import pages.US_01_02_Page;

import static tests.Login.login;

public class US01 {
    US_01_02_Page firstPage=new US_01_02_Page();


    @Test
    public void US01_TC01() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign Up butonuna tıklar.
        //3_Kullanıcı Become a vendor butonunun göründüğünü test eder
    }

    @Test
    public void US01_TC02() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign Up butonuna tıklar.
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        //5_Kullanıcı Email kutusunun göründüğünü test eder
        //6_Kullanıcı Password kutusunun göründüğünü test eder
        //7_Kullanıcı Confirm Password kutusunun göründüğünü test eder
    }

    @Test
    public void US01_TC03() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign Up butonuna tıklar.
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        //5_Kullanıcı geçerli bir mail girer
        //6_Kullanıcı Register Butonuna tıklar.
        //7_Kullanıcı Email butonunun yeşil yandığını test eder
    }

    @Test
    public void US01_TC04() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign Up butonuna tıklar.
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        //5_Kullanıcı mail kutusunu boş bırakır.
        //6_Kullanıcı Register Butonuna tıklar.
        //7_Kullanıcı Email: This field is required uyarısının göründüğünü test eder
    }

    @Test
    public void US01_TC05() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign Up butonuna tıklar.
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        //5_Kullanıcı geçerli bir mail girer
        //6_Kullanıcı kucuk harf, büyük harf, rakam ve special karakter kullanarak şifre girer
        //7_Kullanıcı strong yazısını görür
        //8_Kullanıcı tekrar şifre girer
        //9_Kullanıcı register butonuna tıklar
        //10_Kullanıcı This Email already exists.Please login to the site and apply as vendor uyarısının görünmediğini test eder
    }

    @Test
    public void US01_TC06() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign Up butonuna tıklar.
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        //5_Kullanıcı geçerli bir mail girer
        //6_Kullanıcı kucuk harf, büyük harf, rakam ve special karakter kullanarak şifre girer
        //7_Kullanıcı strong yazısının göründüğünü test eder
    }

    @Test
    public void US01_TC07() {
        //1_Kullanıcı https://tradylinn.com adresine gider.
        //2_Kullanıcı Sign Up butonuna tıklar.
        //3_Kullanıcı “Become A Vendor” butonuna tıklar.
        //4_Kullanıcı “https://tradylinn.com/vendor-register/” url’sini görür
        //5_Kullanıcı geçerli bir mail girer
        //6_Kullanıcı kucuk harf, büyük harf, rakam ve special karakter kullanarak şifre girer
        //7_Kullanıcı strong yazısını görür
        //8_Kullanıcı tekrar şifre girer
        //9_Kullanıcı register butonuna tıklar
        //10_Kullanıcı Password and Confirm-password are not the same uyarısının görünmediğini test eder
    }

    @Test
    public void US01_TC08() {
        //
    }






}
