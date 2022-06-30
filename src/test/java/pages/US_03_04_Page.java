package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_03_04_Page {
    public US_03_04_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Giriş Yap']")
    public WebElement homePageGirisYapButonu;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement girisYapUsernameBox;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement girisYapPasswordBox;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement girisYapButonu;

    @FindBy(xpath = "(//a[text()='Hesabım'])[1]")
    public WebElement hesabimButonu;

    @FindBy(xpath = "//a[text()='Siparişler']")
    public WebElement hesabimSiparislerButonu;

    @FindBy(xpath = "//a[text()='Alışverişe Devam Et']")
    public WebElement hesabimAlisveriseDevamEtButonu;

    @FindBy(xpath = "//figure[@class='product-media']")
    public List<WebElement> urunlerElementListesi;

    @FindBy(xpath = "(//img[@alt='Tradylinn'])[1]")
    public WebElement tradylinnIkonu;

    @FindBy(xpath = "(//a[text()='Hemen Başla'])[1]")
    public WebElement hemenBaslaButonu;

    @FindBy(xpath = "//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']")
    public List<WebElement> adToCartElementListesi;

    @FindBy(xpath = "(//a[@class='cart-toggle'])[1]")
    public WebElement sepetimIkonu;

    @FindBy(xpath = "//button[@name='add-to-cart']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    public WebElement sepetiGoruntule;

    @FindBy(xpath = "//button[text()='Temizle']")
    public WebElement sepetiTemizle;

    @FindBy(xpath = "//h3[.='Sepet Toplamı']")
    public WebElement sepetToplamiTextElement;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement odemeSayfasinaGitButonu;

    @FindBy(xpath = "(//span[@role='textbox'])[2]")
    public WebElement korgoBilgileriSehirElementi;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement korgoBilgileriSehirSearchElementi;

    @FindBy(xpath = "//p[@id='calc_shipping_city_field']")
    public WebElement korgoBilgileriIlceElementi;

    @FindBy(xpath = "//p[@id='calc_shipping_postcode_field']")
    public WebElement korgoBilgileriPostaKoduElementi;

    @FindBy(xpath = "//button[.='Fiyatı Güncelle']")
    public WebElement fiyatiGuncelleButonu;

    @FindBy(xpath = "//p[@class='woocommerce-shipping-destination']")
    public WebElement gonderiAdresiTextElement;

    @FindBy(xpath = "//input[@name='billing_first_name']")
    public WebElement faturaDetaylariIsim;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    public WebElement faturaDetaylariSoyisim;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    public WebElement faturaDetaylariSokak;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    public WebElement faturaDetaylariPostaKodu;

    @FindBy(xpath = "//input[@id='billing_city']")
    public WebElement faturaDetaylariIlce;

    @FindBy(xpath = "//input[@id='billing_phone']")
    public WebElement faturaDetaylariTelefon;

    @FindBy(xpath = "//span[@id='select2-billing_state-container']")
    public WebElement faturaDetaylariSehir;

    @FindBy(xpath = "//input[@id='wcfmmp_user_location']")
    public WebElement faturaDetaylariGonderiYeri;

    @FindBy(xpath = "//button[@name='woocommerce_checkout_place_order']")
    public WebElement siparisiOnaylaButonu;

    @FindBy(xpath = "//p[text()='Teşekkür ederiz. Siparişiniz alınmıştır.']")
    public WebElement tesekkurlerYaziElementi;


    @FindBy(xpath = "//input[@aria-label='Ara']")
    public WebElement urunAramaKutusu;

    @FindBy(xpath = "(//button[@class='btn btn-search'])[1]")
    public WebElement aramaMercegi;

    @FindBy(xpath = "//td[@class='product-price']")
    public List<WebElement> secilenUrunlerFiyatListesi;

    @FindBy(xpath = "//input[@title='Miktar']")
    public List<WebElement> secilenUrunlerMiktarListesi;


    @FindBy(xpath = "//td[@class='product-subtotal']")
    public List<WebElement> secilenUrunlerAraToplamListesi;

    @FindBy(xpath = "//button[@title='Eksi']")
    public List<WebElement> eksiButonListesi;

    @FindBy(xpath = "//button[@title='Artı']")
    public List<WebElement> artiButonListesi;

    @FindBy(xpath = "//button[.='Sepeti Yenile']")
    public WebElement sepetiYenileButonu;

    @FindBy(xpath = "//button[.='Kupon kullan']")
    public WebElement kuponKullanButonu;

    @FindBy(xpath = "//a[.='Alışverişe Devam Et']")
    public WebElement sepetimAlisveriseDevamEtButonu;

    @FindBy(xpath = "//*[.='Fatura detayları']")
    public WebElement faturaDetaylariTitle;

    @FindBy(xpath = "//*[.='Siparişiniz']")
    public WebElement siparisinizTitle;

    @FindBy(xpath = "(//th[.='Ara Toplam'])[2]")
    public WebElement odemeSayfasiAraToplam;


}
