package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Homepage {
    public Homepage() {

            PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement girisButonu;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement pasword;

    @FindBy(xpath = "//button[@name=\"login\"]")
    public WebElement girisYapButonu;

    @FindBy(xpath = "//*[@id=\"menu-item-1074\"]/a")
    public WebElement hesabim;
    @FindBy(xpath ="//a[contains(text(),'Store Manager')]")
    public WebElement StoreManager;


    @FindBy(xpath ="(//span[@class='text'])[4]")
    public WebElement urun;


    @FindBy(xpath ="//span[normalize-space()='Home']")
    public WebElement Home;

    @FindBy(xpath ="//span[contains(text(),'Yeni ekle')]")
    public WebElement yeniUrunEkle;
    @FindBy(xpath = "(//a[@class='cart-toggle'])[1]")
    public WebElement sepetimIkonu;
    @FindBy(xpath = "//button[@name='add-to-cart']")
    public WebElement sepeteEkleButonu;
    @FindBy(xpath = "//a[@class='button wc-forward']")
    public WebElement sepetiGoruntule;

    @FindBy(xpath = "//button[text()='Temizle']")
    public WebElement sepetiTemizle;

    @FindBy(xpath = "(//img[@alt='Tradylinn'])[1]")
    public WebElement tradylinnIkonu;
}
