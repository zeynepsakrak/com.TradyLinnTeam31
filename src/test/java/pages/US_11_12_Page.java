package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_11_12_Page {

    public US_11_12_Page() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "(//a[text()='Hesabım'])[1]")
    public WebElement hesabimButonu;

    @FindBy(xpath = "//a[@href='https://tradylinn.com/store-manager/']")
    public WebElement storeManagerButonu;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement urunlerButonu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> urunlerListesi;

    @FindBy(xpath = "(//a[@class='wcfm_product_title'])[1]")
    public WebElement ilkUrun;

    @FindBy(xpath = "(//a[@class='wcfm_product_title'])[2]")
    public WebElement ikinciUrun;

    @FindBy(xpath = "(//a[@class='wcfm_product_title'])[3]")
    public WebElement ucuncuUrun;

    @FindBy(xpath = "(//div[@class='icon-box text-center'])[2]")
    public WebElement indirmelerButonu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> indirmelerListesi;

    @FindBy(xpath = "(//div[@class='icon-box text-center'])[1]")
    public WebElement siparislerButonu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> siparislerListesi;

    @FindBy(xpath = "(//div[@class='icon-box text-center'])[3]")
    public WebElement adreslerButonu;

    @FindBy(xpath = "//div[@class='woocommerce-Addresses addresses row']")
    public WebElement faturaGonderimAdresi;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> faturaAdres;

    @FindBy(xpath = "//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-account']")
    public WebElement hesapDetaylariButonu;

    @FindBy(xpath = "//input[@id='account_first_name']")
    public WebElement hesapDetaylariAd;

    @FindBy(xpath = "//input[@id='account_last_name']")
    public WebElement hesapDetaylariSoyad;

    @FindBy(xpath = "//input[@id='account_display_name']")
    public WebElement hesapDetaylariGorunenAd;

    @FindBy(xpath = "//input[@id='account_email']")
    public WebElement hesapDetaylariEmail;

    @FindBy(xpath = "//button[@class='woocommerce-Button button btn btn-dark btn-rounded btn-sm']")
    public WebElement degisklikleriKaydetButonu;

    @FindBy(xpath = "//div[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement hesapBigileriDegistirildiYazisi;

    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[13]")
    public WebElement toptanUrunGostermeAyarlariButonu;

    @FindBy(xpath = "//div[@class='wcfm-container wcfm_acf_products_manage_3116_container simple variable external grouped booking']")
    public WebElement toptanUrunGostermeMenusu;

    @FindBy(xpath = "//select[@id='piecetype']")
    public WebElement urunCesidi;

    @FindBy(xpath = "(//input[@class='wcfm_submit_button'])[1]")
    public WebElement submitButonu;

    @FindBy(xpath = "//div[@class='wcfm-message']")
    public WebElement productSuccessfullyPublished;

    @FindBy(xpath = "//input[@id='unitpercart']")
    public WebElement unitsPerPiece;

    @FindBy(xpath = "//input[@id='minorderqtytr']")
    public WebElement minumumQuantity;

    @FindBy(xpath ="//span[contains(text(),'Yeni ekle')]")
    public WebElement yeniUrunEkle;


}
