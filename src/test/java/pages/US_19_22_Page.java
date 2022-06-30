package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US_19_22_Page {
    public US_19_22_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@href='https://tradylinn.com/product-category/indirimli-urunler/'])[4]")
    public WebElement indirimliTumunuGor;

    @FindBy(xpath = "//a[@href=\"https://tradylinn.com/store-manager/followers/\"]")
    public WebElement takipci;

    @FindBy(xpath = "//th[@aria-label='Name']  ")
    public WebElement takipciIsim;

    @FindBy(xpath = "//th[@aria-label='E-posta']")
    public WebElement takipciEposta;

    @FindBy(xpath = "//th[@aria-label='İşlem']")
    public WebElement takipciIslem;

    @FindBy(xpath = ("//li[@class='product-wrap'][1]"))
    public WebElement indirimliIlkUrun;

    @FindBy(xpath = ("//select[@class='orderby form-control']"))
    public WebElement sirala;

    @FindBy(xpath = "//option[@value='menu_order']")
    public WebElement siralama1;

    @FindBy(xpath = "//option[@value='popularity']")
    public WebElement siralama2;

    @FindBy(xpath = "//option[@value='rating']")
    public WebElement siralama3;

    @FindBy(xpath = "//option[@value='date']")
    public WebElement siralama4;

    @FindBy(xpath = "//option[@value='price']")
    public WebElement siralama5;

    @FindBy(xpath = "//option[@value='price-desc']")
    public WebElement siralama6;

    @FindBy(xpath = "//ins//span[@class='woocommerce-Price-amount amount']")
    public List<WebElement> indirimliUrunler;

}
