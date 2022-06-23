package tests;

import org.testng.annotations.Test;
import pages.US_11_12_Page;

public class US12 {
    US_11_12_Page uS_11_12_Page=new US_11_12_Page();

    @Test
    public void siparisler(){
        //1-Kullanici vendor olarak hesabina gider
        //2-Kullanici siparisler butonuna tiklar
        //3-Kullanici siparislerin listelendigini kontrol eder

    }
    @Test
    public void indirmeler(){
      //  1-Kullanici vendor olarak hesabina gider
      //  2-Kullanici Indirmeler butonuna tiklar
      //  3-Kullanici indirilecek urunlerin listesinin goruntulendigini kontrol eder
    }
    @Test

    public void adresler(){
       // 1-Kullanici vendor olarak hesabina gider
       // 2-Kullanici Adresler butonuna tiklar
       // 3-Kullanici Fatura adresi ve gonderim adresinin goruntulendigini kontrol eder
    }

    public void hesapDetaylari(){
       // 1-Kullanici vendor olarak hesabina gider
       // 2-Kullanici Hesap Detaylari butonuna tiklar
       // 3-Kullanici hesap bilgisi ve eposta adresinin goruntulendigini kontrol eder
       // 4-Kullanici hesap bilgisi ve eposta bilgilerinde degisiklik yapar
       // 5-Kullanici degisiklikleri kaydet butonuna tiklar
       // 6-Kullanici Hesap bilgileri başarıyla değiştirildi yazisinin goruntulendigini kontrol eder
    }

}
