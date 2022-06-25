package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_20_21_Page {
    public US_20_21_Page() {PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//*[@id=\"menu-item-1074\"]/a")
    public WebElement hesabim;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/nav/ul/li[2]/a")
    public WebElement storeManejer;

    @FindBy(xpath = "//*[@id=\"wcfm_menu\"]/div[17]/a/span[2]")
    public WebElement inceleme;

    @FindBy(xpath = "//*[@id=\"add_new_product_dashboard\"]/span[2]")
    public WebElement productReviews;

    @FindBy(xpath = "//*[@id=\"wcfm-reviews\"]/tbody/tr/td[2]/div")
    public WebElement kullaniciBilgisi;

    @FindBy(xpath = "//*[@id=\"wcfm-reviews\"]/thead/tr/th[2]")
    public WebElement kullaniciBaslık;

    @FindBy(xpath = "//*[@id=\"wcfm-reviews\"]/tbody/tr/td[3]/div")
                     //*[@id="wcfm-reviews"]/tbody/tr/td[3]/div
    public WebElement kullaniciCommenti;

    @FindBy(xpath = "//*[@id=\"wcfm-reviews\"]/tbody/tr/td[4]/div/div/span")
    public WebElement kullaniciRating;

    @FindBy(xpath = "//*[@id=\"wcfm-reviews\"]/tbody/tr/td[6]")

    public WebElement kullaniciCommentiTarihi;

    @FindBy(xpath = "//*[@id=\"wcfm_menu\"]/div[15]/a/span[2]")
                     //*[@id="wcfm_menu"]/div[17]/a/span[2]
    public WebElement raporlar;

    @FindBy(xpath = "//*[@id=\"poststuff\"]/div/div[1]/ul/li[1]/a")
    public WebElement yearRapor;

    @FindBy(xpath = "//*[@id=\"poststuff\"]/div/div[1]/ul/li[2]/a")
    public WebElement lastMonthRapor;

    @FindBy(xpath = "//*[@id=\"poststuff\"]/div/div[1]/ul/li[3]/a")
    public WebElement thisMonthRapor;

    @FindBy(xpath = "//*[@id=\"poststuff\"]/div/div[1]/ul/li[4]/a")
    public WebElement last7DayRapor;

    @FindBy(xpath = "//*[@id=\"poststuff\"]/div/div[1]/ul/li[5]/form/div/input[1]")
    public WebElement costumRapor;







    }

