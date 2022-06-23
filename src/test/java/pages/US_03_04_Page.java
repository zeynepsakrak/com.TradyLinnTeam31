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

    @FindBy(xpath = "//a[text()='Sepeti görüntüle']")
    public WebElement sepetiGoruntule;

    @FindBy(xpath = "//button[text()='Temizle']")
    public WebElement sepetiTemizle;







}
