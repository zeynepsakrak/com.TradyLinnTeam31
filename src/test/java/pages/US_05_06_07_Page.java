package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US_05_06_07_Page {
    public US_05_06_07_Page () {PageFactory.initElements(Driver.getDriver(), this);}
    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement girisButonu;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement pasword;

    @FindBy(xpath = "//button[@name=\"login\"]")
    public WebElement girisYapButonu;

    @FindBy(xpath = "//*[@id=\"menu-item-1074\"]/a")
    public WebElement hesabimButonu;

    @FindBy(xpath = "//a[@href='https://tradylinn.com/store-manager/']")
    public WebElement storeManagerButonu;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement urunButonu;

    @FindBy(xpath = "//th[@aria-label='Status']")
    public WebElement Status;

    @FindBy(xpath = "//th[@aria-label='Stock']")
    public WebElement Stock;

    @FindBy(xpath = "//*[@id=\"wcfm-products\"]/thead/tr/th[7]")
    public WebElement Price;

    @FindBy(xpath = "//th[@aria-label='Date: activate to sort column ascending']")
    public WebElement Date;

    @FindBy(xpath = "(//span[@class='text'])[19]")
    public WebElement yeniEkleButonu;

    @FindBy(xpath = "//input[@name='is_virtual']")
    public WebElement virtualClick;

    @FindBy(xpath = "//input[@name='is_downloadable']")
    public WebElement downloadableClick;

    @FindBy (xpath = "//input[@id='pro_title']")
    public WebElement productTitle;

    @FindBy (xpath = "//input[@id='regular_price']")
    public WebElement regularPrice;

    @FindBy (xpath = "//input[@id='sale_price']")
    public WebElement salePrice;

}
